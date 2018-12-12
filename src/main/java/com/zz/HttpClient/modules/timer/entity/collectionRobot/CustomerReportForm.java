package com.zz.HttpClient.modules.timer.entity.collectionRobot;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.zz.HttpClient.common.annotation.excel.ExcelField;

/**
 * 
 * @Title:CustomerReportForm
 * @Description:TODO(催收报表)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年12月12日 下午1:10:33
 */
public class CustomerReportForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ExcelField(title = "任务编号")
	private Long taskId;
	
	@ExcelField(title = "合同号")
	private String contractNum;
	
	@ExcelField(title = "客户姓名")
	private String odName;
	
	@ExcelField(title = "客户类型")
	private String rtype;
	
	@ExcelField(title = "手机号")
	private Long phoneNum;
	
	@ExcelField(title = "逾期天数")
	private Long odDays;
	
	@ExcelField(title = "金额")
	private BigDecimal odAmount;
	
	@ExcelField(title = "住址类型")
	private String addressType;
	
	@ExcelField(title = "提交者")
	private String requestEmpno;
	
	@ExcelField(title = "提交日期")
	private String requestDatetime;
	
	@ExcelField(title = "提交批次")
	private String sendBatch;
	
	@ExcelField(title = "接通结果")
	private String callResult;
	
	@ExcelField(title = "还款说明")
	private String repayment;

	public CustomerReportForm() {
	}

	public CustomerReportForm(Long taskId, String contractNum, String odName, String rtype, Long phoneNum, Long odDays,
			BigDecimal odAmount, String addressType, String requestEmpno, String requestDatetime, String sendBatch,
			String callResult, String repayment) {
		this.taskId = taskId;
		this.contractNum = contractNum;
		this.odName = odName;
		this.rtype = rtype;
		this.phoneNum = phoneNum;
		this.odDays = odDays;
		this.odAmount = odAmount;
		this.addressType = addressType;
		this.requestEmpno = requestEmpno;
		this.requestDatetime = requestDatetime;
		this.sendBatch = sendBatch;
		this.callResult = callResult;
		this.repayment = repayment;
	}

	public Long getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getContractNum() {
		return this.contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public String getOdName() {
		return this.odName;
	}

	public void setOdName(String odName) {
		this.odName = odName;
	}

	public String getRtype() {
		return this.rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public Long getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Long getOdDays() {
		return this.odDays;
	}

	public void setOdDays(Long odDays) {
		this.odDays = odDays;
	}

	public BigDecimal getOdAmount() {
		return this.odAmount;
	}

	public void setOdAmount(BigDecimal odAmount) {
		this.odAmount = odAmount;
	}

	public String getAddressType() {
		return this.addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getRequestEmpno() {
		return this.requestEmpno;
	}

	public void setRequestEmpno(String requestEmpno) {
		this.requestEmpno = requestEmpno;
	}

	public String getRequestDatetime() {
		return this.requestDatetime;
	}

	public void setRequestDatetime(String requestDatetime) {
		this.requestDatetime = requestDatetime;
	}

	public String getSendBatch() {
		return this.sendBatch;
	}

	public void setSendBatch(String sendBatch) {
		this.sendBatch = sendBatch;
	}

	public String getCallResult() {
		return this.callResult;
	}

	public void setCallResult(String callResult) {
		this.callResult = callResult;
	}

	public String getRepayment() {
		return this.repayment;
	}

	public void setRepayment(String repayment) {
		this.repayment = repayment;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
