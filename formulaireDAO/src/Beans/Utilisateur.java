package Beans;

public class Utilisateur {
	
	   private String id, nom, prenom, mp;
	   
	   public Utilisateur(){
		  
	   }
	   
	    public String getNom() {
			return nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public String getId() {
			return id;
		}

		public String getMp() {
			return mp;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
			
		}

		public void setNom(String nom) {
			this.nom = nom;
			
		}

		public void setId(String id) {
			this.id = id;
			
		}

		public void setMp(String mp) {
			this.mp = mp;
			
		}
	}