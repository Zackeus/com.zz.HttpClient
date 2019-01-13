<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>拨号测试任务</title>
	<meta name="decorator" content="default"/>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote quoteBox">
		<div class="demoTable">
			<div class="layui-inline">
		    	<div class="layui-input-inline">
		    		<button id="addTimer" class="layui-btn"><i class="layui-icon">&#xe608;</i> 添加</button>
		    	</div>
			</div>
		</div>
	</blockquote>

	<form class="layui-form" onkeydown="if(event.keyCode==13) return false;">
		<table id="timerList" lay-filter="timerList"></table>
		
		<script type="text/html" id="timerStatus">
			{{#  if(d.status){ }}
				<input type="checkbox" name="timerStatus" value="{{d.jobName}}" lay-filter="timerStatus" lay-skin="switch" lay-text="启用|禁用" checked>
			{{#  } else { }}
				<input type="checkbox" name="timerStatus" value="{{d.jobName}}" lay-filter="timerStatus" lay-skin="switch" lay-text="启用|禁用">
			{{#  }}}
		</script>
		
		<script type="text/html" id="timerListBar">
			<a title=">编辑" class="layui-btn layui-btn-xs layui-btn-warm" lay-event="edit"><i class="layui-icon">&#xe642;</i></a>
			<a title="删除" class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del"><i class="layui-icon">&#xe640;</i></a>
		</script>
	</form>
	
	<script type="text/javascript" src="${ctxStatic}/js/sys/timer/dialTestTimer/main.js"></script>
</body>
</html>