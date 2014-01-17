/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import ejb.Chat;
import ejb.Message;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.ChatManager;
import session.MessageManager;

/**
 *
 * @author hackman
 */
@WebServlet(name = "ServletPost", urlPatterns = {"/postMessage.do"})
public class ServletPost extends HttpServlet {

    @EJB
    ChatManager em;
    
    @EJB
    MessageManager em1;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String VUE = "/ChatTP-war/chat.do?id="+request.getParameter("id");
        HttpSession session = request.getSession();
        
        Date today = new Date();
        int heure = today.getHours();
        int minute = today.getMinutes();
        int seconds = today.getSeconds();
        String hString = String.valueOf(heure);
        String sString = String.valueOf(seconds);
        String mString = String.valueOf(minute);
        if (heure < 10)
        {
            hString = "0"+String.valueOf(heure);
        }
          if (minute < 10)
        {
            mString = "0"+String.valueOf(minute);
        }
            if (seconds < 10)
        {
            sString = "0"+String.valueOf(seconds);
        }
        String temps = hString+":"+mString+":"+sString;
  
        
        Chat c2 = em.findChat(Long.parseLong(request.getParameter("id")));
        Message m1 = new Message(session.getAttribute("pseudo").toString(),request.getParameter("msg"),temps);
        em1.saveMessage(m1);
        em.postMessage(c2,m1);
      
        
        response.sendRedirect(VUE);
        //this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
