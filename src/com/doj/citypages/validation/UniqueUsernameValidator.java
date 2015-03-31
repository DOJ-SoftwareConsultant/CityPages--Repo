package com.doj.citypages.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements
		ConstraintValidator<UniqueUsername, String> {

	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
	}

	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}