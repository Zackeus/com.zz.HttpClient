package com.zz.HttpClient.Bean;

import java.io.Serializable;

/**
 * 
 * @Title:CollectionTel
 * @Description:TODO(企业催收外呼号码)
 * @Company:
 * @author zhou.zhang
 * @date 2018年7月19日 上午9:08:51
 */
public class CollectionTel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer carrier; 	// 1：移动 2：联通 3：电信
	private Long createTime; 	// 创建时间
	private Integer duration; 	// 通话时长
	private Long endTime;		// 结束时间
	private String line; 		// 线路标识，中继线路
	private String region; 		// 电话号码所属区域
	private int parallelCount; 	// 并发数
	private Integer selected; 	// 0：已经被选中 1：未选中
	private Integer used; 		// 1：已经使用 0：未使用
	private Integer status; 	// 0：启用 1：禁用
	private String telNumber; 	// 电话接入号
	private String timeRangeBegin;
	private String timeRangeEnd;

	public CollectionTel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollectionTel(Integer carrier, Long createTime, Integer duration, Long endTime, String line, String region,
			int parallelCount, Integer selected, Integer used, Integer status, String telNumber, String timeRangeBegin,
			String timeRangeEnd) {
		super();
		this.carrier = carrier;
		this.createTime = createTime;
		this.duration = duration;
		this.endTime = endTime;
		this.line = line;
		this.region = region;
		this.parallelCount = parallelCount;
		this.selected = selected;
		this.used = used;
		this.status = status;
		this.telNumber = telNumber;
		this.timeRangeBegin = timeRangeBegin;
		this.timeRangeEnd = timeRangeEnd;
	}

	public Integer getCarrier() {
		return carrier;
	}

	public void setCarrier(Integer carrier) {
		this.carrier = carrier;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getParallelCount() {
		return parallelCount;
	}

	public void setParallelCount(int parallelCount) {
		this.parallelCount = parallelCount;
	}

	public Integer getSelected() {
		return selected;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
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

	@Override
	public String toString() {
		return "CollectionTel [carrier=" + carrier + ", createTime=" + createTime + ", duration=" + duration
				+ ", endTime=" + endTime + ", line=" + line + ", region=" + region + ", parallelCount=" + parallelCount
				+ ", selected=" + selected + ", used=" + used + ", status=" + status + ", telNumber=" + telNumber
				+ ", timeRangeBegin=" + timeRangeBegin + ", timeRangeEnd=" + timeRangeEnd + "]";
	}

}
