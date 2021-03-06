<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="/WEB-INF/view/header.jsp"/>

<div class="main-content">
    <form id="news-form">
        <div class="menu-buttons news noshow">
            <div class="logo">
                <a href="."><img src="images/logo.png"></a>
            </div>
            <ul class="news-list-menu">
                <li class="menu-item"><a class="menu-link news action">save</a></li>
                <li class="menu-item"><a class="menu-link news cancel">cancel</a></li>
            </ul>
        </div>
        <ul class="news-list">
            <c:forEach items="${sessionScope.ShowNews}" var="newsItem" varStatus="newsItemStatus">
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
                                <c:if test="${sessionScope.username != null}">
                                    <li>
                                        <a class="news-link">add to archive</a>
                                        <input class="archive-checkbox noshow" type="checkbox" name="news_id" value="${newsItemStatus.index}">
                                    </li>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </form>
</div>