package com.doj.citypages.controller;

import javax.validation.Valid;

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
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.doj.citypages.entities.CpuserAccount;
import com.doj.citypages.events.OnRegistrationCompleteEvent;
import com.doj.citypages.services.IUserService;
import com.doj.citypages.services.UserDto;
import com.doj.citypages.utils.CPConstants;
import com.doj.citypages.validation.EmailExistsException;

@Controller
public class RegistrationController {
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
	      
	        UserDto accountDto = new UserDto();
	        model.addAttribute("user", accountDto);
	        return CPConstants.REGISTRATION;
	    }
	    

	    @RequestMapping(value = CPConstants.SIGNINPAGE, method = RequestMethod.GET)
	    public String showLoginForm(WebRequest request, Model model) {
	      
	        UserDto accountDto = new UserDto();
	        model.addAttribute("user", accountDto);
	        return CPConstants.LOGIN;
	    }
	    
	    @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto accountDto, BindingResult result, WebRequest request, Errors errors) {
	        
	        if (result.hasErrors()) {
	            return new ModelAndView("signUp", "user", accountDto);
	        }

	        CpuserAccount registered = createUserAccount(accountDto);
	        if (registered == null) {
	            result.rejectValue("cpemail", "message.regError");
	        }
	        try {
	            String appUrl = request.getContextPath();
	            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
	        } catch (Exception me) {
	        	me.printStackTrace();
	        	//me.getMessage();
	            //return new ModelAndView("emailError", "user", accountDto);
	        }
	        return new ModelAndView("signUp", "user", accountDto);
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
