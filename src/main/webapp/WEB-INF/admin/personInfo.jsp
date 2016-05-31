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

	<h1 class="text-center bg-info">管理员信息查询</h1>
	<div class="container">
		<form>
			<div class="form-group">
				<label for="username">用户名</label> <input type="text"
					class="form-control" id="username" name="username"
					value="${currentAdmin.username }">
			</div>
			<div class="form-group">
				<label for="realname">真实名</label> <input type="text"
					class="form-control" id="realname" name="realname" 
					value="${currentAdmin.realname }">
			</div>
			<div class="form-group">
				<label for="mobi">手机</label> <input type="text" class="form-control"
					id="mobi" name="mobi" value="${currentAdmin.mobi }">
			</div>
			<div class="form-group">
				<label for="remark">备注</label> <input type="text"
					class="form-control" id="remark"  name="remark"value="${currentAdmin.remark }">
			</div>			
		</form>

	</div>
</body>
</html>