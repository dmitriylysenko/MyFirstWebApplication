<%-- 
    Document   : all
    Created on : 17.06.2015, 21:23:23
    Author     : Дмитрий
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User info page</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" />
    </head>
    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">

                <ul class="nav navbar-nav">
                    <li><a href="<c:url value="/user/login" />"> Login</a> </li>  
                    <!-- <li><a href="<c:url value="/categories" />">Browse categories</a></li> -->
                    <li><a href="<c:url value="/goods/all" />">All categories</a></li>
                    <li><a href="<c:url value="/goods/all/3" />">Category electronics</a></li>
                    <li><a href="<c:url value="/goods/all/4" />">Category foods</a></li>
                    <li><a href="<c:url value="/user/show" />">Profile</a></li>
                    <li><a href="<c:url value="/user/logout" />">Logout</a></li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <div class="jumbotron">
                <h1>Browse Goods</h1>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Goods</h3>
                        </div>
                        <div class="panel-body">
                            <ul>
                                <c:forEach items="${goods}" var="good">
                                    <li>${good.name} - ${good.description} - ${good.price}</li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Basket</h3>
                        </div>
                        <div class="panel-body">
                            <ul>
                                <c:forEach items="${basket}" var="item">
                                    <li>${item.value.good.name} : <span>${item.value.count}</span></li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
