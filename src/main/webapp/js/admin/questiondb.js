
/**
 * 
 */
var DatagridOptions = {
	toolbar : '#questiondb_tb',
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
		title : '题库id',
		width : 50,
		align : 'left',		
	}, {
		field : 'dname',
		title : '题库名称',
		width : 100,
		align : 'left',
	
	}, {
		field : 'remark',
		title : '备注',
		width : 100,
		hidden:true,
		align : 'left',
		
	}, {
		field : 'qlevel',
		title : '试题难度',
		width : 50,
		hidden:true,
		align : 'center',		
	}, {
		field : 'adminid',
		title : '管理员',
		width : 100,
		hidden:true,
		align : 'center',
		
	},{
		field : 'cdate',
		title : '创建时间',
		width : 100,
		hidden:true,
		align : 'center'
	}, 
	
	{
		field : 'status',
		title : '试题状态',
		width : 100,
		hidden : true,
		align : 'center',
		
	}
	] ]
}
// 函数部分

var moduleDatagrid = '#questiondb_dg'
var moduleDialog = '#questiondb_dlg'
var moduleForm = '#questiondb_fm'
var moduleDialogButtons = '#questiondb_dlg_buttons'
var moduleName = '/questiondb/'

	

//以下是模块的独立的函数
//每个模块的查询都是不一样的
function beforeQuery(){

		$("#query_questiondb_dname").combobox({
	    url:urlPrefix + '/questiondb/get.do',
	    valueField:'dname',
	    textField:'dname'
	})
}

function getQueryCondition() {
	var queryCondition = {}
	var dname = $('input[name=query_questiondb_dname]').val()
	queryCondition.dname = dname
	console.log("获取的dname----"+dname)
	return queryCondition
}

//初始化表单外键
function initFormCombobox(){
}

//得到正确的json格式，主要是不能有主键id

function getFmJsonWithRightFormat(moduleForm){
	var fm = $(moduleForm)
	var fmJson = fm.serializeObject()
	console.log("保存之后的序列化")
	console.log(fmJson)
	if(formMethod == "add"){
	     delete fmJson['id']
		console.log("删除题库id属性"+fmJson)
		
	}
	return fmJson

}


//页面加载完成执行查询
$(function() {
	beforeQuery()
//	query(moduleDatagrid,moduleName)
	query(moduleDatagrid, moduleName, DatagridOptions)
})




