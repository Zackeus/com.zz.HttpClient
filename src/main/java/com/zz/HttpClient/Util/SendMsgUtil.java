package com.zz.HttpClient.Util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.zz.HttpClient.Bean.HttpClient.HttpClientResult;
import com.zz.HttpClient.Bean.Msg.SMSMag;
import com.zz.HttpClient.Bean.Msg.WeiXinMsg;
import com.zz.HttpClient.Util.HttpClient.HttpClientUtil;

import net.sf.json.JSONObject;

/**
 * 发送信息工具类
 * 
 * @author zhou.zhang
 *
 */
public class SendMsgUtil {
	
	/**
	 * 发送短信信息
	 * @param url 短信提交接口地址
	 * @param smsMag 短信信息实体类
	 * @return
	 * @throws  
	 * @throws Exception
	 */
	public static HttpClientResult sendSMS(String url, SMSMag smsMag) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// 利用反射获取当前类和父类的所有属性
		Field[] fields = FieldUtils.getAllFields(smsMag.getClass());
		for (Field field : fields) {
			field.setAccessible(true);
			Object value = field.get(smsMag);
			if (!ObjectUtils.isEmpty(value)) {
				map.put(field.getName(), value);
			}
		}
		return HttpClientUtil.doPostJson(url, JSONObject.fromObject(map));
	}

	/**
	 * 发送微信信息
	 * @param url 微信提交接口地址
	 * @param weiXinMsg 微信信息实体类
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult sendWX(String url, WeiXinMsg weiXinMsg) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// 利用反射获取当前类和父类的所有属性
		Field[] fields = FieldUtils.getAllFields(weiXinMsg.getClass());
		for (Field field : fields) {
			field.setAccessible(true);
			Object value = field.get(weiXinMsg);
			if (!ObjectUtils.isEmpty(value)) {
				map.put(field.getName(), value);
			}
		}
		return HttpClientUtil.doPostJson(url, JSONObject.fromObject(map));
	}
}
