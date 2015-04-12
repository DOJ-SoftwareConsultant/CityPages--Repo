package com.doj.citypages.listeners;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.doj.citypages.entities.CpuserAccount;
import com.doj.citypages.events.OnRegistrationCompleteEvent;
import com.doj.citypages.services.IUserService;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent>{
	
	
	@Autowired
    private IUserService service;

    @Autowired
    private MessageSource messages;

    @Autowired
    private JavaMailSender mailSender;


	@Override
	public void onApplicationEvent(OnRegistrationCompleteEvent event) {
		this.confirmRegistration(event);
		
	}

	private void confirmRegistration(OnRegistrationCompleteEvent event) {
		CpuserAccount user = event.getAccountUser();
		String token = UUID.randomUUID().toString();
		service.createVerificationTokenForUser(user, token);

		String recipientAddress = user.getCpemail();
		String subject = "Registration Confirmation";
		String confirmationUrl = event.getAppUrl() + "/regitrationConfirm.html?token="
				+ token;
		String message = messages.getMessage("message.regSucc", null,
				event.getLocale());

		SimpleMailMessage email = new SimpleMailMessage();

		// email.setFrom("rishiranjan706@gmail.com");
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message + " \r\n" + "http://localhost:8080"
				+ confirmationUrl);
		mailSender.send(email);
	}

}
