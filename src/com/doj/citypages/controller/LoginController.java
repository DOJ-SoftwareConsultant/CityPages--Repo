package com.doj.citypages.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doj.citypages.services.IUserService;
import com.doj.citypags.entities.Users;

@Controller
public class LoginController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET) 
	public ModelAndView newUserPage() { 
		ModelAndView view= new ModelAndView("newUser","user", new Users(1,"rishi","rishi.gmail","123"));
		return view; 
	} 

}
