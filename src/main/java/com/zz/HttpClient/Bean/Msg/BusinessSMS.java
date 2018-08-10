package com.zz.HttpClient.Bean.Msg;

import java.util.Date;

import com.zz.HttpClient.Bean.Basic.DataEntity;

/**
 * 
 * @Title:BusinessSMS
 * @Description:TODO(业务短信)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月9日 上午8:40:18
 */
public class BusinessSMS extends DataEntity<BusinessSMS> {

	private static final long serialVersionUID = 1L;

	private String serialNo; 			// 短信流水号
	private String requestSys; 			// 来源系统
	private String requestUser; 		// 提交者
	private String receiverName; 		// 接收短信者姓名
	private String msgContent; 			// 短信内容
	private String receiverCompany; 	// 接收短信者公司名
	private String receiverRole; 		// 接收者角色
	private String receiverTel; 		// 接收者电话号码
	private Date sendDateTime; 			// 短信发送日期
	private String requestDateTime; 	// 请求提交日期
	private Integer repeatTimes; 		// 重发次数
	private Integer repeatInterval; 	// 重发间隔时间(单位：分)
	private String applicationNumber; 	// 合同号
	private String externalContractNbr; // 申请号
	private String remarkT; 			// 提交标签
	private String platForm; 			// 发送平台

	public BusinessSMS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessSMS(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public BusinessSMS(String serialNo, String requestSys, String requestUser, String receiverName, String msgContent,
			String receiverCompany, String receiverRole, String receiverTel, Date sendDateTime, String requestDateTime,
			Integer repeatTimes, Integer repeatInterval, String applicationNumber, String externalContractNbr,
			String remarkT, String platForm) {
		super();
		this.serialNo = serialNo;
		this.requestSys = requestSys;
		this.requestUser = requestUser;
		this.receiverName = receiverName;
		this.msgContent = msgContent;
		this.receiverCompany = receiverCompany;
		this.receiverRole = receiverRole;
		this.receiverTel = receiverTel;
		this.sendDateTime = sendDateTime;
		this.requestDateTime = requestDateTime;
		this.repeatTimes = repeatTimes;
		this.repeatInterval = repeatInterval;
		this.applicationNumber = applicationNumber;
		this.externalContractNbr = externalContractNbr;
		this.remarkT = remarkT;
		this.platForm = platForm;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getRequestSys() {
		return requestSys;
	}

	public void setRequestSys(String requestSys) {
		this.requestSys = requestSys;
	}

	public String getRequestUser() {
		return requestUser;
	}

	public void setRequestUser(String requestUser) {
		this.requestUser = requestUser;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getReceiverCompany() {
		return receiverCompany;
	}

	public void setReceiverCompany(String receiverCompany) {
		this.receiverCompany = receiverCompany;
	}

	public String getReceiverRole() {
		return receiverRole;
	}

	public void setReceiverRole(String receiverRole) {
		this.receiverRole = receiverRole;
	}

	public String getReceiverTel() {
		return receiverTel;
	}

	public void setReceiverTel(String receiverTel) {
		this.receiverTel = receiverTel;
	}

	public Date getSendDateTime() {
		return sendDateTime;
	}

	public void setSendDateTime(Date sendDateTime) {
		this.sendDateTime = sendDateTime;
	}

	public String getRequestDateTime() {
		return requestDateTime;
	}

	public void setRequestDateTime(String requestDateTime) {
		this.requestDateTime = requestDateTime;
	}

	public Integer getRepeatTimes() {
		return repeatTimes;
	}

	public void setRepeatTimes(Integer repeatTimes) {
		this.repeatTimes = repeatTimes;
	}

	public Integer getRepeatInterval() {
		return repeatInterval;
	}

	public void setRepeatInterval(Integer repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getExternalContractNbr() {
		return externalContractNbr;
	}

	public void setExternalContractNbr(String externalContractNbr) {
		this.externalContractNbr = externalContractNbr;
	}

	public String getRemarkT() {
		return remarkT;
	}

	public void setRemarkT(String remarkT) {
		this.remarkT = remarkT;
	}

	public String getPlatForm() {
		return platForm;
	}

	public void setPlatForm(String platForm) {
		this.platForm = platForm;
	}

}
