<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${ctx}/sys/login" method="post">
		<input id="username" name="username" type="text">
		<input id="password" name="password" type="password">
		<button type="submit">提交</button>
	</form>
</body>
</html>