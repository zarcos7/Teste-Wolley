<%-- 
    Document   : index
    Created on : 23/10/2019, 20:52:05
    Author     : wolley
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <input type="button" value="Medico" onclick="window.location.href='medico.jsp'" submit="medico.jsp" />
        <h1>Clientes!</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Telefone</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cliente" items="${clientes}">
                <tr>
                    <td>${cliente.nome}</td>
                    <td>${cliente.telefone}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
        
    </body>
</html>
