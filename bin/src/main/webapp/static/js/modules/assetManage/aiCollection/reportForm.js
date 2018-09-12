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
    
	var myEcharts = echarts.init($('#reportForm')[0]);
	var echartsData = customerFrom.serializeJson($("#sesarchForm"));
	echartsData.typeName = $('#type option:selected').text();
	// 初始化报表视图
	layuiRequest.loadEcharts(ctx + '/assetManage/aiCollection/reportForm', echartsData, myEcharts);
	
	// 统计图类型选择
	form.on('select(type)', function(data) {
		// 隐藏
		for(var i=0; i < $("#type option").length; i++) {
			$('#' + data.elem.options[i].value).css('display','none');
		}
		// 显示选中
		$('#' + data.value).css('display','initial');
	});
	
    // 条件搜索
    form.on('submit(search)', function(data) {
    	data.field.typeName = $('#type option:selected').text();
    	layuiRequest.loadEcharts(ctx + '/assetManage/aiCollection/reportForm', data.field, myEcharts);
    	return false;
    });
	
    // 自适应屏幕
	$(window).on("resize",function() {
		myEcharts.resize(); 
    })
    
    // 自定义校验
    form.verify({
    	customRequired: function(value, item) {
    		// 父级div 是否隐藏
    		if($(item).parent().parent().is(":visible")) {
        		if(value.trim().length == 0) {
        			return '必填项不能为空';
        		}
    		}
    	},
    	customNumber: function(value, item) {
    		if($(item).parent().parent().is(":visible")) {
        		if(!/^[-+]?\d*$/.test(value.trim())) {
        			return '只能填写数字';
        		}
    		}
    	}
    });  
})
