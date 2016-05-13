<%@page import="com.sun.mail.imap.protocol.Status"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 为了确保适当的绘制和触屏缩放，需要在 <head> 之中添加 viewport 元数据标签 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>开始考试</title>
</head>
<body>
	<div class="container-fluid container">
		<form action="">

			<c:forEach items="${questionList}" var="b" varStatus="status">
				<br>
				<label>第${status.index + 1}题</label>
				<label>${b.question.content }</label>
				<br />
				<input type="radio" name="question_${b.question.id }" value="A" />A. ${b.question.optiona }<br />
				<input type="radio" name="question_${b.question.id }" value="B" />B. ${b.question.optionb }<br />
				<input type="radio" name="question_${b.question.id }" value="C" />C. ${b.question.optionc }<br />
				<input type="radio" name="question_${b.question.id }" value="D" />D. ${b.question.optiond }<br />
			</c:forEach>
			<a href="#" class="easyui-linkbutton" plain="true"
				iconCls="icon-save">提交</a>
		</form>
	</div>



</body>
</html>
