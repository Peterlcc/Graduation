<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>iLive|密码修改</title>
<link href="../../resource/user/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" media="all" />
<!-- icon图标 -->
<link rel="icon" href="../../resource/user/images/logoilive.png" type="image/png">
<!-- Bootstrap stylesheet -->
<link href="../../resource/user/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<!-- stylesheet -->
<link href="../../resource/user/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" media="all" />
<!-- fontawesome -->
<!-- meta tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="referrer" content="no-referrer" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 



</script>
<!--fonts-->
<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed"
	rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">
<!--//fonts-->
<script src="../../resource/user/js/jquery.min.js"
	type="text/javascript"></script>
<!-- Include jQuery & Filterizr -->
<script type="text/javascript"
	src="../../resource/user/js/jquery-2.1.4.min.js"></script>
<!-- Required-js -->
<script src="../../resource/user/js/bootstrap.min.js"></script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<script src="../../resource/user/js/controls.js"></script>
<!-- 页面显示的初始化 -->
<!-- //here ends scrolling icon -->
<script type="text/javascript">
	$(document).ready(function() {
		var defaults = {
			containerID : 'toTop', // fading element id
			containerHoverID : 'toTopHover', // fading element hover id
			scrollSpeed : 1200,
			easingType : 'linear'
		};
	});
</script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<script type="text/javascript">
	window.onload = function() {
		profileReadOnly();
	};
</script>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="../../resource/user/js/move-top.js"></script>
<script type="text/javascript" src="../../resource/user/js/easing.js"></script>
<!-- start-smoth-scrolling -->

<!-- 自定义的分页的css样式引用 -->
<link rel="stylesheet" href="../../resource/user/css/page.css"
	type="text/css">
<!-- 自定义的选择框的css样式引用 -->
<link rel="stylesheet"
	href="../../resource/user/css/conditon-select.css" type="text/css">


<!-- / flatty theme -->
<link href='../../resource/edit/assets/stylesheets/light-theme.css'
	id='color-settings-body-color' media='all' rel='stylesheet'
	type='text/css' />
<link
	href='../../resource/edit/assets/stylesheets/bootstrap-responsive.css'
	id='color-settings-input-color' media='all' rel='stylesheet'
	type='text/css' />
<link href='../../resource/edit/assets/stylesheets/bootstrap.css'
	id='color-settings-in-color' media='all' rel='stylesheet'
	type='text/css' />
<script type="text/javascript">
	function editSubmit() {
		var newpassword = $("#newpassword").val();
		var passwordConfirm = $("#passwordConfirm").val();
		var password=$("#password").val();
		if(password==''){
			alert("密码不能为空");
			return false;
		}
		if (newpassword == '' || passwordConfirm == '') {
			alert("新密码或者确认密码不能为空");
			return false;
		}
		else if(newpassword!=passwordConfirm){
			alert("新密码与确认密码不一致");
			return false;
		}
		else{
			return true;
		}

	};
</script>
<script type="text/javascript">
	window.onload = function() {
		profileReadOnly();
	};
</script>

<!-- / demo -->
<body class='contrast-red '>
	<header>
		<div class="container">
			<!-- nav -->
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">

						<div class="logo">
							<h1>
								<a style="color: #00c5b5" href="/house/ilive">iLive</a>
							</h1>
						</div>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li id="userId" style="display: none"
								value="${sessionScope.user.id}">${sessionScope.user.id}</li>
							<li><a href="/house/ilive">主页</a></li>
							<li><a href="/house/home">租房</a></li>
							<li class="dropdown active"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown">${sessionScope.user.name}
									<b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="/user/detail">个人信息</a></li>
									<li><a href="/user/logout">退出</a></li>
								</ul></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
			<script src="../../resource/user/js/nav.js"></script>
			<!-- nav-js -->
			<!-- //nav -->
		</div>
	</header>
	<!-- //header -->
	<div id='wrapper'>
		<div id='main-nav-bg'></div>
		<nav class='' id='main-nav'>
			<div class='navigation'>
				<ul class='nav nav-stacked'>
					<li class=''><a href='/user/detail'> <i class='icon-user text-green'></i>
							<span>个人信息修改</span>
					</a></li>
					<li class=''><a class="disable" href="javascript:void(0)">
							<i class='icon-cog text-green'></i> <span>修改密码</span>
					</a></li>
					<li class=''><a href='/user/collectedHouses'> <i
							class='icon-heart text-green'></i> <span>房屋收藏</span>
					</a></li>
					<li class=''><a href='/user/logedHouses'> <i
							class='icon-edit  text-green'></i> <span>浏览历史</span>
					</a></li>
					<li class=''><a href='/user/phonedHouses'> <i
							class='icon-phone  text-green'></i> <span>查看电话列表</span>
					</a></li>
				</ul>
			</div>
		</nav>
		<section id='content'>
			<div class='container-fluid'>
				<div class='row-fluid' id='content-wrapper'>
					<div class='span12'>
						<div class='row-fluid'>
							<div class='span12 box'>
								<div class='box-header blue-background'>
									<div class='title'>密码修改</div>
									<c:if test="${not empty passwordModifyMsg }">
										<div class='text-orange'>&lt;${passwordModifyMsg }&gt;</div>
									</c:if>
								</div>
								<div class='box-content'>
									<form id="editForm" class='form form-horizontal validate-form'
										style='margin-bottom: 0;' action="/user/passwordModify" method="post"
										onsubmit="return editSubmit();">
										<div class='control-group'>
											<label class='control-label' for='name'>用户名</label>
											<div class='controls'>
												<input class="profile-input"
													data-rule-minlength='2'
													data-rule-required='true' 
													id='name' 
													name='name'
													placeholder='用户名' type='text'
													disabled="disabled"
													value="${sessionScope.user.name }" />
											</div>
										</div>

										<div class='control-group'>
											<label class='control-label' for='password'>密码</label>
											<div class='controls'>
												<input class="profile-input" data-rule-minlength='6'
													data-rule-password='true' data-rule-required='true'
													id='password' name='password' placeholder='密码'
													type='password' />
											</div>
										</div>
										<div class='control-group'>
											<label class='control-label' for='newpassword'>新密码</label>
											<div class='controls'>
												<input class="profile-input" data-rule-minlength='6'
													data-rule-password='true' data-rule-required='true'
													id='newpassword' name='newpassword' placeholder='新密码'
													type='password' />
											</div>
										</div>
										<div class='control-group'>
											<label class='control-label' for='passwordConfirm'>新密码确认</label>
											<div class='controls'>
												<input class="profile-input"
													data-rule-equalto='#validation_password'
													data-rule-required='true' id='passwordConfirm'
													name='passwordConfirm' placeholder='确认密码' type='password' />
											</div>
										</div>
										
										
										
										<div class='form-actions' style='margin-bottom: 0'>
											<button class='btn btn-info' type="button"
												onclick="profileEnable();">
												<i class='icon-edit-sign'></i>修改
											</button>
											&nbsp;
											<button class='btn btn-primary' type='submit'>
												<i class='icon-eraser'></i>提交修改
											</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<!-- footer -->
	<footer>
		<!-- footer-top -->
		<div class="footer-top">
			<div class="container">
				<div class="col-md-4 footer-top-left">
					<h3>
						<a href="/house/ilive">iLive</a>
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
							<li>Telephone : 13820872310</li>
							<li>Email : <a class="mail" href="javascript:void(0);">1414499216@qq.com</a></li>
						</ul>
					</address>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- //footer-top -->
		<div class="w3layouts-copyright">
			<p class="footer">Copyright &copy; 2018.iLive All rights
				reserved.</p>
		</div>
	</footer>
	<!-- //footer -->
	<!-- / jquery -->
	<script
		src='../../resource/edit/assets/javascripts/jquery/jquery.min.js'
		type='text/javascript'></script>
	<!-- / jquery ui -->
	<!-- / bootstrap -->
	<script
		src='../../resource/edit/assets/javascripts/bootstrap/bootstrap.min.js'
		type='text/javascript'></script>

	<!-- / inplace editing -->
	<script
		src='../../resource/edit/assets/javascripts/plugins/xeditable/bootstrap-editable.min.js'
		type='text/javascript'></script>
	<!-- / demo -->
	<script
		src='../../resource/edit/assets/javascripts/demo/jquery.mockjax.js'
		type='text/javascript'></script>
	<script
		src='../../resource/edit/assets/javascripts/demo/inplace_editing.js'
		type='text/javascript'></script>
	<script src='../../resource/edit/assets/javascripts/profileReadOnly.js'
		type='text/javascript'></script>

</body>
</html>