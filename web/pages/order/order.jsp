<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>
	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	</style>
	<script type="text/javascript">
		$(function (){
			$("a.receive_order").click(function (){
				var orderId = $(this).parent().parent().find("td:first").text();
				//alert(orderId);
				return confirm("确定将"+orderId+"收货吗");
			});
		});
	</script>

</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
			<%--静态包含，登录 成功之后的菜单 --%>
			<%@ include file="/pages/common/loginOrRegist_success_menu.jsp"%>
	</div>

	<div id="main">

		<table>
			<tr>
				<td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<c:if test="${empty requestScope.myOrders}">
				<%--如果购物车空的情况--%>
				<tr>
					<td colspan="5"><a href="index.jsp">亲，暂时没有订单信息,可前往购物吧.</a></td>
				</tr>
			</c:if>

			<c:if test="${not empty requestScope.myOrders}">
				<c:forEach items = "${requestScope.myOrders}" var="order">
					<tr>
						<td>${order.orderId}</td>
						<td>${order.createTime}</td>
						<td>${order.price}</td>
						<td>
							<c:if test="${order.status==0}">
								未发货
							</c:if>
							<c:if test="${order.status==1}">
								<a class="receive_order" href="client/clientOrderServlet?action=receiveOrder&orderId=${order.orderId}">点击确认收货</a>
							</c:if>
							<c:if test="${order.status==2}">
								已收货
							</c:if>
						</td>
						<td>
							<a class="order_details" href="client/clientOrderServlet?action=orderDetails&orderId=${order.orderId}">查看详情</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>


	</div>

	<%--静态包含页脚内容--%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
