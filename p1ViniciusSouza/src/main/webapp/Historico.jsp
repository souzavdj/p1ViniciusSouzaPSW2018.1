<%-- 
    Document   : historico
    Created on : 16/04/2018, 20:33:02
    Author     : vinicius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cefetrj.br.p1viniciussouza.model.Empresa"%>
<%@page import="com.cefetrj.br.p1viniciussouza.model.Orcamento"%>
<%@taglib prefix="tags" uri="WEB-INF/tagsLib.tld"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historico</title>
    </head>
    <body>
        <h1>Historico</h1>
        
        <form action="HistoricoServlet" method="POST">
            Codigo:              <input type ="text" name="codigo" value="${param.codigo}">${requestScope.msgErrCodigo}<br>
            Valor Realizado:        <input type ="text" name="valorRealizado" value="${param.valorRealizado}">${msgErrValorRealizado}<br>
            <button type="submit"> Enviar </button>
        </form><br>
        
        <table border="1">
            <core:forEach items="${applicationScope.empresa.orcamentos}" var="orcamento" varStatus="statusOrcamento">
                    <thead>
                        <tr>
                            <th scope="col">Orcamento de ${orcamento.getAno()}</th>
                            <th scope="col">Orçado</th>
                            <th scope="col">Realizado</th>
                            <th scope="col">Comprometido</th>
                            <th scope="col">Disponivel</th>
                        </tr>
                    </thead>
                    <tbody>
                    <core:forEach items="${orcamento.getContas()}" var="conta" varStatus="statusConta">
                        <tags:BuscarSubContasTagController conta="${conta}"/>
                    </core:forEach>
                    </tbody>
            </core:forEach>
        </table>
    </body>
</html>
