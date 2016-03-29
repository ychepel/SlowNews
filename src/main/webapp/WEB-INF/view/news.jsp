<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp"/>

<div class="content">
    <ul class="news-list">
        <c:forEach items="${news}" var="newsItem">
            <li class="list-item">
                <div class="item-content">
                    <img class="teaser-image" src="${newsItem.teaserLink}">
                    <h1>${newsItem.title}</h1>
                    <div class="news-body">${newsItem.body}</div>
                    <a href="#" class="archive-link">add to archive</a>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>

<c:import url="footer.jsp"/>