<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>iLive|快速租房好帮手</title>
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
	 addEventListener("load", function() {
		 setTimeout(hideURLbar, 0); 
		 }
	 , false); 
	 function hideURLbar(){
		 window.scrollTo(0,1);
		 } 
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
								<a href="/house/ilive" style="color: #00c5b5">iLive</a>
							</h1>
						</div>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li id="userId" style="display: none"
								value="${sessionScope.user.id}">${sessionScope.user.id}</li>
							<li><a href="/house/ilive">Home</a></li>
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
					<li class=''><a href="/user/passwordEdit">
							<i class='icon-cog text-green'></i> <span>修改密码</span>
					</a></li>
					<li class=''><a href='/user/collectedHouses'> <i
							class='icon-heart text-green'></i> <span>房屋收藏</span>
					</a></li>
					<li class=''><a class="disable" href="javascript:void(0)"> <i
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
							<div class='span12 box bordered-box blue-border'
								style='margin-bottom: 0;'>
								<div class='box-header blue-background'>
									<div class='title'>查看过的房屋</div>
								</div>
								<div class='box-content box-no-padding'>
									<div class='responsive-table'>
										<div class='scrollable-area'>
											<table class='table' style='margin-bottom: 0;'>
												<thead>
													<tr>
														<th><font size="5" color="black">标题</font></th>
														<th><font size="5" color="black">位置</font></th>
														<th><font size="5" color="black">价格</font></th>
														<th></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${pageBean.beanList}" var="bean">
														<tr>
															<c:choose>
																<c:when test="${fn:length(bean.title) gt 15 }">
																	<c:set var="houseTitle"
																		value="${fn:substring(bean.title,0,12)}..."></c:set>
																</c:when>
																<c:otherwise>
																	<c:set var="houseTitle" value="${bean.title}"></c:set>
																</c:otherwise>
															</c:choose>
															<td>${houseTitle }</td>
															<td>${bean.city }-${bean.areaCity }-${bean.street }</td>
															<td>${bean.price }</td>
															<td>
																<div class='text-right'>
																	<a class='btn btn-success'
																		href='/house/detail?id=${bean.id }'> 查看详情 </a>
																</div>
															</td>
														</tr>
													</c:forEach>

												</tbody>
											</table>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 分页开始 -->
			<div class="center">
				<ul class="pagination">
					<li><h5>第${pageBean.currentPage }页/共${pageBean.totalPage }页</h5></li>
					<li><a href="${pageBean.url }&pc=1">首页</a></li>
					<li><c:if test="${pageBean.currentPage>1 }">
							<a href="${pageBean.url }&pc=${pageBean.currentPage-1 }">上一页</a>
						</c:if></li>
					<!-- begin和end 的设置 -->
					<c:choose>
						<c:when test="${pageBean.totalPage<10 }">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="${pageBean.totalPage}"></c:set>
						</c:when>
						<c:otherwise>
							<c:set var="begin" value="${pageBean.currentPage-5 }"></c:set>
							<c:set var="end" value="${pageBean.currentPage+4 }"></c:set>

							<c:if test="${begin<1 }">
								<c:set var="begin" value="1"></c:set>
								<c:set var="end" value="10"></c:set>
							</c:if>

							<c:if test="${end>pageBean.totalPage }">
								<c:set var="begin" value="${pageBean.totalPage-9 }"></c:set>
								<c:set var="end" value="${pageBean.totalPage}"></c:set>
							</c:if>
						</c:otherwise>
					</c:choose>
					<!-- 循环打印页标 -->
					<c:forEach var="i" begin="${begin }" end="${end }">
						<c:choose>
							<c:when test="${i eq pageBean.currentPage}">
								<li><a class="disable" href="javascript:void(0)">${i }</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${pageBean.url }&pc=${i }">${i }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${pageBean.currentPage<pageBean.totalPage }">
						<li><a href="${pageBean.url }&pc=${pageBean.currentPage+1 }">下一页</a></li>
					</c:if>
					<li><a href="${pageBean.url }&pc=${pageBean.totalPage }">尾页</a></li>
				</ul>
			</div>
			<!-- 分页结束 -->
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
							<li>Email : <a href="javascript:void(0);" class="mail">1414499216@qq.com</a></li>
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

</body>
</html>