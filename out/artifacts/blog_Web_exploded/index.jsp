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
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">

<%--<script src="bootstrap-3.3.7-dist/dist/js/bootstrap.min.js"></script>--%>
<script src="js/jquery-3.3.1.js"></script>
<html>
<head>
    <meta charset="UTF-8">
    <title>先锋的个人技术笔记</title>
</head>
<body>
    <div>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand">先锋个人技术笔记</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="">About</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">小工具<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">正则转换</a></li>
                                <li><a href="#">加密解密</a></li>
                                <li><a href="#">代码规范</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="http://mv.688ing.com/">vip视频解析</a></li>
                                <li><a href="https://music.laod.cn/">Music</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">工具软件</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
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
                        <li><a href="writeblog.jsp">创作博客</a></li>
                        <li class="dropdown">

                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=username%><span class="caret"></span></a>
                            <ul class="dropdown dropdown-menu">
                                <li><a href="">个人中心</a></li>
                                <li><a href="">我的博客</a></li>
                                <li><a href="">管理博客</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="LogoutServlet">登出</a></li>
                            </ul>
                        </li>
                        <%
                        } else {
                        %>
                        <li><a href="login.jsp">登录</a></li>
                        <li><a href="register.jsp">注册</a></li>
                        <%
                            }
                        %>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>

</body>
</html>
