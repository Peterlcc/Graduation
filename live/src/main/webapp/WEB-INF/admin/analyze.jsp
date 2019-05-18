<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<!-- Bootstrap Core CSS -->
<link href="../../resource/analyze/css/bootstrap.min.css"
	rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="../../resource/analyze/css/style.css" rel='stylesheet'
	type='text/css' />
<link href="../../resource/analyze/css/conditon-select.css"
	rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="../../resource/analyze/css/font-awesome.css"
	rel="stylesheet">
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet"
	href="../../resource/analyze/css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<script src="../../resource/analyze/js/jquery-1.10.2.min.js"></script>
<!-- echarts -->
<script type="text/javascript"
	src="../../resource/analyze/js/house-analyze.js"></script>
<script type="text/javascript"
	src="../../resource/analyze/js/user-analyze.js"></script>
<script type="text/javascript"
	src="../../resource/analyze/js/analyze.js"></script>
<script type="text/javascript">
	window.onload = function() {
		houseAnalyze(document.getElementById("houseAttrSelect"), 'house-map');
		userAnalyze(document.getElementById("userAttrSelect"), 'user-map');
		allAnalyze(document.getElementById("allUserAttrSelect"), document
				.getElementById("allHouseAttrSelect"), document
				.getElementById('allMiddleAttrSelect'), 'all-map');
	}
</script>
<script type="text/javascript" src="../../resource/analyze/js/echarts.min.js"></script>
<script type="text/javascript"
	src="../../resource/analyze/js/echarts-gl.min.js"></script>
<script type="text/javascript"
	src="../../resource/analyze/js/ecStat.min.js"></script>

<script type="text/javascript" src="../../resource/analyze/js/china.js"></script>
<script type="text/javascript" src="../../resource/analyze/js/world.js"></script>
<script type="text/javascript"
	src="../../resource/analyze/js/bmap.min.js"></script>

</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="inner-content">
				<div class="outter-wp">
					<!--custom-widgets-->
					<div class="custom-widgets">
						<div class="row-one">
							<div class="col-md-3 widget">
								<div class="stats-left ">
									<h5>今日</h5>
									<h4>登录数</h4>
								</div>
								<div class="stats-right">
									<label>50</label>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="col-md-3 widget states-mdl">
								<div class="stats-left">
									<h5>今日</h5>
									<h4>访问量</h4>
								</div>
								<div class="stats-right">
									<label>100</label>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="col-md-3 widget states-thrd">
								<div class="stats-left">
									<h5>今日</h5>
									<h4>任务量</h4>
								</div>
								<div class="stats-right">
									<label>200</label>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="col-md-3 widget states-last">
								<div class="stats-left">
									<h5>今日</h5>
									<h4>警告数</h4>
								</div>
								<div class="stats-right">
									<label>0</label>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
					<!--//custom-widgets-->
					<!--/candile-->
					<div class="candile">
						<div id="all-chart"></div>
						<div class="candile-inner">
							<h3 style="display: inline" class="sub-tittle">房屋用户关联统计信息</h3>
							&nbsp;&nbsp;&nbsp; <select id="allHouseAttrSelect"
								onchange="allAnalyze(document.getElementById('allUserAttrSelect'),this,document.getElementById('allMiddleAttrSelect'),'all-map')"
								class="condition-select" data-selector>
								<option value="house.area_city">区域</option>
								<option value="house.dealer_company">出租公司</option>
								<option value="house.look_type">看房时间</option>
								<option value="house.street">街道</option>
								<option value="house.rent_type">租住方式</option>
								<option value="house.pay_type">支付方式</option>
							</select> &nbsp;&nbsp;&nbsp; <select class="condition-select"
								onchange="allAnalyze(this,document.getElementById('allHouseAttrSelect'),document.getElementById('allMiddleAttrSelect'),'all-map')"
								id="allUserAttrSelect" data-selector>
								<option value="majors.name">职业</option>
								<option value="users.age">年龄</option>
								<option value="users.sex">性别</option>
							</select>&nbsp;&nbsp;&nbsp; <select class="condition-select"
								onchange="allAnalyze(document.getElementById('allUserAttrSelect'),document.getElementById('allHouseAttrSelect'),this,'all-map')"
								id="allMiddleAttrSelect" data-selector>
								<option value="log">浏览记录</option>
								<option value="collect">收藏</option>
								<option value="phone">查看电话</option>
							</select>
							<div id="center-house">
								<div id="all-map" style="width: 100%; height: 400px"></div>
							</div>
						</div>

						<div id="house-chart"></div>
						<div class="candile-inner">
							<h3 style="display: inline" class="sub-tittle">房屋统计信息</h3>
							&nbsp;&nbsp;&nbsp; <select id="houseAttrSelect"
								onchange="houseAnalyze(this,'house-map')"
								class="condition-select" data-selector>
								<option value="area_city">区域</option>
								<option value="dealer_company">出租公司</option>
								<option value="look_type">看房时间</option>
								<option value="street">街道</option>
								<option value="rent_type">租住方式</option>
								<option value="pay_type">支付方式</option>
							</select>
							<div id="center-house">
								<div id="house-map" style="width: 800px; height: 400px"></div>
							</div>
						</div>
						<div id="user-chart"></div>
						<div class="candile">
							<div class="candile-inner">
								<h3 style="display: inline" class="sub-tittle">用户统计信息</h3>
								&nbsp;&nbsp;&nbsp; <select class="condition-select"
									onchange="userAnalyze(this,'user-map')" id="userAttrSelect"
									data-selector>
									<option value="age">年龄</option>
									<option value="sex">性别</option>
									<option value="majors.name">职业</option>
								</select>

								<div id="center-user">
									<div id="user-map" style="width: 800px; height: 400px"></div>
								</div>
							</div>
						</div>
						<!--/candile-->

						<!--/charts-->
						<div class="charts">
							<div class="chrt-inner"></div>
							<!--/charts-inner-->
						</div>
						<!--//outer-wp-->
					</div>
					<!-- footer -->
					<div class="copyright">
						<p>&copy; 2019.Peter All rights reserved.</p>
					</div>
					<!-- //footer -->
				</div>
			</div>
		</div>
		<!--//content-inner-->
			<!--/sidebar-menu-->
			<div class="sidebar-menu">
				<header class="logo">
					<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
					</a> <a href="index.html"> <span id="logo">
							<h1>后台管理</h1>
					</span>
					</a>
				</header>
				<div style="border-top: 1px solid rgba(69, 74, 84, 0.7)"></div>
				<!--/down-->
				<div class="down">
					<a href="index.html"><img
						src="../../resource/analyze/images/admin.jpg"></a> <a
						class="disable" href="javascript:void(0)"><span class=" name-caret">管理员：${sessionScope.admin.name }</span></a>
					<p>管理员</p>
					<ul>
						<li><a class="tooltips" href="/admin/edit"><span>修改密码</span><i
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
							$(".page-container").removeClass(
									"sidebar-collapsed").addClass(
									"sidebar-collapsed-back");
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