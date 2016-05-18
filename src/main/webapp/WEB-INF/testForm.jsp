<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${stu.username}
	<form:form id="loginForm" method="post" action="res.do" commandName="stu">

		<form:label path="userno">输入学号</form:label>
		<form:input id="userno" name="userno" path="userno"
			 />

		<br>

		<form:label path="username">输入用户名</form:label>
		<form:input id="username" name="username" path="username"
			 />

		<br>

		<form:label path="userpass">输入密码</form:label>
		<form:password id="userpass" name="userpass" path="userpass"
			 />

		<br>
		<input type="submit" value="登录" />
	</form:form>

</body>
</html>