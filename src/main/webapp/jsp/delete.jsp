<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<body>

<form:form id="deleteForm" modelAttribute="user" action="deleteProcess"
           method="post">
    <table align="center">


        <tr>
            <td><form:label path="rollno">rollno:</form:label></td>
            <td><form:input path="rollno"   name="rollno" id="rollno" /></td>
        </tr>
        <tr>
            <td><form:label path="doexit">dateofexit:</form:label></td>
            <td><form:input path="doexit"   name="doexit" id="doexit" /></td>
        </tr>
        <tr>
            <td></td>
            <td align="left"><form:button id="login" name="login">submit</form:button></td>
        </tr>

        <tr></tr>
        <tr>
            <td></td>
            <td><a href="home.jsp">Home</a></td>
        </tr>
    </table>
</form:form>
<table align="center">
    <tr>
        <td >${message2}</td>

    </tr>
</table>

</body>
</html>