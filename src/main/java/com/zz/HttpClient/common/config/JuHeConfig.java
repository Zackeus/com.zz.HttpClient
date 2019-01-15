package com.zz.HttpClient.common.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @Title:JuHeConfig
 * @Description:TODO(聚合速驰催收机器人配置参数)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年7月21日 下午1:31:52
 */
@Component
public class JuHeConfig {

	@Value("${juhe.username}")
	private String username;				// 登录帐号
	
	@Value("${juhe.password}")
	private String password;				// 登录密码
	
	@Value("${juhe.speechSkillId}")
	private Long speechSkillId;				// 借款人话术id
	
	@Value("${juhe.guaranteeSpeechSkillId}")
	private Long guaranteeSpeechSkillId;	// 担保人话术id
	
	@Value("${juhe.robotVoiceId}")
	private Integer robotVoiceId;			// 发音人编号
	
	@Value("${juhe.telNum}")
	private String telNum;					// 64000271
	
	@Value("${juhe.telGuaranteeNum}")
	private String telGuaranteeNum;			// 64000272
	
	@Value("${juhe.telNumThird}")
	private String telNumThird;				// 64000273
	
	@Value("${juhe.sysType}")
	private Integer sysType;				// 系统标签 0 晓曼 1ptah 2yeta
	
	@Value("${juhe.timeRange}")
	private List<String> timeRange;			// 外呼时间段控制
	
	@Value("${juhe.recallStatus}")
	private List<Integer> recallStatus;		// 重复外呼状态
	
	@Value("${juhe.getToken}")
	private String getToken;				// 鉴权接口
	
	@Value("${juhe.searchVoice}")
	private String searchVoice;				// 查询发音人列表
	
	@Value("${juhe.searchSpeechSkill}")
	private String searchSpeechSkill;		// 查询话术列表
	
	@Value("${juhe.searchTel}")
	private String searchTel;				// 查询企业外呼号码
	
	@Value("${juhe.uploadExcelDataExcel}")
	private String uploadExcelDataExcel;	// 数据上传
	
	@Value("${juhe.manageTask}")
	private String manageTask;				// 管理外呼任务
	
	@Value("${juhe.searchTaskList}")
	private String searchTaskList;			// 查询任务集合
	
	@Value("${juhe.borrower}")
	private String borrower;				// 借款人标识
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getSpeechSkillId() {
		return speechSkillId;
	}

	public void setSpeechSkillId(Long speechSkillId) {
		this.speechSkillId = speechSkillId;
	}
	
	public Long getGuaranteeSpeechSkillId() {
		return guaranteeSpeechSkillId;
	}

	public void setGuaranteeSpeechSkillId(Long guaranteeSpeechSkillId) {
		this.guaranteeSpeechSkillId = guaranteeSpeechSkillId;
	}

	public Integer getRobotVoiceId() {
		return robotVoiceId;
	}

	public void setRobotVoiceId(Integer robotVoiceId) {
		this.robotVoiceId = robotVoiceId;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	
	public String getTelGuaranteeNum() {
		return telGuaranteeNum;
	}

	public void setTelGuaranteeNum(String telGuaranteeNum) {
		this.telGuaranteeNum = telGuaranteeNum;
	}
	
	public String getTelNumThird() {
		return telNumThird;
	}

	public void setTelNumThird(String telNumThird) {
		this.telNumThird = telNumThird;
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

	public void setTimeRange(List<String> timeRange) {
		this.timeRange = timeRange;
	}

	public List<Integer> getRecallStatus() {
		return recallStatus;
	}

	public void setRecallStatus(List<Integer> recallStatus) {
		this.recallStatus = recallStatus;
	}
	
	public String getGetToken() {
		return getToken;
	}

	public void setGetToken(String getToken) {
		this.getToken = getToken;
	}

	public String getSearchVoice() {
		return searchVoice;
	}

	public void setSearchVoice(String searchVoice) {
		this.searchVoice = searchVoice;
	}

	public String getSearchSpeechSkill() {
		return searchSpeechSkill;
	}

	public void setSearchSpeechSkill(String searchSpeechSkill) {
		this.searchSpeechSkill = searchSpeechSkill;
	}

	public String getSearchTel() {
		return searchTel;
	}

	public void setSearchTel(String searchTel) {
		this.searchTel = searchTel;
	}

	public String getUploadExcelDataExcel() {
		return uploadExcelDataExcel;
	}

	public void setUploadExcelDataExcel(String uploadExcelDataExcel) {
		this.uploadExcelDataExcel = uploadExcelDataExcel;
	}

	public String getManageTask() {
		return manageTask;
	}

	public void setManageTask(String manageTask) {
		this.manageTask = manageTask;
	}

	public String getSearchTaskList() {
		return searchTaskList;
	}

	public void setSearchTaskList(String searchTaskList) {
		this.searchTaskList = searchTaskList;
	}
	
	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	@Override
	public String toString() {
		return "JuHeConfig [username=" + username + ", password=" + password + ", speechSkillId=" + speechSkillId
				+ ", guaranteeSpeechSkillId=" + guaranteeSpeechSkillId + ", robotVoiceId=" + robotVoiceId + ", telNum="
				+ telNum + ", telGuaranteeNum=" + telGuaranteeNum + ", sysType=" + sysType + ", timeRange=" + timeRange
				+ ", recallStatus=" + recallStatus + ", getToken=" + getToken + ", searchVoice=" + searchVoice
				+ ", searchSpeechSkill=" + searchSpeechSkill + ", searchTel=" + searchTel + ", uploadExcelDataExcel="
				+ uploadExcelDataExcel + ", manageTask=" + manageTask + ", searchTaskList=" + searchTaskList
				+ ", borrower=" + borrower + "]";
	}
	
}
