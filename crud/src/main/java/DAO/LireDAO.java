package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Beans.Utilisateur;

public class LireDAO {
	
	static Connection conn;
	
	public LireDAO() {
		
		conn = null;
	}
	
	public static boolean getConnection() {
		
			//nom: marley  password: marleyb123
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver ok");
				//String url = "jdbc:mysql://127.0.0.1:3306/crud?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"; 
				//conn = DriverManager.getConnection(url,"root","");
			
				String url = "jdbc:mysql://mysql-matt-dev730.alwaysdata.net:3306/matt-dev730_crud?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
				conn = DriverManager.getConnection(url,"204987_user", "User@123");
				System.out.println("connexion ok");
		  
		  }
		 catch(SQLException | ClassNotFoundException  e)
			{
				System.out.println(e.getMessage());
			}
		
		 if (conn != null )
			 return true;
		 else
			 return false;
	}
	
	public static List<Utilisateur> getAllRecords() {
		
		List <Utilisateur> liste = new ArrayList <Utilisateur>();
				
			try {	
					
				PreparedStatement pstmt = conn.prepareStatement("SELECT id, nom, prenom, motdepasse FROM user");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					Utilisateur u = new Utilisateur();
					u.setId(rs.getString(1));
					u.setNom(rs.getString(2));
					u.setPrenom(rs.getString(3));
					u.setMp(rs.getString(4));
					liste.add(u);
					}
					
			 }
			 
			catch(SQLException e) {
				 
				System.out.println(e.getMessage());
			 		  
			   }
			 
				return liste;
	}
	
	public static int Delete(Utilisateur u) {
		
		int status = 0;
		
		try {	
				
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM user WHERE id = ?");
			pstmt.setString(1, u.getId());		
			status = pstmt.executeUpdate();
					 
		 }
		 
		 catch(SQLException sqlE) {
			 
			System.out.println(sqlE.getMessage());
		 		  
		    }
		 return status;
	}
	
	public static Utilisateur getRecordById(String id){
		
		Utilisateur u = null;
		
		try{
		
			PreparedStatement pstmt = conn.prepareStatement("SELECT id, nom, prenom, motdepasse From user WHERE id=?");
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
					u = new Utilisateur();
					u.setId(rs.getString("id"));
					u.setNom(rs.getString("nom"));
					u.setPrenom(rs.getString("prenom"));
					u.setMp(rs.getString("motdepasse"));
				}
			}
			catch(SQLException e)
			{ 
				System.out.println(e.getMessage());
			}
		return u;
	}
	
	public static int Insert(Utilisateur u) {
		
			int status = 0;
		
		try {	
			
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO user (nom, prenom, motdepasse) VALUES (?,?,?)");
			pstmt.setString(1, u.getNom());
			pstmt.setString(2, u.getPrenom());
			pstmt.setString(3, u.getMp());
						
			status = pstmt.executeUpdate();
				 
		}
	 
		catch(SQLException e) {
		 
			System.out.println(e.getMessage());
	 		  
	    }
		return status;
	}
	
	
	
	public static int Update(Utilisateur u) {
		
		int status = 0;
		
		 try {	
				
				PreparedStatement pstmt = conn.prepareStatement("UPDATE user SET nom=?,prenom=?,motdepasse=? WHERE id =?");
				pstmt.setString(1, u.getNom());
				pstmt.setString(2, u.getPrenom());
				pstmt.setString(3, u.getMp());
				pstmt.setString(4, u.getId());
				
				status = pstmt.executeUpdate();
					 
		 }
		 
		 catch(SQLException e) {
			 
			 System.out.println(e.getMessage());
		 		  
		    }
		 return status;
	}
}