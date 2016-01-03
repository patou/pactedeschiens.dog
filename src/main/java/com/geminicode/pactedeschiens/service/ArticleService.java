package com.geminicode.pactedeschiens.service;

import com.geminicode.pactedeschiens.model.Article;

import java.util.List;

public interface ArticleService {
    void save(Article article);

    List<Article> all();

    Article get(long id);
    void delete(long id);
    void updateCover(long id, String imgUrl);
    void removeAll();
}
