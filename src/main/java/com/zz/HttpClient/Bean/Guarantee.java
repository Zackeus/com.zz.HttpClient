package com.zz.HttpClient.Bean;

import java.io.Serializable;
import java.math.BigDecimal;

import com.zz.HttpClient.Util.annotation.excel.ExcelField;

/**
 * 
 * @Title:Guarantee
 * @Description:TODO(担保人实体)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月3日 上午11:12:04
 */
public class Guarantee implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long taskId; 			// 任务Id
	private String contractNum; 	// 合同号
	
	@ExcelField(title = "客户手机号码")
	private Long phoneNum; 			// 手机号
	
	@ExcelField(title = "逾期天数")
	private Long odDays; 			// 逾期天数
	
	@ExcelField(title = "担保人姓名")
	private String odName; 			// 客户姓名
	
	@ExcelField(title = "客户姓名")
	private String customeName;		// 借款人姓名
	
	@ExcelField(title = "金额")
	private BigDecimal odAmount; 	// 金额
	
	private String rtype; 			// 客户类型
	private String addressType;		// 住址类型
	private String requestEmpno; 	// 提交者
	private String requestDatetime; // 提交日期
	private String remark;			// 提交标识
	private String sendBatch;		// 提交批次
	private PageParame pageParame;	// 分页参数

	public Guarantee() {
		super();
	}

	public Guarantee(Long taskId, String contractNum, Long phoneNum, Long odDays, String odName, String customeName,
			BigDecimal odAmount, String rtype, String addressType, String requestEmpno, String requestDatetime, String sendBatch) {
		super();
		this.taskId = taskId;
		this.contractNum = contractNum;
		this.phoneNum = phoneNum;
		this.odDays = odDays;
		this.odName = odName;
		this.customeName = customeName;
		this.odAmount = odAmount;
		this.rtype = rtype;
		this.addressType = addressType;
		this.requestEmpno = requestEmpno;
		this.requestDatetime = requestDatetime;
		this.sendBatch = sendBatch;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public Long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Long getOdDays() {
		return odDays;
	}

	public void setOdDays(Long odDays) {
		this.odDays = odDays;
	}

	public String getOdName() {
		return odName;
	}

	public void setOdName(String odName) {
		this.odName = odName;
	}

	public String getCustomeName() {
		return customeName;
	}

	public void setCustomeName(String customeName) {
		this.customeName = customeName;
	}

	public BigDecimal getOdAmount() {
		return odAmount;
	}

	public void setOdAmount(BigDecimal odAmount) {
		this.odAmount = odAmount;
	}

	public String getRtype() {
		return rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getRequestEmpno() {
		return requestEmpno;
	}

	public void setRequestEmpno(String requestEmpno) {
		this.requestEmpno = requestEmpno;
	}

	public String getRequestDatetime() {
		return requestDatetime;
	}

	public void setRequestDatetime(String requestDatetime) {
		this.requestDatetime = requestDatetime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSendBatch() {
		return sendBatch;
	}

	public void setSendBatch(String sendBatch) {
		this.sendBatch = sendBatch;
	}

	public PageParame getPageParame() {
		return pageParame;
	}

	public void setPageParame(PageParame pageParame) {
		this.pageParame = pageParame;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		Guarantee other = (Guarantee) obj;

		// 多重逻辑处理，去除合同号、手机号相同的记录
		if (this.getContractNum().equals(other.getContractNum())
				|| this.getPhoneNum().compareTo(other.getPhoneNum()) == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Guarantee [taskId=" + taskId + ", contractNum=" + contractNum + ", phoneNum=" + phoneNum + ", odDays="
				+ odDays + ", odName=" + odName + ", customeName=" + customeName + ", odAmount=" + odAmount + ", rtype="
				+ rtype + ", addressType=" + addressType + ", requestEmpno=" + requestEmpno + ", requestDatetime="
				+ requestDatetime + ", remark=" + remark + ", sendBatch=" + sendBatch + ", pageParame=" + pageParame
				+ "]";
	}

}
