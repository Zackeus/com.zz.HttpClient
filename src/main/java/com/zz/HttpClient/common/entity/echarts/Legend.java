package com.zz.HttpClient.common.entity.echarts;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:Legend
 * @Description:TODO(图例组件)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月11日 上午8:25:56
 */
public class Legend implements Serializable {

	private static final long serialVersionUID = 1L;

	private String type = "scroll"; 	// 图例的类型 'scroll'：可滚动翻页的图例
	private Object top = "8%";			// 图例组件离容器上侧的距离
	private List<Object> data; 			// 图例的数据数组

	public Legend() {
		super();
	}

	public Legend(List<Object> data) {
		super();
		this.data = data;
	}
	
	public Legend(String type, Object top, List<Object> data) {
		super();
		this.type = type;
		this.top = top;
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getTop() {
		return top;
	}

	public void setTop(Object top) {
		this.top = top;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
