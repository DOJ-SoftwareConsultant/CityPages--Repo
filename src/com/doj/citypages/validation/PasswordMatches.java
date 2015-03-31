/**
 * 
 */
package com.doj.citypages.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Payload;

/**
 * @author lenovo
 * 
 */

@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface PasswordMatches {
	String message() default "Invalid Email";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
