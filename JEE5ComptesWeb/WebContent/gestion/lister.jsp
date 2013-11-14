<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<%@ page language="java" errorPage="erreur.html" %>
<%@page import="fr.univ.savoie.isc.jee.example.comptes.ejb.Operation"%>
<%@page import="fr.univ.savoie.isc.jee.example.comptes.ejb.Compte"%>
<%@page import="javax.naming.*"%>
<%@page import="java.util.*"%>
<%@page import="javax.rmi.PortableRemoteObject"%>

<%@page import="java.text.DecimalFormat"%><html>
<head>
<title>Liste de comptes</title>
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
	String soldeMax = request.getParameter("soldeMax");	
	String numero = request.getParameter("numero");
	String detenteur = request.getParameter("detenteur");
	Iterator iter = null;
	if (soldeMax != null){
		// recuperation de la liste
		double somme = new Double(soldeMax).doubleValue();
		Collection cpts = op.findBySolde(somme);
		iter = cpts.iterator();
	}  else if (detenteur != null) {
		Collection cpts = op.findByOwner(detenteur);
		iter = cpts.iterator();
	}  else if (numero != null) {
		List cpts = new LinkedList();
		cpts.add(op.findByPrimaryKey(numero));
		iter = cpts.iterator();
	}
	if (iter != null && iter.hasNext()) { 
%>
	<table border="1" >
		<tr><th align="right">Numéro</th><th align="right" >Client</th><th align="right" >Solde</th></tr>
	<%	DecimalFormat fmt = new DecimalFormat("#,##0.00");
		while(iter.hasNext()) {
			Compte cpt = (Compte)iter.next(); 
	%>
		<tr>
			<td align="right" width="80"><%=cpt.getNumero() %></td>
			<td align="right" width="80"><%=cpt.getDetenteur().getNumeroClient() %></td>
			<td align="right" width="100"><%=fmt.format(cpt.getSolde()) %></td>
		</tr>
	<%	} %>
	</table>
<%	} %>
</body>
</html>