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

<form action="${ pageContext.request.contextPath }/listConditionByPage" method="get">
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

<table align="center" border="1" width="100%">
	<tr>
		<th>序号</th>
		<th>分公司</th>
		<th>项目名称</th>
		<th>合同类别</th>
		<th>合同另一方</th>
		<th>是否分劈</th>
		<th>合同金额</th>
		<th>签约日期</th>
		<th>工期起日</th>
		<th>工期止日</th>
		<th>审批日期</th>
		<th>公司存档情况</th>
		<th>招投标情况</th>
		<th>是否超预控</th>
		<th>超预控金额（万元）</th>
		<th>备注</th>
	</tr>
	
	<c:forEach var="c" items="${ page.beanList }" varStatus="status">
		<tr align="center">
			<td>${ status.count }</td>
			<td>${ c.branchorg }</td>
			<td>${ c.objectname }</td>
			<td>${ c.contracttype }</td>
			<td>${ c.otherside }</td>
			<td>${ c.ispartition }</td>
			<td>${ c.contractsum }</td>
			<td>${ c.signdate }</td>
			<td>${ c.workdatefrom }</td>
			<td>${ c.workdateto }</td>
			<td>${ c.approvedate }</td>
			<td>${ c.issave }</td>
			<td>${ c.bidstate }</td>
			<td>${ c.isover }</td>
			<td>${ c.oversum }</td>
			<td>${ c.remark }</td>
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
	<%--  /customer/listConditionByPage?username=美美&type=黄金会员&pc=1 --%>
	<a href="${ page.url }&pc=1">首页</a>
	<%--如果当前页大于1 --%>
	<c:if test="${ page.pageCode > 1 }">
		<a href="${ page.url }&pc=${page.pageCode - 1}">上一页</a>
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
		<a href="${ page.url }&pc=${i}" >[${ i }]</a>
	</c:forEach>
	
	
	<c:if test="${ page.pageCode < page.totalPage }">
		<a href="${ page.url }&pc=${page.pageCode + 1}">下一页</a>
	</c:if>
	<a href="${ page.url }&pc=${page.totalPage}">尾页</a>
</center>

</body>
</html>











