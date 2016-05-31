<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<%@include file="/commons/csslibs.jspf"%>
<%@include file="/commons/jslibs.jspf"%>
<title>试卷管理</title>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/admin/pd.js"></script>
</head>

<body>


	<div id="mask" class="mask"></div>
	<div id="maskText" class="maskText" style="display: none;">正在转换，请稍等...</div>
	<div class="FormType">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<th scope="row">试卷名称</th>
					<td><input type="text" name="query_pd_type"
						id="query_pd_type" class="easyui-combobox"></td>


					<th scope="row">所属题库</th>
					<td><input type="text" id="query_pd_db"></td>
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
		<table id="pd_dg" style="height: 800px"></table>
		<div id="pd_tb" class="datagrid-toolbar">
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
	<div id="pd_dlg" class="easyui-dialog"
		style="width: 500px; height: 300px; padding: 10px 20px" closed="true"
		buttons="pd_dlg_buttons">
		<div class="ftitle">试题信息</div>
		<form action="" id="pd_fm" method="post" novalidate>
			<div class="FormType">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<th scope="row">试卷名称</th>
							<td><input type="text" name="pid" id="pd_fm_paper"
								class="easyui-combobox" required="true"></td>
						</tr>
						<tr>
							<th scope="row">试题类型</th>
							<td><input type="text" name="qtype" class="easyui-combobox"
								id="pd_fm_qtype" required="true"></td>
						</tr>
						<tr>
							<th scope="row">所属题库</th>
							<td><input type="text" name="questiondb" id="pd_fm_questiondb"
								class="easyui-combobox" required="true"></td>
						</tr>
						<tr>
							<th scope="row">试题数量</th>
							<td><input type="text" name="num"
								class="easyui-validatebox" required="true"></td>
						</tr>

						<tr>
							<th scope="row">每题分值</th>
							<td><input type="text" name="perScore"
								class="easyui-validatebox" required="true"></td>
						</tr>
					</tbody>

				</table>

				<!-- 隐藏域 -->
				
				<!-- 获取提交时的日期 -->

				<!-- 扩展区 -->
			</div>
		</form>
		<div id="pd_dlg_buttons" style="display: block"
			class="dialog-button">
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
				onclick="saveObjectForm(moduleForm,moduleDialog)">保存</a> <a href="#"
				class="easyui-linkbutton" iconCls="icon-cancel"
				onclick="cancelOprateObejctForm(moduleDialog)">取消</a>
		</div>

	</div>
</body>

</html>
