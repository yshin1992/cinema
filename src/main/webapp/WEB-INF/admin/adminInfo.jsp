<%@page import="org.ysh.domain.Administrator,org.ysh.constants.*,java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<style>
	h3,div.user-info{
		margin-left:30px;
	}
	label{
		display:inline-block;
		width:75px;
		font-weight:bold;
		margin:0 0 15px 0;
	}
</style>
</head>
<body>
<jsp:include page="head.jsp" />
	<%
		Administrator admin = (Administrator)session.getAttribute(SysConstants.CUR_USER);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	%>
	<h3>管理员个人信息</h3>
	<div class="user-info">
		<label>用户名</label><span><%=admin.getUserName() %></span><br/>
		<label>创建时间</label><span><%=sdf.format(admin.getCreateTime()) %></span><br/>
	</div>
</body>
</html>