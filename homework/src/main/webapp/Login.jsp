<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		user:<input type="text" name="user">
		password:<input type="password" name="password">
		<input type="submit" value="登录">
	</form>
	<input type="button" name="register" value="注册" onclick="register()">
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