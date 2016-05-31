<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,javax.servlet.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
<%@include file="/commons/csslibs.jspf"%>
<%@include file="/commons/jslibs.jspf"%>
<title>学生用户首页</title>

<style type="text/css">

</style>
</head>

<body>
	<div id="layoutID" class="easyui-layout" style="width: 600px"
		data-options="fit:true">

		<!-- 北 -->
		<div data-options="region:'north'"
			style="height: 100px; background-color: #355EBA">
			<input type="text" id="username" hidden="true" value="">
			<div id="logo" style="width: 350px"></div>
			<div
				style="margin-left: 400; font-size: 20px; line-height: 50px; color: #fff;">
				学生在线考试系统
				<div
					style="font-size: 10px; float: right; width: 100px; color: #fff">
					<a href="#" onclick="addTab('用户密码修改',testUrl+'/student/password.do')"
						style="text-decoration: none; color: #fff">【修改密码】</a>
				</div>
				<div
					style="font-size: 10px; float: right; width: 100px; color: #fff">
					<a href="#" onclick="logout()"
						style="text-decoration: none; color: #fff">【安全退出】</a>
				</div>
				<div
					style="font-size: 10px; float: right; width: 200px; text-align: right; color: #fff">
					<span>欢迎您${currentUser.username}：&nbsp;&nbsp;</span>
					<span>欢迎您${currentUser.id}：&nbsp;&nbsp;</span>
				</div>
			</div>

		</div>


		<!-- 西 -->
		<div data-options="region:'west',split:true," style="width: 200px;">
			<div id="accordionID" class="easyui-accordion"
				data-options="fit:true,border:false,">
				<div title="学生模块">
					<ul>
						<li><a onclick="addTab('在线考试',testUrl+'/paper/select.do')">
								<span>在线考试</span>
						</a></li>
						<li><a onclick="addTab('查看成绩',testUrl+'/score/viewScore.do')">
								<span>查看成绩</span>
						</a></li>
						<li><a
							onclick="addTab('查看个人信息',testUrl+'/student/info.do')"> <span>查看个人信息</span>
						</a></li>
						<li><a onclick="addTab('修改密码',testUrl+'/student/password.do')">
								<span>修改密码</span>
						</a></li>

					</ul>
				</div>
			</div>

		</div>

		<!-- 中-->
		<div data-options="region:'center',border:false,plain:true"
			style="padding-top: 5px; background: #fff;">
			<div id="tabsID" class="easyui-tabs"
				data-options="border:false,plain:true"
				style="padding: 5px; background: #fff; height: 520px;"></div>
			<!-- 			<ul id="tt" style="height: 520px;" ></ul> -->
		</div>



		<!-- 		右键菜单 -->
		<div id="mm" class="easyui-menu" style="width: 120px">
			<div id="close" data-options="name:'close',iconCls:'icon-remove'"
				onclick="removePanel()">关闭</div>
			<div id="closeall"
				data-options="name:'closeall',iconCls:'icon-remove'"
				onclick="closeall()">关闭所有</div>
			<div id="cancel" data-options="name:'cancel',iconCls:'icon-cancel'"
				onclick="exit()">取消</div>
		</div>
		<!-- 底部信息 -->
				<div data-options="region:'south'"
			style="height: 25px; background-color: #D3D8F8">
			<table
				style="font-family: Verdana, Arial; text-align: center; padding-left: 100px">
				<tr>
					<td style="width: 33%">河南工程学院在线考试系统</td>
					<td style="width: 45%">CopyRight© 吴婷</td>
					<td style="padding-left: 80px">联系方式:17051063263</td>
				</tr>
			</table>

		</div>

	</div>

	<script>
		var baseUrl = 'http://localhost:8080/OnlineExam'
		var testUrl = 'http://localhost:8080/OnlineExam/admin'
		function addTab(title, url) {
			if ($('#tabsID').tabs('exists', title)) {
				$('#tabsID').tabs('select', title);
			} else {
				var content = '<iframe scrolling="auto" frameborder="0"  src="'
						+ url + '" style="width:100%;height:100%;"></iframe>';
				$('#tabsID').tabs('add', {
					title : title,
					content : content,
					closable : true
				});
			}
		}

		function logout() {
			$
					.ajax({
						type : "get",
						url : baseUrl+"/student/logout.do",
						contentType : "application/json;charset=UTF-8",
						success : function() {
							alert("安全退出成功！");
							window.location.href = baseUrl+"/student/login.do";
						}
					})
		}
	</script>

	<script type="text/javascript">
		
			$(".easyui-tabs li").each(function(index, obj) {
				//获取所有可关闭的选项卡
				var tab = $(".tabs-closable", this).text();
				$(".easyui-tabs").tabs('close', tab);
			});

		

		function removePanel() {
			var tab = $('#tabsID').tabs('getSelected');
			if (tab) {
				var index = $('#tabsID').tabs('getTabIndex', tab);
				$('#tabsID').tabs('close', index);
			}
		}
		function exit() {
			$('#mm').menu('hide');
		}
		$(function() {
			$('#tabsID').bind('contextmenu', function(e) {
				e.preventDefault();
				$('#mm').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			});
		});
	</script>

</body>
</html>
