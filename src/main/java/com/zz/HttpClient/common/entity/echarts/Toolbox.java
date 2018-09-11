package com.zz.HttpClient.common.entity.echarts;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:Toolbox
 * @Description:TODO(工具栏。内置有导出图片，数据视图，动态类型切换，数据区域缩放，重置五个工具)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月11日 上午9:10:28
 */
public class Toolbox implements Serializable {

	private static final long serialVersionUID = 1L;

	private Object right = "3%";	// 工具栏组件离容器右侧的距离
	private Feature feature;		// 各工具配置项

	public Toolbox() {
		super();
		this.feature = new Feature();
	}

	public Toolbox(Object right, Feature feature) {
		super();
		this.right = right;
		this.feature = feature;
	}

	public Object getRight() {
		return right;
	}

	public void setRight(Object right) {
		this.right = right;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
