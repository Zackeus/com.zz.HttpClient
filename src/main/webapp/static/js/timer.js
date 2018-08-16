layui.config({
	base : ctxStatic + "/js/"
}).extend({
	"request" : "request"
})

layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table,
        request = layui.request;

    //添加验证规则
    form.verify({
        oldPwd : function(value, item){
            if(value != "123456"){
                return "密码错误，请重新输入！";
            }
        },
        newPwd : function(value, item){
            if(value.length < 6){
                return "密码长度不能小于6位";
            }
        },
        confirmPwd : function(value, item){
            if(!new RegExp($("#oldPwd").val()).test(value)){
                return "两次输入密码不一致，请重新输入！";
            }
        }
    })

    
    table.render({
        elem: '#timerList', 						//指定原始表格元素选择器（推荐id选择器）
        url : ctx + '/timer/manage/findList', 		//数据接口
        cellMinWidth : 80, 							//（layui 2.2.1 新增）全局定义所有常规单元格的最小宽度（默认：60），一般用于列宽自动分配的情况。其优先级低于表头参数中的 minWidth
        loading : true, 							// 是否显示加载条
        page : true, 								//开启分页
        limit : 20, 								//每页显示的条数（默认：10）。值务必对应 limits 参数的选项。优先级低于 page 参数中的 limit 参数。
        limits : [10,15,20,25], 					// 每页条数的选择项
        id : "timerList", 							// 设定容器唯一ID
        text: { 									//  自定义文本
            none: '暂无相关数据' 						//默认：无数据。注：该属性为 layui 2.2.5 开始新增
        },
        cols : [[
            {field: 'id', title: 'ID', minWidth: 180, fixed: 'left', sort: 'true', align: 'center'},
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
        var layEvent = obj.event,
            data = obj.data;
        console.log(data);
        
		switch (layEvent) {
		
		case "edit":
			// 编辑
//			editUser(data);
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