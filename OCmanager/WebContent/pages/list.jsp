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

<form action="${ pageContext.request.contextPath }/selectByNameAndType" method="post">
	<table align="center">
		<tr>
			<td>
				姓名：<input type="text" name="username" value="${ param.username }"/>
			</td>
			<td>
				类别：
				<select name="type">
					
					<option value="">--请选择--</option>
					<option value="青铜会员" <c:if test="${param.type eq '青铜会员'  }">selected</c:if>  >青铜会员</option>
					<option value="白银会员" <c:if test="${param.type eq '白银会员'  }">selected</c:if>  >白银会员</option>
					<option value="黄金会员" <c:if test="${param.type eq '黄金会员'  }">selected</c:if> >黄金会员</option>
					<option value="钻石会员" <c:if test="${param.type eq '钻石会员'  }">selected</c:if> >钻石会员</option>
				</select>
			</td>
			<td>
				<input type="submit" value="查询" />
			</td>
		</tr>
	</table>
</form>

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
	
	<c:forEach var="c" items="${ requestScope.cList }" varStatus="status">
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

</body>
</html>











