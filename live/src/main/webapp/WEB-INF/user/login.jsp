<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
			<title>Live|登录</title> <!-- CSS -->
			<link rel="stylesheet"
				href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
				<link rel="stylesheet"
					href="../../resource/user/css/bootstrap.min.css">
					<link rel="stylesheet"
						href="../../resource/user/css/font-awesome.min.css">
						<!--<link rel="stylesheet" href="css/form-elements.css">-->
						<link rel="stylesheet"
							href="../../resource/user/css/loginstyle.css">

							<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
							<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
							<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
							<link href="../../resource/user/css/bootstrap.min.css"
								rel="stylesheet" type="text/css" media="all" />
							<!-- Bootstrap stylesheet -->
							<link href="../../resource/user/css/style.css" rel="stylesheet"
								type="text/css" media="all" />
							<!-- stylesheet -->
							<link href="../../resource/user/css/font-awesome.min.css"
								rel="stylesheet" type="text/css" media="all" />
							<!-- fontawesome -->

							<!-- meta tags -->
							<meta name="viewport"
								content="width=device-width, initial-scale=1">
								<meta http-equiv="Content-Type"
									content="text/html; charset=utf-8" />
								<meta name="keywords" content="" />
								<script type="application/x-javascript">
									 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
								</script>

								<!-- //meta tags -->
								<!--fonts-->
								<link
									href="http://fonts.googleapis.com/css?family=Roboto+Condensed"
									rel="stylesheet">
									<link href="http://fonts.googleapis.com/css?family=Open+Sans"
										rel="stylesheet">
										<!--//fonts-->
										<script type="text/javascript"
											src="../../resource/user/js/jquery-2.1.4.min.js">
											//
										</script>
										<!-- Required-js -->
										<script src="../../resource/user/js/bootstrap.js"></script>
										<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
										<!-- Include jQuery & Filterizr -->

										<script src="../../resource/user/js/jquery.filterizr.js"></script>
										<script src="../../resource/user/js/controls.js"></script>

										<!-- Kick off Filterizr -->
										<script type="text/javascript">
											$(function() {
												//Initialize filterizr with default options
												//$('.filtr-container').filterizr();
											});
										</script>
										<!-- start-smoth-scrolling -->
										<script type="text/javascript"
											src="../../resource/user/js/move-top.js"></script>
										<script type="text/javascript"
											src="../../resource/user/js/easing.js"></script>
										<script type="text/javascript">
											jQuery(document)
													.ready(
															function($) {
																$(".scroll")
																		.click(
																				function(
																						event) {
																					event
																							.preventDefault();
																					$(
																							'html,body')
																							.animate(
																									{
																										scrollTop : $(
																												this.hash)
																												.offset().top
																									},
																									1000);
																				});
															});
										</script>
</head>

<body>

	<!-- header -->
	<header>
	<div class="container">
		<!-- nav -->
		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">

				<div class="logo">
					<h1>
						<a href="index.html"> iLive</a>
					</h1>
				</div>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="/house/ilive">Home</a></li>
					<li><a href="/house/home">租房</a></li>
					<li><a href="/user/register">注册</a></li>
					<li class="active"><a href="">登录</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
		<script src="../../resource/user/js/nav.js"></script>
		<!-- nav-js -->
		<!-- //nav -->
	</div>
	</header>
	<!-- //header -->
	<!-- Top content -->
	<div class="top-content"
		style="max-width: 100%; background: url(../../resource/user/images/backgroundimg.jpg); background-position: center; background-repeat: no-repeat; background-attachment: scroll; background-size: cover;">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="titlelogin" style="text-align: center; color: white">
						<c:if test="${not empty errorMsg }">
							<font color="red">${errorMsg }</font>
						</c:if>
						<h2>登录</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 col-sm-offset-4 form-box">

						<div class="form-bottom">
							<form role="form" method="post" class="login-form"
								action="<c:url value='/user/getin'></c:url>">
								<div class="form-group">
									<label class="sr-only">Username</label> <input type="text"
										id="username" name="username" placeholder="用户名"
										class="form-username form-control" />
								</div>
								<div class="form-group">
									<label class="sr-only">Password</label> <input type="password"
										id="password" name="password" placeholder="密码"
										class="form-password form-control" />
								</div>
								<div class="form-group">
									<input type="text" id="valicode" name="valicode"
										class="form-password" /> <img
										onclick="this.src='/user/code?d='+new Date()*1"
										src="/user/code" alt="验证码" />
								</div>
								<center>
									<input type="submit" value="登录" class="btn"
										style="text-align: center; line-height: 2px; background-color: #4aaf51; border: 1px solid transparent; width: 100%; color: white; height: 35px" />
								</center>
								<div class="newregister" style="padding: 15px 0 0 0px">
									<h5>
										<a hred="<c:url value='/user/forgotPassword'></c:url>">忘记密码？</a>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<a style="text-align: right; !important" href="/user/register">没有注册账号？请注册</a>
									</h5>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<footer> <!-- footer-top -->
	<div class="footer-top">
		<div class="container">
			<div class="col-md-4 footer-top-left">
				<h3>
					<a href="index.html">iLive</a>
				</h3>
			</div>
			<div class="col-md-4 footer-top-mid">
				<h3>Our Program</h3>
				<ul>
					<li><a href="/house/ilive"><i
							class="fa fa-long-arrow-right" aria-hidden="true"></i>主页</a></li>

					<li><a href="/user/register"><i
							class="fa fa-long-arrow-right" aria-hidden="true"></i>注册</a></li>
					<li><a href="/user/login"><i
							class="fa fa-long-arrow-right" aria-hidden="true"></i>登录</a></li>

				</ul>
			</div>
			<div class="col-md-4 footer-top-right">
				<h3>Address</h3>
				<address>
					<ul>
						<li>Hebut University</li>
						<li>Telephone : secret</li>
						<li>Email : <a class="mail">1414499216@qq.com</a></li>
					</ul>
				</address>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //footer-top -->
	<div class="w3layouts-copyright">
		<p class="footer">Copyright &copy; 2019.iLive All rights reserved.
		</p>
	</div>
	</footer>

	<!-- //footer -->
	<a href="#" id="toTop" style="display: block;"><span
		id="toTopHover" style="opacity: 0;"></span>To Top</a>
</body>

</html>