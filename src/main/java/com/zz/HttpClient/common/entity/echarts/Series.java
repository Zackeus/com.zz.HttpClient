package com.zz.HttpClient.common.entity.echarts;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:Series
 * @Description:TODO(系列列表,每个系列通过 type 决定自己的图表类型)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月10日 下午5:07:00
 */
public class Series implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name; 								// 系列名称，用于tooltip的显示，legend 的图例筛选
	private String type = "line"; 						// 默认折线图
	private String coordinateSystem = "cartesian2d"; 	// 该系列使用的坐标系:'cartesian2d'使用二维的直角坐标系（也称笛卡尔坐标系);'polar'使用极坐标系
	private Integer xAxisIndex = 0; 					// 使用的 x 轴的 index，在单个图表实例中存在多个 x 轴的时候有用
	private Integer yAxisIndex = 0; 					// 使用的 y 轴的 index，在单个图表实例中存在多个 y轴的时候有用
	private Integer polarIndex = 0; 					// 使用的极坐标系的 index
	private String symbol = "emptyCircle"; 				// 标记的图形
	private Integer symbolSize = 4; 					// 标记的大小
	private Integer symbolRotate; 						// 标记的旋转角度
	private boolean symbolKeepAspect = Boolean.FALSE; 	// 如果 symbol 是 path://
														// 的形式，是否在缩放时保持该图形的长宽比
	private boolean showSymbol = Boolean.TRUE; 			// 是否显示 symbol,
	private String stack; 								// 数据堆叠
	private String cursor = "pointer"; 					// 鼠标悬浮时在图形元素上时鼠标的样式是什么
	private boolean connectNulls = Boolean.FALSE; 		// 是否连接空数据
	private boolean clipOverflow = Boolean.TRUE; 		// 是否对超出部分裁剪，默认裁剪
	private boolean step = Boolean.FALSE; 				// 是否是阶梯线图
	private List<Object> data; 							// 系列中的数据内容数组。数组项通常为具体的数据项,与 xAxis.data 一一对应

	public Series() {
		super();
	}
	
	public Series(String name) {
		super();
		this.name = name;
	}

	public Series(String id, String name, String type, String coordinateSystem, Integer xAxisIndex, Integer yAxisIndex,
			Integer polarIndex, String symbol, Integer symbolSize, Integer symbolRotate, boolean symbolKeepAspect,
			boolean showSymbol, String stack, String cursor, boolean connectNulls, boolean clipOverflow, boolean step,
			List<Object> data) {
		super();
		this.name = name;
		this.type = type;
		this.coordinateSystem = coordinateSystem;
		this.xAxisIndex = xAxisIndex;
		this.yAxisIndex = yAxisIndex;
		this.polarIndex = polarIndex;
		this.symbol = symbol;
		this.symbolSize = symbolSize;
		this.symbolRotate = symbolRotate;
		this.symbolKeepAspect = symbolKeepAspect;
		this.showSymbol = showSymbol;
		this.stack = stack;
		this.cursor = cursor;
		this.connectNulls = connectNulls;
		this.clipOverflow = clipOverflow;
		this.step = step;
		this.data = data;
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

	public String getCoordinateSystem() {
		return coordinateSystem;
	}

	public void setCoordinateSystem(String coordinateSystem) {
		this.coordinateSystem = coordinateSystem;
	}

	public Integer getxAxisIndex() {
		return xAxisIndex;
	}

	public void setxAxisIndex(Integer xAxisIndex) {
		this.xAxisIndex = xAxisIndex;
	}

	public Integer getyAxisIndex() {
		return yAxisIndex;
	}

	public void setyAxisIndex(Integer yAxisIndex) {
		this.yAxisIndex = yAxisIndex;
	}

	public Integer getPolarIndex() {
		return polarIndex;
	}

	public void setPolarIndex(Integer polarIndex) {
		this.polarIndex = polarIndex;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getSymbolSize() {
		return symbolSize;
	}

	public void setSymbolSize(Integer symbolSize) {
		this.symbolSize = symbolSize;
	}

	public Integer getSymbolRotate() {
		return symbolRotate;
	}

	public void setSymbolRotate(Integer symbolRotate) {
		this.symbolRotate = symbolRotate;
	}

	public boolean isSymbolKeepAspect() {
		return symbolKeepAspect;
	}

	public void setSymbolKeepAspect(boolean symbolKeepAspect) {
		this.symbolKeepAspect = symbolKeepAspect;
	}

	public boolean isShowSymbol() {
		return showSymbol;
	}

	public void setShowSymbol(boolean showSymbol) {
		this.showSymbol = showSymbol;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	public boolean isConnectNulls() {
		return connectNulls;
	}

	public void setConnectNulls(boolean connectNulls) {
		this.connectNulls = connectNulls;
	}

	public boolean isClipOverflow() {
		return clipOverflow;
	}

	public void setClipOverflow(boolean clipOverflow) {
		this.clipOverflow = clipOverflow;
	}

	public boolean isStep() {
		return step;
	}

	public void setStep(boolean step) {
		this.step = step;
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
