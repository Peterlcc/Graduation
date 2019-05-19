<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>iLive|注册</title>

	<!-- CSS -->
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
	<link rel="stylesheet" href="../../resource/user/css/bootstrap.min.css">
	<link rel="stylesheet" href="../../resource/user/css/font-awesome.min.css">
	<link rel="stylesheet" href="../../resource/user/css/loginstyle.css">

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
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
	<script type="text/javascript" src="../../resource/user/js/jquery-2.1.4.min.js">
        //

	</script><!-- Required-js -->
	<script src="../../resource/user/js/bootstrap.min.js"></script><!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!-- Include jQuery & Filterizr -->

	<script src="../../resource/user/js/controls.js"></script>

	<script type="text/javascript">
        $(document).ready(function() {

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
                            <h1><a href="index.html"> iLive</a></h1>
                        </div>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                          <ul class="nav navbar-nav">
                            <li><a href="/house/ilive">Home</a></li>
							<li><a href="/house/home">租房</a></li>
                            <li class="active"><a href="/user/register">注册</a></li>
                            <li ><a href="/user/login">登录</a></li>

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
        <!-- Top content -->
        <div class="top-content" style="max-width: 100%; background:url(../../resource/user/images/backgroundimg.jpg);background-repeat: no-repeat;
            background-position: center;
            background-size: cover;">
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-5 col-sm-offset-4 text">
                            <h2> 注册</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-5 col-sm-offset-4 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>请填写下列信息完成注册:</h3>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" id="registerform"  class="register-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" name="form-username" placeholder="用户名" class="form-username form-control" id="form-username">
			                        </div><!--用户名-->
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password1">Password1</label>
			                        	<input type="password" name="form-password1" placeholder="密码" class="form-password1 form-control" id="form-password1">
			                        </div><!--密码-->
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password2">Password2</label>
			                        	<input type="password" name="form-password2" placeholder="确认密码" class="form-password2 form-control" id="form-password2">
			                        </div><!--确认密码-->
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-sex">Sex</label>
			                        	<select  name="form-sex" class="form-sex form-control" id="form-sex">
				                    	<option >男</option>
										<option >女</option>
										</select>
			                        </div><!--性别-->
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-age">Age</label>
			                        	<input type="number" name="form-age" placeholder="年龄" class="form-age form-control" id="form-age">
			                        </div><!--age-->
			                        
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-occupation">Occupation</label>
			                        	<select  name="form-occupation" class="form-occupation form-control" id="form-occupation">
				                    	<option value="1">各类专业、技术人员</option>
										<option value="2">国家机关、党群组织、企事业单位的负责人</option>
										<option value="3">办事人员和有关人员</option>
										<option value="4">商业工作人员</option>
										<option value="5">服务性工作人员</option>
										<option value="6">农林牧渔劳动者</option>
										<option value="7">生产工作、运输工作和部分体力劳动者</option>
										<option value="8">不便分类的其他劳动者</option>
										</select>
			                        </div><!--职业-->
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-email">Eamil</label>
			                        	<input type="email" name="form-email" placeholder="邮箱" class="form-email form-control" id="form-email">
			                        </div><!--邮箱-->
								</form>
			                        <button id="submit" class="btn"  style="line-height: 20px;width:100%;background-color:green;color:white">注册</button>
			                        
			                        <div class="newlogin" style="padding: 15px  0 0 295px">
                   		       			<h5>已有账号？<a href="login.html">请登录</a></h5>	
                   		        	</div>

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
            <p class="footer">Copyright &copy; 2019.iLive All rights reserved. </p>
        </div>
    </footer>
    
    <!-- //footer -->
	<a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 0;"></span>To Top</a>
<script>
        $("#submit").click(function () {
            var username=document.getElementById("form-username").value;
            var password1=document.getElementById("form-password1").value;
            var password2=document.getElementById("form-password2").value;
            var sex=document.getElementById("form-sex").value;
            var occupation=document.getElementById("form-occupation").value;
            
            var age=document.getElementById("form-age").value;
            var email=document.getElementById("form-email").value;
            if(email.indexOf("@")==-1){
            	alert('邮箱不正确');
            }
            if(password1!=password2){
                alert('两次密码不一致！');
			}
			else if(username==""||password1==""||password2==""||sex==""||occupation==""){
                alert("请填写完整信息！");
			}
            else {
                $.ajax({
                    url: "/user/add",
                    dataType:"json",
                    data: {name:username, password: password2,sex:sex,majorId:occupation,age:age,eamil:email},
                    type: "POST",
                    success:function (result) {
                        if(result.result==false){
                            alert(result.msg);
                        }
                        else { window.location.href="/user/login";}
                    }
                });
            }
        })
	</script>
    </body>
</html>