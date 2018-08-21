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

	private String name; 					// 定时任务名
	private Integer startDay; 				// 起始逾期天数
	private Integer endDay; 				// 结束逾期天数
	private CustomerStyle customerStyle; 	// 客户类型
	private String cron; 					// 定时策略
	private boolean status; 				// 当前状态(true：启用；false：禁用)
	private String updateUrl; 				// 更新地址
	private String startUrl; 				// 启动地址
	private String stopUrl; 				// 停止地址

	public CollectionRobotTimer() {
		super();
	}

	public CollectionRobotTimer(String id) {
		super(id);
	}

	public CollectionRobotTimer(String name, Integer startDay, Integer endDay, CustomerStyle customerStyle, String cron,
			boolean status, String updateUrl, String startUrl, String stopUrl) {
		super();
		this.name = name;
		this.startDay = startDay;
		this.endDay = endDay;
		this.customerStyle = customerStyle;
		this.cron = cron;
		this.status = status;
		this.updateUrl = updateUrl;
		this.startUrl = startUrl;
		this.stopUrl = stopUrl;
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

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUpdateUrl() {
		return updateUrl;
	}

	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}

	public String getStartUrl() {
		return startUrl;
	}

	public void setStartUrl(String startUrl) {
		this.startUrl = startUrl;
	}

	public String getStopUrl() {
		return stopUrl;
	}

	public void setStopUrl(String stopUrl) {
		this.stopUrl = stopUrl;
	}

}
