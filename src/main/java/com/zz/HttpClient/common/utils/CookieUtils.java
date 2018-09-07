package com.zz.HttpClient.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @Title:CookieUtils
 * @Description:TODO(CookieUtils)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月15日 上午9:29:18
 */
public class CookieUtils {
	
	/**
	 * 
	 * @Title：setCookie
	 * @Description: TODO(设置 Cookie（生成时间为1天）)
	 * @see：
	 * @param response
	 * @param name 名称
	 * @param value 值
	 */
	public static void setCookie(HttpServletResponse response, String name, String value) {
		setCookie(response, name, value, 60*60*24);
	}
	
	/**
	 * 
	 * @Title：setCookie
	 * @Description: TODO(设置 Cookie)
	 * @see：
	 * @param response
	 * @param name 名称
	 * @param value 值
	 * @param path 路径
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, String path) {
		setCookie(response, name, value, path, 60*60*24);
	}
	
	/**
	 * 
	 * @Title：setCookie
	 * @Description: TODO(设置 Cookie)
	 * @see：
	 * @param response
	 * @param name 名称
	 * @param value 值
	 * @param maxAge 路径
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
		setCookie(response, name, value, "/", maxAge);
	}
	
	/**
	 * 
	 * @Title：setCookie
	 * @Description: TODO(设置 Cookie)
	 * @see：
	 * @param response
	 * @param name 名称
	 * @param value 值
	 * @param path 路径
	 * @param maxAge 生存时间（单位秒）
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, String path, int maxAge) {
		Cookie cookie = new Cookie(name, null);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		try {
			cookie.setValue(URLEncoder.encode(value, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.addCookie(cookie);
	}
	
	/**
	 * 
	 * @Title：getCookie
	 * @Description: TODO(获得指定Cookie的值)
	 * @see：
	 * @param request 名称
	 * @param name 值
	 * @return
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		return getCookie(request, null, name, false);
	}
	
	/**
	 * 
	 * @Title：getCookie
	 * @Description: TODO(获得指定Cookie的值，并删除。)
	 * @see：
	 * @param request
	 * @param response
	 * @param name 名称
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name) {
		return getCookie(request, response, name, true);
	}
	
	/**
	 * 
	 * @Title：getCookie
	 * @Description: TODO(获得指定Cookie的值)
	 * @see：
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param name 名字
	 * @param isRemove 是否移除
	 * @return 值
	 */
	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name, boolean isRemove) {
		String value = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					try {
						value = URLDecoder.decode(cookie.getValue(), "utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					if (isRemove) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}
		return value;
	}

}
