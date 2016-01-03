package com.geminicode.pactedeschiens.rest;

import com.geminicode.pactedeschiens.model.Article;
import com.geminicode.pactedeschiens.service.ArticleService;
import com.geminicode.pactedeschiens.utils.ServiceFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/blog")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RESTBlogService {

    private final ArticleService articleService = ServiceFactory.get().getArticleService();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Article article) {
        articleService.save(article);
    }

    @GET
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Article> all() {
        return articleService.all();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Article get(@PathParam("id") long id) {
        return articleService.get(id);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") long id) {
        articleService.delete(id);
    }
}
