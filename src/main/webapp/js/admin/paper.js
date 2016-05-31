/**
 * 
 */


/**
 * 
 */
var DatagridOptions = {
	toolbar : '#paper_tb',
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
		title : '试卷id',
		width : 100,
		hidden:true,
		align : 'left',		
	}, {
		field : 'paperName',
		title : '试卷名称',
		width : 100,
		
		align : 'left',
	
	}, {
		field : 'status',
		title : '试卷状态',
		width : 200,
		hidden:true,
		align : 'center',
		
	}, {
		field : 'starttime',
		title : '开始时间',
		width : 200,
		hidden:true,
		align : 'center',		
	}, {
		field : 'endtime',
		title : '结束时间',
		width : 200,
		hidden:true,
		align : 'center',
		
	}, {
		field : 'paperMinute',
		title : '试卷时长',
		width : 100,
		hidden : true,
		align : 'center',
		
	},

	{
		field : 'totalScore',
		title : '试卷总分',
		width : 100,
		align : 'center'
	}, {
		field : 'remark',
		title : '备注',
		width : 180,
		align : 'left',
		
	},
	// 其他未显示字段
	{
		field : 'qorder',
		title : '排序',
		width : 180,
		hidden:true,
		align : 'left',
		
	},
	{
		field : 'postdate',
		title : '提交时间',
		width : 180,
		align : 'left',
		
	},
	{
		field : 'showScore',
		title : '显示分数',
		width : 180,
		hidden:true,
		align : 'left',
		
	}

	] ]
}
// 函数部分

var moduleDatagrid = '#paper_dg'
var moduleDialog = '#paper_dlg'
var moduleForm = '#paper_fm'
var moduleDialogButtons = '#paper_dlg_buttons'
var moduleName = '/paper/'

	

//以下是模块的独立的函数
//每个模块的查询都是不一样的
function beforeQuery(){
	
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
	$('#paper_fm_status').combobox({
	    url:urlPrefix + '/json/status.json',
	    valueField:'status',
	    textField:'remark'
	});
	
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




