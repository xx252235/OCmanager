<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="css/common.css" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="${ pageContext.request.contextPath }/contractoutline" method="post">
	
	<!-- 隐藏域 -->
	<input type="hidden" name="id" value="${ c.id }" />

	<table align="left" border="1" width="400" cellpadding="2">
		<tr>
			<td>分公司</td>
			<td>
				<select name="branchorg" disabled="true">
					<option value="一分公司" <c:if test="${ c.branchorg eq '一分公司' }">selected</c:if>>一分公司</option>
					<option value="二分公司" <c:if test="${ c.branchorg eq '二分公司' }">selected</c:if>>二分公司</option>
					<option value="三分公司" <c:if test="${ c.branchorg eq '三分公司' }">selected</c:if>>三分公司</option>
					<option value="四分公司" <c:if test="${ c.branchorg eq '四分公司' }">selected</c:if>>四分公司</option>
					<option value="五分公司" <c:if test="${ c.branchorg eq '五分公司' }">selected</c:if>>五分公司</option>
					<option value="六分公司" <c:if test="${ c.branchorg eq '六分公司' }">selected</c:if>>六分公司</option>
					<option value="路顺公司" <c:if test="${ c.branchorg eq '路顺公司' }">selected</c:if>>路顺公司</option>
					<option value="管理公司" <c:if test="${ c.branchorg eq '管理公司' }">selected</c:if>>管理公司</option>
					<option value="机施公司" <c:if test="${ c.branchorg eq '机施公司' }">selected</c:if>>机施公司</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>项目名称</td>
			<td>
				<input type="text" name="objectname" readonly="readonly" value=${ c.objectname } />
			</td>
		</tr>
		<tr>
			<td>合同类别</td>
			<td>
				<select name="contracttype" disabled="true">
					<option value="专业合同" <c:if test="${ c.contracttype eq '专业合同' }">selected</c:if>>专业合同</option>
					<option value="劳务合同" <c:if test="${ c.contracttype eq '劳务合同' }">selected</c:if>>劳务合同</option>
					<option value="机械合同" <c:if test="${ c.contracttype eq '机械合同' }">selected</c:if>>机械合同</option>
					<option value="材料合同" <c:if test="${ c.contracttype eq '材料合同' }">selected</c:if>>材料合同</option>
					<option value="经济合同" <c:if test="${ c.contracttype eq '经济合同' }">selected</c:if>>经济合同</option>
					<option value="协议书" <c:if test="${ c.contracttype eq '协议书' }">selected</c:if>>协议书</option>
					<option value="总承包合同" <c:if test="${ c.contracttype eq '总承包合同' }">selected</c:if>>总承包合同</option>
					<option value="租赁合同" <c:if test="${ c.contracttype eq '租赁合同' }">selected</c:if>>租赁合同</option>
					<option value="技术服务合同" <c:if test="${ c.contracttype eq '技术服务合同' }">selected</c:if>>技术服务合同</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>合同另一方</td>
			<td>
				<input type="text" name="otherside" value=${ c.otherside } readonly="readonly" />
			</td>
		</tr> 
		<tr>
			<td>是否分劈</td>
			<td>
				<input type="radio" name="ispartition"  disabled="true" value="否" checked="checked"/>否
				<input type="radio" name="ispartition"  disabled="true" value="是"/>是
			</td>
		</tr>
		<tr>
			<td>合同金额</td>
			<td>
				<input type="number" name="contractsum" readonly="readonly" value=${ c.contractsum } οnkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')"/>
			</td>
		</tr>
		<tr>	
			<td>签约日期</td>
			<td>
				<input type="text" name="signdate" value=${ c.signdate } readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
			</td>
		</tr>
		<tr>
			<td>工期起日</td>
			<td>
				<input type="text" name="workdatefrom" value=${ c.workdatefrom } readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
			</td>
		</tr>
		<tr>
			<td>工期止日</td>
			<td>
				<input type="text" name="workdateto" readonly="readonly"  value=${ c.workdateto } />
			</td>
		</tr>
		<tr>
			<td>审批日期</td>
			<td>
				<input type="text" name="approvedate" readonly="readonly" value=${ c.approvedate } readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
			</td>
		</tr>
		<tr>
			<td>公司存档情况</td>
			<td>
				<input type="radio" name="issave"  disabled="true" value="未存" checked="checked"/>未存
				<input type="radio" name="issave"  disabled="true" value="已存"/>已存
			</td>
		</tr>
		<tr>
			<td>招投标情况</td>
			<td>
				<select name="bidstate"  disabled="true">
					<option value="已走">已走</option>
					<option value="未走">未走</option>
					<option value="竞价">竞价</option>
					<option value="无">无</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>是否超预控</td>
			<td>
				<input type="radio" name="isover"  disabled="true" value="否" checked="checked"/>否
				<input type="radio" name="isover"  disabled="true" value="是"/>是
			</td>
		</tr>
		<tr>
			<td>超预控金额（万元）</td>
			<td>
				<input type="number" name="oversum" readonly="readonly" value=${ c.oversum } οnkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
			</td>
		</tr>
		<tr>
			<td>备注</td>
			<td>
				<textarea rows="10" cols="30" name = "remark" readonly="readonly">${ c.remark }</textarea>
				<%-- <div class="textarea" name="remark" value=${ c.remark } contenteditable="true"></div> --%>
			</td>
		</tr>
	</table>
</form>

</body>
</html>