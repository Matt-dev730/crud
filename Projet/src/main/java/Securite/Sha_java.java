package Securite;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

	public class Sha_java{
		
	    String mp;
	
	    public String getSha_java (String motdepasse) throws Exception {
	    	
	     this.mp = motdepasse;
	
	        MessageDigest md = MessageDigest.getInstance("SHA-512");
	        md.update(mp.getBytes());
	
	        byte byteData[] = md.digest();
	
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	
	        return sb.toString();
	}
	
	public static boolean verifyPassword(byte[] mdp1, byte [] mdp2) {
		
		MessageDigest md;
		try {
			
			md = MessageDigest.getInstance("SHA-512");
			return md.isEqual(mdp1, mdp2);
		}
		catch (NoSuchAlgorithmException e) {

			return false;
		}
		
		
	}
}