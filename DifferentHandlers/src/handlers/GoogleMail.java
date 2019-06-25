package handlers;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class GoogleMail {

	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;

	public static void main(String args[]) throws AddressException,
			MessagingException {

		GoogleMail javaEmail = new GoogleMail();

		javaEmail.setMailServerProperties();
		javaEmail.createEmailMessage();
		javaEmail.sendEmail();
	}

	public void setMailServerProperties() {

		String emailPort = "587";//gmail's smtp port

		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("setting mail server properties");

	}

	public void createEmailMessage() throws AddressException,
			MessagingException {
		String[] toEmails = { "abhi.abhinav0209@gmail.com" };
		String emailSubject = "Java Email";
		String emailBody = "This is an java email demo.";

		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);
		System.out.println("mailsession starting");

		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}

		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");//for a html email
		//emailMessage.setText(emailBody);// for a text email
		System.out.println("setting mail subject");

	}

	public void sendEmail() throws AddressException, MessagingException {

		String emailHost = "smtp.gmail.com";
		String fromUser = "mail.priyakri12@gmail.com";//just the id alone without @gmail.com
		String fromUserEmailPassword = "Pirunov94";

		Transport transport = mailSession.getTransport("smtp");
		System.out.println("before connection");
		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		System.out.println("after connection");
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
	}

}