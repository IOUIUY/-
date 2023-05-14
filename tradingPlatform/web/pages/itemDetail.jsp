<%@ page import="com.aic.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 11960
  Date: 2023/3/8
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <link type="text/css" rel="stylesheet" href="/jiajia/static/css/style.css" >
    <script type="text/javascript" src="/jiajia/static/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        function purchaseItem(itemId) {
            if("${user}" == ""){
                alert("请先完成登录！！");
                location.href = "http://121.40.162.98/jiajia/pages/login.jsp";
            }
            else{
                var tem = confirm("已和商家协商好价格和交货方式？");
                if(tem){
                    location.href = "http://121.40.162.98/jiajia/userServlet?action=purchaseItem&itemId=" + itemId;
                }
            }
        }

        function addItemToCart(itemId) {
            if("${user}" == ""){
                alert("请先完成登录！！");
                location.href = "http://121.40.162.98/jiajia/pages/login.jsp";
            }
            else{
                alert("添加成功");
                location.href = "http://121.40.162.98/jiajia/userServlet?action=addItemToCart&itemId=" + itemId;
            }
        }
    </script>
</head>
<body>
<%@include file="/pages/common/head.jsp"%>
    <div id="sales_container">
        <a href="${sessionScope.item.imgPath}" target="_blank"><img src="${sessionScope.item.imgPath}" id="detail_img"></a>
        <div id="detail_div">
            <h1 style="text-align: left;width: 600px;overflow: visible">${sessionScope.item.name}</h1>
            <h4 >价格：${sessionScope.item.price}￥</h4>
            卖家描述:<h5 style="margin-left: 60px;margin-top: 10px;">${sessionScope.item.detail}</h5>
            <span style="float: left">卖家：</span> <div style="float: left;margin-left: 10px">${sessionScope.seller.username}</div>
        </div>
        <div style="float:left;width: 1200px;text-align: center;margin-top: 20px;">
            <button class="detailBtn" style="margin-left: 450px;" onclick="purchaseItem(${sessionScope.item.id})">购买</button>
            <button class="detailBtn" style="margin-left: 100px;" onclick="addItemToCart(${sessionScope.item.id})">加入购物车</button>
        </div>
    </div>
</body>
</html>
