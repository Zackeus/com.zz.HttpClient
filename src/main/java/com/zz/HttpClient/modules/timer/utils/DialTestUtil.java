package com.zz.HttpClient.modules.timer.utils;

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
		// 待呼叫数据
		List<Customer> customers = sendDialTestService.getDialTestCustomer(dialTestTimer);
		
		TaskConfig taskConfig = new TaskConfig(null, null,
				"催收拨号测试" + DateUtils.getDate(DateUtils.parsePatterns[0]) + "DT-1", null, null, null,
				null, null, null, null, juHeConfig.getTelGuaranteeNum(), null, null, null, 0, 60, null);
		
		try {
			HttpClientResult httpClientResult = JuHeHttpUtil.createCustomerTask(customers, taskConfig);
			
			if (JSONObject.fromObject(httpClientResult.getContent()).getInt("code") == 0) {
				// 任务创建成功 数据写入数据库
				String taskId = JSONObject.fromObject(httpClientResult.getContent()).getJSONObject("result")
						.getJSONArray("rows").getJSONObject(0).getString("taskId");
				sendDialTestService.insertInfo(taskId, "17037", "DT-1", customers, dialTestTimer);
			} else {
				// 任务创建失败
				throw new MyException("【裕隆汽车金融】 定时任务【" + dialTestTimer.getJobName() + "】【" + 
						dialTestTimer.getName() + "】创建失败");
			}
		} catch (Exception e) {
			throw new MyException("催收拨号测试任务异常：" + Logs.toLog(e));
		}
	}

}
