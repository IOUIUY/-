<%@ page import="com.aic.pojo.Item" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2023/3/7
  Time: 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的商品</title>
    <%
        pageContext.setAttribute("title","我的商品");
    %>
    <link type="text/css" rel="stylesheet" href="/jiajia/static/css/style.css" >
    <script type="text/javascript" src="/jiajia/static/jquery-1.7.2.js"></script>
    <script type="text/javascript">

    function removeItem(itemId,name) {
            if(confirm("您确定撤销【"+ name +"】商品的售卖吗？")){
                location.href="http://121.40.162.98/jiajia/userServlet?action=removeItem&itemId=" + itemId;
            }
        }
        function modifyItem(itemId) {
            location.href="http://121.40.162.98/jiajia/userServlet?action=findItem&itemId=" + itemId;
        }
    </script>
</head>
<body>
<%@include file="/pages/common/head.jsp"%>
<div id="sales_container">
    <c:if test="${empty sessionScope.itemList}">
        <h4 style="margin-left: 20px">您暂未发布商品，去发布您的商品吧。</h4>
    </c:if>
    <c:if test="${not empty sessionScope.itemList}">
        <c:forEach items="${sessionScope.itemList}" var="item">
            <div id="img_show" style="height: 255px">
                <c:if test="${item.status == 1}">
                    <h1 style="position: static ;color: red;opacity: 0.5;z-index: 2;margin-left: 10px;margin-top: 50px;font-size: 60px;margin-bottom: -130px">已卖出</h1>
                </c:if>
                <img style="z-index: 1;" src="${item.imgPath}"/>
                <div style="font-size: 5px;float: right;opacity: 0.5;">浏览量${item.views}</div><br/>
                <div id="item_name" style="margin-top: 20px;">${item.name}</div>
                <div id="item_price">${item.price}￥</div>
                <div id="item_detail">${item.detail}</div>
                <c:if test="${item.status != 1}">
                    <button class="itemMage" style="margin-left: 20px;" onclick="modifyItem(${item.id})">编辑</button>
                    <button class="itemMage" style="float:right;margin-right: 20px" onclick="removeItem('${item.id}','${item.name}')">撤销</button>
                </c:if>
            </div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
