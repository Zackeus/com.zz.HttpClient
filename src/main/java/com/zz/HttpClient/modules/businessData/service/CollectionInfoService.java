package com.zz.HttpClient.modules.businessData.service;

import java.util.List;

import com.zz.HttpClient.modules.businessData.entity.CollectionResult;
import com.zz.HttpClient.modules.businessData.entity.DetaileReport;

public interface CollectionInfoService {
	
	public void insertCollectionBackInfo(List<CollectionResult> collectionResults);
	
	public void handleDaHanReportInfo(List<DetaileReport> detaileReports);
}
