package com.zz.HttpClient.common.entity.echarts;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:TextStyle
 * @Description:TODO(文本样式)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月11日 上午8:51:59
 */
public class TextStyle implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fontStyle = "italic"; 			// 文字字体的风格
	private String fontWeight = "bolder"; 			// 文字字体的粗细
	private String fontFamily = "Microsoft YaHei"; 	// 文字的字体系列
	private Integer fontSize = 25; 					// 文字的字体大小

	public TextStyle() {
		super();
	}

	public TextStyle(String fontStyle, String fontWeight, String fontFamily, Integer fontSize) {
		super();
		this.fontStyle = fontStyle;
		this.fontWeight = fontWeight;
		this.fontFamily = fontFamily;
		this.fontSize = fontSize;
	}

	public String getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(String fontStyle) {
		this.fontStyle = fontStyle;
	}

	public String getFontWeight() {
		return fontWeight;
	}

	public void setFontWeight(String fontWeight) {
		this.fontWeight = fontWeight;
	}

	public String getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	public Integer getFontSize() {
		return fontSize;
	}

	public void setFontSize(Integer fontSize) {
		this.fontSize = fontSize;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
