<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>iLive|登录</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="./css/bootstrap.min.css">
        <link rel="stylesheet" href="./css/font-awesome.min.css">
		<!--<link rel="stylesheet" href="css/form-elements.css">-->
        <link rel="stylesheet" href="./css/loginstyle.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" /><!-- Bootstrap stylesheet -->
        <link href="./css/style.css" rel="stylesheet" type="text/css" media="all" /><!-- stylesheet -->
        <link href="./css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" /><!-- fontawesome -->

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
        <script type="text/javascript" src="js/jquery-2.1.4.min.js">
            //

        </script><!-- Required-js -->
        <script src="./js/bootstrap.min.js"></script><!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <!-- Include jQuery & Filterizr -->

        <script src="./js/jquery.filterizr.js"></script>
        <script src="./js/controls.js"></script>

        <!-- Kick off Filterizr -->
        <script type="text/javascript">
            $(function() {
                //Initialize filterizr with default options
                $('.filtr-container').filterizr();
            });
        </script>
        <!-- here stars scrolling icon -->
        <script type="text/javascript">
            $(document).ready(function() {
                /*
                 var defaults = {
                 containerID: 'toTop', // fading element id
                 containerHoverID: 'toTopHover', // fading element hover id
                 scrollSpeed: 1200,
                 easingType: 'linear'
                 };
                 */
//					$().UItoTop({ easingType: 'easeOutQuart' });

            });
        </script>
        <!-- start-smoth-scrolling -->
        <script type="text/javascript" src="./js/move-top.js"></script>
        <script type="text/javascript" src="./js/easing.js"></script>
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
    </head>

    <body >

    <!-- header -->
    <header>
        <div class="container">
            <!-- nav -->
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        
                        <div class="logo">
                            <h1><a href="index.html"> iLive</a></h1>
                        </div>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                          <ul class="nav navbar-nav">
                            <li ><a href="properties.html">首页</a></li>
                      
                            <li ><a href="register.html">注册</a></li>
                            <li class="active"><a href="login.html">登录</a></li>

                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container-fluid -->
            </nav>
            <script src="js/nav.js"></script><!-- nav-js -->
            <!-- //nav -->
        </div>
    </header>
    <!-- //header -->
        <!-- Top content -->
        <div class="top-content" style="max-width: 100%; background:url(images/backgroundimg.jpg);
        background-position:center;background-repeat: no-repeat;background-attachment: scroll;background-size: cover;">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="titlelogin" style="text-align: center;color: white">
                            <h2> 登录</h2>
                            
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-4 form-box">
                        	
                            <div class="form-bottom">
			                    <form role="form"  method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only">Username</label>
			                        	<input type="text" id="username"  name="form-username" placeholder="用户名" class="form-username form-control" >
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only">Password</label>
			                        	<input type="password" id="password"  name="form-psd" placeholder="密码" class="form-password form-control" >
			                        </div>
			                        <button id="submit" type="button" class="btn" style="text-align: center;line-height: 2px; ">登录</button>
                   		        
                   		        	<div class="newregister" style="padding: 15px  0 0 170px">
                   		       			<h5>没有注册账号？<a href="register.html">请注册</a></h5>	
                   		        	</div>
			                    </form>
		                    </div>
                        	
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>

    <!-- footer -->
    <footer>
        <!-- footer-top -->
        <div class="footer-top">
            <div class="container">
                <div class="col-md-4 footer-top-left">
                    <h3><a href="index.html">iLive</a></h3>
                </div>
                <div class="col-md-4 footer-top-mid">
                    <h3>Our Program</h3>
                    <ul>
                        <li><a href="properties.html"><i class="fa fa-long-arrow-right" aria-hidden="true"></i>主页</a></li>
                      
                        <li><a href="register.html"><i class="fa fa-long-arrow-right" aria-hidden="true"></i>注册</a></li>
                        <li><a href="login.html"><i class="fa fa-long-arrow-right" aria-hidden="true"></i>登录</a></li>

                    </ul>
                </div>
                <div class="col-md-4 footer-top-right">
                    <h3>Address</h3>
                    <address>
                        <ul>
                            <li>Hebut University</li>
                            <li>Telephone : secret</li>
                            <li>Email : <a class="mail">We don't konw either.</a></li>
                        </ul>
                    </address>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- //footer-top -->
        <div class="w3layouts-copyright">
            <p class="footer">Copyright &copy; 2018.iLive All rights reserved. </p>
        </div>
    </footer>
    <!-- //footer -->
    <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 0;"></span>To Top</a>

    <script>
        $("#submit").click(function () {
            var username=document.getElementById("username").value;
            var password=document.getElementById("password").value;

            $.ajax({
                url: "/user/login",
                dataType:"json",
                data: {username:username, password: password},
                type: "POST",
                success:function (result) {
                   if(result.result==false){
                	   alert("用户名或密码错误！");
                	   window.location.href="login.html";
                     }
                   else { window.location.href="properties.html";}
                }
            })
        })
    </script>

    </body>

</html>