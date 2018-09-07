package com.zz.HttpClient.common.annotation.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.zz.HttpClient.modules.timer.entity.collectionRobot.CollectionRobotTimer;

/**
 * 
 * @Title:CollectionRobotValidator
 * @Description:TODO(催收机器定时类验证器)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月29日 下午5:21:21
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CollectionRobotValidator.Validator.class)
public @interface CollectionRobotValidator {
	
	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	public class Validator implements ConstraintValidator<CollectionRobotValidator, CollectionRobotTimer> {

		@Override
		public void initialize(CollectionRobotValidator constraintAnnotation) {
			// TODO Auto-generated method stub
		}

		@Override
		public boolean isValid(CollectionRobotTimer value, ConstraintValidatorContext context) {
			if (value.getStartDay().intValue() > value.getEndDay().intValue()) {
				// 禁用默认信息
				context.disableDefaultConstraintViolation();
				// 覆盖新的错误信息
				context.buildConstraintViolationWithTemplate("{collectionRobotTimer.startDay.TooSmall}").addConstraintViolation();
				return Boolean.FALSE;
			}
			return Boolean.TRUE;
		}
		
	}

}
