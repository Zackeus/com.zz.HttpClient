package com.zz.HttpClient.modules.sys.web;

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

import com.zz.HttpClient.common.entity.AjaxResult;
import com.zz.HttpClient.common.entity.LayuiTable;
import com.zz.HttpClient.common.service.valid.BaseVaild;
import com.zz.HttpClient.common.service.valid.CreateVaild;
import com.zz.HttpClient.common.service.valid.UpdateVaild;
import com.zz.HttpClient.common.utils.ObjectUtils;
import com.zz.HttpClient.common.utils.WebUtils;
import com.zz.HttpClient.common.web.BaseController;
import com.zz.HttpClient.modules.sys.entity.Menu;
import com.zz.HttpClient.modules.sys.service.MenuService;
import com.zz.HttpClient.modules.sys.utils.UserUtils;

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
	 * @Description: TODO(根据一级菜单生成左侧菜单树)
	 * @see：
	 * @param id 一级菜单ID
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/list/{id}")
	public void getMenuList(@PathVariable("id") String id, HttpServletRequest request,
			HttpServletResponse response) {
		renderString(response, UserUtils.getMenuListByUser(id));
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
	@RequestMapping(value = {"/add/{id}", "/maxMenuSort/{id}"})
	public String addMenuPage(@PathVariable("id") String id, HttpServletRequest request, 
			HttpServletResponse response, Model model) {
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
	@RequestMapping(value = "/add", produces = DEFAUlT_PRODUCES)
	public void addMenu(@Validated({ Default.class, CreateVaild.class }) @RequestBody Menu menu, 
			HttpServletRequest request, HttpServletResponse response) {
		menuService.save(menu);
		renderString(response, new AjaxResult(0, "添加菜单成功"));
	}
	
	/**
	 * 
	 * @Title：editMenuPage
	 * @Description: TODO(编辑菜单页面)
	 * @see：
	 * @param id
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/edit/{id}")
	public String editMenuPage(@PathVariable("id") String id, HttpServletRequest request, 
			HttpServletResponse response, Model model) {
		Menu menu = menuService.get(id);
		model.addAttribute("menu", menu);
		model.addAttribute("parentMenu", menuService.get(menu.getParentId()));
		return "sys/menu/editMenu";
	}
	
	/**
	 * 
	 * @Title：editMenu
	 * @Description: TODO(编辑菜单)
	 * @see：
	 * @param menu
	 * @param request
	 * @param response
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/edit", produces = DEFAUlT_PRODUCES)
	public void editMenu(@Validated({ Default.class, UpdateVaild.class, BaseVaild.class }) @RequestBody Menu menu, 
			HttpServletRequest request, HttpServletResponse response) {
		menuService.save(menu);
		renderString(response, new AjaxResult(0, "更新菜单成功"));
	}
	
	/**
	 * 
	 * @Title：delMenu
	 * @Description: TODO(删除菜单)
	 * @see：
	 * @param request
	 * @param response
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/del", produces = DEFAUlT_PRODUCES)
	public void delMenu(@Validated({ Default.class, UpdateVaild.class, BaseVaild.class }) @RequestBody Menu menu, 
			HttpServletRequest request, HttpServletResponse response) {
		menuService.delete(menu);
		renderString(response, new AjaxResult(0, "删除菜单成功"));
	}
	
}
