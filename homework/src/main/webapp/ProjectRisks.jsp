<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="dao.RiskDAO" %>
 <%@ page import="java.util.List" %>
 <%List riskList = (List)request.getAttribute("riskList"); %>
 <%List names = (List)request.getAttribute("names"); %>
 
 
 
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<title>风险管理系统</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>项目列表</h2>
				<ul class="breadcrumb">
					<li><a>项目列表</a></li>
					<li>风险记录</li>
				</ul>
			</div>
		</div>
	<div id="projectNames">
		<div class="collapse navbar-collapse" id="example-navbar-collapse">
		<ul class="nav navbar-nav">
		<li>项目</li>
			<%if (names != null && !names.isEmpty()) {%>
	<%for(int i=0;i<names.size();i++){ 
	String name=(String)names.get(i);%>
	<li><a href="ProjectRisk?name=<%=name%>"><%=name %></a></li>
	<%} %>
	<%} %>
	<li><a href="RiskAdd"><增加项目></a></li>
		</ul>
	</div>
	</div>

		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<table id="riskTable" class="table table-striped">
					<thead>
						<tr>
							<th>风险内容</th><th>可能性</th><th>影响程度</th><th>触发器/阈值</th><th>创建时间</th><th>终止时间</th><th>查看</th>
						</tr>
					</thead>
					
					<%if (riskList != null && !riskList.isEmpty()) {%>
						<tbody>						
						<% for(int i=0;i<riskList.size();i++) {
							RiskDAO item = (RiskDAO) riskList.get(i);%>
							<tr index=<%= item.getId() %>">
								<td><%= item.getContent() %></td>
								<td><%= item.getPossiblity() %></td>
								<td><%= item.getAffect() %></td>
								<td><%= item.getThreshold() %></td>
								<td><%= item.getCreateTime() %></td>
								<td><%= item.getEndTime() %></td>
								<td><%= item.getIsEnded() %></td>
								<td><a href="RiskStatus?riskId=<%=item.getId()%>">详情</a></td>
							</tr>
						<%} %>
						</tbody>
					<%}else{ %>
						<tr>
							<td>没有匹配的数据</td><td></td><td></td>
						</tr>
					<%} %>
				</table>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>


</html>