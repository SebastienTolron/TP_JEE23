<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<%@page import="javax.ejb.EJB"%>
<%@ page language="java" errorPage="erreur.html" %>
<%@page import="javax.naming.*"%>
<%@page import="javax.rmi.*"%>
<%@page import="fr.univ.savoie.jee.tp.*" %>
<%@page import="fr.univ.savoie.jee.tp.servlet.*" %>
<html>
<head>
<title>Création d'un compte</title>
</head> 
<body bgcolor="#FFFFFF">

<%
	// on recupere le contexte JNDI
	Context initialContext =new InitialContext();
	// optention d'une instance de l'EJB (EJB 3.0)
	ChatManager cm = (ChatManager) PortableRemoteObject.narrow(
				initialContext.lookup("java:comp/env/ejb/ChatManager"),
				ChatManager.class);
	// recuperation des parametres du formulaires
	String nomChat = (request.getParameter("nomChat"));
	String id = (request.getParameter("id"));
	
	int idChat = Integer.decode(id);
	// execution du transfert
	cm.creerChat(idChat,nomChat);
%>
<br>Le compte a été créé.<br>
</body>
</html>