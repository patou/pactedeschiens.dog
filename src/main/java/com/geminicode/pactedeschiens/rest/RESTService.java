package com.geminicode.pactedeschiens.rest;

import com.geminicode.pactedeschiens.model.Message;
import com.geminicode.pactedeschiens.service.MailService;
import com.geminicode.pactedeschiens.utils.ServiceFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This class class expose the API
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RESTService {

    private final MailService mailService = ServiceFactory.get().getMailService();

    @POST
    @Path("/message")
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendMessage(Message message) {
        mailService.send(message.getName(), message.getEmail(), message.getMessage());
    }
}
