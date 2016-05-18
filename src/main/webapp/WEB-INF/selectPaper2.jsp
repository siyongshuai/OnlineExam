<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/commons/csslibs.jspf"%>
<%@include file="/commons/jslibs.jspf"%>
<%@include file="/commons/bootstrap.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>准备考试</title>
</head>
<body>
	<div class="container">
		<input id="cc" name="pid" class="easyui-combobox ">
		
	</div>
	<script>

$(function(){
	var domain = "http://localhost:8080"
		var contextPath = "${pageContext.request.contextPath}"
		var moduleName = "/manage_page/paper/"
		var method = "get.do"
		var url = domain+contextPath+moduleName+method
		console.log(url)
		$('#cc').combobox({
		    url:url,
		    valueField:'id',
		    textField:'paperName'
		});
})
</script>

</body>
</html>