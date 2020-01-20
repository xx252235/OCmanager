<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<table align="center" border="1" width="80%">
	<tr>
		<th>序号</th>
		<th>姓名</th>
		<th>性别</th>
		<th>生日</th>
		<th>电话</th>
		<th>邮箱</th>
		<th>爱好</th>
		<th>类型</th>
		<th>操作</th>
	</tr>
	
	<c:forEach var="c" items="${ page.beanList }" varStatus="status">
		<tr align="center">
			<td>${ status.count }</td>
			<td>${ c.username }</td>
			<td>${ c.gender }</td>
			<td>${ c.birthday }</td>
			<td>${ c.cellphone }</td>
			<td>${ c.email }</td>
			<td>${ c.love }</td>
			<td>${ c.type }</td>
			<td>
				<a href="${ pageContext.request.contextPath }/initupdate?id=${ c.id }">编辑</a>
				|
				<a href="${ pageContext.request.contextPath }/delete?id=${c.id}" onclick="return confirm('确定删除吗？')" >删除</a>
			</td>
		</tr>
	</c:forEach>
</table>


<center>
	第${ page.pageCode }页/共${ page.totalPage }页
	<a href="${ pageContext.request.contextPath }/listCustomerByPage?pc=1">首页</a>
	<%--如果当前页大于1 --%>
	<c:if test="${ page.pageCode > 1 }">
		<a href="${ pageContext.request.contextPath }/listCustomerByPage?pc=${page.pageCode - 1}">上一页</a>
	</c:if>
	
	
	<%--定义这些变量 --%>
	<c:choose>
		<c:when test="${ page.totalPage <= 10 }">
			<c:set var="begin" value="1" ></c:set>
			<c:set var="end" value="${ page.totalPage }"></c:set>
		</c:when>
		<c:otherwise>
			<c:set var="begin" value="${ page.pageCode - 5 }" ></c:set>
			<c:set var="end" value="${ page.pageCode + 4 }"></c:set>
			
			<%-- 头溢出 --%>
			<c:if test="${ begin < 1 }">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value="10"></c:set>
			</c:if>
			
			<c:if test="${ end > page.totalPage }">
				<c:set var="begin" value="${ page.totalPage - 9}"></c:set>
				<c:set var="end" value="${ page.totalPage }"></c:set>
			</c:if>
		</c:otherwise>
	</c:choose>
	
	
	<%-- 用循环 --%>
	<c:forEach var = "i" begin="${ begin }" end="${ end }">
		<a href="${ pageContext.request.contextPath }/listCustomerByPage?pc=${i}" >[${ i }]</a>
	</c:forEach>
	
	
	<c:if test="${ page.pageCode < page.totalPage }">
		<a href="${ pageContext.request.contextPath }/listCustomerByPage?pc=${page.pageCode + 1}">下一页</a>
	</c:if>
	<a href="${ pageContext.request.contextPath }/listCustomerByPage?pc=${page.totalPage}">尾页</a>
</center>

</body>
</html>











