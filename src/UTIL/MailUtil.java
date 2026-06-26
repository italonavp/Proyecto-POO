package UTIL;

import java.io.File;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtil {

    private static final String CORREO_ORIGEN = "proyectop572@gmail.com";
    private static final String CONTRA = "cajf qbla rujd joxi";
    
    public static boolean sendTo(String destinatario, String asunto, String mensaje, String rutaFile) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CORREO_ORIGEN, CONTRA);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(CORREO_ORIGEN));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));

            msg.setSubject(asunto);
            
            MimeBodyPart text = new MimeBodyPart();
            text.setText(mensaje);
            
            MimeBodyPart archivo = new MimeBodyPart();
            archivo.attachFile(new File(rutaFile));
            
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(archivo);
            multipart.addBodyPart(text);
            
            msg.setContent(multipart);
            
            Transport.send(msg);
            
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
