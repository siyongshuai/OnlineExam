<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<%@include file="/commons/csslibs.jspf"%>
<%@include file="/commons/jslibs.jspf"%>
<title>用户管理</title>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/admin/student.js"></script>
</head>

<body>


	<div id="mask" class="mask"></div>
	<div id="maskText" class="maskText" style="display: none;">正在转换，请稍等...</div>
	<div class="FormType">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<th scope="row">用户名</th>
					<td><input type="text" name="query_user_username"
						id="query_user_username" ></td>


					<th scope="row">学号</th>
					<td><input type="text" name="query_user_userno"
						id="query_user_userno" class="easyui-combobox"></td>

				</tr>
				<tr>
					<th scope="row">真实姓名</th>
					<td><input type="text" name="query_user_realname"
						id="query_user_realname"></td>


					<th scope="row">邮箱</th>
					<td><input type="text" name="query_user_email"
						id="query_user_email" class="easyui-combobox"></td>

				</tr>
				<tr>
					<td />
					<td />
					<td />
					<td><a href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-search'"
						onclick="query(moduleDatagrid,moduleName,DatagridOptions)">查询</a>&nbsp&nbsp
						<a href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-cancel'" onclick="reset()">重置</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div style="margin-top: 10px;">
		<table id="user_dg" style="height: 800px"></table>
		<div id="user_tb" class="datagrid-toolbar">
			<table>
				<tr>
					<td nowrap=true><a href="javascript:void(0)"
						class="easyui-linkbutton"
						data-options="iconCls:'icon-add',plain:true"
						onclick="newObjectForm(moduleDialog,moduleForm,moduleDialogButtons,moduleName)">新增</a>
					<td nowrap=true><a href="javascript:void(0)"
						class="easyui-linkbutton"
						data-options="iconCls:'icon-edit',plain:true"
						onclick="editObjectForm(moduleDatagrid,moduleDialog,moduleForm,moduleDialogButtons,moduleName)">编辑</a>
					</td>
					<td nowrap=true><a href="javascript:void(0)"
						class="easyui-linkbutton"
						data-options="iconCls:'icon-remove',plain:true"
						onclick="deleteObjects(moduleDatagrid,moduleName)">删除</a></td>
					<td><div class="datagrid-btn-separator"></div></td>
					<td nowrap=true><a href="javascript:void(0)"
						class="easyui-linkbutton"
						data-options="iconCls:'icon-search',plain:true"
						onclick="viewObjectForm(moduleDatagrid,moduleDialog,moduleDialogButtons,moduleForm)">
							查看详细信息</a></td>
				</tr>
			</table>
		</div>
	</div>
	<div id="user_dlg" class="easyui-dialog"
		style="width: 800px; height: 500px; padding: 10px 20px" closed="true"
		buttons="user_dlg_buttons">
		<div class="fti
		tle">试题信息</div>
		<form action="" id="user_fm" method="post" novalidate>
			<div class="FormType">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tbody>
				
						<tr>
							<th scope="row">学号</th>
							<td><input type="text" name="userno"
								class="easyui-validatebox" required="true"></td>
						</tr>
						<tr>
							<th scope="row">用户名</th>
							<td><input type="text" name="username"
								class="easyui-validatebox" required="true"></td>
						</tr>
						<tr>
							<th scope="row">密码</th>
							<td><input type="text" name="userpass"
								class="easyui-validatebox" required="true"></td>
						</tr>
						<tr>
							<th scope="row">照片</th>
							<td><input type="text" name="photo"
								class="easyui-validatebox" required="flase"></td>
						</tr>
						<tr>
							<th scope="row">状态</th>
							<td><input type="text" name="status"
								class="easyui-validatebox" required="true"></td>
						</tr>
						<tr>
							<th scope="row">注册时间</th>
							<td><textarea name="regdate" class="easyui-datetimebox"
									required="true"></textarea></td>
						</tr>
						<tr>
							<th scope="row">真实姓名</th>
							<td><input type="text" name="realname"
								class="easyui-validatebox">
						</tr>

						<tr>
							<th scope="备注">电子邮件</th>
							<td><input type="text" name="email"
								class="easyui-validatebox"></td>
						</tr>
						<tr>
							<th scope="备注">联系电话</th>
							<td><input type="text" name="mobi"
								class="easyui-validatebox"></td>
						</tr>
						<tr>
							<th scope="备注">备注</th>
							<td><input type="text" name="remark"
								class="easyui-validatebox"></td>
						</tr>
						<tr>
							<th scope="备注">用户组</th>
							<td><input type="text" name="gid" class="easyui-validatebox"></td>
						</tr>

						<tr>
							<th scope="备注">登陆次数</th>
							<td><input type="text" name="logintimes"
								class="easyui-validatebox"></td>
						</tr>
						<tr>
							<th scope="备注">最后登陆时间</th>
							<td><input type="text" name="lastlogin"
								class="easyui-datetimebox"></td>
						</tr>


					</tbody>

				</table>

				<!-- 隐藏域 -->
				<input type="text" style="display: none" name="id">
				

				<!-- 扩展区 -->
			</div>
		</form>
		<div id="user_dlg_buttons" style="display: block"
			class="dialog-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
				onclick="saveObjectForm(moduleForm,moduleDialog)">保存</a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-cancel"
				onclick="cancelOprateObejctForm(moduleDialog)">取消</a>
		</div>

	</div>
</body>

</html>
