/**
 * 
 */

/**
 * 
 */
var DatagridOptions = {
	toolbar : '#viewOwnScore_tb',
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
		hidden:true,
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
		title : '试卷名称',
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
		hidden:true,
		align : 'center',		
	}, {
		field : 'edate',
		title : '结束时间',
		width : 200,
		hidden:true,
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

var moduleDatagrid = '#viewOwnScore_dg'
var moduleDialog = '#viewOwnScore_dlg'
var moduleForm = '#viewOwnScore_fm'
var moduleDialogButtons = '#viewOwnScore_dlg_buttons'
//moduleName 主要是url
var moduleName = '/score/'

	

//以下是模块的独立的函数
//每个模块的查询都是不一样的
function beforeQuery(){

//	初始化试卷下拉列表
	$("#query_viewOwnScore_pid").combobox({
	    url:urlPrefix + '/paper/get.do',
	    valueField:'id',
	    textField:'paperName'
	})
}

function getQueryCondition() {

	var queryCondition = {}
	var uid = $('input[id=query_viewOwnScore_uid]').val()
	var pid = $('input[name=query_viewOwnScore_pid]').val()
	var pid2= $("#query_viewOwnScore_pid").combobox('getValue')
	console.log("获取的uid-----"+uid)
	console.log("获取的pid---------"+pid)
	console.log("获取的pid2---------"+pid2)
	queryCondition.uid=uid
	queryCondition.pid=pid
	console.log(queryCondition)
	return queryCondition;
}

//初始化表单外键
function initFormCombobox(){
	
	}
	


//得到正确的json格式，主要是不能有主键id

function getFmJsonWithRightFormat(moduleForm){


}


//页面加载完成执行查询
$(function() {
	beforeQuery()
//	query(moduleDatagrid,moduleName)
	query(moduleDatagrid, moduleName, DatagridOptions)
})




