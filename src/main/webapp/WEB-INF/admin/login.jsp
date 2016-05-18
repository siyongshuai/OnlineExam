<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/bootstrap2.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	${message}
	<h1 class="text-center bg-info">学生在线考试系统管理员登陆界面</h1>
	<div class="container">
		<form:form id="loginForm" method="post" action="login.do"
			commandName="adminBean">
		
			<br>
			<div class="form-group">
				<form:label path="username">输入用户名</form:label>
				<form:input id="username" name="username" path="username" class="form-control" />
			</div>
			<br>
			<div class="form-group">
				<form:label path="userpass">输入密码</form:label>
				<form:password id="userpass" name="userpass" path="userpass" class="form-control" />
			</div>
			<br>
			<input type="submit" value="登录" />
		</form:form>

	</div>
</body>
</html>