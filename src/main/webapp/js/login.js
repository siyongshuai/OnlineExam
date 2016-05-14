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
	console.log(student)
	
	$.ajax({
		type : "POST",
		url : baseUrl + "/front_page/student/login.do",
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
$(function(){
	
	$("#login_btn").click(user_login)
})