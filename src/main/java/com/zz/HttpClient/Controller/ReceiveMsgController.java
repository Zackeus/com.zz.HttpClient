package com.zz.HttpClient.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zz.HttpClient.Bean.CTC.Report;
import com.zz.HttpClient.Controller.basic.BaseController;
import com.zz.HttpClient.Bean.CTC.DetaileReport;
import com.zz.HttpClient.Service.CollectionInfoService;
import com.zz.HttpClient.Bean.CollectionCallData;
import com.zz.HttpClient.Bean.CollectionResult;
import com.zz.HttpClient.Bean.Result;
import com.zz.HttpClient.Bean.ReturnInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 
 * @Title:ReceiveMsgController
 * @Description:TODO(数据推送接收)
 * @Company:
 * @author zhou.zhang
 * @date 2018年7月7日 下午5:29:53
 */
@Controller
@RequestMapping("/receive")
@SuppressWarnings("unchecked")
public class ReceiveMsgController extends BaseController {

	@Resource
	private CollectionInfoService collectionInfoService;

	/**
	 * 
	 * @Title:erpRequest
	 * @Description: TODO(聚合速驰催收机器人外呼结果推送接收)
	 * @param parms
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/juheMsg", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String erpRequest(@RequestBody Object parms, HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
		classMap.put("callData", CollectionCallData.class);

		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setClassMap(classMap);

		JSONArray jsonArray = JSONArray.fromObject(parms);

		if (!jsonArray.isEmpty()) {
			List<CollectionResult> collectionResults = JSONArray.toList(jsonArray, new CollectionResult(), jsonConfig);
			collectionInfoService.insertCollectionBackInfo(collectionResults);
		}
		
		return renderString(response, new ReturnInfo(0, "ok", new Result()));
	}
	
	/**
	 * 
	 * @Title：daHanMsg
	 * @Description: TODO(大汉三通短信结果推送接收)
	 * @see：
	 * 注：大汉三通推送方式为 Ajax 传输 Json 对象，固不能用 @RequestBody 接收，否则会报 415 类型不匹配异常
	 * @param parms
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/daHanMsg")
	public void daHanMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject parms = JSONObject.fromObject(new String(request.getParameter("report").getBytes(ISO_ENCODING), UTF_ENCODING));
		JSONObject jsonObject = new JSONObject();
		Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
		classMap.put("reports", DetaileReport.class);
		Report report = (Report) JSONObject.toBean(parms, Report.class, classMap);
		
		if (StringUtils.isEmpty(report.getResult()) || !StringUtils.equals("0", report.getResult())) {
			jsonObject.put("status", "error");
		} else {
			collectionInfoService.handleDaHanReportInfo(report.getReports());
			jsonObject.put("status", "success");
		}
		
		renderString(response, jsonObject.toString(), CONTENT_TYPE);
	}
}