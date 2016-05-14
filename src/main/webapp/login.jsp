<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/bootstrap.jspf"%>
<title>登录界面</title>
</head>
<body>
	<h1 class="text-center">学生在线考试系统</h1>
	<div class="container">
		<form id="login_fm">
			<div class="form-group">
				<label for="userno">学号</label> <input type="text"
					class="form-control" id="userno" placeholder="学号">
			</div>
			<div class="form-group">
				<label for="username">用户名</label> <input type="text"
					class="form-control" id="username" placeholder="用户名">
			</div>
			<div class="form-group">
				<label for="userpass">密码</label> <input type="password"
					class="form-control" id="userpass" placeholder="密码">
			</div>


			<button id="login_btn" type="submit" class="btn btn-default">登录</button>
			<button id="register_btn" type="submit" class="btn btn-default">注册</button>
		</form>
	</div>
	<input type="text" id="baseUrl" value="${pageContext.request.contextPath}">
	<!-- js脚本加载区域 -->
	<script src="${pageContext.request.contextPath}/js/login.js"></script>
</body>
</html>