package fr.univ.savoie.jee.tp.servlet;
/*
 * Created on 18 nov. 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import fr.univ.savoie.jee.tp.ChatManager;

/**
 * @author Stephane Talbot
 *
 * La servlet permet de transferer de l'argent d'un compte vers un autre
 * 
 */
public class Servlet extends HttpServlet {

	@EJB(name="ejb/ChatManager")
	ChatManager chatmanagerBean ;

	/** 
	 * Il s'agit d'une servlet qui fonctionne avec la methode GET
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		try {
			// recuperation des parametres du formulaires
		
			// execution du transfert
			chatmanagerBean.creerChat(1, "Chat1");
			out.println("<br>le transfert a été effectué<br>");
		} catch (Exception e) {
			out.println("<br>erreur lors du transfert<br>");
			return;
		}
	}

}
