/**
 * 
 */
var baseUrl = "http://localhost:8080/OnlineExam"
function endExam() {
	var examlist = [];
	$("input:radio:checked").each(function(index, domEle) {
		// console.log($(domEle).val())

		var examdetail = {}
		examdetail.userAnswer = $(domEle).val()
		examdetail.uid = 1
		examdetail.pid = 1
		examdetail.qid = $(domEle).attr("name")
		examdetail.qtype = 1
		console.log(examdetail)
		examlist.push(examdetail);

	})

	console.log(examlist)
	$.ajax({
		type : "POST",
		url : baseUrl + "/manage_page/ed/many.do",
		dataType : "json",
		contentType : "application/json;charset=UTF-8",
		data : JSON.stringify(examlist),
		success : function(data) {

			alert("操作成功")
			// console.log(JSON.stringify(saveDataAry))  

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log(XMLHttpRequest.status);
			console.log(XMLHttpRequest.readyState);
			console.log(textStatus);
			console.log("操作失败")
		}
	});
	
}


function getNowFormatDate() {
	    var date = new Date();
	    var seperator1 = "-";
	    var seperator2 = ":";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate();
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
	            + " " + date.getHours() + seperator2 + date.getMinutes()+120
	            + seperator2 + date.getSeconds();
	console.log(currentdate)
	    return currentdate;
	}
function submit(){
	
}

$(document).ready(function() {
//	$("#endExamBtn").click(function() {
//		alert("Hello World  click");
//	})
	
	$("#endExamBtn").click(endExam)

//	   $('#clock').countdown('2016/6/15', function(event) {
//		     $(this).html(event.strftime('%H:%M:%S'));
//		   });
	
	 var twoHours = new Date().getTime() + 2*60*60*1000;

	  
	$('#clock').countdown(twoHours)
	.on('update.countdown',function(event){
		var $this = $(this);
		$this.html(event.strftime('距离结束:'
		+ '<span>%H</span> 小时 '
	    + '<span>%M</span> 分'
	    + '<span>%S</span> 秒'))
	})
	.on('finish.countdown',function(event){
		$(this).html('作答时间已到!')
		.parent().addClass('disabled');

	})

	 
	
})