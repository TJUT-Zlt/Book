<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="utf-8"  %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>
    <%@include file="/pages/common/head.jsp"%></head>

<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">订单详情</span>

</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
        </tr>

        <c:forEach items="${requestScope.orderItems}" var = "orderItem">
            <tr>
                <td>${orderItem.name}</td>
                <td>${orderItem.count}</td>
                <td>${orderItem.price}</td>
                <td>${orderItem.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>
<%--    <div class="cart_info">--%>
<%--        <span class="cart_span">订单中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>--%>
<%--        <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>--%>
<%--    </div>--%>
</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>