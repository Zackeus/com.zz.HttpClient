layui.extend({
	layuiRequest: '{/}' + ctxStatic + '/layui/layuiRequest'
})

layui.use(['layuiRequest','form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table,
        layuiRequest = layui.layuiRequest;
    
    $('#jobTime').click(function () {
    	var index = layui.layer.open({
            type: 2,
            title: '编辑定时任务', 		// 不显示标题栏
            closeBtn: 1,			// 关闭按钮
            area: ['820px', '500px'],
            shade: 0, 				// 遮罩
            shadeClose: false, 		// 是否点击遮罩关闭
            offset: 'rt',			// 垂直水平居中
            anim: 0, 				// 弹出动画
            isOutAnim: true, 		// 关闭动画
            scrollbar: false, 		// 是否允许浏览器出现滚动条
            maxmin: true, 			// 最大最小化
            id: 'LAY_CronTimer', 	// 用于控制弹层唯一标识
            moveType: 1,
            content: [ctx + '/timer/collectionRobot/cron', 'no']
    	});
    });
    
    form.on('submit(addTimer)', function(data) {
    	layuiRequest.addTimer(ctx + '/timer/collectionRobot/addJob', data.field, $(this));
    	return false;
    });
    
})