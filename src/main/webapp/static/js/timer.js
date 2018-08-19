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

    var timerListIns =  table.render({
        elem: '#timerList', 						//	指定原始表格元素选择器（推荐id选择器）
        url : ctx + '/timer/manage/findList', 		//	数据接口
        cellMinWidth : 50, 							//	（layui 2.2.1 新增）全局定义所有常规单元格的最小宽度（默认：60），一般用于列宽自动分配的情况。其优先级低于表头参数中的 minWidth
        loading : true, 							//	是否显示加载条
        page : true, 								//	开启分页
        limit : 20, 								//	每页显示的条数（默认：10）。值务必对应 limits 参数的选项。优先级低于 page 参数中的 limit 参数。
        limits : [10,15,20,25], 					//	每页条数的选择项
        id : "timerList", 							//	设定容器唯一ID
        text: { 									//	自定义文本
            none: '暂无相关数据' 						//	默认：无数据。注：该属性为 layui 2.2.5 开始新增
        },
        response: { 								// 定义后端 json 格式，详细参见官方文档
        	statusName: 'code', 					// 数据状态的字段名称，默认：code
        	statusCode: 0, 							// 成功的状态码，默认：0
        	msgName: 'msg', 						// 状态信息的字段名称，默认：msg
        	countName: 'total', 					// 数据总数的字段名称，默认：count
        	dataName: 'list' 						// 数据列表的字段名称，默认：data
        },
        request: {									// 定义前端 json 格式
        	  pageName: 'page', 					// 页码的参数名称，默认：page
        	  limitName: 'pageSize' 				// 每页数据量的参数名，默认：limit
        },  
        cols : [[
            {field: 'id', title: 'ID', minWidth: 100, fixed: 'left', sort: 'true', align: 'center'},
            {field: 'name', title: '任务名', align:'center'},
            {field: 'startDate', title: '起始时间', sort: 'true', align:'center'},
            {field: 'endDate', title: '结束时间', sort: 'true', align:'center'},
            {field: 'status', title: '当前状态', minWidth:100, templet: '#timerStatus', align:'center'},
            {title: '操作', fixed:"right", align: 'center', templet:'#timerListBar'}
        ]]
    });
    
    // 启用/禁用任务
    form.on('switch(timerStatus)', function(data) {
        var tipText = '确定禁用当前任务？';
        var url = $(data.elem).data("stop");
        if(data.elem.checked) {
            tipText = '确定启用当前任务？';
            var url = $(data.elem).data("start");
        }
        
        layer.msg(tipText, {
        	time: 0, 
        	btn: ['确定', '取消'],
            btn1: function(index, layero) {
            	// 启用/禁用定时任务
            	request.operatTimer(form, data, index, ctx + url);
            },
            btn2: function(index, layero) {
            	// 取消
            	data.elem.checked = !data.elem.checked;
            	form.render();
            	layer.close(index);
            }
        });
        
    });
    
    //列表操作
    table.on('tool(timerList)', function(obj){
		switch (obj.event) {
		
		case "edit":
			// 编辑
			editTimer(obj.data);
			break;
			
		default:
			break;
		}
    });
    
    //编辑定时任务
    function editTimer(data) {
		layer.open({
            type: 2,
            title: '编辑定时任务', 		// 不显示标题栏
            closeBtn: 1,			// 关闭按钮
            area: ['820px', '500px'],
            shade: 0, 				// 遮罩
            shadeClose: false, 		// 是否点击遮罩关闭
            offset: 'auto',			// 垂直水平居中
            anim: 0, 				// 弹出动画
            isOutAnim: true, 		// 关闭动画
            scrollbar: false, 		// 是否允许浏览器出现滚动条
            maxmin: true, 			// 最大最小化
            id: 'LAY_EditTimer', 	// 用于控制弹层唯一标识
            moveType: 1,
            content: [ctx + '/timer/manage/strategy?id=' + data.id, 'no'],
            cancel: function(index, layero) {
            },
            end:function(index) {
            	timerListIns.reload();
           }
    	});
    }

    //控制表格编辑时文本的位置【跟随渲染时的位置】
    $("body").on("click",".layui-table-body.layui-table-main tbody tr td",function(){
        $(this).find(".layui-table-edit").addClass("layui-"+$(this).attr("align"));
    });

})