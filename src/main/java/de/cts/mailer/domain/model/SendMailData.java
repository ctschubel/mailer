package de.cts.mailer.domain.model;

import java.util.Properties;

/**
 * Modelobject containing necessary information to send an email.
 * 
 * @author chris
 *
 */
public class SendMailData {

	// smtp information
	private String smtpHost;
	private String smtpUser;
	private String smtpPassword;
	private int smtpPort;
	private boolean smtpAuth = false;

	// message data
	private String from;
	private String to;
	private String body;
	private String subject;

	/**
	 * Converts smtp information to properties object.
	 * 
	 * @return
	 */
	public Properties getMailProperties() {
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", this.smtpAuth);
		prop.put("mail.smtp.starttls.enable", this.smtpAuth);
		prop.put("mail.smtp.host", this.smtpHost);
		prop.put("mail.smtp.port", this.smtpPort);
		prop.put("mail.smtp.ssl.trust", this.smtpHost);
		return prop;
	}

	public SendMailData withFrom(final String from) {
		setFrom(from);
		return this;
	}

	public SendMailData withTo(final String to) {
		setTo(to);
		return this;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(final String from) {
		this.from = from;
	}

	public String getTo() {
		return this.to;
	}

	public void setTo(final String to) {
		this.to = to;
	}

	public boolean isSmtpAuth() {
		return this.smtpAuth;
	}

	public SendMailData withSmtpAuth(final boolean smtpAuth) {
		setSmtpAuth(smtpAuth);
		return this;
	}

	public void setSmtpAuth(final boolean smtpAuth) {
		this.smtpAuth = smtpAuth;

	}

	public SendMailData withSmtpHost(final String smtpHost) {
		setSmtpHost(smtpHost);
		return this;
	}

	public SendMailData withSmtpUser(final String smtpUser) {
		setSmtpUser(smtpUser);
		return this;
	}

	public SendMailData withSmtpPassword(final String smtpPassword) {
		setSmtpPassword(smtpPassword);
		return this;
	}

	public SendMailData withSmtpPort(final int smtpPort) {
		setSmtpPort(smtpPort);
		return this;
	}

	public SendMailData withBody(final String body) {
		setBody(body);
		return this;
	}

	public SendMailData withSubject(final String subject) {
		setSubject(subject);
		return this;
	}

	public String getSmtpHost() {
		return this.smtpHost;
	}

	public void setSmtpHost(final String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getSmtpUser() {
		return this.smtpUser;
	}

	public void setSmtpUser(final String smtpUser) {
		this.smtpUser = smtpUser;
	}

	public String getSmtpPassword() {
		return this.smtpPassword;
	}

	public void setSmtpPassword(final String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}

	public int getSmtpPort() {
		return this.smtpPort;
	}

	public void setSmtpPort(final int smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(final String body) {
		this.body = body;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

}
