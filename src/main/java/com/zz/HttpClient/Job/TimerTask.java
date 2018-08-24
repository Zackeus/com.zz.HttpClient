package com.zz.HttpClient.Job;

import org.springframework.stereotype.Component;

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

//	@Autowired
//	private MsgConfig msgConfig;
//
//	/**
//	 * 
//	 * @throws Exception
//	 * @Title:closeTask
//	 * @Description: TODO(每天晚上九点半停止智能催收任务)
//	 */
//	@Scheduled(cron = "0 30 21 * * ?")
//	public void stopTask() {
//		try {
//			Object taskId = OdCustomerUtil.judgeStopTaskId(new CollectionRobotTimer());
//			if (ObjectUtils.isEmpty(taskId)) {
//				return;
//			}
//			JuHeHttpUtil.manageTask(new Task(3, new Long(taskId.toString()), 1, null));
//			SendMsgUtil.sendWX(msgConfig.getWxUrl(),
//					new WeiXinMsg(GlobalConfig.requestInfoSys, GlobalConfig.requestUser, GlobalConfig.receiverName,
//							"【裕隆汽车金融】 因已过催收时间，催收任务：" + taskId + " 已被停止", GlobalConfig.receiverCompany,
//							GlobalConfig.receiverRole, null, GlobalConfig.repeatTimes, GlobalConfig.repeatInterval,
//							null, null, null, null, msgConfig.getCollectDpId(), msgConfig.getCollectAgentId()));
//		} catch (Exception e) {
//			WeiXinMsg weiXinErrorMsg = new WeiXinMsg(GlobalConfig.requestErrorSys, GlobalConfig.requestUser,
//					GlobalConfig.receiverName, "【裕隆汽车金融】 停止智能催收任务异常：" + e.getMessage(), GlobalConfig.receiverCompany,
//					GlobalConfig.receiverRole, null, GlobalConfig.repeatTimes, GlobalConfig.repeatInterval, null, null,
//					null, null, msgConfig.getCollectDpId(), msgConfig.getCollectAgentId());
//			try {
//				SendMsgUtil.sendWX(msgConfig.getWxUrl(), weiXinErrorMsg);
//			} catch (Exception e1) {
//				Logs.error("发送微信信息异常：" + e1.getMessage());
//			}
//		}
//	}
//
//	/**
//	 * 
//	 * @Title:cleanFile
//	 * @Description: TODO(每月1号凌晨1点 清理文件数据)
//	 */
//	@Scheduled(cron = "0 0 1 1 * ?")
//	public void cleanFile() {
//
//	}
	
}
