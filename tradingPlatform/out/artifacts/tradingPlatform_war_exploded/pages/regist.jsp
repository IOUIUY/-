<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2023/3/9
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link type="text/css" rel="stylesheet" href="/jiajia/static/css/style.css" >
    <script type="text/javascript" src="/jiajia/static/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            if("${sessionScope.flag}" != ""){
                if("${sessionScope.flag}" == "0"){
                    alert("账号已存在！！");
                }else if("${sessionScope.flag}" == "1"){
                    alert("请正确输入！！");
                }else{
                    alert("注册成功，即将前往登录页面！");
                    ${sessionScope.remove("flag")}
                    location.href = "/jiajia/pages/login.jsp";
                }
            }
        })
    </script>
</head>
<body id="login_body">
    <h1 id="login_header">校园二手交易平台</h1>
    <div id="container" style="height: 400px">
        <div id="login_input">
            <h1 style="margin-top: 8px">用户注册</h1>
            <form action="http://121.40.162.98/jiajia/userServlet?action=regist" method="post">
                账&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp号<input type="text" class="regist_msg" name="username" placeholder="由数字和字母组成">
                <br/>
                密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码<input type="password" class="regist_msg" name="password" placeholder="请输入密码">
                <br/>
                确认密码<input type="password" class="regist_msg" name="repassword" placeholder="请再次输入密码"><br/>
                邮&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp箱<input type="text" class="regist_msg" name="emil" placeholder="请输入注册邮箱"><br/>
                <input type="submit" id="submit" value="注册">
            </form>
        </div>
    </div>
</body>
</html>
