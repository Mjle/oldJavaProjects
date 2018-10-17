package com.fdmgroup.servletproject.model;

import java.util.List;

/**
 * Interface for UserDAO
 * @author michael.le
 *
 */
public interface IUserDAO {

	boolean addUser(User user);
	User getUser(String username);
	boolean removeUser(String username);
	boolean updateUser(User user);
	List<User> listUsers();
}
