layui.extend({
	request: '{/}' + ctxStatic + '/js/request'
})

layui.use(['request','form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table,
        request = layui.request;
    
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
    
    form.on('submit(editTimer)', function(data){
    	  console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
    	  console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
    	  console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
    	  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

})