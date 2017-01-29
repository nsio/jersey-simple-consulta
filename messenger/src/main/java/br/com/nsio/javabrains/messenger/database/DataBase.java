package br.com.nsio.javabrains.messenger.database;

import java.util.HashMap;
import java.util.Map;

import br.com.nsio.javabrains.messenger.model.Message;
import br.com.nsio.javabrains.messenger.model.Profile;

public class DataBase {
	
	// ISSO NÃO É THREAD-SAFE, APENAS PARA TESTAR;
	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
}
