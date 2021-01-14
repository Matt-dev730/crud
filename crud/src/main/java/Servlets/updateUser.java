package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Utilisateur;
import DAO.LireDAO;

@WebServlet(name = "update", urlPatterns = "/update")

public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		@Override
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String id = request.getParameter("id");
			//affiche id 
		
			LireDAO.getConnection();
			
			Utilisateur user = null;
			   
			user = LireDAO.getRecordById(id);
			
				ServletContext context = getServletContext();
					context.setAttribute("user",user);
			
		
			
			
				RequestDispatcher rd =  getServletContext().getRequestDispatcher("/editForm.jsp");
					rd.forward(request, response);
			
	
		
		}
	    
	    @Override
	    
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	    	
	    	
	    	
	    	Utilisateur u = new Utilisateur();
	    	u.setId(request.getParameter("id"));
			
	    	u.setNom(request.getParameter("Nom"));
			
			u.setPrenom(request.getParameter("Prenom"));
			
			u.setMp(request.getParameter("Mp"));
			
			LireDAO.getConnection();
			
		
			int i = LireDAO.Update(u);
			
			if(i == 1) {
				RequestDispatcher rd = request.getRequestDispatcher("listUser");
				rd.forward(request, response);
			}
			
			if(i == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("Erreur.jsp");
				rd.forward(request, response);
			}
		}
}
