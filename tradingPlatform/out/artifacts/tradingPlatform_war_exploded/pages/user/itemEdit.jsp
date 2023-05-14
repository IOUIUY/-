<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2023/3/10
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品编辑</title>
    <%
        pageContext.setAttribute("title","商品编辑");
    %>
    <link type="text/css" rel="stylesheet" href="/jiajia/static/css/style.css" >
    <script type="text/javascript" src="/jiajia/static/jquery-1.7.2.js"></script>
</head>
<body>
<%@include file="/pages/common/head.jsp"%>
<div id="sales_container">
    <img src="${sessionScope.item.imgPath}" style="width: 300px;height: 250px;float: left;margin-left: 40px;margin-top: 60px"/>
    <form style="float: top" id="item_form" method="post" action="http://121.40.162.98/jiajia/userServlet?action=modifyItem&itemId=${sessionScope.item.id}" enctype="multipart/form-data">
        商品名称：<input type="text" name="name" class="inputBox" value="${sessionScope.item.name}"><br/>
        价&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp格：<input type="number" name="price" class="inputBox" value="${sessionScope.item.price}"><br/>
        <div id="item_div">商品描述：</div><textarea name="detail" class="inputBox">${sessionScope.item.detail}</textarea><br/>
        <div id="img_div">修改图片：<input type="file" name="photo" accept="image/*" id="img_file"><br/></div>
        <input type="submit" value="保存修改" id="form_submit">
    </form>
</div>
</body>
</html>
