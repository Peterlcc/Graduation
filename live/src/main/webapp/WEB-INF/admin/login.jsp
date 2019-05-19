<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>管理员登录</title>
<!-- Bootstrap -->
<meta charset="utf-8" />
<link href="../../resource/admin/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link
	href="../../resource/admin/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet" media="screen">
<link href="../../resource/admin/assets/styles.css" rel="stylesheet"
	media="screen">
<script
	src="../../resource/admin/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>
<body id="login">
	<div class="container">
		<c:if test="${not empty errorMsg }">
			<font color="red">${errorMsg }</font>
		</c:if>
		<form id="form-login" class="form-signin" method="post"
			action="/admin/getin">
			<!--跳转的页面jsp-->
			<h3 class="form-signin-heading" style="text-align: center;">管理员登录</h3>
			<input id="adminname" name="name" type="text"
				class="input-block-level" placeholder="用户名"> <input
				id="adminpassword" name="password" type="password"
				class="input-block-level" placeholder="密码">
			<button class="btn btn-large btn-primary" id="submitBtn"
				type="button" style="text-align: center;">登录</button>
		</form>

	</div>
	<!-- /container -->
	<script src="../../resource/admin/vendors/jquery-1.9.1.min.js"></script>
	<script src="../../resource/admin/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#submitBtn").click(function() {
			var formLogin = document.getElementById("form-login");
			formLogin.action = "/admin/getin";
			formLogin.submit();
		});
	</script>
</body>
</html>