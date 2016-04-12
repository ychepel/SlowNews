<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <c:if test="${title != null}">${title}</c:if>
        <c:if test="${title == null}">Slow News</c:if>
    </title>
    <link rel="stylesheet" href="/style.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
    <script src="/js/main.js"></script>
    <script src="/js/weather.js"></script>
</head>
<body>
<div class="header">
    <div class="logo">
        <a href="."><img src="images/logo.png"></a>
    </div>
    <div class="welcome">
        <c:if test="${sessionScope.username == null}">Hello, Guest !</c:if>
        <c:if test="${sessionScope.username != null}">Hello, ${sessionScope.username} !</c:if>
    </div>
    <nav class="menu">
        <ul class="list-menu">
            <li class="menu-item">
                <a class="header-link${uri eq '/news' ? ' active' : ''}" href="/news">real news</a>
            </li>
            <li class="menu-item">
                <a class="header-link${uri eq '/fakenews' ? ' active' : ''}" href="/fakenews">fake news</a>
            </li>
            <c:if test="${sessionScope.username == null}">
                <li class="menu-item">
                    <a class="header-link${uri eq '/login' ? ' active' : ''}" href="/login">log in</a>
                </li>
                <li class="menu-item">
                    <a class="header-link${uri eq '/signup' ? ' active' : ''}" href="/signup">sign up</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.username != null}">
                <li class="menu-item">
                    <a class="header-link${uri eq '/archive' ? ' active' : ''}" href="/archive">archive</a>
                </li>
                <li class="menu-item">
                    <a class="header-link${uri eq '/logout' ? ' active' : ''}" href="/logout">log out</a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>

<c:if test='${message != null}'>
    <div class="message">${message}</div>
</c:if>
<c:if test='${error_message != null}'>
    <div class="error-message">${error_message}</div>
</c:if>
