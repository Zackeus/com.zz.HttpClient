package com.zz.HttpClient.modules.demo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zz.HttpClient.common.web.BaseController;

/**
 * 
 * @Title:EchartsController
 * @Description:TODO(Echarts 案例演示)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年9月8日 下午3:20:25
 */
@Controller
@RequestMapping("/demo")
public class EchartsController extends BaseController {
	
	/**
	 * 
	 * @Title：foldLineDiagram
	 * @Description: TODO(折线图)
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/foldLine", method = RequestMethod.GET)
	public String foldLineDiagram(HttpServletRequest request, HttpServletResponse response) {
		return "/demo/echarts/foldLine";
	}
	
	/**
	 * 
	 * @Title：histogram
	 * @Description: TODO(柱状图)
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/histogram", method = RequestMethod.GET)
	public String histogram(HttpServletRequest request, HttpServletResponse response) {
		return "/demo/echarts/histogram";
	}

}
