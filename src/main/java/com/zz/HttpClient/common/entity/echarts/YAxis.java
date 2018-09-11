package com.zz.HttpClient.common.entity.echarts;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:YAxis
 * @Description:TODO(直角坐标系 grid 中的 y 轴)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月11日 上午9:23:16
 */
public class YAxis implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;					// 坐标轴名称
	private String type = "value"; 			// 坐标轴类型 'value' 数值轴
	private NameTextStyle nameTextStyle; 	// 坐标轴名称的文字样式

	public YAxis() {
		super();
		this.nameTextStyle = new NameTextStyle();
	}
	
	public YAxis(String name) {
		super();
		this.name = name;
		this.nameTextStyle = new NameTextStyle();
	}

	public YAxis(String type, NameTextStyle nameTextStyle) {
		super();
		this.type = type;
		this.nameTextStyle = nameTextStyle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public NameTextStyle getNameTextStyle() {
		return nameTextStyle;
	}

	public void setNameTextStyle(NameTextStyle nameTextStyle) {
		this.nameTextStyle = nameTextStyle;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
