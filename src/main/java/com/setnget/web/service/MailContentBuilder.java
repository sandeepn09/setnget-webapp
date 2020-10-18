package com.setnget.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {

	private TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String build(String name) {
        Context context = new Context();
        context.setVariable("name", name);
        return templateEngine.process("mail_template", context);
    }
    
    public String buildSupportMessage(String name, String custEmail, String message) {
        Context context = new Context();
        context.setVariable("name", name);
        context.setVariable("email", custEmail);
        context.setVariable("message", message);
        return templateEngine.process("support_mail", context);
    }

}
