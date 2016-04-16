<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="/WEB-INF/view/header.jsp"/>

<div class="main-content">
    <c:import url="/WEB-INF/view/message.jsp"/>
    <div class="user-form">
        <form id="signup-form" class="user-form">
            <ul class="signup-list">
                <li class="form-field"><input class="form-input" type="text" name="username" placeholder="Enter User Name" required="required"></li>
                <li class="form-field"><input class="form-input" type="email" name="email" placeholder="Enter Email Address" required="required""></li>
                <li class="form-field"><input class="form-input" type="password" name="password" placeholder="Enter Password" required="required"></li>
                <li class="form-field"><button class="form-button" type="submit">Create New Account</button></li>
            </ul>
        </form>
    </div>
</div>