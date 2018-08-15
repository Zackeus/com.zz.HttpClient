layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

    $(".loginBody .seraph").click(function(){
        layer.msg("这只是做个样式，至于功能，你见过哪个后台能这样登录的？还是老老实实的找管理员去注册吧",{
            time:5000
        });
    })

    //登录按钮
    form.on("submit(login)",function(data) {
    	var btnSubmit = $(this);
		$.ajax({
			method: 'POST',
			url : ctx + '/sys/login',
			data : data.field,
			dataType : 'json',
			beforeSend: function(){
				btnSubmit.text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
			},
			success : function(result) {
				if (result.code == "0") {
					location.href = ctx + '/sys/area/index';
				} else {
					layer.msg(result.message, {icon: 5,time: 2000,shift: 6}, function(){});
					btnSubmit.text("登录").attr("disabled",false).removeClass("layui-disabled");
				}
			},
			error : function(result) {
				// 错误信息
				layer.msg('响应失败', {icon: 5,time: 2000,shift: 6}, function(){});
				btnSubmit.text("登录").attr("disabled",false).removeClass("layui-disabled");
			}
		});
		// 阻止form表单submit
		return false;
    })

    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
})
