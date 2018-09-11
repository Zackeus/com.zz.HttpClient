package com.zz.HttpClient.common.entity.echarts;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:XAxis
 * @Description:TODO(直角坐标系 grid 中的 x 轴)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月10日 下午6:19:38
 */
public class XAxis implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;							// 坐标轴名称
	private Boolean show = Boolean.TRUE;			// 是否显示 x 轴
	private String type = "category";				// 坐标轴类型
	private boolean boundaryGap = Boolean.FALSE; 	// 坐标轴两边留白策略
	private List<Object> data;						// 类目数据

	public XAxis() {
		super();
	}
	
	public XAxis(String name, List<Object> data) {
		super();
		this.name = name;
		this.data = data;
	}

	public XAxis(Boolean show, String type, boolean boundaryGap, List<Object> data) {
		super();
		this.show = show;
		this.type = type;
		this.boundaryGap = boundaryGap;
		this.data = data;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isBoundaryGap() {
		return boundaryGap;
	}

	public void setBoundaryGap(boolean boundaryGap) {
		this.boundaryGap = boundaryGap;
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
