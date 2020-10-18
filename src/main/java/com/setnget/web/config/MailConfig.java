package com.setnget.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class MailConfig {

	@Value("${spring.view.prefix}")
    private String prefix;

    @Value("${spring.view.suffix}")
    private String suffix;

    @Value("${spring.view.view-names}")
    private String viewNames;
	
    
	
	  @Bean public ITemplateResolver templateResolver() {
	  ClassLoaderTemplateResolver templateResolver = new
	  ClassLoaderTemplateResolver(); templateResolver.setPrefix("templates/thymeleaf/");
	  templateResolver.setSuffix(".html");
	  templateResolver.setTemplateMode("HTML");
	  templateResolver.setCharacterEncoding("UTF-8"); return templateResolver; }
	 
	 
	
	  @Bean
	    InternalResourceViewResolver jspViewResolver() {
	        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix(prefix);
	        viewResolver.setSuffix(suffix);
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setViewNames(viewNames);
	        return viewResolver;
	    }

}
