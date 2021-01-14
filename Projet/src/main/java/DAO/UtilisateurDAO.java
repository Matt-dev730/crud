package DAO;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.CompteClient;
import Beans.Ville;
import Securite.Sha_java;

public class UtilisateurDAO {
	
	static Connection conn;
	
	static Connection connectJavaSql;
	
	static CompteClient user;
	
	public UtilisateurDAO() {
		
		conn = null;
	}
	
	public static Connection getConnection() {
		
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver ok");
			    String url = "jdbc:mysql://127.0.0.1:3306/alichat?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"; 
				conn = DriverManager.getConnection(url,"root","");
				//String url = "jdbc:mysql://mysql-matt-dev730.alwaysdata.net:3306/matt-dev730_project?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"; 
				//conn = DriverManager.getConnection(url,"204987_lilice", "Aiko123");
				System.out.println("connexion ok");
		  
		  }
		 catch(SQLException | ClassNotFoundException  e)
			{
				System.out.println(e.getMessage());
			}
		return conn;
	}
	
	public static void closeConnexion(Connection connectJavaSql) {
        try {
            connectJavaSql.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
			
	public static List<CompteClient> getAllRecords() {
		
		List <CompteClient> liste = new ArrayList <CompteClient>();
				
			try {	
					
				PreparedStatement pstmt = conn.prepareStatement("SELECT id_compteclient, nom, prenom, motdepasse, adresse, email, telephone FROM compteclient");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					CompteClient u = new CompteClient();
					u.setId(rs.getString(1));
					u.setNom(rs.getString(2));
					u.setPrenom(rs.getString(3));
					u.setMp(rs.getString(4));
					u.setAdresse(rs.getString(5));
					u.setEmail(rs.getString(6));
					u.setTelephone(rs.getString(7));
					liste.add(u);
					}
					
			 }
			 
			catch(SQLException e) {
				 
				System.out.println(e.getMessage());
			 		  
			   }
			 
				return liste;
	}
	
	public static int Delete(CompteClient c) {
		
		int status = 0;
		
		try {	
				
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM compteclient WHERE id = ?");
			pstmt.setString(1, c.getId());		
			status = pstmt.executeUpdate();
					 
		 }
		 
		 catch(SQLException sqlE) {
			 
			System.out.println(sqlE.getMessage());
		 		  
		    }
		 return status;
	}
	
	public static CompteClient getRecordByEmail(String email){
		
		getConnection();
		CompteClient c = null;
		Ville v = null;
		
		try{
		
			PreparedStatement pstmt = conn.prepareStatement("SELECT id_compteclient, nom, prenom, motdepasse, adresse, email, telephone From compteclient WHERE email=?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
					c = new CompteClient();
					v = new Ville();
					
					c.setId(rs.getString("id_compteclient"));
					c.setNom(rs.getString("nom"));
					c.setPrenom(rs.getString("prenom"));
					c.setMp(rs.getString("motdepasse"));
					c.setAdresse(rs.getString("Adresse"));
					c.setEmail(rs.getString("email"));
					c.setTelephone(rs.getString("telephone"));
					v.setCp(rs.getString("CodePostal"));
				}
			}
			catch(SQLException e)
			{ 
				System.out.println(e.getMessage());
			}
		return c;
	}
	
	public static int Insert(CompteClient c, Ville v) throws Exception {
			
			Sha_java mdpHash = new Sha_java();
			
			int status = 0;
			
			String Hash = mdpHash.getSha_java(c.getMp());
			
		try {	
			
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO compteclient (nom, prenom, motdepasse, adresse, email, telephone, id_ville) VALUES (?,?,?,?,?,?, (SELECT `id_ville` FROM ville WHERE code_postale = ?))");
			pstmt.setString(1, c.getNom());
			pstmt.setString(2, c.getPrenom());
			pstmt.setString(3, Hash);
			pstmt.setString(4, c.getAdresse());
			pstmt.setString(5, c.getEmail());
			pstmt.setString(6, c.getTelephone());
			pstmt.setString(7, v.getCp());
			
			status = pstmt.executeUpdate();
			
			conn.setAutoCommit(false);
			conn.commit();
		
		}
	 
		catch(SQLException e) {
		 
			System.out.println(e.getMessage());
	 		  
	    }
		return status;
	}
	
	public static int Update(CompteClient c) {
		
		int status = 0;
		
		 try {	
				
				PreparedStatement pstmt = conn.prepareStatement("UPDATE compteclient SET nom=?, prenom=?, motdepasse=?, id_compteclient, adresse=?, email=?, telephone=? WHERE id =?");
				pstmt.setString(1, c.getNom());
				pstmt.setString(2, c.getPrenom());
				pstmt.setString(3, c.getMp());
				pstmt.setString(4, c.getAdresse());
				pstmt.setString(5, c.getEmail());
				pstmt.setString(6, c.getTelephone());
				pstmt.setString(7, c.getId());
				
				status = pstmt.executeUpdate();
					 
		 }
		 
		 catch(SQLException e) {
			 
			 System.out.println(e.getMessage());
		 		  
		    }
		 return status;
	}
	
	public static CompteClient Connexion(String email, String mp) throws SQLException {
      
        PreparedStatement pstmt;
		ResultSet rs;
		
		try (Connection conn = UtilisateurDAO.getConnection()){
            connectJavaSql = UtilisateurDAO.getConnection();
            pstmt = conn.prepareStatement("SELECT email FROM compteclient WHERE email = ?");
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            rs.next();
            rs.getString(1);
            if(rs.getString(1).equals(email)) {
             }
        } catch (SQLException e) {
            System.out.println("Impossible de trouver un utilisateur avec l'email : " + email );
            return user;
        }
        try {
            conn = UtilisateurDAO.getConnection();
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(mp.getBytes());

            byte byteData[] = md.digest();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            String mdpHash = (String) sb.toString();

            System.out.println("Mot de passe (saisie clavier) : " + mp + " - Mot de passe haché en hexadécimal : " + mdpHash);
            
           
            pstmt = conn.prepareStatement("SELECT email, nom, prenom, motdepasse, phone FROM compteclient WHERE email = ?");
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            rs.next();
            
            	user = new CompteClient();
            	
            	user.setNom(rs.getString(1));
            	user.setPrenom(rs.getString(2));
            	user.setMp(rs.getString(3));
            	user.setEmail(rs.getString(4));
            	user.setAdresse(rs.getString(5));
            	user.setTelephone(rs.getString(6));
            	
            closeConnexion(conn);
        } catch (Exception e) {
            System.out.println("Impossible de trouver un Utilisateur avec le mot de passe : " + mp);
        }
        return user;
    }
}