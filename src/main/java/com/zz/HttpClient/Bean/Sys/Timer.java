package com.zz.HttpClient.Bean.Sys;

import com.zz.HttpClient.Bean.Basic.DataEntity;

/**
 * 
 * @Title:Timer
 * @Description:TODO(定时任务实体)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月16日 上午10:51:06
 */
public class Timer extends DataEntity<Timer> {

	private static final long serialVersionUID = 1L;

	private String name; 		// 定时任务名
	private Integer startDate; 	// 起始时间(单位小时)
	private Integer endDate; 	// 结束时间(单位小时)
	private boolean status; 	// 当前状态(true：启用；false：禁用)
	private String updateUrl; 	// 更新地址
	private String startUrl; 	// 启动地址
	private String stopUrl; 	// 停止地址
	private String cron; 		// 定时策略

	public Timer() {
		super();
	}

	public Timer(String id) {
		super(id);
	}
	
	public Timer(String id, String cron) {
		super(id);
		this.cron = cron;
	}
	
	public Timer(String id, boolean status) {
		super(id);
		this.status = status;
	}
	
	public Timer(String name, Integer startDate, Integer endDate, boolean status, String updateUrl, String startUrl,
			String stopUrl, String cron) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.updateUrl = updateUrl;
		this.startUrl = startUrl;
		this.stopUrl = stopUrl;
		this.cron = cron;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStartDate() {
		return startDate;
	}

	public void setStartDate(Integer startDate) {
		this.startDate = startDate;
	}

	public Integer getEndDate() {
		return endDate;
	}

	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
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

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}
}
