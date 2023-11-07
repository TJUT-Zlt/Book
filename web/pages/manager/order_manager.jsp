<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>

	<script type="text/javascript">
		$(function (){
			$("a.send_order").click(function (){
				var orderId = $(this).parent().parent().find("td:first").text();
				//alert(orderId);
				return confirm("确定将"+orderId+"发货吗");
			});
		});
	</script>
</head>

<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
			<%--静态包含，登录 成功之后的菜单 --%>
			<%@ include file="/pages/common/manager_menu.jsp"%>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
			</tr>
			<c:forEach items = "${requestScope.orders}" var="order">
			<tr>
				<td>${order.orderId}</td>
				<td>${order.createTime}</td>
				<td>${order.price}</td>
				<td>
					<a class="order_details" href="manager/orderServlet?action=orderDetails&orderId=${order.orderId}">查看详情</a>
				</td>
				<td>
					<c:if test="${order.status==0}">
						<a class="send_order" href="manager/orderServlet?action=sendOrder&orderId=${order.orderId}">点击发货</a>
					</c:if>
					<c:if test="${order.status==1}">
						已发货
					</c:if>
					<c:if test="${order.status==2}">
						用户已签收
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</table>
	</div>

	<%--静态包含页脚内容--%>
	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>
