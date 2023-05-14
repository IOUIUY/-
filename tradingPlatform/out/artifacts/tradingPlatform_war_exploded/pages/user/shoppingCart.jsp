<%@ page import="com.aic.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2023/3/11
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <%
        pageContext.setAttribute("title","购物车");
    %>
    <link type="text/css" rel="stylesheet" href="/jiajia/static/css/style.css" >
    <script type="text/javascript" src="/jiajia/static/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        function purchaseItem(itemId , id) {
            var tem = confirm("已和商家协商好价格和交货方式？");
            if(tem){
                location.href = "http://121.40.162.98/jiajia/userServlet?action=purchaseItem&itemId=" + itemId +"&cartItemId=" + id;
            }
        }

        function removeItemFromCart(itemId , itemName) {
            var tem = confirm("您确定将【" + itemName +"】移出购物车吗？");
            if(tem){
                location.href = "http://121.40.162.98/jiajia/userServlet?action=removeItemFromCart&itemId=" + itemId;
            }
        }
    </script>
</head>
<body>
<%@include file="/pages/common/head.jsp"%>
    <div id="sales_container">
        <c:if test="${not empty sessionScope.cartItems}" >
            <c:forEach items="${sessionScope.cartItems}" var="item">
                <div id="item_container">
                    <div style="font-size: 15px;opacity: 0.7;">卖家：${item.sellerName}</div>
                    <img id="cartImg" src="${item.imgPath}">
                    <div id="cart_item_name">${item.name}</div>
                    <button class="cart_item_button" style="margin-top: 20px" onclick="purchaseItem(${item.cargoId} , ${item.id})">结算</button>
                    <div id="cart_item_detail">${item.detail}</div>
                    <div id="cart_item_price">￥${item.price}</div><br/>
                    <button class="cart_item_button" style="margin-top: 20px" onclick="removeItemFromCart(${item.id} , '${item.name}')">删除</button>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${empty sessionScope.cartItems}">
            <h4 style="margin-left: 20px">您的购物车为空，快去选购心仪的商品吧！</h4>
        </c:if>
    </div>
</body>
</html>
