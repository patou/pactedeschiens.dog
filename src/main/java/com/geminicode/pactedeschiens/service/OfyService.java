package com.geminicode.pactedeschiens.service;

import com.geminicode.pactedeschiens.model.Article;
import com.geminicode.pactedeschiens.model.ContactMessage;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class OfyService {

    static {
        factory().register(ContactMessage.class);
        factory().register(Article.class);
    }

    private OfyService() {}

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    private static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
