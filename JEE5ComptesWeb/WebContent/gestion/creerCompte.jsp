<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<%@ page language="java" errorPage="erreur.html" %>
<%@page import="fr.univ.savoie.isc.jee.example.comptes.ejb.Operation"%>
<%@page import="javax.naming.*"%>
<%@page import="javax.rmi.PortableRemoteObject"%>
<html>
<head>
<title>Création d'un compte</title>
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
	String owner = (request.getParameter("detenteur"));
	double somme = new Double(request.getParameter("somme")).doubleValue();
	// execution du transfert
	op.creerCompte(compte, owner, somme);
%>
<br>Le compte a été créé.<br>
</body>
</html>