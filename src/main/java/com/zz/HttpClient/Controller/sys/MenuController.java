package com.zz.HttpClient.Controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.groups.Default;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zz.HttpClient.Bean.Basic.AjaxResult;
import com.zz.HttpClient.Bean.Basic.LayuiTable;
import com.zz.HttpClient.Bean.Sys.Menu;
import com.zz.HttpClient.Controller.basic.BaseController;
import com.zz.HttpClient.Service.sys.MenuService;
import com.zz.HttpClient.Service.sys.valid.BaseVaild;
import com.zz.HttpClient.Service.sys.valid.CreateVaild;
import com.zz.HttpClient.Service.sys.valid.UpdateVaild;
import com.zz.HttpClient.Util.Logs;
import com.zz.HttpClient.Util.ObjectUtils;
import com.zz.HttpClient.Util.UserUtils;
import com.zz.HttpClient.Util.WebUtils;

import net.sf.json.JSONObject;

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
	 * @Title：treeMenuList
	 * @Description: TODO(选择菜单)
	 * @see：
	 * @param request
	 * @param response
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/choseMenu")
	public void treeMenuList(HttpServletRequest request, HttpServletResponse response) {
		renderString(response, menuService.getAllMenuList(new Menu(UserUtils.getPrincipal(), "1")));
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
		Logs.info("ID:" + id);
		Integer sort  = menuService.getMaxSortById(id);
		if (WebUtils.isAjaxRequest(request)) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sort", ObjectUtils.isEmpty(sort) ? 10 : sort + 10);
			renderString(response, new AjaxResult(0, "成功", jsonObject));
			return null;
		}
		model.addAttribute("menu", menuService.get(id));
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
	public void addMenu(@Validated({ Default.class, CreateVaild.class }) @RequestBody Menu menu, 
			HttpServletRequest request, HttpServletResponse response) {
		menuService.addMenu(menu);
		renderString(response, new AjaxResult(0, "添加菜单成功"));
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
	public void delMenu(@Validated({ Default.class, UpdateVaild.class, BaseVaild.class }) @RequestBody Menu menu, 
			HttpServletRequest request, HttpServletResponse response) {
		menuService.delete(menu);
		renderString(response, new AjaxResult(0, "删除成功"));
	}
	
}
