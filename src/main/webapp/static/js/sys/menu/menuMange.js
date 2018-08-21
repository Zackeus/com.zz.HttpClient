layui.extend({
	treetable: '{/}' + ctxStatic + '/layui-2.2.5/lay/tree/treetable',
	request: '{/}' + ctxStatic + '/js/request'
});	
	    
layui.use(['table', 'treetable', 'request', 'layer'], function() {
    var $ = layui.jquery,
    	layer = parent.layer === undefined ? layui.layer : top.layer,
    	table = layui.table,
    	treetable = layui.treetable,
    	request = layui.request;

    // 渲染表格
    layer.load();
    treetable.render ({
        treeColIndex: 1,						// 树形图标显示在第几列
        treeSpid: 1,							// 最上级的父级id
        treeIdName: 'id',						// id字段的名称
        treePidName: 'parentId',				// pid字段的名称
        treeDefaultClose: true,					// 是否默认折叠
        treeLinkage: false,						// 父级展开时是否自动展开所有子级
        elem: '#menulist',
        url: ctx + '/sys/menu/mangeList',
        page: false,
        cols: [[
            {type: 'numbers'},
            {field: 'name', minWidth: 170, title: '菜单名称'},
            {field: 'href', align: 'center', title: '链接'},
            {templet: '#menu-icon', width: 80,  align: 'center', title: '图标'},
            {field: 'sort', width: 80, align: 'center', title: '排序'},
            {templet: '#menu-operate', width: 180, align: 'center', title: '操作'}
        ]],
        done: function () {
            layer.closeAll('loading');
        }
    });
    
    //列表操作
    table.on('tool(menulist)', function(obj){
		switch (obj.event) {
		
		case "add":
			console.log('增加');
			break;
			
		case "edit":
			console.log('编辑');
			break;
			
		case "del":
			delMenu(obj.data);
			break;
			
		default:
			break;
		}
    });
    
    function delMenu(data) {
        layer.msg('确定要删除此菜单?', {
        	time: 0, 
        	btn: ['确定', '取消'],
            btn1: function(index, layero) {
            	request.delMenu(data, index, ctx + '/sys/menu/del');
            },
            btn2: function(index, layero) {
            	layer.close(index);
            }
        });
    }

    // 全部展开
    $('#btn-expand').click(function () {
        treetable.expandAll('#menulist');
    });

    // 全部折叠
    $('#btn-fold').click(function () {
        treetable.foldAll('#menulist');
    });
});