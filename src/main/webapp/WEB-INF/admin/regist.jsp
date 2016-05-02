<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
 	String basePath=request.getScheme()+"://"
 		+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<style>
.admin-regist{
	width:450px;
	margin:15px auto;
	padding:5px;
}
label{
	display:inline-block;
	width:75px;
	margin-bottom:15px;
}
</style>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="admin-regist">
	<form action="<%=basePath %>admin/regist" method="post">
		<label>用户名</label><input type="text" size=22 maxlength=60 name="userName" id="userName"/><br/>
		<label>密码</label><input type="password" size=22 maxlength=60 name="passwd" id="passwd"/><br/>
		<label>确认密码</label><input type="password" size=22 maxlength=60 name="confirmpasswd" id="confirmpasswd"/><br/>
		<input type="button" value="注册" onclick="regist();"/>
	</form>
</div>
<script src="<%=basePath %>js/string-util.js"></script>
<script>
function regist(){
	var username = document.getElementById("userName").value.trim();
	var passwd = document.getElementById("passwd").value.trim();
	var confirmpswd = document.getElementById("confirmpasswd").value.trim();
	if(username.length==0){
		alert("用户名不能为空");
		document.getElementById("userName").focus();
		return;
	}
	if(passwd.length < 5){
		alert("密码长度不能小于5");
		document.getElementById("passwd").focus();
		return;
	}
	if(passwd != confirmpswd){
		alert("两次密码输入不一致");
		document.getElementById("confirmpasswd").focus();
		return;
	}
	document.forms[0].submit();		
}
</script>
</body>
</html>