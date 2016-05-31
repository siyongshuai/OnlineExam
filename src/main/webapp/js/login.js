/**
 * 
 */
// 定义登录函数

function login_fm(){
	var url = "http://localhost:8080/OnlineExam/admin/student/login6.do"
	var student = {}
	student.userno = $('#userno').val()
	student.userpass = $('#userpass').val()
	student.username = $('#username').val()
//	alert(student)
	console.log(student.userno)
	console.log(student.userpass)
	console.log(student.username)
	var stu = JSON.stringify(student)
		$.ajaxSetup({
		  contentType: "application/json; charset=utf-8"
		});
	$.post(url,stu,function(){alert("操作成功")})

}
function user_login(){

	var student = {}
	student.userno = $('#userno').val()
	student.userpass = $('#userpass').val()
	student.username = $('#username').val()
//	alert(student)
	console.log(student.userno)
	console.log(student.userpass)
	console.log(student.username)
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/OnlineExam/admin/student/login7.do",
//		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify(student),
		success : function(data) {

			 
			alert("操作成功")
			// console.log(JSON.stringify(saveDataAry))  
			console.log(data)
			window.location.href="http://www.jd.com"

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
			alert(textStatus);
			console.log(XMLHttpRequest.status)
			console.log(XMLHttpRequest.readyState)
			console.log(textStatus)
			console.log(errorThrown)
			alert("操作失败")
			alert(errorThrown)
			window.location.href="http://www.jd.com"
		}
	});
	
}


	
	
	$(document).ready(function(){
		
		$("#login_btn").click(user_login)
	})