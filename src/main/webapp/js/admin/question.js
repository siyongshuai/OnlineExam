
/**
 * 
 */
var DatagridOptions = {
	toolbar : '#question_tb',
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
		title : '试题id',
		width : 50,
		align : 'left',		
	}, {
		field : 'dbid',
		title : '所属题库',
		width : 100,
		hidden:true,
		align : 'left',
	
	}, {
		field : 'qtype',
		title : '试题类型',
		width : 100,
		hidden:true,
		align : 'center',
		
	}, {
		field : 'qlevel',
		title : '试题难度',
		width : 50,
		hidden:true,
		align : 'center',		
	}, {
		field : 'qfrom',
		title : '试题来源',
		width : 100,
		hidden:true,
		align : 'center',
		
	}, {
		field : 'status',
		title : '试题状态',
		width : 100,
		hidden : true,
		align : 'center',
		
	},

	{
		field : 'content',
		title : '题目',
		width : 100,
		align : 'center'
	}, {
		field : 'optiona',
		title : '选项A',
		width : 100,
		align : 'left',
		
	},
	// 其他未显示字段
	{
		field : 'optionb',
		title : '选项B',
		width : 100,
		align : 'left',
		
	},
	{
		field : 'optionc',
		title : '选项C',
		width : 100,
		align : 'left',
		
	},
	{
		field : 'optiond',
		title : '选项D',
		width : 100,
		align : 'left',
		
	},
	{
		field : 'skey',
		title : '正确答案',
		width : 100,
		align : 'left',
		
	},
	{
		field : 'postdate',
		title : '提交时间',
		width : 100,
		align : 'left',
		
	},
	{
		field : 'keydesc',
		title : '答案解析',
		width : 100,
		align : 'left',
		
	}

	] ]
}
// 函数部分

var moduleDatagrid = '#question_dg'
var moduleDialog = '#question_dlg'
var moduleForm = '#question_fm'
var moduleDialogButtons = '#question_dlg_buttons'
var moduleName = '/question/'

	

//以下是模块的独立的函数
//每个模块的查询都是不一样的
function beforeQuery(){
	$("#query_question_type").combobox({
	    url: urlPrefix + '/json/qtype.json',
	    valueField:'qtype',
	    textField:'remark'
	})
		$("#query_question_db").combobox({
	    url:urlPrefix + '/questiondb/get.do',
	    valueField:'id',
	    textField:'remark'
	})
}

function getQueryCondition() {
	var queryCondition = {}
//	函数体收尾两行不动，中间部分根据模块自定义
//	var query_qxyId = $("input[name='query_qxyId']").val()
//	console.log("query_qxyId -------" + query_qxyId)
//	var query_ptmc = $('#query_ptmc').val()
//	queryCondition.qxyId = query_qxyId
//	queryCondition.ptmc = query_ptmc
//	console.log(queryCondition)
	return queryCondition
}

//初始化表单外键
function initFormCombobox(){
	$("#question_fm_qtype").combobox({
	    url: urlPrefix + '/json/qtype.json',
	    valueField:'qtype',
	    textField:'remark'
	})
	$("#question_fm_qlevel").combobox({
	    url:urlPrefix + '/json/qlevel.json',
	    valueField:'qlevel',
	    textField:'remark'
	})
	$("#question_fm_qfrom").combobox({
	    url:urlPrefix + '/json/qfrom.json',
	    valueField:'qfrom',
	    textField:'remark'
	})
	$("#question_fm_status").combobox({
	    url:urlPrefix + '/json/status.json',
	    valueField:'status',
	    textField:'remark'
	})
// question 所属题库需要从数据库中取
	$("#question_fm_dbid").combobox({
	    url:urlPrefix + '/questiondb/get.do',
	    valueField:'id',
	    textField:'remark'
	})
}

//得到正确的json格式，主要是不能有主键id

function getFmJsonWithRightFormat(moduleForm){
	var fm = $(moduleForm)
	var fmJson = fm.serializeObject()
	console.log("保存之后的序列化")
	console.log(fmJson)
	if(formMethod == "add"){
	     delete fmJson['id']
		console.log("删除试题id属性"+fmJson)
		
	}
	return fmJson

}


//页面加载完成执行查询
$(function() {
	beforeQuery()
//	query(moduleDatagrid,moduleName)
	query(moduleDatagrid, moduleName, DatagridOptions)
})




