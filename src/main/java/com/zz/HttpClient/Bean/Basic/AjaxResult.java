package com.zz.HttpClient.Bean.Basic;

import java.io.Serializable;

/**
 * 
 * @Title:LayuiResult
 * @Description:TODO(前端Ajax响应实体)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月16日 下午4:52:45
 */
public class AjaxResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code; 	// 响应code
	private String message; // 响应内容

	public AjaxResult() {
		super();
	}

	public AjaxResult(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LayuiResult [code=" + code + ", message=" + message + "]";
	}

}
