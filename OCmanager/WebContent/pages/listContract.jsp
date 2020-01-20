<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="css/common.css" />
<%
String contractsum = request.getParameter("contractsum");
System.out.println(contractsum+"ssssssssssss");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/function.js"></script>
</head>
<body>

<form name="form1" action="" method="post">
	<table id="search">
		<tr>
			<td>
				分公司：
				<select name="branchorg">
					<option value="">--请选择--</option>
					<option value="一分公司" >一分公司</option>
					<option value="二分公司" >二分公司</option>
					<option value="三分公司" >三分公司</option>
					<option value="四分公司" >四分公司</option>
					<option value="五分公司" >五分公司</option>
					<option value="六分公司" >六分公司</option>
					<option value="路顺公司" >路顺公司</option>
					<option value="管理公司" >管理公司</option>
					<option value="机施公司" >机施公司</option>
			</select>
			</td>
			<td>
				项目名称：<input type="text" name="objectname" />
			</td>
			<td>
				合同类别：
				<select name="contracttype">
					
					<option value="">--请选择--</option>
					<option value="专业合同" >专业合同</option>
					<option value="劳务合同" >劳务合同</option>
					<option value="机械合同" >机械合同</option>
					<option value="材料合同" >材料合同</option>
					<option value="经济合同" >经济合同</option>
					<option value="协议书" >协议书</option>
					<option value="总承包合同" >总承包合同</option>
					<option value="租赁合同" >租赁合同</option>
					<option value="技术服务合同" >技术服务合同</option>
				</select>
			</td>
			<td>
				合同金额：<input type="number" name="contractsum"  οnkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')"/>
			</td>
			<td>
				签约日期：<input type="text" name="signdate"  autocomplete="off"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
			</td>
			<td align="right">
				<input type="Button" name="Find" value="查询" onClick="find()" />
				<input type="Button" name="Create" value="新增合同" onClick="create()"/>
				<input type="Button" name="ExportExcel" value="导出" onClick="exportExcel()"/>
			</td>
		</tr>
	</table>
</form>

<table id="rounded-corner">
	<thead>
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
		</tr>
	</thead>
	<tbody>
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
			<td>
				<a href="${ pageContext.request.contextPath }/initupdate?id=${ c.id }">编辑</a>
				|
				<a href="${ pageContext.request.contextPath }/readonly?id=${ c.id }">查看</a>
				|
				<a href="${ pageContext.request.contextPath }/deletecontract?id=${c.id}" onclick="return confirm('确定删除吗？')" >删除</a>
				|
				<a href="${ pageContext.request.contextPath }/pages/addcontent.jsp?id=${c.id}&objectname=${c.objectname}" >内容</a>
			</td>
		</tr>
		
	</c:forEach>
	</tbody>
</table>
<center style="margin-left:600px;margin-bottom=100px;position:fixed;bottom:0">
	第${ page.pageCode }页/共${ page.totalPage }页
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
<Script Language="JavaScript">
    function find(){
	    document.form1.action="${ pageContext.request.contextPath }/listContract";
	    document.form1.submit();
    } 

    function create(){
	    document.form1.action="${ pageContext.request.contextPath }/pages/addcontract.jsp";
	    document.form1.submit();
    }
    function exportExcel(){
	    document.form1.action="${ pageContext.request.contextPath }/Export";
	    document.form1.submit();
    }
</Script>
</body>
</html>











