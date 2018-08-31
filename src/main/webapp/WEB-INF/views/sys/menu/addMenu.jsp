<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>增加菜单</title>
	<meta name="decorator" content="default"/>
	<style type="text/css">
	.downpanel .layui-select-title span{line-height: 38px;}
	.downpanel dl dd:hover{background-color: inherit;}
	
	.layui-icon-input i{
		position: absolute;
		left:15px;
		top:50%;
		margin-top: 8px;
	}
	.layui-icon-input .layui-input {
		padding-right: 30px;
		margin-left: 40px;
	}
	.choseIcon {
		margin-left: 40px;
	}
	</style>
</head>
<body class="childrenBody">

	<form class="layui-form layui-form-pane">
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">父级菜单</label>
			<div class="layui-input-block">
				<div class="layui-unselect layui-form-select downpanel">
					<div class="layui-select-title">
						<span id="treeclass" class="layui-input layui-unselect">功能菜单</span>
						<input id="parentId" name="parentId" type="hidden" value="1">
						<i class="layui-edge"></i>
					</div>
					<dl class="layui-anim layui-anim-upbit">
						<dd>
							<ul id="classtree"></ul>
						</dd>
					</dl>						
				</div>
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">菜单名称</label>
			<div class="layui-input-block">
				<input id="name" name="name" type="text" class="layui-input" lay-verify="required" placeholder="请输入菜单名称">
			</div>
		</div>
		<div class="layui-form-item layui-row layui-col-xs12">
			<label class="layui-form-label">菜单图标</label>
			<div class="layui-inline">
				<div class="layui-input-inline layui-icon-input">
					<input id="icon" name="icon" type="text" class="layui-input" style="display:none">
					<input id="iconCode" name="iconCode" type="text" class="layui-input" value="无" disabled>
					<i id="iconStyle" name="iconStyle" class="layui-icon" style="top: 1px;"></i>
				</div>
				<div class="layui-input-inline">
					<button id="choseIcon" class="layui-btn choseIcon" type="button"><i class="layui-icon layui-icon-tianjia"></i></button>
                </div>
			</div>
		</div>
		<div class="layui-form-item">
	    	<div class="layui-input-block">
	      		<button class="layui-btn" lay-submit lay-filter="addMenu">提交</button>
	      		<button class="layui-btn layui-btn-primary" lay-filter="closeMenu" type="button">关闭</button>
	    	</div>
	 	</div>
	</form>

	<script type="text/javascript" src="${ctxStatic}/js/sys/menu/addMenu.js"></script>
</body>
</html>