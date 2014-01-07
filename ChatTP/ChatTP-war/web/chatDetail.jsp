<%-- 
    Document   : chatDetail
    Created on : 6 janv. 2014, 20:13:14
    Author     : hackman
--%>
<%@include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script type="text/javascript">
            $(document).ready(function() {
                // Create a jqxLinkButton widget.
                $("#jqxButton").jqxLinkButton({width: '200', height: '30'});
            });
        </script>
        <script type="text/javascript">
            $(document).ready(function() {
                // Create jqxPanel
                $("#jqxWidget").jqxPanel({width: 700, height: 400});
            });
        </script>
        
         <script type="text/javascript">
            $(document).ready(function () {
                
                $("#input").jqxInput({placeHolder: "Entrez un message.", height: 25, width: 200, minLength: 1 });
            });
        </script>
        
        
        <title>Chat en cours </title>
    </head>
    <body>
        <div class="container">
            <div class="header">

                <h3 class="text-muted">TP-Chat - Jérémy Marois , Sébastien Tolron</h3>
                <h1>Connecté en tant que  <%= session.getAttribute("pseudo")%>.</h1>   <a href="index.html" > Changer de pseudo. </a> 

            </div>




            <div class="jumbotron" style='padding-bottom: 15px;'>

                <div>
                    <h2>Bienvenue dans le chat <c:out value="${chat.name}"/> </h2> 
                </div>

              

                <div id='jqxWidget' style=" font-size: 13px; font-family: Verdana;">

                    <div style='white-space: nowrap;'>
                        <div style='min-height: 400px;' >
                  <div id='listChat' style='min-height: 150px' >
                    <c:forEach items="${messageList}" var="message">

                        <div id="chat">
                            <br><p><c:out value="${message.pseudo}"/>:  <c:out value="${message.contenu}"/> </p>
                        </div>
                    </c:forEach>
                </div>
                    </div>
                </div>            
            </div>
                
         
          <form action="postMessage.do" method="POST">
                        <input type="text" id='input' name="msg" />
                        <input type="submit" value="Nouveau message" />
                        <input type="hidden" name="id" value="<c:out value="${chat.id}" />" />
                    </form>
            <div style='width:200px; margin-top: 40px;' id='jqxWidget'>
                <div>
                    <a style='margin-left: 25px;' href="accueil.do" id='jqxButton'>Retourner à l'accueil </a>
                </div> 
            </div>
    </body>
</html>
