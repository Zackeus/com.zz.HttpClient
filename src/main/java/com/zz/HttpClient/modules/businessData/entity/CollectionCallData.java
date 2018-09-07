package com.zz.HttpClient.modules.businessData.entity;

import java.io.Serializable;

/**
 * 
 * @Title:CollectionCallData
 * @Description:TODO(外呼交互内容)
 * @Company:
 * @author zhou.zhang
 * @date 2018年7月8日 下午5:21:03
 */
public class CollectionCallData implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long index; 		// 排序索引
	private String nodeId; 		// 节点 ID
	private String node; 		// 节点名称
	private String robot; 		// 机器人语音
	private String hitId; 		// 回答节点
	private String hitName; 	// 识别结果
	private String result; 		// 识别结果

	public CollectionCallData() {
		super();
	}

	public CollectionCallData(Long index, String nodeId, String node, String robot, String hitId, String hitName,
			String result) {
		super();
		this.index = index;
		this.nodeId = nodeId;
		this.node = node;
		this.robot = robot;
		this.hitId = hitId;
		this.hitName = hitName;
		this.result = result;
	}

	public Long getIndex() {
		return index;
	}

	public void setIndex(Long index) {
		this.index = index;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getRobot() {
		return robot;
	}

	public void setRobot(String robot) {
		this.robot = robot;
	}

	public String getHitId() {
		return hitId;
	}

	public void setHitId(String hitId) {
		this.hitId = hitId;
	}

	public String getHitName() {
		return hitName;
	}

	public void setHitName(String hitName) {
		this.hitName = hitName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "CollectionCallData [index=" + index + ", nodeId=" + nodeId + ", node=" + node + ", robot=" + robot
				+ ", hitId=" + hitId + ", hitName=" + hitName + ", result=" + result + "]";
	}

}
