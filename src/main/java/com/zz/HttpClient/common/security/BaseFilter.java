package com.zz.HttpClient.common.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.servlet.AdviceFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.zz.HttpClient.common.config.GlobalConfig;
import com.zz.HttpClient.common.config.MsgConfig;
import com.zz.HttpClient.common.entity.msg.WeiXinMsg;
import com.zz.HttpClient.common.utils.SendMsgUtil;
import com.zz.HttpClient.common.utils.WebUtils;

/**
 * 
 * @Title:BaseFilter
 * @Description:TODO(基础拦截器)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月8日 下午2:15:12
 */
public abstract class BaseFilter extends AdviceFilter {

	@Autowired
	protected MsgConfig msgConfig;
	
	protected static final String ENCODING = "UTF-8";
	
	protected static final String CONTENT_TYPE = "application/json";
	
	/**
	 * 
	 * @Title：handleIp
	 * @Description: TODO(校验IP白名单)
	 * @see：
	 * @param requestIp
	 * @param ipLists
	 * @return
	 */
	protected boolean handleIp(String requestIp, List<String> ipLists) {
		for (String ip : ipLists) {
			if (ip.trim().equals(requestIp)) {
				// ip校验符合
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @Title：handleHttpRequest
	 * @Description: TODO(处理请求返回；Ajax返回json)
	 * @see：
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param msg
	 * @throws IOException
	 */
	protected void handleHttpRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String msg) throws IOException {
		handleHttpRequest(httpServletRequest, httpServletResponse, msg, true);
	}

	protected void handleHttpRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			String msg, boolean judge) throws IOException {
		if (judge) {
			if (!WebUtils.isAjaxRequest(httpServletRequest)) {
				/*普通HTTP请求，进行重定向*/
//				httpServletResponse.sendRedirect("/login/local");
				return;
			}
		}
		httpServletResponse.setCharacterEncoding(ENCODING);
		httpServletResponse.setContentType(CONTENT_TYPE);
		httpServletResponse.getWriter().write(msg);
	}

	/**
	 * 
	 * @Title：sendWeiXinMag
	 * @Description: TODO(发送微信信息，告知非法IP访问) 
	 * @see：
	 * @param msg
	 * @throws Exception
	 */
	protected void sendWeiXinMag(String msg) throws Exception {
		WeiXinMsg weiXinErrorMsg = new WeiXinMsg(GlobalConfig.requestErrorSys, GlobalConfig.requestUser,
				GlobalConfig.receiverName, msg, GlobalConfig.receiverCompany, GlobalConfig.receiverRole, null,
				GlobalConfig.repeatTimes, GlobalConfig.repeatInterval, null, null, null, null, msgConfig.getItDpId(),
				msgConfig.getErrorAgentId());
		SendMsgUtil.sendWX(msgConfig.getWxUrl(), weiXinErrorMsg);
	}

}
