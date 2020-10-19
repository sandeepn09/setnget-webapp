package com.setnget.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailClient {

	private JavaMailSender mailSender;
	private MailContentBuilder mailContentBuilder;

	private static final String SUPPORT_SUBJECT = "Customer Inquiry - %s";
	private static final String HELLO_FROM_GNS = "Hello from SetnGet!";

	@Value("${spring.mail.username}")
	private String supportEmail;

	@Autowired
	public MailClient(JavaMailSender mailSender, MailContentBuilder mailContentBuilder) {
		this.mailSender = mailSender;
		this.mailContentBuilder = mailContentBuilder;
	}

	public void sendMessageToSupport(String message, String customerEmail, String name, String subject) {
		String completeSubject = String.format(SUPPORT_SUBJECT, subject);
		prepareAndSend(supportEmail, completeSubject,
				mailContentBuilder.buildSupportMessage(name, customerEmail, message));
	}

	public void sendThankyouMessage(String customerEmail, String name) {
		prepareAndSend(customerEmail, HELLO_FROM_GNS, mailContentBuilder.build(name));
	}

	public void prepareAndSend(String recipient, String subject, String content) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom(supportEmail);
			messageHelper.setTo(recipient);
			messageHelper.setSubject(subject);
			messageHelper.setText(content, true);
		};
		try {
			mailSender.send(messagePreparator);
		} catch (MailException e) {
			e.printStackTrace();
		}
	}
}
