<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>编辑任务</title>
	<meta name="decorator" content="default"/>
</head>
<body class="childrenBody">
	<form id="editTimerForm" class="layui-form layui-form-pane">
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">任务ID</label>
			<div class="layui-input-block">
				<input id="jobName" name="jobName" type="text" class="layui-input" value="${dialTestTimer.jobName}" readonly>
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">任务组名</label>
			<div class="layui-input-block">
				<input id="jobGroupName" name="jobGroupName" type="text" class="layui-input" value="${dialTestTimer.jobGroupName}" readonly>
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">执行类</label>
			<div class="layui-input-block">
				<input id="jobClass" name="jobClass" type="text" class="layui-input" value="${dialTestTimer.jobClass}" readonly>
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">任务名</label>
			<div class="layui-input-block">
				<input id="name" name="name" type="text" class="layui-input" value="${dialTestTimer.name}" lay-verify="required" placeholder="请输入任务名">
			</div>
		</div>
		 <div class="layui-form-item layui-inline">
		    <label class="layui-form-label">逾期天数</label>
		    <div class="layui-input-inline" style="width: 100px;">
		      <input id="startDay" name="startDay" type="text" class="layui-input" value="${dialTestTimer.startDay}" lay-verify="required|number">
		    </div>
		    <div class="layui-form-mid">-</div>
		    <div class="layui-input-inline" style="width: 100px;">
		      <input id="endDay" name="endDay" type="text" class="layui-input" value="${dialTestTimer.endDay}" lay-verify="required|number">
		    </div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">手机标签</label>
		    <div class="layui-input-block">
		    	<c:forEach items="${fns:getDictList('mobile_phone_label')}" var="obj">
		    		<c:choose>
			    		<c:when test="${fn:contains(dialTestTimer.mobileLabels, obj.value)}">
			    			<input type="checkbox" name="mobileLabels.${obj.value}" title="${obj.label}" checked>
			    		</c:when>
			    		<c:otherwise>
			    			<input type="checkbox" name="mobileLabels.${obj.value}" title="${obj.label}">
	                    </c:otherwise>
                    </c:choose>
				</c:forEach>
		    </div>
		</div>
		
		<div class="layui-form-item">
		    <label class="layui-form-label">用户类型</label>
		    <div class="layui-input-block">
		      <select id="customerStyleId" name="customerStyleId" lay-verify="required">
		      	<option value="">请选择类别</option>
				<c:forEach items="${fns:getDictList('customer_type')}" var="obj">
					<c:choose>
						<c:when test="${obj.id == dialTestTimer.customerStyle.id}">
							<option value="${obj.id}" selected="selected">${obj.label}</option>
						</c:when>
						<c:otherwise>
							<option value="${obj.id}">${obj.label}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
		      </select>
		    </div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">定时策略</label>
			<div class="layui-input-block">
				<input id="jobTime" name="jobTime" type="text" class="layui-input" value="${dialTestTimer.jobTime}" readonly>
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">备注</label>
		    <div class="layui-input-block">
		    	<textarea id="remarks" name="remarks" class="layui-textarea" placeholder="请输入内容">${dialTestTimer.remarks}</textarea>
		    </div>
		</div>
		<div class="layui-form-item">
	    	<div class="layui-input-block">
	      		<button class="layui-btn" lay-submit lay-filter="editTimer">提交</button>
	      		<button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    	</div>
	 	</div>
	</form>
	
	<script type="text/javascript" src="${ctxStatic}/js/sys/timer/dialTestTimer/editTimer.js"></script>
</body>
</html>