<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>定时任务配置主页</title>
	<meta name="decorator" content="default"/>
</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote">
		<a class="layui-btn layui-btn-sm" href="${ctx}/testTimer/updateCron?cron=*/5 * * * * ?">启动</a>
		<a class="layui-btn layui-btn-sm" href="${ctx}/testTimer/stopCron">关闭</a>
	</blockquote>

	<form class="layui-form" onkeydown="if(event.keyCode==13) return false;">
		<table id="userGrade" lay-filter="userGrade"></table>
		
		<script type="text/html" id="gradeIcon">
		{{#  if(d.gradeIcon === 'icon-vip1'){ }}
		<span class="seraph vip1 {{d.gradeIcon}}"></span>
		{{#  } else if(d.gradeIcon === 'icon-vip2'){ }}
		<span class="seraph vip2 {{d.gradeIcon}}"></span>
		{{#  } else if(d.gradeIcon === 'icon-vip3'){ }}
		<span class="seraph vip3 {{d.gradeIcon}}"></span>
		{{#  } else if(d.gradeIcon === 'icon-vip4'){ }}
		<span class="seraph vip4 {{d.gradeIcon}}"></span>
		{{#  } else if(d.gradeIcon === 'icon-vip5'){ }}
		<span class="seraph vip5 {{d.gradeIcon}}"></span>
		{{#  } else if(d.gradeIcon === 'icon-vip6'){ }}
		<span class="seraph vip6 {{d.gradeIcon}}"></span>
		{{#  } else if(d.gradeIcon === 'icon-vip7'){ }}
		<span class="seraph vip7 {{d.gradeIcon}}"></span>
		{{#  }}}
	</script>
		<script type="text/html" id="gradeBar">
		<input type="checkbox" name="gradeStatus" lay-filter="gradeStatus" lay-skin="switch" lay-text="启用|禁用" checked>
	</script>
	</form>
	
	<script type="text/javascript" src="${ctxStatic}/js/timer.js"></script>
</body>
</html>