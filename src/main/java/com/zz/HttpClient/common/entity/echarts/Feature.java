package com.zz.HttpClient.common.entity.echarts;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:Feature
 * @Description:TODO(各工具配置项)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月11日 上午9:11:55
 */
public class Feature implements Serializable {

	private static final long serialVersionUID = 1L;

	private Object saveAsImage;		// 保存为图片
	private MagicType magicType; 	// 动态类型切换

	public Feature() {
		super();
		this.saveAsImage = new Object();
		this.magicType = new MagicType();
	}

	public Feature(Object saveAsImage, MagicType magicType) {
		super();
		this.saveAsImage = saveAsImage;
		this.magicType = magicType;
	}

	public Object getSaveAsImage() {
		return saveAsImage;
	}

	public void setSaveAsImage(Object saveAsImage) {
		this.saveAsImage = saveAsImage;
	}

	public MagicType getMagicType() {
		return magicType;
	}

	public void setMagicType(MagicType magicType) {
		this.magicType = magicType;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
