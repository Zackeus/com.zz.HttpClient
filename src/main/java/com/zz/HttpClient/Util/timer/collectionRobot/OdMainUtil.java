package com.zz.HttpClient.Util.timer.collectionRobot;

import org.springframework.stereotype.Component;

import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.Config.GlobalConfig;

/**
 * 
 * @Title:OdMainUtil
 * @Description:TODO(催收任务主类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月24日 下午1:12:55
 */
@Component
public class OdMainUtil {
	
	// 借款人发送标签
	private static String sendCustomerBatch;
	
	// 担保人发送标签
	private static String sendGuaranteeBatch;
	
	/**
	 * 
	 * @param collectionRobotTimer 
	 * @Title：sendOdCustomer
	 * @Description: TODO(执行借款人)
	 * @see：
	 * @throws Exception
	 */
	public void sendOdCustomer(CollectionRobotTimer collectionRobotTimer) throws Exception {
		switch (OdCustomerUtil.judgeSendBatch(collectionRobotTimer)) {
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
		OdCustomerUtil.createTask("17037", sendCustomerBatch, collectionRobotTimer);
	}
	
	/**
	 * 
	 * @param collectionRobotTimer 
	 * @throws Exception 
	 * @Title：sendOdGuarantee
	 * @Description: TODO(执行保证人)
	 * @see：
	 */
	public void sendOdGuarantee(CollectionRobotTimer collectionRobotTimer) throws Exception {
		switch (OdGuaranteeUtil.judgeSendBatch(collectionRobotTimer)) {
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
		OdGuaranteeUtil.createTask("17037", sendGuaranteeBatch, collectionRobotTimer);
	}

}
