package com.zz.HttpClient.Controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.Bean.Basic.Page;
import com.zz.HttpClient.Bean.Sys.Dict;
import com.zz.HttpClient.Controller.basic.BaseController;
import com.zz.HttpClient.Service.sys.DictService;
import com.zz.HttpClient.Util.Logs;
import com.zz.HttpClient.Util.annotation.argumentResolver.PageRequestBody;

/**
 * 
 * @Title:DictController
 * @Description:TODO(字典Controller)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年9月5日 下午1:49:04
 */
@Controller
@RequestMapping("/sys/dict")
public class DictController extends BaseController {
	
	@Autowired
	private DictService dictService;
	
	/**
	 * 
	 * @Title：dictManage
	 * @Description: TODO(字典管理)
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/manage")
	public String dictManage(HttpServletRequest request, HttpServletResponse response) {
		return "/sys/dict/dictManage";
	}
	
	/**
	 * 
	 * @Title：dictList
	 * @Description: TODO(字典分页条件查询)
	 * @see：
	 * @param request
	 * @param response
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/list", consumes = MediaType.APPLICATION_JSON, produces = DEFAUlT_PRODUCES)
	public void dictList(@PageRequestBody Dict dict, HttpServletRequest request, HttpServletResponse response) {
		Logs.info("字典信息：" + dict);
		Logs.info("分页信息：:" + request.getAttribute("page") + " , " + request.getAttribute("pageSize"));
		renderString(response, dictService.findPage(new Page<>(request), dict));
	}

}
