package com.zz.HttpClient.modules.timer.entity;

import java.util.Arrays;
import java.util.List;

import javax.validation.GroupSequence;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.zz.HttpClient.common.annotation.validator.DialTestTimerValidator;
import com.zz.HttpClient.common.service.valid.First;
import com.zz.HttpClient.common.service.valid.Second;
import com.zz.HttpClient.common.utils.ObjectUtils;
import com.zz.HttpClient.common.utils.StringUtils;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CustomerStyle;

/**
 * 
 * @Title:DialTestTimer
 * @Description:TODO(催收拨号测试任务实体)
 * @Company: 
 * @author zhou.zhang
 * @date 2019年1月13日 下午3:53:17
 */
@GroupSequence({DialTestTimer.class, First.class, Second.class})
@DialTestTimerValidator(groups = {Second.class})
public class DialTestTimer extends TimerJob<DialTestTimer> {

	private static final long serialVersionUID = 1L;
	
	@Min(value = 1, message = "{collectionRobotTimer.startDay.Min}")
	private Integer startDay; 				// 起始逾期天数
	
	@Min(value = 1, message = "{collectionRobotTimer.endDay.Min}")
	private Integer endDay; 				// 结束逾期天数
	
	private CustomerStyle customerStyle; 	// 客户类型
	
	private List<String> mobileLabels;		// 手机标签
	private String mobileLabelsStr;			// 手机标签字符(以';'拼接，存储时使用)
	
	@NotNull(message = "{collectionRobotTimer.status.NotNull}")
	private boolean status; 				// 当前状态(true：启用；false：禁用)
	
	@NotBlank(message = "{collectionRobotTimer.customerStyleId.NotBlank}")
	private String customerStyleId; 		// 客户类型Id 更新时使用

	public DialTestTimer() {
		super();
	}

	public DialTestTimer(String jobName, String jobGroupName, String name, String jobTime, String jobClass) {
		super(jobName, jobGroupName, name, jobTime, jobClass);
	}

	public DialTestTimer(String jobName, String jobGroupName) {
		super(jobName, jobGroupName);
	}

	public DialTestTimer(String jobName) {
		super(jobName);
	}

	public DialTestTimer(Integer startDay, Integer endDay, CustomerStyle customerStyle, List<String> mobileLabels,
			String mobileLabelsStr, boolean status, String customerStyleId) {
		super();
		this.startDay = startDay;
		this.endDay = endDay;
		this.customerStyle = customerStyle;
		this.mobileLabels = mobileLabels;
		this.mobileLabelsStr = mobileLabelsStr;
		this.status = status;
		this.customerStyleId = customerStyleId;
	}

	public Integer getStartDay() {
		return startDay;
	}

	public void setStartDay(Integer startDay) {
		this.startDay = startDay;
	}

	public Integer getEndDay() {
		return endDay;
	}

	public void setEndDay(Integer endDay) {
		this.endDay = endDay;
	}

	public CustomerStyle getCustomerStyle() {
		return customerStyle;
	}

	public void setCustomerStyle(CustomerStyle customerStyle) {
		this.customerStyle = customerStyle;
	}

	public List<String> getMobileLabels() {
		return mobileLabels;
	}

	public void setMobileLabels(List<String> mobileLabels) {
		this.mobileLabels = mobileLabels;
	}
	
	public String getMobileLabelsStr() {
		return mobileLabelsStr;
	}

	public void setMobileLabelsStr(String mobileLabelsStr) {
		this.mobileLabelsStr = mobileLabelsStr;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getCustomerStyleId() {
		return customerStyleId;
	}

	public void setCustomerStyleId(String customerStyleId) {
		this.customerStyleId = customerStyleId;
	}
	
	/**
	 * 
	 * @Title：initMobileLabels
	 * @Description: TODO(标签字符转列表)
	 * @see：
	 */
	public void initMobileLabels() {
		if (StringUtils.isNotBlank(this.mobileLabelsStr)) {
			this.mobileLabels =  Arrays.asList(StringUtils.split(this.mobileLabelsStr, StringUtils.SEPARATOR_SECOND));
		}
	}
	
	/**
	 * 
	 * @Title：initMobileLabelsStr
	 * @Description: TODO(标签列表转字符)
	 * @see：
	 */
	public void initMobileLabelsStr() {
		if (ObjectUtils.isNotEmpty(this.mobileLabels)) {
			this.mobileLabelsStr =  StringUtils.join(this.mobileLabels, StringUtils.SEPARATOR_SECOND);
		}
	}
	
}
