<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>增加定时任务</title>
	<meta name="decorator" content="default"/>
</head>
<body class="childrenBody">

	<form id='addTimerForm' class="layui-form layui-form-pane">
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">任务名</label>
			<div class="layui-input-block">
				<input id="name" name="name" type="text" class="layui-input" lay-verify="required" placeholder="请输入任务名">
			</div>
		</div>
		 <div class="layui-form-item layui-inline">
		    <label class="layui-form-label">逾期天数</label>
		    <div class="layui-input-inline" style="width: 100px;">
		      <input id="startDay" name="startDay" type="text" class="layui-input" lay-verify="required|number" placeholder="起始天数">
		    </div>
		    <div class="layui-form-mid">-</div>
		    <div class="layui-input-inline" style="width: 100px;">
		      <input id="endDay" name="endDay" type="text" class="layui-input" lay-verify="required|number" placeholder="结束天数">
		    </div>
		</div>
		<div class="layui-form-item">
		    <label class="layui-form-label">用户类型</label>
		    <div class="layui-input-block">
		      <select id="customerStyleId" name="customerStyleId" lay-verify="required">
		      	<option value="">请选择类别</option>
				<c:forEach items="${fns:getDictList('customer_type')}" var="obj">
					<option value="${obj.id}">${obj.label}</option>
				</c:forEach>
		      </select>
		    </div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机标签</label>
		    <div class="layui-input-block">
		    	<c:forEach items="${fns:getDictList('mobile_phone_label')}" var="obj">
		    		<input type="checkbox" name="mobileLabels.${obj.value}" title="${obj.label}">
				</c:forEach>
		    </div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">定时策略</label>
			<div class="layui-input-block">
				<input id="jobTime" name="jobTime" type="text" class="layui-input" placeholder="请设置定时策略" lay-verify="required" readonly>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">状态</label>
	    	<div class="layui-input-block">
	      		<input id="status" name="status" type="checkbox" lay-skin="switch" lay-text="启用|禁用" value="true">
	    	</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">备注</label>
		    <div class="layui-input-block">
		    	<textarea id="remarks" name="remarks" class="layui-textarea" placeholder="请输入内容"></textarea>
		    </div>
		</div>
		<div class="layui-form-item">
	    	<div class="layui-input-block">
	      		<button class="layui-btn" lay-submit lay-filter="addTimer">提交</button>
	      		<button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    	</div>
	 	</div>
	</form>

	<script type="text/javascript" src="${ctxStatic}/js/sys/timer/dialTestTimer/addTimer.js"></script>
</body>
</html>