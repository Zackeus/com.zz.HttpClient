package com.zz.HttpClient.Bean.Basic;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:LayuiPage
 * @Description:TODO(Layui前端分页数据封装实体)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月16日 下午1:12:56
 */
public class LayuiPage<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code; 	// 数据状态的字段名称 陈功默认为0
	private String msg; 	// 状态信息的字段名称
	private Integer count; 	// 数据总数的字段名称
	private List<T> data; 	// 数据列表的字段名称

	public LayuiPage() {
		super();
	}
	
	public LayuiPage(Page<T> page) {
		this.code = 0;
		this.msg = "";
		this.count = page.getTotal();
		data = page.getList();
	}

	public LayuiPage(Integer code, String msg, Integer count, List<T> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
