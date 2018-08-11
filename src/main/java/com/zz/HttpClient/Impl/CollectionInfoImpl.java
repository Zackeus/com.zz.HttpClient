package com.zz.HttpClient.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.Bean.CTC.DetaileReport;
import com.zz.HttpClient.Dao.BusinessSMSDao;
import com.zz.HttpClient.Dao.CollectionInfoDao;
import com.zz.HttpClient.Service.CollectionInfoService;
import com.zz.HttpClient.Util.ListUtil;
import com.zz.HttpClient.Util.ObjectUtils;
import com.zz.HttpClient.Bean.CollectionCallData;
import com.zz.HttpClient.Bean.CollectionResult;

/**
 * 
 * @Title:CollectionInfoImpl
 * @Description:TODO(推送数据处理)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月9日 上午9:04:27
 */
@Service("collectionInfoService")
public class CollectionInfoImpl implements CollectionInfoService {
	
	@Resource
	private CollectionInfoDao collectionInfoDao;
	
	@Autowired
	private BusinessSMSDao businessSMSDao;
	
	/**
	 * 聚合速驰推送数据处理
	 */
	@Override
	public void insertCollectionBackInfo(List<CollectionResult> collectionResults) {
		for (List<CollectionResult> collectionResultsBySplit : ListUtil.listSplite(collectionResults,
				(collectionResults.size() / 100) + 1)) {
			// List分批插入 SqlServer 对语句的条数和参数的数量都有限制，分别是 1000 和 2100。
			collectionInfoDao.insertCollectionResult(collectionResultsBySplit);

			// 处理外呼交互内容
			for (CollectionResult collectionResult : collectionResultsBySplit) {
				Long taskDataId = collectionResult.getTaskDataId();
				List<CollectionCallData> collectionCallDatas = collectionResult.getCallData();
				
				if (!ObjectUtils.isEmpty(collectionCallDatas)) {
					if (collectionCallDatas.size() > 100) {
						for (List<CollectionCallData> collectionCallDatasBySplit : ListUtil
								.listSplite(collectionCallDatas, (collectionCallDatas.size() / 100) + 1)) {
							collectionInfoDao.insertCollectionCallData(taskDataId, collectionCallDatasBySplit);
						}
					} else {
						collectionInfoDao.insertCollectionCallData(taskDataId, collectionCallDatas);
					}
				}
			}
		}
	}

	/**
	 * 大汉三通短信数据处理
	 */
	@Override
	public void handleDaHanReportInfo(List<DetaileReport> detaileReports) {
		if (ObjectUtils.isEmpty(detaileReports)) {
			return;
		}
		
		for (DetaileReport detaileReport : detaileReports) {
			if (!StringUtils.equals("1", detaileReport.getSmsIndex())) {
				// 长短信过滤 只更新序号为1的短信报告
				continue;
			}
			
            if (StringUtils.equals("0", detaileReport.getStatus().trim())) {
            	// 更新短信备注为T 发送成功
            	businessSMSDao.updateRemark(businessSMSDao.getSerialNoByMsgNo(detaileReport.getMsgid()));
            }
            businessSMSDao.updateStatus(detaileReport);
		}
	}
}
