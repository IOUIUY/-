<%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2023/3/13
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购买记录</title>
    <%
        pageContext.setAttribute("title","购买记录");
    %>
    <link type="text/css" rel="stylesheet" href="/jiajia/static/css/style.css" >
    <script type="text/javascript" src="/jiajia/static/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        function removeOrder(orderId) {
            if(confirm("您确定删除该记录吗？")){
                location.href = "http://121.40.162.98/jiajia/userServlet?action=removeOrder&orderId=" + orderId;
            }
        }
    </script>
</head>
<body>
<%@include file="/pages/common/head.jsp"%>
<div id="sales_container">
    <c:if test="${not empty sessionScope.orderList}" >
        <c:forEach items="${sessionScope.orderList}" var="item">
            <div id="item_container">
                <div style="font-size: 15px;opacity: 0.7;">卖家：${item.sellerName}</div>
                <img id="cartImg" src="${item.imgPath}">
                <div id="cart_item_name">${item.name}</div>
                <div id="cart_item_detail">${item.detail}</div>
                <div id="cart_item_price" style="margin-top: 50px;">￥${item.price}</div><br/>
                <button id="deleteOrder" style="float: right;margin-right: 20px;margin-top: -30px;border-radius: 1.5rem;border: none;background: bisque;font-size: 18px;" onclick="removeOrder(${item.id})">删除该记录</button>
                <div style="float: left;margin-left: 20px;margin-top: 60px;">交易日期：${item.createTime}</div>
            </div>
        </c:forEach>
    </c:if>
    <c:if test="${empty sessionScope.orderList}">
        <h4 style="margin-left: 20px">您尚未购买商品！</h4>
    </c:if>
</div>

</body>
</html>
