package com.zz.HttpClient.common.entity.echarts;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:Title
 * @Description:TODO(标题组件，包含主标题和副标题)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年9月11日 上午8:59:26
 */
public class Title implements Serializable {

	private static final long serialVersionUID = 1L;

	private String text; 			// 主标题文本
	private TextStyle textStyle; 	// 文本样式

	public Title() {
		super();
		this.textStyle = new TextStyle();
	}
	
	public Title(String text) {
		super();
		this.text = text;
		this.textStyle = new TextStyle();
	}

	public Title(String text, TextStyle textStyle) {
		super();
		this.text = text;
		this.textStyle = textStyle;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public TextStyle getTextStyle() {
		return textStyle;
	}

	public void setTextStyle(TextStyle textStyle) {
		this.textStyle = textStyle;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
