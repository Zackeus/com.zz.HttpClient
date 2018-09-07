package com.zz.HttpClient.modules.businessData.security;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.util.WebUtils;

import com.zz.HttpClient.common.security.BaseFilter;
import com.zz.HttpClient.common.utils.Logs;
import com.zz.HttpClient.common.utils.NetworkUtil;

import net.sf.json.JSONObject;

/**
 * 
 * @Title:DaHanFilter
 * @Description:TODO(大汉三通接口ip白名单校验)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月8日 上午11:43:13
 */
public class DaHanFilter extends BaseFilter {
	
	@Resource(name = "ipWhileListByDaHan")
	private List<String> ipWhileListByDaHan;
	
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) {
    	try {
    		String requestIp = NetworkUtil.getIpAddress(WebUtils.toHttp(request)).trim();
    		if (handleIp(requestIp, ipWhileListByDaHan)) {
    			return true;
			}
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status", "Restricted IP");
			handleHttpRequest(WebUtils.toHttp(request), WebUtils.toHttp(response), jsonObject.toString(), false);
			
			// 发送微信信息
            sendWeiXinMag("【裕隆汽车金融】 " + requestIp + " : 不在大汉三通短信结果推送白名单内");
			return false;
		} catch (Exception e) {
			Logs.error("校验大汉三通IP白名单异常： " + e.getMessage());
			return false;
		}
	}
	
}
