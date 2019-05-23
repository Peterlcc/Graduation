<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Forms</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	 addEventListener("load", function() {
		 setTimeout(hideURLbar, 0);
		 }, false);
	 function hideURLbar(){
		 window.scrollTo(0,1); 
		 } 
</script>
<!-- Bootstrap Core CSS -->
<link href="../../resource/analyze/css/bootstrap.min.css"
	rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="../../resource/analyze/css/style.css" rel='stylesheet'
	type='text/css' />
<link href="../../resource/analyze/css/conditon-select.css"
	rel='stylesheet' type='text/css' />
<!-- icon图标 -->
<link rel="icon" href="../../resource/user/images/logoilive.png" type="image/png">
<!-- Graph CSS -->
<link href="../../resource/analyze/css/font-awesome.css"
	rel="stylesheet">
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet"
	href="../../resource/analyze/css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<script src="../../resource/analyze/js/jquery-1.10.2.min.js"></script>

<script type="text/javascript">
	function editSubmit() {
				var newpassword=$("#newpassword").val();
				var passwordConfirm=$("#passwordConfirm").val();
				
				if(newpassword==''||passwordConfirm==''){
					return false;
				}
				if($("#newpassword").val()==$("#passwordConfirm").val()){
					return true;
				}else{
					alert("新密码与确认密码不一致");
					return false;
				}
						
			};
</script>
</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="inner-content">
				<!--//outer-wp-->
				<div class="outter-wp">
					<!--/forms-->
					<div class="forms-main">
						<!--/forms-inner-->
						<div class="forms-inner">
							<!--/set-1-->
							<div class="set-1">
								<div class="col-md-6 graph-2">
									<h3 class="inner-tittle two">管理员密码修改</h3>
									<div class="grid-1">
										<div class="form-body">
											<form id="editForm" class="form-horizontal" method="post"
												action="/admin/modify" onsubmit="return editSubmit();">
												<div class="form-group">
													<label for="username" class="col-sm-2 control-label">用户名</label>
													<div class="col-sm-9">
														<input type="text" class="form-control" id="username"
															name="username" placeholder="用户名" disabled="disabled"
															value="${sessionScope.admin.name }">
													</div>
												</div>
												<div class="form-group">
													<label for="password" class="col-sm-2 control-label">旧密码</label>
													<div class="col-sm-9">
														<input type="password" class="form-control" id="password"
															placeholder="旧密码" name="password">
													</div>
												</div>
												<div class="form-group">
													<label for="newpassword" class="col-sm-2 control-label">新密码</label>
													<div class="col-sm-9">
														<input type="password" class="form-control"
															id="newpassword" placeholder="新密码" name="newpassword">
													</div>
												</div>
												<div class="form-group">
													<label for="passwordConfirm" class="col-sm-2 control-label">确认</label>
													<div class="col-sm-9">
														<input type="password" class="form-control"
															name="passwordConfirm" id="passwordConfirm"
															placeholder="确认新密码">
													</div>
												</div>
												<div class="col-sm-offset-2">
													<button type="submit" class="btn btn-default">确认修改</button>
												</div>
											</form>
										</div>

									</div>

								</div>

							</div>
							<!--//set-1-->
							<!--/set-2-->

							<!--//set-4-->
						</div>
						<!--//forms-inner-->
					</div>
					<!--//forms-->
				</div>
				<!--//outer-wp-->
			</div>
		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
		<div class="sidebar-menu">
			<header class="logo">
				<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
				</a> <a class="disable" href="javascript:void(0)"> <span id="logo">
						<h1>后台管理</h1>
				</span>
				</a>
			</header>
			<div style="border-top: 1px solid rgba(69, 74, 84, 0.7)"></div>
			<!--/down-->
			<div class="down">
				<a class="disable" href="javascript:void(0)"><img
					src="../../resource/analyze/images/admin.jpg"></a> <a
					class="disable" href="javascript:void(0)"><span
					class=" name-caret">管理员：${sessionScope.admin.name }</span></a>
				<p>管理员</p>
				<ul>
					<li><a class="tooltips disable" href="javascript:void(0)"><span>修改密码</span><i
							class="lnr lnr-cog"></i></a></li>
					<li><a class="tooltips" href="/admin/logout"><span>退出登录</span><i
							class="lnr lnr-power-switch"></i></a></li>
				</ul>
			</div>
			<!--//down-->
			<div class="menu">
				<ul id="menu">
					<li><a href="/admin/analyze#house-chart"><i
							class="fa fa-table"></i> <span>房屋分析</span></a></li>
					<li><a href="/admin/analyze#user-chart"><i
							class="fa fa-table"></i> <span>用户分析</span></a></li>
					<li><a href="/admin/users"><i
							class="fa fa-file-text-o"></i> <span>用户明细</span></a></li>
					<li><a href="/admin/houses"><i
							class="fa fa-file-text-o"></i> <span>房屋明细</span></a></li>
				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}

					toggle = !toggle;
				});
	</script>
	<!-- Bootstrap Core JavaScript -->
	<script src="../../resource/analyze/js/jquery.nicescroll.js"></script>
	<script src="../../resource/analyze/js/bootstrap.min.js"></script>
</body>
</html>