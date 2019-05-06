<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>分页</title>
<style type="text/css">
.center {
	/*设置div为水平居中显示*/
	text-align: center;
	/*设置div里面的内容为居中显示*/
	line-height: 200px;
	/*设置div里面的内容向下200px*/
	margin-top: 100px;
	/*设置div离顶部距离为100px*/
	box-shadow: 10px 5px 6px 5px black;
}
.center-table{
width: 70%;
border: 1;
align: center;
}
</style>
</head>
<body>
	<table class="center-table">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>url</th>
			<th>letter</th>
			<th>jobType</th>
			<th>province</th>
		</tr>
		<c:forEach items="${pageBean.beanList}" var="bean">
			<tr>
				<td>${bean.id}</td>
				<td>${bean.name}</td>
				<td>${bean.url}</td>
				<td>${bean.letter}</td>
				<td>${bean.jobType}</td>
				<td>${bean.province}</td>
			</tr>
		</c:forEach>

	</table>
	<br>
	<div class="center">
		第${pageBean.currentPage }页/共${pageBean.totalPage }页
		<a href="/city/getCityList?currentPage=1&pageSize=10">首页</a>
		<c:if test="${pageBean.currentPage>1 }">
			<a href="/city/getCityList?currentPage=${pageBean.currentPage-1 }&pageSize=10">上一页</a>
		</c:if>
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
		
		<c:forEach var="i" begin="${begin }" end="${end }">
			<c:choose>
				<c:when test="${i eq pageBean.currentPage}">
					[${i }]
				</c:when>
				<c:otherwise>
					
					<a href="/city/getCityList?currentPage=${i }&pageSize=10">[${i }]</a>
				</c:otherwise>
			</c:choose>
		
		</c:forEach>
		
		<c:if test="${pageBean.currentPage<pageBean.totalPage }">
			<a href="/city/getCityList?currentPage=${pageBean.currentPage+1 }&pageSize=10">下一页</a>
		</c:if>
		<a href="/city/getCityList?currentPage=${pageBean.totalPage }&pageSize=10">尾页</a>
	</div>
</body>
</html>