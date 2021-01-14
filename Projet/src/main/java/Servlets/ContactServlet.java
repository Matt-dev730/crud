package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Contacts.Contact;

public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ContactServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @SuppressWarnings("unused")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String Firstname= request.getParameter("Nom");
        String Lastname =request.getParameter("Prenom");
        String Subject = request.getParameter("Mail");
        String Email= request.getParameter("Objet");
        String Body = request.getParameter("Message");



        if (Body != "" && Firstname != "" && Lastname != "" && Subject != "" && Email != "") {

        	Contact mail= new Contact(Firstname, Lastname, Subject, Email, Body);
            getServletContext().getRequestDispatcher("/MessageTransmit.jsp").forward(request, response);
        }

        else {
            getServletContext().getRequestDispatcher("/MessageNonTransmit.jsp").forward(request, response);

	    }
	
	}
}