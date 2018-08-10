package com.zz.HttpClient.Timer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.Bean.CollectionTel;
import com.zz.HttpClient.Bean.Customer;
import com.zz.HttpClient.Bean.CustomerRepeat;
import com.zz.HttpClient.Bean.ReplaySet;
import com.zz.HttpClient.Bean.TaskConfig;
import com.zz.HttpClient.Bean.HttpClient.HttpClientResult;
import com.zz.HttpClient.Bean.Msg.WeiXinMsg;
import com.zz.HttpClient.Config.GlobalConfig;
import com.zz.HttpClient.Config.JuHeConfig;
import com.zz.HttpClient.Config.MsgConfig;
import com.zz.HttpClient.Service.SendOdCustomerService;
import com.zz.HttpClient.Util.DateUtils;
import com.zz.HttpClient.Util.JuHeHttpUtil;
import com.zz.HttpClient.Util.ListUtil;
import com.zz.HttpClient.Util.ObjectUtils;
import com.zz.HttpClient.Util.SendMsgUtil;

import net.sf.json.JSONObject;

/**
 * 
 * @Title:OdCustomerUtil
 * @Description:TODO(催收借款人工具类)
 * @Company:
 * @author zhou.zhang
 * @date 2018年7月20日 下午3:50:18
 */
@Component
public class OdCustomerUtil {

	@Resource(name = "juHeConfig")
	private JuHeConfig juHeConfig;

	@Resource(name = "msgConfig")
	private MsgConfig msgConfig;

	public static OdCustomerUtil odCustomerUtil;

	/**
	 * 
	 * @Title:init
	 * @Description: TODO(初始化的时候，将本类中的配置变量赋值给静态的本类变量)
	 */
	@PostConstruct
	public void init() {
		odCustomerUtil = this;
		odCustomerUtil.juHeConfig = this.juHeConfig;
		odCustomerUtil.msgConfig = this.msgConfig;
	}

	/**
	 * 
	 * @Title:judgeSendBatch
	 * @Description: TODO(判断发送标签)
	 * @param juHeService
	 * @return
	 * @throws Exception
	 */
	public static String judgeSendBatch(SendOdCustomerService sendOdCustomerService, String rtype) throws Exception {
		ReplaySet replaySet = sendOdCustomerService.getReplaySet(rtype);
		CollectionTel collectionTel = getCollectionTel(odCustomerUtil.juHeConfig.getTelNum());

		if ((replaySet == null || replaySet.getFirstTaskId() == null) && collectionTel.getUsed() == 0) {
			// 为 T-1
			return GlobalConfig.firstTime;
		}

		if (replaySet.getSecondTaskId() == null && collectionTel.getUsed() == 0) {
			// 为 T-2
			return GlobalConfig.secondTime;
		}

		if (replaySet.getThirdTaskId() == null && collectionTel.getUsed() == 0) {
			// 为 T-3
			return GlobalConfig.thirdTime;
		}

		if (replaySet.getFourthTaskId() == null && collectionTel.getUsed() == 0) {
			// 为 T-4
			return GlobalConfig.fouthTime;
		}
		return "T";
	}
	
	/**
	 * 
	 * @Title:judgeStopBatch
	 * @Description: TODO(判断停止任务号)
	 * @param sendOdCustomerService
	 * @param rtype
	 * @return
	 * @throws Exception
	 */
	public static String judgeStopTaskId(SendOdCustomerService sendOdCustomerService, String rtype) throws Exception {
		ReplaySet replaySet = sendOdCustomerService.getReplaySet(rtype);
		CollectionTel collectionTel = getCollectionTel(odCustomerUtil.juHeConfig.getTelNum());
		
		if (replaySet != null && replaySet.getFourthTaskId() != null && collectionTel.getUsed() == 1) {
			// 为 T-4
			return replaySet.getFourthTaskId();
		}
		
		if (replaySet.getThirdTaskId() != null && collectionTel.getUsed() == 1) {
			// 为 T-3
			return replaySet.getThirdTaskId();
		}
		
		if (replaySet.getSecondTaskId() != null && collectionTel.getUsed() == 1) {
			// 为 T-2
			return replaySet.getSecondTaskId();
		}

		if (replaySet.getFirstTaskId() != null && collectionTel.getUsed() == 1) {
			// 为 T-1
			return replaySet.getFirstTaskId();
		}
		return null;
	}

	/**
	 * 
	 * @Title:getCollectionTel
	 * @Description: TODO(获取企业外呼实体)
	 * @param telNum
	 * @return
	 * @throws Exception
	 */
	public static CollectionTel getCollectionTel(String telNum) throws Exception {
		List<CollectionTel> collectionTels = JuHeHttpUtil.searchTel(JuHeHttpUtil
				.getToken(odCustomerUtil.juHeConfig.getUsername(), odCustomerUtil.juHeConfig.getPassword()));
		for (CollectionTel collectionTel : collectionTels) {
			if (telNum.equals(collectionTel.getTelNumber())) {
				return collectionTel;
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title:getRepeatList
	 * @Description: TODO(获取重复电话数据)
	 * @param checkList
	 * @param repeatList
	 * @return
	 */
	public static List<CustomerRepeat> getRepeatTelList(List<Customer> checkList, List<Customer> repeatList) {
		if (ObjectUtils.isEmpty(repeatList)) {
			return null;
		}

		List<CustomerRepeat> customerRepeatsCheck = new ArrayList<>();
		List<CustomerRepeat> customerRepeatsRepeat = new ArrayList<>();

		for (Customer customer : checkList) {
			CustomerRepeat customerRepeat = new CustomerRepeat();
			BeanUtils.copyProperties(customer, customerRepeat);
			customerRepeatsCheck.add(customerRepeat);
		}

		for (Customer customer : repeatList) {
			CustomerRepeat customerRepeat = new CustomerRepeat();
			BeanUtils.copyProperties(customer, customerRepeat);
			customerRepeatsRepeat.add(customerRepeat);
		}
		return customerRepeatsRepeat = ListUtil.getNoRepeatList(customerRepeatsCheck,
				ListUtil.getNoRepeatList(customerRepeatsRepeat));
	}

	/**
	 * 
	 * @Title:getPostList
	 * @Description: TODO(获取提交List数据)
	 * @param postLists
	 * @param repeatList
	 * @return
	 */
	public static Map<String, Object> getPostList(SendOdCustomerService sendOdCustomerService, String sendBatch,
			String rtype) {
		Map<String, Object> map = new HashMap<>();
		List<Customer> customers = new ArrayList<>();
		List<Customer> repeatCustomers = new ArrayList<>();
		ListIterator<Customer> listIteratorCustomer;
		TaskConfig taskConfig = new TaskConfig();

		switch (sendBatch) {

		case GlobalConfig.firstTime:
			taskConfig = new TaskConfig(null, null,
					"裕隆催收" + DateUtils.getDate(DateUtils.parsePatterns[0]) + GlobalConfig.firstTime, null, null, null,
					null, null, null, null, odCustomerUtil.juHeConfig.getTelNum(), null, null, null, 0, 60, null);
			map = ListUtil.getSplitList(sendOdCustomerService.getOverdueCustomer());
			map.put("taskConfig", taskConfig);
			return map;

		case GlobalConfig.secondTime:
			customers = sendOdCustomerService.getReplayCustomer(GlobalConfig.firstTime, rtype);
			repeatCustomers = sendOdCustomerService.getRepeatCollectionInfo(GlobalConfig.firstTime, rtype);

			taskConfig = new TaskConfig(null, null,
					"裕隆催收" + DateUtils.getDate(DateUtils.parsePatterns[0]) + GlobalConfig.secondTime, null, null, null,
					null, null, null, null, odCustomerUtil.juHeConfig.getTelNum(), null, null, null, 1, 5, null);
			map.put("taskConfig", taskConfig);

			if (repeatCustomers == null || repeatCustomers.size() == 0) {
				map.put("list", customers);
				return map;
			}

			// 手机号替换
			listIteratorCustomer = customers.listIterator();
			while (listIteratorCustomer.hasNext()) {
				Customer customer = listIteratorCustomer.next();
				for (Customer repeatCustomer : repeatCustomers) {
					if (repeatCustomer.getContractNum().equals(customer.getContractNum())) {
						listIteratorCustomer.remove();
						listIteratorCustomer.add(repeatCustomer);
					}
				}
			}
			map.put("list", customers);
			return map;

		case GlobalConfig.thirdTime:
			customers = sendOdCustomerService.getReplayCustomer(GlobalConfig.secondTime, rtype);
			repeatCustomers = sendOdCustomerService.getRepeatCollectionInfo(GlobalConfig.secondTime, rtype);

			taskConfig = new TaskConfig(null, null,
					"裕隆催收" + DateUtils.getDate(DateUtils.parsePatterns[0]) + GlobalConfig.thirdTime, null, null, null,
					null, null, null, null, odCustomerUtil.juHeConfig.getTelNum(), null, null, null, 1, 5, null);
			map.put("taskConfig", taskConfig);

			if (repeatCustomers == null || repeatCustomers.size() == 0) {
				map.put("list", customers);
				return map;
			}

			listIteratorCustomer = customers.listIterator();
			while (listIteratorCustomer.hasNext()) {
				Customer customer = listIteratorCustomer.next();
				for (Customer repeatCustomer : repeatCustomers) {
					if (repeatCustomer.getContractNum().equals(customer.getContractNum())) {
						listIteratorCustomer.remove();
						listIteratorCustomer.add(repeatCustomer);
					}
				}
			}
			map.put("list", customers);
			return map;

		case GlobalConfig.fouthTime:
			customers = sendOdCustomerService.getReplayCustomer(GlobalConfig.thirdTime, rtype);
			repeatCustomers = sendOdCustomerService.getRepeatCollectionInfo(GlobalConfig.thirdTime, rtype);

			taskConfig = new TaskConfig(null, null,
					"裕隆催收" + DateUtils.getDate(DateUtils.parsePatterns[0]) + GlobalConfig.fouthTime, null, null, null,
					null, null, null, null, odCustomerUtil.juHeConfig.getTelNum(), null, null, null, 2, 5, null);
			map.put("taskConfig", taskConfig);

			if (repeatCustomers == null || repeatCustomers.size() == 0) {
				map.put("list", customers);
				return map;
			}

			listIteratorCustomer = customers.listIterator();
			while (listIteratorCustomer.hasNext()) {
				Customer customer = listIteratorCustomer.next();
				for (Customer repeatCustomer : repeatCustomers) {
					if (repeatCustomer.getContractNum().equals(customer.getContractNum())) {
						listIteratorCustomer.remove();
						listIteratorCustomer.add(repeatCustomer);
					}
				}
			}
			map.put("list", customers);
			return map;
		}
		return null;
	}
	
	/**
	 * 
	 * @Title:createTask
	 * @Description: TODO(创建任务)
	 * @param juHeService
	 * @param requestEmpno
	 *            提交者
	 * @param sendBatch
	 *            发送标签
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static void createTask(SendOdCustomerService sendOdCustomerService, String requestEmpno, String sendBatch,
			String rtype) throws Exception {
		// 待发送的微信信息
		WeiXinMsg weiXinMsg = new WeiXinMsg(GlobalConfig.requestErrorSys, GlobalConfig.requestUser,
				GlobalConfig.receiverName, null, GlobalConfig.receiverCompany, GlobalConfig.receiverRole, null,
				GlobalConfig.repeatTimes, GlobalConfig.repeatInterval, null, null, null, null,
				odCustomerUtil.msgConfig.getCollectDpId(), odCustomerUtil.msgConfig.getCollectAgentId());

		// 获取逾期客户数据 对合同号和手机号去重
		Map<String, Object> map = getPostList(sendOdCustomerService, sendBatch, rtype);
		// 待插入数据
		List<Customer> customers = (List<Customer>) map.get("list");
		// 重复手机号数据
		List<CustomerRepeat> customerRepeats = getRepeatTelList(customers, (List<Customer>) map.get("repeatList"));

		HttpClientResult httpClientResult = JuHeHttpUtil.createTask(customers,
				(TaskConfig) map.get("taskConfig"));
		if (JSONObject.fromObject(httpClientResult.getContent()).getInt("code") == 0) {
			// 任务创建成功 数据写入数据库
			String taskId = JSONObject.fromObject(httpClientResult.getContent()).getJSONObject("result")
					.getJSONArray("rows").getJSONObject(0).getString("taskId");

			sendOdCustomerService.insertCollectionInfo(taskId, requestEmpno, sendBatch, customers, customerRepeats);

			weiXinMsg.setMsg_content("【裕隆汽车金融】 智能催收-借款人任务创建成功；TaskId: " + taskId + "; SendBatch: " + sendBatch);
			SendMsgUtil.sendWX(odCustomerUtil.msgConfig.getWxUrl(), weiXinMsg);
		} else {
			weiXinMsg.setMsg_content("【裕隆汽车金融】 智能催收-借款人任务创建失败");
			SendMsgUtil.sendWX(odCustomerUtil.msgConfig.getWxUrl(), weiXinMsg);
		}
	}
}
