/**
 * 
 */

var DatagridOptions = {
	toolbar : '#user_tb',
	rownumbers : true,
	nowrap : false,
	striped : true,
	singleSelect : true,
	// fitColumns: true,
	pagination : true,
	// data 属性先不定义，在ajax请求成功后定义
	// data: [],
	columns : [ [ {
		field : 'id',
		title : '考试id',
		width : 100,
		align : 'left',
	}, {
		field : 'userno',
		title : '学号',
		width : 100,
		align : 'left',
		

	}, {
		field : 'username',
		title : '用户名',
		width : 100,
		align : 'center',
		
	}, {
		field : 'userpass',
		title : '用户密码',
		width : 200,
		align : 'center',
	},{
		field : 'realname',
		title : '真实姓名',
		width : 180,
		align : 'left',

	},
	{
		field : 'email',
		title : '邮箱',
		width : 180,
		align : 'left',

	},
	{
		field : 'photo',
		title : '照片',
		width : 200,
		align : 'center',

	}, {
		field : 'status',
		title : '用户状态',
		width : 200,
		hidden : true,
		align : 'center',

	},

	{
		field : 'regdate',
		title : '注册时间',
		width : 100,
		align : 'center'
	}, 
	// 其他未显示字段
	{
		field : 'mobi',
		title : '电话',
		width : 180,
		align : 'left',

	},
	{
		field : 'remark',
		title : '备注',
		width : 180,
		align : 'left',

	},
	{
		field : 'gid',
		title : '用户组',
		width : 180,
		align : 'left',

	},
	{
		field : 'logintimes',
		title : '登录次数',
		width : 180,
		align : 'left',

	},
	{
		field : 'lastlogin',
		title : '最后登陆时间',
		width : 180,
		align : 'left',

	},
	

	] ]
}
// 函数部分

var moduleDatagrid = '#user_dg'
var moduleDialog = '#user_dlg'
var moduleForm = '#user_fm'
var moduleDialogButtons = '#user_dlg_buttons'
// moduleName 主要是url
var moduleName = '/student/'

// 以下是模块的独立的函数
// 每个模块的查询都是不一样的
function beforeQuery() {

	// 初始化试卷下拉列表
	$("#query_user_username").combobox({
		url : urlPrefix + '/student/get.do',
		valueField : 'username',
		textField : 'username'
	})
	$("#query_user_userno").combobox({
		url : urlPrefix + '/student/get.do',
		valueField : 'userno',
		textField : 'userno'
	})
	$("#query_user_realname").combobox({
		url : urlPrefix + '/student/get.do',
		valueField : 'realname',
		textField : 'realname'
	})
	$("#query_user_email").combobox({
		url : urlPrefix + '/student/get.do',
		valueField : 'email',
		textField : 'email'
	})
}

function getQueryCondition() {

	var queryCondition = {}
	

	var username = $('input[name=query_user_username]').val()
	var userno = $('input[name=query_user_userno]').val()
	var realname = $('input[name=query_user_realname]').val()
	var email = $('input[name=query_user_email]').val()
	
	console.log("获取的username-----" + username)
	console.log("获取的userno-----" + userno)
	console.log("获取的realname ---------" + realname)
	console.log("获取的email---------" + email)
	queryCondition.username= username
	queryCondition.userno = userno
	queryCondition.realname =realname
	queryCondition.email=email
	

	console.log(queryCondition)
	return queryCondition;
}

// 初始化表单外键
function initFormCombobox() {

}

// 得到正确的json格式，主要是不能有主键id

function getFmJsonWithRightFormat(moduleForm) {
	var fm = $(moduleForm)
	var fmJson = fm.serializeObject()
	console.log("保存之后的序列化")
	console.log(fmJson)
	if (formMethod == "add") {
		delete fmJson['id']
		console.log("删除用户id属性" + fmJson)

	}
	return fmJson

}

// 页面加载完成执行查询
$(function() {
	beforeQuery()
	// query(moduleDatagrid,moduleName)
	query(moduleDatagrid, moduleName, DatagridOptions)
})
