<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="/WEB-INF/view/header.jsp"/>

<div class="content">
    <ul class="news-list">
        <c:forEach items="${news}" var="newsItem" varStatus="newsItemStatus">
            <li class="list-item">
                <div class="item-content">
                    <img class="teaser-image" src="${newsItem.teaserLink}">
                    <div class="text-content">
                        <h1>${newsItem.title}</h1>
                        <div class="news-body">${newsItem.body}</div>
                        <ul class="news-links">
                            <c:if test='${newsItem.url != ""}'>
                                <li><a href="${newsItem.url}" class="news-link" target="_blank">read</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>