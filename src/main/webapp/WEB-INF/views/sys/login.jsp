<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<form action="${ctx}/sys/login" method="post">
		<input id="userName" name="userName" type="text">
		<input id="passWord" name="passWord" type="password">
		<input id="rememberMe" name="rememberMe" value="false">
		<button type="submit">提交</button>
	</form>
</body>
</html>