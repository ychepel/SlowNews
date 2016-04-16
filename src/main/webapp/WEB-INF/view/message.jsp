<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test='${message != null}'>
    <div class="message">${message}</div>
</c:if>
<c:if test='${error_message != null}'>
    <div class="error-message">${error_message}</div>
</c:if>