<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form class="form-horizontal" action="LoginServlet" method="post" style="width:500px;height:300px;padding-top:50px;padding-left:300px;">
		<span class="heading">用户登录</span>
		<div class="form-group" style="padding-top:20px">
		<input class="form-control" type="text" name="user" placeholder="用户名">
		<i class="fa fa-user"></i>
		</div>
		<div class="form-group">		
		<input class="form-control" type="password" name="password" placeholder="密码">
		<i class="fa fa-user"></i>
		</div>
		<input class="btn btn-default" type="submit" value="登录">
		<a onclick="register();" style="padding-left:50px">注册</a>
		</form>
	<p id="failText"></p>
<script type="text/javascript" src="jquery-1.11.2.min.js" ></script>  
<script type="text/javascript">
$(document).ready(function(){
	var message = <%=request.getAttribute("message")%>;
	if(message!=null){
		$("#failText").text("用户名或密码错误，请重新输入");
	}
});	
function register(){
	location.href="Register.jsp";
}
</script>
</body>
</html>