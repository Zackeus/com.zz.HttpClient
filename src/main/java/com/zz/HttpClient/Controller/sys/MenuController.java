package com.zz.HttpClient.Controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zz.HttpClient.Bean.Basic.LayuiResult;
import com.zz.HttpClient.Bean.Basic.LayuiTable;
import com.zz.HttpClient.Bean.Sys.Menu;
import com.zz.HttpClient.Controller.basic.BaseController;
import com.zz.HttpClient.Service.sys.MenuService;
import com.zz.HttpClient.Util.Logs;
import com.zz.HttpClient.Util.ObjectUtils;
import com.zz.HttpClient.Util.UserUtils;
import com.zz.HttpClient.Util.WebUtils;

/**
 * 
 * @Title:MenuController
 * @Description:TODO(菜单Controller)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月14日 下午4:38:18
 */
@Controller
@RequestMapping("/sys/menu")
public class MenuController extends BaseController {
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * 
	 * @Title：getMenuList
	 * @Description: TODO(系统菜单) 
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/list")
	public void getMenuList(@RequestParam(name = "parentId") String parentId, HttpServletRequest request,
			HttpServletResponse response) {
		renderString(response, UserUtils.getMenuListByUser(parentId));
	}
	
	/**
	 * 
	 * @Title：menuMange
	 * @Description: TODO(菜单管理)
	 * @see：
	 * @param parentId
	 * @param request
	 * @param response
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/mange")
	public String menuMange(HttpServletRequest request, HttpServletResponse response) {
		if (WebUtils.isAjaxRequest(request)) {
			renderString(response, new LayuiTable<>(menuService.findAllList()));
			return null;
		}
		return "sys/menu/menuMange";
	}
	
	/**
	 * 
	 * @Title：addMenu
	 * @Description: TODO(增加菜单页面)
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/add/{id}")
	public String addMenuPage(@PathVariable("id") String id, HttpServletRequest request, 
			HttpServletResponse response, Model model) {
		Integer sort  = menuService.getMaxSortById(id);
		model.addAttribute("sort", ObjectUtils.isEmpty(sort) ? 10 : sort + 10);
		return "sys/menu/addMenu";
	}
	
	/**
	 * 
	 * @Title：addMenu
	 * @Description: TODO(增加菜单)
	 * @see：
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/add", produces = "application/json;charset=UTF-8")
	public void addMenu(@RequestBody Menu menu, HttpServletRequest request, 
			HttpServletResponse response) {
		Logs.info("菜单：" + menu);
		renderString(response, new LayuiResult(0, "添加菜单成功"));
	}
	
	/**
	 * 
	 * @Title：choseMenu
	 * @Description: TODO(选择菜单)
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/choseMenu")
	public String choseMenu(HttpServletRequest request, HttpServletResponse response) {
		if (WebUtils.isAjaxRequest(request)) {
			renderString(response, menuService.getAllMenuList(new Menu(UserUtils.getPrincipal(), "53cdf74600914890a962399f0fb16df4")));
			return null;
		}
		return "sys/menu/choseMenu";
	}
	
	/**
	 * 
	 * @Title：delMenu
	 * @Description: TODO(删除按钮)
	 * @see：
	 * @param request
	 * @param response
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/del", produces = "application/json;charset=UTF-8")
	public void delMenu(@RequestBody Menu menu, HttpServletRequest request, HttpServletResponse response) {
		Logs.info("菜单：" + menu);
		menuService.clearCache();
		renderString(response, new LayuiResult(0, "删除成功"));
	}

}
