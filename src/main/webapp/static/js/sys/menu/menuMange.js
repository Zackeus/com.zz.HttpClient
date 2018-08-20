layui.extend({
	treetable: '{/}' + ctxStatic + '/layui-2.2.5/lay/tree/treetable'
});	
	    
layui.use(['table', 'treetable'], function() {
    var $ = layui.jquery;
    var table = layui.table;
    var treetable = layui.treetable;

    // 渲染表格
    layer.load();
    treetable.render ({
    	height: 'full-20', 						//高度最大化减去差值
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
            {field: 'name', minWidth: 200, title: '菜单名称'},
            {field: 'href', align: 'center', title: '链接'},
            {field: 'sort', width: 80, align: 'center', title: '排序'},
            {templet: '#auth-state', width: 180, align: 'center', title: '操作'}
        ]],
        done: function () {
            layer.closeAll('loading');
        }
    });

    // 全部展开
    $('#btn-expand').click(function () {
        treetable.expandAll('#menulist');
    });

    // 全部折叠
    $('#btn-fold').click(function () {
        treetable.foldAll('#menulist');
    });
});