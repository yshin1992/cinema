<%@page import="org.ysh.domain.Administrator,org.ysh.constants.*"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/head.css"> 
</head>
<body>
<div class="header">
	<div class="nav-right">
		<% 
			if(null == session.getAttribute(SysConstants.CUR_USER))
			{
		%>
		<a class="nav-login" href="<%=basePath %>admin/login">登录</a>
		<a class="nav-login" href="<%=basePath %>admin/regist">注册</a>
		<%
			}
			else 
			{
				Administrator admin = (Administrator)session.getAttribute(SysConstants.CUR_USER);
		%>
			<div class="user" onmouseover="showsetting();" onmouseout="hidesetting();">
				<a class="nav-login" href="<%=basePath %>admin/showinfo"><%=admin.getUserName() %></a>
				<div class="user-setting" id="setting">
					<a href="<%=basePath %>admin/showinfo">个人信息</a>
					<a href="<%=basePath %>admin/update">修改密码</a>
					<a href="<%=basePath %>admin/logout">注销</a>
				</div>
			</div>
		<%
			}
		%>
	</div>
</div>
<script>
	function showsetting(){
		document.getElementById("setting").style.display="block";
	}
	
	function hidesetting(){
		document.getElementById("setting").style.display="none";
	}
	
</script>
</body>
</html>