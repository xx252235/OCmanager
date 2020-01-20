<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<form name="form1" action="" method="post">
	<table align="center" border="1" width="600" height="200" cellpadding="10">
	<tr>
			<td>分公司</td>
			<td>
				<select name="branchorg">
					<option value="一分公司">一分公司</option>
					<option value="二分公司">二分公司</option>
					<option value="三分公司">三分公司</option>
					<option value="四分公司">四分公司</option>
					<option value="五分公司">五分公司</option>
					<option value="六分公司">六分公司</option>
					<option value="路顺公司">路顺公司</option>
					<option value="管理公司">管理公司</option>
					<option value="机施公司">机施公司</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>项目名称</td>
			<td>
				<input type="text" name="objectname" />
			</td>
		</tr>
		<tr>
			<td>合同类别</td>
			<td>
				<select name="contracttype">
					<option value="专业合同">专业合同</option>
					<option value="劳务合同">劳务合同</option>
					<option value="机械合同">机械合同</option>
					<option value="材料合同">材料合同</option>
					<option value="经济合同">经济合同</option>
					<option value="协议书">协议书</option>
					<option value="总承包合同">总承包合同</option>
					<option value="租赁合同">租赁合同</option>
					<option value="技术服务合同">技术服务合同</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>合同另一方</td>
			<td>
				<input placeholder="提示语..." type="text" name="otherside" />
			</td>
		</tr> 
		<tr>
			<td>是否分劈</td>
			<td>
				<input type="radio" name="ispartition" value="否" checked="checked"/>否
				<input type="radio" name="ispartition" value="是"/>是
			</td>
		</tr>
		<tr>
			<td>合同金额</td>
			<td>
				<input type="number" name="contractsum" οnkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')"/>
			</td>
		</tr>
		<tr>	
			<td>签约日期</td>
			<td>
				<input type="text" name="signdate" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
			</td>
		</tr>
		<tr>
			<td>工期起日</td>
			<td>
				<input type="text" name="workdatefrom" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
			</td>
		</tr>
		<tr>
			<td>工期止日</td>
			<td>
				<input type="text" name="workdateto" />
			</td>
		</tr>
		<tr>
			<td>审批日期</td>
			<td>
				<input type="text" name="approvedate" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
			</td>
		</tr>
		<tr>
			<td>公司存档情况</td>
			<td>
				<input type="radio" name="issave" value="未存" checked="checked"/>未存
				<input type="radio" name="issave" value="已存"/>已存
			</td>
		</tr>
		<tr>
			<td>招投标情况</td>
			<td>
				<select name="bidstate">
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
				<input type="radio" name="isover" value="否" checked="checked"/>否
				<input type="radio" name="isover" value="是"/>是
			</td>
		</tr>
		<tr>
			<td>超预控金额（万元）</td>
			<td>
				<input type="number" name="oversum" οnkeyup="this.value=this.value.replace(/[^\d.]/g,'')" onafterpaste="this.value=this.value.replace(/[^\d.]/g,'')">
			</td>
		</tr>
		<tr>
			<td>备注</td>
			<td>
				<textarea rows="10" cols="30" name = "remark"></textarea>
				<!-- <div class="textarea" name="remark" contenteditable="true"></div> -->
			</td>
		</tr>
		
		
		<tr align="center">
			<td colspan="2">
				<input type="Button" name="Create" value="提交" onClick="save()"/>
				<input type="Button" name="Create" value="提交并新增内容" onClick="saveandcreate()"/>
				
			</td>
		</tr>
	</table>
</form>
<Script Language="JavaScript">
    function save(){
	    document.form1.action="${ pageContext.request.contextPath }/addcontract";
	    document.form1.submit();
    } 

    function saveandcreate(){
    	//alert(contractid);
	    document.form1.action="${ pageContext.request.contextPath }/addcontractandcontent";
	    document.form1.submit();
    }
</Script>
</body>
</html>
