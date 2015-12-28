package com.geminicode.pactedeschiens.service.impl;

import com.geminicode.pactedeschiens.service.MailService;
import com.google.common.base.Strings;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailServiceImpl implements MailService {

    private static final Logger LOGGER = Logger.getLogger(MailServiceImpl.class.getName());
    public static final String MAIL = "pactedeschiens@gmail.com";
    public static final String NAME = "Johan LAMBON";
    public static final String OBJECT = "Contact";
    public static final String MAIL_FROM = "pactedeschiens-2.appspot.com";

    @Override
    public void send(String firstname, String lastname, String email, String message) {

        if (Strings.isNullOrEmpty(firstname) || Strings.isNullOrEmpty(lastname) || Strings.isNullOrEmpty(email) || Strings.isNullOrEmpty(message)) {
            LOGGER.log(Level.SEVERE, "One param is null or empty.");
            return;
        }

        LOGGER.log(Level.INFO, firstname + " " + lastname + " " + email + " " + message);
        final Properties props = new Properties();
        final Session session = Session.getDefaultInstance(props, null);

        try {
            final Message msg = new MimeMessage(session);
            msg.setHeader("charset", "UTF-8");
            msg.setFrom(new InternetAddress(MAIL_FROM, firstname + " " + lastname));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(MAIL, NAME));
            msg.setSubject(OBJECT);
            msg.setText(message + "\n" + "Message come from : " + email);
            Transport.send(msg);

        } catch (MessagingException | UnsupportedEncodingException e) {
            LOGGER.log(Level.SEVERE, "Message can't be sent, from : " + email + ", message : " + message, e);
        }
    }
}
