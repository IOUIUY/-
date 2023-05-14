<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 119
  +60
  Date: 2023/1/28
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="header">校园二手交易平台</div>
<div id="header_link">
    <c:if test="${pageContext.getAttribute('title') == '首页'}">
        <a href="http://121.40.162.98/jiajia/index.jsp" style="opacity: 0.5;text-decoration: none">首页</a>
    </c:if>
    <c:if test="${pageContext.getAttribute('title') != '首页'}">
        <a href="http://121.40.162.98/jiajia/index.jsp">首页</a>
    </c:if>
    <c:if test="${pageContext.getAttribute('title') == '所有商品'}">
        <a href="http://121.40.162.98/jiajia/userServlet?action=showAllItem" style="opacity: 0.5;text-decoration: none">查看所有商品</a>
    </c:if>
    <c:if test="${pageContext.getAttribute('title') != '所有商品'}">
        <a href="http://121.40.162.98/jiajia/userServlet?action=showAllItem">查看所有商品</a>
    </c:if>
    <c:if test="${pageContext.getAttribute('title') == '售卖'}">
        <a href="http://121.40.162.98/jiajia/pages/user/sales.jsp" style="opacity: 0.5;text-decoration: none">我要售卖商品</a>
    </c:if>
    <c:if test="${pageContext.getAttribute('title') != '售卖'}">
        <a href="http://121.40.162.98/jiajia/pages/user/sales.jsp">我要售卖商品</a>
    </c:if>
    <c:if test="${pageContext.getAttribute('title') == '我的商品'}">
        <a href="http://121.40.162.98/jiajia/userServlet?action=showUserItem" style="opacity: 0.5;text-decoration: none">我的商品</a>
    </c:if>
    <c:if test="${pageContext.getAttribute('title') != '我的商品'}">
        <a href="http://121.40.162.98/jiajia/userServlet?action=showUserItem">我的商品</a>
    </c:if>
    <c:if test="${pageContext.getAttribute('title') == '购物车'}">
        <a href="http://121.40.162.98/jiajia/userServlet?action=showUserCartItem" style="opacity: 0.5;text-decoration: none">购物车</a>
    </c:if>
    <c:if test="${pageContext.getAttribute('title') != '购物车'}">
        <a href="http://121.40.162.98/jiajia/userServlet?action=showUserCartItem">购物车</a>
    </c:if>


    <a>消息</a>
    <c:if test="${pageContext.getAttribute('title') == '购买记录'}">
        <a href="http://121.40.162.98/jiajia/userServlet?action=showUserOrder" style="opacity: 0.5;text-decoration: none">购买记录</a>
    </c:if>
    <c:if test="${pageContext.getAttribute('title') != '购买记录'}">
        <a href="http://121.40.162.98/jiajia/userServlet?action=showUserOrder">购买记录</a>
    </c:if>

    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="http://121.40.162.98/jiajia/pages/login.jsp">登录</a>|
            <a href="http://121.40.162.98/jiajia/pages/regist.jsp">注册</a>
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <div><a href="http://121.40.162.98/jiajia/userServlet?action=logout">退出登录</a></div>
            <div>${sessionScope.user.username}|</div>
        </c:if>
    </div>
</div>
