<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>

</head>
<body>
<h2>result values</h2>


<c:if test="${not empty lists}">
<table style="width:100%">
    <tr>
        <th>rollno</th>
        <th>room</th>
        <th>firstname</th>
        <th>lastname</th>
        <th>email</th>
        <th>address</th>
        <th>phone</th>
        <th>doe</th>
        <th>doexit</th>
        <th>status</th>
 </tr>

        <c:forEach var="listValue" items="${lists}">
          <tr>
            <td>${listValue.rollno}</td>
            <td>${listValue.roomno}</td>
            <td>${listValue.firstname}</td>
            <td>${listValue.lastname}</td>
            <td>${listValue.email}</td>
            <td>${listValue.address}</td>
            <td>${listValue.phone}</td>
            <td>${listValue.doe}</td>
              <td>${listValue.doexit}</td>
              <td>${listValue.status}</td>
          </tr>
        </c:forEach>


</table>
</c:if>
</body>
</html>