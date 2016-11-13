<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>风险管理系统</title>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>新增风险</h2>
				<ul class="breadcrumb">
					<li><a>风险列表</a></li>
					<li>新增风险</li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<form class="form-horizontal" id="riskForm">
				  <div class="form-group">
				    <label for="projectNameInput" class="col-sm-2 control-label">项目名称</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="projectNameInput" name="projectName" placeholder="项目名称">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="riskContentInput" class="col-sm-2 control-label">风险描述</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="riskContentInput" name="riskContent" placeholder="风险描述">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="riskTriggerInput" class="col-sm-2 control-label">阈值</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="riskTriggerInput" name="riskTrigger" placeholder="阈值">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="riskPosSel" class="col-sm-2 control-label">可能性</label>
				    <div class="col-sm-10">
				      <select class="form-control" id="riskPosSel" name="riskPos">
				      	<option value="high">高</option>
				      	<option value="middle">中</option>
				      	<option value="low">低</option>
				      </select>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="riskPosSel" class="col-sm-2 control-label">影响程度</label>
				    <div class="col-sm-10">
				      <select class="form-control" id="riskAffectSel" name="riskAffect">
				      	<option value="high">高</option>
				      	<option value="middle">中</option>
				      	<option value="low">低</option>
				      </select>
				    </div>
				  </div>
				</form>
				<div class="col-sm-2"></div>
				<div class="col-sm-10" style="padding-left:5px">
				  <button class="btn btn-default" onclick="javascript:submit()">保存</button>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>

<script type="text/javascript">

function submit(){
	if($("#projectNameInput").val() == '') {
		alert("请输入项目名称");
		return;
	}
	if($("#riskContentInput").val() == '') {
		alert("请输入风险描述");
		return;
	}
	if($("#riskTriggerInput").val() == '') {
		alert("请输入阈值");
		return;
	}else{
        var result = /^[0-9]+$/.test($("#riskTriggerInput").val());
        if(!result){
        	alert("阈值为数字");
        	return;
        }
	}
	$.post("RiskAdd", $("#riskForm").serialize(), function(r){
		if(r == 'success'){
			window.location = "#";
		}else{
			alert("添加失败");
		}
	});
}

</script>
</body>
</html>