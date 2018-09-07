package com.zz.HttpClient.modules.timer.entity.collectionRobot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Title:TaskConfig
 * @Description:TODO(任务配置)
 * @Company:
 * @author zhou.zhang
 * @date 2018年7月6日 上午9:04:18
 */
public class TaskConfig implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String fileName; 					// 文件名
	private String orgFileName; 				// 组织文件名
	private String name; 						// 任务名称
	private Long beginTime; 					// 开始时间
	private Long endTime; 						// 截至时间
	private Long speechSkillId; 				// 话术编号
	private Integer robotVoiceId; 				// 发音人编号
	private Integer speedRate; 					// 语速
	private Integer robotTaskType; 				// 机器人外呼类型 0 呼出
	private Integer telType; 					// 号码类型 1 普通号码 2 轮显号码 默认 1
	private String telNum; 						// 外呼号码
	private Integer sysType; 					// 系统标签
	private List<String> timeRange; 			// 外呼时间段控制
	private Integer parallelCount; 				// 并行数
	private Integer recallMaxCount; 			// 最大重复外呼次数
	private Integer recallWaitTime; 			// 重复外呼等待时间
	private List<Integer> recallStatus; 		// 重复外呼状态

	public TaskConfig() {
		super();
	}

	public TaskConfig(String fileName, String orgFileName, String name, Long beginTime, Long endTime,
			Long speechSkillId, Integer robotVoiceId, Integer speedRate, Integer robotTaskType, Integer telType,
			String telNum, Integer sysType, List<String> timeRange2, Integer parallelCount, Integer recallMaxCount,
			Integer recallWaitTime, List<Integer> recallStatus2) {
		super();
		this.fileName = fileName;
		this.orgFileName = orgFileName;
		this.name = name;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.speechSkillId = speechSkillId;
		this.robotVoiceId = robotVoiceId;
		this.speedRate = speedRate;
		this.robotTaskType = robotTaskType;
		this.telType = telType;
		this.telNum = telNum;
		this.sysType = sysType;
		this.timeRange = timeRange2;
		this.parallelCount = parallelCount;
		this.recallMaxCount = recallMaxCount;
		this.recallWaitTime = recallWaitTime;
		this.recallStatus = recallStatus2;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public Long getSpeechSkillId() {
		return speechSkillId;
	}

	public void setSpeechSkillId(Long speechSkillId) {
		this.speechSkillId = speechSkillId;
	}

	public Integer getRobotVoiceId() {
		return robotVoiceId;
	}

	public void setRobotVoiceId(Integer robotVoiceId) {
		this.robotVoiceId = robotVoiceId;
	}

	public Integer getSpeedRate() {
		return speedRate;
	}

	public void setSpeedRate(Integer speedRate) {
		this.speedRate = speedRate;
	}

	public Integer getRobotTaskType() {
		return robotTaskType;
	}

	public void setRobotTaskType(Integer robotTaskType) {
		this.robotTaskType = robotTaskType;
	}

	public Integer getTelType() {
		return telType;
	}

	public void setTelType(Integer telType) {
		this.telType = telType;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public Integer getSysType() {
		return sysType;
	}

	public void setSysType(Integer sysType) {
		this.sysType = sysType;
	}

	public List<String> getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(ArrayList<String> timeRange) {
		this.timeRange = timeRange;
	}

	public Integer getParallelCount() {
		return parallelCount;
	}

	public void setParallelCount(Integer parallelCount) {
		this.parallelCount = parallelCount;
	}

	public Integer getRecallMaxCount() {
		return recallMaxCount;
	}

	public void setRecallMaxCount(Integer recallMaxCount) {
		this.recallMaxCount = recallMaxCount;
	}

	public Integer getRecallWaitTime() {
		return recallWaitTime;
	}

	public void setRecallWaitTime(Integer recallWaitTime) {
		this.recallWaitTime = recallWaitTime;
	}

	public List<Integer> getRecallStatus() {
		return recallStatus;
	}

	public void setRecallStatus(ArrayList<Integer> recallStatus) {
		this.recallStatus = recallStatus;
	}

	@Override
	public String toString() {
		return "TaskConfig [fileName=" + fileName + ", orgFileName=" + orgFileName + ", name=" + name + ", beginTime="
				+ beginTime + ", endTime=" + endTime + ", speechSkillId=" + speechSkillId + ", robotVoiceId="
				+ robotVoiceId + ", speedRate=" + speedRate + ", robotTaskType=" + robotTaskType + ", telType="
				+ telType + ", telNum=" + telNum + ", sysType=" + sysType + ", timeRange=" + timeRange
				+ ", parallelCount=" + parallelCount + ", recallMaxCount=" + recallMaxCount + ", recallWaitTime="
				+ recallWaitTime + ", recallStatus=" + recallStatus + "]";
	}

}
