package com.zz.HttpClient.modules.timer.jobClass;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.common.config.GlobalConfig;
import com.zz.HttpClient.common.config.JuHeConfig;
import com.zz.HttpClient.common.config.MsgConfig;
import com.zz.HttpClient.common.entity.msg.WeiXinMsg;
import com.zz.HttpClient.common.utils.Logs;
import com.zz.HttpClient.common.utils.ObjectUtils;
import com.zz.HttpClient.common.utils.SendMsgUtil;
import com.zz.HttpClient.common.utils.StringUtils;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.modules.timer.service.CollectionRobotTimerService;
import com.zz.HttpClient.modules.timer.utils.OdMainUtil;

/**
 * 
 * @Title:CollectionRobotTimer
 * @Description:TODO(催收机器人排程任务)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月22日 上午8:26:50
 */
@Component
public class CollectionRobotJob implements Job {

	@Autowired
	private JuHeConfig juHeConfig;
	
	@Autowired
	private MsgConfig msgConfig;
	
	@Autowired
	private OdMainUtil odMainUtil;

	@Autowired
	private CollectionRobotTimerService collectionRobotTimerService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		CollectionRobotTimer collectionRobotTimer = collectionRobotTimerService
				.get(context.getJobDetail().getKey().getName());

		if (ObjectUtils.isEmpty(collectionRobotTimer)
				|| StringUtils.isEmpty(collectionRobotTimer.getCustomerStyle().getName())) {
			WeiXinMsg weiXinErrorMsg = new WeiXinMsg(GlobalConfig.requestErrorSys, GlobalConfig.requestUser,
					GlobalConfig.receiverName, "【裕隆汽车金融】 催收排程创建异常：判断信息为空", GlobalConfig.receiverCompany,
					GlobalConfig.receiverRole, null, GlobalConfig.repeatTimes, GlobalConfig.repeatInterval, null, null,
					null, null, msgConfig.getCollectDpId(), msgConfig.getCollectAgentId());
			try {
				SendMsgUtil.sendWX(msgConfig.getWxUrl(), weiXinErrorMsg);
			} catch (Exception e) {
				Logs.error("发送微信信息异常：" + e.getMessage());
			}
			return;
		}

		if (StringUtils.equals(juHeConfig.getBorrower(), collectionRobotTimer.getCustomerStyle().getName())) {
			// 创建借款人催收任务
			try {
				odMainUtil.sendOdCustomer(collectionRobotTimer);
			} catch (Exception e) {
				Logs.error("创建借款人催收任务失败：" + e.getMessage());
				WeiXinMsg weiXinErrorMsg = new WeiXinMsg(GlobalConfig.requestErrorSys, GlobalConfig.requestUser,
						GlobalConfig.receiverName, "【裕隆汽车金融】 创建智能催收-借款人任务异常：" + e.getMessage(), GlobalConfig.receiverCompany,
						GlobalConfig.receiverRole, null, GlobalConfig.repeatTimes, GlobalConfig.repeatInterval, null, null,
						null, null, msgConfig.getCollectDpId(), msgConfig.getCollectAgentId());
				try {
					SendMsgUtil.sendWX(msgConfig.getWxUrl(), weiXinErrorMsg);
				} catch (Exception e1) {
					Logs.error("发送微信信息异常：" + e1.getMessage());
				}
			}
		} else {
			// 创建担保人催收任务
			try {
				odMainUtil.sendOdGuarantee(collectionRobotTimer);
			} catch (Exception e) {
				Logs.error("创建保证人催收任务失败：" + e.getMessage());
				WeiXinMsg weiXinErrorMsg = new WeiXinMsg(GlobalConfig.requestErrorSys, GlobalConfig.requestUser,
						GlobalConfig.receiverName, "【裕隆汽车金融】 创建智能催收-担保人任务异常：" + e.getMessage(), GlobalConfig.receiverCompany,
						GlobalConfig.receiverRole, null, GlobalConfig.repeatTimes, GlobalConfig.repeatInterval, null, null,
						null, null, msgConfig.getCollectDpId(), msgConfig.getCollectAgentId());
				try {
					SendMsgUtil.sendWX(msgConfig.getWxUrl(), weiXinErrorMsg);
				} catch (Exception e1) {
					Logs.error("发送微信信息异常：" + e1.getMessage());
				}
			}
		}
	}

}
