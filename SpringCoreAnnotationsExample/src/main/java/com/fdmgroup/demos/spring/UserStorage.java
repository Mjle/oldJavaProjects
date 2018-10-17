package com.fdmgroup.demos.spring;

import java.util.List;

import org.apache.log4j.Logger;

public class UserStorage {

	private Logger log = Logger.getLogger(UserStorage.class);
	
	private List<User> users;
	public void setUsersList(List<User> users){
		this.users = users;
	}
	
	public void init(){
		log.info(users.getClass());
		print();
	}
	
	public void print(){
		for(User user : users){
			log.info(user.getId());
		}
	}
}
