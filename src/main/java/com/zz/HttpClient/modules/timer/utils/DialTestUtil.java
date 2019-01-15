package com.zz.HttpClient.modules.timer.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.common.config.JuHeConfig;
import com.zz.HttpClient.common.entity.HttpClientResult;
import com.zz.HttpClient.common.utils.DateUtils;
import com.zz.HttpClient.common.utils.Logs;
import com.zz.HttpClient.common.utils.exception.MyException;
import com.zz.HttpClient.modules.timer.entity.DialTestTimer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.Customer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.TaskConfig;
import com.zz.HttpClient.modules.timer.service.SendDialTestService;

import net.sf.json.JSONObject;

/**
 * 
 * @Title:DialTestUtil
 * @Description:TODO(催收拨号测试任务主类)
 * @Company: 
 * @author zhou.zhang
 * @date 2019年1月14日 下午4:31:11
 */
@Component
public class DialTestUtil {
	
	@Autowired
	private JuHeConfig juHeConfig;
	
	@Autowired
	private SendDialTestService sendDialTestService;
	
	public void createTask(DialTestTimer dialTestTimer) {
		// 发送标签
		String sendBeanch = "DT-1";
		
		// 待呼叫数据
//		List<Customer> customers = sendDialTestService.getDialTestCustomer(dialTestTimer);
		List<Customer> customers = new ArrayList<>();
		Customer customer = new Customer(null, "HP116175", "张舟", "借款人", new Long("15058041631"), 
				new Long("24"), new BigDecimal("2536.4"), "邮寄地", "17037", null, null, null, null);
		customers.add(customer);
		
		// 创建任务配置
		TaskConfig taskConfig = createTaskConfig(sendBeanch);
		
		try {
			HttpClientResult httpClientResult = JuHeHttpUtil.createTask(customers, Customer.class, taskConfig);
			
			if (JSONObject.fromObject(httpClientResult.getContent()).getInt("code") == 0) {
				// 任务创建成功 数据写入数据库
				String taskId = JSONObject.fromObject(httpClientResult.getContent()).getJSONObject("result")
						.getJSONArray("rows").getJSONObject(0).getString("taskId");
				sendDialTestService.insertInfo(taskId, "17037", sendBeanch, customers, dialTestTimer);
			} else {
				// 任务创建失败
				throw new MyException("【裕隆汽车金融】 定时任务【" + dialTestTimer.getJobName() + "】【" + 
						dialTestTimer.getName() + "】创建失败");
			}
		} catch (Exception e) {
			throw new MyException("催收拨号测试任务异常：" + Logs.toLog(e));
		}
	}
	
	/**
	 * 
	 * @Title：createTaskConfig
	 * @Description: TODO(创建任务配置)
	 * @see：
	 * @param sendBeanch 发送标签
	 * @return
	 */
	private TaskConfig createTaskConfig(String sendBeanch) {
		return new TaskConfig(
				null, 																		// 文件名																		
				null,																		// 组织文件名
				"催收拨号测试" + DateUtils.getDate(DateUtils.parsePatterns[0]) + sendBeanch,   // 任务名称
				System.currentTimeMillis(), 												// 开始时间
				DateUtils.getTimesnight(21), 												// 截至时间
				juHeConfig.getSpeechSkillId(), 												// 话术编号
				juHeConfig.getRobotVoiceId(), 												// 发音人编号
				80, 																		// 语速
				0, 																			// 机器人外呼类型 0 呼出
				null, 																		// 号码类型 1 普通号码 2 轮显号码 默认 1
				juHeConfig.getTelNumThird(), 												// 外呼号码(外显)
				juHeConfig.getSysType(), 													// 系统标签								
				juHeConfig.getTimeRange(), 													// 外呼时间段控制
				1, 																			// 并行数
				0, 																			// 最大重复外呼次数
				60, 																		// 重复外呼等待时间
				juHeConfig.getRecallStatus());												// 重复外呼状态
	}

}
