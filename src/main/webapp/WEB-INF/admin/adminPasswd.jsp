<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
 	String basePath=request.getScheme()+"://"
 		+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码管理</title>
<style>
	.passwd-update{
		width:400px;
		margin:20px auto;
		border:1px solid silver;
		padding:15px;
	}
	h3{
		width:100%;
		text-align:center;
	}
	.passwd-update  label{
		display: inline-block;
		width:85px;
	}
</style>
</head>
<body>
	<jsp:include page="head.jsp" />
	<h3>管理员密码修改</h3>
	<div class="passwd-update">
		<form action="<%=basePath %>admin/update" method="post">
			<label>旧密码</label><input type="password" name="oldpasswd" id="oldpasswd" size=22 maxlength=60 placeholder="请输入旧密码"/><br/>
			<label>新密码</label><input type="password" name="newpasswd" id="newpasswd" size=22 maxlength=60 placeholder="请输入新密码"/><br/>
			<label>新密码确认</label><input type="password" name="confirmpasswd" id="confirmpasswd" size=22 maxlength=60 placeholder="请再次输入新密码"/><br/>
			<input type="button" value="修改" onclick="submitForm();"/>
		</form>
	</div>
<script src="<%=basePath %>js/string-util.js"></script>
<script>
	function submitForm()
	{
		var oldpswd = document.getElementById("oldpasswd").value.trim();
		var newpswd = document.getElementById("newpasswd").value.trim();
		var confirm = document.getElementById("confirmpasswd").value.trim();
		if(oldpswd.length<5){
			alert("旧密码输入错误");
			return;
		}
		if(newpswd.length<5){
			alert("新密码的长度不能小于5");
			return;
		}
		if(oldpswd == newpswd){
			alert("新密码不能和旧密码相同");
			return;
		}
		if(newpswd != confirm){
			alert("两次新密码输入不一致");
			return;
		}
		document.forms[0].submit();
	}
</script>
</body>
</html>