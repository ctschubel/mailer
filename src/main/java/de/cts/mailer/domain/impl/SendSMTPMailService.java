package de.cts.mailer.domain.impl;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import de.cts.mailer.domain.SendMailService;
import de.cts.mailer.domain.model.SendMailData;

/**
 * Sends an email with SMTP
 * @author chris
 *
 */
public class SendSMTPMailService implements SendMailService {

	@Override
	public void sendMail(final SendMailData data) throws AddressException, MessagingException {

		Session session = Session.getInstance(data.getMailProperties(), new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(data.getSmtpUser(), data.getSmtpPassword());
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(data.getFrom()));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(data.getTo()));
		message.setSubject(data.getSubject());

		String msg = data.getBody();

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(msg, determineContentType(msg));

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);

		message.setContent(multipart);

		Transport.send(message);

	}

	private String determineContentType(final String msg) {
		// TODO implement method
		return "text/html";
	}

}
