<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<link href="../../resource/user/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" /><!-- Bootstrap stylesheet -->
<link href="../../resource/user/css/style.css" rel="stylesheet" type="text/css" media="all" /><!-- stylesheet -->
<link href="../../resource/user/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" /><!-- fontawesome -->  
<!-- meta tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //meta tags -->
<!--fonts-->
<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<!--//fonts-->	        
<script type="text/javascript" src="../../resource/user/js/jquery-2.1.4.min.js"></script><!-- Required-js -->
<!-- requried-jsfiles-for owl -->
	<link href="../../resource/user/css/owl.carousel.css" rel="stylesheet" type="text/css" media="all" />
		 <script src="../../resource/user/js/owl.carousel.js"></script>
			<script>
			 $(document).ready(function() {
					$("#owl-demo").owlCarousel({
						 items : 4,
						 lazyLoad : true,
						 autoPlay : true,
							navigation : true,
							navigationText :  true,
							pagination : false,
							});
				});
			</script>
<!-- //requried-jsfiles-for owl -->	
<script src="../../resource/user/js/bootstrap.min.js"></script><!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../../resource/user/js/jquery.superslides.js" type="text/javascript" charset="utf-8"></script><!-- banner-slider-js -->  
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
                            <h1><a href="javascript:void(0);"> iLive</a></h1>
                        </div>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                          <ul class="nav navbar-nav">
                            <li class="active"><a href="/house/ilive">Home</a></li>
							<li class="dropdown">
							  <a href="#" class="dropdown-toggle" data-toggle="dropdown">服务 <b class="caret"></b></a>
							  <ul class="dropdown-menu">
								<li><a href="/house/home">租房</a></li>
							  </ul>
							</li>
							<c:choose>
								<c:when test="${not empty sessionScope.user }">
									<li class="dropdown">
									  <a href="#" class="dropdown-toggle" data-toggle="dropdown">${user.name} <b class="caret"></b></a>
									  <ul class="dropdown-menu">
										<li><a href="/user/detail">个人信息</a></li>
										<li><a href="/user/logout">退出</a></li>
									  </ul>
									</li>
								</c:when>
								<c:otherwise>
		                            <li ><a href="/user/register">注册</a></li>
		                            <li ><a href="/user/login">登录</a></li>
								</c:otherwise>
							</c:choose>

                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container-fluid -->
            </nav>
            <script src="../../resource/user/js/nav.js"></script><!-- nav-js -->
            <!-- //nav -->
        </div>
    </header>
    <!-- //header -->
		<!-- Features -->
		<div class="features-w3l" style="padding:0px 0px 35px 0px ">
			<div class="container" style="border:1px solid gray;border-radius:5px">
				
				<div class="wthree_w3l_grids">
					<div class="col-md-6 wthree_w3l_grid" >
						<div class="col-xs-3 wthree_w3l_grid-left">
							<div class="wthree_w3l_grid-left1">
								<i class="fa fa-home" aria-hidden="true"></i>
							</div>
						</div>
						<div class="col-xs-9 wthree_w3l_grid-right">
							<h4>家一样的温暖</h4>
							<p>ilive的愿景就是通过大数据的途径给离家在外的人家的温暖</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="col-md-6 wthree_w3l_grid wow fadeInRight animated" data-wow-delay=".5s">
						<div class="col-xs-3 wthree_w3l_grid-left">
							<div class="wthree_w3l_grid-left1">
								<i class="fa fa-key" aria-hidden="true"></i>
							</div>
						</div>
						<div class="col-xs-9 wthree_w3l_grid-right">
							<h4>打开心灵的钥匙</h4>
							<p>ilive将根据用户的行为习惯，计算用户的偏好，并以此为依据为用户推荐合适满意的房屋</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="wthree_w3l_grids" style="padding-bottom: 10px">
					<div class="col-md-6 wthree_w3l_grid wow fadeInLeft animated" data-wow-delay=".5s">
						<div class="col-xs-3 wthree_w3l_grid-left">
							<div class="wthree_w3l_grid-left1">
								<i class="fa fa-building-o" aria-hidden="true"></i>
							</div>
						</div>
						<div class="col-xs-9 wthree_w3l_grid-right">
							<h4>立体的服务</h4>
							<p>ilive基于平台的大数据系统，为广大用户提供立体周到的服务</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="col-md-6 wthree_w3l_grid wow fadeInRight animated" data-wow-delay=".5s">
						<div class="col-xs-3 wthree_w3l_grid-left">
							<div class="wthree_w3l_grid-left1">
								<i class="fa fa-briefcase" aria-hidden="true"></i>
							</div>
						</div>
						<div class="col-xs-9 wthree_w3l_grid-right">
							<h4>生活中的好助手</h4>
							<p>ilive致力于平台智能化的发展，为那您的幸福生活保驾护航</p>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
		<!-- //Features -->
		
		<!-- Stats -->
		<div class="stats">
			<div class="container">
			<h3>Overview</h3>
				<div class="stats-info">
					<div class="col-md-4 col-sm-4 stats-grid slideanim">
						<i class="fa fa-smile-o"></i>
						<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='15500' data-delay='.5' data-increment="50">1800</div>
						<p class="stats-info">Active Users</p>
					</div>
					<div class="col-md-4 col-sm-4 stats-grid slideanim">
						<i class="fa fa-tags" aria-hidden="true"></i>
						<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='18' data-delay='.5' data-increment="5">18</div>
						<p class="stats-info">Rents per month</p>
					</div>
					<div class="col-md-4 col-sm-4 stats-grid slideanim">
						<i class="fa fa-home" aria-hidden="true"></i>
						<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='775903' data-delay='.5' data-increment="20">775903</div>
						<p class="stats-info">Number of Homes</p>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
<!-- //main-content -->
	<!-- footer -->
    <footer>
        <!-- footer-top -->
        <div class="footer-top">
            <div class="container">
                <div class="col-md-4 footer-top-left">
                    <h3><a href="/house/ilive">iLive</a></h3>
                </div>
                <div class="col-md-4 footer-top-mid">
                    <h3>Our Program</h3>
                    <ul>
                        <li><a href="/house/ilive"><i class="fa fa-long-arrow-right" aria-hidden="true"></i>主页</a></li>
                      
                        <li><a href="/user/register"><i class="fa fa-long-arrow-right" aria-hidden="true"></i>注册</a></li>
                        <li><a href="/user/login"><i class="fa fa-long-arrow-right" aria-hidden="true"></i>登录</a></li>

                    </ul>
                </div>
                <div class="col-md-4 footer-top-right">
                    <h3>Address</h3>
                    <address>
                        <ul>
                            <li>Hebut University</li>
                            <li>Telephone : 10096</li>
                            <li>Email : <a class="mail" href="javascript:void(0);">1414499216@qq.com</a></li>
                        </ul>
                    </address>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- //footer-top -->
        <div class="w3layouts-copyright">
            <p class="footer">Copyright &copy; 2019.iLive All rights reserved. </p>
        </div>
    </footer>
    
    <!-- //footer -->
	<!-- here stars scrolling icon -->
			<script type="text/javascript">
				$(document).ready(function() {
					$().UItoTop({ easingType: 'easeOutQuart' });
					});
			</script>
			<!-- start-smoth-scrolling -->
			<script type="text/javascript" src="../../resource/user/js/move-top.js"></script>
			<script type="text/javascript" src="../../resource/user/js/easing.js"></script>
			<script type="text/javascript">
				jQuery(document).ready(function($) {
					$(".scroll").click(function(event){		
						event.preventDefault();
						$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
					});
				});
			</script>
			<!-- start-smoth-scrolling -->
		<!-- //here ends scrolling icon -->			
</body>
</html>

</body>
</html>