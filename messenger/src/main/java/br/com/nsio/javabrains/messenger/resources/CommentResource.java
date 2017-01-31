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
import javax.ws.rs.core.MediaType;

import br.com.nsio.javabrains.messenger.model.Comment;
import br.com.nsio.javabrains.messenger.service.CommentServie;

// Optional
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentServie commentServie = new CommentServie(); 
	
	@GET
	public List<Comment> getAllComments(@PathParam("codMessage") long messageId){
		return this.commentServie.getAllComments(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	// Can access param from parent resource
	public Comment testeDois(@PathParam("codMessage") long messageId, @PathParam("commentId") Long commentId){
		return this.commentServie.getComment(messageId, commentId);
	}
	
	@POST
	public Comment addComment(@PathParam("codMessage") long messageId, Comment comment){
		return this.commentServie.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("codMessage") long messageId, @PathParam("commentId") long commentId, Comment comment){
		comment.setId(commentId);
		return this.commentServie.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("codMessage") long messageId, @PathParam("commentId") long commentId){
		this.commentServie.removeComment(messageId, commentId);
	}
	
}
