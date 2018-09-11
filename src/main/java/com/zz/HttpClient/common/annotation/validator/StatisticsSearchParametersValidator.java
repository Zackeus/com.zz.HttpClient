package com.zz.HttpClient.common.annotation.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.zz.HttpClient.common.utils.DateUtils;
import com.zz.HttpClient.modules.assetManage.entity.StatisticsSearchParameters;

/**
 * 
 * @Title:SearchParametersValidator
 * @Description:TODO(报表搜索参数验证器)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年9月10日 下午3:20:38
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StatisticsSearchParametersValidator.Validator.class)
public @interface StatisticsSearchParametersValidator {
	
	
	String message() default "参数异常";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	public class Validator implements ConstraintValidator<StatisticsSearchParametersValidator, StatisticsSearchParameters> {

		@Override
		public void initialize(StatisticsSearchParametersValidator constraintAnnotation) {
			// TODO Auto-generated method stub
		}

		@Override
		public boolean isValid(StatisticsSearchParameters value, ConstraintValidatorContext context) {
			if (!DateUtils.timeCompareOfTwoDate(value.getStartDay(), value.getEndDay())) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("{searchParameters.startDay.TooBig}").addConstraintViolation();
				return Boolean.FALSE;
			}
			
			if (DateUtils.getDistanceOfTwoDate(value.getStartDay(), value.getEndDay()) > 5) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("{searchParameters.distanceDay.TooBig}").addConstraintViolation();
				return Boolean.FALSE;
			}
			
			if (Integer.valueOf(value.getStartHour()) > Integer.valueOf(value.getEndHour())) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("{searchParameters.startHour.TooBig}").addConstraintViolation();
				return Boolean.FALSE;
			}
			
			if (Integer.valueOf(value.getEndHour()) - Integer.valueOf(value.getStartHour()) > 13) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("{searchParameters.distanceHour.TooBig}").addConstraintViolation();
				return Boolean.FALSE;
			}
			return Boolean.TRUE;
		}
	}

}
