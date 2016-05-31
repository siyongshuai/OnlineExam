
var DatagridOptions = {
	toolbar : '#pd_tb',
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
		title : '试卷详情id',
		width : 100,
		hidden:true,
		align : 'left',		
	}, {
		field : 'pid',
		title : '试卷名称',
		width : 100,
		align : 'left',
	
	},{
		field : 'cid',
		title : '试题类型',
		width : 100,
		align : 'left',
	
	},  
	{
		field : 'qid',
		title : '问题id',
		width : 200,
		hidden:true,
		align : 'center',
		
	}, {
		field : 'score',
		title : '分数',
		hidden:true,
		width : 200,
		align : 'center',		
	}, {
		field : 'orderid',
		title : '排序规则',
		width : 200,
		hidden:true,
		align : 'center',
		
	}

	] ]
}
// 函数部分

var moduleDatagrid = '#pd_dg'
var moduleDialog = '#pd_dlg'
var moduleForm = '#pd_fm'
var moduleDialogButtons = '#pd_dlg_buttons'
var moduleName = '/pd/'

	

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
//所属试卷
	$('#pd_fm_paper').combobox({
	    url:urlPrefix + '/paper/get.do',
	    valueField:'id',
	    textField:'paperName'
	});
//试题类型
	$('#pd_fm_qtype').combobox({
	    url:urlPrefix + '/json/qtype.json',
	    valueField:'qtype',
	    textField:'remark'
	});
	
//	所属题库
	$('#pd_fm_questiondb').combobox({
	    url:urlPrefix + '/questiondb/get.do',
	    valueField:'id',
	    textField:'dname'
	});
	
}

//得到正确的json格式，主要是不能有主键id

function getFmJsonWithRightFormat(moduleForm){
	var fm = $(moduleForm)
	var fmJson = fm.serializeObject()
	return fmJson

}


//页面加载完成执行查询
$(function() {
	beforeQuery()
//	query(moduleDatagrid,moduleName)
	query(moduleDatagrid, moduleName, DatagridOptions)
})




