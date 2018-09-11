package com.zz.HttpClient.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zz.HttpClient.common.annotation.argumentResolver.PageRequestBody;
import com.zz.HttpClient.common.entity.AjaxResult;
import com.zz.HttpClient.common.entity.Page;
import com.zz.HttpClient.common.utils.ObjectUtils;
import com.zz.HttpClient.common.utils.StringUtils;
import com.zz.HttpClient.common.web.BaseController;
import com.zz.HttpClient.modules.sys.entity.Dict;
import com.zz.HttpClient.modules.sys.service.DictService;

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
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String dictManage(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("typeList", dictService.findTypeList());
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
	@RequestMapping(value = "/list", consumes = MediaType.APPLICATION_JSON, 
		produces = DEFAUlT_PRODUCES, method = RequestMethod.POST)
	public void dictList(@PageRequestBody Dict dict, HttpServletRequest request, HttpServletResponse response) {
		renderString(response, dictService.findPage(new Page<>(request), dict));
	}
	
	/**
	 * 
	 * @Title：addDict
	 * @Description: TODO(添加字典页面)
	 * @see：
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = {"/add", "/add/{id}"}, method = RequestMethod.GET)
	public String addDictPage(@PathVariable(value = "id", required = false) String id, 
			HttpServletRequest request, HttpServletResponse response, Model model) {
		if (StringUtils.isBlank(id)) {
			model.addAttribute("dict", new Dict());
		} else {
			Dict dict = dictService.get(id);
			dict.setSort(ObjectUtils.isEmpty(dict.getSort()) ? 10 : dict.getSort() + 10);
			model.addAttribute("dict", dict);
		}
		return "/sys/dict/addDict";
	}
	
	/**
	 * 
	 * @Title：addDict
	 * @Description: TODO(添加字典)
	 * @see：
	 * @param dict
	 * @param request
	 * @param response
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = {"/add"}, consumes = MediaType.APPLICATION_JSON, 
		produces = DEFAUlT_PRODUCES, method = RequestMethod.POST)
	public void addDict(@Validated @RequestBody Dict dict, HttpServletRequest request, HttpServletResponse response) {
		dictService.save(dict);
		renderString(response, new AjaxResult(0, "添加字典成功"));
	}

}
