<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>折线图</title>
	<meta name="decorator" content="default"/>
</head>
<body class="childrenBody">
    <div class="demoTable">
        <blockquote class="layui-elem-quote">
            特别声明：ECharts，一个纯 Javascript 的图表库，可以流畅的运行在 PC 和移动设备上，兼容当前绝大部分浏览器（IE8/9/10/11，Chrome，Firefox，Safari等），底层依赖轻量级的 Canvas 类库 ZRender，提供直观，生动，可交互，可高度个性化定制的数据可视化图表。WeAdmin提示：如需使用或者详细更多案例可以访问官网 <a href="http://echarts.baidu.com/" style="color:red">ECharts</a>。
        </blockquote>
        <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
        <div id="main" style="width: 100%;height:400px;"></div>
        <blockquote class="layui-elem-quote">
            注意：本案例的Echarts图表库由cdn引入，需要在线才能正常使用，若要离线使用，请至Echarts官网下载。
        </blockquote>
    </div>
    <script type="text/javascript" src="${ctxStatic}/js/modules/demo/foldLine.js"></script>
</body>
</html>