<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>
<div class="header">
    <div class="logo">
        <a href="."><img src="images/logo.png"></a>
    </div>
    <nav class="menu">
        <ul class="list-menu">
            <li class="menu-item"><a class="header-link" href="/news">all</a></li>
            <li class="menu-item"><a class="header-link" href="/archive">archive</a></li>
            <li class="menu-item"><a class="header-link" href="/login">log in</a></li>
            <li class="menu-item"><a class="header-link" href="/signup">sign up</a></li>
        </ul>
    </nav>
</div>