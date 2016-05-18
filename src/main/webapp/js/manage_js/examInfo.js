
var DatagridOptions = {
	toolbar : '#examInfo_tb',
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
		field : 'uid',
		title : '用户id',
		width : 100,
		align : 'left',
		formatter: function(value,row,index){
			if (row.user){
				return row.user.username;
			} else {
				return value;
			}
		}
	
	}, {
		field : 'pid',
		title : '试卷id',
		width : 200,
		align : 'center',
		formatter: function(value,row,index){
			if (row.user){
				return row.paper.paperName;
			} else {
				return value;
			}
		}
		
	}, {
		field : 'sdate',
		title : '开始时间',
		width : 200,
		align : 'center',		
	}, {
		field : 'edate',
		title : '结束时间',
		width : 200,
		align : 'center',
		
	}, {
		field : 'ip',
		title : '试题状态',
		width : 200,
		hidden : true,
		align : 'center',
		
	},

	{
		field : 'score',
		title : '分数',
		width : 100,
		align : 'center'
	}, {
		field : 'status',
		title : '试卷状态',
		width : 180,
		align : 'left',
		
	},
	// 其他未显示字段
	{
		field : 'remark',
		title : '备注',
		width : 180,
		align : 'left',
		
	}

	] ]
}
// 函数部分

var moduleDatagrid = '#examInfo_dg'
var moduleDialog = '#examInfo_dlg'
var moduleForm = '#examInfo_fm'
var moduleDialogButtons = '#examInfo_dlg_buttons'
//moduleName 主要是url
var moduleName = '/ei/'

	

//以下是模块的独立的函数
//每个模块的查询都是不一样的
function beforeQuery(){

//	初始化试卷下拉列表
	$("#query_examInfo_username").combobox({
	    url:urlPrefix + '/student/get.do',
	    valueField:'username',
	    textField:'username'
	})
		$("#query_examInfo_paperName").combobox({
	    url:urlPrefix + '/paper/get.do',
	    valueField:'paperName',
	    textField:'paperName'
	})
}

function getQueryCondition() {

	var queryCondition = {}
	var user = {}
	var paper ={}
	var username = $('input[name=query_examInfo_username]').val()
	var username2 = $('input[id=query_examInfo_username]').val()
	var paperName = $('input[name=query_examInfo_paperName]').val()
	var paperName2 = $("#query_examInfo_paperName").combobox('getValue')
	console.log("获取的username-----"+username)
	console.log("获取的username2-----"+username2)
	console.log("获取的paperName ---------"+paperName )
	console.log("获取的paperName2---------"+paperName2)
	user.username= username
	paper.paperName = paperName
	queryCondition.user = user
	queryCondition.paper = paper

	console.log(queryCondition)
	return queryCondition;
}

//初始化表单外键
function initFormCombobox(){
	$("#examInfo_fm_uid").combobox({
	    url:urlPrefix + '/student/get.do',
	    valueField:'id',
	    textField:'username'
	})
	
		$("#examInfo_fm_pid").combobox({
	    url:urlPrefix + '/paper/get.do',
	    valueField:'id',
	    textField:'paperName'
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
	     
		console.log("删除考试id属性"+fmJson)
		
	}
	return fmJson

}


//页面加载完成执行查询
$(function() {
	beforeQuery()
//	query(moduleDatagrid,moduleName)
	query(moduleDatagrid, moduleName, DatagridOptions)
})




