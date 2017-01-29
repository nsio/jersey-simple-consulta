package br.com.nsio.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import br.com.nsio.javabrains.messenger.database.DataBase;
import br.com.nsio.javabrains.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DataBase.getMessages();
	
	public MessageService(){
		this.messages.put(1L, new Message(1L, "Hello World!", "Nsio"));
		this.messages.put(2L, new Message(2L, "Hello Jersey!", "Nsio"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(this.messages.values());
	}
	
	public List<Message> getMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getMessagesPaginated(int start, int pageSize){
		ArrayList<Message> messagesList = new ArrayList<Message>(messages.values());
		if(start + pageSize > messagesList.size()){
			return new ArrayList<Message>();
		}
		return messagesList.subList(start, start + pageSize);
	}
	
	public Message getMessage(long id){
		return this.messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(this.messages.size() + 1);
		this.messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		this.messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return this.messages.remove(id);
	}
	
}
