/**
 * 
 */


	$('#ff').form('submit',{
		url:urlPrefix+"/question/add.do",
		success:function(data){
			$.messager.alert('Info', data, 'info');
		}
	});