package com.zz.HttpClient.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @Title:MsgConfig
 * @Description:TODO(信息配置参数)
 * @Company:
 * @author zhou.zhang
 * @date 2018年7月21日 下午2:28:16
 */
@Component
public class MsgConfig {

	@Value("${msg.smsUrl}")
	private String smsUrl;

	@Value("${msg.wxUrl}")
	private String wxUrl;

	@Value("${msg.errorAgentId}")
	private String errorAgentId;

	@Value("${msg.redPacketAgentId}")
	private String redPacketAgentId;

	@Value("${msg.collectAgentId}")
	private String collectAgentId;

	@Value("${msg.ItDpId}")
	private String itDpId;

	@Value("${msg.collectDpId}")
	private String collectDpId;

	public String getSmsUrl() {
		return smsUrl;
	}

	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}

	public String getWxUrl() {
		return wxUrl;
	}

	public void setWxUrl(String wxUrl) {
		this.wxUrl = wxUrl;
	}

	public String getErrorAgentId() {
		return errorAgentId;
	}

	public void setErrorAgentId(String errorAgentId) {
		this.errorAgentId = errorAgentId;
	}

	public String getRedPacketAgentId() {
		return redPacketAgentId;
	}

	public void setRedPacketAgentId(String redPacketAgentId) {
		this.redPacketAgentId = redPacketAgentId;
	}

	public String getCollectAgentId() {
		return collectAgentId;
	}

	public void setCollectAgentId(String collectAgentId) {
		this.collectAgentId = collectAgentId;
	}

	public String getItDpId() {
		return itDpId;
	}

	public void setItDpId(String itDpId) {
		this.itDpId = itDpId;
	}

	public String getCollectDpId() {
		return collectDpId;
	}

	public void setCollectDpId(String collectDpId) {
		this.collectDpId = collectDpId;
	}

	@Override
	public String toString() {
		return "MsgConfig [smsUrl=" + smsUrl + ", wxUrl=" + wxUrl + ", errorAgentId=" + errorAgentId
				+ ", redPacketAgentId=" + redPacketAgentId + ", collectAgentId=" + collectAgentId + ", itDpId=" + itDpId
				+ ", collectDpId=" + collectDpId + "]";
	}

}
