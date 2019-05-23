<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>Error</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="../../resource/error/css/bootstrap.css">
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="../../resource/error/css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- icon图标 -->
<link rel="icon" href="../../resource/user/images/logoilive.png" type="image/png">
<link href='http://fonts.useso.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="../../resource/error/css/font.css" type="text/css"/>
<link href="../../resource/error/css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
</head>
<body class="error-body">
		<div class="agile-signup">	
		<center><h5>错误信息：${errormsg}</h5></center>
			
			<div class="error-page">
				<img src="../../resource/admin/images/error.png" alt="">
			</div>
			
			<div class="go-back">
				<a href="/house/ilive">Back To Home</a>
			</div>
			
			<!-- footer -->
			<div class="copyright">
				<p>&copy; 2019.Peter All rights reserved.</p>
			</div>
			<!-- //footer -->
		</div>
	
</body>
</html>
