<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="user-list">
    <h3>List of users:</h3>
    <table>
        <thead>
            <th class="user-list-head">User Name</th>
            <th class="user-list-head">Email</th>
            <th class="user-list-head">Password</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
                <tr>
                    <td class="user-list-body">${user.name}</td>
                    <td class="user-list-body">${user.email}</td>
                    <td class="user-list-body">${user.password}</td>
                </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
