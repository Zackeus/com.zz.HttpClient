package com.zz.HttpClient.Bean.Sys.timer.collectionRobot;

import com.zz.HttpClient.Bean.Basic.DataEntity;

/**
 * 
 * @Title:CollectionRobotTimer
 * @Description:TODO(催收机器定时任务实体)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月21日 上午11:42:57
 */
public class CollectionRobotTimer extends DataEntity<CollectionRobotTimer> {

	private static final long serialVersionUID = 1L;

	private String jobName; 				// 定时任务名；实际是定时任务Id
	private String jobGroupName; 			// 定时任务组名
	private String name; 					// 定时任务名
	private Integer startDay; 				// 起始逾期天数
	private Integer endDay; 				// 结束逾期天数
	private CustomerStyle customerStyle; 	// 客户类型
	private String jobTime; 				// 定时策略
	private boolean status; 				// 当前状态(true：启用；false：禁用)
	private String jobClass; 				// 定时任务执行类名
	
	private String customerStyleId; 		// 客户类型Id 更新时使用

	public CollectionRobotTimer() {
		super();
	}

	public CollectionRobotTimer(String id) {
		super(id);
	}

	public CollectionRobotTimer(String jobName, String jobGroupName, String name, Integer startDay, Integer endDay,
			CustomerStyle customerStyle, String jobTime, boolean status, String jobClass) {
		super();
		this.jobName = jobName;
		this.jobGroupName = jobGroupName;
		this.name = name;
		this.startDay = startDay;
		this.endDay = endDay;
		this.customerStyle = customerStyle;
		this.jobTime = jobTime;
		this.status = status;
		this.jobClass = jobClass;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroupName() {
		return jobGroupName;
	}

	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getJobTime() {
		return jobTime;
	}

	public void setJobTime(String jobTime) {
		this.jobTime = jobTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getJobClass() {
		return jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}

	public String getCustomerStyleId() {
		return customerStyleId;
	}

	public void setCustomerStyleId(String customerStyleId) {
		this.customerStyleId = customerStyleId;
	}

}
