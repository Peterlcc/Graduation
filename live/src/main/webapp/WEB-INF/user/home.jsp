<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>iLive|快速租房好帮手</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" /><!-- Bootstrap stylesheet -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" /><!-- stylesheet -->
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" /><!-- fontawesome -->  
<!-- meta tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="referrer" content="no-referrer" />
	<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //meta tags -->
<!--fonts-->
<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<!--//fonts-->
    <script src="js/jquery.min.js" type="text/javascript"></script>
	<script  type="text/javascript">
        function getJsonLength(json){
            var length = 0;
            for(var attr in json){
                length++;
            }
            return length;
            console.log(length);
        }
       
        
        function addDetail(result) {
      
        	var classDiv= $("#parenthouse").children("div");
            var divsPrice=document.getElementsByClassName("jm-item-title");
            var divsTitle=document.getElementsByClassName("agile-its-property-title");
            var divsSrc=document.getElementsByClassName("imgsrc");
            var spansId=document.getElementsByClassName("jm-item-id");
            
             for(var i=0;i<9;i++)
			{
				classDiv[i].style="display:block";
			} 
             if(getJsonLength(result.houses)<9)
            	{
            		for(var i=getJsonLength(result.houses);i<9;i++)
            				classDiv[i].style="display:none";
            	}
            	 
            for(var i = 0; i<getJsonLength(result.houses); i++){
       
                divsPrice[i].innerText='￥'+result.houses[i].price;
               // console.log(divsPrice[i]);
                divsTitle[i].innerText=result.houses[i].title;
                divsSrc[i].src=result.houses[i].imgs[0];
                //console.log(divsSrc[i].src);
                spansId[i].innerText=result.houses[i].id;
                //console.log(spansId[i].innerText);
//                console.log(getJsonLength(result)+'+'+divsSrc[i].src);
                if(divsSrc[i].src=="http://localhost:8080/undefined")
                	{
                		divsSrc[i].src="images/imgback.jpg";
                	}
            }
        }
	</script>
	<script type="text/javascript">
	function userselecta() {
    	var userSelectall="全部";
        userSelecta=this.innerHTML;
        $.ajax({
            type: "POST",
            url: "/house/listByRegion",
            dataType: "json",
            data:{region:userSelecta,start:1 },
            success: function(result){
            	//console.log("success!");
                addDetail(result);
            }
        })
    }
	function userselectb() {
    	//console.log("45353465");
    	var userSelectb="全部";
        userSelectb=this.innerHTML;
        //  console.log(userSelectb);
        $.ajax({
            type: "POST",
            url: "/house/listByPrice",
            dataType: "json",
            data:{interval:userSelectb,start:1},
            success: function(result){
                addDetail(result);
            }
        })
    }
	function userselectc() {
    	var userSelectc="全部";
        userSelectc=this.innerHTML;
      //  console.log(userSelectc);
        $.ajax({
            type: "POST",
            url: "/house/listByArea",
            dataType: "json",
            data:{interval:userSelectc,start:1},
            success: function(result){
            	//console.log(result);
                addDetail(result);
            }
        })
    }
	
	function userselectall() {
     
        $.ajax({
            type: "POST",
            url: "/house/listAll",
            dataType: "json",
            data:{pagestr:""},
            success: function(result){
            	//console.log(result);
                addDetail(result);
            }
        })
    }
	
	
	
/* 	function addinput(){
		  var inputpage=document.getElementById("inputPage").value;
		  (inputpage);
               /*  $(".zxf_pagediv a").on("click",addpage);  */
                /* $(".zxf_pagediv button").on("click",addinput);  */
	
	
	function addpage(){
    	var pageChangeTo=$(this).text();
    	//alert(pageChangeTo);
    	if(pageChangeTo=="确定"){pageChangeTo=document.getElementById("inputPage").value;}
    	//alert(pageChangeTo);
         $.ajax({
            type: "POST",
            url: "/house/listAll",
            dataType: "json",
            data:{pagestr:pageChangeTo},
            success: function(result){
            	console.log(result);
                addDetail(result);
                $(".zxf_pagediv a,button").on("click",addpage); 
                
            }
        }) 
    }
	
        window.onload=function () {
        	var aList=document.getElementById("dropdownLista").getElementsByTagName("a");
        	var bList=document.getElementById("dropdownListb").getElementsByTagName("a");
        	var cList=document.getElementById("dropdownListc").getElementsByTagName("a");
        	var allitem=document.getElementById("allitem");
     //       console.log(aList);
    			 allitem.onclick=userselectall;
    			 
              for(var i=0;i<aList.length;i++){
                 aList[i].onclick=userselecta;
              } 
              for(var i=0;i<bList.length;i++){
                  bList[i].onclick=userselectb;
               } 
              for(var i=0;i<cList.length;i++){
                  cList[i].onclick=userselectc;
               } 
          //   console.log(aList);
            $(function(){
                $.ajax({
                    type: "POST",
                    url: "/house/listAll",
                    dataType: "json",
                    data:{pagestr:""},
                    success: function(result){
                    	//console.log(result);
                    	if(result.error=="undefined"){
                    		alert("请登录！");
                    		refresh();
                    	}
                    	document.getElementById("getusername").innerText=result.username;
                    	 // alert(result.count);
                          $(".zxf_pagediv").createPage({
                            pageNum: result.count,
                            current: 1,
                            backfun: function(e) {
                             	
                                 //console.log(e);//回调
                             } 
                         });  
                      //    console.log(document.getElementsByClassName("zxf_pagediv"));
                        addDetail(result);  
                        $(".zxf_pagediv a,button").on("click",addpage); 
                    }
                })
            })
            
        }
        
        
	</script>

<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script><!-- Required-js -->
<script src="js/bootstrap.min.js"></script><!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!-- Include jQuery & Filterizr -->

    <!--<script src="js/jquery.filterizr.js" ></script>-->
    <script src="js/controls.js"></script>

    <!-- Kick off Filterizr -->
    <!--<script type="text/javascript">-->
        <!--$(function() {-->
            <!--//Initialize filterizr with default options-->
            <!--$('.filtr-container').filterizr();-->
        <!--});-->
    <!--/*</script>*/-->
	<!-- here stars scrolling icon -->
			<script type="text/javascript">
				$(document).ready(function() {

						var defaults = {
						containerID: 'toTop', // fading element id
						containerHoverID: 'toTopHover', // fading element hover id
						scrollSpeed: 1200,
						easingType: 'linear'
						};

										
//					$().UItoTop({ easingType: 'easeOutQuart' });
										
					});
			</script>
			<!-- start-smoth-scrolling -->
			<script type="text/javascript" src="js/move-top.js"></script>
			<script type="text/javascript" src="js/easing.js"></script>
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
					<h1><a  style="color: #00c5b5">iLive</a></h1>
				</div>	
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				  <ul class="nav navbar-nav">
					<li class="active"><a href="properties.html" >主页</a></li>
					
					<li><a id="getusername">xxx</a></li>
					<li><a >欢迎登录</a></li>
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
	<!-- breadcrumbs -->
	<div class="w3ls-inner-banner">
		<div class="container">
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- //breadcrumbs -->
	
	<!-- main-content -->
	<div class="main-content" style="padding: 30px">

		<!-- gallery -->
	<div class="gallery" id="gallery">
	<div class="container">
		<div class="gallery_gds">
			<ul id="dropdownList" class="simplefilter ">
                <li   id="allitem" data-filter="all">全部</li>
				<li  class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">区域 <b class="caret"></b></a>
					<ul id="dropdownLista" class="dropdown-menu">
						<li ><a >不限</a></li>
						<li ><a >和平</a></li>
						<li ><a >南开</a></li>
                        <li ><a >河西</a></li>
                        <li ><a >河北</a></li>
                        <li ><a >河东</a></li>
                        <li ><a >红桥</a></li>
                        <li ><a >西青</a></li>
                        <li ><a >北辰</a></li>
                        <li ><a >东丽</a></li>
                        <li ><a >津南</a></li>
                        <li ><a >塘沽</a></li>
                        <li ><a >开发区</a></li>
                        <li ><a >武清</a></li>
                        <li ><a >滨海新区</a></li>
                        <li ><a >宝坻</a></li>
                        <li ><a >蓟州</a></li>
					</ul>
				</li><!--区域-->
                <li class="dropdown" >
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">租金 <b class="caret"></b></a>
					<ul id="dropdownListb" class="dropdown-menu">
                        <li ><a >不限</a></li>
                        <li ><a >500元以下</a></li>
                        <li ><a>500-800元</a></li>
                        <li ><a >800-1500元</a></li>
                        <li ><a >1500-2000元</a></li>
                        <li ><a >2000-3000元</a></li>
                        <li ><a >3000-5000元</a></li>
                        <li ><a >5000元以上</a></li>
					</ul>
				</li><!--租金-->
                <li class="dropdown" >
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">面积 <b class="caret"></b></a>
                    <ul id="dropdownListc" class="dropdown-menu">
                        <li ><a >不限</a></li>
                        <li ><a >50平以下</a></li>
                        <li ><a >50-70平</a></li>
                        <li ><a >70-90平</a></li>
                        <li ><a >90-110平</a></li>
                        <li ><a >110-130平</a></li>
                        <li ><a >130-150平</a></li>
                        <li ><a>150平以上</a></li>
                    </ul>
				</li><!--面积-->

            </ul>   
            <div class="filtr-container " id="parenthouse" style="padding: 0px; position: relative; height: 858px;">
				<div class="col-md-4 col-ms-6 jm-item first filtr-item"  style="opacity: 1; transform: scale(1) translate3d(0px, 0px, 0px); backface-visibility: hidden; perspective: 1000px; transform-style: preserve-3d; position: absolute; transition: all 0.5s ease-out 0ms;">
					<div class="jm-item-wrapper" >
						<span class="jm-item-id" style="display: none">id</span>
						<div class="jm-item-image" >
							<img class="imgsrc" src="images/imgback.jpg" alt="property" />
							<span class="jm-item-overlay"> </span>
							<div class="jm-item-button"><a>详细内容</a></div>
						</div>
						<div class="jm-item-title">$250</div>
						<a class="agile-its-property-title" >Property 1</a>
						</div>
				</div>
				<div class="col-md-4 col-ms-6 jm-item first filtr-item"  style="opacity: 1; transform: scale(1) translate3d(380px, 0px, 0px); backface-visibility: hidden; perspective: 1000px; transform-style: preserve-3d; position: absolute; transition: all 0.5s ease-out 0ms;">
					<div class="jm-item-wrapper">
						<span class="jm-item-id" style="display: none">id</span>
						<div class="jm-item-image">
							<img class="imgsrc" src="images/imgback.jpg" alt="property" />
							<span class="jm-item-overlay"> </span>
							<div class="jm-item-button"><a >详细内容</a></div>
						</div>
						<div class="jm-item-title">$380</div>
						<a class="agile-its-property-title" >Property 2</a>
                    </div>

				</div>
				<div class="col-md-4 col-ms-6 jm-item first filtr-item"  style="opacity: 1; transform: scale(1) translate3d(760px, 0px, 0px); backface-visibility: hidden; perspective: 1000px; transform-style: preserve-3d; position: absolute; transition: all 0.5s ease-out 0ms;">
					<div class="jm-item-wrapper">
						<span class="jm-item-id" style="display: none">id</span>
						<div class="jm-item-image">
							<img class="imgsrc" src="images/imgback.jpg" alt="property" />
							<span class="jm-item-overlay"> </span>
							<div class="jm-item-button"><a>详细内容</a></div>
						</div>
						<div class="jm-item-title">$410</div>
						<a class="agile-its-property-title">Property 3</a>
                    </div>
				</div>
				<div class="col-md-4 col-ms-6 jm-item first filtr-item"  style="opacity: 1; transform: scale(1) translate3d(0px, 286px, 0px); backface-visibility: hidden; perspective: 1000px; transform-style: preserve-3d; position: absolute; transition: all 0.5s ease-out 0ms;">
					<div class="jm-item-wrapper">
						<span class="jm-item-id" style="display: none">id</span>
						<div class="jm-item-image">
							<img class="imgsrc" src="images/imgback.jpg" alt="property" />
							<span class="jm-item-overlay"> </span>
							<div class="jm-item-button"><a >详细内容</a></div>
						</div>
						<div class="jm-item-title">$580</div>
						<a class="agile-its-property-title">Property 4</a>
                    </div>
				</div>
				<div class="col-md-4 col-ms-6 jm-item first filtr-item"  style="opacity: 1; transform: scale(1) translate3d(380px, 286px, 0px); backface-visibility: hidden; perspective: 1000px; transform-style: preserve-3d; position: absolute; transition: all 0.5s ease-out 0ms;">
					<div class="jm-item-wrapper">
						<span class="jm-item-id" style="display: none">id</span>
						<div class="jm-item-image">
							<img class="imgsrc" src="images/imgback.jpg" alt="property" />
							<span class="jm-item-overlay"> </span>
							<div class="jm-item-button"><a>详细内容</a></div>
						</div>
						<div class="jm-item-title">$310</div>
						<a class="agile-its-property-title">Property 5</a>
					</div>
				</div>
				<div class="col-md-4 col-ms-6 jm-item first filtr-item"  style="opacity: 1; transform: scale(1) translate3d(760px, 286px, 0px); backface-visibility: hidden; perspective: 1000px; transform-style: preserve-3d; position: absolute; transition: all 0.5s ease-out 0ms;">
					<div class="jm-item-wrapper">
						<span class="jm-item-id" style="display: none">id</span>
						<div class="jm-item-image">
							<img class="imgsrc" src="images/imgback.jpg" alt="property" />
							<span class="jm-item-overlay"> </span>
							<div class="jm-item-button"><a >详细内容</a></div>
						</div>
						<div class="jm-item-title">$810</div>
						<a class="agile-its-property-title" >Property 6</a>
                    </div>
				</div>
				<div class="col-md-4 col-ms-6 jm-item first filtr-item"  style="opacity: 1; transform: scale(1) translate3d(0px, 572px, 0px); backface-visibility: hidden; perspective: 1000px; transform-style: preserve-3d; position: absolute; transition: all 0.5s ease-out 0ms;">
					<div class="jm-item-wrapper">
						<span class="jm-item-id" style="display: none">id</span>
						<div class="jm-item-image">
							<img class="imgsrc" src="images/imgback.jpg" alt="property" />
							<span class="jm-item-overlay"> </span>
							<div class="jm-item-button"><a >详细内容</a></div>
						</div>
						<div class="jm-item-title">$599</div>
						<a class="agile-its-property-title" >Property 7</a>
                    </div>
				</div>
				<div class="col-md-4 col-ms-6 jm-item first filtr-item"  style="opacity: 1; transform: scale(1) translate3d(380px, 572px, 0px); backface-visibility: hidden; perspective: 1000px; transform-style: preserve-3d; position: absolute; transition: all 0.5s ease-out 0ms;">
					<div class="jm-item-wrapper">
						<span class="jm-item-id" style="display: none">id</span>
						<div class="jm-item-image">
							<img class="imgsrc" src="images/imgback.jpg" alt="property" />
							<span class="jm-item-overlay"> </span>
							<div class="jm-item-button"><a >详细内容</a></div>
						</div>
						<div class="jm-item-title">$699</div>
						<a class="agile-its-property-title" >Property 8</a>
                    </div>
				</div>
				<div class="col-md-4 col-ms-6 jm-item first filtr-item"  style="opacity: 1; transform: scale(1) translate3d(760px, 572px, 0px); backface-visibility: hidden; perspective: 1000px; transform-style: preserve-3d; position: absolute; transition: all 0.5s ease-out 0ms;">
					<div class="jm-item-wrapper">
						<span  class="jm-item-id" style="display: none">id</span>
						<div class="jm-item-image">
							<img id="find" class="imgsrc" src="images/imgback.jpg" alt="property" />
							<span class="jm-item-overlay"> </span>
							<div class="jm-item-button" ><a >详细内容</a></div>
						</div>
						<div class="jm-item-title">$699</div>
						<a class="agile-its-property-title" >Property 9</a>
					</div>
				</div>
               <div class="clearfix"> </div>
            </div>


		</div>
	</div>


	</div>
	<!--//gallery-->

	</div>
<!-- //main-content -->
    <div class="zxf_pagediv" style="padding: 30px 0 10px 0"></div>
    <!-- footer -->
    <footer>
        <!-- footer-top -->
        <div class="footer-top">
            <div class="container">
                <div class="col-md-4 footer-top-left">
                    <h3><a >iLive</a></h3>
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
</body>
<script src="js/zxf_page.js" type="text/javascript"></script>
<script type="text/javascript">
  $(".jm-item-image").click(function () {
	  var urlNew = "property-details.html?id="+$(this).prev().text();//此处拼接内容
	  window.location.href = urlNew;
  })
  $(".agile-its-property-title").click(function () {
	  var urlNew = "property-details.html?id="+$(this).parent().children(":first").text();//此处拼接内容
	  window.location.href = urlNew;
  })
</script>
</html>
