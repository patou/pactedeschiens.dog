package com.geminicode.pactedeschiens.service;

import com.geminicode.pactedeschiens.model.ContactMessage;

public interface MailService {
    void send(ContactMessage contactMessage);
    ContactMessage get(long id);
    void save(ContactMessage contactMessage);
    void delete(long id);
}
