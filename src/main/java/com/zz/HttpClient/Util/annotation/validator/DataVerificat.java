package com.zz.HttpClient.Util.annotation.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.zz.HttpClient.Service.Basic.CrudService;
import com.zz.HttpClient.Util.ObjectUtils;
import com.zz.HttpClient.Util.SpringContextUtil;
import com.zz.HttpClient.Util.StringUtils;

/**
 * 
 * @Title:DataVerificat
 * @Description:TODO(数据校验器 操作数据据库前校验数据是否存在 要相应的 service 
 * 实现 CrudService 的 get(String id) 方法,实现此方法最好整合缓存机制)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月30日 下午2:28:52
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DataVerificat.Validator.class)
public @interface DataVerificat {
	
	String message() default "{IsExistData}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
	Class<? extends CrudService<?, ?>> service();
	
	public class Validator implements ConstraintValidator<DataVerificat, String> {
		
		private Class<? extends CrudService<?, ?>> service;

		@Override
		public void initialize(DataVerificat constraintAnnotation) {
			service = constraintAnnotation.service();
		}

		@Override
		public boolean isValid(String value, ConstraintValidatorContext context) {
			if (StringUtils.isBlank(value)) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate("{IsNotBlank}").addConstraintViolation();
				return Boolean.FALSE;
			}
			
			return !ObjectUtils.isEmpty(SpringContextUtil.getBeanByName(service).get(value));
		}
	}
}
