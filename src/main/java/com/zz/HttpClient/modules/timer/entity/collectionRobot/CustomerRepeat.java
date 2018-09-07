package com.zz.HttpClient.modules.timer.entity.collectionRobot;

import java.math.BigDecimal;

public class CustomerRepeat extends Customer {

	private static final long serialVersionUID = 1L;
	
	public CustomerRepeat() {
		super();
	}

	public CustomerRepeat(Long taskId, String contractNum, String odName, String rtype, Long phoneNum, Long odDays,
			BigDecimal odAmount, String addressType, String requestEmpno, String requestDatetime, String remark,
			String sendBatch, PageParame pageParame) {
		super(taskId, contractNum, odName, rtype, phoneNum, odDays, odAmount, addressType, requestEmpno, requestDatetime,
				remark, sendBatch, pageParame);
	}

	public CustomerRepeat(Long taskId, String contractNum, String odName, String rtype, Long phoneNum, Long odDays,
			BigDecimal odAmount, String addressType, String requestEmpno, String requestDatetime, String remark,
			String sendBatch) {
		super(taskId, contractNum, odName, rtype, phoneNum, odDays, odAmount, addressType, requestEmpno, requestDatetime,
				remark, sendBatch);
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

		CustomerRepeat other = (CustomerRepeat) obj;

		// 多重逻辑处理，去除合同号、手机号相同的记录
		if (this.getContractNum().equals(other.getContractNum())
				&& this.getPhoneNum().compareTo(other.getPhoneNum()) == 0) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
