package com.zz.HttpClient.Bean.Sys.timer.collectionRobot;

import com.zz.HttpClient.Bean.Sys.timer.TimerJob;

/**
 * 
 * @Title:CollectionRobotTimer
 * @Description:TODO(催收机器定时任务实体)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月21日 上午11:42:57
 */
public class CollectionRobotTimer extends TimerJob<CollectionRobotTimer> {

	private static final long serialVersionUID = 1L;

	private Integer startDay; 				// 起始逾期天数
	private Integer endDay; 				// 结束逾期天数
	private CustomerStyle customerStyle; 	// 客户类型
	private boolean status; 				// 当前状态(true：启用；false：禁用)
	
	private String customerStyleId; 		// 客户类型Id 更新时使用
	
	public CollectionRobotTimer() {
		super();
	}

	public CollectionRobotTimer(String jobName, String jobGroupName, String name, String jobTime, String jobClass) {
		super(jobName, jobGroupName, name, jobTime, jobClass);
	}

	public CollectionRobotTimer(String jobName) {
		super(jobName);
	}
	
	public CollectionRobotTimer(String jobName, String jobGroupName) {
		super(jobName, jobGroupName);
	}

	public CollectionRobotTimer(Integer startDay, Integer endDay, CustomerStyle customerStyle, boolean status,
			String customerStyleId) {
		super();
		this.startDay = startDay;
		this.endDay = endDay;
		this.customerStyle = customerStyle;
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

}
