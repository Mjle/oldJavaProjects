package com.fdmgroup.servletproject.model.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fdmgroup.servletproject.model.IUserDAO;
import com.fdmgroup.servletproject.model.User;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Implements UserDAO interfaces to manipulate User table in the database
 * @author LeHuynhAnh
 *
 */
public class UserDAO implements IUserDAO {

	private static final String validUsernameRegex = "[A-Za-z0-9_]+";
	private static final String PERSISTENCE_UNIT_NAME = "ServletProject";
	static Logger myLogger = Logger.getLogger("myLogger");
	
	private static EntityManagerFactory factory;

	static {
		setFactory(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
		PropertyConfigurator.configure("log4j.properties");
	}

	public EntityManager getEntityManager() {
		return getFactory().createEntityManager();
	}

	/**
	 * Insert a row with the user information to the User table
	 */
	public boolean addUser(User user) {
		myLogger.info("adding user");
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		User validUser = getUser(user.getUsername());
		if (validUser != null) {
			return false;
		}
		try {
			et.begin();
			em.persist(user);
			et.commit();
			return true;
		} finally {
			em.close();
		}
	}

	/**
	 * Retrieves a user with the passed in parameter of username
	 */
	public User getUser(String username) {
		TypedQuery<User> query = getEntityManager().createNamedQuery("User.findByName", User.class);
		User user = null;
		try {
			user = query.setParameter("username", username).getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Removes a user with the passed in parameter of username
	 */
	public boolean removeUser(String username) {
		if (!username.matches(validUsernameRegex)) {
			myLogger.info("Username " + username + " must contain only A-Za-z0-9_. Fail to remove.");
			return false;
		}
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		User user = getUser(username);
		if (user != null) {
			try {
				et.begin();
				em.remove(em.contains(user) ? user : em.merge(user));
				et.commit();
				return true;
			} finally {
				em.close();
			}
		} else {
			return false;
		}
	}

	/**
	 * Update a user if the username exist in the database
	 */
	public boolean updateUser(User user) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		User foundUser = getUser(user.getUsername());
		try {
			if (foundUser != null) {
				et.begin();
				User modifyUser = em.find(User.class, foundUser.getId());
				modifyUser.setFirstName(user.getFirstName());
				modifyUser.setLastName(user.getLastName());
				modifyUser.setPassword(user.getPassword());
				modifyUser.setEmail(user.getEmail());
				et.commit();
				return true;
			}
		} finally {
			em.close();
		}
		myLogger.info("User: " + user.getUsername() + " does not exist. Failed to update.");
		return false;
	}

	/**
	 * Returns a list of users.
	 * SQL query is found in the User class in NamedQueries
	 */
	public List<User> listUsers() {
		TypedQuery<User> query = getEntityManager().createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	public static EntityManagerFactory getFactory() {
		return factory;
	}

	public static void setFactory(EntityManagerFactory factory) {
		UserDAO.factory = factory;
	}

}
