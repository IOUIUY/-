<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2023/2/7
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>售卖</title>
    <%
        pageContext.setAttribute("title","售卖");
    %>
    <link type="text/css" rel="stylesheet" href="/jiajia/static/css/style.css" >
    <script type="text/javascript" src="/jiajia/static/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function (){
            var user = "${sessionScope.user}";
            if(user == ""){// 未登录
                alert("请先登录！");
                location.href = "../login.jsp";
            }
        })
    </script>
</head>
<body>
<%@include file="/pages/common/head.jsp"%>
<div id="sales_container">
    <form id="item_form" method="post" action="http://121.40.162.98/jiajia/userServlet?action=addItem" enctype="multipart/form-data">
        商品名称：<input type="text" name="name" class="inputBox"><br/>
        价&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp格：<input type="number" name="price" class="inputBox"><br/>
        <div id="item_div">商品描述：</div><textarea name="detail" class="inputBox"></textarea><br/>
        <div id="img_div">上传图片：<input type="file" name="photo" accept="image/*" id="img_file"><br/></div>
        <input type="submit" value="发布" id="form_submit">
    </form>
</div>
</body>
</html>
