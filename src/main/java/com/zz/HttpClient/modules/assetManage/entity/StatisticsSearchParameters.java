package com.zz.HttpClient.modules.assetManage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zz.HttpClient.common.annotation.validator.Hour;
import com.zz.HttpClient.common.annotation.validator.StatisticsSearchParametersValidator;
import com.zz.HttpClient.common.service.valid.First;
import com.zz.HttpClient.common.service.valid.Second;

/**
 * 
 * @Title:SearchParameters
 * @Description:TODO(催收统计搜索参数)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月10日 下午2:30:09
 */
@GroupSequence({StatisticsSearchParameters.class, First.class, Second.class})
@StatisticsSearchParametersValidator(groups = {Second.class})
@Component
public class StatisticsSearchParameters implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "{searchParameters.startDay.NotNull}")
	private Date startDay; 		// 起始天数
	
	@NotNull(message = "{searchParameters.endDay.NotNull}")
	private Date endDay; 		// 结束天数
	
	@NotBlank(message = "{searchParameters.startHour.NotBlank}")
	@Hour
	@Value("${statisticsSearchParameters.startHour}")
	private String startHour; 	// 起始小时
	
	@NotBlank(message = "{searchParameters.endHour.NotBlank}")
	@Hour
	@Value("${statisticsSearchParameters.endHour}")
	private String endHour; 	// 结束小时

	public StatisticsSearchParameters() {
		super();
	}

	public StatisticsSearchParameters(Date startDay, Date endDay, String startHour, String endHour) {
		super();
		this.startDay = startDay;
		this.endDay = endDay;
		this.startHour = startHour;
		this.endHour = endHour;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public String getStartHour() {
		return startHour;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
