package com.doj.citypages.controller;

import java.util.Calendar;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.doj.citypages.entities.CpuserAccount;
import com.doj.citypages.entities.VerificationToken;
import com.doj.citypages.events.OnRegistrationCompleteEvent;
import com.doj.citypages.services.IUserService;
import com.doj.citypages.services.UserDto;
import com.doj.citypages.utils.CPConstants;
import com.doj.citypages.validation.EmailExistsException;

@Controller
public class RegistrationController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	    @Autowired
	    private IUserService service;

	    @Autowired
	    private MessageSource messages;

	    @Autowired
	    private JavaMailSender mailSender;

	    @Autowired
	    private ApplicationEventPublisher eventPublisher;

	    public RegistrationController() {

	    }
	    
	    

	    @RequestMapping(value = CPConstants.SIGNUPPAGE, method = RequestMethod.GET)
	    public String showRegistrationForm(WebRequest request, Model model) {
	    	LOGGER.debug("Rendering registration page.");
	        UserDto accountDto = new UserDto();
	        model.addAttribute("user", accountDto);
	        return CPConstants.REGISTRATION;
	    }
	    
	    @RequestMapping(value = CPConstants.REGCONF, method = RequestMethod.GET)
	    public String confirmRegistration(WebRequest request, Model model, @RequestParam("token") String token) {
	    	
	    	LOGGER.debug("Rendering confirm registration page.");
	        Locale locale = request.getLocale();

	        VerificationToken verificationToken = service.getVerificationToken(token);
	        if (verificationToken == null) {
	            String message = messages.getMessage("auth.message.invalidToken", null, locale);
	            model.addAttribute("message", message);
	            return "redirect:/badUser.html?lang=" + locale.getLanguage();
	        }

	        CpuserAccount user = verificationToken.getCpuseraccount();
	        Calendar cal = Calendar.getInstance();
	        
	        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
	            model.addAttribute("message", messages.getMessage("auth.message.expired", null, locale));
	            return "redirect:/badUser.html?lang=" + locale.getLanguage();
	        }

	        user.setEnabled(true);
	        service.saveRegisteredUser(user);
	        return "redirect:/login.html?lang=" + locale.getLanguage();
	    }
	    

	    @RequestMapping(value = CPConstants.SIGNINPAGE, method = RequestMethod.GET)
	    public String showLoginForm(WebRequest request, Model model) {
	      
	        UserDto accountDto = new UserDto();
	        model.addAttribute("user", accountDto);
	        return CPConstants.LOGIN;
	    }
	  
	    
	    @RequestMapping(value = CPConstants.SIGNUPPAGE, method = RequestMethod.POST)
	    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto accountDto, BindingResult result, WebRequest request, Errors errors) {
	        
	        if (result.hasErrors()) {
	        
	            return new ModelAndView(CPConstants.REGISTRATION, "user", accountDto);
	        }

	        CpuserAccount registered = createUserAccount(accountDto);
	        if (registered == null) {
	            result.rejectValue("email", "message.regError");
	          return new ModelAndView(CPConstants.REGISTRATION, "user", accountDto);
	        }
	        try {
	            String appUrl = request.getContextPath();
	            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
	        } catch (Exception me) {
	        	//me.printStackTrace();
	        	//me.getMessage();
	            return new ModelAndView("emailError", "user", accountDto);
	        }
	        return new ModelAndView(CPConstants.SUCCESSREG, "user", accountDto);
	    }
	    
	 	    
	    private CpuserAccount createUserAccount(UserDto accountDto) {
	    	CpuserAccount registered = null;
	        try {
	            registered = service.registerNewUserAccount(accountDto);
	        } catch (EmailExistsException e) {
	            return null;
	        }
	        return registered;
	    }
}
