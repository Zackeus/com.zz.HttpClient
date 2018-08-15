package com.zz.HttpClient.Controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zz.HttpClient.Controller.BaseController;
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
