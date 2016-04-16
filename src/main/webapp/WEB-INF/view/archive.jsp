<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="/WEB-INF/view/header.jsp"/>

<div class="main-content">
    <form id="archive-form">
        <div class="menu-buttons archive noshow">
            <div class="logo">
                <a href="."><img src="images/logo.png"></a>
            </div>
            <ul class="news-list-menu">
                <li class="menu-item"><a class="menu-link archive action">remove</a></li>
                <li class="menu-item"><a class="menu-link archive cancel">cancel</a></li>
            </ul>
        </div>
        <ul class="news-list">
            <c:forEach items="${news}" var="newsItem">
            <li class="list-item">
                    <div class="item-content">
                        <img class="teaser-image" src="${newsItem.teaserLink}">
                        <div class="text-content">
                            <h1>${newsItem.title}</h1>
                            <div class="news-body">${newsItem.body}</div>
                            <ul class="news-links">
                                <c:if test='${newsItem.url != ""}'>
                                    <li><a href="${newsItem.url}" class="archive-link" target="_blank">read</a></li>
                                </c:if>
                                    <li>
                                        <a class="archive-link">remove</a>
                                        <input class="remove-checkbox noshow" type="checkbox" name="news_id" value="${newsItem.id}">
                                    </li>
                            </ul>
                        </div>
                    </div>
            </li>
            </c:forEach>
        </ul>
    </form>
</div>