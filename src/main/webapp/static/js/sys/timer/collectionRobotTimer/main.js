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

    var collectionRobotListIns =  table.render({
        elem: '#collectionRobotTimerList',
        url : ctx + '/timer/collectionRobot/findList',
        cellMinWidth : 50, 							//	（layui 2.2.1 新增）全局定义所有常规单元格的最小宽度（默认：60），一般用于列宽自动分配的情况。其优先级低于表头参数中的 minWidth
        loading : true, 							//	是否显示加载条
        page : true, 								//	开启分页
        limit : 20, 								//	每页显示的条数（默认：10）。值务必对应 limits 参数的选项。优先级低于 page 参数中的 limit 参数。
        limits : [10,15,20,25], 					//	每页条数的选择项
        id : "collectionRobotTimerList", 			//	设定容器唯一ID
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
            {field: 'jobName', title: 'ID', minWidth: 100, fixed: 'left', sort: 'true', align: 'center'},
            {field: 'name', title: '任务名', align:'center'},
            {field: 'startDay', title: '逾期天数', sort: 'true', align:'center'},
            {field: 'endDay', title: '逾期天数', sort: 'true', align:'center'},
            {templet: '<div>{{d.customerStyle.name}}</div>', title: '客户类型', align:'center'},
            {field: 'jobTime', title: '定时策略', align:'center'},
            {field: 'status', title: '当前状态', minWidth:100, templet: '#timerStatus', align:'center'},
            {title: '操作', fixed:"right", align: 'center', templet:'#timerListBar'}
        ]]
    });
    
    // 启用/禁用任务
    form.on('switch(timerStatus)', function(data) {
        var tipText = '确定禁用当前任务？';
        var url = ctx + '/timer/collectionRobot/stopJob?jobName=' + this.value;
        if(data.elem.checked) {
            tipText = '确定启用当前任务？';
            url = ctx + '/timer/collectionRobot/startJob?jobName=' + this.value;
        }
        
        layer.msg(tipText, {
        	time: 0, 
        	btn: ['确定', '取消'],
            btn1: function(index, layero) {
            	// 启用/禁用定时任务
            	request.operatTimer(form, data, index, url);
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
    table.on('tool(collectionRobotTimerList)', function(obj){
		switch (obj.event) {
		
		case "edit":
			editTimer(obj.data);
			break;
			
		case "del":
			delTimer(obj.data);
			break;
			
		default:
			break;
		}
    });
    
    // 编辑定时任务
    function editTimer(data) {
    	var index = layui.layer.open({
            type: 2,
            title: '编辑定时任务', 		// 不显示标题栏
            closeBtn: 1,			// 关闭按钮
            shade: 0, 				// 遮罩
            shadeClose: false, 		// 是否点击遮罩关闭
            anim: 0, 				// 弹出动画
            isOutAnim: true, 		// 关闭动画
            scrollbar: false, 		// 是否允许浏览器出现滚动条
            maxmin: true, 			// 最大最小化
            id: 'LAY_EditTimer', 	// 用于控制弹层唯一标识
            moveType: 1,
            content: [ctx + '/timer/collectionRobot/editTimer?jobName=' + data.jobName],
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                setTimeout(function(){
                    layui.layer.tips('点击此处返回任务列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            },
            cancel: function(index, layero) {
            },
            end:function(index) {
            	collectionRobotListIns.reload();
           }
    	});
    	layui.layer.full(index);
        window.sessionStorage.setItem("index", index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function() {
        	layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    
    // 删除定时任务
    function delTimer(data) {
        layer.msg('确定删除此任务？', {
        	time: 0, 
        	btn: ['确定', '取消'],
            btn1: function(index, layero) {
            	request.delTimer(ctx + '/timer/collectionRobot/deleteJob', data, index, collectionRobotListIns);
            },
            btn2: function(index, layero) {
            	layer.close(index);
            }
        });
    }

    //控制表格编辑时文本的位置【跟随渲染时的位置】
    $("body").on("click",".layui-table-body.layui-table-main tbody tr td",function(){
        $(this).find(".layui-table-edit").addClass("layui-"+$(this).attr("align"));
    });

})