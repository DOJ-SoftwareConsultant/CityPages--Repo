package com.doj.citypages.services;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.doj.citypages.validation.PasswordMatches;
import com.doj.citypages.validation.ValidEmail;


@PasswordMatches
public class UserDto {
	@NotNull
	@NotEmpty
	private String firstName;

	@NotNull
	@NotEmpty
	private String lastName;

	@NotNull
	@NotEmpty
	@Size(min=6,max=18,message="Password length must be between 6 and 18")
	private String password;

	@NotNull
	@NotEmpty
	private String matchingPassword;

	@ValidEmail
	@NotNull
	@NotEmpty
	private String email;
	
	private Integer role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("User [firstName=").append(firstName).append("]")
				.append("[lastName=").append(lastName).append("]")
				.append("[email").append(email).append("]").append("[password")
				.append(password).append("]");
		return builder.toString();
	}
}
