package com.zz.HttpClient.common.annotation.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.zz.HttpClient.common.utils.basic.BasicValidator;
import com.zz.HttpClient.modules.timer.entity.DialTestTimer;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DialTestTimerValidator.Validator.class)
public @interface DialTestTimerValidator {
	
	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	public class Validator extends BasicValidator<DialTestTimerValidator, DialTestTimer> {

		@Override
		public void initialize(DialTestTimerValidator constraintAnnotation) {
			// TODO Auto-generated method stub
		}

		@Override
		public boolean isValid(DialTestTimer value, ConstraintValidatorContext context) {
			if (value.getStartDay().intValue() > value.getEndDay().intValue()) 
				return sendErrorMsg(context, "{collectionRobotTimer.startDay.TooSmall}");
			return Boolean.TRUE;
		}
		
	}

}
