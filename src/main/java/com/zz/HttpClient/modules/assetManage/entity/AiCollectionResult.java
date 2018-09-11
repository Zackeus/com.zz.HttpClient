package com.zz.HttpClient.modules.assetManage.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:AiCollectionResult
 * @Description:TODO(催收结果)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月10日 下午6:33:15
 */
public class AiCollectionResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long taskDataId; 					// 外呼任务编号
	private Long callTime; 						// 外呼时间(时间戳格式)
	private Long callBeginTime; 				// 接通时间(时间戳格式)
	private Long callEndTime; 					// 结束时间(时间戳格式)
	private Long callTimeLength; 				// 外呼时长(单位秒)
	private Long callProcTimeLength; 			// 接通时长(单位秒)
	private Integer status; 					// 外呼状态
	private String callStatus;					// 状态说明
	private Integer result; 					// 通话结果
	private String callResult;					// 状态说明
	private String recordFile;					// 外呼电话录音文件
	private String insertTime; 					// 接收时间
	
	private Long total;							// 拨打总数
	private Long sucNum;						// 拨打成功数

	public AiCollectionResult() {
		super();
	}

	public AiCollectionResult(Long taskDataId, Long callTime, Long callBeginTime, Long callEndTime, Long callTimeLength,
			Long callProcTimeLength, Integer status, String callStatus, Integer result, String callResult,
			String recordFile, String insertTime, Long total, Long sucNum) {
		super();
		this.taskDataId = taskDataId;
		this.callTime = callTime;
		this.callBeginTime = callBeginTime;
		this.callEndTime = callEndTime;
		this.callTimeLength = callTimeLength;
		this.callProcTimeLength = callProcTimeLength;
		this.status = status;
		this.callStatus = callStatus;
		this.result = result;
		this.callResult = callResult;
		this.recordFile = recordFile;
		this.insertTime = insertTime;
		this.total = total;
		this.sucNum = sucNum;
	}

	public Long getTaskDataId() {
		return taskDataId;
	}

	public void setTaskDataId(Long taskDataId) {
		this.taskDataId = taskDataId;
	}

	public Long getCallTime() {
		return callTime;
	}

	public void setCallTime(Long callTime) {
		this.callTime = callTime;
	}

	public Long getCallBeginTime() {
		return callBeginTime;
	}

	public void setCallBeginTime(Long callBeginTime) {
		this.callBeginTime = callBeginTime;
	}

	public Long getCallEndTime() {
		return callEndTime;
	}

	public void setCallEndTime(Long callEndTime) {
		this.callEndTime = callEndTime;
	}

	public Long getCallTimeLength() {
		return callTimeLength;
	}

	public void setCallTimeLength(Long callTimeLength) {
		this.callTimeLength = callTimeLength;
	}

	public Long getCallProcTimeLength() {
		return callProcTimeLength;
	}

	public void setCallProcTimeLength(Long callProcTimeLength) {
		this.callProcTimeLength = callProcTimeLength;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getCallResult() {
		return callResult;
	}

	public void setCallResult(String callResult) {
		this.callResult = callResult;
	}

	public String getRecordFile() {
		return recordFile;
	}

	public void setRecordFile(String recordFile) {
		this.recordFile = recordFile;
	}

	public String getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getSucNum() {
		return sucNum;
	}

	public void setSucNum(Long sucNum) {
		this.sucNum = sucNum;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
