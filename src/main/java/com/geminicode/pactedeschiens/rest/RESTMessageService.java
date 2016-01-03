package com.geminicode.pactedeschiens.rest;

import com.geminicode.pactedeschiens.model.ContactMessage;
import com.geminicode.pactedeschiens.service.MailService;
import com.geminicode.pactedeschiens.utils.ServiceFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/message")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RESTMessageService {

    private final MailService mailService = ServiceFactory.get().getMailService();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void send(ContactMessage contactMessage) {
        mailService.send(contactMessage);
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ContactMessage get(@PathParam("id") long id) {
        return mailService.get(id);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") long id) {
        mailService.delete(id);
    }
}
