package com.zz.HttpClient.modules.timer.entity;

import java.util.Date;

/**
 * 
 * @Title:CommonTimer
 * @Description:TODO(普通定时任务)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年12月12日 下午3:44:49
 */
public class CommonTimer extends TimerJob<CommonTimer> {

	private static final long serialVersionUID = 1L;
	
	private boolean status; // 当前状态(true：启用；false：禁用)
	private boolean result;	// 排程执行结果
	private Date resDate;	// 最近执行日期
	
	public CommonTimer() {
		super();
	}
	
	public CommonTimer(String jobName, String jobGroupName, String name, String jobTime, String jobClass) {
		super(jobName, jobGroupName, name, jobTime, jobClass);
	}
	
	public CommonTimer(String jobName, String jobGroupName) {
		super(jobName, jobGroupName);
	}
	
	public CommonTimer(String jobName) {
		super(jobName);
	}
	
	public CommonTimer(boolean status, boolean result, Date resDate) {
		super();
		this.status = status;
		this.result = result;
		this.resDate = resDate;
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isResult() {
		return result;
	}
	
	public void setResult(boolean result) {
		this.result = result;
	}
	
	public Date getResDate() {
		return resDate;
	}
	
	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}
	
}
