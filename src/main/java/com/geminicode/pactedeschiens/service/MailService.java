package com.geminicode.pactedeschiens.service;

public interface MailService {
    void send(String firstname, String lastname, String email, String message);
}
