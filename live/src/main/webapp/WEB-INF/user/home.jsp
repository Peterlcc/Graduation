<%@page import="java.util.TreeMap"%>
<%@page import="net.bytebuddy.asm.Advice.This"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>iLive|快速租房好帮手</title>
	<link href="../../resource/user/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" /><!-- Bootstrap stylesheet -->
	<link href="../../resource/user/css/style.css" rel="stylesheet" type="text/css" media="all" /><!-- stylesheet -->
	<link href="../../resource/user/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" /><!-- fontawesome -->  
	<!-- meta tags -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="referrer" content="no-referrer" />
	<meta name="keywords" content="" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!--fonts-->
	<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
	<link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
	<!--//fonts-->
    <script src="../../resource/user/js/jquery.min.js" type="text/javascript"></script>
    <!-- Include jQuery & Filterizr -->
	<script type="text/javascript" src="../../resource/user/js/jquery-2.1.4.min.js"></script><!-- Required-js -->
	<script src="../../resource/user/js/bootstrap.min.js"></script><!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

    <script src="../../resource/user/js/controls.js"></script>
	<!-- 页面显示的初始化 -->
	<!-- //here ends scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear'
				};				
			});
	</script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
			});
		});
	</script>
	
	<!-- start-smoth-scrolling -->
	<script type="text/javascript" src="../../resource/user/js/move-top.js"></script>
	<script type="text/javascript" src="../../resource/user/js/easing.js"></script>
	<!-- start-smoth-scrolling -->
	
	<!-- 自定义的分页的css样式引用 -->
	<link rel="stylesheet" href="../../resource/user/css/page.css" type="text/css">
	<!-- 自定义的选择框的css样式引用 -->
	<link rel="stylesheet" href="../../resource/user/css/conditon-select.css" type="text/css">
	
	<!-- 级联选择框 -->
	<script type="text/javascript" src="../../resource/user/js/house-select.js"></script>
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
					<h1><a  style="color: #00c5b5" href="/house/ilive">iLive</a></h1>
				</div>	
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				  <ul class="nav navbar-nav">
					<li id="userId" style="display: none" value="${user.id}">${user.id}</li>
					<li ><a href="/house/ilive">Home</a></li>
					<li class="active"><a href="/house/home">租房</a></li>
					<li class="dropdown">
					  <a href="#" class="dropdown-toggle" data-toggle="dropdown">${user.name} <b class="caret"></b></a>
					  <ul class="dropdown-menu">
						<li><a href="/user/detail">个人信息</a></li>
						<li><a href="/user/logout">退出</a></li>
					  </ul>
					</li>
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
	<div class="gallery" id="gallery" style="padding:0px">
	<div class="container">
		<div class="gallery_gds">
		<form action="/house/home" method="get" style="width:1125px">
			<h5 class="select-title" >区域</h5>
			<c:if test="${not empty houseQueryVo.house }">
					<c:if test="${not empty houseQueryVo.house.areaCity}">
						<c:set var="areaStr" value="${houseQueryVo.house.areaCity}"></c:set>
					</c:if>
			</c:if>
			<select class="condition-select" onchange="areaSearch(this);" id="areaSelect" name="area" data-selector>
				<option value="">请选择</option>
				<c:forEach items="${city.areas}" var="area">
					<c:choose>
						<c:when test="${area.name eq areaStr}">
							<option class="area" selected="selected" value="${area.name }">${area.name }</option>
						</c:when>
						<c:otherwise>
							<option class="area" value="${area.name }">${area.name }</option>
						</c:otherwise>
					</c:choose>
					
				</c:forEach>
			</select>
			
			<h5 class="select-title">街道</h5>
			<c:if test="${not empty houseQueryVo.house }">
					<c:if test="${not empty houseQueryVo.house.street}">
						<c:set var="streetStr" value="${houseQueryVo.house.street}"></c:set>
					</c:if>
			</c:if>
			<select class="condition-select" id="streetSelect" name="street" data-selector>
				<option value="">请选择</option>
				<c:if test="${not empty streetStr}">
					<option class="street" selected="selected" value="${streetStr }">${streetStr }</option>
				</c:if>
			</select>
			
			<h5 class="select-title">价位</h5>
			<%
			java.util.Map<String, String> priceStrs=new TreeMap<>();
			priceStrs.put("0-500", "500元以下");
			priceStrs.put("500-1000", "500-1000元");
			priceStrs.put("1000-2000", "1000-2000元");
			priceStrs.put("2000-3000", "2000-3000元");
			priceStrs.put("3000-4000", "3000-4000元");
			priceStrs.put("4000-5000", "4000-5000元");
			priceStrs.put("5000", "5000元以上");
			%>
			<select class="condition-select" id=priceSelect name="price" data-selector>
				<option value="">请选择</option>
				<%
				String priceStr=(String)request.getAttribute("priceStr");
				for(String key:priceStrs.keySet())
				{
					out.print("<option class='price' "+(key.equals(priceStr)?"selected='selected'":"")+" value="+key+">"+priceStrs.get(key)+"</option>");
				} %>
			</select>
			<input id="search" onclick="search();" class="submit-select" type="submit" style="margin:10px 0px 10px 50px" value="查找">
		</form>
            <div class="filtr-container " id="parenthouse" style="padding: 0px; position: relative; height: 858px;">
            <%
            int[] x=new int[]{0,380,760,0,380,760,0,380,760};
            int[] y=new int[]{0,0,0,286,286,286,572,572,572};
            int[] z=new int[]{0,0,0,0,0,0,0,0,0};
            int scaleIndex=0;
            %>
				<c:forEach items="${houseQueryVo.pageBean.beanList}" var="bean">
					<div class="col-md-4 col-ms-6 jm-item first filtr-item"  style="opacity: 1; transform: scale(1) translate3d(<%=x[scaleIndex] %>px, <%=y[scaleIndex] %>px, <%=z[scaleIndex] %>px); backface-visibility: hidden; perspective: 1000px; transform-style: preserve-3d; position: absolute; transition: all 0.5s ease-out 0ms;">
						<div class="jm-item-wrapper" >
							<span id="hosueId" class="jm-item-id" style="display: none;">${bean.id}</span>
							<div class="jm-item-image" >
								<c:choose>
									<c:when test="${fn:length(bean.title) gt 15 }">
										<c:set var="houseTitle" value="${fn:substring(bean.title,0,12)}..."></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="houseTitle" value="${bean.title}"></c:set>
									</c:otherwise>
								</c:choose>
								<img class="imgsrc" src="${bean.imgUrls[0] }" alt="${houseTitle}"  onerror="this.onerror='';src='../../resource/user/images/imgback.jpg'"/>
								<span class="jm-item-overlay"> </span>
								<div class="jm-item-button"><a>详细内容</a></div>
							</div>
							<div class="jm-item-title">￥${bean.price }</div>
							<a class="agile-its-property-title" >${houseTitle}</a>
						</div>
					</div>
					<%scaleIndex++; %> 
				</c:forEach>
               <div class="clearfix"> </div>
            </div>
		</div>
	</div>


	</div>
	<!--//gallery-->

	</div>
<!-- //main-content -->
	<!-- 分页开始 -->
    <div class="center">
    	<ul class="pagination">
    	  <li><h5>第${houseQueryVo.pageBean.currentPage }页/共${houseQueryVo.pageBean.totalPage }页</h5></li>
		  <li><a href="${houseQueryVo.pageBean.url }&pc=1">首页</a></li>
		  <li>
			<c:if test="${houseQueryVo.pageBean.currentPage>1 }">
				<a href="${houseQueryVo.pageBean.url }&pc=${houseQueryVo.pageBean.currentPage-1 }">上一页</a>
			</c:if>
		  </li>
		  <!-- begin和end 的设置 -->
		  <c:choose>
			<c:when test="${houseQueryVo.pageBean.totalPage<10 }">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value="${houseQueryVo.pageBean.totalPage}"></c:set>
			</c:when>
			<c:otherwise>
				<c:set var="begin" value="${houseQueryVo.pageBean.currentPage-5 }"></c:set>
				<c:set var="end" value="${houseQueryVo.pageBean.currentPage+4 }"></c:set>
				
				<c:if test="${begin<1 }">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="10"></c:set>
				</c:if>
				
				<c:if test="${end>houseQueryVo.pageBean.totalPage }">
					<c:set var="begin" value="${houseQueryVo.pageBean.totalPage-9 }"></c:set>
					<c:set var="end" value="${houseQueryVo.pageBean.totalPage}"></c:set>
				</c:if>
			</c:otherwise>
		</c:choose>
		<!-- 循环打印页标 -->
		<c:forEach var="i" begin="${begin }" end="${end }">
			<c:choose>
				<c:when test="${i eq houseQueryVo.pageBean.currentPage}">
					<li><a class="disable" href="javascript:void(0)">${i }</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${houseQueryVo.pageBean.url }&pc=${i }">${i }</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${houseQueryVo.pageBean.currentPage<houseQueryVo.pageBean.totalPage }">
			<li><a href="${houseQueryVo.pageBean.url }&pc=${houseQueryVo.pageBean.currentPage+1 }">下一页</a></li>
		</c:if>
		<li><a href="${houseQueryVo.pageBean.url }&pc=${houseQueryVo.pageBean.totalPage }">尾页</a></li>
		</ul>
    </div>
    <!-- 分页结束 -->
    
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
            <p class="footer">Copyright &copy; 2018.iLive All rights reserved. </p>
        </div>
    </footer>
    <!-- //footer -->
</body>

<!-- log的收集 -->
<script type="text/javascript" src="../../resource/user/js/house-log.js"></script>

<!-- 每一项的点击事件 -->
<script type="text/javascript">
   $(".jm-item-image").click(function () {
	  var houseId=$(this).prev().text();
	  houseLog(houseId);
	  var urlNew = "/house/detail?id="+houseId;//此处拼接内容
	  window.location.href = urlNew;
  })
  $(".agile-its-property-title").click(function () {
	  var houseId=$(this).parent().children(":first").text();
	  houseLog(houseId);
	  var urlNew = "/house/detail?id="+houseId;//此处拼接内容
	  window.location.href = urlNew;
  }) 
</script>
</html>
