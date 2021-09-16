import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Helper {

	public void mailGonder(String metin, String baslik, String mailAdresi) {// Üyelik maili

		Properties pro = new Properties();
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.socketFactory.port", "465");
		pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.port", "465");
		// Bu yukardaki sabit prot deðerleri bunlara bakmak için Java Mail Api Ye bak

		// java.mail olaný import et
		Session session = Session.getDefaultInstance(pro, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// Mail Atmak için atacak olan mail de gidip "gmail uygulama þifresi al "
				// Gönderici mail
				return new PasswordAuthentication("donaexpressltd@gmail.com", "");//buraya þifreni yaz
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("donaexpressltd@gmail.com"));

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailAdresi));// AlýcýMail

			message.setSubject(baslik);// Konu

			message.setText(metin);// içerik
			Transport.send(message);
			System.out.println("Mail Gönderimi Baþaralý");
		} catch (Exception e2) {
			System.out.println("Mail Gönderimi Baþarasýz!!");
		}

	}

	public void SifremiUnuttummailGonder(String metin, String baslik, String mailAdresi) {// Þifremi
																							// unuttum
																							// maili

		Properties pro = new Properties();
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.socketFactory.port", "465");
		pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.port", "465");
		// Bu yukardaki sabit prot deðerleri bunlara bakmak için Java Mail Api Ye bak

		// java.mail olaný import et
		Session session = Session.getDefaultInstance(pro, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// Mail Atmak için atacak olan mail de gidip "gmail uygulama þifresi al "
				// Gönderici mail
				return new PasswordAuthentication("donaexpressltd@gmail.com", "");//buraya þifreni yaz
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("donaexpressltd@gmail.com"));

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailAdresi));// AlýcýMail

			message.setSubject(baslik);// Konu

			message.setText(metin);// içerik
			Transport.send(message);
			System.out.println("Mail Gönderimi Baþaralý");
		} catch (Exception e2) {
			System.out.println("Mail Gönderimi Baþarasýz!!");
		}

	}

}
