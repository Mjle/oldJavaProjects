package com.fdmgroup.demos.spring;

public class UserFactory {

	private static int userId = 0;
	
	public static User createUser(){
		userId+=1;
		return new User(userId);
	}
	
	public User getUser(){
		return UserFactory.createUser();
	}
	
}
