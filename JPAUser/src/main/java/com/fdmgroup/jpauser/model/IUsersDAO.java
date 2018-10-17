package com.fdmgroup.jpauser.model;

import java.util.List;

import com.fdmgroup.jpauser.exceptions.InvalidUsernameException;
import com.fdmgroup.jpauser.exceptions.NoUserFoundException;
import com.fdmgroup.jpauser.exceptions.NullUserException;
import com.fdmgroup.jpauser.exceptions.UsernameAlreadyExistsException;

public interface IUsersDAO {

	void addUser(User user) throws UsernameAlreadyExistsException, InvalidUsernameException, NullUserException;
	User getUser(String username) throws InvalidUsernameException;
	void removeUser(String username) throws InvalidUsernameException, NoUserFoundException;
	void updateUser(User user) throws NullUserException, InvalidUsernameException;
	List<User> listUsers();
	
}
