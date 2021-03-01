<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/web/jsp/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/web/css/index.css">
<style type="text/css">
body {
/* 	background: url(${pageContext.request.contextPath}/web/img/girl.png) */
/* 		no-repeat; */
  	background: rgb(10, 20, 30);
}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/loginAndReg/login2" method="post">
		<div class="bg">
			<div class="wel">绩效打分系统</div>
			<div class="user">
				<div id="yonghu" style="">账&nbsp;&nbsp;&nbsp;号</div>
				<input type="text" name="code" value="孙世禄">
			</div>
			<div class="password">
				<div id="yonghu">密&nbsp;&nbsp;&nbsp;码</div>
				<input class="" type="password" name="password" value="123">
			</div>
<!-- 			<div class="fg"> -->
<!-- 				<div style="font-size: 11px; margin-top: 11px;"> -->
<!-- 					<a style="font-size: 11px;" -->
<!-- 						href="/pms/web/jsp/register.jsp">去注册</a> -->
<!-- 				</div> -->
<!-- 			</div> -->
			<input class="btn" type="submit" name="登录" value="登录">
		</div>
	</form>
</body>
</html>