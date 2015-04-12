package com.doj.citypages.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.doj.citypages.services.UserDto;

public class PasswordMatchesValidator implements
		ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}

	
	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserDto  userDto=(UserDto) obj;
		System.out.println(userDto.getPassword().equals(userDto.getMatchingPassword()));
		return userDto.getPassword().equals(userDto.getMatchingPassword());

	}
}
