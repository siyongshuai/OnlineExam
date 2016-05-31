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
				.ready(
						function() {

							$.ajax({
										type : "POST",
										url : "${pageContext.request.contextPath}/admin/question/add.do",
										dataType : "json",
										contentType : "application/json;charset=UTF-8",
										data : JSON.stringify({										    
									        "dbid": 1,
									        "qtype": 2,
									        "qlevel": 1,
									        "qfrom": 1,
									        "status": "1",
									        "optiona": "重载",
									        "optionb": "重写",
									        "optionc": "封装",
									        "optiond": "继承",
									        "postdate": null,
									        "adminid": null,
									        "content": "以下属于面向对象的特征的是",
									        "skey": "C,D",
									        "keydesc": "考察面向对象的基础知识"
											    }),
										success : function(data) {

											alert("操作成功")
											// console.log(JSON.stringify(saveDataAry))  

										},
										error : function(XMLHttpRequest, textStatus, errorThrown) {
					                        console.log(XMLHttpRequest.status);
					                        console.log(XMLHttpRequest.readyState);
					                        console.log(textStatus);
					                        console.log("操作失败")
					                    }
									});
						});
	</script>
</body>
</html>