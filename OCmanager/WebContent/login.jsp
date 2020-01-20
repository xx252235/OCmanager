<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	System.out.println(basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<script type="text/javascript" src="js/login.js"></script>
<title>合同信息管理</title>
</head>
<body>
<div id="login">

    <div id="image_logo"><img src="image/login/fly_icon.png"></div>

    <div id="loginForm">
		<form action="LoginServlet" method="post">
			<div id="div_userid"><input type="text" id="userid" name="userid" class="text_field" placeholder="请输入账号"/></div>
	
	        <div id="div_password"><input type="password" id="password" name="password" class="text_field" placeholder="请输入密码"/></div>
	
	        <div id="div_forget"><a id="forget_pwd" href="forget_pwd.html" target="_blank">忘记密码？</a></div>
	
	        <div id="div_btn_login"><input type="submit"   id=btn_login value="登录"  /></div>
		</form>
	</div>

</div>
<Script Language="JavaScript">
/* var xmlHttp;
function getXMLHttpRequest() {
    if (window.XMLHttpRequest) {
        return new XMLHttpRequest();

    } else {
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}
function keyLogin(event) {

    var browser = navigator.appName;
    var userAgent = navigator.userAgent;
    var code;
    if(browser.indexOf('Internet')>-1) //IE
    code = window.event.keyCode;
    else if(userAgent.indexOf("Firefox")>-1)  //火狐
    code = event.which;
    else  //其它浏览器
    code = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

    if ( code == 13)  //按Enter键的键值为13
        document.getElementById("btn_login").click();  //调用登录按钮的登录事件
}


window.onload = function () {
    var btn_login = document.getElementById('btn_login');
    var btn_register = document.getElementById('btn_register');


    btn_login.onclick = function login() {

        var userid = document.getElementById("userid");
        var password = document.getElementById("password");
        if (userid.value == "") {

            alert("请输入用户名");

        } else if (password.value == "") {

            alert("请输入密码");

        } else{
        	 //1.生成xmlHttp对象
            xmlHttp = getXMLHttpRequest();
            //2.设置请求参数（method,url,async）
            alert(userid.value+"???///"+password.value);

            xmlHttp.open("Post", "LoginServlet?userid="+userid.value+"&password="+password.value, true);
            alert(userid.value+"???///"+password.value);

            //3.监听服务器返回的数据
            xmlHttp.onreadystatechange = loginCheckCallBack;
            //4.发送请求
            xmlHttp.send();
        }
    }
    
function loginCheckCallBack() {
    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
        //接收服务器返回的数据
        var text = xmlHttp.responseText;
        if("0"!=text){
            document.getElementById("nameTip").innerText="用户名已存在，请重新输入";
        }else{
            document.getElementById("nameTip").innerText="";
        }
    }
}
} */
</Script>
</body>
</html>
