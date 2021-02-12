<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Customer</title>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
          </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>
        <form:form action="saveCustomer" modelAttribute="customer" method="POST">
            <form:hidden path="id"/>
            <table>
                <tbody>
                    <tr>
                        <td><label>First Name: </label></td>
                        <td><form:input path="firstName"/></td>
                    </tr>
                    <tr>
                        <td><label>Last Name: </label></td>
                        <td><form:input path="lastName"/></td>
                    </tr>
                    <tr>
                        <td><label>email: </label></td>
                        <td><form:input path="email"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="save"></td>
                    </tr>
                </tbody>
            </table>
            <a href="${pageContext.request.contextPath}/customer/list">back to list</a>
        </form:form>
    </div>
</body>
</html>
