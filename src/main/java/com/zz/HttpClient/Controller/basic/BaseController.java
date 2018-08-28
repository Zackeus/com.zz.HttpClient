package com.zz.HttpClient.Controller.basic;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zz.HttpClient.Bean.Basic.LayuiResult;
import com.zz.HttpClient.Util.DateUtils;
import com.zz.HttpClient.Util.JsonMapper;
import com.zz.HttpClient.Util.WebUtils;
import com.zz.HttpClient.Util.exception.MyException;

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
		if (response != null) {
			return renderString(response, JsonMapper.toJsonString(object), CONTENT_TYPE);
		}
		return null;
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
	 * @Title：renderInfo
	 * @Description: TODO(处理返回信息；Ajax返回json；普通请求将信息加入Model中并返回)
	 * @see：
	 * @param response
	 * @param url
	 * @param code
	 * @param message
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected String renderInfo(HttpServletRequest request, HttpServletResponse response, Model model, String url, JSONObject jsonObject) {
		if (WebUtils.isAjaxRequest(request)) {
			return renderString(response, jsonObject);
		}
		
		Iterator<String> it = jsonObject.keys(); 
		while(it.hasNext()) {
			String key = it.next(); 
			model.addAttribute(key, jsonObject.getString(key));
		}
		return url;
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
            renderString(response, new LayuiResult(-1, "当前账号无权进行此操作!!!"));
            return null;
        } else {
            return "sys/403";
        }
    }
    
    /**
     * 
     * @Title：runTimeException
     * @Description: TODO(参数校验异常)
     * @see：
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public String methodArgumentNotValidExceptio(HttpServletRequest request, HttpServletResponse response, 
    		MethodArgumentNotValidException e) {
		if (WebUtils.isAjaxRequest(request)) {
	    	String errorMesssage = "参数校验异常：" + e.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
	        renderString(response, new LayuiResult(400, errorMesssage));
	        return null;
		} else {
			return "sys/400";
		}
    }
    
	/**
	 * 
	 * @Title：schedulerException
	 * @Description: TODO(自定义异常) 
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
	@ExceptionHandler({ MyException.class })
	public String schedulerException(HttpServletRequest request, HttpServletResponse response, MyException e) {
		if (WebUtils.isAjaxRequest(request)) {
			renderString(response, new LayuiResult(-1, e.getMessage()));
			return null;
		} else {
			return "sys/Error";
		}
	}
	
	/**
	 * 
	 * @Title：exception
	 * @Description: TODO(未知异常)
	 * @see：
	 * @param request
	 * @param response
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ Exception.class })
	public String exception(HttpServletRequest request, HttpServletResponse response, Exception e) {
		if (WebUtils.isAjaxRequest(request)) {
			renderString(response, new LayuiResult(-1, "未知的错误：" + e.getMessage()));
			e.printStackTrace();
			return null;
		} else {
			return "sys/Error";
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
