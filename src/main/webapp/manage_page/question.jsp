<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<%@include file="/commons/csslibs.jspf"%>
<%@include file="/commons/jslibs.jspf"%>
<title>题库管理</title>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/manage_js/question.js"></script>
</head>

<body>


	<div id="mask" class="mask"></div>
	<div id="maskText" class="maskText" style="display: none;">正在转换，请稍等...</div>
	<div class="FormType">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<th scope="row">试题类型</th>
					<td><input type="text" name="query_question_type"
						id="query_question_type" class="easyui-combobox"></td>


					<th scope="row">所属题库</th>
					<td><input type="text" id="query_question_db"></td>
					</td>
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
		<table id="question_dg" style="height: 800px"></table>
		<div id="question_tb" class="datagrid-toolbar">
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
	<div id="question_dlg" class="easyui-dialog"
		style="width: 800px; height: 500px; padding: 10px 20px" closed="true"
		buttons="question_dlg_buttons">
		<div class="ftitle">试题信息</div>
		<form action="" id="question_fm" method="post" novalidate>
			<div class="FormType">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<th scope="row">试题类型</th>
							<td><input type="text" name="qtype" id="question_fm_qtype"
								class="easyui-combobox " required="true"></td>
						</tr>
						<tr>
							<th scope="row">所属题库</th>
							<td><input type="text" name="dbid" id="question_fm_dbid"
								class="easyui-combobox" required="true"></td>
						</tr>
						<tr>
							<th scope="row">试题难度</th>
							<td><input type="text" name="qlevel" id="question_fm_qlevel"
								class="easyui-combobox" required="true"></td>
						</tr>
						<tr>
							<th scope="row">试题来源</th>
							<td><input type="text" name="qfrom" id="question_fm_qfrom"
								class="easyui-combobox" required="true"></td>
						</tr>
						<tr>
							<th scope="row">试题状态</th>
							<td><input type="text" name="status" id="question_fm_status"
								class="easyui-combobox" required="true"></td>
						</tr>
						<tr>
							<th scope="row">题干内容</th>
							<td><textarea name="content" class="textarea"
									required="true"></textarea></td>
						</tr>
						<tr>
							<th scope="row">选项A</th>
							<td><input type="text" name="optiona"
								class="input_full"></td>
						</tr>
						<tr>
							<th scope="row">选项B</th>
							<td><input type="text" name="optionb"
								class="input_full"></td>
						</tr>
						<tr>
							<th scope="row">选项C</th>
							<td><input type="text" name="optionc"
								class="input_full"></td>
						</tr>
						<tr>
							<th scope="row">选项D</th>
							<td><input type="text" name="optiond"
								class="input_full"></td>
						</tr>
						<tr>
							<th scope="row">正确答案</th>
							<td><input type="text" name="skey"
								class="easyui-validatebox" ></td>
						</tr>
						<tr>
							<th scope="row">答案解析</th>
							<td><textarea name="keydesc" class="textarea"
									required="true"></textarea></td>
						</tr>

					</tbody>

				</table>

				<!-- 隐藏域 -->
				<input type="text" style="display: none" name="id">
				<!-- 获取提交时的日期 -->
				
				<!-- 扩展区 -->
			</div>
		</form>
		<div id="question_dlg_buttons" style="display: block" class="dialog-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
				onclick="saveObjectForm(moduleForm,moduleDialog)">保存</a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-cancel"
				onclick="cancelOprateObejctForm(moduleDialog)">取消</a>
		</div>

	</div>
</body>

</html>
