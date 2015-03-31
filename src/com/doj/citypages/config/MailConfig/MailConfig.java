package com.doj.citypages.config.MailConfig;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(basePackages = { "com.doj.citypages" })
@PropertySource("classpath:email.properties")
public class MailConfig {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private Environment env;

	public MailConfig() {
		super();
	}

	

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public JavaMailSender javaMailSenderImpl() {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		LOGGER.debug("into mail configuration class");
		mailSenderImpl.setHost(env.getProperty("smtp.host"));
		mailSenderImpl.setPort(env.getProperty("smtp.port", Integer.class));
		mailSenderImpl.setProtocol(env.getProperty("smtps.protocol"));
		mailSenderImpl.setUsername(env.getProperty("support.email"));
		mailSenderImpl.setPassword(env.getProperty("smtp.password"));
		mailSenderImpl.setUsername(env.getProperty("smtp.username"));

		Properties properties = new Properties();
		// properties.setProperty("mail.smtp.host","smtp.gmail.com");
		// properties.setProperty("mail.smtp.port", "587");
		// .setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.debug", "true");
		mailSenderImpl.setJavaMailProperties(properties);
		LOGGER.debug("mail properties set");
		return mailSenderImpl;
	}

}