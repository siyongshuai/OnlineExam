<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<%@include file="/commons/csslibs.jspf"%>
<%@include file="/commons/jslibs.jspf"%>

<title>查看个人成绩</title>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/admin/examDetail.js"></script>
</head>

<body>


	<div id="mask" class="mask"></div>
	<div id="maskText" class="maskText" style="display: none;">正在转换，请稍等...</div>
	<div class="FormType">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<th scope="row">用户名</th>
					<td><input type="text" name="query_examInfo_username"
						id="query_examInfo_username" value="${currentUser.id }"></td>


					<th scope="row">试卷名</th>
					<td><input type="text" name="query_examInfo_paperName"
						id="query_examInfo_paperName" class="easyui-combobox"></td>

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
		<table id="examInfo_dg" style="height: 800px"></table>
		<div id="examInfo_tb" class="datagrid-toolbar">
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
	<div id="examInfo_dlg" class="easyui-dialog"
		style="width: 800px; height: 500px; padding: 10px 20px" closed="true"
		buttons="examInfo_dlg_buttons">
		<div class="fti
		tle">考试信息</div>
		<form action="" id="examInfo_fm" method="post" novalidate>
			<div class="FormType">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tbody>					
						<tr>
							<th scope="row">用户名</th>
							<td><input type="text" name="uid" id="examInfo_fm_uid"
								class="easyui-combobox" ></td>
						</tr>
						<tr>
							<th scope="row">试卷</th>
							<td><input type="text" name="pid" id="examInfo_fm_pid"
								class="easyui-combobox" ></td>
						</tr>
						<tr>
							<th scope="row">开始时间</th>
							<td><input type="text" name="sdate"
								class="easyui-datetimebox" ></td>
						</tr>
						<tr>
							<th scope="row">结束时间</th>
							<td><input type="text" name="edate"
								class="easyui-datetimebox" ></td>
						</tr>
						<tr>
							<th scope="row">ip</th>
							<td><input type="text" name="ip" class="easyui-validatebox"
								required="true"></td>
						</tr>
						<tr>
							<th scope="row">成绩</th>
							<td><textarea name="score" class="easyui-validatebox"
									required="true"></textarea></td>
						</tr>
						<tr>
							<th scope="row">状态</th>
							<td><input type="text" name="status"
								class="easyui-validatebox"></td>
						</tr>
						<tr>
							<th scope="备注">remark</th>
							<td><input type="text" name="remark" class="input_full"></td>
						</tr>


					</tbody>

				</table>

				<!-- 隐藏域 -->
				<input type="text" style="display: none" name="id">
				<!-- 获取提交时的日期 -->

				<!-- 扩展区 -->
			</div>
		</form>
		<div id="examInfo_dlg_buttons" style="display: block" class="dialog-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
				onclick="saveObjectForm(moduleForm,moduleDialog)">保存</a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-cancel"
				onclick="cancelOprateObejctForm(moduleDialog)">取消</a>
		</div>

	</div>
</body>

</html>
