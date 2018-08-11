package com.zz.HttpClient.Timer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.Bean.HttpClient.HttpClientResult;
import com.zz.HttpClient.Bean.Msg.WeiXinMsg;
import com.zz.HttpClient.Config.GlobalConfig;
import com.zz.HttpClient.Config.JuHeConfig;
import com.zz.HttpClient.Config.MsgConfig;
import com.zz.HttpClient.Service.SendOdCuaranteeService;
import com.zz.HttpClient.Util.DateUtils;
import com.zz.HttpClient.Util.JuHeHttpUtil;
import com.zz.HttpClient.Util.ListUtil;
import com.zz.HttpClient.Util.ObjectUtils;
import com.zz.HttpClient.Util.SendMsgUtil;
import com.zz.HttpClient.Bean.CollectionTel;
import com.zz.HttpClient.Bean.Guarantee;
import com.zz.HttpClient.Bean.ReplaySet;
import com.zz.HttpClient.Bean.TaskConfig;

import net.sf.json.JSONObject;

/**
 * 
 * @Title:OdGuaranteeUtil
 * @Description:TODO(电催保证人根据类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月3日 下午2:09:21
 */
@Component
public class OdGuaranteeUtil {
	
	@Autowired
	private JuHeConfig juHeConfig;

	@Autowired
	private MsgConfig msgConfig;

	public static OdGuaranteeUtil odGuaranteeUtil;

	/**
	 * 
	 * @Title:init
	 * @Description: TODO(初始化的时候，将本类中的配置变量赋值给静态的本类变量)
	 */
	@PostConstruct
	public void init() {
		odGuaranteeUtil = this;
	}
	
	/**
	 * 
	 * @Title:judgeSendBatch
	 * @Description: TODO(判断发送标签)
	 * @param sendOdCuaranteeService
	 * @param rtype
	 * @return
	 * @throws Exception
	 */
	public static String judgeSendBatch(SendOdCuaranteeService sendOdCuaranteeService, String rtype) throws Exception {
		ReplaySet replaySet = sendOdCuaranteeService.getReplaySet(rtype);
		CollectionTel collectionTel = OdCustomerUtil.getCollectionTel(odGuaranteeUtil.juHeConfig.getTelGuaranteeNum());

		if ((replaySet == null || replaySet.getFirstTaskId() == null) && collectionTel.getUsed() == 0) {
			// 为 G-1
			return GlobalConfig.firstGime;
		}

		if (replaySet.getSecondTaskId() == null && collectionTel.getUsed() == 0) {
			// 为 G-2
			return GlobalConfig.secondGime;
		}

		if (replaySet.getThirdTaskId() == null && collectionTel.getUsed() == 0) {
			// 为 G-3
			return GlobalConfig.thirdGime;
		}

		if (replaySet.getFourthTaskId() == null && collectionTel.getUsed() == 0) {
			// 为 G-4
			return GlobalConfig.fouthGime;
		}
		return "T";
	}
	
	/**
	 * 
	 * @Title:getTaskData
	 * @Description: TODO(处理提交任务数据)
	 * @param sendOdCuaranteeService
	 * @param requestEmpno
	 * @param sendBatch
	 * @param rtype
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getTaskData(SendOdCuaranteeService sendOdCuaranteeService, String sendBatch) {
		Map<String, Object> taskMap = new HashMap<>();
		// 待提交数据
		List<Guarantee> guarantees = new ArrayList<>();
		// 任务配置
		TaskConfig taskConfig = new TaskConfig();
		
		switch (sendBatch) {
		case GlobalConfig.firstGime:
			// G-1
			guarantees = (List<Guarantee>) ListUtil.getSplitList(sendOdCuaranteeService.getOverdueGuarantee()).get("list");
			taskConfig = new TaskConfig(null, null,
					"裕隆催收" + DateUtils.getDate(DateUtils.parsePatterns[0]) + GlobalConfig.firstGime, null, null, null,
					null, null, null, null, odGuaranteeUtil.juHeConfig.getTelGuaranteeNum(), null, null, null, 0, 60, null);
			break;

		case GlobalConfig.secondGime:
			// G-2
			guarantees = sendOdCuaranteeService.getReplayGuarantee(GlobalConfig.firstGime);
			taskConfig = new TaskConfig(null, null,
					"裕隆催收" + DateUtils.getDate(DateUtils.parsePatterns[0]) + GlobalConfig.secondGime, null, null, null,
					null, null, null, null, odGuaranteeUtil.juHeConfig.getTelGuaranteeNum(), null, null, null, 1, 5, null);
			break;

		case GlobalConfig.thirdGime:
			// G-3
			guarantees = sendOdCuaranteeService.getReplayGuarantee(GlobalConfig.secondGime);
			taskConfig = new TaskConfig(null, null,
					"裕隆催收" + DateUtils.getDate(DateUtils.parsePatterns[0]) + GlobalConfig.thirdGime, null, null, null,
					null, null, null, null, odGuaranteeUtil.juHeConfig.getTelGuaranteeNum(), null, null, null, 1, 5, null);
			break;

		case GlobalConfig.fouthGime:
			// G-4
			guarantees = sendOdCuaranteeService.getReplayGuarantee(GlobalConfig.thirdGime);
			taskConfig = new TaskConfig(null, null,
					"裕隆催收" + DateUtils.getDate(DateUtils.parsePatterns[0]) + GlobalConfig.fouthGime, null, null, null,
					null, null, null, null, odGuaranteeUtil.juHeConfig.getTelGuaranteeNum(), null, null, null, 2, 5, null);
			break;

		default:
			break;
		}
		
		taskMap.put("dataList", guarantees);
		taskMap.put("taskConfig", taskConfig);
		return taskMap;
	}
	
	/**
	 * 
	 * @Title:createTask
	 * @Description: TODO(创建任务)
	 * @param sendOdCustomerService
	 * @param requestEmpno
	 * @param sendBatch
	 * @param rtype
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static void createTask(SendOdCuaranteeService sendOdCuaranteeService, String requestEmpno, String sendBatch,
			String rtype) throws Exception {
		// 待发送的微信信息
		WeiXinMsg weiXinMsg = new WeiXinMsg(GlobalConfig.requestInfoSys, GlobalConfig.requestUser,
				GlobalConfig.receiverName, null, GlobalConfig.receiverCompany, GlobalConfig.receiverRole, null,
				GlobalConfig.repeatTimes, GlobalConfig.repeatInterval, null, null, null, null,
				odGuaranteeUtil.msgConfig.getCollectDpId(), odGuaranteeUtil.msgConfig.getCollectAgentId());
		
		Map<String, Object> taskMap = getTaskData(sendOdCuaranteeService, sendBatch);
		List<Guarantee> guarantees = (List<Guarantee>) taskMap.get("dataList");
		
		if (ObjectUtils.isEmpty(guarantees)) {
			// 提交信息为空
			return;
		}
		
		HttpClientResult httpClientResult = JuHeHttpUtil.createGuaranteeTask(guarantees, (TaskConfig) taskMap.get("taskConfig"));
		
		if (JSONObject.fromObject(httpClientResult.getContent()).getInt("code") == 0) {
			// 任务创建成功 数据写入数据库
			String taskId = JSONObject.fromObject(httpClientResult.getContent()).getJSONObject("result")
					.getJSONArray("rows").getJSONObject(0).getString("taskId");

			sendOdCuaranteeService.insertCollectionInfo(taskId, requestEmpno, sendBatch, guarantees);

			weiXinMsg.setMsg_content("【裕隆汽车金融】 智能催收-担保人任务创建成功；TaskId: " + taskId + "; SendBatch: " + sendBatch);
			SendMsgUtil.sendWX(odGuaranteeUtil.msgConfig.getWxUrl(), weiXinMsg);
		} else {
			weiXinMsg.setMsg_content("【裕隆汽车金融】 智能催收-担保人任务创建失败");
			weiXinMsg.setRequest_sys(GlobalConfig.requestErrorSys);
			SendMsgUtil.sendWX(odGuaranteeUtil.msgConfig.getWxUrl(), weiXinMsg);
		}
	}

}
