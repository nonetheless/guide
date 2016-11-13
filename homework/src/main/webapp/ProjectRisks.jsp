<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目</title>
</head>
<body>
<div id="projectNames" style="float:left">
</div>
<div>
        <table id="riskTable" 
                class="main-table">
		  <thead>
            <tr>
              	<th data-field="content" >风险</th>
             	<th data-field="possiblity">可能性</th>
              	<th data-field="affect" >影响程度</th>
             	<th data-field="projectName" >项目名称</th>
            </tr>
          </thead>
        </table>
</div>
</body>
<script type="text/javascript" src="jquery-1.11.2.min.js" ></script> 
<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap-table/1.11.0/bootstrap-table.js" ></script>  
<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap-table/1.11.0/bootstrap-table.min.js" ></script>  
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap-table/1.11.0/bootstrap-table.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap-table/1.11.0/bootstrap-table.min.css">


<script type="text/javascript">
$(document).ready(function(){
	var names = [];
	names = <%=request.getAttribute("names")%>;
	for(var i=0;i<names.length;i++){
		$("#projectNames").append("<div><a onclick='getRisks("+names[i]+")'>"+names[i]+"</a></div>");
	}
});	
function getRisks(name){
	url="ProjectRisk?name="+name;
	$.get(url,function(r){
		$('#riskTable').bootstrapTable('load',r);
	});
}
</script>
</html>