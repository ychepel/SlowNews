<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <c:if test="${title != null}">${title}</c:if>
        <c:if test="${title == null}">Slow News</c:if>
    </title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<div class="header">
    <div class="logo">
        <a href="."><img src="images/logo.png"></a>
    </div>
    <div class="welcome">
        <c:if test="${sessionScope.username != null}">Welcome, ${sessionScope.username} !</c:if>
    </div>
    <nav class="menu">
        <ul class="list-menu">
            <li class="menu-item"><a class="header-link" href="/news">all</a></li>
            <li class="menu-item"><a class="header-link" href="/archive">archive</a></li>
            <c:if test="${sessionScope.username == null}">
                <li class="menu-item"><a class="header-link" href="/login">log in</a></li>
                <li class="menu-item"><a class="header-link" href="/signup">sign up</a></li>
            </c:if>
            <c:if test="${sessionScope.username != null}">
                <li class="menu-item"><a class="header-link" href="/logout">log out</a></li>
            </c:if>
        </ul>
    </nav>
</div>