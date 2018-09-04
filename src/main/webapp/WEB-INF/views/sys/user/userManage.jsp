<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>用户管理</title>
	<meta name="decorator" content="default"/>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote quoteBox">
		<div class="demoTable">
			<div class="layui-inline">
		    	<div class="layui-input-inline">
		    		<button id="addUser" class="layui-btn"><i class="layui-icon">&#xe608;</i> 添加</button>
		    	</div>
			</div>
		</div>
	</blockquote>

	<form class="layui-form" onkeydown="if(event.keyCode==13) return false;">
		<table id="userList" lay-filter="userList"></table>
		
		<script type="text/html" id="timerListBar">
			<a title=">编辑" class="layui-btn layui-btn-xs layui-btn-warm" lay-event="edit"><i class="layui-icon">&#xe642;</i></a>
		</script>
	</form>
	
	<script type="text/javascript" src="${ctxStatic}/js/sys/user/userMange.js"></script>
</body>
</html>