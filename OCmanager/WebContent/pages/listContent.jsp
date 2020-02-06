<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String contract_id = request.getParameter("relativeid");
String readonly = request.getParameter("readonly");

System.out.println(contract_id+"kkkkkkkkkkkkkk"+readonly);
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
				合同内容：<input type="text" name="contract_con" value="${ param.objectname }"/>
			</td>
			
			<td>
				<input type="Button" name="Find" value="查询" onClick="find(<%=contract_id %>,<%=readonly %>)" />
				<%if(!"true".equals(readonly)){ %>
				<input type="Button" name="Create" value="新增合同内容" onClick="create(<%=contract_id %>)"/>
				<%} %>
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
				<%if(!"true".equals(readonly)){ %>
				<td>
					<a href="${ pageContext.request.contextPath }/editcontent?content_id=${ c.content_id }">编辑</a>
					|
					<a href="${ pageContext.request.contextPath }/readonlycontent?content_id=${ c.content_id }">查看</a>
					|
					<a href="${ pageContext.request.contextPath }/deletecontent?content_id=${c.content_id}&contract_id=<%=contract_id %>" onclick="return confirm('确定删除吗？')" >删除</a>
				</td>
				<%} %>
			</tr>
		</c:forEach>
	</tbody>
</table>
<Script Language="JavaScript">
    function find(contractid,readonly){
    alert(contractid);
	    document.form1.action="${ pageContext.request.contextPath }/selectContent?contract_id="+contractid+"&readonly="+readonly+"";
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











