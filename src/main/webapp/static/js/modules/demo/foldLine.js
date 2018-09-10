layui.extend({
	echarts: '{/}' + ctxStatic + '/layui/lay/echarts/echarts'
})

layui.use(['layer','laytpl','echarts'],function() {
	var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        echarts = layui.echarts;
	
	var foldLineEcharts = echarts.init($('#main')[0]); 
	// 指定图表的配置项和数据
	var option = {
	    title: {
	        text: '折线图堆叠', 					// 主标题文本
	        textStyle: {
		        fontStyle: 'italic', 			// 主标题文字字体的风格
		        fontWeight: 'bolder', 			// 主标题文字字体的粗细
		        fontFamily: 'Microsoft YaHei', 	// 主标题文字的字体系列
		        fontSize: 25,					// 主标题文字的字体大小
		        align: 'center',				// 文字水平对齐方式，默认自动
		        verticalAlign: 'middle',		// 文字垂直对齐方式，默认自动
		        lineHeight: 56,					// 行高
		        textBorderColor: 'transparent',	// 文字本身的描边颜色
		        textBorderWidth: 0,				// 文字本身的描边宽度
		        textShadowColor: 'transparent', // 文字本身的阴影颜色
		        textShadowBlur: 0				// 文字本身的阴影长度
	        }
	    },
	    tooltip: {								// 提示框组件
	        trigger: 'axis'						// 触发类型 'axis' 坐标轴触发
	    },
	    legend: {								// 图例组件
	    	type: 'scroll',						// 图例的类型 'plain'：普通图例,'scroll'：可滚动翻页的图例
	        data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
	    },
	    grid: {
	    	show: true,							// 是否显示直角坐标系网格
	    	top: '25%',
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    toolbox: {								// 工具栏
	    	right: '3%',						// 工具栏组件离容器右侧的距离
	    	feature: {							// 各工具配置项
	            saveAsImage: {},				// 保存为图片
	            magicType: {					// 动态类型切换 
	                type: ['line', 'bar', 'stack', 'tiled']
	            }
	        }
	    },
	    xAxis: {								// 直角坐标系 grid 中的 x 轴
	        type: 'category',					// 坐标轴类型 'category' 类目轴
	        boundaryGap: false,					// 坐标轴两边留白策略
	        nameTextStyle: {					// 坐标轴名称的文字样式
	        	fontFamily: 'Microsoft YaHei'	// 坐标轴名称文字的字体系列
	        },
	        data: ['周一','周二','周三','周四','周五','周六','周日']
	    },
	    yAxis: {								// 直角坐标系 grid 中的 y 轴
	        type: 'value',						// 坐标轴类型 'value' 数值轴
	        nameTextStyle: {					// 坐标轴名称的文字样式
	        	fontWeight: 200,				// 坐标轴名称文字字体的粗细
	        	fontFamily: 'Microsoft YaHei'	// 坐标轴名称文字的字体系列
	        }
	    },
	    series: [
	        {
	            name:'邮件营销',
	            type:'line',
	            data:[120, 132, 101, 134, 90, 230, 210]
	        },
	        {
	            name:'联盟广告',
	            type:'line',
	            data:[220, 182, 191, 234, 290, 330, 310]
	        },
	        {
	            name:'视频广告',
	            type:'line',
	            data:[150, 232, 201, 154, 190, 330, 410]
	        },
	        {
	            name:'直接访问',
	            type:'line',
	            data:[320, 332, 301, 334, 390, 330, 320]
	        },
	        {
	            name:'搜索引擎',
	            type:'line',
	            data:[820, 932, 901, 934, 1290, 1330, 1320]
	        }
	    ]
	};
	
	// 使用刚指定的配置项和数据显示图表。
	foldLineEcharts.setOption(option);
	
	// 动态类型切换事件
	foldLineEcharts.on('magictypechanged', function (params) {
		switch (params.currentType) {
		
		case "line":
			console.log('切换折线图');
			foldLineEcharts.setOption({title:{text:'切换折线图'}});
			break;
			
		case "bar":
			console.log('切换柱状图');
			foldLineEcharts.setOption({title:{text:'切换柱状图'}});
			break;
			
		case "stack":
			console.log('切换数据堆叠');
			foldLineEcharts.setOption({title:{text:'切换数据堆叠'}});
			break;
			
		case "tiled":
			console.log('切换数据平铺');
			foldLineEcharts.setOption({title:{text:'切换数据平铺'}});
			break;
			
		default:
			break;
		}
	});

    // 自适应屏幕
	$(window).on("resize",function() {
		foldLineEcharts.resize(); 
    })

})
