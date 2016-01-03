package com.geminicode.pactedeschiens.service.impl;

import com.geminicode.pactedeschiens.model.Article;
import com.geminicode.pactedeschiens.model.ContactMessage;
import com.geminicode.pactedeschiens.service.ArticleService;
import com.geminicode.pactedeschiens.service.OfyService;

import java.util.List;
import java.util.logging.Logger;

public class ArticleServiceImpl implements ArticleService {

    private static final Logger LOGGER = Logger.getLogger(ArticleServiceImpl.class.getName());

    @Override
    public List<Article> all() {
        return OfyService.ofy().load().type(Article.class).list();
    }

    @Override
    public Article get(long id) {
        return OfyService.ofy().load().type(Article.class).id(id).now();
    }

    @Override
    public void save(Article article) {
        OfyService.ofy().save().entity(article).now();
    }

    @Override
    public void delete(long id) {
        OfyService.ofy().delete().type(ContactMessage.class).id(id).now();
    }

    @Override
    public void updateCover(long id, String imagUrl) {
        Article fromDB = get(id);
        fromDB.setCover(imagUrl);
        save(fromDB);
    }

    @Override
    public void removeAll() {
        final List<Article> list = all();
        OfyService.ofy().delete().entities(list).now();
    }
}
