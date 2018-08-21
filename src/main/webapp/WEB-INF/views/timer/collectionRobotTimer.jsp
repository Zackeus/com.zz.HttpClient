<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>催收任务</title>
	<meta name="decorator" content="default"/>
</head>
<body class="childrenBody">
	<form class="layui-form" onkeydown="if(event.keyCode==13) return false;">
		<table id="collectionRobotTimerList" lay-filter="collectionRobotTimerList"></table>
		
		<script type="text/javascript" id="customerStyle">
			{{d.customerStyle.name}}
		</script>
		
		<script type="text/html" id="timerStatus">
			{{#  if(d.status){ }}
				<input type="checkbox" name="timerStatus" lay-filter="timerStatus" lay-skin="switch" lay-text="启用|禁用" 
				data-start="{{d.startUrl}}" data-stop="{{d.stopUrl}}" checked>
			{{#  } else { }}
				<input type="checkbox" name="timerStatus" lay-filter="timerStatus" lay-skin="switch" lay-text="启用|禁用" 
				data-start="{{d.startUrl}}" data-stop="{{d.stopUrl}}">
			{{#  }}}
		</script>
		
		<script type="text/html" id="timerListBar">
			<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="edit">编辑</a>
		</script>
	</form>
	
	<script type="text/javascript" src="${ctxStatic}/js/timer/collectionRobotTimer.js"></script>
</body>
</html>