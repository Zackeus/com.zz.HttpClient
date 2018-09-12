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

	@NotBlank(message = "{searchParameters.type.NotNull}")
	@Value("${statisticsSearchParameters.type}")
	private String type;		// 报表类型
	
	private String typeName; 	// 报表名
	
	@NotNull(message = "{searchParameters.startDay.NotNull}")
	private Date startDay; 		// 起始天数
	
	@NotNull(message = "{{searchParameters.endDay.NotNull}}")
	private Date endDay; 		// 结束天数
	
	@Value("${statisticsSearchParameters.startHour}")
	private String startHour; 	// 起始小时
	
	@Value("${statisticsSearchParameters.endHour}")
	private String endHour; 	// 结束小时
	
	private Integer startAge;	// 起始年龄
	private Integer endAge;		// 结束年龄
	
	// 催收接通率统计图(时间)
	public static final String CONNECTION_RATE_STATISTICS_TIME = "connection_rate_statistics_time";
	// 催收接通率统计图(年龄)
	public static final String CONNECTION_RATE_STATISTICS_AGE = "connection_rate_statistics_age";

	public StatisticsSearchParameters() {
		super();
	}
	
	public StatisticsSearchParameters(String type, String typeName, Date startDay, Date endDay, String startHour,
			String endHour, Integer startAge, Integer endAge) {
		super();
		this.type = type;
		this.typeName = typeName;
		this.startDay = startDay;
		this.endDay = endDay;
		this.startHour = startHour;
		this.endHour = endHour;
		this.startAge = startAge;
		this.endAge = endAge;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
	
	public Integer getStartAge() {
		return startAge;
	}

	public void setStartAge(Integer startAge) {
		this.startAge = startAge;
	}

	public Integer getEndAge() {
		return endAge;
	}

	public void setEndAge(Integer endAge) {
		this.endAge = endAge;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
