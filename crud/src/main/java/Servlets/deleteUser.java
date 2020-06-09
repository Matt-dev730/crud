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

@WebServlet(name = "deleteUser", urlPatterns = "/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur UD = LireDAO.getRecordById(request.getParameter("id"));
		
		int i = LireDAO.Delete(UD);
		
		if (i == 1) {
			
			RequestDispatcher rd = request.getRequestDispatcher("listUser");
				rd.forward(request, response);
		}
		
		if (i == 0) {
			
			RequestDispatcher rd = request.getRequestDispatcher("Erreur.jsp");
				rd.forward(request, response);
		}

    }
}
