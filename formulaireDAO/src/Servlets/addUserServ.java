package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Utilisateur;
import DAO.LireDAO;

@WebServlet("/addUser")
public class addUserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public addUserServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd =  getServletContext().getRequestDispatcher("/addUser.jsp");
		
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur u = new Utilisateur();
		
		String nom = request.getParameter("Nom");
		
		String prenom = request.getParameter("Prenom");
		
		String mp = request.getParameter("Mp");
		
		u.setNom(nom);
		
		u.setPrenom(prenom);
		
		u.setMp(mp);
		
		LireDAO.Insert(u);
		
		if(LireDAO.Insert(u) == 1) {
		System.out.println("oui");	
		}
		else
			System.out.println("non");
		}

}
