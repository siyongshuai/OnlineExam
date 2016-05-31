<%@page import="com.sun.mail.imap.protocol.Status"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/bootstrap2.jspf"%>
<title>开始考试</title>
</head>
<body>
 
	<p>欢迎${currentUser.username}</p>
	<p>试卷id=${paperId}</p>
	<p>用户id <input type="text" id="uid" name="uid" value="${userId}"></p>
	<div id="getting-started"></div>
	<br />
	<br />
	<br />
	<div class="container"  >
		<h1><span id="clock" class="bg-primary" ></span></h1>
	</div>

	<div class="container-fluid container">
		<form action="">

			<c:forEach items="${questionList}" var="b" varStatus="status">
				<br>
				<label>第${status.index + 1}题</label>
				<label>${b.question.content }</label>
				<br />
				<input type="radio" name="${b.question.id }" value="A" />A. ${b.question.optiona }<br />
				<input type="radio" name="${b.question.id }" value="B" />B. ${b.question.optionb }<br />
				<input type="radio" name="${b.question.id }" value="C" />C. ${b.question.optionc }<br />
				<input type="radio" name="${b.question.id }" value="D" />D. ${b.question.optiond }<br />
			</c:forEach>
			<button id="endExamBtn" type="button" class="btn btn-warning">提交</button>

		</form>
	</div>
<!-- 定义一个隐藏区域来保存pid -->
<!-- 当前用户id -->
<input type="text" id="uid" name="uid" value="${currentUser.username }">
<!-- 当前试卷id -->
<input type="hidden" id="paperId" name="paperId" value="${paperId }">

	<script src="${pageContext.request.contextPath}/js/display.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.countdown.min.js"></script>

</body>
</html>
