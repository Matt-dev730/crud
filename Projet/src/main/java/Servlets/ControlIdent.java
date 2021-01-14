package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.CompteClient;
import DAO.UtilisateurDAO;
import Securite.Sha_java;


public class ControlIdent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UtilisateurDAO connexion;
     List<CompteClient> listUser;
    public ControlIdent() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doConnect(request, response);}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doConnect(request, response);
			}

	private void doConnect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String email=request.getParameter("email");
		String mp=request.getParameter("mp");
		
		CompteClient user = UtilisateurDAO.getRecordByEmail(email);
		
		String mdpHash = null;
		Sha_java Mdp = new Sha_java();
		
		try {
			mdpHash = Mdp.getSha_java(mp);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		byte [] mdp1 = mdpHash.getBytes();
		byte [] mdp2 = user.getMp().getBytes();
		
		if (Sha_java.verifyPassword(mdp1, mdp1)) {
			
			/*listUser  =  UtilisateurDAO.getAllRecords();
			request.setAttribute("list",listUser);*/
			
			
		    RequestDispatcher rd = request.getRequestDispatcher("MonCompte.jsp");
		    rd.forward(request, response);
		    
		    
		}
		
		else {
			 RequestDispatcher rd = request.getRequestDispatcher("ConnexionError.jsp");
		     rd.forward(request, response);
		}
	}
}