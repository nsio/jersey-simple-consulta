package br.com.nsio.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.nsio.javabrains.messenger.model.Message;
import br.com.nsio.javabrains.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	private MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("pageSize") int pageSize){
		if(year > 0){
			return this.messageService.getMessagesForYear(year);
		}
		if(start >= 0 && pageSize >= 0){
			return this.messageService.getMessagesPaginated(start, pageSize);
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{codMessage}")
	public Message getMessage(@PathParam("codMessage") Long codMessage){
		return this.messageService.getMessage(codMessage);
	}
	
	// PARA CRIAR UM NOVO OBJETO;
	@POST
	public Message addMessage(Message message){
		return this.messageService.addMessage(message);
	}
	
	// PARA ATUALIZAR UM OBJETO
	@PUT
	@Path("/{codMessage}")
	public Message updateMessage(@PathParam("codMessage") Long codMessage, Message message){
		message.setId(codMessage);
		return this.messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{codMessage}")
	public void removeMessage(@PathParam("codMessage") Long codMessage){
		this.messageService.removeMessage(codMessage);
	}
	
}
