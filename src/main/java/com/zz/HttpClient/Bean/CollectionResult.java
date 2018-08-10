package com.zz.HttpClient.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @Title:CollectionResult
 * @Description:TODO(催收结果)
 * @Company:
 * @author zhou.zhang
 * @date 2018年7月8日 下午5:09:05
 */
public class CollectionResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long taskId; 							// 外呼编号
	private Long taskDataId; 						// 外呼任务编号
	private Long callTime;							// 外呼时间(时间戳格式)
	private Long callBeginTime; 					// 接通时间(时间戳格式)
	private Long callEndTime; 						// 结束时间(时间戳格式)
	private Long callTimeLength; 					// 外呼时长(单位秒)
	private Long callProcTimeLength; 				// 接通时长(单位秒)
	private Integer status; 						// 外呼状态
	private String callResult;
	private Integer result; 						// 通话结果
	private Long telNumber; 						// 电话接入号
	private String recordFile; 						// 外呼电话录音文件
	private Long fileLength; 						// 录音文件长度
	private List<Object> rowData; 					// 上传数据
	private List<CollectionCallData> callData; 		// 外呼交互内容

	public CollectionResult() {
		super();
	}

	public CollectionResult(Long taskId, Long taskDataId, Long callTime, Long callBeginTime, Long callEndTime,
			Long callTimeLength, Long callProcTimeLength, Integer status, String callResult, Integer result,
			Long telNumber, String recordFile, Long fileLength, List<Object> rowData,
			List<CollectionCallData> callData) {
		super();
		this.taskId = taskId;
		this.taskDataId = taskDataId;
		this.callTime = callTime;
		this.callBeginTime = callBeginTime;
		this.callEndTime = callEndTime;
		this.callTimeLength = callTimeLength;
		this.callProcTimeLength = callProcTimeLength;
		this.status = status;
		this.callResult = callResult;
		this.result = result;
		this.telNumber = telNumber;
		this.recordFile = recordFile;
		this.fileLength = fileLength;
		this.rowData = rowData;
		this.callData = callData;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
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

	public String getCallResult() {
		return callResult;
	}

	public void setCallResult(String callResult) {
		this.callResult = callResult;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Long getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(Long telNumber) {
		this.telNumber = telNumber;
	}

	public String getRecordFile() {
		return recordFile;
	}

	public void setRecordFile(String recordFile) {
		this.recordFile = recordFile;
	}

	public Long getFileLength() {
		return fileLength;
	}

	public void setFileLength(Long fileLength) {
		this.fileLength = fileLength;
	}

	public List<Object> getRowData() {
		return rowData;
	}

	public void setRowData(List<Object> rowData) {
		this.rowData = rowData;
	}

	public List<CollectionCallData> getCallData() {
		return callData;
	}

	public void setCallData(List<CollectionCallData> callData) {
		this.callData = callData;
	}

	@Override
	public String toString() {
		return "CollectionResult [taskId=" + taskId + ", taskDataId=" + taskDataId + ", callTime=" + callTime
				+ ", callBeginTime=" + callBeginTime + ", callEndTime=" + callEndTime + ", callTimeLength="
				+ callTimeLength + ", callProcTimeLength=" + callProcTimeLength + ", status=" + status + ", callResult="
				+ callResult + ", result=" + result + ", telNumber=" + telNumber + ", recordFile=" + recordFile
				+ ", fileLength=" + fileLength + ", rowData=" + rowData + ", callData=" + callData + "]";
	}

}
