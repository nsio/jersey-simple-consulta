package br.com.nsio.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.nsio.javabrains.messenger.database.DataBase;
import br.com.nsio.javabrains.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DataBase.getProfiles();
	
	public ProfileService(){
		this.profiles.put("Nsio", new Profile(1L, "Nsio", "Nsio", "Chrysos"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(this.profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return this.profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(this.profiles.size() + 1);
		this.profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		this.profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return this.profiles.remove(profileName);
	}
	
}
