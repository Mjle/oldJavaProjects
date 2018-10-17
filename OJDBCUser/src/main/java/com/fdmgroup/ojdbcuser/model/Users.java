package com.fdmgroup.ojdbcuser.model;

import java.util.List;

import com.fdmgroup.ojdbcuser.controllers.UsernameAlreadyExistsException;

public interface Users {

	void addUser(User user) throws UsernameAlreadyExistsException;
	User getUser(String username);
	void removeUser(String username);
	void updateUser(User user);
	List<User> listUsers();
	
}
