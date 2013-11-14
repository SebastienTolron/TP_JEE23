<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<%@ page language="java" errorPage="erreur.html" %>
<%@page import="fr.univ.savoie.isc.jee.example.comptes.ejb.Operation"%>
<%@page import="javax.naming.*"%>
<%@page import="javax.rmi.PortableRemoteObject"%>
<html>
<head>
<title>Création d'un Client</title>
</head>
<body bgcolor="#FFFFFF">
<jsp:useBean id="client" class="fr.univ.savoie.isc.jee.example.comptes.ejb.Client"></jsp:useBean>
<%-- recuperation des parametres du formulaires --%>
<jsp:setProperty name="client"  property="*" />
<%
	// on recupere le contexte JNDI
	Context initialContext =new InitialContext();
	// optention d'une instance de l'EJB (EJB 3.0)
	Operation op = (Operation) PortableRemoteObject.narrow(
				initialContext.lookup("java:comp/env/ejb/Operation"),
				Operation.class);
	// creation
	op.creerClient(client);
%>
<br>Le client a été créé.<br>
</body>
</html>