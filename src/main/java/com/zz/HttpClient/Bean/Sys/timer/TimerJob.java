package com.zz.HttpClient.Bean.Sys.timer;

import org.hibernate.validator.constraints.NotBlank;

import com.zz.HttpClient.Bean.Basic.DataEntity;
import com.zz.HttpClient.Service.sys.valid.SpecialVaild;
import com.zz.HttpClient.Service.sys.valid.UpdateVaild;
import com.zz.HttpClient.Util.validator.annotation.IsExistClass;
import com.zz.HttpClient.Util.validator.annotation.IsValidCron;

/**
 * 
 * @Title:TimerJob
 * @Description:TODO(定时任务基类)
 * @Company:
 * @author zhou.zhang
 * @param <T>
 * @date 2018年8月22日 上午9:08:32
 */
public class TimerJob<T> extends DataEntity<T> {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "{timerJob.jobName.NotBlank}", groups = {UpdateVaild.class})
	private String jobName; 		// 定时任务名；实际是定时任务Id
	
	@NotBlank(message = "{timerJob.jobGroupName.NotBlank}", groups = {UpdateVaild.class})
	private String jobGroupName; 	// 定时任务组名
	
	@NotBlank(message = "{timerJob.name.NotBlank}")
	private String name; 			// 定时任务名
	
	@NotBlank(message = "{timerJob.jobTime.NotBlank}")
	@IsValidCron
	private String jobTime; 		// 定时策略
	
	@NotBlank(message = "{timerJob.jobClass.NotBlank}", groups = {UpdateVaild.class})
	@IsExistClass(groups = {SpecialVaild.class})
	private String jobClass; 		// 定时任务执行类名

	public TimerJob() {
		super();
	}

	public TimerJob(String jobName) {
		this.jobName = jobName;
	}
	
	public TimerJob(String jobName, String jobGroupName) {
		super();
		this.jobName = jobName;
		this.jobGroupName = jobGroupName;
	}
	
	public TimerJob(String jobName, String jobGroupName, String name, String jobTime, String jobClass) {
		super();
		this.jobName = jobName;
		this.jobGroupName = jobGroupName;
		this.name = name;
		this.jobTime = jobTime;
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

	public String getJobTime() {
		return jobTime;
	}

	public void setJobTime(String jobTime) {
		this.jobTime = jobTime;
	}

	public String getJobClass() {
		return jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}

}
