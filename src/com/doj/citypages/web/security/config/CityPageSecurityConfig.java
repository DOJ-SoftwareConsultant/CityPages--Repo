package com.doj.citypages.web.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.doj.citypages.web.security.MySimpleUrlAuthenticationSuccessHandler;

/**
 * @author Dinesh.Rajput
 *
 */

@EnableWebSecurity
@Configuration
@ComponentScan(basePackages = { "com.doj.citypages" })
public class CityPageSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
   /* @Autowired
	private MySimpleUrlAuthenticationSuccessHandler authenticationSuccessHandler;*/
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.inMemoryAuthentication().withUser("doj").password("123456").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	}
 
	/*@Bean
	 public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       // authProvider.setUserDetailsService(userDetailsService);
     //   authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }*/
	
	
	
	 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 /*http
		 .csrf().disable()
	        .authorizeRequests() 
	          .anyRequest().authenticated() 
	          .and() 
	        .formLogin() 
	          .loginPage("/login") 
	          .defaultSuccessUrl("/sites") 
	          .failureUrl("/login") 
	          .successHandler(authenticationSuccessHandler) // autowired or defined below 
	          .and() 
	        .logout() 
	          .permitAll() 
	          .and() ;*/
 
	  http.authorizeRequests()
	  	.antMatchers("/login/**").access("hasRole('ROLE_USER')")
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
		.and().formLogin().loginPage("/login.html");
 
	}
	
	 @Override
	  public void configure(WebSecurity web) throws Exception {
	    web
	      .ignoring()
	         .antMatchers("/resources/**"); // #3
	  }
}
