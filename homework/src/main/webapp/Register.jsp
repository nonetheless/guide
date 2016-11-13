<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<form method="post">
		user:<input type="text" name="user" id="user">
		password:<input type="password" name="password" id="password1">
		password:<input type="password" name="password" id="password2">
		<input type="submit" value="注册" onclick="check()">
	</form>
	<p id="failText"></p>
<script type="text/javascript" src="jquery-1.11.2.min.js" ></script>  
<script type="text/javascript">
$(document).ready(function(){

});	
function check(){
	if($("#password1").val()==$("#password2").val()){
		location.href="RegisterServlet?user="+$("#user").val()+"&password="+$("#password").val();
	}
}
</script>
</body>
</html>