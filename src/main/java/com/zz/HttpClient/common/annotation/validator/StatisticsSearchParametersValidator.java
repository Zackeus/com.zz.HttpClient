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
import com.zz.HttpClient.common.utils.StringUtils;
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
			switch (value.getType()) {
			case StatisticsSearchParameters.CONNECTION_RATE_STATISTICS_TIME:
				// 催收接通率统计图(时间)
				if (StringUtils.isBlank(value.getStartHour())) {
					return sendErrorMsg(context, "{searchParameters.startHour.NotBlank}");
				}
				
				if (!value.getStartHour().matches("(0\\d{1}|1\\d{1}|2[0-4])")) {
					return sendErrorMsg(context, "不是小时格式");
				}
				
				if (StringUtils.isBlank(value.getEndHour())) {
					return sendErrorMsg(context, "{searchParameters.endHour.NotBlank}");
				}
				
				if (!value.getEndHour().matches("(0\\d{1}|1\\d{1}|2[0-4])")) {
					return sendErrorMsg(context, "不是小时格式");
				}
				break;

			default:
				return sendErrorMsg(context, "{searchParameters.type.Unknown}");
			}
			

			if (!DateUtils.timeCompareOfTwoDate(value.getStartDay(), value.getEndDay())) {
				return sendErrorMsg(context, "{searchParameters.startDay.TooBig}");
			}
			
			if (DateUtils.getDistanceOfTwoDate(value.getStartDay(), value.getEndDay()) > 20) {
				return sendErrorMsg(context, "{searchParameters.distanceDay.TooBig}");
			}
			
			if (Integer.valueOf(value.getStartHour()) > Integer.valueOf(value.getEndHour())) {
				return sendErrorMsg(context, "{searchParameters.startHour.TooBig}");
			}
			
			if (Integer.valueOf(value.getEndHour()) - Integer.valueOf(value.getStartHour()) > 13) {
				return sendErrorMsg(context, "{searchParameters.distanceHour.TooBig}");
			}
			return Boolean.TRUE;
		}
		
		public boolean sendErrorMsg(ConstraintValidatorContext context, String msg) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(msg).addConstraintViolation();
			return Boolean.FALSE;
		}
	}

}
