<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>编辑任务</title>
	<meta name="decorator" content="default"/>
</head>
<body class="childrenBody">
	<form class="layui-form layui-form-pane">
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">任务ID</label>
			<div class="layui-input-block">
				<input id="jobName" name="jobName" type="text" class="layui-input" value="${commonTimer.jobName}" disabled>
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">任务组名</label>
			<div class="layui-input-block">
				<input id="jobGroupName" name="jobGroupName" type="text" class="layui-input" value="${commonTimer.jobGroupName}" disabled>
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">执行类</label>
			<div class="layui-input-block">
				<input id="jobClass" name="jobClass" type="text" class="layui-input" value="${commonTimer.jobClass}" disabled>
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">任务名</label>
			<div class="layui-input-block">
				<input id="name" name="name" type="text" class="layui-input" value="${commonTimer.name}" lay-verify="required" placeholder="请输入任务名">
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">定时策略</label>
			<div class="layui-input-block">
				<input id="jobTime" name="jobTime" type="text" class="layui-input" value="${commonTimer.jobTime}" readonly>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">异常重启</label>
	    	<div class="layui-input-block">
	      		<input id="restart" name="restart" type="checkbox" lay-skin="switch" lay-text="启用|禁用" value="true" ${commonTimer.restart ? 'checked' : ''}>
	    	</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">备注</label>
		    <div class="layui-input-block">
		    	<textarea id="remarks" name="remarks" class="layui-textarea" placeholder="请输入内容">${commonTimer.remarks}</textarea>
		    </div>
		</div>
		<div class="layui-form-item">
	    	<div class="layui-input-block">
	      		<button class="layui-btn" lay-submit lay-filter="editTimer">提交</button>
	      		<button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    	</div>
	 	</div>
	</form>
	
	<script type="text/javascript" src="${ctxStatic}/js/sys/timer/commonTimer/editTimer.js"></script>
</body>
</html>