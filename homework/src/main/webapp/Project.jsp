<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
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
<div id="projectNames" style="float:left">
<%if (names != null && !names.isEmpty()) {%>
<%for(int i=0;i<names.size();i++){ 
String name=(String)names.get(i);%>
<div><a href="ProjectRisk?name=<%=name%>"><%=name %></a></div>
<%} %>
<%} %>
</div>

<script type="text/javascript">
</script>

</body>
</html>