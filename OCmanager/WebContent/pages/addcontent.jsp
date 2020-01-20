<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String objectName = request.getParameter("objectname");
String id = request.getParameter("id");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>"<%=objectName %>"</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <!-- 访问项目的时候会自动访问这个index文件 -->
  <frameset cols="420,*">
  <!-- 将页面分为两个部分，一部分是top.jsp一部分是main.jsp -->
  	<frame src="${ pageContext.request.contextPath }/contractoutline?id=<%=id %>" name="left"/>
  	<frame src="${ pageContext.request.contextPath }/listContent?contract_id=<%=id %>" name="right"/>
  </frameset>
  
  <body>
  </body>
  
  
</html>












