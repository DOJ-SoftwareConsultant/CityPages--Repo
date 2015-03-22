package com.doj.citypages.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doj.citypages.entities.Users;
import com.doj.citypages.services.IUserService;

@Controller
public class LoginController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value="/signup", method=RequestMethod.GET) 
	public ModelAndView newUserPage() { 
		ModelAndView view= new ModelAndView("signup","user", new Users(1,"rishi","rishi.gmail","123"));
		return view; 
	} 

	@RequestMapping(value="/signin", method=RequestMethod.GET) 
	public ModelAndView userPage() { 
		ModelAndView view= new ModelAndView("signin","user", new Users(1,"rishi","rishi.gmail","123"));
		return view; 
	}
	
	@RequestMapping(value="/product", method=RequestMethod.GET) 
	public ModelAndView getProduct() { 
		ModelAndView view= new ModelAndView("signin","user", new Users(1,"rishi","rishi.gmail","123"));
		return view; 
	}
	
	@RequestMapping(value="/allproduct", method=RequestMethod.GET) 
	public ModelAndView getAllProduct() { 
		ModelAndView view= new ModelAndView("signin","user", new Users(1,"rishi","rishi.gmail","123"));
		return view; 
	}
}
