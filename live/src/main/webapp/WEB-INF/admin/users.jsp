<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户列表</title>
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
<!-- icon图标 -->
<link rel="icon" href="../../resource/user/images/logoilive.png" type="image/png">
<link rel="stylesheet" href="../../resource/user/css/page.css" type="text/css">
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

</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="inner-content">
				<!--outter-wp-->
				<div class="outter-wp">
					<!--//sub-heard-part-->
					<div class="graph-visual tables-main">
						<h3 class="inner-tittle two">用户信息展示</h3>
						<div class="graph">
							<div class="tables">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>id</th>
											<th>姓名</th>
											<th>性别</th>
											<th>年龄</th>
											<th>邮箱</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pageBean.beanList }" var="bean">
											<tr>
												<th scope="row">${bean.id }</th>
												<td>${bean.name }</td>
												<td>${bean.sex }</td>
												<td>${bean.age }</td>
												<td>${bean.email }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
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
										<li><a
											href="${pageBean.url }&pc=${pageBean.currentPage+1 }">下一页</a></li>
									</c:if>
									<li><a href="${pageBean.url }&pc=${pageBean.totalPage }">尾页</a></li>
								</ul>
							</div>
							<!-- 分页结束 -->
						</div>
					</div>
					<!--//graph-visual-->
				</div>
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
					<li><a class="tooltips" href="/admin/edit"><span>修改密码</span><i
							class="lnr lnr-cog"></i></a></li>
					<li><a class="tooltips" href="/admin/logout"><span>退出登录</span><i
							class="lnr lnr-power-switch"></i></a></li>
				</ul>
			</div>
			<!--//down-->
			<div class="menu">
				<ul id="menu">
					<li><a href="/admin/analyze"><i class="fa fa-table"></i> <span>分析首页</span></a></li>
				<li><a href="/admin/simpleAnalyze#house-chart"><i
						class="fa fa-table"></i> <span>房屋单表分析</span></a></li>
				<li><a href="/admin/simpleAnalyze#user-chart"><i
						class="fa fa-table"></i> <span>用户单表分析</span></a></li>
				<li><a href="/admin/users"><i class="fa fa-file-text-o"></i>
						<span>用户明细</span></a></li>
				<li><a href="/admin/houses"><i class="fa fa-file-text-o"></i>
						<span>房屋明细</span></a></li>
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