<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>合同信息管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <!-- 访问项目的时候会自动访问这个index文件 -->
  <frameset rows="120,*">
  <!-- 将页面分为两个部分，一部分是top.jsp一部分是main.jsp -->
  	<frame src="${ pageContext.request.contextPath }/top.jsp" name="top"/>
  	<frame src="${ pageContext.request.contextPath }/main.jsp" name="main"/>
  </frameset>
  
  <body>
  </body>
  
  
</html>












