package de.cts.mailer.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import javax.mail.internet.MimeMultipart;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.icegreen.greenmail.junit5.GreenMailExtension;
import com.icegreen.greenmail.user.GreenMailUser;
import com.icegreen.greenmail.util.ServerSetupTest;

import de.cts.mailer.domain.SendMailService;
import de.cts.mailer.domain.model.SendMailData;

/**
 * @author chris
 *
 */
@SpringBootTest(classes = { SendSMTPMailService.class })
@ExtendWith(SpringExtension.class)
public class SendSMTPMailServiceTest {

	@RegisterExtension
	static GreenMailExtension greenMail = new GreenMailExtension(ServerSetupTest.SMTP);

	@Autowired
	private SendMailService mailService;

	@Test
	public void sendMail_ok() throws Exception {
		GreenMailUser greenMailSendUser = greenMail.setUser("send@test.com", "test123");
		GreenMailUser greenMailReceiveUser = greenMail.setUser("receive@test.com", "test456");

		SendMailData data = new SendMailData()//
				.withBody("This is a TestMessage")//
				.withSubject("TestSubject")//
				.withSmtpAuth(false)//
				.withSmtpHost("localhost")//
				.withSmtpPort(greenMail.getSmtp().getPort())//
				.withSmtpUser(greenMailSendUser.getLogin())//
				.withSmtpPassword(greenMailSendUser.getPassword())//
				.withFrom(greenMailSendUser.getEmail())//
				.withTo(greenMailReceiveUser.getEmail());
		this.mailService.sendMail(data);

		assertThat(greenMail.getReceivedMessages()[0].getFrom()[0].toString()).isEqualTo("send@test.com");
		assertThat(greenMail.getReceivedMessages()[0].getSubject()).isEqualTo("TestSubject");
		assertThat(((MimeMultipart) greenMail.getReceivedMessages()[0].getContent()).getBodyPart(0).getContent())
				.isEqualTo("This is a TestMessage");
	}

}
