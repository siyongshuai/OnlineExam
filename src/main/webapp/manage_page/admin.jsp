<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@include file="/commons/csslibs.jspf"%>
<%@include file="/commons/jslibs.jspf"%>
<title>管理员信息管理</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/managepage_js/common2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/managepage_js/admin.js"></script>
</head>
<div>
	<div class="FormType">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<th scope="row">账户名</th>
					<td><input type="text" id="query_yhmc"></td>
					<th scope="row">身份</th>
					<td><select id="query_yhsf">
							<option value="">全部身份</option>
							<option value="管理员">管理员</option>
							<option value="普通用户">普通用户</option>
					</select>
					</td>
				</tr>
				<tr>
					<th />
					<td />
					<th />
					<td><a href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-search'"
						onclick="query(moduleDatagrid, moduleName, DatagridOptions)">查询</a>
						<a href="#" class="easyui-linkbutton"
						data-options="iconCls:'icon-cancel'" onclick="reset()">重置</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div style="margin-top:10px;">
		<table id="admin_dg" style="height: 405px"></table>
		<div id="admin_tb" class="datagrid-toolbar">
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
</div>


<div id="admin_dlg" class="easyui-dialog"
	style="width: 800px; height: 500px; padding: 10px 20px" closed="true"
	buttons="#dlg-buttons">
	<div class="ftitle">管理员信息管理</div>
	<form action="" id="admin_fm" method="post" novalidate>
		<div class="FormType">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<th scope="row">用户名</th>
						<td><input type="text" name="zhm" id="admin_fm_zhm"
							class="easyui-validatebox" required="true"></td>
					</tr>
					<tr>
						<th scope="row">身份</th>
						<td><select name="sf" id="admin_fm_sf"
							class="easyui-combobox" required="true">
								<option value="管理员">管理员</option>
								<option value="普通用户">普通用户</option>
						</select>
						</td>
					</tr>
					<tr>
						<th scope="row">密码</th>
						<td><input type="text" name="mm" id="admin_fm_mm"
							class="easyui-validatebox" required="true"></td>
					</tr>

				</tbody>
			</table>


			<!-- 隐藏区 -->
			<input type="number" style="display: none" name="yhId"
				id="admin_fm_yhId">
	</form>
	
</div>
<div id="admin-dlg-buttons" style="display: block"
		class="dialog-button">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="saveObjectForm(moduleForm,moduleDialog)">保存</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-cancel"
			onclick="javascript:$('#admin_dlg').dialog('close')">取消</a>
	</div>
</div>