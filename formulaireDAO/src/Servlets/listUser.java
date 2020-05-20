package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import Beans.Utilisateur;
import DAO.LireDAO;

@WebServlet(name ="listUser", urlPatterns = "/listUser")
public class listUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
		List <Utilisateur> liste;
    
	public listUser() {
        super();
        
        liste = null;
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		JOptionPane.showMessageDialog( null, "doGet  in Servlet listUser");
		executeQuery(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JOptionPane.showMessageDialog( null, "doPost in Servlet listUser");
		executeQuery(request, response);
		}
	
	public void executeQuery(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
			if(!LireDAO.getConnection())
			{
				//request.getRequestDispatcher("/NoOk.html");
		    	PrintWriter out = response.getWriter();  
		        out.print("<html><body>");  
		        out.print("<b>connexion data base impossible</b>");  
		        out.print("</body></html>");
		        return;
		    }
				
			
			liste = LireDAO.getAllRecords();
		   
			request.setAttribute("list",liste);
		    RequestDispatcher rd = request.getRequestDispatcher("ViewUser.jsp");
		    rd.forward(request, response);
	}
}
