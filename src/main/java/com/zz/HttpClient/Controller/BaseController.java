package com.zz.HttpClient.Controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zz.HttpClient.Util.DateUtils;
import com.zz.HttpClient.Util.JsonMapper;
import com.zz.HttpClient.Util.WebUtils;

import net.sf.json.JSONObject;

/**
 * 
 * @Title:BaseController
 * @Description:TODO(控制器支持类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月9日 下午5:12:20
 */
@SuppressWarnings("deprecation")
public abstract class BaseController {
	
	protected static final String UTF_ENCODING = "UTF-8";
	
	protected static final String ISO_ENCODING = "iso-8859-1";
	
	protected static final String CONTENT_TYPE = "application/json";

	/**
	 * 
	 * @Title：addMessage
	 * @Description: TODO(添加Model消息)
	 * @see：
	 * @param model
	 * @param messages
	 */
	protected void addMessage(Model model, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		model.addAttribute("message", sb.toString());
	}
	
	/**
	 * 
	 * @Title：addMessage
	 * @Description: TODO(添加Flash消息)
	 * @see：
	 * @param redirectAttributes
	 * @param messages
	 */
	protected void addMessage(RedirectAttributes redirectAttributes, String... messages) {
		StringBuilder sb = new StringBuilder();
		for (String message : messages){
			sb.append(message).append(messages.length>1?"<br/>":"");
		}
		redirectAttributes.addFlashAttribute("message", sb.toString());
	}
	
	/**
	 * 
	 * @Title：renderString
	 * @Description: TODO(客户端返回JSON字符串)
	 * @see：
	 * @param response
	 * @param object
	 * @return
	 */
	protected String renderString(HttpServletResponse response, Object object) {
		return renderString(response, JsonMapper.toJsonString(object), CONTENT_TYPE);
	}
	
	/**
	 * 
	 * @Title：renderString
	 * @Description: TODO(客户端返回字符串)
	 * @see：
	 * @param response
	 * @param string
	 * @param type
	 * @return
	 */
	protected String renderString(HttpServletResponse response, String string, String type) {
		try {
			response.reset();
	        response.setContentType(type);
	        response.setCharacterEncoding(UTF_ENCODING);
			response.getWriter().print(string);
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 
	 * @Title：bindException
	 * @Description: TODO(参数绑定异常)
	 * @see：
	 * @return
	 */
	@ExceptionHandler({BindException.class, ConstraintViolationException.class, ValidationException.class})
    public String bindException() {  
        return "error/400";
    }
	
	/**
	 * 
	 * @Title：authorizationException
	 * @Description: TODO(授权登录异常)
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
    @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
    public String authorizationException(HttpServletRequest request, HttpServletResponse response) {
        if (WebUtils.isAjaxRequest(request)) {
            // 输出JSON
        	JSONObject jsonObject = new JSONObject();
            jsonObject.put("retcode", "-100");
            jsonObject.put("error_msg", "当前账号无权限进行此操作！！！");
            renderString(response, jsonObject.toString(), CONTENT_TYPE);
            return null;
        } else {
            return "sys/403";
        }
    }
	
	/**
	 * 
	 * @Title：initBinder
	 * @Description: TODO(初始化数据绑定)
	 * @see：
	 * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
	 * 2. 将字段中Date类型转换为String类型
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text.trim()));
			}
			@Override
			public String getAsText() {
				Object value = getValue();
				return value != null ? value.toString() : "";
			}
		});
		// Date 类型转换
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(DateUtils.parseDate(text));
			}
		});
	}
	
}
