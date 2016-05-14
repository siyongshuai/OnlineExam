/**
 * 
 */
// 定义登录函数
var baseUrl = $('#baseUrl').val()
function user_login(){
	var student = {}
	student.userno = $('#userno').val()
	student.userpass = $('#userpass').val()
	student.username = $('#username').val()
	alert(student)
	console.log(student.userno)
	console.log(student.userpass)
	console.log(student.username)
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/OnlineExam" + "/front_page/student/login1.do",
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify(student),
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
		
	})
	
	
}


	
	
	$(document).ready(function(){
		
		$("#login_btn").click(user_login)
	})