



function submit(){
	var userName= $('#username').val();
	var oldpwd =  $('#ysmm_passwd').val();
	var newpwd1 = $('#xmm1_passwd').val();
	var newpwd2 = $('#xmm2_passwd').val();
	console.log("获取密码111"+newpwd1);
	var st={"zhm":userName};
	
	
	var o={};
	 $.ajax({
		type : "post",
		url : urlPrefix+"/yh/query.do",
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify(st),
		success : function(data) {
			o=data;
			
			var psd=o[0].mm;
			console.log(psd);
			if(newpwd1!=newpwd2){alert("密码不一致");}
			else if(oldpwd!=psd){
				alert("原始密码输入错误");
			}
			else{
				editpw(newpwd1);
			}
		},
		error : function(data) {
			alert("获取当前密码失败")
		}
	})
	
	
}


function editpw(pwd){
	var userName= $('#username').val();
	var st={"zhm":userName,"mm":pwd};
	
	$.ajax({
		type : "post",
		url : urlPrefix+"/yh/updateMm.do",
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify(st),
		success : function(data) {
			alert("密码更改成功！");
			login();
			
		},
		error : function(data) {
			alert("更改密码失败")
		}
	})
	}
	function login(){
		window.top.location.href=urlPrefix+'/login.html';
	}