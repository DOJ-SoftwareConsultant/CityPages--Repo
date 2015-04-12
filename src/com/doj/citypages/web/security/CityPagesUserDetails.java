package com.doj.citypages.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.doj.citypages.entities.CpuserAccount;

/**
 * Customer {@link UserDetails} holding our authentication object {@link Account} and keeping track of the list of
 * {@link GrantedAuthority} for the current authenticated user
 * 
 * @author Dinesh Rajput
 * 
 */
public class CityPagesUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 653027638824438094L;
	private CpuserAccount account;
	private List<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
	

	public CityPagesUserDetails() {
		
		// TODO Auto-generated constructor stub
	}

	public CityPagesUserDetails(CpuserAccount account, List<? extends GrantedAuthority> authorities) {
		this.account = account;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return account.getCppwd();
	}

	@Override
	public String getUsername() {
		return account.getCpemail();
	}

	public CpuserAccount getAccount() {
		return account;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
