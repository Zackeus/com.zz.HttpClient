package com.zz.HttpClient.Util.annotation.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.springframework.util.ClassUtils;

/**
 * 
 * @Title:IsExistClass
 * @Description:TODO(类路径校验类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月28日 下午4:14:03
 */
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsExistClass.Validator.class)
public @interface IsExistClass {
	
	String message() default "{IsExistClass}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	public class Validator implements ConstraintValidator<IsExistClass, String> {

		@Override
		public void initialize(IsExistClass constraintAnnotation) {
			// TODO Auto-generated method stub
		}

		@Override
		public boolean isValid(String value, ConstraintValidatorContext context) {
			return ClassUtils.isPresent(value, this.getClass().getClassLoader());
		}
		
	}

}
