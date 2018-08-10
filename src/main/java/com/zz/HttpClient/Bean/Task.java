package com.zz.HttpClient.Bean;

import java.io.Serializable;

public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer operateType; 	// 操作类型
	private Long taskId; 			// 任务编号
	private Integer periodType; 	// 任务周期类型
	private TaskConfig taskConfig; 	// 任务配置

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(Integer operateType, Long taskId, Integer periodType, TaskConfig taskConfig) {
		super();
		this.operateType = operateType;
		this.taskId = taskId;
		this.periodType = periodType;
		this.taskConfig = taskConfig;
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Integer getPeriodType() {
		return periodType;
	}

	public void setPeriodType(Integer periodType) {
		this.periodType = periodType;
	}

	public TaskConfig getTaskConfig() {
		return taskConfig;
	}

	public void setTaskConfig(TaskConfig taskConfig) {
		this.taskConfig = taskConfig;
	}

	@Override
	public String toString() {
		return "Task [operateType=" + operateType + ", taskId=" + taskId + ", periodType=" + periodType
				+ ", taskConfig=" + taskConfig + "]";
	}

}
