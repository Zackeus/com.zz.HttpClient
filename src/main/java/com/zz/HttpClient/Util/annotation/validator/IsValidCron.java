package com.zz.HttpClient.Util.annotation.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.zz.HttpClient.Util.TimerUtil;

/**
 * 
 * @Title:IsValidCron
 * @Description:TODO(cron 表达式校验类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月28日 下午4:32:33
 */
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsValidCron.Validator.class)
public @interface IsValidCron {
	
	String message() default "{IsValidCron}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	public class Validator implements ConstraintValidator<IsValidCron, String> {

		@Override
		public void initialize(IsValidCron constraintAnnotation) {
			// TODO Auto-generated method stub
		}

		@Override
		public boolean isValid(String value, ConstraintValidatorContext context) {
			return TimerUtil.isValid(value);
		}
		
	}

}
