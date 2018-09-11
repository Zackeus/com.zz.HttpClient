package com.zz.HttpClient.common.entity.echarts;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:NameTextStyle
 * @Description:TODO(坐标轴名称的文字样式)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月11日 上午9:24:49
 */
public class NameTextStyle implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fontWeight = "bold"; 			// 坐标轴名称文字字体的粗细
	private String fontFamily = "Microsoft YaHei"; 	// 坐标轴名称文字的字体系列

	public NameTextStyle() {
		super();
	}

	public NameTextStyle(String fontWeight, String fontFamily) {
		super();
		this.fontWeight = fontWeight;
		this.fontFamily = fontFamily;
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

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
