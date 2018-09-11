package com.zz.HttpClient.common.entity.echarts;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:Grid
 * @Description:TODO(直角坐标系内绘图网格)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月11日 上午9:04:33
 */
public class Grid implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean show = Boolean.TRUE;			// 是否显示直角坐标系网格
	private Object left = "5%";						// grid 组件离容器左侧的距离
	private Object top = "20%";						// grid 组件离容器上侧的距离
	private Object right = "5%";					// grid 组件离容器右侧的距离
	private Object bottom = "3%";					// grid 组件离容器下侧的距离
	private boolean containLabel = Boolean.TRUE;	// grid 区域是否包含坐标轴的刻度标签

	public Grid() {
		super();
	}

	public Grid(boolean show, Object left, Object top, Object right, Object bottom, boolean containLabel) {
		super();
		this.show = show;
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.containLabel = containLabel;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public Object getLeft() {
		return left;
	}

	public void setLeft(Object left) {
		this.left = left;
	}

	public Object getTop() {
		return top;
	}

	public void setTop(Object top) {
		this.top = top;
	}

	public Object getRight() {
		return right;
	}

	public void setRight(Object right) {
		this.right = right;
	}

	public Object getBottom() {
		return bottom;
	}

	public void setBottom(Object bottom) {
		this.bottom = bottom;
	}

	public boolean isContainLabel() {
		return containLabel;
	}

	public void setContainLabel(boolean containLabel) {
		this.containLabel = containLabel;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
