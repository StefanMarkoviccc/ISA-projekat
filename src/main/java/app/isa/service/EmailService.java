package app.isa.service;

import app.isa.domain.model.User;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Properties;

@Service
public class EmailService implements IEmailService{
    @Override
    public void sendActionEmail(List<User> users) {

    }


   /* @Override
    public void sendActionEmail(List<User> users) {

        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", true);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("isaprojekat13@gmail.com", "testtesttest1");
                }
            });

            String addressList = "";

            for(int i = 0; i < users.size(); i++) {

                if(i == 0) {
                    addressList = addressList + users.get(i).getEmail();
                }
                else {
                    addressList = addressList + "," + users.get(i).getEmail();
                }

            }

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("isaprojekat13@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(addressList));
            message.setSubject("Mail Subject");

            String msg = "Napravljena je nova akcija za kucu na koju ste preplaceni!";

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    */
}
