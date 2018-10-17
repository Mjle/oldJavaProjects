package com.fdmgroup.springusersystem.model;

import java.util.List;

import com.fdmgroup.springusersystem.model.impl.User;

/**
 * Interface for UserDAO
 *
 */
public interface IUserDAO {

	boolean addUser(User user);
	User getUser(String username);
	boolean removeUser(String username);
	boolean updateUser(User user);
	List<User> listUsers();
}
