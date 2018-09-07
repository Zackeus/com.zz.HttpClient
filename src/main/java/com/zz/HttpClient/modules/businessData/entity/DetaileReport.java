package com.zz.HttpClient.modules.businessData.entity;

import java.io.Serializable;

/**
 * 
 * @Title:Reports
 * @Description:TODO(大汉三通短信子报告)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月8日 下午4:00:55
 */
public class DetaileReport implements Serializable {

	private static final long serialVersionUID = 1L;

	private String msgid; 		// 短信编号
	private String phone; 		// 下行手机号码
	private String status; 		// 短信发送结果 0——成功；1——接口处理失败；2——运营商网关失败；
	private String desc; 		// 当status为1时，以desc的错误码为准
	private String wgcode; 		// 当status为2时，表示运营商网关返回的原始值
	private String time; 		// 状态报告接收时间格式为yyyy-MM-ddHH:mm:ss
	private String smsCount; 	// 长短信条数
	private String smsIndex; 	// 长短信序号

	public DetaileReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetaileReport(String msgid, String phone, String status, String desc, String wgcode, String time, String smsCount,
			String smsIndex) {
		super();
		this.msgid = msgid;
		this.phone = phone;
		this.status = status;
		this.desc = desc;
		this.wgcode = wgcode;
		this.time = time;
		this.smsCount = smsCount;
		this.smsIndex = smsIndex;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getWgcode() {
		return wgcode;
	}

	public void setWgcode(String wgcode) {
		this.wgcode = wgcode;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(String smsCount) {
		this.smsCount = smsCount;
	}

	public String getSmsIndex() {
		return smsIndex;
	}

	public void setSmsIndex(String smsIndex) {
		this.smsIndex = smsIndex;
	}

	@Override
	public String toString() {
		return "Reports [msgid=" + msgid + ", phone=" + phone + ", status=" + status + ", desc=" + desc + ", wgcode="
				+ wgcode + ", time=" + time + ", smsCount=" + smsCount + ", smsIndex=" + smsIndex + "]";
	}

}
