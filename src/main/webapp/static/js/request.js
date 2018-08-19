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
							layer.msg(result.message, {icon: 5,time: 2000,shift: 6}, function(){});
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
        					layer.msg('操作成功', {icon: 6,time: 1000});
        				} else {
        					layer.msg(result.message, {icon: 5,time: 2000,shift: 6}, function(){});
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
			}
	};
	exports('request', obj);
})
