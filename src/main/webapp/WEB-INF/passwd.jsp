<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,javax.servlet.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/commons/bootstrap2.jspf"%>
<title>密码修改</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/passwd.js"></script>

</head>
<body>
		<label for="username">原始密码</label>	
	<input type="text" id="username" name="username"
		class="form-control" value="${currentUser.userno }">
	<div class="container">
		<form method="post" action="password.do">
			<div class="form-group">
				<label for="oldpasswd">原始密码</label> <input type="password"
					id="oldpasswd" name="oldpasswd" class="form-control">
			</div>
			<div class="form-group">
				<label for="newpasswd">请输入新密码</label> <input type="password"
					id="newpasswd" name="newpasswd" class="form-control">
			</div>
			<div class="form-group">
				<label for="newpasswd2">确认新密码</label> <input type="password"
					id="newpasswd2" name="newpasswd2" class="form-control">
			</div>
			
			<p class="text-center"><input class="btn btn btn-danger " type="submit" id="confirm"  name="confirm" value="确认更改"></p>
	
		</form>
			<input type="text" id="currentPass" name="currentPass"
		class="form-control" value="${currentUser.userpass }">
	</div>

	<script type="text/javascript">
	var oldPasswdState 
	var newPasswdState
	$('input[name="oldpasswd"]').blur(function(){
		var currentPass = $('#currentPass').val()
		var oldpasswd = $('#oldpasswd').val()
		if(currentPass==oldpasswd){
		console.log("currentPass-------"+currentPass)
		console.log("oldPass-------"+oldpasswd)
		oldPasswdState = true
		console.log("oldPasswdState-------"+oldPasswdState)
		}
		else{
			oldPasswdState = false
			alert("输入的原始密码错误")
		}
	})
	$('input[name="newpasswd2"]').blur(function(){
		var newpasswd = $('#newpasswd').val()
		var newpasswd2 = $('#newpasswd2').val()
		if(newpasswd==newpasswd2){
		console.log("newpasswd-------"+newpasswd)
		console.log("newpasswd2-------"+newpasswd2)
		newPasswdState = true
		console.log("newPasswdState-------"+newPasswdState)
		}
		else{
			newPasswdState = false
			alert("两次输入的新密码不一样")
			
		}
	})
	$('input[name="confirm"]').submit(function(){
		if(oldPasswdState==true&&newPasswdState==true){
			return true
		}
		else{
			return false
		}
	})
	</script>
</body>
</html>