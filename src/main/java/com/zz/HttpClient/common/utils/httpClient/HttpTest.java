package com.zz.HttpClient.common.utils.httpClient;

import java.util.ArrayList;
import java.util.List;

import com.zz.HttpClient.modules.businessData.entity.CollectionCallData;
import com.zz.HttpClient.modules.businessData.entity.CollectionResult;
import com.zz.HttpClient.modules.businessData.entity.DetaileReport;
import com.zz.HttpClient.modules.businessData.entity.Report;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class HttpTest {
	
	// String url = "http://loan.yulon-finance.com.cn:8088/com.zz.HttpClient/receive/juheMsg";
	// String url = "http://ssq.yulon-finance.com.cn:8989/com.zz.HttpClient/receive/juheMsg";
//	private static final String url = "http://localhost:8008/com.zz.HttpClient/receive/juheMsg";
	private static final String url = "http://localhost:8008/com.zz.HttpClient/receive/daHanMsg";

	
	public static void main(String[] args) throws Exception {
		daHantest();
	}
	
	public static void daHantest() throws Exception {
		Report report = new Report("0", "成功", null);
		List<DetaileReport> detaileReports = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			DetaileReport detaileReport = new DetaileReport("400362f1fd30402b8ac6e32df8077fdc", "15058041631", "0", "成功", "DELIVRD", 
					"2015-03-17 16:32:20", "3", i + "");
			detaileReports.add(detaileReport);
		}
		report.setReports(detaileReports);
		System.out.println(HttpClientUtil.doPostJson(url, JSONObject.fromObject(report)));
	}
	
	public static void juHeTest() throws Exception {
		
		Long taskId = new Long("55060");
		Long taskDataId = new Long("38893344");
		Long callTime = new Long("1531034493000");
		Long callBeginTime = new Long("1531034504000");
		Long callEndTime = new Long("1531034573056");
		Long callTimeLength = new Long("80");
		Long callProcTimeLength = new Long("69");
		Integer status = 2;
		String callResult = "成功";
		Integer result = 0;
		Long telNumber = new Long("15058041631");
		String recordFile = "http://xiaoman.kxjlcc.com/oss-resource/fs_record/2017/10/13/15/O_20171013150858_68104787_13922235252_00625E1HACCB9004345H7B5AES06BQ0D_3918937_.wav";
		Long fileLength = new Long("67");
		List<Object> rowData = new ArrayList<>();
		rowData.add("15058041631");
		rowData.add("7");
		rowData.add("张舟");
		rowData.add("5269.45");

		CollectionCallData collectionCallData1 = new CollectionCallData(new Long("1"), "start_8ae26", "身份确认",
				"您好 ，我是裕隆汽车金融还款提醒专员", "judge_node_70729", "是的", "是的是的");
		CollectionCallData collectionCallData2 = new CollectionCallData(new Long("2"),
				"EndNotifyNode_f245aab7-4b32-431f-a093-7fb392664a9d", null, null, null, null, null);
		List<CollectionCallData> callData = new ArrayList<>();
		callData.add(collectionCallData1);
		callData.add(collectionCallData2);

		CollectionResult collectionResult = new CollectionResult(taskId, taskDataId, callTime, callBeginTime,
				callEndTime, callTimeLength, callProcTimeLength, status, callResult, result, telNumber, recordFile,
				fileLength, rowData, callData);

		JSONArray jsonArray = new JSONArray();
		jsonArray.add(collectionResult);
		System.out.println(HttpClientUtil.doPostJson(url, JSONArray.fromObject(jsonArray)));
	}

}
