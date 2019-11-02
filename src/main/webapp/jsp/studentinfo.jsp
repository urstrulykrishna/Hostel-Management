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

<form:form id="doeForm2"  action="studentinfo"
           method="post">
    <table align="center">

        <td align="left"><form:button id="login" name="login">getDetails of student</form:button></td>



        <tr>
            <td></td>
            <td><a href="home.jsp">Home</a></td>
        </tr>
    </table>
</form:form>


</body>
</html>