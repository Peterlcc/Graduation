<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page 
import="com.peter.bean.House"
import="java.util.List"
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>ilive|房屋详情</title>
    <link href="../../resource/user/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" /><!-- Bootstrap stylesheet -->
    <link href="../../resource/user/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" /><!-- fontawesome -->
    <link href="../../resource/user/css/style.css" rel="stylesheet" type="text/css" media="all" /><!-- stylesheet -->
    <link href="../../resource/user/css/detail.css" rel="stylesheet" type="text/css"/><!-- stylesheet -->
    <!-- meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <meta name="referrer" content="no-referrer" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //meta tags -->
    <!--fonts-->
    <link href="http://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <!--//fonts-->
    <script type="text/javascript" src="../../resource/user/js/jquery-2.1.4.min.js"></script><!-- Required-js -->
    <script src="../../resource/user/js/bootstrap.min.js"></script><!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script type="text/javascript" src="../../resource/user/js/numscroller-1.0.js"></script>
    <!-- here stars scrolling icon -->
    <script type="text/javascript">
        $(document).ready(function() {
            $().UItoTop({ easingType: 'easeOutQuart' });

        });
    </script>
    <!-- start-smoth-scrolling -->
    <script type="text/javascript" src="../../resource/user/js/move-top.js"></script>
    <script type="text/javascript" src="../../resource/user/js/easing.js"></script>
    <script type="text/javascript" src="../../resource/user/js/house-collect.js"></script>
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
    <script type="text/javascript">
    function Tel(){
    	document.getElementById("dealer-phone").style.display="inline";
    }
    </script>
	<script type="text/javascript">
		window.onload=function(){
			setCollect();
		}
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
					<h1><a  style="color: #00c5b5">iLive</a></h1>
				</div>	
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				  <ul class="nav navbar-nav">
				  	<li id="userId" style="display: none" value="${user.id}">${user.id}</li>
				  	<li class="active"><a href="/house/home" >主页</a></li>
					<li><a id="getusername">${user.name}</a></li>
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
<!--**************************************************************************************************************************************-->
<!-- breadcrumbs -->
<div class="w3ls-inner-banner">
    <div class="container">
    <!-- <div id="return" style="display: inline;float: left"  onclick="javascript:history.back(-1);" ><a href="#">&lt;&lt;返回上一页</a></div> -->
        <label></label>
        <div class="clearfix"></div>
    </div>
</div>
<!-- //breadcrumbs -->

<!-- main-content -->
<div class="main-content">
    <!-- property-details -->
    <div class="agileits-property-details"><!--房屋细节-->
        
        <div class="container">
            <div class="col-md-6 w3ls-property-images" ><!--图片-->
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel"><!--写入图片地址 -->
						<%
                        	 House house=(House)request.getAttribute("house");
                    		List<String> imgs=house.getImgUrls();
                        %>
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                    <%
                    out.print("<li data-target='#carousel-example-generic' data-slide-to='0' class='active'></li>");
            		for(int i=1;i<imgs.size();i++)
            		{
            			out.print("<li data-target='#carousel-example-generic' data-slide-to='1' class=''></li>");
            		} 
                    %>
                    </ol>

                    <!-- Wrapper for slides 传入图片的地址 -->
                    <div id="getPics" class="carousel-inner" >
                        <%
                        out.print("<div class='item active'><img class='img-responsive' src='"+imgs.get(0)+"' alt='"+house.getTitle()+"' style='height: 490px;'/></div>");
                		for(int i=1;i<imgs.size();i++)
                		{
                			out.print("<div class='item'><img class='img-responsive' src='"+imgs.get(i)+"' alt='"+house.getTitle()+"' style='height: 490px;'/></div>");
                		} 
                        %>
                    </div>

                    <!-- Controls 左右滑动-->
                    <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>
            </div>
            <div class="col-md-6 ins-details"><!--具体的介绍-->

                <div class="ins-name" style="height: 10px;"><!--title/price-->
                    <h3 style="float:left" id="housetitle">${house.title}  <!--标题title--></h3>
                    <span id="houseid" hidden="hidden">${house.id}</span>
                    <button style="float:right" id="focus" style="background-color: gainsboro" onclick="userCollect();">收藏</button>
                </div>
                <div style="height:30px;float:left;color: red; font-size: 30px;margin:0 0 15px 0;" id="houseprice">${house.price}元</div><!--价格price-->
                <div>
                    <table  class="table table-bordered table-striped" >
                        <tr style="height: 30px"><!--area/type-->
                            <td width="100px"  height="20px" align="right">面积:</td>
                            <td id="housearea" width="80px" height="20px">${house.area}</td>
                            <td width="100px" align="right" height="20px">户型:</td>
                            <td  id="housetype" height="20px">${house.roomType}</td>
                        </tr>
                        <tr ><!--floors/floor-->
                        <%
                        String floor=house.getFloor();
                        String[] fmsg=floor.split("/");
                        %>
                            <td width="100px" align="right">楼房总高:</td>
                            <td id="housefloors"><%=fmsg[1] %></td>
                            <td width="100px" align="right">楼层:</td>
                            <td id="housefloor"><%=fmsg[0] %></td>
                        </tr>
                        <tr ><!--village-->
                        <%
                        Date releaseTime=house.getReleaseTime();
                        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                        String rtime=format.format(releaseTime);
                        %>
                            <td width="100px" align="right">发布时间:</td>
                            <td id="releaseTime" colspan="3"><%=rtime %></td>
                        </tr>
                        <tr><!--region/street-->
                            <td width="100px" align="right">具体位置:</td>
                            <td colspan="3"><span id="position" style="color: blue;"><%=house.getCity()+"-"+house.getAreaCity()+"-"+house.getStreet() %></span></td>
                        </tr>
                        <tr><!--subway-->
                            <td width="100px" align="right">租期:</td>
                            <td id="rentTime" colspan="3">${house.rentTime }</td>
                        </tr>
                        <tr><!--direction-->
                            <td width="100px" align="right">朝向:</td>
                            <td id="direction" colspan="3">${house.direction }</td>
                        </tr>
                        <tr><!--rentType-->
                            <td width="100px" align="right">出租方式:</td>
                            <td colspan="3"><span id="houserenttype" class=" badge badge-danger">${house.rentType }</span></td>
                        </tr>
                        <tr><!--status-->
                            <td width="100px" align="right">看房:</td>
                            <td id="housestatus" colspan="3">${house.lookType }</td>
                        </tr>
                        <tr><!--warmType-->
                        <%
                        String tags=house.getTags();
                        String[] tagsSplit=tags.split("%%");
                        %>
                            <td width="100px" align="right">标签:</td>
                            <td id="tags" colspan="3"><div>
                            <%
                            for(String tag:tagsSplit)
                            	out.print("<span class=' badge badge-danger'>"+tag+"</span>");
                            %>
                            <div></td>
                        </tr>
                        <tr><!--payType-->
                            <td width="100px" align="right">支付方式:</td>
                            <td id="housepaytype" colspan="3">${house.payType }</td>
                        </tr>
                        <tr><!--time-->
                            <td width="100px" align="right" >公司:</td>
                            <td id="housetime" class=" alert alert-success">${house.dealerCompany }</td>
                            <!--number-->
                            <td width="80px" align="right" >出租人:</td>
                            <td id="housenumber" class=" alert alert-warning">${house.dealerName }</td>
                        </tr>
                        <tr><!--time-->
                            <td width="100px" align="right" >浏览数:</td>
                            <td id="housetime" class=" alert alert-success">${house.logNum }</td>
                            <!--number-->
                            <td width="80px" align="right" >收藏数:</td>
                            <td id="housenumber" class=" alert alert-warning">${house.collectNum }</td>
                        </tr>
                    </table>
                </div>
			<button class="dealer-btn" style="float:left;width:100px;display: inline;" id="Tel" style="background-color: gainsboro" onclick="Tel();">查看电话</button> &nbsp;&nbsp;&nbsp;
			<span id="dealer-phone" class="telephone" style="display: none;" >${house.dealerPhone }</span>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <!-- property-details -->

    <!-- related-properties -->
    <div  id="relative" class="wthree-related-properties text-center"><!--相关推荐-->
        <div class="container">
            <h3 class="w3l-heading">好房为你推荐</h3>
            <c:forEach items="${sessionScope.user.recommands }" var="recommand">
            	<div class="col-md-3 w3-related-property"><!--引入image/title-->
	            	<span class="jm-item-id" style="display: none">${recommand.house.id}</span>
	                <a ><figure><img class="img-responsive1"  style="width:200px;height:150px;" src="${recommand.house.imgUrls[0]}" alt="" /></figure></a>
	                <a class="recom">${recommand.house.title}</a>
	            </div>
            </c:forEach>
            <div class="clearfix"></div>
        </div>
    </div>
    <!-- //related-properties -->
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
                    <li><a href="/house/home"><i class="fa fa-long-arrow-right" aria-hidden="true"></i>主页</a></li>
                    <li><a href="about.html"><i class="fa fa-long-arrow-right" aria-hidden="true"></i>关于我们</a></li>
                    <li><a href="/user/login"><i class="fa fa-long-arrow-right" aria-hidden="true"></i>登录</a></li>
                    <li><a href="/user/register"><i class="fa fa-long-arrow-right" aria-hidden="true"></i>注册</a></li>
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
<script>

$(".img-responsive1").click(function () {
	  var urlNew = "/house/detail?id="+$(this).parent().parent().prev().text();//此处拼接内容
	  window.location.href = urlNew;
})
$(".recom").click(function () {
	  var urlNew = "/house/detail?id="+$(this).parent().children(":first").text();//此处拼接内容
	  window.location.href = urlNew;
})
</script>
</body>

</html>
