<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="css/common.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="background-top">
	<div  align="center">
		<h3>合同信息管理平台</h3>
		<h3>
			<a href="${ pageContext.request.contextPath }/listContract" target="main">查询所有合同</a>
			| 	
			<a href="${ pageContext.request.contextPath }/listContractAndContent" target="main">查询所有合同（包含内容）</a>
			| 	
			<a href="${ pageContext.request.contextPath }/addExtContract" target="main">追加合同</a>
		</h3>
			
	</div>
</div>

</body>
</html>