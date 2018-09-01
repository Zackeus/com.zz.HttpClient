layui.extend({
	request: '{/}' + ctxStatic + '/js/request'
})

layui.use(['request','form','layer','laydate','table','laytpl','tree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table,
        request = layui.request,
        tree = layui.tree;
    
    // 选择菜单下拉选
    layui.tree({
    	elem:"#classtree",
    	nodes:[{name: '常用文件夹',id: 1,alias: 'changyong',children: [{name: '所有未读',id: 11,href: 'http://www.layui.com/',alias: 'weidu'}, {name: '置顶邮件',id: 12}, {name: '标签邮件',id: 13}]}, {name: '我的邮箱',id: 2,spread: true,children: [{name: 'QQ邮箱',id: 21,spread: true,children: [{name: '收件箱',id: 211,children: [{name: '所有未读',id: 2111}, {name: '置顶邮件',id: 2112}, {name: '标签邮件',id: 2113}]}, {name: '已发出的邮件',id: 212}, {name: '垃圾邮件',id: 213}]}, {name: '阿里云邮',id: 22,children: [{name: '收件箱',id: 221}, {name: '已发出的邮件',id: 222}, {name: '垃圾邮件',id: 223}]}]}],
    	click:function(node) {
    		var $select=$($(this)[0].elem).parents(".layui-form-select");
    		$select.removeClass("layui-form-selected").find(".layui-select-title span").html(node.name).end().find("input:hidden[name='parentId']").val(node.id);
    	}
    });
	  
	$(".downpanel").on("click",".layui-select-title",function(e) {
		$(".layui-form-select").not($(this).parents(".layui-form-select")).removeClass("layui-form-selected");
		$(this).parents(".downpanel").toggleClass("layui-form-selected");
		layui.stope(e);
	}).on("click","dl i",function(e) {
		layui.stope(e);
	});
	  
	$(document).on("click",function(e) {
		$(".layui-form-select").removeClass("layui-form-selected");
	});
	
	// 菜单图标
    $('#choseIcon').click(function () {
    	var index = layui.layer.open({
            type: 2,
            title: '设置菜单图标', 		// 不显示标题栏
            skin: 'layui-layer-lan',
            closeBtn: 1,			// 关闭按钮
            area: ['100%', '100%'],
            shade: 0, 				// 遮罩
            shadeClose: true, 		// 是否点击遮罩关闭
            offset: 'auto',			// 垂直水平居中
            anim: 0, 				// 弹出动画
            isOutAnim: true, 		// 关闭动画
            scrollbar: true, 		// 是否允许浏览器出现滚动条
            maxmin: true, 			// 最大最小化
            id: 'LAY_Icon', 		// 用于控制弹层唯一标识
            moveType: 1,
            content: [ctx + '/sys/area/icon']
    	});
    });
    
    form.on('submit(addMenu)', function(data) {
    	request.addMenu(ctx + '/sys/menu/add', data.field, $(this));
    	return false;
    });
    
})