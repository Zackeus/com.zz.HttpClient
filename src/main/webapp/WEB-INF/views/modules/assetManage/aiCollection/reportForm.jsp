<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>催收统计</title>
	<meta name="decorator" content="default"/>
</head>
<body class="childrenBody">
	<form id="sesarchForm" class="layui-form" onkeydown="if(event.keyCode==13) return false;">
		<blockquote class="layui-elem-quote quoteBox">
			条件搜索：
			<div class="layui-inline">
	      		<div class="layui-input-inline">
	        		<input id="startDay" name="startDay" class="layui-input" type="text" lay-verify="required|date" placeholder="起始日期" 
	        			autocomplete="off" value="<fmt:formatDate value="${defaultSearch.startDay}" pattern="yyyy-MM-dd" />">
	      		</div>
	      		-
	      		<div class="layui-input-inline">
	        		<input id="endDay" name="endDay" class="layui-input" type="text" lay-verify="required|date" placeholder="结束日期" 
	        			autocomplete="off" value="<fmt:formatDate value="${defaultSearch.endDay}" pattern="yyyy-MM-dd" />">
	      		</div>
	    	</div>
    			<div class="layui-input-inline" style="width: 100px;">
    				<select id="startHour" name="startHour" lay-verify="required|number">
						<c:forEach items="${fns:getDictList('sys_time_hour')}" var="obj">
							<c:choose>
								<c:when test="${obj.value == defaultSearch.startHour}">
									<option value="${obj.value}" selected="selected">${obj.label}</option>
								</c:when>
								<c:otherwise>
									<option value="${obj.value}">${obj.label}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
    			</div>
    			-
    			<div class="layui-input-inline" style="width: 100px;">
    			    <select id="endHour" name="endHour" lay-verify="required|number">
						<c:forEach items="${fns:getDictList('sys_time_hour')}" var="obj">
							<c:choose>
								<c:when test="${obj.value == defaultSearch.endHour}">
									<option value="${obj.value}" selected="selected">${obj.label}</option>
								</c:when>
								<c:otherwise>
									<option value="${obj.value}">${obj.label}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
    			</div>
 			</div>
	    	<button class="layui-btn" lay-submit lay-filter="search"><i class="layui-icon layui-icon-search"></i></button>
		</blockquote>
	</form>
	
    <div id="reportForm" class="layui-echarts"></div>
    <script type="text/javascript" src="${ctxStatic}/js/modules/assetManage/aiCollection/reportForm.js"></script>
</body>
</html>