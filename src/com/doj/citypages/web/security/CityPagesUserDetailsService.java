package com.doj.citypages.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.doj.citypages.entities.CpuserAccount;
import com.doj.citypages.repositories.UserRepository;
import com.doj.citypages.services.IUserService;

/**
 * Custom {@link UserDetailsService} which retrieves the data for the user
 * authenticating from the database. When the user exists returns a
 * {@link CityPagesUserDetails} containing all information for further
 * authentication
 * 
 * @author Dinesh Rajput
 * 
 */
@Component
@Service
@Transactional
public class CityPagesUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IUserService userService;

	@Autowired
	private MessageSource messages;

	/*@Autowired
	CityPagesUserDetails cityPagesUserDetails;*/

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		 boolean enabled = true;
	        boolean accountNonExpired = true;
	        boolean credentialsNonExpired = true;
	        boolean accountNonLocked = true;
		if (StringUtils.isEmpty(email)) {
			throw new UsernameNotFoundException("Username was empty");
		}

		try {
			CpuserAccount cpUser = userRepository.findBycpemail(email);
			if (cpUser == null) {
                return new org.springframework.security.core.userdetails.User(" ", " ", enabled, true, true, true, getAuthorities(new Integer(1)));
            }
			 return new org.springframework.security.core.userdetails.User(cpUser.getCpemail(), cpUser.getCppwd(), cpUser.isEnabled(), accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(cpUser.getRole().getRole()));
		} catch (Exception e) {
			throw new UsernameNotFoundException("Username not found");
		}
	}

	// CpuserAccount account = userService.login(username);

	// if (account == null) {
	// throw new UsernameNotFoundException("Username not found");
	// }

	private Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	public List<String> getRoles(Integer role) {
		List<String> roles = new ArrayList<String>();
		if (role.intValue() == 2) {
			roles.add("ROLE_ADMIN");
		} else if (role.intValue() == 1) {
			roles.add("ROLE_USER");
		}
		return roles;
	}

	private static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	/*
	 * for (Role role : account.getRoles()) { grantedAuthorities.add(new
	 * SimpleGrantedAuthority(role.getRole())); for (Permission permission :
	 * role.getPermissions()) { grantedAuthorities.add(new
	 * SimpleGrantedAuthority(permission.getPermission())); }
	 */

}
