package com.geminicode.pactedeschiens.service.impl;

import com.geminicode.pactedeschiens.model.ContactMessage;
import com.geminicode.pactedeschiens.service.MailService;
import com.geminicode.pactedeschiens.service.OfyService;
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
    public static final String MAIL_FROM = "pactedeschiens@gmail.com";

    @Override
    public void send(ContactMessage contactMessage) {

        if (Strings.isNullOrEmpty(contactMessage.getFirstName()) || Strings.isNullOrEmpty(contactMessage.getLastName()) || Strings.isNullOrEmpty(contactMessage.getEmail()) || Strings.isNullOrEmpty(contactMessage.getMessage())) {
            LOGGER.log(Level.SEVERE, "One param is null or empty.");
            return;
        }

        LOGGER.log(Level.INFO, contactMessage.getFirstName() + " " + contactMessage.getLastName() + " " + contactMessage.getEmail() + " " + contactMessage.getMessage());
        final Properties props = new Properties();
        final Session session = Session.getDefaultInstance(props, null);

        try {
            final Message msg = new MimeMessage(session);
            msg.setHeader("charset", "UTF-8");
            msg.setFrom(new InternetAddress(MAIL_FROM, contactMessage.getFirstName() + " " + contactMessage.getLastName()));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(MAIL, NAME));
            msg.setSubject(OBJECT);
            msg.setText(contactMessage.getMessage() + "\n" + "ContactMessage come from : " + contactMessage.getEmail());
            Transport.send(msg);

            save(contactMessage);

        } catch (MessagingException | UnsupportedEncodingException e) {
            LOGGER.log(Level.SEVERE, "ContactMessage can't be sent, from : " + contactMessage.getEmail() + ", message : " + contactMessage.getMessage(), e);
        }
    }

    @Override
    public ContactMessage get(long id) {
        return OfyService.ofy().load().type(ContactMessage.class).id(id).now();
    }

    @Override
    public void save(ContactMessage contactMessage) {
        OfyService.ofy().save().entity(contactMessage).now();
    }

    @Override
    public void delete(long id) {
        OfyService.ofy().delete().type(ContactMessage.class).id(id).now();
    }
}
