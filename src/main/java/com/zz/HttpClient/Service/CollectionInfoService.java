package com.zz.HttpClient.Service;

import java.util.List;

import com.zz.HttpClient.Bean.CTC.DetaileReport;
import com.zz.HttpClient.Bean.CollectionResult;

public interface CollectionInfoService {
	
	public void insertCollectionBackInfo(List<CollectionResult> collectionResults);
	
	public void handleDaHanReportInfo(List<DetaileReport> detaileReports);
}
