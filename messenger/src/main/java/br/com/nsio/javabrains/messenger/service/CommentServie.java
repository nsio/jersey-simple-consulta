package br.com.nsio.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.nsio.javabrains.messenger.database.DataBase;
import br.com.nsio.javabrains.messenger.model.Comment;
import br.com.nsio.javabrains.messenger.model.Message;

public class CommentServie {
	
	private Map<Long, Message> messages = DataBase.getMessages();
	
	public List<Comment> getAllComments(long messageId){
		return new ArrayList<Comment>(messages.get(messageId).getComments().values());
	}
	
	public Comment getComment(long messageId, long commentId){
		return messages.get(messageId).getComments().get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comment.getId() <= 0){
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
	
}
