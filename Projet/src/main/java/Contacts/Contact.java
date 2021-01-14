package Contacts;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.Properties;

public class Contact {

    public Contact(String Firstname,String Lastname,String Subject,String Email,String Body) throws IOException {

        final String username = "alichat.contact@gmail.com";
        final String password = "3103@Aiko";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("alichat.contact@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("alichat.contact@gmail.com")
            );
            message.setSubject(Subject);
            message.setText(Email+"\n"+Firstname+" "+Lastname+"\n"+Body);

            Transport.send(message);

            System.out.println("Message envoyé");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}