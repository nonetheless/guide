<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="dao.StatusDAO" %>
<%@ page import="java.util.List" %>

<%List statusList = (List)request.getAttribute("statusList"); %>
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
				<h2>跟踪记录</h2>
				<ul class="breadcrumb">
					<li><a>风险列表</a></li>
					<li>跟踪记录</li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>时间</th><th>跟踪者</th><th>描述</th>
						</tr>
					</thead>
					
					<%if (statusList != null && !statusList.isEmpty()) {%>
						<tbody>						
						<% for(int i=0;i<statusList.size();i++) {
							StatusDAO item = (StatusDAO) statusList.get(i);%>
							<tr>
								<td><%= item.getCreateTime() %></td>
								<td><%= item.getFollowerId() %></td>
								<td><%= item.getDescription() %></td>
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

<script type="text/javascript">
</script>
</body>
</html>