<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String contract_id = request.getParameter("contract_id");
	String content_id = request.getParameter("content_id");
	System.out.println(id+"(((((((((((((())))))))))))))");

%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="${ pageContext.request.contextPath }/listContent" method="post">
	
	<!-- 隐藏域 -->
	<input type="hidden" name="content_id" value="${ c.content_id }" />

	<table align="center" border="1" width="600" cellpadding="10">
		<tr>
			<td>合同id</td>
			<td>
				<input type="text" name="relativeid" value="${c.relativeid}" readonly="readonly" />
			</td>
		</tr>
		<tr>
			<td>合同内容</td>
			<td>
				<input type="text" name="contract_con" value="${c.contract_con}" readonly="readonly" />
			</td>
		</tr>
		<tr>
			<td>规格型号</td>
			<td>
				<input type="text" name="style"  value="${c.style}" readonly="readonly" />
			</td>
		</tr>
		<tr>
			<td>单位</td>
			<td>
				<input type="text" name="unit" value="${c.unit}" readonly="readonly" />
			</td>
		</tr>
		<tr>
			<td>单价</td>
			<td>
				<input type="number" name="price" value="${c.price}"  readonly="readonly" οnkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
			</td>
		</tr>
		<tr>
			<td>录入时间</td>
			<td>
				<input type="text" name="inputdate" value="${c.inputdate}" readonly="readonly" />
			</td>
		</tr>
		<tr>
			<td>更新时间</td>
			<td>
				<input type="text" name="updatedate" value="${c.updatedate}" readonly="readonly" />
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="返回" />
			</td>
		</tr>
	</table>
</form>

</body>
</html>