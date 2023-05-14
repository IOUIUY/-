<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2023/3/8
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有商品</title>
    <%
        pageContext.setAttribute("title","所有商品");
    %>
    <link type="text/css" rel="stylesheet" href="/jiajia/static/css/style.css" >
    <script type="text/javascript" src="/jiajia/static/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        function showDetail(itemId) {
            location.href = "http://121.40.162.98/jiajia/userServlet?action=showDetail&itemId="+itemId;
        }
    </script>
</head>
<body>
<%@include file="/pages/common/head.jsp"%>
<div id="sales_container">
    <c:forEach items="${sessionScope.itemList}" var="item">
        <div id="img_show" onclick="showDetail('${item.id}')">
            <img src="${item.imgPath}"/>
            <div id="item_name">${item.name}</div>
            <div id="item_price">${item.price}￥</div>
            <div id="item_detail">${item.detail}</div>
            <div style="float: right;font-size: 5px;opacity: 0.5;">浏览量${item.views}</div>
        </div>
    </c:forEach>
</div>
</body>
</html>
