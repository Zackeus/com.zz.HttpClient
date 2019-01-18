package com.zz.HttpClient.modules.timer.entity.collectionRobot;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:ExplicitNum
 * @Description:TODO(外显实体（yeta接口）)
 * @Company: 
 * @author zhou.zhang
 * @date 2019年1月18日 上午9:02:26
 */
public class ExplicitNum implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long businessId;			// 企业编号
	private Integer concurrent;
	private Integer concurrentShow;		
	private String cpnCode;				// 外显号
	private Integer expired;
	private String prefix;
	private String timeRangeBegin;
	private String timeRangeEnd;
	private Integer used;				// 1：占用 0：空闲
	
	public ExplicitNum() {
		super();
	}
	
	public ExplicitNum(Long businessId, Integer concurrent, Integer concurrentShow, String cpnCode, Integer expired,
			String prefix, String timeRangeBegin, String timeRangeEnd, Integer used) {
		super();
		this.businessId = businessId;
		this.concurrent = concurrent;
		this.concurrentShow = concurrentShow;
		this.cpnCode = cpnCode;
		this.expired = expired;
		this.prefix = prefix;
		this.timeRangeBegin = timeRangeBegin;
		this.timeRangeEnd = timeRangeEnd;
		this.used = used;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public Integer getConcurrent() {
		return concurrent;
	}

	public void setConcurrent(Integer concurrent) {
		this.concurrent = concurrent;
	}

	public Integer getConcurrentShow() {
		return concurrentShow;
	}

	public void setConcurrentShow(Integer concurrentShow) {
		this.concurrentShow = concurrentShow;
	}

	public String getCpnCode() {
		return cpnCode;
	}

	public void setCpnCode(String cpnCode) {
		this.cpnCode = cpnCode;
	}

	public Integer getExpired() {
		return expired;
	}

	public void setExpired(Integer expired) {
		this.expired = expired;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getTimeRangeBegin() {
		return timeRangeBegin;
	}

	public void setTimeRangeBegin(String timeRangeBegin) {
		this.timeRangeBegin = timeRangeBegin;
	}

	public String getTimeRangeEnd() {
		return timeRangeEnd;
	}

	public void setTimeRangeEnd(String timeRangeEnd) {
		this.timeRangeEnd = timeRangeEnd;
	}

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	

}
