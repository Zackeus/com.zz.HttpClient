layui.define(['jquery','layer'],function(exports){
	var	$ = layui.$,
		layer = parent.layer === undefined ? layui.layer : top.layer;
	var obj = {
			// 用户登录
			login: function (url, data, loginBtn) {
				$.ajax({
					method: 'POST',
					url : url,
					data : data,
					dataType : 'json',
					beforeSend: function(){
						loginBtn.text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
					},
					success : function(result) {
						if (result.code == "0") {
							location.href = ctx + '/sys/area/index';
						} else {
							layer.msg(result.msg, {icon: 5,time: 2000,shift: 6}, function(){});
							loginBtn.text("登录").attr("disabled",false).removeClass("layui-disabled");
						}
					},
					error : function(result) {
						// 错误信息
						layer.msg('响应失败', {icon: 5,time: 2000,shift: 6}, function(){});
						loginBtn.text("登录").attr("disabled",false).removeClass("layui-disabled");
					}
				});
			},
			// 增加定时任务
			addTimer: function (url, data, btn) {
        		$.ajax({
        			method: 'POST',
        			url : url,
        			contentType : 'application/json',
        			dataType : 'json',
        			data : JSON.stringify(data),
        			beforeSend: function() {
        				btn.text("提交中...").attr("disabled","disabled").addClass("layui-disabled");
        			},
        			success : function(result) {
        				if (result.code == "0") {
        					layer.msg(result.msg, {icon: 6,time: 1000});
        					parent.layer.close(parent.layer.getFrameIndex(window.name));
        				} else {
							layer.msg(result.msg, {icon: 5,time: 2000,shift: 6}, function(){});
							btn.text("提交").attr("disabled",false).removeClass("layui-disabled");
        				}
        			},
        			error : function(result) {
        				layer.msg('响应失败', {icon: 5,time: 2000,shift: 6}, function(){});
        				btn.text("提交").attr("disabled",false).removeClass("layui-disabled");
        			}
        		});
			},
			// 启用/禁用定时任务
			operatTimer: function (form, data, index, url) {
        		$.ajax({
        			method: 'POST',
        			url : url,
        			dataType : 'json',
        			beforeSend: function() {
        				layer.close(index);
        				layer.load();
        			},
        			success : function(result) {
        				layer.closeAll('loading');
        				if (result.code == "0") {
        					layer.msg(result.msg, {icon: 6,time: 1000});
        				} else {
        					layer.msg(result.msg, {icon: 5,time: 2000,shift: 6}, function(){});
                        	data.elem.checked = !data.elem.checked;
                        	form.render();
        				}
        			},
        			error : function(result) {
        				// 错误信息
        				layer.closeAll('loading');
        				layer.msg('响应失败', {icon: 5,time: 2000,shift: 6}, function(){});
                    	data.elem.checked = !data.elem.checked;
                    	form.render();
        			}
        		});
			},
			// 编辑定时任务
			editTimer: function (url, data, btn) {
        		$.ajax({
        			method: 'POST',
        			url : url,
        			contentType : 'application/json',
        			dataType : 'json',
        			data : JSON.stringify(data),
        			beforeSend: function() {
        				btn.text("提交中...").attr("disabled","disabled").addClass("layui-disabled");
        			},
        			success : function(result) {
        				if (result.code == "0") {
        					layer.msg(result.msg, {icon: 6,time: 1000});
        					parent.layer.close(parent.layer.getFrameIndex(window.name));
        				} else {
							layer.msg(result.msg, {icon: 5,time: 2000,shift: 6}, function(){});
							btn.text("提交").attr("disabled",false).removeClass("layui-disabled");
        				}
        			},
        			error : function(result) {
        				layer.msg('响应失败', {icon: 5,time: 2000,shift: 6}, function(){});
        				btn.text("提交").attr("disabled",false).removeClass("layui-disabled");
        			}
        		});
			},
			// 删除定时任务
			delTimer: function (url, data, index, tableIns) {
        		$.ajax({
        			method: 'POST',
        			url : url,
        			dataType : 'json',
        			data : {
        				jobName : data.jobName
        			},
        			beforeSend: function() {
        				layer.close(index);
        				layer.load();
        			},
        			success : function(result) {
        				layer.closeAll('loading');
        				if (result.code == "0") {
        					layer.msg(result.msg, {icon: 6,time: 1000});
        					tableIns.reload();
        				} else {
							layer.msg(result.msg, {icon: 5,time: 2000,shift: 6}, function(){});
        				}
        			},
        			error : function(result) {
        				layer.closeAll('loading');
        				layer.msg('响应失败', {icon: 5,time: 2000,shift: 6}, function(){});
        			}
        		});
			},
			// 获取菜单最大排序
			getMaxMenuSort: function (url) {
				var returnMsg;
        		$.ajax({
        			async : false,
        			method : 'POST',
        			url : url,
        			dataType : 'json',
        			success : function(result) {
        				returnMsg = result;
        			},
        			error : function(result) {
        			}
        		});
        		return returnMsg;
			},
			// 添加菜单
			addMenu: function (url, data, btn) {
        		$.ajax({
        			method: 'POST',
        			url : url,
        			contentType : 'application/json',
        			dataType : 'json',
        			data : JSON.stringify(data),
        			beforeSend: function() {
        				btn.text("提交中...").attr("disabled","disabled").addClass("layui-disabled");
        			},
        			success : function(result) {
        				if (result.code == "0") {
        					layer.msg(result.msg, {icon: 6,time: 1000});
        					parent.layer.close(parent.layer.getFrameIndex(window.name));
        				} else {
							layer.msg(result.msg, {icon: 5,time: 2000,shift: 6}, function(){});
							btn.text("提交").attr("disabled",false).removeClass("layui-disabled");
        				}
        			},
        			error : function(result) {
        				layer.msg('响应失败', {icon: 5,time: 2000,shift: 6}, function(){});
        				btn.text("提交").attr("disabled",false).removeClass("layui-disabled");
        			}
        		});
			},
			// 编辑菜单
			editMenu: function (url, data, btn) {
        		$.ajax({
        			method: 'POST',
        			url : url,
        			contentType : 'application/json',
        			dataType : 'json',
        			data : JSON.stringify(data),
        			beforeSend: function() {
        				btn.text("提交中...").attr("disabled","disabled").addClass("layui-disabled");
        			},
        			success : function(result) {
        				if (result.code == "0") {
        					layer.msg(result.msg, {icon: 6,time: 1000});
        					parent.layer.close(parent.layer.getFrameIndex(window.name));
        				} else {
							layer.msg(result.msg, {icon: 5,time: 2000,shift: 6}, function(){});
							btn.text("提交").attr("disabled",false).removeClass("layui-disabled");
        				}
        			},
        			error : function(result) {
        				layer.msg('响应失败', {icon: 5,time: 2000,shift: 6}, function(){});
        				btn.text("提交").attr("disabled",false).removeClass("layui-disabled");
        			}
        		});
			},
			// 删除菜单
			delMenu: function (data, index, url, tableIns) {
        		$.ajax({
        			method: 'POST',
        			url : url,
        			data : JSON.stringify(data),
        			contentType : 'application/json',
        			dataType : 'json',
        			beforeSend: function() {
        				layer.close(index);
        				layer.load();
        			},
        			success : function(result) {
        				layer.closeAll('loading');
        				if (result.code == "0") {
        					layer.msg(result.msg, {icon: 6,time: 1000});
        					tableIns.reload();
        				} else {
        					layer.msg(result.msg, {icon: 5,time: 2000,shift: 6}, function(){});
        				}
        			},
        			error : function(result) {
        				// 错误信息
        				layer.closeAll('loading');
        				layer.msg('响应失败', {icon: 5,time: 2000,shift: 6}, function(){});
        			}
        		});
			}
	};
	exports('request', obj);
})
