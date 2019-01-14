package com.zz.HttpClient.modules.timer.jobClass;

import org.quartz.DisallowConcurrentExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.common.config.GlobalConfig;
import com.zz.HttpClient.common.entity.msg.WeiXinMsg;
import com.zz.HttpClient.common.utils.ObjectUtils;
import com.zz.HttpClient.modules.timer.entity.DialTestTimer;
import com.zz.HttpClient.modules.timer.service.DialTestTimerService;
import com.zz.HttpClient.modules.timer.utils.DialTestUtil;

/**
 * 
 * @Title:DialTestJob
 * @Description:TODO(催收拨号测试排程任务)
 * @Company: 
 * @author zhou.zhang
 * @date 2019年1月13日 下午2:35:40
 */
@Component
@DisallowConcurrentExecution
public class DialTestJob extends BaseJob {
	
	@Autowired
	DialTestTimerService dialTestTimerService;
	
	@Autowired
	DialTestUtil dialTestUtil;
	
	/**
	 * 初始化参数
	 */
	@Override
	protected void initParameter() {
		jobFunction = "催收拨打测试";
		isUpdateRes = Boolean.FALSE;
	}
	
	/**
	 * 前置操作
	 */
	@Override
	protected boolean preHandle(String jobName) {
		return Boolean.TRUE;
	}
	
	/**
	 * 任务执行
	 */
	@Override
	protected void executeJob(String jobName) {
		DialTestTimer dialTestTimer = dialTestTimerService.get(jobName);
		
		if (ObjectUtils.isEmpty(dialTestTimer)) {
			WeiXinMsg weiXinErrorMsg = new WeiXinMsg(GlobalConfig.requestErrorSys, GlobalConfig.requestUser,
					GlobalConfig.receiverName, "【裕隆汽车金融】 定时任务【" + jobName + "】【" + jobFunction + "】创建异常：任务信息为空", 
					GlobalConfig.receiverCompany,GlobalConfig.receiverRole, null, GlobalConfig.repeatTimes, GlobalConfig.repeatInterval, 
					null, null, null, null, msgConfig.getItDpId(), msgConfig.getTimerAgentId());
			sendErrorMsg(weiXinErrorMsg);
			return;
		}
		dialTestUtil.createTask(dialTestTimer);
	}
	
}
