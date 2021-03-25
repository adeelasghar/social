/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mentoringminds.haris.social.resources;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.mentoringminds.haris.social.model.Message;
import com.mentoringminds.haris.social.service.MessageService;

@Path("/messages")

public class MessageResource {
@GET
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)	
	public List <Message> getAllRecords(){
		return MessageService.getAllRecords();
		
	}

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Message save(Message message) {
	return MessageService.save(message);
}

@PUT
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/{messageid}")
public Message update(@PathParam("messageid") int id, Message message) {
	message.setId(id);
	return MessageService.update(message);
	
}

@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Path("/{messageid}")
public void delete(@PathParam("messageid") int id) {
	MessageService.delete(id);
	
}

@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/{messageid}")
public Message getRecordById(@PathParam("messageid") int id) {
	return MessageService.findById(id);}

}
