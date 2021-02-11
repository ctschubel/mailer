package de.cts.mailer.domain;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import de.cts.mailer.domain.model.SendMailData;

/**
 * Service for sending Emails.
 * 
 * @author chris
 *
 */
//TODO use abstract super class for SendMailData information to extend from.
public interface SendMailService {

	/**
	 * Uses information from {@link SendMailData} to send an email.
	 * 
	 * @param data
	 * @throws AddressException
	 * @throws MessagingException
	 */
	void sendMail(SendMailData data) throws AddressException, MessagingException;

}
