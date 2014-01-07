<%-- 
    Document   : chatView
    Created on : 6 janv. 2014, 19:48:45
    Author     : hackman
--%>
<%@include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            #chat{
                display: inline-block;
                margin-left: 30px;
                margin-top:30px;
                padding: 50px;
            }            

            
            .myButton {
                        -moz-box-shadow: 3px 4px 0px 0px #8a2a21;
                        -webkit-box-shadow: 3px 4px 0px 0px #8a2a21;
                        box-shadow: 3px 4px 0px 0px #8a2a21;
                        background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #c62d1f), color-stop(1, #f24437));
                        background:-moz-linear-gradient(top, #c62d1f 5%, #f24437 100%);
                        background:-webkit-linear-gradient(top, #c62d1f 5%, #f24437 100%);
                        background:-o-linear-gradient(top, #c62d1f 5%, #f24437 100%);
                        background:-ms-linear-gradient(top, #c62d1f 5%, #f24437 100%);
                        background:linear-gradient(to bottom, #c62d1f 5%, #f24437 100%);
                        filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#c62d1f', endColorstr='#f24437',GradientType=0);
                        background-color:#c62d1f;
                        -moz-border-radius:18px;
                        -webkit-border-radius:18px;
                        border-radius:18px;
                        border:1px solid #d02718;
                        display:inline-block;
                        cursor:pointer;
                        color:#ffffff;
                        font-family:arial;
                        font-size:17px;
                        padding:20px 40px;
                        text-decoration:none;
                        text-shadow:0px 1px 0px #810e05;
                }
                .myButton:hover {
                        background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #f24437), color-stop(1, #c62d1f));
                        background:-moz-linear-gradient(top, #f24437 5%, #c62d1f 100%);
                        background:-webkit-linear-gradient(top, #f24437 5%, #c62d1f 100%);
                        background:-o-linear-gradient(top, #f24437 5%, #c62d1f 100%);
                        background:-ms-linear-gradient(top, #f24437 5%, #c62d1f 100%);
                        background:linear-gradient(to bottom, #f24437 5%, #c62d1f 100%);
                        filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#f24437', endColorstr='#c62d1f',GradientType=0);
                        background-color:#f24437;
                }
                .myButton:active {
                        position:relative;
                        top:1px;
                }
        </style>
        <title>Liste des Chats</title>
    </head>
    <body>

        <div class="container">
            <div class="header">

                <h3 class="text-muted">TP-Chat - Jérémy Marois , Sébastien Tolron</h3>
                <h1>Connecté en tant que  <%= session.getAttribute("pseudo")%>. </h1>  <a href="index.html" > Changer de pseudo. </a> 
            </div>

            <div class="jumbotron">


                <h2> Liste des chats : </h2>
                <div id='listChat' style='min-height: 150px' >
                <c:forEach items="${chatList}" var="chat">

                    <div id="chat">
                        <a href="chat.do?id=<c:out value="${chat.id}"/>" class="myButton"> <c:out value="${chat.name}"/> </a>
                        <a href="modifChat.do?id=<c:out value="${chat.id}"/> " >   <img src="EditObjectButton.png" alt="delete">  </a>
                        <a href="deleteChat.do?id=<c:out value="${chat.id}"/> " >  <img src="DeleteButton.png" alt="delete"> </a>
                    </div>

                </c:forEach>
                </div>
            </div> <!-- /container -->


            <h3> Creer un nouveau Chat </h3>

            <form method="GET" action="creerChat.do" >
                <input type="text" name="nomChat" />
                <input type="submit" value="Creer" />


            </form>


    </body>
</html>

