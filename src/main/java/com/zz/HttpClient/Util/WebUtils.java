package com.zz.HttpClient.Util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @Title:WebUtils
 * @Description:TODO(web 工具类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月11日 下午3:35:36
 */
public class WebUtils extends org.apache.shiro.web.util.WebUtils {
	
	public static final String X_REQUESTED_WITH = "x-requested-with";
	
	public static final String XML_HTTP_REQUEST = "XMLHttpRequest";

	/**
	 * 
	 * @Title：isAjaxRequest
	 * @Description: TODO(是否是Ajax请求)
	 * @see：
	 * @param request
	 * @return
	 */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader(X_REQUESTED_WITH);
        if (StringUtils.isNoneEmpty(requestedWith) && StringUtils.equals(requestedWith, XML_HTTP_REQUEST)) {
            return true;
        } else {
            return false;
        }
    }
}