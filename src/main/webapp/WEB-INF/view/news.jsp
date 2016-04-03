<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp"/>

<form class="content" action="/save" method="post">
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
                                <li><a href="${newsItem.url}" class="news-link" target="_blank">read</a></li>
                            </c:if>
                            <label class="massive-checkbox">
                                <input type="checkbox" name="0">
                                <span></span>
                            </label>
                            <li><a href="#" class="news-link">add to archive</a></li>
                        </ul>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</form>

<c:import url="footer.jsp"/>