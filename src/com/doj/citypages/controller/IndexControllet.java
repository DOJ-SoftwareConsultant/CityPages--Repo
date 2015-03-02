package com.doj.citypages.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doj.citypages.utils.CPConstants;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class IndexControllet {
	
	@RequestMapping(CPConstants.ROOTPAGE)
	public String home(){
		
		return CPConstants.HOME;
	}
}
