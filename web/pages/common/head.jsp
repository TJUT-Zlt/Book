<%--
  Created by IntelliJ IDEA.
  User: abel
  Date: 2023/9/15
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--                     http             ://  localhost                :         8080/              Book                     /--%>
<% String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort()+request.getContextPath()+"/";

pageContext.setAttribute("basePath",basePath);

%>

<!--写base标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%> ">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
