<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>增加字典</title>
	<meta name="decorator" content="default"/>
</head>
<body class="childrenBody">

	<form class="layui-form layui-form-pane">
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">字典键值</label>
			<div class="layui-input-block">
				<input id="value" name="value" type="text" class="layui-input" lay-verify="required" placeholder="请输入字典键值">
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">字典标签</label>
			<div class="layui-input-block">
				<input id="label" name="label" type="text" class="layui-input" lay-verify="required" placeholder="请输入字典标签">
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">字典类型</label>
			<div class="layui-input-block">
				<input id="type" name="type" type="text" class="layui-input" lay-verify="required" placeholder="请输入字典类型">
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">字典描述</label>
			<div class="layui-input-block">
				<input id="description" name="description" type="text" class="layui-input" lay-verify="required" placeholder="请输入字典描述">
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">字典排序</label>
			<div class="layui-input-block">
				<input id="sort" name="sort" type="text" class="layui-input" lay-verify="required|number" placeholder="请输入字典排序">
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
	      		<button class="layui-btn" lay-submit lay-filter="addDict">提交</button>
	      		<button id="closeDict" class="layui-btn layui-btn-primary" type="button">关闭</button>
	    	</div>
	 	</div>
	</form>

	<script type="text/javascript" src="${ctxStatic}/js/sys/dict/addDict.js"></script>
</body>
</html>