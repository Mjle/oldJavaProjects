package com.fdmgroup.demos.spring;

public class User {

	private int id;
	private String username;
	private String password;
	
	public User(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	
}
