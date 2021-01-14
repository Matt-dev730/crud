package Beans;

public class CompteClient {
	
	   private String id, nom, prenom, mp, email, adresse, telephone, id_ville;
	   
	public CompteClient() {
		  
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
		
		public String getEmail() {
			return email;
		}
		
		public String getAdresse() {
			return adresse;
		}
		
		public String getTelephone() {
			return telephone;
		}
		
		 public String getId_ville() {
			return id_ville;
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
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		
		public void setId_ville(String id_ville) {
			this.id_ville = id_ville;
		}
	}