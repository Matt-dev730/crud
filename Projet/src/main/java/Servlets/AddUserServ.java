package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.CompteClient;
import Beans.Ville;
import DAO.UtilisateurDAO;
import Securite.Sha_java;

public class AddUserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    @Override
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doCreate(request, response);}
    
    @Override
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doCreate(request, response);
    }

	private void doCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CompteClient compteClient = new CompteClient();
		
		Ville ville = new Ville();
		
		compteClient.setNom(request.getParameter("Nom"));
		
		compteClient.setPrenom(request.getParameter("Prenom"));
		
		compteClient.setEmail(request.getParameter("Email"));
		
		compteClient.setTelephone(request.getParameter("Telephone"));
		
		compteClient.setAdresse(request.getParameter("Adresse"));
		
		String Mp = request.getParameter("Mp");
		
		Sha_java Mdp = new Sha_java(); 
		
		try {
			compteClient.setMp(Mdp.getSha_java(Mp));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		ville.setCp(request.getParameter("CodePostal"));
		
		ville.setNom(request.getParameter("Ville"));
		
		UtilisateurDAO.getConnection();
		
		int i;
		try {
			i = UtilisateurDAO.Insert(compteClient, ville);
			
			if(i == 1) {
				this.getServletContext().getRequestDispatcher("/listUser").forward(request, response);
			}
			
			if(i == 0) {
				this.getServletContext().getRequestDispatcher("/Erreur.jsp").forward(request, response);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}
}