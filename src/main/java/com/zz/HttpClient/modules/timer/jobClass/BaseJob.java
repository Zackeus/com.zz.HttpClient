package com.zz.HttpClient.modules.timer.jobClass;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.zz.HttpClient.common.config.GlobalConfig;
import com.zz.HttpClient.common.config.MsgConfig;
import com.zz.HttpClient.common.entity.msg.WeiXinMsg;
import com.zz.HttpClient.common.utils.Logs;
import com.zz.HttpClient.common.utils.ObjectUtils;
import com.zz.HttpClient.common.utils.SendMsgUtil;
import com.zz.HttpClient.common.utils.exception.MyException;
import com.zz.HttpClient.common.utils.httpClient.HttpStatus;
import com.zz.HttpClient.modules.timer.entity.CommonTimer;
import com.zz.HttpClient.modules.timer.service.CommonTimerService;

/**
 * 
 * @Title:BaseJob
 * @Description:TODO(定时任务基类)
 * @Company:
 * @author zhou.zhang
 * @date 2018年12月13日 上午9:53:49
 */
public abstract class BaseJob implements Job {
	
	// 定时任务名
	protected String jobFunction = "未定义";
	
	// 是否需要更新结果
	protected boolean isUpdateRes = Boolean.TRUE;

	@Autowired
	protected CommonTimerService commonTimerService;

	@Autowired
	protected MsgConfig msgConfig;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String jobName = context.getJobDetail().getKey().getName();
		Exception exception = null;
		try {
			initParameter();
			boolean continueChain = preHandle(jobName);
			if (continueChain)
				executeJob(jobName);
			afterHandle(jobName);
		} catch (Exception e) {
			exception = e;
		} finally {
			cleanup(jobName, exception);
		}
	}
	
	/**
	 * 
	 * @Title：initParameter
	 * @Description: TODO(初始化参数)
	 * @see：
	 */
	protected void initParameter() {
		
	}

	/**
	 * 
	 * @Title：preHandle
	 * @Description: TODO(前置操作) @see：
	 * @param jobName
	 * @return
	 */
	protected boolean preHandle(String jobName) {
		CommonTimer commonTimer = commonTimerService.get(jobName);
		// 是否异常重启
		if (commonTimer.isRestart())
			return !commonTimerService.isSuccess(jobName);
		return Boolean.TRUE;
	}

	/**
	 * 
	 * @Title：executeJob
	 * @Description: TODO(执行任务) @see：
	 * @param jobName
	 */
	protected void executeJob(String jobName) {

	}

	/**
	 * 
	 * @Title：afterHandle
	 * @Description: TODO(后置操作) @see：
	 */
	protected void afterHandle(String jobName) {
		if (isUpdateRes) {
			commonTimerService.updateRes(jobName, Boolean.TRUE);
		}
	}

	/**
	 * 
	 * @Title：cleanup
	 * @Description: TODO(异常处理) @see：
	 * @param e
	 * @throws JobExecutionException
	 * @throws Exception
	 */
	protected void cleanup(String jobName, Exception e) throws JobExecutionException {
		if (ObjectUtils.isNotEmpty(e)) {
			Logs.error(jobName + " :定时任务异常：" + Logs.toLog(e));
			
			if (isUpdateRes) {
				commonTimerService.updateRes(jobName, Boolean.FALSE);
			}
			
			WeiXinMsg weiXinErrorMsg = new WeiXinMsg(GlobalConfig.requestErrorSys, GlobalConfig.requestUser,
					GlobalConfig.receiverName, "【裕隆汽车金融】 定时任务【" + jobName + "】【" + 
							jobFunction + "】执行异常：" + e.getMessage(),
					GlobalConfig.receiverCompany, GlobalConfig.receiverRole, null, GlobalConfig.repeatTimes,
					GlobalConfig.repeatInterval, null, null, null, null, msgConfig.getItDpId(),
					msgConfig.getTimerAgentId());
			try {
				sendErrorMsg(weiXinErrorMsg);
			} catch (Exception e1) {
				throw new JobExecutionException(Logs.toLog(e));
			}
			throw new JobExecutionException(Logs.toLog(e));
		}
	}

	/**
	 * 
	 * @Title：sendErrorMsg
	 * @Description: TODO(发送微信异常报警信息) @see：
	 * @param weiXinErrorMsg
	 * @throws Exception
	 */
	protected void sendErrorMsg(WeiXinMsg weiXinErrorMsg) {
		try {
			SendMsgUtil.sendWX(msgConfig.getWxUrl(), weiXinErrorMsg);
		} catch (Exception e) {
			Logs.error("发送微信报警信息异常：" + Logs.toLog(e));
			throw new MyException(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "发送微信报警信息异常：" + e.toString());
		}
	}

}
