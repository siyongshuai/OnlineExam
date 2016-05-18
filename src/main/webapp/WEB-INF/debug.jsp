<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Request Scope (key==values)</h3>
<%
java.util.Enumeration<String> reqEnum = request.getAttributeNames();
while (reqEnum.hasMoreElements()) {
String s = reqEnum.nextElement();
out.print(s);
out.println("==" + request.getAttribute(s));
%><br />
<%} %>


Read more: http://www.intertech.com/Blog/understanding-spring-mvc-model-and-session-attributes/#ixzz48jB6JF1B 
Follow us: @IntertechInc on Twitter | Intertech on Facebook
</body>
</html>