<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>图标设置</title>
	<meta name="decorator" content="default" />
	<style type="text/css">
	/* 宫格 */
	.site-doc-icon {margin-bottom: 50px;font-size: 0;}
	.site-doc-icon li {display: inline-block;vertical-align: middle;width: 200px;line-height: 35px;padding: 20px 0;margin-right: -1px;margin-bottom: -1px;border: 1px solid #e2e2e2;font-size: 14px;text-align: center;color: #666;transition: all .3s;-webkit-transition: all .3s;cursor: pointer;}
	.site-doc-icon li .layui-icon {display: inline-block;font-size: 38px;}
	.site-doc-icon li .fontclass {display: none;}
	.site-doc-icon li .name {color: #c2c2c2;}
	.site-doc-icon li .code {text-overflow: ellipsis;white-space: nowrap;overflow: hidden;padding: 5px;}
	.site-doc-icon li:hover {background-color: #f2f2f2;color: #000;}
	.zai-class {background-color: #fff;line-height: 30px;border: 1px solid #ece9e9;position: fixed;top: 0px;box-shadow: 0 5px 15px #c3bebe;}
	.zai-class ul li {text-align: center;font-size: 14px;line-height: 20px;font-family: inherit;float: left;padding: 10px;border: 1px solid #e6e3e3;width: 90px;cursor: pointer;}
	.layui-card-body {width: 99%;}
	</style>
</head>
<body class="childrenBody">
	<div style="width: 99%; height: 135px;"></div>
	<div class="layui-fluid">
		<div class="layui-card">
			<div class="layui-card-header" style="text-align: center; font-size: 25px;" id="layui">layui图标库列表</div>
			<div class="layui-card-body">
				<ul class="site-doc-icon">
					<li>
						<i class="layui-icon layui-icon-duihua"></i>
						<div class="name">对话</div>
						<div class="code">layui-icon-duihua</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-shezhi"></i>
						<div class="name">设置</div>
						<div class="code">layui-icon-shezhi</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-yinshenim"></i>
						<div class="name">隐身im</div>
						<div class="code">layui-icon-yinshenim</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-search"></i>
						<div class="name">搜索</div>
						<div class="code">layui-icon-search</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-fenxiang1"></i>
						<div class="name">分享</div>
						<div class="code">layui-icon-fenxiang1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-shezhi1"></i>
						<div class="name">设置1</div>
						<div class="code">layui-icon-shezhi1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-yinqing"></i>
						<div class="name">引擎</div>
						<div class="code">layui-icon-yinqing</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-close"></i>
						<div class="name">关闭</div>
						<div class="code">layui-icon-close</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-close-fill"></i>
						<div class="name">关闭-fill</div>
						<div class="code">layui-icon-close-fill</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-baobiao"></i>
						<div class="name">报表</div>
						<div class="code">layui-icon-baobiao</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-star"></i>
						<div class="name">星星</div>
						<div class="code">layui-icon-star</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-yuandian"></i>
						<div class="name">圆点</div>
						<div class="code">layui-icon-yuandian</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-chat"></i>
						<div class="name">聊天</div>
						<div class="code">layui-icon-chat</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-logo"></i>
						<div class="name">logo</div>
						<div class="code">layui-icon-logo</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-list"></i>
						<div class="name">列表</div>
						<div class="code">layui-icon-list</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-tubiao"></i>
						<div class="name">图表</div>
						<div class="code">layui-icon-tubiao</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ok-circle"></i>
						<div class="name">ok-圆圈</div>
						<div class="code">layui-icon-ok-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-huanfu2"></i>
						<div class="name">换肤</div>
						<div class="code">layui-icon-huanfu2</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-On-line"></i>
						<div class="name">在线</div>
						<div class="code">layui-icon-On-line</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-biaoge"></i>
						<div class="name">表格</div>
						<div class="code">layui-icon-biaoge</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-right"></i>
						<div class="name">右箭头</div>
						<div class="code">layui-icon-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-left"></i>
						<div class="name">左箭头</div>
						<div class="code">layui-icon-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-cart-simple"></i>
						<div class="name">购物车</div>
						<div class="code">layui-icon-cart-simple</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-cry"></i>
						<div class="name">哭</div>
						<div class="code">layui-icon-cry</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-smile"></i>
						<div class="name">笑</div>
						<div class="code">layui-icon-smile</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-survey"></i>
						<div class="name">调查</div>
						<div class="code">layui-icon-survey</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-tree"></i>
						<div class="name">树</div>
						<div class="code">layui-icon-tree</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-iconfont17"></i>
						<div class="name">上箭头-圆圈</div>
						<div class="code">layui-icon-iconfont17</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-tianjia"></i>
						<div class="name">添加</div>
						<div class="code">layui-icon-tianjia</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-download-circle"></i>
						<div class="name">下箭头-圆圈</div>
						<div class="code">layui-icon-download-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-xuanzemoban48"></i>
						<div class="name">选择模板</div>
						<div class="code">layui-icon-xuanzemoban48</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-gongju"></i>
						<div class="name">工具</div>
						<div class="code">layui-icon-gongju</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-face-surprised"></i>
						<div class="name">惊讶</div>
						<div class="code">layui-icon-face-surprised</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-bianji"></i>
						<div class="name">编辑</div>
						<div class="code">layui-icon-bianji</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-speaker"></i>
						<div class="name">喇叭</div>
						<div class="code">layui-icon-speaker</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-down"></i>
						<div class="name">下箭头</div>
						<div class="code">layui-icon-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-wenjian"></i>
						<div class="name">文件</div>
						<div class="code">layui-icon-wenjian</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-layouts"></i>
						<div class="name">布局</div>
						<div class="code">layui-icon-layouts</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-duigou"></i>
						<div class="name">√对勾</div>
						<div class="code">layui-icon-duigou</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-tianjia1"></i>
						<div class="name">添加1</div>
						<div class="code">layui-icon-tianjia1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-yaoyaozhibofanye"></i>
						<div class="name">翻页</div>
						<div class="code">layui-icon-yaoyaozhibofanye</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-read"></i>
						<div class="name">阅读</div>
						<div class="code">layui-icon-read</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-404"></i>
						<div class="name">404</div>
						<div class="code">layui-icon-404</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-lunbozutu"></i>
						<div class="name">轮播组图</div>
						<div class="code">layui-icon-lunbozutu</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-help"></i>
						<div class="name">帮助</div>
						<div class="code">layui-icon-help</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-daima1"></i>
						<div class="name">代码</div>
						<div class="code">layui-icon-daima1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-jinshui"></i>
						<div class="name">进水</div>
						<div class="code">layui-icon-jinshui</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-username"></i>
						<div class="name">用户名</div>
						<div class="code">layui-icon-username</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-find-fill"></i>
						<div class="name">搜索-fill</div>
						<div class="code">layui-icon-find-fill</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-about"></i>
						<div class="name">关于</div>
						<div class="code">layui-icon-about</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-location"></i>
						<div class="name">坐标</div>
						<div class="code">layui-icon-location</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-up"></i>
						<div class="name">上箭头</div>
						<div class="code">layui-icon-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-pause"></i>
						<div class="name">暂停</div>
						<div class="code">layui-icon-pause</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-riqi"></i>
						<div class="name">日期</div>
						<div class="code">layui-icon-riqi</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-uploadfile"></i>
						<div class="name">上传</div>
						<div class="code">layui-icon-uploadfile</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-delete"></i>
						<div class="name">删除</div>
						<div class="code">layui-icon-delete</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-play"></i>
						<div class="name">播放</div>
						<div class="code">layui-icon-play</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-top"></i>
						<div class="name">返回顶部</div>
						<div class="code">layui-icon-top</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-haoyouqingqiu"></i>
						<div class="name">好友请求</div>
						<div class="code">layui-icon-haoyouqingqiu</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-refresh-3"></i>
						<div class="name">刷新</div>
						<div class="code">layui-icon-refresh-3</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-weibiaoti1"></i>
						<div class="name">对号</div>
						<div class="code">layui-icon-weibiaoti1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-chuangkou"></i>
						<div class="name">窗口</div>
						<div class="code">layui-icon-chuangkou</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-comiisbiaoqing"></i>
						<div class="name">表情</div>
						<div class="code">layui-icon-comiisbiaoqing</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhengque"></i>
						<div class="name">正确</div>
						<div class="code">layui-icon-zhengque</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-dollar"></i>
						<div class="name">美元</div>
						<div class="code">layui-icon-dollar</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-iconfontwodehaoyou"></i>
						<div class="name">我的好友</div>
						<div class="code">layui-icon-iconfontwodehaoyou</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-wenjianxiazai"></i>
						<div class="name">文件下载</div>
						<div class="code">layui-icon-wenjianxiazai</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-tupian"></i>
						<div class="name">图片</div>
						<div class="code">layui-icon-tupian</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-lianjie"></i>
						<div class="name">链接</div>
						<div class="code">layui-icon-lianjie</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-diamond"></i>
						<div class="name">钻石</div>
						<div class="code">layui-icon-diamond</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-jilu"></i>
						<div class="name">记录</div>
						<div class="code">layui-icon-jilu</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-liucheng"></i>
						<div class="name">流程</div>
						<div class="code">layui-icon-liucheng</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-fontstrikethrough"></i>
						<div class="name">删除线</div>
						<div class="code">layui-icon-fontstrikethrough</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-unlink"></i>
						<div class="name">断开链接</div>
						<div class="code">layui-icon-unlink</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-bianjiwenzi"></i>
						<div class="name">编辑文字</div>
						<div class="code">layui-icon-bianjiwenzi</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-sanjiao"></i>
						<div class="name">三角</div>
						<div class="code">layui-icon-sanjiao</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-danxuankuanghouxuan"></i>
						<div class="name">单选框候选</div>
						<div class="code">layui-icon-danxuankuanghouxuan</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-danxuankuangxuanzhong"></i>
						<div class="name">单选框选中</div>
						<div class="code">layui-icon-danxuankuangxuanzhong</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-juzhongduiqi"></i>
						<div class="name">居中对齐</div>
						<div class="code">layui-icon-juzhongduiqi</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-youduiqi"></i>
						<div class="name">右对齐</div>
						<div class="code">layui-icon-youduiqi</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zuoduiqi"></i>
						<div class="name">左对齐</div>
						<div class="code">layui-icon-zuoduiqi</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-gongsisvgtubiaozongji22"></i>
						<div class="name">复选框候选</div>
						<div class="code">layui-icon-gongsisvgtubiaozongji22</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-gongsisvgtubiaozongji23"></i>
						<div class="name">复选框选中</div>
						<div class="code">layui-icon-gongsisvgtubiaozongji23</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-refresh-2"></i>
						<div class="name">刷新-2</div>
						<div class="code">layui-icon-refresh-2</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-loading-1"></i>
						<div class="name">加载1</div>
						<div class="code">layui-icon-loading-1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-return"></i>
						<div class="name">返回</div>
						<div class="code">layui-icon-return</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-jiacu"></i>
						<div class="name">加粗</div>
						<div class="code">layui-icon-jiacu</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-uploading"></i>
						<div class="name">上传中</div>
						<div class="code">layui-icon-uploading</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-liaotianduihuaimgoutong"></i>
						<div class="name">聊天对话</div>
						<div class="code">layui-icon-liaotianduihuaimgoutong</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-video"></i>
						<div class="name">视频</div>
						<div class="code">layui-icon-video</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-headset"></i>
						<div class="name">耳机</div>
						<div class="code">layui-icon-headset</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-wenjianjiafan"></i>
						<div class="name">文件夹（反）</div>
						<div class="code">layui-icon-wenjianjiafan</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-shouji"></i>
						<div class="name">手机</div>
						<div class="code">layui-icon-shouji</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-tianjia2"></i>
						<div class="name">添加2</div>
						<div class="code">layui-icon-tianjia2</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-wenjianjia"></i>
						<div class="name">文件夹（反）</div>
						<div class="code">layui-icon-wenjianjia</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-biaoqing"></i>
						<div class="name">表情</div>
						<div class="code">layui-icon-biaoqing</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-html"></i>
						<div class="name">html</div>
						<div class="code">layui-icon-html</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-biaodan"></i>
						<div class="name">表单</div>
						<div class="code">layui-icon-biaodan</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-cart"></i>
						<div class="name">购物车</div>
						<div class="code">layui-icon-cart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-camera-fill"></i>
						<div class="name">相机-fill</div>
						<div class="code">layui-icon-camera-fill</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-25"></i>
						<div class="name">&nbsp;</div>
						<div class="code">layui-icon-25</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-emwdaima"></i>
						<div class="name">代码</div>
						<div class="code">layui-icon-emwdaima</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-fire"></i>
						<div class="name">火</div>
						<div class="code">layui-icon-fire</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-set"></i>
						<div class="name">设置</div>
						<div class="code">layui-icon-set</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zitixiahuaxian"></i>
						<div class="name">字体下划线</div>
						<div class="code">layui-icon-zitixiahuaxian</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-sanjiao1"></i>
						<div class="name">三角1</div>
						<div class="code">layui-icon-sanjiao1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-tips"></i>
						<div class="name">提示</div>
						<div class="code">layui-icon-tips</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-tupian-copy-copy"></i>
						<div class="name">图片</div>
						<div class="code">layui-icon-tupian-copy-copy</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-more-vertical"></i>
						<div class="name">更多-竖</div>
						<div class="code">layui-icon-more-vertical</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhuti2"></i>
						<div class="name">主题</div>
						<div class="code">layui-icon-zhuti2</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-loading"></i>
						<div class="name">加载</div>
						<div class="code">layui-icon-loading</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-xieti"></i>
						<div class="name">斜体</div>
						<div class="code">layui-icon-xieti</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-refresh-1"></i>
						<div class="name">刷新-1</div>
						<div class="code">layui-icon-refresh-1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-rmb"></i>
						<div class="name">人民币</div>
						<div class="code">layui-icon-rmb</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-home"></i>
						<div class="name">主页</div>
						<div class="code">layui-icon-home</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-user"></i>
						<div class="name">用户</div>
						<div class="code">layui-icon-user</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-notice"></i>
						<div class="name">注意</div>
						<div class="code">layui-icon-notice</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-login-weibo"></i>
						<div class="name">新浪微博登录</div>
						<div class="code">layui-icon-login-weibo</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-voice"></i>
						<div class="name">声音</div>
						<div class="code">layui-icon-voice</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-download"></i>
						<div class="name">上传</div>
						<div class="code">layui-icon-download</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-login-qq"></i>
						<div class="name">qq登录</div>
						<div class="code">layui-icon-login-qq</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-snowflake"></i>
						<div class="name">雪花</div>
						<div class="code">layui-icon-snowflake</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-yemian1"></i>
						<div class="name">页面</div>
						<div class="code">layui-icon-yemian1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-template"></i>
						<div class="name">模板</div>
						<div class="code">layui-icon-template</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-auz"></i>
						<div class="name">护盾</div>
						<div class="code">layui-icon-auz</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-console"></i>
						<div class="name">控制台</div>
						<div class="code">layui-icon-console</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-app"></i>
						<div class="name">app</div>
						<div class="code">layui-icon-app</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-prev"></i>
						<div class="name">前一个</div>
						<div class="code">layui-icon-prev</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-website"></i>
						<div class="name">站点</div>
						<div class="code">layui-icon-website</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-next"></i>
						<div class="name">后一个</div>
						<div class="code">layui-icon-next</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-component"></i>
						<div class="name">部件</div>
						<div class="code">layui-icon-component</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-more"></i>
						<div class="name">更多-横</div>
						<div class="code">layui-icon-more</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-login-wechat"></i>
						<div class="name">微信登录</div>
						<div class="code">layui-icon-login-wechat</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-shrink-right"></i>
						<div class="name">收缩</div>
						<div class="code">layui-icon-shrink-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-spread-left"></i>
						<div class="name">展开</div>
						<div class="code">layui-icon-spread-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-camera"></i>
						<div class="name">相机</div>
						<div class="code">layui-icon-camera</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-note"></i>
						<div class="name">便笺</div>
						<div class="code">layui-icon-note</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-refresh"></i>
						<div class="name">刷新</div>
						<div class="code">layui-icon-refresh</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-nv"></i>
						<div class="name">女</div>
						<div class="code">layui-icon-nv</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-nan"></i>
						<div class="name">男</div>
						<div class="code">layui-icon-nan</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-password"></i>
						<div class="name">密码</div>
						<div class="code">layui-icon-password</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-senior"></i>
						<div class="name">高级</div>
						<div class="code">layui-icon-senior</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-theme"></i>
						<div class="name">样式</div>
						<div class="code">layui-icon-theme</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-tread"></i>
						<div class="name">踩</div>
						<div class="code">layui-icon-tread</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-praise"></i>
						<div class="name">顶</div>
						<div class="code">layui-icon-praise</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-star-fill"></i>
						<div class="name">星星-fill</div>
						<div class="code">layui-icon-star-fill</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-template-1"></i>
						<div class="name">模板1</div>
						<div class="code">layui-icon-template-1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-loading-2"></i>
						<div class="name">加载2</div>
						<div class="code">layui-icon-loading-2</div>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<hr>
	<div class="layui-card-header" style="text-align: center; font-size: 25px;">第三方ICO图标库</div>
	<div class="layui-fluid">
		<div class="layui-card">
			<div class="layui-card-body">
				<ul class="site-doc-icon">
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-a">开发图标</div>
					<li>
						<i class="layui-icon layui-icon-zserver"></i>
						<div class="code">layui-icon-zserver</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zserver-l"></i>
						<div class="code">layui-icon-zserver-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zservers"></i>
						<div class="code">layui-icon-zservers</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhacker"></i>
						<div class="code">layui-icon-zhacker</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zkeyboard"></i>
						<div class="code">layui-icon-zkeyboard</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zkeyboard-l"></i>
						<div class="code">layui-icon-zkeyboard-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcommand"></i>
						<div class="code">layui-icon-zcommand</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcommand-l"></i>
						<div class="code">layui-icon-zcommand-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zusb"></i>
						<div class="code">layui-icon-zusb</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zusb-l"></i>
						<div class="code">layui-icon-zusb-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbug"></i>
						<div class="code">layui-icon-zbug</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbug-l"></i>
						<div class="code">layui-icon-zbug-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zsave"></i>
						<div class="code">layui-icon-zsave</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zsave-l"></i>
						<div class="code">layui-icon-zsave-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcode-file"></i>
						<div class="code">layui-icon-zcode-file</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcode-file-l"></i>
						<div class="code">layui-icon-zcode-file-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zfirewall"></i>
						<div class="code">layui-icon-zfirewall</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zfirewall-l"></i>
						<div class="code">layui-icon-zfirewall-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmicrochip"></i>
						<div class="code">layui-icon-zmicrochip</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmicrochip-l"></i>
						<div class="code">layui-icon-zmicrochip-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zprogram"></i>
						<div class="code">layui-icon-zprogram</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zconfiguration"></i>
						<div class="code">layui-icon-zconfiguration</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztab-select"></i>
						<div class="code">layui-icon-ztab-select</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zplatform"></i>
						<div class="code">layui-icon-zplatform</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztab"></i>
						<div class="code">layui-icon-ztab</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcontrol"></i>
						<div class="code">layui-icon-zcontrol</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcontrol-rank"></i>
						<div class="code">layui-icon-zcontrol-rank</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcode-plugin-l"></i>
						<div class="code">layui-icon-zcode-plugin-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcode-l"></i>
						<div class="code">layui-icon-zcode-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zoperation"></i>
						<div class="code">layui-icon-zoperation</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcode-edit-l"></i>
						<div class="code">layui-icon-zcode-edit-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zstorage-l"></i>
						<div class="code">layui-icon-zstorage-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcode-branch"></i>
						<div class="code">layui-icon-zcode-branch</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcode-fork"></i>
						<div class="code">layui-icon-zcode-fork</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zgreatwall"></i>
						<div class="code">layui-icon-zgreatwall</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztaiji"></i>
						<div class="code">layui-icon-ztaiji</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-b">基地图标</div>
					<li>
						<i class="layui-icon layui-icon-zcircle-o"></i>
						<div class="code">layui-icon-zcircle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcircle-l"></i>
						<div class="code">layui-icon-zcircle-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zsquare-o"></i>
						<div class="code">layui-icon-zsquare-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zsquare-l"> </i>
						<div class="code">layui-icon-zsquare-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztriangle-o"> </i>
						<div class="code">layui-icon-ztriangle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztriangle-l"> </i>
						<div class="code">layui-icon-ztriangle-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcamber-o"> </i>
						<div class="code">layui-icon-zcamber-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcamber-l"> </i>
						<div class="code">layui-icon-zcamber-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcup"> </i>
						<div class="code">layui-icon-zcup</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcup-l"> </i>
						<div class="code">layui-icon-zcup-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcalendar"> </i>
						<div class="code">layui-icon-zcalendar</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcalendar-l"> </i>
						<div class="code">layui-icon-zcalendar-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhome"> </i>
						<div class="code">layui-icon-zhome</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhome-l"> </i>
						<div class="code">layui-icon-zhome-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zimage"> </i>
						<div class="code">layui-icon-zimage</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zimage-l"> </i>
						<div class="code">layui-icon-zimage-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbuy"> </i>
						<div class="code">layui-icon-zbuy</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbuy-l"> </i>
						<div class="code">layui-icon-zbuy-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcomment"> </i>
						<div class="code">layui-icon-zcomment</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcomment-l"> </i>
						<div class="code">layui-icon-zcomment-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zchemistry"> </i>
						<div class="code">layui-icon-zchemistry</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zchemistry-l"> </i>
						<div class="code">layui-icon-zchemistry-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbookmark"> </i>
						<div class="code">layui-icon-zbookmark</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbookmark-l"> </i>
						<div class="code">layui-icon-zbookmark-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbook"> </i>
						<div class="code">layui-icon-zbook</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbook-l"> </i>
						<div class="code">layui-icon-zbook-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbuilding"> </i>
						<div class="code">layui-icon-zbuilding</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbuilding-l"> </i>
						<div class="code">layui-icon-zbuilding-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zgame"> </i>
						<div class="code">layui-icon-zgame</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zgame-l"> </i>
						<div class="code">layui-icon-zgame-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zheadset"> </i>
						<div class="code">layui-icon-zheadset</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zheadset-l"> </i>
						<div class="code">layui-icon-zheadset-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zgift"> </i>
						<div class="code">layui-icon-zgift</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zgift-l"> </i>
						<div class="code">layui-icon-zgift-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zheart"> </i>
						<div class="code">layui-icon-zheart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zheart-l"> </i>
						<div class="code">layui-icon-zheart-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zprinter"> </i>
						<div class="code">layui-icon-zprinter</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zprinter-l"> </i>
						<div class="code">layui-icon-zprinter-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zinbox"> </i>
						<div class="code">layui-icon-zinbox</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zinbox-l"> </i>
						<div class="code">layui-icon-zinbox-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zright-clipboard"> </i>
						<div class="code">layui-icon-zright-clipboard</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zright-clipboard-l"> </i>
						<div class="code">layui-icon-zright-clipboard-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlist-clipboard"> </i>
						<div class="code">layui-icon-zlist-clipboard</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlist-clipboard-l"> </i>
						<div class="code">layui-icon-zlist-clipboard-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztalk"> </i>
						<div class="code">layui-icon-ztalk</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztalk-l"> </i>
						<div class="code">layui-icon-ztalk-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztime"> </i>
						<div class="code">layui-icon-ztime</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztime-l"> </i>
						<div class="code">layui-icon-ztime-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbar-chart"> </i>
						<div class="code">layui-icon-zbar-chart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbar-chart-l"> </i>
						<div class="code">layui-icon-zbar-chart-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlock"> </i>
						<div class="code">layui-icon-zlock</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlock-l"> </i>
						<div class="code">layui-icon-zlock-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmusic"> </i>
						<div class="code">layui-icon-zmusic</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmusic-l"> </i>
						<div class="code">layui-icon-zmusic-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmusic-note"> </i>
						<div class="code">layui-icon-zmusic-note</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmusic-note-l"> </i>
						<div class="code">layui-icon-zmusic-note-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zfilm"> </i>
						<div class="code">layui-icon-zfilm</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zfilm-l"> </i>
						<div class="code">layui-icon-zfilm-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlight"> </i>
						<div class="code">layui-icon-zlight</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlight-l"> </i>
						<div class="code">layui-icon-zlight-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmedal"> </i>
						<div class="code">layui-icon-zmedal</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmedal-l"> </i>
						<div class="code">layui-icon-zmedal-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmouse"> </i>
						<div class="code">layui-icon-zmouse</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmouse-l"> </i>
						<div class="code">layui-icon-zmouse-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmicrophone"> </i>
						<div class="code">layui-icon-zmicrophone</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmicrophone-l"> </i>
						<div class="code">layui-icon-zmicrophone-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zvolume"> </i>
						<div class="code">layui-icon-zvolume</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zvolume-l"> </i>
						<div class="code">layui-icon-zvolume-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zwatch"> </i>
						<div class="code">layui-icon-zwatch</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zwatch-l"> </i>
						<div class="code">layui-icon-zwatch-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztag"> </i>
						<div class="code">layui-icon-ztag</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztag-l"> </i>
						<div class="code">layui-icon-ztag-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zwebcam"> </i>
						<div class="code">layui-icon-zwebcam</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zwebcam-l"> </i>
						<div class="code">layui-icon-zwebcam-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zsetting"> </i>
						<div class="code">layui-icon-zsetting</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zsetting-l"> </i>
						<div class="code">layui-icon-zsetting-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zstar"> </i>
						<div class="code">layui-icon-zstar</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zstar-l"> </i>
						<div class="code">layui-icon-zstar-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbell"> </i>
						<div class="code">layui-icon-zbell</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbell-l"> </i>
						<div class="code">layui-icon-zbell-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcloud"> </i>
						<div class="code">layui-icon-zcloud</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcloud-l"> </i>
						<div class="code">layui-icon-zcloud-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbattery"> </i>
						<div class="code">layui-icon-zbattery</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbattery-l"> </i>
						<div class="code">layui-icon-zbattery-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zairplane"> </i>
						<div class="code">layui-icon-zairplane</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zairplane-l"> </i>
						<div class="code">layui-icon-zairplane-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztrash"> </i>
						<div class="code">layui-icon-ztrash</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztrash-l"> </i>
						<div class="code">layui-icon-ztrash-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zfile"> </i>
						<div class="code">layui-icon-zfile</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zfile-l"> </i>
						<div class="code">layui-icon-zfile-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zdoc-file"> </i>
						<div class="code">layui-icon-zdoc-file</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zdoc-file-l"> </i>
						<div class="code">layui-icon-zdoc-file-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcomputer"> </i>
						<div class="code">layui-icon-zcomputer</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcomputer-l"> </i>
						<div class="code">layui-icon-zcomputer-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlaptop"> </i>
						<div class="code">layui-icon-zlaptop</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlaptop-l"> </i>
						<div class="code">layui-icon-zlaptop-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmobile"> </i>
						<div class="code">layui-icon-zmobile</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmobile-l"> </i>
						<div class="code">layui-icon-zmobile-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zuser"> </i>
						<div class="code">layui-icon-zuser</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zuser-l"> </i>
						<div class="code">layui-icon-zuser-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmessage"> </i>
						<div class="code">layui-icon-zmessage</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmessage-l"> </i>
						<div class="code">layui-icon-zmessage-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcamera"> </i>
						<div class="code">layui-icon-zcamera</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcamera-l"> </i>
						<div class="code">layui-icon-zcamera-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlocation"> </i>
						<div class="code">layui-icon-zlocation</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlocation-l"> </i>
						<div class="code">layui-icon-zlocation-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zread"> </i>
						<div class="code">layui-icon-zread</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zread-l"> </i>
						<div class="code">layui-icon-zread-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zclock"> </i>
						<div class="code">layui-icon-zclock</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zclock-l"> </i>
						<div class="code">layui-icon-zclock-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbluetooth"> </i>
						<div class="code">layui-icon-zbluetooth</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbluetooth-l"> </i>
						<div class="code">layui-icon-zbluetooth-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcalculator"> </i>
						<div class="code">layui-icon-zcalculator</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcalculator-l"> </i>
						<div class="code">layui-icon-zcalculator-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcoin"> </i>
						<div class="code">layui-icon-zcoin</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcoin-l"> </i>
						<div class="code">layui-icon-zcoin-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbriefcase"> </i>
						<div class="code">layui-icon-zbriefcase</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbriefcase-l"> </i>
						<div class="code">layui-icon-zbriefcase-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zeye"> </i>
						<div class="code">layui-icon-zeye</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zeye-l"> </i>
						<div class="code">layui-icon-zeye-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zruler"> </i>
						<div class="code">layui-icon-zruler</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zruler-l"> </i>
						<div class="code">layui-icon-zruler-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zclothes"> </i>
						<div class="code">layui-icon-zclothes</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zclothes-l"> </i>
						<div class="code">layui-icon-zclothes-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbrush"> </i>
						<div class="code">layui-icon-zbrush</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbrush-l"> </i>
						<div class="code">layui-icon-zbrush-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zrollerbrush"> </i>
						<div class="code">layui-icon-zrollerbrush</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zrollerbrush-l"> </i>
						<div class="code">layui-icon-zrollerbrush-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcrown"> </i>
						<div class="code">layui-icon-zcrown</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcrown-l"> </i>
						<div class="code">layui-icon-zcrown-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zboard"> </i>
						<div class="code">layui-icon-zboard</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zboard-l"> </i>
						<div class="code">layui-icon-zboard-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmap"> </i>
						<div class="code">layui-icon-zmap</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmap-l"> </i>
						<div class="code">layui-icon-zmap-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlightning"> </i>
						<div class="code">layui-icon-zlightning</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlightning-l"> </i>
						<div class="code">layui-icon-zlightning-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztruck"> </i>
						<div class="code">layui-icon-ztruck</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztruck-l"> </i>
						<div class="code">layui-icon-ztruck-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zshopping-cart"> </i>
						<div class="code">layui-icon-zshopping-cart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zshopping-cart-l"> </i>
						<div class="code">layui-icon-zshopping-cart-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zrocket"> </i>
						<div class="code">layui-icon-zrocket</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zrocket-l"> </i>
						<div class="code">layui-icon-zrocket-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztriangle"> </i>
						<div class="code">layui-icon-ztriangle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zsquare"> </i>
						<div class="code">layui-icon-zsquare</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcircle"> </i>
						<div class="code">layui-icon-zcircle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcamber"> </i>
						<div class="code">layui-icon-zcamber</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zx-buy-l"> </i>
						<div class="code">layui-icon-zx-buy-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zpaper-plane"> </i>
						<div class="code">layui-icon-zpaper-plane</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zquote-left"> </i>
						<div class="code">layui-icon-zquote-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zquote-right"> </i>
						<div class="code">layui-icon-zquote-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zd-space"> </i>
						<div class="code">layui-icon-zd-space</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zthumbs-up"> </i>
						<div class="code">layui-icon-zthumbs-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zwifi"> </i>
						<div class="code">layui-icon-zwifi</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zpixels"> </i>
						<div class="code">layui-icon-zpixels</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zprototype"> </i>
						<div class="code">layui-icon-zprototype</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zvector-design"> </i>
						<div class="code">layui-icon-zvector-design</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zconnection"> </i>
						<div class="code">layui-icon-zconnection</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zforum"> </i>
						<div class="code">layui-icon-zforum</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zuser-framework"> </i>
						<div class="code">layui-icon-zuser-framework</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zanalysis"> </i>
						<div class="code">layui-icon-zanalysis</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcollection"> </i>
						<div class="code">layui-icon-zcollection</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zdata-test"> </i>
						<div class="code">layui-icon-zdata-test</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zweb-edit"> </i>
						<div class="code">layui-icon-zweb-edit</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zfont"> </i>
						<div class="code">layui-icon-zfont</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zoverlapping"> </i>
						<div class="code">layui-icon-zoverlapping</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zpad"> </i>
						<div class="code">layui-icon-zpad</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlayers"> </i>
						<div class="code">layui-icon-zlayers</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlayout-grid"> </i>
						<div class="code">layui-icon-zlayout-grid</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlayout-grids"> </i>
						<div class="code">layui-icon-zlayout-grids</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlayout-list"> </i>
						<div class="code">layui-icon-zlayout-list</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zpaper"> </i>
						<div class="code">layui-icon-zpaper</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zpeople"> </i>
						<div class="code">layui-icon-zpeople</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zpokemon-ball"> </i>
						<div class="code">layui-icon-zpokemon-ball</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zred-envelope"> </i>
						<div class="code">layui-icon-zred-envelope</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmoney"> </i>
						<div class="code">layui-icon-zmoney</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zd-glasses"> </i>
						<div class="code">layui-icon-zd-glasses</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zadd"> </i>
						<div class="code">layui-icon-zadd</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zshare"></i>
						<div class="code">layui-icon-zshare</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-c">线性图标</div>
					<li>
						<i class="layui-icon layui-icon-zpen"> </i>
						<div class="code">layui-icon-zpen</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zpen-write"> </i>
						<div class="code">layui-icon-zpen-write</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcome-l"> </i>
						<div class="code">layui-icon-zcome-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zout-l"> </i>
						<div class="code">layui-icon-zout-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zqrcode-l"> </i>
						<div class="code">layui-icon-zqrcode-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zscan-l"> </i>
						<div class="code">layui-icon-zscan-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zvolume-x-l"> </i>
						<div class="code">layui-icon-zvolume-x-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zinfo-l"> </i>
						<div class="code">layui-icon-zinfo-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zscissors"> </i>
						<div class="code">layui-icon-zscissors</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlink-l"> </i>
						<div class="code">layui-icon-zlink-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlocation-l"> </i>
						<div class="code">layui-icon-zlocation-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zchoose-list-l"> </i>
						<div class="code">layui-icon-zchoose-list-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zwrite-l"> </i>
						<div class="code">layui-icon-zwrite-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmessage-l"> </i>
						<div class="code">layui-icon-zmessage-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zblackboard-l"> </i>
						<div class="code">layui-icon-zblackboard-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zthumbs-up-l"> </i>
						<div class="code">layui-icon-zthumbs-up-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztransmission-l"> </i>
						<div class="code">layui-icon-ztransmission-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zwrench-l"> </i>
						<div class="code">layui-icon-zwrench-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztime-plugin-l"> </i>
						<div class="code">layui-icon-ztime-plugin-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlabel-info-l"> </i>
						<div class="code">layui-icon-zlabel-info-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zsword-l"> </i>
						<div class="code">layui-icon-zsword-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zproduct-l"> </i>
						<div class="code">layui-icon-zproduct-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zdoc-edit"> </i>
						<div class="code">layui-icon-zdoc-edit</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-znew-l"> </i>
						<div class="code">layui-icon-znew-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-znewspaper-l"> </i>
						<div class="code">layui-icon-znewspaper-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zprototype-select-l"> </i>
						<div class="code">layui-icon-zprototype-select-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zconstruct-l"> </i>
						<div class="code">layui-icon-zconstruct-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcontainer-l"> </i>
						<div class="code">layui-icon-zcontainer-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zdetect-l"> </i>
						<div class="code">layui-icon-zdetect-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zgit-l"> </i>
						<div class="code">layui-icon-zgit-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zprogram-framework-l"> </i>
						<div class="code">layui-icon-zprogram-framework-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zaso-l"> </i>
						<div class="code">layui-icon-zaso-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-znetwork-l"> </i>
						<div class="code">layui-icon-znetwork-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zsite-folder-l"> </i>
						<div class="code">layui-icon-zsite-folder-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zassociation-l"> </i>
						<div class="code">layui-icon-zassociation-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcertificate"> </i>
						<div class="code">layui-icon-zcertificate</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zdesign-edit-l"> </i>
						<div class="code">layui-icon-zdesign-edit-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zdesign-shape-l"> </i>
						<div class="code">layui-icon-zdesign-shape-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zfire-l"> </i>
						<div class="code">layui-icon-zfire-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zfolder-l"> </i>
						<div class="code">layui-icon-zfolder-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zgeometry-shape-l"> </i>
						<div class="code">layui-icon-zgeometry-shape-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlight-flash-l"> </i>
						<div class="code">layui-icon-zlight-flash-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbook-l"> </i>
						<div class="code">layui-icon-zbook-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbookmark-l"> </i>
						<div class="code">layui-icon-zbookmark-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zclip-l"> </i>
						<div class="code">layui-icon-zclip-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zclose-l"> </i>
						<div class="code">layui-icon-zclose-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcloud-l"> </i>
						<div class="code">layui-icon-zcloud-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcomment-l"> </i>
						<div class="code">layui-icon-zcomment-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zdiamond-l"> </i>
						<div class="code">layui-icon-zdiamond-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zdownload-l"> </i>
						<div class="code">layui-icon-zdownload-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zeye-l"> </i>
						<div class="code">layui-icon-zeye-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zheart-l"> </i>
						<div class="code">layui-icon-zheart-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmenu-l"> </i>
						<div class="code">layui-icon-zmenu-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcategory-l"> </i>
						<div class="code">layui-icon-zcategory-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmessage-l"> </i>
						<div class="code">layui-icon-zmessage-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmouse-l"> </i>
						<div class="code">layui-icon-zmouse-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zsearch-l"> </i>
						<div class="code">layui-icon-zsearch-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zsetting-l"> </i>
						<div class="code">layui-icon-zsetting-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zshield-l"> </i>
						<div class="code">layui-icon-zshield-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztag-l"> </i>
						<div class="code">layui-icon-ztag-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztrash-l"> </i>
						<div class="code">layui-icon-ztrash-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zupload-l"> </i>
						<div class="code">layui-icon-zupload-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zworld-l"> </i>
						<div class="code">layui-icon-zworld-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zwrite-l"> </i>
						<div class="code">layui-icon-zwrite-l</div>
					</li>
					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-d">多媒体图标</div>
					<li>
						<i class="layui-icon layui-icon-zheadset"> </i>
						<div class="code">layui-icon-zheadset</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zheadset-l"> </i>
						<div class="code">layui-icon-zheadset-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zimage"> </i>
						<div class="code">layui-icon-zimage</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zimage-l"> </i>
						<div class="code">layui-icon-zimage-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcamera"> </i>
						<div class="code">layui-icon-zcamera</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcamera-l"> </i>
						<div class="code">layui-icon-zcamera-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmicrophone"> </i>
						<div class="code">layui-icon-zmicrophone</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmicrophone-l"> </i>
						<div class="code">layui-icon-zmicrophone-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmusic"> </i>
						<div class="code">layui-icon-zmusic</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmusic-l"> </i>
						<div class="code">layui-icon-zmusic-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmusic-note"> </i>
						<div class="code">layui-icon-zmusic-note</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmusic-note-l"> </i>
						<div class="code">layui-icon-zmusic-note-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zvolume"> </i>
						<div class="code">layui-icon-zvolume</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zvolume-l"> </i>
						<div class="code">layui-icon-zvolume-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zvideo-file"> </i>
						<div class="code">layui-icon-zvideo-file</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zvideo-file-l"> </i>
						<div class="code">layui-icon-zvideo-file-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmusic-file"> </i>
						<div class="code">layui-icon-zmusic-file</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmusic-file-l"> </i>
						<div class="code">layui-icon-zmusic-file-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zslider-l"> </i>
						<div class="code">layui-icon-zslider-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zplay-l"> </i>
						<div class="code">layui-icon-zplay-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zpause-l"> </i>
						<div class="code">layui-icon-zpause-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zvideo-camera-l"> </i>
						<div class="code">layui-icon-zvideo-camera-l</div>
					</li>
					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-e">箭头的方向</div>
					<li>
						<i class="layui-icon layui-icon-zangle-down-l"> </i>
						<div class="code">layui-icon-zangle-down-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zangle-left-l"> </i>
						<div class="code">layui-icon-zangle-left-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zangle-right-l"> </i>
						<div class="code">layui-icon-zangle-right-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zangle-up-l"> </i>
						<div class="code">layui-icon-zangle-up-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zarrow-down-l"> </i>
						<div class="code">layui-icon-zarrow-down-l</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zarrow-up-l"> </i>
						<div class="code">layui-icon-zarrow-up-l</div>
					</li>
					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-f">手势操作</div>
					<li>
						<i class="layui-icon layui-icon-zhand-bevel"> </i>
						<div class="code">layui-icon-zhand-bevel</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhand-slide"> </i>
						<div class="code">layui-icon-zhand-slide</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhand-gather"> </i>
						<div class="code">layui-icon-zhand-gather</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhande-vertical"> </i>
						<div class="code">layui-icon-zhande-vertical</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhand-horizontal"> </i>
						<div class="code">layui-icon-zhand-horizontal</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhand-button"> </i>
						<div class="code">layui-icon-zhand-button</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhand-touch"> </i>
						<div class="code">layui-icon-zhand-touch</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhand-pointer"> </i>
						<div class="code">layui-icon-zhand-pointer</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhand-grasp"> </i>
						<div class="code">layui-icon-zhand-grasp</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhand-stop"> </i>
						<div class="code">layui-icon-zhand-stop</div>
					</li>
					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-g">国际品牌</div>
					<li>
						<i class="layui-icon layui-icon-zandroid"> </i>
						<div class="code">layui-icon-zandroid</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zapple"> </i>
						<div class="code">layui-icon-zapple</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zchrome"> </i>
						<div class="code">layui-icon-zchrome</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcss3"> </i>
						<div class="code">layui-icon-zcss3</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zdribbble"> </i>
						<div class="code">layui-icon-zdribbble</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zdropbox"> </i>
						<div class="code">layui-icon-zdropbox</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zfacebook"> </i>
						<div class="code">layui-icon-zfacebook</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zhtml5"> </i>
						<div class="code">layui-icon-zhtml5</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zlinux"> </i>
						<div class="code">layui-icon-zlinux</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmicrosoft"> </i>
						<div class="code">layui-icon-zmicrosoft</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zrss"> </i>
						<div class="code">layui-icon-zrss</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zsteam"> </i>
						<div class="code">layui-icon-zsteam</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztwitter"> </i>
						<div class="code">layui-icon-ztwitter</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zvimeo"> </i>
						<div class="code">layui-icon-zvimeo</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zwordpress"> </i>
						<div class="code">layui-icon-zwordpress</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zyoutube"> </i>
						<div class="code">layui-icon-zyoutube</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zgithub"> </i>
						<div class="code">layui-icon-zgithub</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zgithub-logo"> </i>
						<div class="code">layui-icon-zgithub-logo</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zInstagram"> </i>
						<div class="code">layui-icon-zInstagram</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zpaypal"> </i>
						<div class="code">layui-icon-zpaypal</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zpinterest"> </i>
						<div class="code">layui-icon-zpinterest</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztelegram"> </i>
						<div class="code">layui-icon-ztelegram</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zraspberry"> </i>
						<div class="code">layui-icon-zraspberry</div>
					</li>
					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-h">中国品牌</div>
					<li>
						<i class="layui-icon layui-icon-zweixin"> </i>
						<div class="code">layui-icon-zweixin</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zqq"> </i>
						<div class="code">layui-icon-zqq</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zmoments"> </i>
						<div class="code">layui-icon-zmoments</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztaobao"> </i>
						<div class="code">layui-icon-ztaobao</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-ztmall"> </i>
						<div class="code">layui-icon-ztmall</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zweibo"> </i>
						<div class="code">layui-icon-zweibo</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zweixinzhifu"> </i>
						<div class="code">layui-icon-zweixinzhifu</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zalipay"> </i>
						<div class="code">layui-icon-zalipay</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbitcoin"> </i>
						<div class="code">layui-icon-zbitcoin</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbaiduwangpan"> </i>
						<div class="code">layui-icon-zbaiduwangpan</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zcaomei"> </i>
						<div class="code">layui-icon-zcaomei</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zv2ex"> </i>
						<div class="code">layui-icon-zv2ex</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zbilibili"> </i>
						<div class="code">layui-icon-zbilibili</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zqzone"> </i>
						<div class="code">layui-icon-zqzone</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhihu"> </i>
						<div class="code">layui-icon-zzhihu</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zchuangzaoshi"> </i>
						<div class="code">layui-icon-zchuangzaoshi</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-1">第三方新图标</div>
					<li>
						<i class="layui-icon layui-icon-zzaddress-book"></i>
						<div class="code">layui-icon-zzaddress-book</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzaddress-book-o"></i>
						<div class="code">layui-icon-zzaddress-book-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzaddress-card"></i>
						<div class="code">layui-icon-zzaddress-card</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzaddress-card-o"></i>
						<div class="code">layui-icon-zzaddress-card-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbandcamp"></i>
						<div class="code">layui-icon-zzbandcamp</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbath"></i>
						<div class="code">layui-icon-zzbath</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbathtub"></i>
						<div class="code">layui-icon-zzbathtub</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdrivers-license"></i>
						<div class="code">layui-icon-zzdrivers-license</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdrivers-license-o"></i>
						<div class="code">layui-icon-zzdrivers-license-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzeercast"></i>
						<div class="code">layui-icon-zzeercast</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzenvelope-open"></i>
						<div class="code">layui-icon-zzenvelope-open</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzenvelope-open-o"></i>
						<div class="code">layui-icon-zzenvelope-open-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzetsy"></i>
						<div class="code">layui-icon-zzetsy</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfree-code-camp"></i>
						<div class="code">layui-icon-zzfree-code-camp</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgrav"></i>
						<div class="code">layui-icon-zzgrav</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhandshake-o"></i>
						<div class="code">layui-icon-zzhandshake-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzid-badge"></i>
						<div class="code">layui-icon-zzid-badge</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzid-card"></i>
						<div class="code">layui-icon-zzid-card</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzid-card-o"></i>
						<div class="code">layui-icon-zzid-card-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzimdb"></i>
						<div class="code">layui-icon-zzimdb</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlinode"></i>
						<div class="code">layui-icon-zzlinode</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmeetup"></i>
						<div class="code">layui-icon-zzmeetup</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmicrochip"></i>
						<div class="code">layui-icon-zzmicrochip</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpodcast"></i>
						<div class="code">layui-icon-zzpodcast</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzquora"></i>
						<div class="code">layui-icon-zzquora</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzravelry"></i>
						<div class="code">layui-icon-zzravelry</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzs15"></i>
						<div class="code">layui-icon-zzs15</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshower"></i>
						<div class="code">layui-icon-zzshower</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsnowflake-o"></i>
						<div class="code">layui-icon-zzsnowflake-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsuperpowers"></i>
						<div class="code">layui-icon-zzsuperpowers</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztelegram"></i>
						<div class="code">layui-icon-zztelegram</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer"></i>
						<div class="code">layui-icon-zzthermometer</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-0"></i>
						<div class="code">layui-icon-zzthermometer-0</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-1"></i>
						<div class="code">layui-icon-zzthermometer-1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-2"></i>
						<div class="code">layui-icon-zzthermometer-2</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-3"></i>
						<div class="code">layui-icon-zzthermometer-3</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-4"></i>
						<div class="code">layui-icon-zzthermometer-4</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-empty"></i>
						<div class="code">layui-icon-zzthermometer-empty</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-full"></i>
						<div class="code">layui-icon-zzthermometer-full</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-half"></i>
						<div class="code">layui-icon-zzthermometer-half</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-quarter"></i>
						<div class="code">layui-icon-zzthermometer-quarter</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-three-quarters"></i>
						<div class="code">layui-icon-zzthermometer-three-quarters</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztimes-rectangle"></i>
						<div class="code">layui-icon-zztimes-rectangle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztimes-rectangle-o"></i>
						<div class="code">layui-icon-zztimes-rectangle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuser-circle"></i>
						<div class="code">layui-icon-zzuser-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuser-circle-o"></i>
						<div class="code">layui-icon-zzuser-circle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuser-o"></i>
						<div class="code">layui-icon-zzuser-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvcard"></i>
						<div class="code">layui-icon-zzvcard</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvcard-o"></i>
						<div class="code">layui-icon-zzvcard-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwindow-close"></i>
						<div class="code">layui-icon-zzwindow-close</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwindow-close-o"></i>
						<div class="code">layui-icon-zzwindow-close-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwindow-maximize"></i>
						<div class="code">layui-icon-zzwindow-maximize</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwindow-minimize"></i>
						<div class="code">layui-icon-zzwindow-minimize</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwindow-restore"></i>
						<div class="code">layui-icon-zzwindow-restore</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwpexplorer"></i>
						<div class="code">layui-icon-zzwpexplorer</div>
					</li>
					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-2">网页</div>

					<li>
						<i class="layui-icon layui-icon-zzaddress-book"></i>
						<div class="code">layui-icon-zzaddress-book</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzaddress-book-o"></i>
						<div class="code">layui-icon-zzaddress-book-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzaddress-card"></i>
						<div class="code">layui-icon-zzaddress-card</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzaddress-card-o"></i>
						<div class="code">layui-icon-zzaddress-card-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzadjust"></i>
						<div class="code">layui-icon-zzadjust</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzamerican-sign-language-interpreting"></i>
						<div class="code">layui-icon-zzamerican-sign-language-interpreting</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzanchor"></i>
						<div class="code">layui-icon-zzanchor</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarchive"></i>
						<div class="code">layui-icon-zzarchive</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarea-chart"></i>
						<div class="code">layui-icon-zzarea-chart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrows"></i>
						<div class="code">layui-icon-zzarrows</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrows-h"></i>
						<div class="code">layui-icon-zzarrows-h</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrows-v"></i>
						<div class="code">layui-icon-zzarrows-v</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzasl-interpreting"></i>
						<div class="code">layui-icon-zzasl-interpreting</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzassistive-listening-systems"></i>
						<div class="code">layui-icon-zzassistive-listening-systems</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzasterisk"></i>
						<div class="code">layui-icon-zzasterisk</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzat"></i>
						<div class="code">layui-icon-zzat</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzaudio-description"></i>
						<div class="code">layui-icon-zzaudio-description</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzautomobile"></i>
						<div class="code">layui-icon-zzautomobile</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbalance-scale"></i>
						<div class="code">layui-icon-zzbalance-scale</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzban"></i>
						<div class="code">layui-icon-zzban</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbank"></i>
						<div class="code">layui-icon-zzbank</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbar-chart"></i>
						<div class="code">layui-icon-zzbar-chart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbar-chart-o"></i>
						<div class="code">layui-icon-zzbar-chart-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbarcode"></i>
						<div class="code">layui-icon-zzbarcode</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbars"></i>
						<div class="code">layui-icon-zzbars</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbath"></i>
						<div class="code">layui-icon-zzbath</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbathtub"></i>
						<div class="code">layui-icon-zzbathtub</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbattery"></i>
						<div class="code">layui-icon-zzbattery</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbattery-0"></i>
						<div class="code">layui-icon-zzbattery-0</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbattery-1"></i>
						<div class="code">layui-icon-zzbattery-1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbattery-2"></i>
						<div class="code">layui-icon-zzbattery-2</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbattery-3"></i>
						<div class="code">layui-icon-zzbattery-3</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbattery-4"></i>
						<div class="code">layui-icon-zzbattery-4</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbattery-empty"></i>
						<div class="code">layui-icon-zzbattery-empty</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbattery-full"></i>
						<div class="code">layui-icon-zzbattery-full</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbattery-half"></i>
						<div class="code">layui-icon-zzbattery-half</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbattery-quarter"></i>
						<div class="code">layui-icon-zzbattery-quarter</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbattery-three-quarters"></i>
						<div class="code">layui-icon-zzbattery-three-quarters</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbed"></i>
						<div class="code">layui-icon-zzbed</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbeer"></i>
						<div class="code">layui-icon-zzbeer</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbell"></i>
						<div class="code">layui-icon-zzbell</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbell-o"></i>
						<div class="code">layui-icon-zzbell-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbell-slash"></i>
						<div class="code">layui-icon-zzbell-slash</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbell-slash-o"></i>
						<div class="code">layui-icon-zzbell-slash-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbicycle"></i>
						<div class="code">layui-icon-zzbicycle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbinoculars"></i>
						<div class="code">layui-icon-zzbinoculars</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbirthday-cake"></i>
						<div class="code">layui-icon-zzbirthday-cake</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzblind"></i>
						<div class="code">layui-icon-zzblind</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbluetooth"></i>
						<div class="code">layui-icon-zzbluetooth</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbluetooth-b"></i>
						<div class="code">layui-icon-zzbluetooth-b</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbolt"></i>
						<div class="code">layui-icon-zzbolt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbomb"></i>
						<div class="code">layui-icon-zzbomb</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbook"></i>
						<div class="code">layui-icon-zzbook</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbookmark"></i>
						<div class="code">layui-icon-zzbookmark</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbookmark-o"></i>
						<div class="code">layui-icon-zzbookmark-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbraille"></i>
						<div class="code">layui-icon-zzbraille</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbriefcase"></i>
						<div class="code">layui-icon-zzbriefcase</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbug"></i>
						<div class="code">layui-icon-zzbug</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbuilding"></i>
						<div class="code">layui-icon-zzbuilding</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbuilding-o"></i>
						<div class="code">layui-icon-zzbuilding-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbullhorn"></i>
						<div class="code">layui-icon-zzbullhorn</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbullseye"></i>
						<div class="code">layui-icon-zzbullseye</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbus"></i>
						<div class="code">layui-icon-zzbus</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcab"></i>
						<div class="code">layui-icon-zzcab</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcalculator"></i>
						<div class="code">layui-icon-zzcalculator</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcalendar"></i>
						<div class="code">layui-icon-zzcalendar</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcalendar-check-o"></i>
						<div class="code">layui-icon-zzcalendar-check-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcalendar-minus-o"></i>
						<div class="code">layui-icon-zzcalendar-minus-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcalendar-o"></i>
						<div class="code">layui-icon-zzcalendar-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcalendar-plus-o"></i>
						<div class="code">layui-icon-zzcalendar-plus-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcalendar-times-o"></i>
						<div class="code">layui-icon-zzcalendar-times-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcamera"></i>
						<div class="code">layui-icon-zzcamera</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcamera-retro"></i>
						<div class="code">layui-icon-zzcamera-retro</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcar"></i>
						<div class="code">layui-icon-zzcar</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcaret-square-o-down"></i>
						<div class="code">layui-icon-zzcaret-square-o-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcaret-square-o-left"></i>
						<div class="code">layui-icon-zzcaret-square-o-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcaret-square-o-right"></i>
						<div class="code">layui-icon-zzcaret-square-o-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcaret-square-o-up"></i>
						<div class="code">layui-icon-zzcaret-square-o-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcart-arrow-down"></i>
						<div class="code">layui-icon-zzcart-arrow-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcart-plus"></i>
						<div class="code">layui-icon-zzcart-plus</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc"></i>
						<div class="code">layui-icon-zzcc</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcertificate"></i>
						<div class="code">layui-icon-zzcertificate</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcheck"></i>
						<div class="code">layui-icon-zzcheck</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcheck-circle"></i>
						<div class="code">layui-icon-zzcheck-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcheck-circle-o"></i>
						<div class="code">layui-icon-zzcheck-circle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcheck-square"></i>
						<div class="code">layui-icon-zzcheck-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcheck-square-o"></i>
						<div class="code">layui-icon-zzcheck-square-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzchild"></i>
						<div class="code">layui-icon-zzchild</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcircle"></i>
						<div class="code">layui-icon-zzcircle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcircle-o"></i>
						<div class="code">layui-icon-zzcircle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcircle-o-notch"></i>
						<div class="code">layui-icon-zzcircle-o-notch</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcircle-thin"></i>
						<div class="code">layui-icon-zzcircle-thin</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzclock-o"></i>
						<div class="code">layui-icon-zzclock-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzclone"></i>
						<div class="code">layui-icon-zzclone</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzclose"></i>
						<div class="code">layui-icon-zzclose</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcloud"></i>
						<div class="code">layui-icon-zzcloud</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcloud-download"></i>
						<div class="code">layui-icon-zzcloud-download</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcloud-upload"></i>
						<div class="code">layui-icon-zzcloud-upload</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcode"></i>
						<div class="code">layui-icon-zzcode</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcode-fork"></i>
						<div class="code">layui-icon-zzcode-fork</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcoffee"></i>
						<div class="code">layui-icon-zzcoffee</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcog"></i>
						<div class="code">layui-icon-zzcog</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcogs"></i>
						<div class="code">layui-icon-zzcogs</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcomment"></i>
						<div class="code">layui-icon-zzcomment</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcomment-o"></i>
						<div class="code">layui-icon-zzcomment-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcommenting"></i>
						<div class="code">layui-icon-zzcommenting</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcommenting-o"></i>
						<div class="code">layui-icon-zzcommenting-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcomments"></i>
						<div class="code">layui-icon-zzcomments</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcomments-o"></i>
						<div class="code">layui-icon-zzcomments-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcompass"></i>
						<div class="code">layui-icon-zzcompass</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcopyright"></i>
						<div class="code">layui-icon-zzcopyright</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcreative-commons"></i>
						<div class="code">layui-icon-zzcreative-commons</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcredit-card"></i>
						<div class="code">layui-icon-zzcredit-card</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcredit-card-alt"></i>
						<div class="code">layui-icon-zzcredit-card-alt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcrop"></i>
						<div class="code">layui-icon-zzcrop</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcrosshairs"></i>
						<div class="code">layui-icon-zzcrosshairs</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcube"></i>
						<div class="code">layui-icon-zzcube</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcubes"></i>
						<div class="code">layui-icon-zzcubes</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcutlery"></i>
						<div class="code">layui-icon-zzcutlery</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdashboard"></i>
						<div class="code">layui-icon-zzdashboard</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdatabase"></i>
						<div class="code">layui-icon-zzdatabase</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdeaf"></i>
						<div class="code">layui-icon-zzdeaf</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdeafness"></i>
						<div class="code">layui-icon-zzdeafness</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdesktop"></i>
						<div class="code">layui-icon-zzdesktop</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdiamond"></i>
						<div class="code">layui-icon-zzdiamond</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdot-circle-o"></i>
						<div class="code">layui-icon-zzdot-circle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdownload"></i>
						<div class="code">layui-icon-zzdownload</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdrivers-license"></i>
						<div class="code">layui-icon-zzdrivers-license</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdrivers-license-o"></i>
						<div class="code">layui-icon-zzdrivers-license-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzedit"></i>
						<div class="code">layui-icon-zzedit</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzellipsis-h"></i>
						<div class="code">layui-icon-zzellipsis-h</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzellipsis-v"></i>
						<div class="code">layui-icon-zzellipsis-v</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzenvelope"></i>
						<div class="code">layui-icon-zzenvelope</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzenvelope-o"></i>
						<div class="code">layui-icon-zzenvelope-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzenvelope-open"></i>
						<div class="code">layui-icon-zzenvelope-open</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzenvelope-open-o"></i>
						<div class="code">layui-icon-zzenvelope-open-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzenvelope-square"></i>
						<div class="code">layui-icon-zzenvelope-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzeraser"></i>
						<div class="code">layui-icon-zzeraser</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzexchange"></i>
						<div class="code">layui-icon-zzexchange</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzexclamation"></i>
						<div class="code">layui-icon-zzexclamation</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzexclamation-circle"></i>
						<div class="code">layui-icon-zzexclamation-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzexclamation-triangle"></i>
						<div class="code">layui-icon-zzexclamation-triangle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzexternal-link"></i>
						<div class="code">layui-icon-zzexternal-link</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzexternal-link-square"></i>
						<div class="code">layui-icon-zzexternal-link-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzeye"></i>
						<div class="code">layui-icon-zzeye</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzeye-slash"></i>
						<div class="code">layui-icon-zzeye-slash</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzeyedropper"></i>
						<div class="code">layui-icon-zzeyedropper</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfax"></i>
						<div class="code">layui-icon-zzfax</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfeed"></i>
						<div class="code">layui-icon-zzfeed</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfemale"></i>
						<div class="code">layui-icon-zzfemale</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfighter-jet"></i>
						<div class="code">layui-icon-zzfighter-jet</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-archive-o"></i>
						<div class="code">layui-icon-zzfile-archive-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-audio-o"></i>
						<div class="code">layui-icon-zzfile-audio-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-code-o"></i>
						<div class="code">layui-icon-zzfile-code-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-excel-o"></i>
						<div class="code">layui-icon-zzfile-excel-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-image-o"></i>
						<div class="code">layui-icon-zzfile-image-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-movie-o"></i>
						<div class="code">layui-icon-zzfile-movie-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-pdf-o"></i>
						<div class="code">layui-icon-zzfile-pdf-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-photo-o"></i>
						<div class="code">layui-icon-zzfile-photo-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-picture-o"></i>
						<div class="code">layui-icon-zzfile-picture-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-powerpoint-o"></i>
						<div class="code">layui-icon-zzfile-powerpoint-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-sound-o"></i>
						<div class="code">layui-icon-zzfile-sound-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-video-o"></i>
						<div class="code">layui-icon-zzfile-video-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-word-o"></i>
						<div class="code">layui-icon-zzfile-word-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-zip-o"></i>
						<div class="code">layui-icon-zzfile-zip-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfilm"></i>
						<div class="code">layui-icon-zzfilm</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfilter"></i>
						<div class="code">layui-icon-zzfilter</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfire"></i>
						<div class="code">layui-icon-zzfire</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfire-extinguisher"></i>
						<div class="code">layui-icon-zzfire-extinguisher</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzflag"></i>
						<div class="code">layui-icon-zzflag</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzflag-checkered"></i>
						<div class="code">layui-icon-zzflag-checkered</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzflag-o"></i>
						<div class="code">layui-icon-zzflag-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzflash"></i>
						<div class="code">layui-icon-zzflash</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzflask"></i>
						<div class="code">layui-icon-zzflask</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfolder"></i>
						<div class="code">layui-icon-zzfolder</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfolder-o"></i>
						<div class="code">layui-icon-zzfolder-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfolder-open"></i>
						<div class="code">layui-icon-zzfolder-open</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfolder-open-o"></i>
						<div class="code">layui-icon-zzfolder-open-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfrown-o"></i>
						<div class="code">layui-icon-zzfrown-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfutbol-o"></i>
						<div class="code">layui-icon-zzfutbol-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgamepad"></i>
						<div class="code">layui-icon-zzgamepad</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgavel"></i>
						<div class="code">layui-icon-zzgavel</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgear"></i>
						<div class="code">layui-icon-zzgear</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgears"></i>
						<div class="code">layui-icon-zzgears</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgift"></i>
						<div class="code">layui-icon-zzgift</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzglass"></i>
						<div class="code">layui-icon-zzglass</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzglobe"></i>
						<div class="code">layui-icon-zzglobe</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgraduation-cap"></i>
						<div class="code">layui-icon-zzgraduation-cap</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgroup"></i>
						<div class="code">layui-icon-zzgroup</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-grab-o"></i>
						<div class="code">layui-icon-zzhand-grab-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-lizard-o"></i>
						<div class="code">layui-icon-zzhand-lizard-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-paper-o"></i>
						<div class="code">layui-icon-zzhand-paper-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-peace-o"></i>
						<div class="code">layui-icon-zzhand-peace-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-pointer-o"></i>
						<div class="code">layui-icon-zzhand-pointer-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-rock-o"></i>
						<div class="code">layui-icon-zzhand-rock-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-scissors-o"></i>
						<div class="code">layui-icon-zzhand-scissors-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-spock-o"></i>
						<div class="code">layui-icon-zzhand-spock-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-stop-o"></i>
						<div class="code">layui-icon-zzhand-stop-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhandshake-o"></i>
						<div class="code">layui-icon-zzhandshake-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhard-of-hearing"></i>
						<div class="code">layui-icon-zzhard-of-hearing</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhashtag"></i>
						<div class="code">layui-icon-zzhashtag</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhdd-o"></i>
						<div class="code">layui-icon-zzhdd-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzheadphones"></i>
						<div class="code">layui-icon-zzheadphones</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzheart"></i>
						<div class="code">layui-icon-zzheart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzheart-o"></i>
						<div class="code">layui-icon-zzheart-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzheartbeat"></i>
						<div class="code">layui-icon-zzheartbeat</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhistory"></i>
						<div class="code">layui-icon-zzhistory</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhome"></i>
						<div class="code">layui-icon-zzhome</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhotel"></i>
						<div class="code">layui-icon-zzhotel</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhourglass"></i>
						<div class="code">layui-icon-zzhourglass</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhourglass-1"></i>
						<div class="code">layui-icon-zzhourglass-1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhourglass-2"></i>
						<div class="code">layui-icon-zzhourglass-2</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhourglass-3"></i>
						<div class="code">layui-icon-zzhourglass-3</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhourglass-end"></i>
						<div class="code">layui-icon-zzhourglass-end</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhourglass-half"></i>
						<div class="code">layui-icon-zzhourglass-half</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhourglass-o"></i>
						<div class="code">layui-icon-zzhourglass-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhourglass-start"></i>
						<div class="code">layui-icon-zzhourglass-start</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzi-cursor"></i>
						<div class="code">layui-icon-zzi-cursor</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzid-badge"></i>
						<div class="code">layui-icon-zzid-badge</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzid-card"></i>
						<div class="code">layui-icon-zzid-card</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzid-card-o"></i>
						<div class="code">layui-icon-zzid-card-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzimage"></i>
						<div class="code">layui-icon-zzimage</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzinbox"></i>
						<div class="code">layui-icon-zzinbox</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzindustry"></i>
						<div class="code">layui-icon-zzindustry</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzinfo"></i>
						<div class="code">layui-icon-zzinfo</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzinfo-circle"></i>
						<div class="code">layui-icon-zzinfo-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzinstitution"></i>
						<div class="code">layui-icon-zzinstitution</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzkey"></i>
						<div class="code">layui-icon-zzkey</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzkeyboard-o"></i>
						<div class="code">layui-icon-zzkeyboard-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlanguage"></i>
						<div class="code">layui-icon-zzlanguage</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlaptop"></i>
						<div class="code">layui-icon-zzlaptop</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzleaf"></i>
						<div class="code">layui-icon-zzleaf</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlegal"></i>
						<div class="code">layui-icon-zzlegal</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlemon-o"></i>
						<div class="code">layui-icon-zzlemon-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlevel-down"></i>
						<div class="code">layui-icon-zzlevel-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlevel-up"></i>
						<div class="code">layui-icon-zzlevel-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlife-bouy"></i>
						<div class="code">layui-icon-zzlife-bouy</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlife-buoy"></i>
						<div class="code">layui-icon-zzlife-buoy</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlife-ring"></i>
						<div class="code">layui-icon-zzlife-ring</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlife-saver"></i>
						<div class="code">layui-icon-zzlife-saver</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlightbulb-o"></i>
						<div class="code">layui-icon-zzlightbulb-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzline-chart"></i>
						<div class="code">layui-icon-zzline-chart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlocation-arrow"></i>
						<div class="code">layui-icon-zzlocation-arrow</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlock"></i>
						<div class="code">layui-icon-zzlock</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlow-vision"></i>
						<div class="code">layui-icon-zzlow-vision</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmagic"></i>
						<div class="code">layui-icon-zzmagic</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmagnet"></i>
						<div class="code">layui-icon-zzmagnet</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmail-forward"></i>
						<div class="code">layui-icon-zzmail-forward</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmail-reply"></i>
						<div class="code">layui-icon-zzmail-reply</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmail-reply-all"></i>
						<div class="code">layui-icon-zzmail-reply-all</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmale"></i>
						<div class="code">layui-icon-zzmale</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmap"></i>
						<div class="code">layui-icon-zzmap</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmap-marker"></i>
						<div class="code">layui-icon-zzmap-marker</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmap-o"></i>
						<div class="code">layui-icon-zzmap-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmap-pin"></i>
						<div class="code">layui-icon-zzmap-pin</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmap-signs"></i>
						<div class="code">layui-icon-zzmap-signs</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmeh-o"></i>
						<div class="code">layui-icon-zzmeh-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmicrochip"></i>
						<div class="code">layui-icon-zzmicrochip</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmicrophone"></i>
						<div class="code">layui-icon-zzmicrophone</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmicrophone-slash"></i>
						<div class="code">layui-icon-zzmicrophone-slash</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzminus"></i>
						<div class="code">layui-icon-zzminus</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzminus-circle"></i>
						<div class="code">layui-icon-zzminus-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzminus-square"></i>
						<div class="code">layui-icon-zzminus-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzminus-square-o"></i>
						<div class="code">layui-icon-zzminus-square-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmobile"></i>
						<div class="code">layui-icon-zzmobile</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmobile-phone"></i>
						<div class="code">layui-icon-zzmobile-phone</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmoney"></i>
						<div class="code">layui-icon-zzmoney</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmoon-o"></i>
						<div class="code">layui-icon-zzmoon-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmortar-board"></i>
						<div class="code">layui-icon-zzmortar-board</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmotorcycle"></i>
						<div class="code">layui-icon-zzmotorcycle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmouse-pointer"></i>
						<div class="code">layui-icon-zzmouse-pointer</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmusic"></i>
						<div class="code">layui-icon-zzmusic</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zznavicon"></i>
						<div class="code">layui-icon-zznavicon</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zznewspaper-o"></i>
						<div class="code">layui-icon-zznewspaper-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzobject-group"></i>
						<div class="code">layui-icon-zzobject-group</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzobject-ungroup"></i>
						<div class="code">layui-icon-zzobject-ungroup</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpaint-brush"></i>
						<div class="code">layui-icon-zzpaint-brush</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpaper-plane"></i>
						<div class="code">layui-icon-zzpaper-plane</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpaper-plane-o"></i>
						<div class="code">layui-icon-zzpaper-plane-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpaw"></i>
						<div class="code">layui-icon-zzpaw</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpencil"></i>
						<div class="code">layui-icon-zzpencil</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpencil-square"></i>
						<div class="code">layui-icon-zzpencil-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpencil-square-o"></i>
						<div class="code">layui-icon-zzpencil-square-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpercent"></i>
						<div class="code">layui-icon-zzpercent</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzphone"></i>
						<div class="code">layui-icon-zzphone</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzphone-square"></i>
						<div class="code">layui-icon-zzphone-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzphoto"></i>
						<div class="code">layui-icon-zzphoto</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpicture-o"></i>
						<div class="code">layui-icon-zzpicture-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpie-chart"></i>
						<div class="code">layui-icon-zzpie-chart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzplane"></i>
						<div class="code">layui-icon-zzplane</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzplug"></i>
						<div class="code">layui-icon-zzplug</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzplus"></i>
						<div class="code">layui-icon-zzplus</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzplus-circle"></i>
						<div class="code">layui-icon-zzplus-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzplus-square"></i>
						<div class="code">layui-icon-zzplus-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzplus-square-o"></i>
						<div class="code">layui-icon-zzplus-square-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpodcast"></i>
						<div class="code">layui-icon-zzpodcast</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpower-off"></i>
						<div class="code">layui-icon-zzpower-off</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzprint"></i>
						<div class="code">layui-icon-zzprint</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpuzzle-piece"></i>
						<div class="code">layui-icon-zzpuzzle-piece</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzqrcode"></i>
						<div class="code">layui-icon-zzqrcode</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzquestion"></i>
						<div class="code">layui-icon-zzquestion</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzquestion-circle"></i>
						<div class="code">layui-icon-zzquestion-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzquestion-circle-o"></i>
						<div class="code">layui-icon-zzquestion-circle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzquote-left"></i>
						<div class="code">layui-icon-zzquote-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzquote-right"></i>
						<div class="code">layui-icon-zzquote-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrandom"></i>
						<div class="code">layui-icon-zzrandom</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrecycle"></i>
						<div class="code">layui-icon-zzrecycle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrefresh"></i>
						<div class="code">layui-icon-zzrefresh</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzregistered"></i>
						<div class="code">layui-icon-zzregistered</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzremove"></i>
						<div class="code">layui-icon-zzremove</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzreorder"></i>
						<div class="code">layui-icon-zzreorder</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzreply"></i>
						<div class="code">layui-icon-zzreply</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzreply-all"></i>
						<div class="code">layui-icon-zzreply-all</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzretweet"></i>
						<div class="code">layui-icon-zzretweet</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzroad"></i>
						<div class="code">layui-icon-zzroad</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrocket"></i>
						<div class="code">layui-icon-zzrocket</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrss"></i>
						<div class="code">layui-icon-zzrss</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrss-square"></i>
						<div class="code">layui-icon-zzrss-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzs15"></i>
						<div class="code">layui-icon-zzs15</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsearch"></i>
						<div class="code">layui-icon-zzsearch</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsearch-minus"></i>
						<div class="code">layui-icon-zzsearch-minus</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsearch-plus"></i>
						<div class="code">layui-icon-zzsearch-plus</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsend"></i>
						<div class="code">layui-icon-zzsend</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsend-o"></i>
						<div class="code">layui-icon-zzsend-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzserver"></i>
						<div class="code">layui-icon-zzserver</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshare"></i>
						<div class="code">layui-icon-zzshare</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshare-alt"></i>
						<div class="code">layui-icon-zzshare-alt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshare-alt-square"></i>
						<div class="code">layui-icon-zzshare-alt-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshare-square"></i>
						<div class="code">layui-icon-zzshare-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshare-square-o"></i>
						<div class="code">layui-icon-zzshare-square-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshield"></i>
						<div class="code">layui-icon-zzshield</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzship"></i>
						<div class="code">layui-icon-zzship</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshopping-bag"></i>
						<div class="code">layui-icon-zzshopping-bag</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshopping-basket"></i>
						<div class="code">layui-icon-zzshopping-basket</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshopping-cart"></i>
						<div class="code">layui-icon-zzshopping-cart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshower"></i>
						<div class="code">layui-icon-zzshower</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsign-in"></i>
						<div class="code">layui-icon-zzsign-in</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsign-language"></i>
						<div class="code">layui-icon-zzsign-language</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsign-out"></i>
						<div class="code">layui-icon-zzsign-out</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsignal"></i>
						<div class="code">layui-icon-zzsignal</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsigning"></i>
						<div class="code">layui-icon-zzsigning</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsitemap"></i>
						<div class="code">layui-icon-zzsitemap</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsliders"></i>
						<div class="code">layui-icon-zzsliders</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsmile-o"></i>
						<div class="code">layui-icon-zzsmile-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsnowflake-o"></i>
						<div class="code">layui-icon-zzsnowflake-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsoccer-ball-o"></i>
						<div class="code">layui-icon-zzsoccer-ball-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsort"></i>
						<div class="code">layui-icon-zzsort</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsort-alpha-asc"></i>
						<div class="code">layui-icon-zzsort-alpha-asc</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsort-alpha-desc"></i>
						<div class="code">layui-icon-zzsort-alpha-desc</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsort-amount-asc"></i>
						<div class="code">layui-icon-zzsort-amount-asc</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsort-amount-desc"></i>
						<div class="code">layui-icon-zzsort-amount-desc</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsort-asc"></i>
						<div class="code">layui-icon-zzsort-asc</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsort-desc"></i>
						<div class="code">layui-icon-zzsort-desc</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsort-down"></i>
						<div class="code">layui-icon-zzsort-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsort-numeric-asc"></i>
						<div class="code">layui-icon-zzsort-numeric-asc</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsort-numeric-desc"></i>
						<div class="code">layui-icon-zzsort-numeric-desc</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsort-up"></i>
						<div class="code">layui-icon-zzsort-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzspace-shuttle"></i>
						<div class="code">layui-icon-zzspace-shuttle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzspinner"></i>
						<div class="code">layui-icon-zzspinner</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzspoon"></i>
						<div class="code">layui-icon-zzspoon</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsquare"></i>
						<div class="code">layui-icon-zzsquare</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsquare-o"></i>
						<div class="code">layui-icon-zzsquare-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstar"></i>
						<div class="code">layui-icon-zzstar</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstar-half"></i>
						<div class="code">layui-icon-zzstar-half</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstar-half-empty"></i>
						<div class="code">layui-icon-zzstar-half-empty</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstar-half-full"></i>
						<div class="code">layui-icon-zzstar-half-full</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstar-half-o"></i>
						<div class="code">layui-icon-zzstar-half-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstar-o"></i>
						<div class="code">layui-icon-zzstar-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsticky-note"></i>
						<div class="code">layui-icon-zzsticky-note</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsticky-note-o"></i>
						<div class="code">layui-icon-zzsticky-note-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstreet-view"></i>
						<div class="code">layui-icon-zzstreet-view</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsuitcase"></i>
						<div class="code">layui-icon-zzsuitcase</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsun-o"></i>
						<div class="code">layui-icon-zzsun-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsupport"></i>
						<div class="code">layui-icon-zzsupport</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztablet"></i>
						<div class="code">layui-icon-zztablet</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztachometer"></i>
						<div class="code">layui-icon-zztachometer</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztag"></i>
						<div class="code">layui-icon-zztag</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztags"></i>
						<div class="code">layui-icon-zztags</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztasks"></i>
						<div class="code">layui-icon-zztasks</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztaxi"></i>
						<div class="code">layui-icon-zztaxi</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztelevision"></i>
						<div class="code">layui-icon-zztelevision</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzterminal"></i>
						<div class="code">layui-icon-zzterminal</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer"></i>
						<div class="code">layui-icon-zzthermometer</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-0"></i>
						<div class="code">layui-icon-zzthermometer-0</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-1"></i>
						<div class="code">layui-icon-zzthermometer-1</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-2"></i>
						<div class="code">layui-icon-zzthermometer-2</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-3"></i>
						<div class="code">layui-icon-zzthermometer-3</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-4"></i>
						<div class="code">layui-icon-zzthermometer-4</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-empty"></i>
						<div class="code">layui-icon-zzthermometer-empty</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-full"></i>
						<div class="code">layui-icon-zzthermometer-full</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-half"></i>
						<div class="code">layui-icon-zzthermometer-half</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-quarter"></i>
						<div class="code">layui-icon-zzthermometer-quarter</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthermometer-three-quarters"></i>
						<div class="code">layui-icon-zzthermometer-three-quarters</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthumb-tack"></i>
						<div class="code">layui-icon-zzthumb-tack</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthumbs-down"></i>
						<div class="code">layui-icon-zzthumbs-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthumbs-o-down"></i>
						<div class="code">layui-icon-zzthumbs-o-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthumbs-o-up"></i>
						<div class="code">layui-icon-zzthumbs-o-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthumbs-up"></i>
						<div class="code">layui-icon-zzthumbs-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzticket"></i>
						<div class="code">layui-icon-zzticket</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztimes"></i>
						<div class="code">layui-icon-zztimes</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztimes-circle"></i>
						<div class="code">layui-icon-zztimes-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztimes-circle-o"></i>
						<div class="code">layui-icon-zztimes-circle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztimes-rectangle"></i>
						<div class="code">layui-icon-zztimes-rectangle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztimes-rectangle-o"></i>
						<div class="code">layui-icon-zztimes-rectangle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztint"></i>
						<div class="code">layui-icon-zztint</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztoggle-down"></i>
						<div class="code">layui-icon-zztoggle-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztoggle-left"></i>
						<div class="code">layui-icon-zztoggle-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztoggle-off"></i>
						<div class="code">layui-icon-zztoggle-off</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztoggle-on"></i>
						<div class="code">layui-icon-zztoggle-on</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztoggle-right"></i>
						<div class="code">layui-icon-zztoggle-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztoggle-up"></i>
						<div class="code">layui-icon-zztoggle-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztrademark"></i>
						<div class="code">layui-icon-zztrademark</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztrash"></i>
						<div class="code">layui-icon-zztrash</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztrash-o"></i>
						<div class="code">layui-icon-zztrash-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztree"></i>
						<div class="code">layui-icon-zztree</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztrophy"></i>
						<div class="code">layui-icon-zztrophy</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztruck"></i>
						<div class="code">layui-icon-zztruck</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztty"></i>
						<div class="code">layui-icon-zztty</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztv"></i>
						<div class="code">layui-icon-zztv</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzumbrella"></i>
						<div class="code">layui-icon-zzumbrella</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuniversal-access"></i>
						<div class="code">layui-icon-zzuniversal-access</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuniversity"></i>
						<div class="code">layui-icon-zzuniversity</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzunlock"></i>
						<div class="code">layui-icon-zzunlock</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzunlock-alt"></i>
						<div class="code">layui-icon-zzunlock-alt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzunsorted"></i>
						<div class="code">layui-icon-zzunsorted</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzupload"></i>
						<div class="code">layui-icon-zzupload</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuser"></i>
						<div class="code">layui-icon-zzuser</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuser-circle"></i>
						<div class="code">layui-icon-zzuser-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuser-circle-o"></i>
						<div class="code">layui-icon-zzuser-circle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuser-o"></i>
						<div class="code">layui-icon-zzuser-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuser-plus"></i>
						<div class="code">layui-icon-zzuser-plus</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuser-secret"></i>
						<div class="code">layui-icon-zzuser-secret</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuser-times"></i>
						<div class="code">layui-icon-zzuser-times</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzusers"></i>
						<div class="code">layui-icon-zzusers</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvcard"></i>
						<div class="code">layui-icon-zzvcard</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvcard-o"></i>
						<div class="code">layui-icon-zzvcard-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvideo-camera"></i>
						<div class="code">layui-icon-zzvideo-camera</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvolume-control-phone"></i>
						<div class="code">layui-icon-zzvolume-control-phone</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvolume-down"></i>
						<div class="code">layui-icon-zzvolume-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvolume-off"></i>
						<div class="code">layui-icon-zzvolume-off</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvolume-up"></i>
						<div class="code">layui-icon-zzvolume-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwarning"></i>
						<div class="code">layui-icon-zzwarning</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwheelchair"></i>
						<div class="code">layui-icon-zzwheelchair</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwheelchair-alt"></i>
						<div class="code">layui-icon-zzwheelchair-alt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwifi"></i>
						<div class="code">layui-icon-zzwifi</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwindow-close"></i>
						<div class="code">layui-icon-zzwindow-close</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwindow-close-o"></i>
						<div class="code">layui-icon-zzwindow-close-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwindow-maximize"></i>
						<div class="code">layui-icon-zzwindow-maximize</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwindow-minimize"></i>
						<div class="code">layui-icon-zzwindow-minimize</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwindow-restore"></i>
						<div class="code">layui-icon-zzwindow-restore</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwrench"></i>
						<div class="code">layui-icon-zzwrench</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-3">辅助功能</div>

					<li>
						<i class="layui-icon layui-icon-zzamerican-sign-language-interpreting"></i>
						<div class="code">layui-icon-zzamerican-sign-language-interpreting</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzasl-interpreting"></i>
						<div class="code">layui-icon-zzasl-interpreting</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzassistive-listening-systems"></i>
						<div class="code">layui-icon-zzassistive-listening-systems</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzaudio-description"></i>
						<div class="code">layui-icon-zzaudio-description</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzblind"></i>
						<div class="code">layui-icon-zzblind</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbraille"></i>
						<div class="code">layui-icon-zzbraille</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc"></i>
						<div class="code">layui-icon-zzcc</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdeaf"></i>
						<div class="code">layui-icon-zzdeaf</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdeafness"></i>
						<div class="code">layui-icon-zzdeafness</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhard-of-hearing"></i>
						<div class="code">layui-icon-zzhard-of-hearing</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlow-vision"></i>
						<div class="code">layui-icon-zzlow-vision</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzquestion-circle-o"></i>
						<div class="code">layui-icon-zzquestion-circle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsign-language"></i>
						<div class="code">layui-icon-zzsign-language</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsigning"></i>
						<div class="code">layui-icon-zzsigning</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztty"></i>
						<div class="code">layui-icon-zztty</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuniversal-access"></i>
						<div class="code">layui-icon-zzuniversal-access</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvolume-control-phone"></i>
						<div class="code">layui-icon-zzvolume-control-phone</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwheelchair"></i>
						<div class="code">layui-icon-zzwheelchair</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwheelchair-alt"></i>
						<div class="code">layui-icon-zzwheelchair-alt</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-4">手势</div>

					<li>
						<i class="layui-icon layui-icon-zzhand-grab-o"></i>
						<div class="code">layui-icon-zzhand-grab-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-lizard-o"></i>
						<div class="code">layui-icon-zzhand-lizard-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-o-down"></i>
						<div class="code">layui-icon-zzhand-o-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-o-left"></i>
						<div class="code">layui-icon-zzhand-o-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-o-right"></i>
						<div class="code">layui-icon-zzhand-o-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-o-up"></i>
						<div class="code">layui-icon-zzhand-o-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-paper-o"></i>
						<div class="code">layui-icon-zzhand-paper-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-peace-o"></i>
						<div class="code">layui-icon-zzhand-peace-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-pointer-o"></i>
						<div class="code">layui-icon-zzhand-pointer-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-rock-o"></i>
						<div class="code">layui-icon-zzhand-rock-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-scissors-o"></i>
						<div class="code">layui-icon-zzhand-scissors-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-spock-o"></i>
						<div class="code">layui-icon-zzhand-spock-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-stop-o"></i>
						<div class="code">layui-icon-zzhand-stop-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthumbs-down"></i>
						<div class="code">layui-icon-zzthumbs-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthumbs-o-down"></i>
						<div class="code">layui-icon-zzthumbs-o-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthumbs-o-up"></i>
						<div class="code">layui-icon-zzthumbs-o-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthumbs-up"></i>
						<div class="code">layui-icon-zzthumbs-up</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-5">运输</div>

					<li>
						<i class="layui-icon layui-icon-zzambulance"></i>
						<div class="code">layui-icon-zzambulance</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzautomobile"></i>
						<div class="code">layui-icon-zzautomobile</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbicycle"></i>
						<div class="code">layui-icon-zzbicycle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbus"></i>
						<div class="code">layui-icon-zzbus</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcab"></i>
						<div class="code">layui-icon-zzcab</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcar"></i>
						<div class="code">layui-icon-zzcar</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfighter-jet"></i>
						<div class="code">layui-icon-zzfighter-jet</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmotorcycle"></i>
						<div class="code">layui-icon-zzmotorcycle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzplane"></i>
						<div class="code">layui-icon-zzplane</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrocket"></i>
						<div class="code">layui-icon-zzrocket</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzship"></i>
						<div class="code">layui-icon-zzship</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzspace-shuttle"></i>
						<div class="code">layui-icon-zzspace-shuttle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsubway"></i>
						<div class="code">layui-icon-zzsubway</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztaxi"></i>
						<div class="code">layui-icon-zztaxi</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztrain"></i>
						<div class="code">layui-icon-zztrain</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztruck"></i>
						<div class="code">layui-icon-zztruck</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwheelchair"></i>
						<div class="code">layui-icon-zzwheelchair</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwheelchair-alt"></i>
						<div class="code">layui-icon-zzwheelchair-alt</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-6">性别</div>

					<li>
						<i class="layui-icon layui-icon-zzgenderless"></i>
						<div class="code">layui-icon-zzgenderless</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzintersex"></i>
						<div class="code">layui-icon-zzintersex</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmars"></i>
						<div class="code">layui-icon-zzmars</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmars-double"></i>
						<div class="code">layui-icon-zzmars-double</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmars-stroke"></i>
						<div class="code">layui-icon-zzmars-stroke</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmars-stroke-h"></i>
						<div class="code">layui-icon-zzmars-stroke-h</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmars-stroke-v"></i>
						<div class="code">layui-icon-zzmars-stroke-v</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmercury"></i>
						<div class="code">layui-icon-zzmercury</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzneuter"></i>
						<div class="code">layui-icon-zzneuter</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztransgender"></i>
						<div class="code">layui-icon-zztransgender</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztransgender-alt"></i>
						<div class="code">layui-icon-zztransgender-alt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvenus"></i>
						<div class="code">layui-icon-zzvenus</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvenus-double"></i>
						<div class="code">layui-icon-zzvenus-double</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvenus-mars"></i>
						<div class="code">layui-icon-zzvenus-mars</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-7">文件类型</div>

					<li>
						<i class="layui-icon layui-icon-zzfile"></i>
						<div class="code">layui-icon-zzfile</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-archive-o"></i>
						<div class="code">layui-icon-zzfile-archive-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-audio-o"></i>
						<div class="code">layui-icon-zzfile-audio-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-code-o"></i>
						<div class="code">layui-icon-zzfile-code-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-excel-o"></i>
						<div class="code">layui-icon-zzfile-excel-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-image-o"></i>
						<div class="code">layui-icon-zzfile-image-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-movie-o"></i>
						<div class="code">layui-icon-zzfile-movie-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-o"></i>
						<div class="code">layui-icon-zzfile-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-pdf-o"></i>
						<div class="code">layui-icon-zzfile-pdf-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-photo-o"></i>
						<div class="code">layui-icon-zzfile-photo-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-picture-o"></i>
						<div class="code">layui-icon-zzfile-picture-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-powerpoint-o"></i>
						<div class="code">layui-icon-zzfile-powerpoint-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-sound-o"></i>
						<div class="code">layui-icon-zzfile-sound-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-text"></i>
						<div class="code">layui-icon-zzfile-text</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-text-o"></i>
						<div class="code">layui-icon-zzfile-text-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-video-o"></i>
						<div class="code">layui-icon-zzfile-video-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-word-o"></i>
						<div class="code">layui-icon-zzfile-word-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-zip-o"></i>
						<div class="code">layui-icon-zzfile-zip-o</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-8">可旋转</div>
					<li>
						<i class="layui-icon layui-icon-zzcircle-o-notch"></i>
						<div class="code">layui-icon-zzcircle-o-notch</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcog"></i>
						<div class="code">layui-icon-zzcog</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgear"></i>
						<div class="code">layui-icon-zzgear</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrefresh"></i>
						<div class="code">layui-icon-zzrefresh</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzspinner"></i>
						<div class="code">layui-icon-zzspinner</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-9">表单</div>

					<li>
						<i class="layui-icon layui-icon-zzcheck-square"></i>
						<div class="code">layui-icon-zzcheck-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcheck-square-o"></i>
						<div class="code">layui-icon-zzcheck-square-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcircle"></i>
						<div class="code">layui-icon-zzcircle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcircle-o"></i>
						<div class="code">layui-icon-zzcircle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdot-circle-o"></i>
						<div class="code">layui-icon-zzdot-circle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzminus-square"></i>
						<div class="code">layui-icon-zzminus-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzminus-square-o"></i>
						<div class="code">layui-icon-zzminus-square-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzplus-square"></i>
						<div class="code">layui-icon-zzplus-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzplus-square-o"></i>
						<div class="code">layui-icon-zzplus-square-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsquare"></i>
						<div class="code">layui-icon-zzsquare</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsquare-o"></i>
						<div class="code">layui-icon-zzsquare-o</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-10">支付</div>

					<li>
						<i class="layui-icon layui-icon-zzcc-amex"></i>
						<div class="code">layui-icon-zzcc-amex</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-diners-club"></i>
						<div class="code">layui-icon-zzcc-diners-club</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-discover"></i>
						<div class="code">layui-icon-zzcc-discover</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-jcb"></i>
						<div class="code">layui-icon-zzcc-jcb</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-mastercard"></i>
						<div class="code">layui-icon-zzcc-mastercard</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-paypal"></i>
						<div class="code">layui-icon-zzcc-paypal</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-stripe"></i>
						<div class="code">layui-icon-zzcc-stripe</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-visa"></i>
						<div class="code">layui-icon-zzcc-visa</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcredit-card"></i>
						<div class="code">layui-icon-zzcredit-card</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcredit-card-alt"></i>
						<div class="code">layui-icon-zzcredit-card-alt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgoogle-wallet"></i>
						<div class="code">layui-icon-zzgoogle-wallet</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpaypal"></i>
						<div class="code">layui-icon-zzpaypal</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-11">图表</div>

					<li>
						<i class="layui-icon layui-icon-zzarea-chart"></i>
						<div class="code">layui-icon-zzarea-chart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbar-chart"></i>
						<div class="code">layui-icon-zzbar-chart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbar-chart-o"></i>
						<div class="code">layui-icon-zzbar-chart-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzline-chart"></i>
						<div class="code">layui-icon-zzline-chart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpie-chart"></i>
						<div class="code">layui-icon-zzpie-chart</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-12">货币</div>

					<li>
						<i class="layui-icon layui-icon-zzbitcoin"></i>
						<div class="code">layui-icon-zzbitcoin</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbtc"></i>
						<div class="code">layui-icon-zzbtc</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcny"></i>
						<div class="code">layui-icon-zzcny</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdollar"></i>
						<div class="code">layui-icon-zzdollar</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzeur"></i>
						<div class="code">layui-icon-zzeur</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzeuro"></i>
						<div class="code">layui-icon-zzeuro</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgbp"></i>
						<div class="code">layui-icon-zzgbp</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgg"></i>
						<div class="code">layui-icon-zzgg</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgg-circle"></i>
						<div class="code">layui-icon-zzgg-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzils"></i>
						<div class="code">layui-icon-zzils</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzinr"></i>
						<div class="code">layui-icon-zzinr</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzjpy"></i>
						<div class="code">layui-icon-zzjpy</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzkrw"></i>
						<div class="code">layui-icon-zzkrw</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmoney"></i>
						<div class="code">layui-icon-zzmoney</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrmb"></i>
						<div class="code">layui-icon-zzrmb</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrouble"></i>
						<div class="code">layui-icon-zzrouble</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrub"></i>
						<div class="code">layui-icon-zzrub</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzruble"></i>
						<div class="code">layui-icon-zzruble</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrupee"></i>
						<div class="code">layui-icon-zzrupee</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshekel"></i>
						<div class="code">layui-icon-zzshekel</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsheqel"></i>
						<div class="code">layui-icon-zzsheqel</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztry"></i>
						<div class="code">layui-icon-zztry</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzturkish-lira"></i>
						<div class="code">layui-icon-zzturkish-lira</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzusd"></i>
						<div class="code">layui-icon-zzusd</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwon"></i>
						<div class="code">layui-icon-zzwon</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzyen"></i>
						<div class="code">layui-icon-zzyen</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-13">文本编辑</div>

					<li>
						<i class="layui-icon layui-icon-zzalign-center"></i>
						<div class="code">layui-icon-zzalign-center</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzalign-justify"></i>
						<div class="code">layui-icon-zzalign-justify</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzalign-left"></i>
						<div class="code">layui-icon-zzalign-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzalign-right"></i>
						<div class="code">layui-icon-zzalign-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbold"></i>
						<div class="code">layui-icon-zzbold</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzchain"></i>
						<div class="code">layui-icon-zzchain</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzchain-broken"></i>
						<div class="code">layui-icon-zzchain-broken</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzclipboard"></i>
						<div class="code">layui-icon-zzclipboard</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcolumns"></i>
						<div class="code">layui-icon-zzcolumns</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcopy"></i>
						<div class="code">layui-icon-zzcopy</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcut"></i>
						<div class="code">layui-icon-zzcut</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdedent"></i>
						<div class="code">layui-icon-zzdedent</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzeraser"></i>
						<div class="code">layui-icon-zzeraser</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile"></i>
						<div class="code">layui-icon-zzfile</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-o"></i>
						<div class="code">layui-icon-zzfile-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-text"></i>
						<div class="code">layui-icon-zzfile-text</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfile-text-o"></i>
						<div class="code">layui-icon-zzfile-text-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfiles-o"></i>
						<div class="code">layui-icon-zzfiles-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfloppy-o"></i>
						<div class="code">layui-icon-zzfloppy-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfont"></i>
						<div class="code">layui-icon-zzfont</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzheader"></i>
						<div class="code">layui-icon-zzheader</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzindent"></i>
						<div class="code">layui-icon-zzindent</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzitalic"></i>
						<div class="code">layui-icon-zzitalic</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlink"></i>
						<div class="code">layui-icon-zzlink</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlist"></i>
						<div class="code">layui-icon-zzlist</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlist-alt"></i>
						<div class="code">layui-icon-zzlist-alt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlist-ol"></i>
						<div class="code">layui-icon-zzlist-ol</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlist-ul"></i>
						<div class="code">layui-icon-zzlist-ul</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzoutdent"></i>
						<div class="code">layui-icon-zzoutdent</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpaperclip"></i>
						<div class="code">layui-icon-zzpaperclip</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzparagraph"></i>
						<div class="code">layui-icon-zzparagraph</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpaste"></i>
						<div class="code">layui-icon-zzpaste</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrepeat"></i>
						<div class="code">layui-icon-zzrepeat</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrotate-left"></i>
						<div class="code">layui-icon-zzrotate-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrotate-right"></i>
						<div class="code">layui-icon-zzrotate-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsave"></i>
						<div class="code">layui-icon-zzsave</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzscissors"></i>
						<div class="code">layui-icon-zzscissors</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstrikethrough"></i>
						<div class="code">layui-icon-zzstrikethrough</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsubscript"></i>
						<div class="code">layui-icon-zzsubscript</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsuperscript"></i>
						<div class="code">layui-icon-zzsuperscript</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztable"></i>
						<div class="code">layui-icon-zztable</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztext-height"></i>
						<div class="code">layui-icon-zztext-height</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztext-width"></i>
						<div class="code">layui-icon-zztext-width</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzth"></i>
						<div class="code">layui-icon-zzth</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzth-large"></i>
						<div class="code">layui-icon-zzth-large</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzth-list"></i>
						<div class="code">layui-icon-zzth-list</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzunderline"></i>
						<div class="code">layui-icon-zzunderline</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzundo"></i>
						<div class="code">layui-icon-zzundo</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzunlink"></i>
						<div class="code">layui-icon-zzunlink</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-14">指示方向</div>

					<li>
						<i class="layui-icon layui-icon-zzangle-double-down"></i>
						<div class="code">layui-icon-zzangle-double-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzangle-double-left"></i>
						<div class="code">layui-icon-zzangle-double-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzangle-double-right"></i>
						<div class="code">layui-icon-zzangle-double-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzangle-double-up"></i>
						<div class="code">layui-icon-zzangle-double-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzangle-down"></i>
						<div class="code">layui-icon-zzangle-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzangle-left"></i>
						<div class="code">layui-icon-zzangle-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzangle-right"></i>
						<div class="code">layui-icon-zzangle-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzangle-up"></i>
						<div class="code">layui-icon-zzangle-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrow-circle-down"></i>
						<div class="code">layui-icon-zzarrow-circle-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrow-circle-left"></i>
						<div class="code">layui-icon-zzarrow-circle-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrow-circle-o-down"></i>
						<div class="code">layui-icon-zzarrow-circle-o-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrow-circle-o-left"></i>
						<div class="code">layui-icon-zzarrow-circle-o-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrow-circle-o-right"></i>
						<div class="code">layui-icon-zzarrow-circle-o-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrow-circle-o-up"></i>
						<div class="code">layui-icon-zzarrow-circle-o-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrow-circle-right"></i>
						<div class="code">layui-icon-zzarrow-circle-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrow-circle-up"></i>
						<div class="code">layui-icon-zzarrow-circle-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrow-down"></i>
						<div class="code">layui-icon-zzarrow-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrow-left"></i>
						<div class="code">layui-icon-zzarrow-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrow-right"></i>
						<div class="code">layui-icon-zzarrow-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrow-up"></i>
						<div class="code">layui-icon-zzarrow-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrows"></i>
						<div class="code">layui-icon-zzarrows</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrows-alt"></i>
						<div class="code">layui-icon-zzarrows-alt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrows-h"></i>
						<div class="code">layui-icon-zzarrows-h</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzarrows-v"></i>
						<div class="code">layui-icon-zzarrows-v</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcaret-down"></i>
						<div class="code">layui-icon-zzcaret-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcaret-left"></i>
						<div class="code">layui-icon-zzcaret-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcaret-right"></i>
						<div class="code">layui-icon-zzcaret-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcaret-square-o-down"></i>
						<div class="code">layui-icon-zzcaret-square-o-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcaret-square-o-left"></i>
						<div class="code">layui-icon-zzcaret-square-o-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcaret-square-o-right"></i>
						<div class="code">layui-icon-zzcaret-square-o-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcaret-square-o-up"></i>
						<div class="code">layui-icon-zzcaret-square-o-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcaret-up"></i>
						<div class="code">layui-icon-zzcaret-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzchevron-circle-down"></i>
						<div class="code">layui-icon-zzchevron-circle-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzchevron-circle-left"></i>
						<div class="code">layui-icon-zzchevron-circle-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzchevron-circle-right"></i>
						<div class="code">layui-icon-zzchevron-circle-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzchevron-circle-up"></i>
						<div class="code">layui-icon-zzchevron-circle-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzchevron-down"></i>
						<div class="code">layui-icon-zzchevron-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzchevron-left"></i>
						<div class="code">layui-icon-zzchevron-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzchevron-right"></i>
						<div class="code">layui-icon-zzchevron-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzchevron-up"></i>
						<div class="code">layui-icon-zzchevron-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzexchange"></i>
						<div class="code">layui-icon-zzexchange</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-o-down"></i>
						<div class="code">layui-icon-zzhand-o-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-o-left"></i>
						<div class="code">layui-icon-zzhand-o-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-o-right"></i>
						<div class="code">layui-icon-zzhand-o-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhand-o-up"></i>
						<div class="code">layui-icon-zzhand-o-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlong-arrow-down"></i>
						<div class="code">layui-icon-zzlong-arrow-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlong-arrow-left"></i>
						<div class="code">layui-icon-zzlong-arrow-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlong-arrow-right"></i>
						<div class="code">layui-icon-zzlong-arrow-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlong-arrow-up"></i>
						<div class="code">layui-icon-zzlong-arrow-up</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztoggle-down"></i>
						<div class="code">layui-icon-zztoggle-down</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztoggle-left"></i>
						<div class="code">layui-icon-zztoggle-left</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztoggle-right"></i>
						<div class="code">layui-icon-zztoggle-right</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztoggle-up"></i>
						<div class="code">layui-icon-zztoggle-up</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-15">视频播放</div>

					<li>
						<i class="layui-icon layui-icon-zzarrows-alt"></i>
						<div class="code">layui-icon-zzarrows-alt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbackward"></i>
						<div class="code">layui-icon-zzbackward</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcompress"></i>
						<div class="code">layui-icon-zzcompress</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzeject"></i>
						<div class="code">layui-icon-zzeject</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzexpand"></i>
						<div class="code">layui-icon-zzexpand</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfast-backward"></i>
						<div class="code">layui-icon-zzfast-backward</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfast-forward"></i>
						<div class="code">layui-icon-zzfast-forward</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzforward"></i>
						<div class="code">layui-icon-zzforward</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpause"></i>
						<div class="code">layui-icon-zzpause</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpause-circle"></i>
						<div class="code">layui-icon-zzpause-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpause-circle-o"></i>
						<div class="code">layui-icon-zzpause-circle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzplay"></i>
						<div class="code">layui-icon-zzplay</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzplay-circle"></i>
						<div class="code">layui-icon-zzplay-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzplay-circle-o"></i>
						<div class="code">layui-icon-zzplay-circle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrandom"></i>
						<div class="code">layui-icon-zzrandom</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstep-backward"></i>
						<div class="code">layui-icon-zzstep-backward</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstep-forward"></i>
						<div class="code">layui-icon-zzstep-forward</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstop"></i>
						<div class="code">layui-icon-zzstop</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstop-circle"></i>
						<div class="code">layui-icon-zzstop-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstop-circle-o"></i>
						<div class="code">layui-icon-zzstop-circle-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzyoutube-play"></i>
						<div class="code">layui-icon-zzyoutube-play</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-16">标志</div>
					<li>
						<i class="layui-icon layui-icon-zz500px"></i>
						<div class="code">layui-icon-zz500px</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzadn"></i>
						<div class="code">layui-icon-zzadn</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzamazon"></i>
						<div class="code">layui-icon-zzamazon</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzandroid"></i>
						<div class="code">layui-icon-zzandroid</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzangellist"></i>
						<div class="code">layui-icon-zzangellist</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzapple"></i>
						<div class="code">layui-icon-zzapple</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbandcamp"></i>
						<div class="code">layui-icon-zzbandcamp</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbehance"></i>
						<div class="code">layui-icon-zzbehance</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbehance-square"></i>
						<div class="code">layui-icon-zzbehance-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbitbucket"></i>
						<div class="code">layui-icon-zzbitbucket</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbitbucket-square"></i>
						<div class="code">layui-icon-zzbitbucket-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbitcoin"></i>
						<div class="code">layui-icon-zzbitcoin</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzblack-tie"></i>
						<div class="code">layui-icon-zzblack-tie</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbluetooth"></i>
						<div class="code">layui-icon-zzbluetooth</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbluetooth-b"></i>
						<div class="code">layui-icon-zzbluetooth-b</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbtc"></i>
						<div class="code">layui-icon-zzbtc</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzbuysellads"></i>
						<div class="code">layui-icon-zzbuysellads</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-amex"></i>
						<div class="code">layui-icon-zzcc-amex</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-diners-club"></i>
						<div class="code">layui-icon-zzcc-diners-club</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-discover"></i>
						<div class="code">layui-icon-zzcc-discover</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-jcb"></i>
						<div class="code">layui-icon-zzcc-jcb</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-mastercard"></i>
						<div class="code">layui-icon-zzcc-mastercard</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-paypal"></i>
						<div class="code">layui-icon-zzcc-paypal</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-stripe"></i>
						<div class="code">layui-icon-zzcc-stripe</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcc-visa"></i>
						<div class="code">layui-icon-zzcc-visa</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzchrome"></i>
						<div class="code">layui-icon-zzchrome</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcodepen"></i>
						<div class="code">layui-icon-zzcodepen</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcodiepie"></i>
						<div class="code">layui-icon-zzcodiepie</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzconnectdevelop"></i>
						<div class="code">layui-icon-zzconnectdevelop</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcontao"></i>
						<div class="code">layui-icon-zzcontao</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzcss3"></i>
						<div class="code">layui-icon-zzcss3</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdashcube"></i>
						<div class="code">layui-icon-zzdashcube</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdelicious"></i>
						<div class="code">layui-icon-zzdelicious</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdeviantart"></i>
						<div class="code">layui-icon-zzdeviantart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdigg"></i>
						<div class="code">layui-icon-zzdigg</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdribbble"></i>
						<div class="code">layui-icon-zzdribbble</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdropbox"></i>
						<div class="code">layui-icon-zzdropbox</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzdrupal"></i>
						<div class="code">layui-icon-zzdrupal</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzedge"></i>
						<div class="code">layui-icon-zzedge</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzeercast"></i>
						<div class="code">layui-icon-zzeercast</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzempire"></i>
						<div class="code">layui-icon-zzempire</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzenvira"></i>
						<div class="code">layui-icon-zzenvira</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzetsy"></i>
						<div class="code">layui-icon-zzetsy</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzexpeditedssl"></i>
						<div class="code">layui-icon-zzexpeditedssl</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfa"></i>
						<div class="code">layui-icon-zzfa</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfacebook"></i>
						<div class="code">layui-icon-zzfacebook</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfacebook-f"></i>
						<div class="code">layui-icon-zzfacebook-f</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfacebook-official"></i>
						<div class="code">layui-icon-zzfacebook-official</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfacebook-square"></i>
						<div class="code">layui-icon-zzfacebook-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfirefox"></i>
						<div class="code">layui-icon-zzfirefox</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfirst-order"></i>
						<div class="code">layui-icon-zzfirst-order</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzflickr"></i>
						<div class="code">layui-icon-zzflickr</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfont-awesome"></i>
						<div class="code">layui-icon-zzfont-awesome</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfonticons"></i>
						<div class="code">layui-icon-zzfonticons</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfort-awesome"></i>
						<div class="code">layui-icon-zzfort-awesome</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzforumbee"></i>
						<div class="code">layui-icon-zzforumbee</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfoursquare"></i>
						<div class="code">layui-icon-zzfoursquare</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzfree-code-camp"></i>
						<div class="code">layui-icon-zzfree-code-camp</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzge"></i>
						<div class="code">layui-icon-zzge</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzget-pocket"></i>
						<div class="code">layui-icon-zzget-pocket</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgg"></i>
						<div class="code">layui-icon-zzgg</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgg-circle"></i>
						<div class="code">layui-icon-zzgg-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgit"></i>
						<div class="code">layui-icon-zzgit</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgit-square"></i>
						<div class="code">layui-icon-zzgit-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgithub"></i>
						<div class="code">layui-icon-zzgithub</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgithub-alt"></i>
						<div class="code">layui-icon-zzgithub-alt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgithub-square"></i>
						<div class="code">layui-icon-zzgithub-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgitlab"></i>
						<div class="code">layui-icon-zzgitlab</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgittip"></i>
						<div class="code">layui-icon-zzgittip</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzglide"></i>
						<div class="code">layui-icon-zzglide</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzglide-g"></i>
						<div class="code">layui-icon-zzglide-g</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgoogle"></i>
						<div class="code">layui-icon-zzgoogle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgoogle-plus"></i>
						<div class="code">layui-icon-zzgoogle-plus</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgoogle-plus-circle"></i>
						<div class="code">layui-icon-zzgoogle-plus-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgoogle-plus-official"></i>
						<div class="code">layui-icon-zzgoogle-plus-official</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgoogle-plus-square"></i>
						<div class="code">layui-icon-zzgoogle-plus-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgoogle-wallet"></i>
						<div class="code">layui-icon-zzgoogle-wallet</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgratipay"></i>
						<div class="code">layui-icon-zzgratipay</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzgrav"></i>
						<div class="code">layui-icon-zzgrav</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhacker-news"></i>
						<div class="code">layui-icon-zzhacker-news</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhouzz"></i>
						<div class="code">layui-icon-zzhouzz</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhtml5"></i>
						<div class="code">layui-icon-zzhtml5</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzimdb"></i>
						<div class="code">layui-icon-zzimdb</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzinstagram"></i>
						<div class="code">layui-icon-zzinstagram</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzinternet-explorer"></i>
						<div class="code">layui-icon-zzinternet-explorer</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzioxhost"></i>
						<div class="code">layui-icon-zzioxhost</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzjoomla"></i>
						<div class="code">layui-icon-zzjoomla</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzjsfiddle"></i>
						<div class="code">layui-icon-zzjsfiddle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlastfm"></i>
						<div class="code">layui-icon-zzlastfm</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlastfm-square"></i>
						<div class="code">layui-icon-zzlastfm-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzleanpub"></i>
						<div class="code">layui-icon-zzleanpub</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlinkedin"></i>
						<div class="code">layui-icon-zzlinkedin</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlinkedin-square"></i>
						<div class="code">layui-icon-zzlinkedin-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlinode"></i>
						<div class="code">layui-icon-zzlinode</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzlinux"></i>
						<div class="code">layui-icon-zzlinux</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmaxcdn"></i>
						<div class="code">layui-icon-zzmaxcdn</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmeanpath"></i>
						<div class="code">layui-icon-zzmeanpath</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmedium"></i>
						<div class="code">layui-icon-zzmedium</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmeetup"></i>
						<div class="code">layui-icon-zzmeetup</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmixcloud"></i>
						<div class="code">layui-icon-zzmixcloud</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmodx"></i>
						<div class="code">layui-icon-zzmodx</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzodnoklassniki"></i>
						<div class="code">layui-icon-zzodnoklassniki</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzodnoklassniki-square"></i>
						<div class="code">layui-icon-zzodnoklassniki-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzopencart"></i>
						<div class="code">layui-icon-zzopencart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzopenid"></i>
						<div class="code">layui-icon-zzopenid</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzopera"></i>
						<div class="code">layui-icon-zzopera</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzoptin-monster"></i>
						<div class="code">layui-icon-zzoptin-monster</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpagelines"></i>
						<div class="code">layui-icon-zzpagelines</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpaypal"></i>
						<div class="code">layui-icon-zzpaypal</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpied-piper"></i>
						<div class="code">layui-icon-zzpied-piper</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpied-piper-alt"></i>
						<div class="code">layui-icon-zzpied-piper-alt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpied-piper-pp"></i>
						<div class="code">layui-icon-zzpied-piper-pp</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpinterest"></i>
						<div class="code">layui-icon-zzpinterest</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpinterest-p"></i>
						<div class="code">layui-icon-zzpinterest-p</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzpinterest-square"></i>
						<div class="code">layui-icon-zzpinterest-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzproduct-hunt"></i>
						<div class="code">layui-icon-zzproduct-hunt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzqq"></i>
						<div class="code">layui-icon-zzqq</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzquora"></i>
						<div class="code">layui-icon-zzquora</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzra"></i>
						<div class="code">layui-icon-zzra</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzravelry"></i>
						<div class="code">layui-icon-zzravelry</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrebel"></i>
						<div class="code">layui-icon-zzrebel</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzreddit"></i>
						<div class="code">layui-icon-zzreddit</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzreddit-alien"></i>
						<div class="code">layui-icon-zzreddit-alien</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzreddit-square"></i>
						<div class="code">layui-icon-zzreddit-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzrenren"></i>
						<div class="code">layui-icon-zzrenren</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzresistance"></i>
						<div class="code">layui-icon-zzresistance</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsafari"></i>
						<div class="code">layui-icon-zzsafari</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzscribd"></i>
						<div class="code">layui-icon-zzscribd</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsellsy"></i>
						<div class="code">layui-icon-zzsellsy</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshare-alt"></i>
						<div class="code">layui-icon-zzshare-alt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshare-alt-square"></i>
						<div class="code">layui-icon-zzshare-alt-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzshirtsinbulk"></i>
						<div class="code">layui-icon-zzshirtsinbulk</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsimplybuilt"></i>
						<div class="code">layui-icon-zzsimplybuilt</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzskyatlas"></i>
						<div class="code">layui-icon-zzskyatlas</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzskype"></i>
						<div class="code">layui-icon-zzskype</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzslack"></i>
						<div class="code">layui-icon-zzslack</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzslideshare"></i>
						<div class="code">layui-icon-zzslideshare</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsnapchat"></i>
						<div class="code">layui-icon-zzsnapchat</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsnapchat-ghost"></i>
						<div class="code">layui-icon-zzsnapchat-ghost</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsnapchat-square"></i>
						<div class="code">layui-icon-zzsnapchat-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsoundcloud"></i>
						<div class="code">layui-icon-zzsoundcloud</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzspotify"></i>
						<div class="code">layui-icon-zzspotify</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstack-exchange"></i>
						<div class="code">layui-icon-zzstack-exchange</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstack-overflow"></i>
						<div class="code">layui-icon-zzstack-overflow</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsteam"></i>
						<div class="code">layui-icon-zzsteam</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsteam-square"></i>
						<div class="code">layui-icon-zzsteam-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstumbleupon"></i>
						<div class="code">layui-icon-zzstumbleupon</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstumbleupon-circle"></i>
						<div class="code">layui-icon-zzstumbleupon-circle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzsuperpowers"></i>
						<div class="code">layui-icon-zzsuperpowers</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztelegram"></i>
						<div class="code">layui-icon-zztelegram</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztencent-weibo"></i>
						<div class="code">layui-icon-zztencent-weibo</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzthemeisle"></i>
						<div class="code">layui-icon-zzthemeisle</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztrello"></i>
						<div class="code">layui-icon-zztrello</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztripadvisor"></i>
						<div class="code">layui-icon-zztripadvisor</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztumblr"></i>
						<div class="code">layui-icon-zztumblr</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztumblr-square"></i>
						<div class="code">layui-icon-zztumblr-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztwitch"></i>
						<div class="code">layui-icon-zztwitch</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztwitter"></i>
						<div class="code">layui-icon-zztwitter</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zztwitter-square"></i>
						<div class="code">layui-icon-zztwitter-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzusb"></i>
						<div class="code">layui-icon-zzusb</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzviacoin"></i>
						<div class="code">layui-icon-zzviacoin</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzviadeo"></i>
						<div class="code">layui-icon-zzviadeo</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzviadeo-square"></i>
						<div class="code">layui-icon-zzviadeo-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvimeo"></i>
						<div class="code">layui-icon-zzvimeo</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvimeo-square"></i>
						<div class="code">layui-icon-zzvimeo-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvine"></i>
						<div class="code">layui-icon-zzvine</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzvk"></i>
						<div class="code">layui-icon-zzvk</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwechat"></i>
						<div class="code">layui-icon-zzwechat</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzweibo"></i>
						<div class="code">layui-icon-zzweibo</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzweixin"></i>
						<div class="code">layui-icon-zzweixin</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwhatsapp"></i>
						<div class="code">layui-icon-zzwhatsapp</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwikipedia-w"></i>
						<div class="code">layui-icon-zzwikipedia-w</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwindows"></i>
						<div class="code">layui-icon-zzwindows</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwordpress"></i>
						<div class="code">layui-icon-zzwordpress</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwpbeginner"></i>
						<div class="code">layui-icon-zzwpbeginner</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwpexplorer"></i>
						<div class="code">layui-icon-zzwpexplorer</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwpforms"></i>
						<div class="code">layui-icon-zzwpforms</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzxing"></i>
						<div class="code">layui-icon-zzxing</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzxing-square"></i>
						<div class="code">layui-icon-zzxing-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzy-combinator"></i>
						<div class="code">layui-icon-zzy-combinator</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzy-combinator-square"></i>
						<div class="code">layui-icon-zzy-combinator-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzyahoo"></i>
						<div class="code">layui-icon-zzyahoo</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzyc"></i>
						<div class="code">layui-icon-zzyc</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzyc-square"></i>
						<div class="code">layui-icon-zzyc-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzyelp"></i>
						<div class="code">layui-icon-zzyelp</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzyoast"></i>
						<div class="code">layui-icon-zzyoast</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzyoutube"></i>
						<div class="code">layui-icon-zzyoutube</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzyoutube-play"></i>
						<div class="code">layui-icon-zzyoutube-play</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzyoutube-square"></i>
						<div class="code">layui-icon-zzyoutube-square</div>
					</li>

					<hr>
					<div class="layui-card-header" style="text-align: center; font-size: 18px;" id="zai-17">医疗</div>

					<li>
						<i class="layui-icon layui-icon-zzambulance"></i>
						<div class="code">layui-icon-zzambulance</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzh-square"></i>
						<div class="code">layui-icon-zzh-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzheart"></i>
						<div class="code">layui-icon-zzheart</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzheart-o"></i>
						<div class="code">layui-icon-zzheart-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzheartbeat"></i>
						<div class="code">layui-icon-zzheartbeat</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzhospital-o"></i>
						<div class="code">layui-icon-zzhospital-o</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzmedkit"></i>
						<div class="code">layui-icon-zzmedkit</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzplus-square"></i>
						<div class="code">layui-icon-zzplus-square</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzstethoscope"></i>
						<div class="code">layui-icon-zzstethoscope</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzuser-md"></i>
						<div class="code">layui-icon-zzuser-md</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwheelchair"></i>
						<div class="code">layui-icon-zzwheelchair</div>
					</li>
					<li>
						<i class="layui-icon layui-icon-zzwheelchair-alt"></i>
						<div class="code">layui-icon-zzwheelchair-alt</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<hr>
	<div class="zai-class">
		<ul>
			<li><a href="#layui">Layui</a></li>
			<li><a href="#zai-a">开发图标</a></li>
			<li><a href="#zai-b">基地图标</a></li>
			<li><a href="#zai-c">线性图标</a></li>
			<li><a href="#zai-d">多媒体图标</a></li>
			<li><a href="#zai-e">箭头方向</a></li>
			<li><a href="#zai-f">手势操作</a></li>
			<li><a href="#zai-g">国际品牌</a></li>
			<li><a href="#zai-h">中国品牌</a></li>
			<li><a href="#zai-1">第三方新图标</a></li>
			<li><a href="#zai-2">网页图标</a></li>
			<li><a href="#zai-3">辅助功能</a></li>
			<li><a href="#zai-4">手势图标</a></li>
			<li><a href="#zai-5">运输图标</a></li>
			<li><a href="#zai-6">性别图标</a></li>
			<li><a href="#zai-7">文件类型</a></li>
			<li><a href="#zai-8">可旋转图标</a></li>
			<li><a href="#zai-9">表单图标</a></li>
			<li><a href="#zai-10">支付图标</a></li>
			<li><a href="#zai-11">图表图标</a></li>
			<li><a href="#zai-12">货币图标</a></li>
			<li><a href="#zai-13">文本编辑</a></li>
			<li><a href="#zai-14">指示方向</a></li>
			<li><a href="#zai-15">视频播放</a></li>
			<li><a href="#zai-16">标志图标</a></li>
			<li><a href="#zai-17">医疗图标</a></li>
		</ul>
	</div>

	<script type="text/javascript" src="${ctxStatic}/js/sys/icons.js"></script>

</body>
</html>