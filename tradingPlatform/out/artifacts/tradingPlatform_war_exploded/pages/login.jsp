<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2023/1/28
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link type="text/css" rel="stylesheet" href="/jiajia/static/css/style.css" >
</head>
<body id="login_body">
<a href="http://121.40.162.98/jiajia">返回首页</a>
<h1 id="login_header">校园二手交易平台</h1>
<div id="container">
    <div id="login_input">
        <h1>用户登录</h1>
        <div id="errorMsg">${requestScope.msg}</div>
        <form action="http://121.40.162.98/jiajia/userServlet?action=login" method="post">
            账号<input type="text" class="user_msg" id="username" name="username" placeholder="请输入用户名">
            <br/>
            密码<input type="password" class="user_msg" id="password" name="password" placeholder="请输入密码">
            <br/>
            <input type="checkbox" id="cx">记住用户名
            <a href="http://121.40.162.98/jiajia/pages/regist.jsp" id="register">注册</a>
            <br/>
            <input type="submit" id="submit" value="登录">
        </form>
    </div>
</div>
</body>
</html>
