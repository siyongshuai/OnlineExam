/**
 * 
 */
//表单操作只有一个公用的信号量
var formMethod
var url
var urlPrefix = 'http://localhost:8080/OnlineExam/admin';
//自定义jqeury 插件，将表单序列化成json
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}
function reset(){
	$("td input").val("");
}
function empty(){
	$("td input").val("");
}
function pagerFilter(data){
    if (typeof data.length == 'number' && typeof data.splice == 'function'){    // 判断数据是否是数组
        data = {
            total: data.length,
            rows: data
        }
    }
    var dg = $(this);
    var opts = dg.datagrid('options');
    var pager = dg.datagrid('getPager');
    pager.pagination({
//    	pageSize: 10,//每页显示的记录条数，默认为10 
        pageList: [5,10,15,20],//可以设置每页记录条数的列表 
//        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
        beforePageText: '第',//页数文本框前显示的汉字 
        afterPageText: '页    共 {pages} 页', 
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
        onSelectPage:function(pageNum, pageSize){
            
        	opts.pageNumber = pageNum;
            opts.pageSize = pageSize;
            pager.pagination('refresh',{
                pageNumber:pageNum,
                pageSize:pageSize
            });
            dg.datagrid('loadData',data);
        }
    });
    if (!data.originalRows){
        data.originalRows = (data.rows);
    }
    var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
    var end = start + parseInt(opts.pageSize);
    data.rows = (data.originalRows.slice(start, end));
    return data;
}


	
//直接删除记录
function deleteObjects(moduleDatagrid,moduleName) {
    var  dg = $(moduleDatagrid)
	var rows = dg.datagrid('getChecked');
    console.log(rows);
    
    if(rows.length == 0){   
    	$.messager.alert('提示', "请先勾上要删除的数据。", 'info');
	}
    else{
    	$.messager.confirm('提示', "是否确认删除？", function(r) {
    	      if (r) {
    	    	  $.each(rows, function(index, object) {
    	      		object = rows[index]
    	      		$.ajax({

    	      			url : urlPrefix + moduleName+'delete.do',
    	      			type : "POST",
    	      			data : JSON.stringify(object),
    	      			success : function(data) {
    	      				alert("删除成功");
    	      				query(moduleDatagrid, moduleName, DatagridOptions);
    	      			},
    	      			error : function() {
    	      				alert("删除失败");
    	      			},
    	      			dataType : "json",
    	      			contentType : "application/json;charset=UTF-8"
    	      		});
    	      		dg.datagrid('loaded');
    	      		dg.datagrid('reload');
    	      	})
    	    	  
    	    	  
    	      }
    	    });
    	
    	
    }

}

//增加表单

function newObjectForm(moduleDialog,moduleForm,moduleDialogButtons,moduleName){
	var dlg = $(moduleDialog)
	var fm = $(moduleForm)
	var dlg_buttons = $(moduleDialogButtons)
	dlg_buttons.attr('style','display : block')
	dlg.dialog('open').dialog('setTitle','新增记录')
	dlg.form('clear')
//	每个模块的form的外键初始化不一样，应该放在模块的js中
	initFormCombobox()
	url = urlPrefix + moduleName+'add.do'
	formMethod = "add"
}
//编辑表单

function editObjectForm(moduleDatagrid,moduleDialog,moduleForm,moduleDialogButtons,moduleName){
	var dg = $(moduleDatagrid)
	var dlg = $(moduleDialog)
	var fm = $(moduleForm)
	var dlg_buttons = $(moduleDialogButtons)
	var row = dg.datagrid('getSelected');
	console.log("获取到的行对象")
	console.log(row);
	if (row){
		
		dlg.dialog('open').dialog('setTitle','编辑记录');
		initFormCombobox()
		dlg_buttons.attr('style','display : block')
		fm.form('load',row);
		url = urlPrefix + moduleName+'update.do'
//		console.log("保存之前的序列化")
		var ptjson = fm.serializeObject()
//		console.log(ptjson)
//		console.log(url)
		formMethod ="update"
	}
	else{
		 $.messager.alert('提示', "请先单击选中要编辑的行", 'info');
	}
}

function saveObjectForm(moduleForm,moduleDialog){
	var fm = $(moduleForm)
	var dlg  =$(moduleDialog)
	if(formMethod == undefined){return}
	
	var fmJson = fm.serializeObject()
	console.log("保存之后的序列化")
	console.log(fmJson)
	if(formMethod == "add"){
//		调用正确的json格式,每个模块的json格式处理是不一样的
		fmJson = getFmJsonWithRightFormat(moduleForm)
		console.log("增加记录时正确的json形式---"+fmJson)
	}
	console.log(url)
	$.ajax({
		url : url,
		type : "POST",
		data : JSON.stringify(fmJson),
		dataType : "json",
		contentType : "application/json",
		success : function(data) {
			dlg.dialog('close')
			alert("数据提交成功")
//			操作成功或者失败都要清空清空全局信号量，以免其他模块用
			url = undefined
			formMethod = undefined
			
			
//			query(moduleDatagrid,moduleName);
			query(moduleDatagrid, moduleName, DatagridOptions)
		},
		error : function(data){
			alert("数据提交失败")
			//dlg.dialog('close')
			url = undefined
			formMethod = undefined
		}
		
	})
	$('#dg').datagrid('loaded');
	$('#dg').datagrid('reload');
	
	
}

function viewObjectForm(moduleDatagrid,moduleDialog,moduleDialogButtons,moduleForm){
	
	var dg = $(moduleDatagrid)
	var dlg = $(moduleDialog)
	var fm = $(moduleForm)
	var dlg_buttons = $(moduleDialogButtons)
	var row = dg.datagrid('getSelected');
	if (row){
		dlg.dialog('open').dialog('setTitle','查看详细信息');
			dlg_buttons.attr('style','display : none')
			initFormCombobox()
		fm.form('load',row);
	}
}

function cancelOprateObejctForm(moduleDialog){
	var dlg =$(moduleDialog)
	var fm = $(moduleForm)
	dlg.form('clear')
	dlg.dialog('close')
	url = undefined
	formMethod = undefined
	
//	清空信号量
}
function query(moduleDatagrid, moduleName, DatagridOptions) {
	var dg = $(moduleDatagrid)
	$.ajax({
		type : "post",
		url : urlPrefix + moduleName + 'query.do',
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify(getQueryCondition()),
		success : function(data) {
			dg.datagrid({
				loadFilter : pagerFilter
			}).datagrid('loadData', data);
			// DatagridOptions.data = []
			// options.data = data

			// dg.datagrid(options)
			DatagridOptions.data = data
			dg.datagrid(DatagridOptions)
		},
		error : function(data) {
			alert("查询数据失败")
		}
	})
}


