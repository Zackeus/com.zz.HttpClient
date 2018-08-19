package com.zz.HttpClient.Util;

import java.util.Date;

import org.springframework.scheduling.support.CronSequenceGenerator;

/**
 * 
 * @Title:TimerUtil
 * @Description:TODO(定时任务工具类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月17日 上午9:19:57
 */
public class TimerUtil {
	
	/**
	 * 
	 * @Title：getNextTime
	 * @Description: TODO(解析 cron 表达式，获取下次执行时间)
	 * @see：
	 * @param cron
	 */
	public static Date getNextTime(String cron) {
		return new CronSequenceGenerator(cron).next(new Date());
	}

}
