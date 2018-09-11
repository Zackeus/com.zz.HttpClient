package com.zz.HttpClient.common.entity.echarts;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:Tooltip
 * @Description:TODO(提示框组件)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月11日 上午9:00:43
 */
public class Tooltip implements Serializable {

	private static final long serialVersionUID = 1L;

	private String trigger = "axis"; // 触发类型

	public Tooltip() {
		super();
	}

	public Tooltip(String trigger) {
		super();
		this.trigger = trigger;
	}

	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
