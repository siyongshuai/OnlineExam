<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax TEST</title>

</head>
<body>
	hello ajax
	<script
		src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(function() {
					$
							.ajax({
								type : "POST",
								url : "${pageContext.request.contextPath}/manage_page/ed/many.do",
								dataType : "json",
								contentType : "application/json;charset=UTF-8",
								data : JSON.stringify([ {
									"userAnswer" : "C",
									"uid" : 1,
									"qid" : "22"
								}, {
									"userAnswer" : "A",
									"uid" : 1,
									"qid" : "19"
								}, {
									"userAnswer" : "C",
									"uid" : 1,
									"qid" : "1"
								}, {
									"userAnswer" : "B",
									"uid" : 1,
									"qid" : "13"
								}, {
									"userAnswer" : "B",
									"uid" : 1,
									"qid" : "16"
								} ]),
								success : function(data) {

									alert("操作成功")
									// console.log(JSON.stringify(saveDataAry))  

								},
								error : function(XMLHttpRequest, textStatus,
										errorThrown) {
									console.log(XMLHttpRequest.status);
									console.log(XMLHttpRequest.readyState);
									console.log(textStatus);
									console.log("操作失败")
								}
							});
				})
	</script>
</body>
</html>