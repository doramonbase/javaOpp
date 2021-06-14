<%-- 
    Document   : index
    Created on : May 15, 2021, 10:04:03 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Quan Ly Hoc Sinh</h1>
        <div align="center">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>markC</th>
                    <th>markPHP</th>
                </tr>
                <c:forEach var="student" items="${listStudent}">
                    <tr>
                        <td><c:out value="${student.id}" /></td>
                        <td><c:out value="${student.name}" /></td>
                        <td><c:out value="${student.email}" /></td>
                        <td><c:out value="${student.address}" /></td>
                        <td><c:out value="${student.markC}" /></td>
                        <td><c:out value="${student.markPHP}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
