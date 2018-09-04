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

    var userListtIns =  table.render({
        elem: '#userList',
        url : ctx + '/sys/user/manage',
        cellMinWidth : 50, 							//	（layui 2.2.1 新增）全局定义所有常规单元格的最小宽度（默认：60），一般用于列宽自动分配的情况。其优先级低于表头参数中的 minWidth
        loading : true, 							//	是否显示加载条
        page : true, 								//	开启分页
        limit : 15, 								//	每页显示的条数（默认：10）。值务必对应 limits 参数的选项。优先级低于 page 参数中的 limit 参数。
        limits : [10,15,20,25], 					//	每页条数的选择项
        id : "userList", 							//	设定容器唯一ID
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
            {templet: '<div>{{d.company.name}}</div>', title: '归属公司', align:'center'},
            {templet: '<div>{{d.office.name}}</div>', title: '归属部门', align:'center'},
            {field: 'loginName', title: '登录名',  minWidth: 30, align:'center'},
            {field: 'name', title: '姓名', align:'center'},
            {field: 'userType', title: '用户类型', align:'center'},
            {field: 'phone', title: '电话', align:'center'},
            {field: 'mobile', title: '手机', align:'center'},
            {title: '操作', fixed:"right", align: 'center', templet:'#timerListBar'}
        ]]
    });
    
    //列表操作
    table.on('tool(userList)', function(obj){
		switch (obj.event) {
		
		case "edit":
			console.log(obj.data);
//			editTimer(obj.data);
			break;
			
		case "del":
//			delTimer(obj.data);
			break;
			
		default:
			break;
		}
    });
    
    //控制表格编辑时文本的位置【跟随渲染时的位置】
    $("body").on("click",".layui-table-body.layui-table-main tbody tr td",function(){
        $(this).find(".layui-table-edit").addClass("layui-"+$(this).attr("align"));
    });

})