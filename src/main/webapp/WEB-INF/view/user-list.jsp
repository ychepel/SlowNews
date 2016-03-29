<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp"/>
<div class="user-list">
    <h3>List of users:</h3>
    <table>
        <thead>
            <th>User Name</th>
            <th>Email</th>
            <th>Password</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<c:import url="footer.jsp"/>
