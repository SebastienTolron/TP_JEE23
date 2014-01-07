<%-- 
    Document   : chat
    Created on : 6 janv. 2014, 16:01:55
    Author     : hackman
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TP Chat -- Un chat </title>
    </head>
    <body>
        <h1> <c:out value="${chat.name}"/> </h1>
        
        
        
        <form action="postMessage" method="POST">
            <input type="text" name="msg" />
            <input type="submit" value="Nouveau message" />
            <input type="hidden" name="id" value="<c:out value="${chat.id}" />" />
        </form>
    </body>
</html>
