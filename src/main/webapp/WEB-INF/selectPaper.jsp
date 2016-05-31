<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@include file="/commons/bootstrap2.jspf"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择试卷</title>
</head>
<body>

	<h1 class="text-center bg-info">请选择试卷，准备进入考试</h1>
	<h1 class="text-center bg-info">session里面当前的用户${currentUser.username}</h1>
	<h1 class="text-center bg-info">session里面当前的用户id${currentUser.id}</h1>
	<input type="hidden"  id="uid" name="uid" value="${currentUser.id}">
	<div class="container">


			
			<form:select id="pid" path="papers" items="${papers}"
					itemLabel="paperName" itemValue="id"  class="form-control input-lg"/>

	</div>
	<br>
	<br>
	<p class="text-center">
	<a id="startBtn" class=" btn btn-default btn-lg btn-danger" href="#" >开始考试</a>
	</p>
	<script type="text/javascript">
	
	$('#startBtn').click(function(){
		var uid = $('#uid').val()
		var pid = $('#pid').val()
		var domain = "http://localhost:8080"
		var requestContext = "${pageContext.request.contextPath}"
		var urlNameSpace = "/admin/paper/"
		var url = domain+requestContext+urlNameSpace+"display.do?pid="+pid+"&uid="+uid
		var start = $('#startBtn').attr("href",url)
		console.log("uid------------"+uid)
		console.log("pid------------"+pid)
		console.log(url)
	})
	
	
	
	</script>
</body>
</html>