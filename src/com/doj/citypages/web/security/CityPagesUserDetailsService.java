package com.doj.citypages.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.doj.citypages.services.IUserService;

/**
 * Custom {@link UserDetailsService} which retrieves the data for the user authenticating from the database. When the
 * user exists returns a {@link CityPagesUserDetails} containing all information for further authentication
 * 
 * @author Dinesh Rajput
 * 
 */
@Component
public class CityPagesUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StringUtils.isEmpty(username)) {
			throw new UsernameNotFoundException("Username was empty");
		}

		//CpuserAccount account = userService.login(username);

//		if (account == null) {
//			throw new UsernameNotFoundException("Username not found");
//		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		/*for (Role role : account.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
			for (Permission permission : role.getPermissions()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(permission.getPermission()));
			}
		}*/
		return null;//new CityPagesUserDetails(userService.login(username), grantedAuthorities);
	}
}
