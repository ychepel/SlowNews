<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp"/>

<div class="user-form">
    <form class="signup-form" action="login" method="post">
        <ul>
            <li class="form-field"><input class="form-input" input type="text" name="username" placeholder="Enter User Name" required="required"></li>
            <li class="form-field"><input input class="form-input" type="password" name="password" placeholder="Enter Password" required="required"></li>
            <li class="form-field"><button class="form-button" type="submit">Log in</button></li>
        </ul>
    </form>
</div>

<c:import url="footer.jsp"/>
