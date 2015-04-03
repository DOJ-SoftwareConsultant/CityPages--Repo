package com.doj.citypages.web.security;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Support class for easy access to our custom {@link CityPagesUserDetails}
 * 
 * @author Marten Deinum
 * @author Koen Serneels
 * 
 */
public class SecurityContextSupport {

	public static CityPagesUserDetails getUserDetails() {
		return (CityPagesUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
