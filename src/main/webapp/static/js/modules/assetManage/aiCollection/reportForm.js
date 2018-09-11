layui.extend({
	echarts: '{/}' + ctxStatic + '/layui/lay/echarts/echarts',
	layuiRequest: '{/}' + ctxStatic + '/layui/layuiRequest',
	customerFrom: '{/}' + ctxStatic + '/layui/lay/custom/from'
})

layui.use(['layuiRequest','form','layer','laytpl','laydate','echarts','customerFrom'],function() {
	var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        layuiRequest = layui.layuiRequest,
        form = layui.form,
        laytpl = layui.laytpl,
        laydate = layui.laydate,
        echarts = layui.echarts,
        customerFrom = layui.customerFrom;
	
    laydate.render({
    	elem:'#startDay',			// 绑定元素
    	theme: '#393D49', 			// 自定义背景色主题
    	calendar: true,				// 显示公历节日
    	mark: {'0-0-10': '工资'}, 	//每个月10号
		done: function(value, date, endDate){
			if($('#endDay').val() == '' || 
					new Date(Date.parse(value)) >= new Date(Date.parse($('#endDay').val()))) {
				$("#endDay").val(value);
			}
		}
    });
    laydate.render({
    	elem:'#endDay',
    	theme: '#393D49',
    	calendar: true,
    	mark: {'0-0-10': '工资'},
		done: function(value, date, endDate){
			if($('#startDay').val() == '') {
				return;
			}
			// 判断结束日期是否大于开始日期
			if(new Date(Date.parse($('#startDay').val())) >= 
				new Date(Date.parse(value))) {
				$('#endDay').val($('#startDay').val());
			}
		}
    });
    
	var foldLineEcharts = echarts.init($('#reportForm')[0]);
	// 初始化报表视图
	layuiRequest.loadEcharts(ctx + '/assetManage/aiCollection/reportForm', customerFrom.serializeJson($("#sesarchForm")), foldLineEcharts);
	
    // 条件搜索
    form.on('submit(search)', function(data) {
    	layuiRequest.loadEcharts(ctx + '/assetManage/aiCollection/reportForm', data.field, foldLineEcharts);
    	return false;
    });
	
    // 自适应屏幕
	$(window).on("resize",function() {
		foldLineEcharts.resize(); 
    })
})
