package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.CompteClient;
import DAO.UtilisateurDAO;

public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
		CompteClient liste;
    
	public ListUser() {
        super();
        
        liste = null;
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		executeQuery(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		executeQuery(request, response);
		}
	
	public void executeQuery(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
			if(UtilisateurDAO.getConnection() != null)
			{
				this.getServletContext().getRequestDispatcher("/CompteCree.jsp").forward(request, response);
		    }
				
			
			try {
				liste = UtilisateurDAO.Connexion(null, null);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		   
			request.setAttribute("list",liste);
			this.getServletContext().getRequestDispatcher("/MonCompte.jsp").forward(request, response);
	}
}