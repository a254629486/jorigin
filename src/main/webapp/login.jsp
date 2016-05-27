<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/login"
		method="post">
		账号：<input type="text" name="username" /><br /> 密码：<input
			type="password" name="password" /><br /> <input type="submit"
			value="登陆" />
	</form>
</body>
</html>