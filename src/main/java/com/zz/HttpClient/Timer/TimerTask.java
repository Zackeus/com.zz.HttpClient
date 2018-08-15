package com.zz.HttpClient.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.Config.GlobalConfig;
import com.zz.HttpClient.Config.JuHeConfig;
import com.zz.HttpClient.Config.MsgConfig;
import com.zz.HttpClient.Service.SendOdCuaranteeService;
import com.zz.HttpClient.Service.SendOdCustomerService;
import com.zz.HttpClient.Util.JuHeHttpUtil;
import com.zz.HttpClient.Util.Logs;
import com.zz.HttpClient.Util.ObjectUtils;
import com.zz.HttpClient.Util.SendMsgUtil;
import com.zz.HttpClient.Bean.Task;
import com.zz.HttpClient.Bean.Msg.WeiXinMsg;

/**
 * 
 * @Title:TimerTask
 * @Description:TODO(定时任务)
 * @Company:
 * @author zhou.zhang
 * @date 2018年7月20日 上午11:14:18
 */
@Component
public class TimerTask {

	// 借款人发送标签
	private static String sendCustomerBatch;

	// 担保人发送标签
	private static String sendGuaranteeBatch;

	@Autowired
	private JuHeConfig juHeConfig;

	@Autowired
	private MsgConfig msgConfig;

	@Autowired
	private SendOdCustomerService sendOdCustomerService;

	@Autowired
	private SendOdCuaranteeService sendOdCuaranteeService;

	/**
	 * 
	 * @Title:sendOdCustomer
	 * @Description: TODO(星期一到星期五的早晨8:00至晚上20：00每隔半小时执行一次)
	 */
	@Scheduled(cron = "0 0/30 8-20 * * ?")
	// @Scheduled(cron = "0 0/30 8-20 ? * MON-FRI")
	public void sendOdCustomer() {
		try {
			switch (OdCustomerUtil.judgeSendBatch(sendOdCustomerService, juHeConfig.getBorrower())) {
			case GlobalConfig.firstTime:
				sendCustomerBatch = GlobalConfig.firstTime;
				break;

			case GlobalConfig.secondTime:
				sendCustomerBatch = GlobalConfig.secondTime;
				break;

			case GlobalConfig.thirdTime:
				sendCustomerBatch = GlobalConfig.thirdTime;
				break;

			case GlobalConfig.fouthTime:
				sendCustomerBatch = GlobalConfig.fouthTime;
				break;

			default:
				return;
			}
			OdCustomerUtil.createTask(sendOdCustomerService, "17037", sendCustomerBatch, juHeConfig.getBorrower());
		} catch (Exception e) {
			Logs.error("智能催收类别判断异常：" + e.getMessage());
			WeiXinMsg weiXinErrorMsg = new WeiXinMsg(GlobalConfig.requestErrorSys, GlobalConfig.requestUser,
					GlobalConfig.receiverName, "【裕隆汽车金融】 创建智能催收-借款人任务异常：" + e.getMessage(), GlobalConfig.receiverCompany,
					GlobalConfig.receiverRole, null, GlobalConfig.repeatTimes, GlobalConfig.repeatInterval, null, null,
					null, null, msgConfig.getCollectDpId(), msgConfig.getCollectAgentId());
			e.printStackTrace();
			try {
				SendMsgUtil.sendWX(msgConfig.getWxUrl(), weiXinErrorMsg);
			} catch (Exception e1) {
				Logs.error("发送微信信息异常：" + e1.getMessage());
			}
		}
	}

	/**
	 * 
	 * @throws Exception
	 * @Title:sendOdGuarantee
	 * @Description: TODO(电催逾期保证人)
	 */
	@Scheduled(cron = "0 0/30 9-19 * * ?")
	public void sendOdGuarantee() {
		try {
			switch (OdGuaranteeUtil.judgeSendBatch(sendOdCuaranteeService, juHeConfig.getBorrower())) {
			case GlobalConfig.firstGime:
				sendGuaranteeBatch = GlobalConfig.firstGime;
				break;

			case GlobalConfig.secondGime:
				sendGuaranteeBatch = GlobalConfig.secondGime;
				break;

			case GlobalConfig.thirdGime:
				sendGuaranteeBatch = GlobalConfig.thirdGime;
				break;

			case GlobalConfig.fouthGime:
				sendGuaranteeBatch = GlobalConfig.fouthGime;
				break;

			default:
				return;
			}
			OdGuaranteeUtil.createTask(sendOdCuaranteeService, "17037", sendGuaranteeBatch, juHeConfig.getBorrower());
		} catch (Exception e) {
			Logs.error("智能催收类别判断异常：" + e.getMessage());
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

	/**
	 * 
	 * @throws Exception
	 * @Title:closeTask
	 * @Description: TODO(每天晚上九点半停止智能催收任务)
	 */
	@Scheduled(cron = "0 30 21 * * ?")
	public void stopTask() {
		try {
			Object taskId = OdCustomerUtil.judgeStopTaskId(sendOdCustomerService, juHeConfig.getBorrower());
			if (ObjectUtils.isEmpty(taskId)) {
				return;
			}
			JuHeHttpUtil.manageTask(new Task(3, new Long(taskId.toString()), 1, null));
			SendMsgUtil.sendWX(msgConfig.getWxUrl(),
					new WeiXinMsg(GlobalConfig.requestInfoSys, GlobalConfig.requestUser, GlobalConfig.receiverName,
							"【裕隆汽车金融】 因已过催收时间，催收任务：" + taskId + " 已被停止", GlobalConfig.receiverCompany,
							GlobalConfig.receiverRole, null, GlobalConfig.repeatTimes, GlobalConfig.repeatInterval,
							null, null, null, null, msgConfig.getCollectDpId(), msgConfig.getCollectAgentId()));
		} catch (Exception e) {
			WeiXinMsg weiXinErrorMsg = new WeiXinMsg(GlobalConfig.requestErrorSys, GlobalConfig.requestUser,
					GlobalConfig.receiverName, "【裕隆汽车金融】 停止智能催收任务异常：" + e.getMessage(), GlobalConfig.receiverCompany,
					GlobalConfig.receiverRole, null, GlobalConfig.repeatTimes, GlobalConfig.repeatInterval, null, null,
					null, null, msgConfig.getCollectDpId(), msgConfig.getCollectAgentId());
			try {
				SendMsgUtil.sendWX(msgConfig.getWxUrl(), weiXinErrorMsg);
			} catch (Exception e1) {
				Logs.error("发送微信信息异常：" + e1.getMessage());
			}
		}
	}

	/**
	 * 
	 * @Title:cleanFile
	 * @Description: TODO(每月1号凌晨1点 清理文件数据)
	 */
	@Scheduled(cron = "0 0 1 1 * ?")
	public void cleanFile() {

	}
}
