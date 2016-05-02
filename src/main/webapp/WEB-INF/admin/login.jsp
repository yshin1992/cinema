<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
 	String basePath=request.getScheme()+"://"
 		+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/login.css">
<style>
</style>
</head>
<body>
<jsp:include page="head.jsp" />
	<div class="login-div">
		<form action="<%=basePath %>admin/login" method="post">
			<label for="username">用户名</label><input type="text" autocomplete="off" size=20 maxlength=60 name="username" /><br/>
			<label for="password">密码</label><input type="password" autocomplete="off" size=20 maxlength=30 name="password"/><br/>
			<input type="submit" value="登录" /> <a href="<%=basePath %>admin/regist">注册</a>
		</form>
		<div class="error">
			<%=request.getAttribute("loginInfo")==null?"":request.getAttribute("loginInfo") %>
		</div>
	</div>
</body>
</html>