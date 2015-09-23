package com.geminicode.pactedeschiens.utils;


import com.geminicode.pactedeschiens.service.MailService;
import com.geminicode.pactedeschiens.service.impl.MailServiceImpl;

public class ServiceFactory {
    private static ServiceFactory instance = null;

    private MailService mailService;

    public static ServiceFactory get() {
        if (instance == null) {
            synchronized (ServiceFactory.class) {
                if (instance == null) {
                    instance = new ServiceFactory();
                }
            }
        }
        return instance;
    }

    public MailService getMailService() {
        if(mailService == null) {
            mailService = new MailServiceImpl();
        }
        return mailService;
    }

}
