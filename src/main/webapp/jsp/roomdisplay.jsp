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
            <th>roomno</th>
            <th>type of room</th>
            <th>current count</th>

        </tr>

        <c:forEach var="listValue" items="${lists}">
            <tr>
                <td>${listValue.roomno}</td>
                <td>${listValue.nop}</td>
                <td>${listValue.cstatus}</td>

            </tr>
        </c:forEach>


    </table>
</c:if>
</body>
</html>