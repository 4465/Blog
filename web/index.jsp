<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2022/2/27
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>先锋的个人技术笔记</title>
</head>
<body>
    <%
        String username = null;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("username")){
                    username = cookie.getValue();
                }
            }
        }
        if(username != null){


    %>
    <ul>
        <li><a href="index.jsp"><span>主页</span></a></li>
        <li><a href="product.jsp"><span>产品</span></a></li>
        <li><a href="cart.jsp"><span>大车</span></a></li>
        <li><a href="search_page.jsp"><span>搜索</span></a></li>
        <li><a href="LogoutServlet"><span>登出</span></a></li>
        <li><a href="update_user.jsp?username=<%=username %>"><span><%=username%></span></a></li>
    </ul>
    <%
    } else {
    %>
    <ul>
        <li><a href="index.jsp"><span>主页</span></a></li>
        <li><a href="product.jsp"><span>产品</span></a></li>
        <li><a href="search_page.jsp"><span>搜索</span></a></li>
        <li><a href="register.jsp"><span>注册</span></a></li>
        <li><a href="login.jsp"><span>登录</span></a></li>
    </ul>
    <%
        }
    %>
</body>
</html>
