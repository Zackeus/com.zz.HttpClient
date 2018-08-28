package com.zz.HttpClient.Util;

import java.text.ParseException;
import java.util.Date;

import org.quartz.impl.triggers.CronTriggerImpl;
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
	public static String getNextTime(String cron) {
		return DateUtils.formatDateTime(new CronSequenceGenerator(cron).next(new Date()));
	}
	
	/**
	 * 
	 * @Title：isValidExpression
	 * @Description: TODO(判断cron表达式是否有效)
	 * @see：
	 * @param cron
	 * @return
	 */
	public static boolean isValid(String cron) {
        CronTriggerImpl trigger = new CronTriggerImpl();
        try {
			trigger.setCronExpression(cron);
		} catch (ParseException e) {
			return false;
		}
        Date date = trigger.computeFirstFireTime(null);
        return date != null && date.after(new Date());
    }
	
	/**
	 * 
	 * @Title：main
	 * @Description: TODO(测试)
	 * @see：
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		System.out.println(isValid("0/5 * * * * ?"));
	}

}
