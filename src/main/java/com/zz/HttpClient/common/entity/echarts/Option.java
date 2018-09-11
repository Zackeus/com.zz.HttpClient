package com.zz.HttpClient.common.entity.echarts;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:Option
 * @Description:TODO(配置项)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月10日 下午6:25:46
 */
public class Option implements Serializable {

	private static final long serialVersionUID = 1L;

	private Title title;			// 标题组件
	private Tooltip tooltip;		// 提示框组件
	private Legend legend;			// 图例组件
	private Grid grid;				// 直角坐标系内绘图网格
	private Toolbox toolbox;		// 工具栏
	private XAxis xAxis;			// 直角坐标系 grid 中的 x 轴
	private YAxis yAxis;			// 直角坐标系 grid 中的 y 轴
	private List<Series> series; 	// 系列列表 y轴数据

	public Option() {
		super();
	}
	
	public Option(Title title, Tooltip tooltip, Legend legend, Grid grid, Toolbox toolbox, XAxis xAxis, YAxis yAxis,
			List<Series> series) {
		super();
		this.title = title;
		this.tooltip = tooltip;
		this.legend = legend;
		this.grid = grid;
		this.toolbox = toolbox;
		this.xAxis = xAxis;
		this.yAxis = yAxis;
		this.series = series;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Tooltip getTooltip() {
		return tooltip;
	}

	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public Toolbox getToolbox() {
		return toolbox;
	}

	public void setToolbox(Toolbox toolbox) {
		this.toolbox = toolbox;
	}

	public XAxis getxAxis() {
		return xAxis;
	}

	public void setxAxis(XAxis xAxis) {
		this.xAxis = xAxis;
	}

	public YAxis getyAxis() {
		return yAxis;
	}

	public void setyAxis(YAxis yAxis) {
		this.yAxis = yAxis;
	}

	public List<Series> getSeries() {
		return series;
	}

	public void setSeries(List<Series> series) {
		this.series = series;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
