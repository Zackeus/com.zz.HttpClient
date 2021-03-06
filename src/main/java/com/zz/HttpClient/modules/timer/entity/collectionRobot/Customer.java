package com.zz.HttpClient.modules.timer.entity.collectionRobot;

import java.io.Serializable;
import java.math.BigDecimal;

import com.zz.HttpClient.common.annotation.excel.ExcelField;

/**
 * 
 * @Title:Customer
 * @Description:TODO(客户实体类)
 * @Company:
 * @author zhou.zhang
 * @date 2018年7月5日 下午7:06:51
 */
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long taskId; 			// 任务Id
	private String contractNum; 	// 合同号
	
	@ExcelField(title = "客户手机号码")
	private Long phoneNum; 			// 手机号
	
	@ExcelField(title = "逾期天数")
	private Long odDays; 			// 逾期天数
	
	@ExcelField(title = "客户姓名")
	private String odName; 			// 客户姓名
	
	@ExcelField(title = "金额")
	private BigDecimal odAmount; 	// 金额
	
	private String customeName;		// 借款人姓名
	private String rtype; 			// 客户类型
	private String addressType;		// 住址类型
	private String requestEmpno; 	// 提交者
	private String requestDatetime; // 提交日期
	private String remark;			// 提交标识
	private String sendBatch;		// 提交批次
	private PageParame pageParame;	// 分页参数

	public Customer() {
		super();
	}
	
	public Customer(Long taskId, String contractNum, String odName, String rtype, Long phoneNum, Long odDays,
			BigDecimal odAmount, String addressType, String requestEmpno, String requestDatetime, String remark,
			String sendBatch) {
		super();
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
		this.remark = remark;
		this.sendBatch = sendBatch;
	}
	
	public Customer(Long taskId, String contractNum, String odName, String rtype, Long phoneNum, Long odDays,
			BigDecimal odAmount, String addressType, String requestEmpno, String requestDatetime, String remark,
			String sendBatch, PageParame pageParame) {
		super();
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
		this.remark = remark;
		this.sendBatch = sendBatch;
		this.pageParame = pageParame;
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

	public String getRtype() {
		return rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
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

	public BigDecimal getOdAmount() {
		return odAmount;
	}

	public void setOdAmount(BigDecimal odAmount) {
		this.odAmount = odAmount;
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

	/**
	 * 重写equals,用于比较对象属性是否包含
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		Customer other = (Customer) obj;

		// 多重逻辑处理，去除合同号、手机号相同的记录
		if (this.getContractNum().equals(other.getContractNum())
				|| this.getPhoneNum().compareTo(other.getPhoneNum()) == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Customer [taskId=" + taskId + ", contractNum=" + contractNum + ", phoneNum=" + phoneNum + ", odDays="
				+ odDays + ", odName=" + odName + ", odAmount=" + odAmount + ", customeName=" + customeName + ", rtype="
				+ rtype + ", addressType=" + addressType + ", requestEmpno=" + requestEmpno + ", requestDatetime="
				+ requestDatetime + ", remark=" + remark + ", sendBatch=" + sendBatch + ", pageParame=" + pageParame
				+ "]";
	}
	
}
