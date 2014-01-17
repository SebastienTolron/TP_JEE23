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
        <title>Liste des Chats</title>
        <script type="text/javascript">
            $(document).ready(function() {
                var theme = "Bootstrap"

                // Application de JqxWidget sur la pop_up  Creer

                $("#jqxRadioButton").jqxRadioButton({width: 250, height: 25, checked: true, theme: theme});
                $("#jqxRadioButton2").jqxRadioButton({width: 250, height: 25, theme: theme});
                $("#txtInput").jqxInput({placeHolder: "Entrer un nom ", height: 25, width: 200, minLength: 1, theme: "bootstrap"});
                $("#Button").jqxButton({theme: theme});
                $("#ButtonClose").jqxButton({theme: theme});
                $('#ButtonClose').on('click', function() {
                    window.location.href = "accueil.do";
                });

                $('#Button').on('click', function() {
                    $('.formV').jqxValidator('validate');
                });


                $('.formV').on('validationSuccess', function(event) {

                    var checked = $('#jqxRadioButton').jqxRadioButton('checked');

                    window.location.href = "creerChat.do?nomChat=" + $('#txtInput').val() + "&RbChat=" + checked;
                });

                $('.formV').jqxValidator({
                    rules: [
                        {input: '#txtInput', message: 'Le nom est obligatoire ', action: 'keyup, blur', rule: 'required'},
                        {input: '#txtInput', message: 'le nom etre entre 3 et 20 caractères!', action: 'keyup, blur', rule: 'length=3,20'}
                    ], theme: theme

                });


                // Application de JqxWidget sur la pop_up Modifier

                $("#txtInput2").jqxInput({height: 25, width: 200, minLength: 1, theme: "bootstrap"});
                $("#ButtonCloseM").jqxButton({theme: theme});
                $('#ButtonCloseM').on('click', function() {
                    window.location.href = "accueil.do";
                });
                $("#jqxRadioButtonM").jqxRadioButton({width: 250, height: 25, checked: true, theme: theme});
                $("#jqxRadioButton2M").jqxRadioButton({width: 250, height: 25, theme: theme});
                $("#ButtonM").jqxButton({theme: theme});
                $('#ButtonM').on('click', function() {
                    $('.formM').jqxValidator('validate');
                });
                

                $('.formM').on('validationSuccess', function(event) {

                    var checked2 = $('#jqxRadioButtonM').jqxRadioButton('checked');

                    window.location.href = "modifChat.do?nomChat=" + $('#txtInput2').val() + "&RbChat=" + checked2+"&idChatM="+ $('#idChat').val();
                });

                $('.formM').jqxValidator({
                    rules: [
                        {input: '#txtInput2', message: 'Le nom est obligatoire ', action: 'keyup, blur', rule: 'required'},
                        {input: '#txtInput2', message: 'le nom etre entre 3 et 20 caractères!', action: 'keyup, blur', rule: 'length=3,20'}
                    ], theme: theme

                });


                // Jquery General
                $('.linkModif').on('click', function() {
                    $("#idChat").val(this.id);
                    $("#textInput2").val($("#nomChatl").text());
                    var etatC = $("#etatChatl").text();
                    if ( etatC == 'true')
                    {
                        jQuery("#radio_1").attr('checked', 'checked');
                    }
                    else
                    {
                        jQuery("#radio_1").attr('checked', 'checked');
                    }
                });
              
            });
        </script>

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

                        <div style="display: none">
                            <p id="nomChatl"><c:out value="${chat.name}"/></p>
                            <p id="etatChatl"><c:out value="${chat.etat}"/></p>
                        </div>
                        <c:set var="etatChat" value="${chat.etat}"/>
                        <div id="chat" style="padding:22px;">
                            <c:if  test="${etatChat == 'true'}">                                
                                <a href="chat.do?id=<c:out value="${chat.id}"/>" class="myButton" > <c:out value="${chat.name}"/> </a>
                                
                            </c:if> 
                            <c:if  test="${etatChat == 'false'}">
                                <a class="myButtonDisabled"> <c:out value="${chat.name}"/> </a>
                            </c:if> 

                            <a class="linkModif" id="<c:out value="${chat.id}"/>" href="#openModal2"  >   <img src="EditObjectButton.png" alt="delete">  </a>
                            <a href="deleteChat.do?id=<c:out value="${chat.id}"/> " >  <img src="DeleteButton.png" alt="delete"> </a>

                            <c:if  test="${etatChat == 'false'}">
                                <p style="margin-left: 30px"> Fermé </p>
                            </c:if> 
                            <c:if  test="${etatChat == 'true'}">
                                <p style="margin-left: 30px"> Ouvert </p>
                            </c:if> 
                        </div>

                    </c:forEach>
                </div>
            </div> <!-- /container -->


            <a href="#openModal"> <h3> Creer un nouveau Chat </h3> </a>




            <div id="openModal" class="modalDialog">

                <div >
                    <h1> Creer un Chat<h2>
                            <form class="formV">
                                <input id ="txtInput" type="text" name="nomChat" />

                                <div style='margin-top: 10px;' id='jqxRadioButton'>
                                    Ouvert</div>
                                <div style='margin-top: 10px;' id='jqxRadioButton2'>
                                    <span>Fermé</span></div>
                                <div style='margin-top: 10px;' id='Button'>
                                    <span>Creer</span></div>

                                <div style='margin-top: 10px;' id='ButtonClose'>
                                    <span>Quitter</span></div>      
                            </form>
                            </div>

                            </div>


                            <div id="openModal2" class="modalDialog">

                                <div>
                                    <h1> Modifier un Chat<h2>
                                            <form class="formM">
                                                <input id ="txtInput2" type="text" name="nomChatM" />

                                                <div style='margin-top: 10px;' id='jqxRadioButtonM'>
                                                    Ouvert</div>
                                                <div style='margin-top: 10px;' id='jqxRadioButton2M'>
                                                    <span>Fermé</span></div>
                                                <div style='margin-top: 10px;' id='ButtonM'>
                                                    <span>Modifier</span></div>

                                                <div style='margin-top: 10px;' id='ButtonCloseM'>
                                                    <span>Quitter</span></div>      

                                                <input id="idChat" type="hidden" name="idChatM" value=" "/> 
                                            </form>
                                            </div>

                                            </div>




                                            </body>
                                            </html>

