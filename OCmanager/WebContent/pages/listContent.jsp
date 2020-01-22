<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String contract_id = request.getParameter("contract_id");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="css/common.css" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="form1" action="" method="post">
	<table align="left">
		<tr>
			<td>
				项目名称：<input type="text" name="objectname" value="${ param.objectname }"/>
			</td>
			<td>
				合同类别：
				<select name="contracttype">
					
					<option value="">--请选择--</option>
					<option value="专业合同" <c:if test="${ param.contracttype eq '专业合同' }">selected</c:if>>专业合同</option>
					<option value="劳务合同" <c:if test="${ param.contracttype eq '劳务合同' }">selected</c:if>>劳务合同</option>
					<option value="机械合同" <c:if test="${ param.contracttype eq '机械合同' }">selected</c:if>>机械合同</option>
					<option value="材料合同" <c:if test="${ param.contracttype eq '材料合同' }">selected</c:if>>材料合同</option>
					<option value="经济合同" <c:if test="${ param.contracttype eq '经济合同' }">selected</c:if>>经济合同</option>
					<option value="协议书" <c:if test="${ param.contracttype eq '协议书' }">selected</c:if>>协议书</option>
					<option value="总承包合同" <c:if test="${ param.contracttype eq '总承包合同' }">selected</c:if>>总承包合同</option>
					<option value="租赁合同" <c:if test="${ param.contracttype eq '租赁合同' }">selected</c:if>>租赁合同</option>
					<option value="技术服务合同" <c:if test="${ param.contracttype eq '技术服务合同' }">selected</c:if>>技术服务合同</option>
				</select>
			</td>
			<td>
				<input type="Button" name="Find" value="查询" onClick="find()" />
				<input type="Button" name="Create" value="新增合同内容" onClick="create(<%=contract_id %>)"/>
			</td>
		</tr>
	</table>
</form>
		<table align="center">
		<tr>
			<td>



			</td>
		</tr>
	</table>
<table id="rounded-corner">
	<thead>
		<tr>
			<th>序号</th>
			<th  style="display:none">合同内容id</th>
			<th>合同内容</th>
			<th>规格型号</th>
			<th>单位</th>
			<th>单价</th>
			<th style="display:none">录入时间</th>
			<th style="display:none">更新时间</th>
		
		</tr>
	</thead>
	<tbody>
		<c:forEach var="c" items="${ requestScope.cList }" varStatus="status">
			<tr align="center">
				<td>${ status.count }</td>
				<td style="display:none">${ c.content_id }</td>
				<td>${ c.contract_con }</td>
				<td>${ c.style }</td>
				<td>${ c.unit }</td>
				<td>${ c.price }</td>
				<td style="display:none">${ c.inputdate }</td>
				<td style="display:none">${ c.updatedate }</td>
				<td>
					<a href="${ pageContext.request.contextPath }/editcontent?content_id=${ c.content_id }">编辑</a>
					|
					<a href="${ pageContext.request.contextPath }/readonlycontent?content_id=${ c.content_id }">查看</a>
					|
					<a href="${ pageContext.request.contextPath }/deletecontent?content_id=${c.content_id}&contract_id=<%=contract_id %>" onclick="return confirm('确定删除吗？')" >删除</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<Script Language="JavaScript">
    function find(){
	    document.form1.action="${ pageContext.request.contextPath }/selectByName";
	    document.form1.submit();
    } 

    function create(contractid){
    	//alert(contractid);
	    document.form1.action="${ pageContext.request.contextPath }/pages/contentinfo.jsp?contract_id="+contract_id+"";
	    document.form1.submit();
    }
</Script>
</body>
</html>











