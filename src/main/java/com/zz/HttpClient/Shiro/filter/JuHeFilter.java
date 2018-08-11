package com.zz.HttpClient.Shiro.filter;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.util.WebUtils;

import com.zz.HttpClient.Util.Logs;
import com.zz.HttpClient.Util.NetworkUtil;
import com.zz.HttpClient.Bean.Result;
import com.zz.HttpClient.Bean.ReturnInfo;

import net.sf.json.JSONObject;

/**
 * 
 * @Title:JuHeFilter
 * @Description:TODO(据合速驰接口ip白名单校验)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月8日 上午11:43:18
 */
public class JuHeFilter extends BaseFilter {

	@Resource(name = "ipWhileListByJuHe")
	private List<String> ipWhileListByJuHe;

	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) {
		try {
			String requestIp = NetworkUtil.getIpAddress(WebUtils.toHttp(request)).trim();
			if (handleIp(requestIp, ipWhileListByJuHe)) {
				return true;
			}

			handleHttpRequest(WebUtils.toHttp(request), WebUtils.toHttp(response),
					JSONObject.fromObject(new ReturnInfo(-1, "Restricted IP", new Result())).toString(), false);
			// 发送微信信息
			sendWeiXinMag("【裕隆汽车金融】 " + requestIp + " : 不在据合速驰推送催收机器人拨打结果推送白名单内");
			return false;
		} catch (Exception e) {
			Logs.error("校验据合速驰IP白名单异常： " + e.getMessage());
			return false;
		}
	}

}
