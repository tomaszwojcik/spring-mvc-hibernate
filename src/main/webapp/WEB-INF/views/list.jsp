<%--
  Created by IntelliJ IDEA.
  User: twojcik
  Date: 15.06.12
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<table class="data">
    <tr>
        <th>Id</th>
        <th>First name</th>
        <th>Last name</th>
    </tr>
    <c:forEach items="${persons}" var="person">
        <tr>
            <td>${person.id}</td>
            <td>${person.firstname}</td>
            <td>${person.lastname}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>