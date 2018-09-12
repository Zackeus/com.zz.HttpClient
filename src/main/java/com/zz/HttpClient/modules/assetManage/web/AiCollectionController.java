package com.zz.HttpClient.modules.assetManage.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zz.HttpClient.common.entity.AjaxResult;
import com.zz.HttpClient.common.utils.DateUtils;
import com.zz.HttpClient.common.utils.Logs;
import com.zz.HttpClient.common.utils.WebUtils;
import com.zz.HttpClient.common.web.BaseController;
import com.zz.HttpClient.modules.assetManage.entity.StatisticsSearchParameters;
import com.zz.HttpClient.modules.assetManage.service.AiCollectionService;

import net.sf.json.JSONObject;

/**
 * 
 * @Title:AiCollection
 * @Description:TODO(智能催收)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年9月10日 上午10:09:34
 */
@Controller
@RequestMapping("/assetManage/aiCollection")
public class AiCollectionController extends BaseController {
	
	@Autowired
	private StatisticsSearchParameters statisticsSearchParameters;
	
	@Autowired
	private AiCollectionService aiCollectionService;
	
	/**
	 * 
	 * @Title：reportFormPage
	 * @Description: TODO(报表页面)
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/reportForm", method = RequestMethod.GET)
	public String reportFormPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		// 默认查询昨天 凌晨8:00 至 20:00 的数据
		Date defaultDate = DateUtils.getDateBefore(new Date(), 1);
		statisticsSearchParameters.setStartDay(defaultDate);
		statisticsSearchParameters.setEndDay(defaultDate);
		model.addAttribute("defaultSearch", statisticsSearchParameters);
		return "/modules/assetManage/aiCollection/reportForm";
	}
	
	/**
	 * 
	 * @Title：reportForm
	 * @Description: TODO(报表视图)
	 * @see：
	 * @param searchParameters
	 * @param request
	 * @param response
	 * @param model
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/reportForm", consumes = MediaType.APPLICATION_JSON,
			produces = DEFAUlT_PRODUCES, method = RequestMethod.POST)
	public void reportForm(@Validated @RequestBody StatisticsSearchParameters searchParameters, 
			HttpServletRequest request, HttpServletResponse response, Model model) {
		Logs.info(WebUtils.getIpAddress(request));
		renderString(response, new AjaxResult(0, "加载数据成功", 
				new JSONObject().fromObject(aiCollectionService.connectionRateStatisticsByTime(searchParameters))));
	}

}
