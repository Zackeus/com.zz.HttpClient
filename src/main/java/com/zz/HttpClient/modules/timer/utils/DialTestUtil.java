package com.zz.HttpClient.modules.timer.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.common.config.GlobalConfig;
import com.zz.HttpClient.common.config.JuHeConfig;
import com.zz.HttpClient.common.entity.HttpClientResult;
import com.zz.HttpClient.common.utils.DateUtils;
import com.zz.HttpClient.common.utils.Logs;
import com.zz.HttpClient.common.utils.ObjectUtils;
import com.zz.HttpClient.common.utils.StringUtils;
import com.zz.HttpClient.common.utils.exception.MyException;
import com.zz.HttpClient.modules.timer.entity.DialTestTimer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.Customer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.ExplicitNum;
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
		String sendBeanch = getSendBanch();
		if (StringUtils.isBlank(sendBeanch)) {
			// 外显被占用   结束任务
			return;
		}
		
		// 待呼叫数据
		List<Customer> customers = sendDialTestService.getDialTestCustomer(sendBeanch, dialTestTimer);
		if (ObjectUtils.isEmpty(customers)) {
			// 待呼叫数据为空
			Logs.info("【裕隆汽车金融】 定时任务【" + dialTestTimer.getJobName() + "】【" + dialTestTimer.getName() + "】【" +
					sendBeanch + "】任务数据为空");
			return;
		}
		
		// 创建任务配置
		TaskConfig taskConfig = createTaskConfig(sendBeanch);
		
		try {
			HttpClientResult httpClientResult = JuHeHttpUtil.createTask(customers, Customer.class, taskConfig);
			
			if (JSONObject.fromObject(httpClientResult.getContent()).getInt("code") == 0) {
				// 任务创建成功 数据写入数据库
				String taskId = JSONObject.fromObject(httpClientResult.getContent()).getJSONObject("result")
						.getJSONArray("rows").getJSONObject(0).getString("taskId");
				sendDialTestService.insertInfo(taskId, "17037", sendBeanch, customers, dialTestTimer);
//				Logs.info("任务：" + sendBeanch + "创建成功");
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
	
	/**
	 * 
	 * @Title：getSendBanch
	 * @Description: TODO(生成发送标签)
	 * @see：
	 * @return
	 */
	private String getSendBanch() {
		try {
			ExplicitNum explicitNum = JuHeHttpUtil.searchTelOneYeta(juHeConfig.getTelNumThird());
			
			if (ObjectUtils.isEmpty(explicitNum)) {
				throw new MyException("查无此外显号：【" + juHeConfig.getTelNumThird() + "】");
			}
			if (explicitNum.getUsed() == 1) {
				// 此外显已被占用
				return null;
			}
			
			String sendBatchLately = sendDialTestService.getSendBeanch(GlobalConfig.dialTestbatch);
			if (StringUtils.isBlank(sendBatchLately)) {
				return GlobalConfig.dialTestbatch + 1;
			}
			return GlobalConfig.dialTestbatch + (Integer.valueOf(StringUtils.split(sendBatchLately, "-")[1]) + 1);
		} catch (Exception e) {
			throw new MyException(Logs.toLog(e));
		}
	}

}
