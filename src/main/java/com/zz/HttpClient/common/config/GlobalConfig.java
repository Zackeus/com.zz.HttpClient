package com.zz.HttpClient.common.config;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.zz.HttpClient.common.utils.PropertiesLoader;

/**
 * 
 * @Title:GlobalConfig
 * @Description:TODO(通用配置类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年7月20日 下午4:34:45
 */
@Component
public class GlobalConfig {
	
	/**
	 * 当前对象实例
	 */
	private static GlobalConfig globalConfig = new GlobalConfig();
	
	/**
	 * 全局属性值
	 */
	private static Map<String, String> map = Maps.newHashMap();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("properties/jdbc.properties");
	
	/**
	 * 显示/隐藏
	 */
	public static final String SHOW = "1";
	public static final String HIDE = "0";

	/**
	 * 是/否
	 */
	public static final String YES = "1";
	public static final String NO = "0";
	
	/**
	 * 对/错
	 */
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	
	/**
	 * 
	 * @Title:getInstance
	 * @Description: TODO(获取当前对象实例)
	 * @return
	 */
	public static GlobalConfig getInstance() {
		return globalConfig;
	}
	
	/**
	 * 
	 * @Title:getConfig
	 * @Description: TODO(获取配置)
	 * @param key
	 * @return
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = loader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}
	
	
	public static final String firstTime = "T-1";
	
	public static final String secondTime = "T-2";
	
	public static final String thirdTime = "T-3";
	
	public static final String fouthTime = "T-4";
	
	public static final String firstGime = "G-1";
	
	public static final String secondGime = "G-2";
	
	public static final String thirdGime = "G-3";
	
	public static final String fouthGime = "G-4";
	
	// 据合速驰上传文件路径
	public static String filePath = "D:/JuHe/";
	
	public static String requestErrorSys = "Error";
	
	public static String requestInfoSys = "Info";
	
	public static String requestUser = "zhangzhou";
	
	public static String receiverName = "张舟";
	
	public static String receiverCompany = "裕隆汽车金融(中国)有限公司";
	
	public static String receiverRole = "运维工程师";
	
	public static Integer repeatTimes = 1;
	
	public static Integer repeatInterval = 60;

}
