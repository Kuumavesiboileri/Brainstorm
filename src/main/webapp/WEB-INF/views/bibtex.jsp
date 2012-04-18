<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : bibtex
    Created on : 18.4.2012, 12:07:48
    Author     : jarlerik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bibtex</title>
    </head>
    <body>
        <h1>bibtex</h1>
        <c:forEach var="item" items="${bibtexs}">
            <p>${item}</p>
        </c:forEach>
    </body>
</html>
