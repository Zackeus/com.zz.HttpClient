package com.zz.HttpClient.Controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zz.HttpClient.Bean.Basic.LayuiResult;
import com.zz.HttpClient.Bean.Basic.LayuiTable;
import com.zz.HttpClient.Bean.Sys.Menu;
import com.zz.HttpClient.Controller.basic.BaseController;
import com.zz.HttpClient.Service.sys.MenuService;
import com.zz.HttpClient.Util.Logs;
import com.zz.HttpClient.Util.UserUtils;

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
	 * @Title：menuMange
	 * @Description: TODO(菜单管理页面)
	 * @see：
	 * @param parentId
	 * @param request
	 * @param response
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/mange")
	public String menuMange(HttpServletRequest request, HttpServletResponse response) {
		return "sys/menu/menuMange";
	}
	
	/**
	 * 
	 * @Title：menuMange
	 * @Description: TODO(菜单管理列表)
	 * @see：
	 * @param parentId
	 * @param request
	 * @param response
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/mangeList")
	public void menuMangeList(HttpServletRequest request, HttpServletResponse response) {
		renderString(response, new LayuiTable<>(menuService.findAllList()));
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
		renderString(response, new LayuiResult(0, "删除成功"));
	}

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

}
