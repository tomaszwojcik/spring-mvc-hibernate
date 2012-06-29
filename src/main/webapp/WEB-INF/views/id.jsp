<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
${person.firstname} ${person.lastname}
<c:forEach items="${person.dogs}" var="dog">
    <tr>
        <td>${dog.id}</td>
        <td>${dog.name}</td>
    </tr>
</c:forEach>
</body>
</html>