<%-- 
    Document   : Formulario
    Created on : 16/04/2018, 19:45:10
    Author     : vinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
    </head>
    <body>
        <h1>Formulario</h1>
        <form action="FormularioServlet" method="POST">
            <select name="empresa">
                <option value=""></option>
                <option value="Hortifrut Marechal" ${param.empresa eq "Hortifrut Marechal" ? "selected" : ""}>Hortifrut Marechal</option>
                <option value="Mundial" ${param.empresa eq "Mundial" ? "selected" : ""}>Mundial</option>
            </select>${requestScope.msgErrEmpresa}<br>
            <select name="ano">
                <option value=""></option>
                <option value="2017" ${param.ano eq "2017" ? "selected" : ""}>2017</option>
                <option value="2016" ${param.ano eq "2016" ? "selected" : ""}>2016</option>
            </select>${requestScope.msgErrAno}<br>
            <button type="submit"> Enviar </button>
        </form>
    </body>
</html>
