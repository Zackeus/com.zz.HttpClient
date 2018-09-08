layui.extend({
	layuiRequest: '{/}' + ctxStatic + '/layui/layuiRequest'
})

layui.use(['layuiRequest','form','layer','laydate','table','laytpl','tree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table,
        layuiRequest = layui.layuiRequest,
        tree = layui.tree,
    	treeSelectData;
    
    // 树形菜单下拉选点击
	$(".downpanel").on("click",".layui-select-title",function(e) {
		if (!treeSelectData) {
			getTreeSelect();
		}
		$(".layui-form-select").not($(this).parents(".layui-form-select")).removeClass("layui-form-selected");
		$(this).parents(".downpanel").toggleClass("layui-form-selected");
		layui.stope(e);
	}).on("click","dl i",function(e) {
		layui.stope(e);
	});
	  
	$(document).on("click",function(e) {
		$(".layui-form-select").removeClass("layui-form-selected");
	});
	
	// 树形菜单 Select 渲染
	function getTreeSelect() {
	    $.ajax({
			method: 'POST',
			url : ctx + '/sys/menu/choseMenu',
			dataType : 'json',
	        success: function (result) {
	            // 选择菜单下拉选
	            layui.tree({
	            	elem:'#classtree',
	            	href:'javascript:;',
	            	nodes:result,
	            	click:function(node) {
	            		var $select=$($(this)[0].elem).parents(".layui-form-select");
	            		$select.removeClass("layui-form-selected").find(".layui-select-title span").html(node.name).end().find("input:hidden[name='parentId']").val(node.id);
	            		
	            		var sortMsg = layuiRequest.getMaxMenuSort(ctx + '/sys/menu/maxMenuSort/' + node.id);
	            		if (sortMsg.code == "0") {
	            			$('#sort').val(sortMsg.customObj.sort);
	            		}
	            	}
	            });
	            treeSelectData = result;
	        },
			error : function(result) {
				layer.msg('加载菜单树形列表失败', {icon: 5,time: 2000,shift: 6}, function(){});
			}
	    })
	}
	
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
    
	// 清除图标
    $('#clearIcon').click(function () {
    	$('#icon').val('');
    	$('#iconCode').val('无');
    	$("#iconStyle").attr('class', 'layui-icon');
    });
    
    $('#closeMenu').click(function () {
    	parent.layer.close(parent.layer.getFrameIndex(window.name));
    });
    
    form.on('submit(addMenu)', function(data) {
    	layuiRequest.addMenu(ctx + '/sys/menu/add', data.field, $(this));
    	return false;
    });
    
})