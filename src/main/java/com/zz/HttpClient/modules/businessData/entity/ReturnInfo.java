package com.zz.HttpClient.modules.businessData.entity;

import java.io.Serializable;

/**
 * 据合速驰推送结果返回信息
 * 
 * @author zhou.zhang
 *
 */
public class ReturnInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code; 			// 编码
	private String message; 	// 返回信息
	private Result result;
	
	public ReturnInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReturnInfo(int code, String message, Result result) {
		super();
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ReturnInfo [code=" + code + ", message=" + message + ", result=" + result + "]";
	}

}
