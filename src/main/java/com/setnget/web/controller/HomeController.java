package com.setnget.web.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.setnget.web.service.MailClient;

@Controller
public class HomeController {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	MailClient mailClient;

	@RequestMapping("/home")
	public String getHome() {
		return "jsp/home";
	}
	
	@RequestMapping("/privacy-statement")
	public String confirm(HttpServletResponse response) {
		return "jsp/privacy-statement";
	}
	
	@RequestMapping("/tou")
	public String termsOfUse(HttpServletResponse response) {
		return "jsp/tou";
	}
	
	@RequestMapping("/subscribe")
	public String subscribe(HttpServletResponse response) {
		return "jsp/subscripton_conf";
	}

	@RequestMapping("email1")
	public String sendMail() {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("support@setnget.com");
		msg.setTo("sandeepn26@gmail.com");

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		javaMailSender.send(msg);

		return "home.jsp";
	}

	@RequestMapping("/email")
	public String sendHtmlMail(HttpServletRequest request) throws MessagingException {

		String customerEmail = request.getParameter("email");
		String name = request.getParameter("name");

		mailClient.sendMessageToSupport(request.getParameter("message"), customerEmail, name,
				request.getParameter("subject"));
		mailClient.sendThankyouMessage(customerEmail, name);
		return "jsp/thankyou_msg";
	}

}
