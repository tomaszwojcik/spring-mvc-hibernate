<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>
<%-- command name = bean name --%>
<form:form method="POST" commandName="person">
    <table>
        <tr>
            <td>Firstname:</td>
            <td><form:input path="firstname"/></td>
        </tr>
        <tr>
            <td>Lastname:</td>
            <td><form:input path="lastname"/></td>
        </tr>
    </table>
    <div class="form-buttons">
        <div class="button"><input name="submit" type="submit"/></div>
    </div>
</form:form>
</body>

</html>