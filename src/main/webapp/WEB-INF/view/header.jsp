<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header">
    <div class="logo">
        <a id="logo-link" href="."><img src="images/logo.png"></a>
    </div>
    <div class="welcome">
        <c:if test="${sessionScope.username == null}">Hello, Guest !</c:if>
        <c:if test="${sessionScope.username != null}">Hello, ${sessionScope.username} !</c:if>
    </div>
    <nav class="menu">
        <ul class="list-menu">
            <li class="menu-item">
                <a class="header-link${uri eq '/content/news' || uri eq '/content/' ? ' active' : ''}" href="/news">
                    real news
                </a>
            </li>
            <li class="menu-item">
                <a class="header-link${uri eq '/content/fakenews' ? ' active' : ''}" href="/fakenews">fake news</a>
            </li>
            <c:if test="${sessionScope.username == null}">
                <li class="menu-item">
                    <a class="header-link${uri eq '/content/login' ? ' active' : ''}" href="/login">log in</a>
                </li>
                <li class="menu-item">
                    <a class="header-link${uri eq '/content/signup' ? ' active' : ''}" href="/signup">sign up</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.username != null}">
                <li class="menu-item">
                    <a class="header-link${uri eq '/content/archive' ? ' active' : ''}" href="/archive">archive</a>
                </li>
                <li class="menu-item">
                    <a class="header-link" href="/logout">log out</a>
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