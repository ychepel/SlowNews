<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Slow News</title>
    <link rel="stylesheet" href="/style.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
    <script src="/js/main.js"></script>
    <script src="/js/weather.js"></script>
</head>
<body>

<div id="content">
    <div class="header">
        <div class="logo">
            <a id="logo-link" href="."><img src="images/logo.png"></a>
        </div>
    </div>
    <div class="loading">
        <img src="images/loading.gif">
    </div>
</div>

<c:import url="/WEB-INF/view/footer.jsp"/>