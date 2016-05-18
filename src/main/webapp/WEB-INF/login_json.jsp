<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>登录界面</title>
</head>
<body>
	<h1 class="text-center">学生在线考试系统</h1>
	<div class="container">
		
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
			
		
		
		<input type="submit" id="login_btn"  class="btn btn-default" value="登录">
		<a href="http://www.baidu.com" target="_blank">新标签页</a>
	</div>

	<!-- js脚本加载区域 -->
	<script src="${pageContext.request.contextPath}/js/login.js"></script>
</body>
</html>