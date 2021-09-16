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

	public void mailGonder(String metin, String baslik, String mailAdresi) {// �yelik maili

		Properties pro = new Properties();
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.socketFactory.port", "465");
		pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.port", "465");
		// Bu yukardaki sabit prot de�erleri bunlara bakmak i�in Java Mail Api Ye bak

		// java.mail olan� import et
		Session session = Session.getDefaultInstance(pro, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// Mail Atmak i�in atacak olan mail de gidip "gmail uygulama �ifresi al "
				// G�nderici mail
				return new PasswordAuthentication("donaexpressltd@gmail.com", "");//buraya �ifreni yaz
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("donaexpressltd@gmail.com"));

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailAdresi));// Al�c�Mail

			message.setSubject(baslik);// Konu

			message.setText(metin);// i�erik
			Transport.send(message);
			System.out.println("Mail G�nderimi Ba�aral�");
		} catch (Exception e2) {
			System.out.println("Mail G�nderimi Ba�aras�z!!");
		}

	}

	public void SifremiUnuttummailGonder(String metin, String baslik, String mailAdresi) {// �ifremi
																							// unuttum
																							// maili

		Properties pro = new Properties();
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.socketFactory.port", "465");
		pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.port", "465");
		// Bu yukardaki sabit prot de�erleri bunlara bakmak i�in Java Mail Api Ye bak

		// java.mail olan� import et
		Session session = Session.getDefaultInstance(pro, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// Mail Atmak i�in atacak olan mail de gidip "gmail uygulama �ifresi al "
				// G�nderici mail
				return new PasswordAuthentication("donaexpressltd@gmail.com", "");//buraya �ifreni yaz
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("donaexpressltd@gmail.com"));

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailAdresi));// Al�c�Mail

			message.setSubject(baslik);// Konu

			message.setText(metin);// i�erik
			Transport.send(message);
			System.out.println("Mail G�nderimi Ba�aral�");
		} catch (Exception e2) {
			System.out.println("Mail G�nderimi Ba�aras�z!!");
		}

	}

}
