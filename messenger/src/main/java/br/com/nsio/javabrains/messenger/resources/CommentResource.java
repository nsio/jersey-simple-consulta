package br.com.nsio.javabrains.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

// Optional
@Path("/")
public class CommentResource {
	
	@GET
	public String teste(){
		return "new SubResource";
	}
	
	@GET
	@Path("/{commentId}")
	// Can access param from parent resource
	public String testeDois(@PathParam("codMessage") Long codMessage, @PathParam("commentId") Long commentId){
		return "Comment ID is : " + commentId + " Codigo Message : " + codMessage;
	}
	
}
