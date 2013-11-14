<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<%@ page language="java" errorPage="erreur.html" %>
<%@page import="javax.naming.*"%>
<%@page import="javax.rmi.PortableRemoteObject"%>
<%@page import="fr.univ.savoie.isc.jee.example.comptes.ejb.Operation"%>
<html>

<head>
<title>Opération de débit sur un compte</title>
</head>
<body bgcolor="#FFFFFF">

<%
	// on recupere le contexte JNDI
	Context initialContext =new InitialContext();
	// optention d'une instance de l'EJB (EJB 3.0)
	Operation op = (Operation) PortableRemoteObject.narrow(
				initialContext.lookup("java:comp/env/ejb/Operation"),
				Operation.class);
	// recuperation des parametres du formulaires
	String compte = (request.getParameter("compte"));
	double somme = new Double(request.getParameter("somme")).doubleValue();
	// execution du transfert
	op.debiter(compte, somme);
%>
<br>le débit a été effectué<br>
</body>
</html>