<%-- 
    Document   : medico
    Created on : 02/12/2019, 21:48:33
    Author     : Leandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medico</title>
    </head>
    <body>
        <h1>Medicos!</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>CRM</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="medico" items="${medicos}">
                <tr>
                    <td>${medico.nome}</td>
                    <td>${medico.telefone}</td>
                    <td>${medico.crm}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
        
    </body>
</html>
