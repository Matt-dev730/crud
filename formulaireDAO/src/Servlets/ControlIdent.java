package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Beans.*;
import Beans.Utilisateur;
import DAO.LireDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

@WebServlet(name = "controlident", urlPatterns = "/controlident")
public class ControlIdent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControlIdent() {
        
    	 super();
     }
     
 	protected void doGet(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
 		RequestDispatcher rd = reqest.getRequestDispatcher("Login.html");
 	        rd.forward(reqest, response);
 	}

 	protected void doPost(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
 			
 		String ident = reqest.getParameter("ident");
 		String mp = reqest.getParameter("mp");
         
 		HttpSession session = reqest.getSession(true);
 			session.setAttribute("ident", ident);
 			session.setAttribute("mp", mp);
         
         RequestDispatcher rd = reqest.getRequestDispatcher("listUser");
         rd.forward(reqest, response);
 	}
 }
