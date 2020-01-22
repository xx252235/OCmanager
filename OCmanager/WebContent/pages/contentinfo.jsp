<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%
String contract_id = request.getParameter("contract_id");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
    .con1{
        /* 对连续过长的字母和数字进行强制换行*/
        word-wrap: break-word;
		word-break: normal;
    }
    .textarea{
		  min-height:100px;
		  border:1px solid #666;
		  width:300px;
		  font-size:14px;
		  max-height:90px;
  }
</style>
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/function.js"></script>
<script>
		function onKeyUpDesc(text){
			var value = text.value;
		 	if (isNaN(value) && value != "." ){
		 		value = value.substring(0,value.length-1);
		 		text.value = value ;
			}
		}
		</script>
</head>
<body>

<form action="${ pageContext.request.contextPath }/addcontent" method="post">
	<table align="center" border="1" width="600" height="200" cellpadding="10">
		<tr>
			<td style="display:none" >合同id</td>
			<td style="display:none">
				<input type="text" style="display:none" name="relativeid" value=<%=contract_id %> />
			</td>
		</tr>
		<tr>
			<td>合同内容</td>
			<td>
				<input type="text" name="contract_con" />
			</td>
		</tr>
		<tr>
			<td>规格型号</td>
			<td>
				<input type="text" name="style" />
			</td>
		</tr>
		<tr>
			<td>单位</td>
			<td>
				<input type="text" name="unit" />
			</td>
		</tr>
		<tr>
			<td>单价</td>
			<td>
				<input type="number" name="price" οnkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
			</td>
		</tr>
		<tr>
			<td>录入时间</td>
			<td>
				<input type="text" name="inputdate" readonly="readonly" />
			</td>
		</tr>
		<tr>
			<td>更新时间</td>
			<td>
				<input type="text" name="updatedate" readonly="readonly" />
			</td>
		</tr>
		
		
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="添加" />
			</td>
		</tr>
	</table>
</form>

</body>
</html>
