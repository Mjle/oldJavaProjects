package com.fdmgroup.jpauser.model.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fdmgroup.jpauser.model.User;
import com.fdmgroup.jpauser.exceptions.InvalidUsernameException;
import com.fdmgroup.jpauser.exceptions.NullUserException;
import com.fdmgroup.jpauser.exceptions.UsernameAlreadyExistsException;
import com.fdmgroup.jpauser.model.IUsersDAO;

/**
 * UsersDAO is an object that provides interface to the 'USERS' database.
 * 
 * @author michael.le
 *
 */
public class UsersDAO implements IUsersDAO {

	private static final String validUsernameRegex = "[A-Za-z0-9_]+";
	private static final String PERSISTENCE_UNIT_NAME = "JPAUser";
	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	/**
	 * @return an entity manager.
	 */
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	/**
	 * Add users based on a user object.
	 * @param user should be an object with a valid username, and desired fields.
	 */
	public void addUser(User user) throws UsernameAlreadyExistsException, InvalidUsernameException, NullUserException {
		if (user == null) {
			throw new NullUserException();
		}
		if (!user.getUsername().matches(validUsernameRegex)) {
			throw new InvalidUsernameException(user.getUsername());
		}
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		User validEmployee = getUser(user.getUsername());
		if (validEmployee != null) {
			throw new UsernameAlreadyExistsException(user.getUsername());
		}
		try {
			et.begin();
			em.persist(user);
			et.commit();
		} finally {
			em.close();
		}
	}

	/**
	 * @param username should be a valid username. 
	 * It will return a user object or a null depending if the database finds the user.
	 */
	public User getUser(String username) throws InvalidUsernameException {
		if (!username.matches(validUsernameRegex)) {
			throw new InvalidUsernameException(username);
		}
		TypedQuery<User> query = getEntityManager().createNamedQuery("User.findByName", User.class);
		User user = null;
		try {
			user = query.setParameter("username", username).getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 * The entity manager may not contain a user object from previous
	 * connection. That is why you need ternary operator to merge it otherwise.
	 */
	public void removeUser(String username) throws InvalidUsernameException {
		if (!username.matches(validUsernameRegex)) {
			throw new InvalidUsernameException(username);
		}
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		User user = getUser(username);
		try {
			if (!(user == null)) {
				et.begin();
				em.remove(em.contains(user) ? user : em.merge(user));
				et.commit();
			}
		} finally {
			em.close();
		}
	}

	/**
	 * @param User with different fields should be passed in. 
	 * User should have a username that is already in database.
	 */
	public void updateUser(User user) throws NullUserException, InvalidUsernameException {
		if (user == null || user.getUsername() == null) {
			throw new NullUserException();
		}
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		User foundUser = getUser(user.getUsername());
		try {
			if (foundUser != null) {
				et.begin();
				User modifyPersistedUser = em.find(User.class, foundUser.getUserId());
				modifyPersistedUser.setPassword(user.getPassword());
				modifyPersistedUser.setRole(user.getRole());
				modifyPersistedUser.setFirstName(user.getFirstName());
				modifyPersistedUser.setLastName(user.getLastName());
				modifyPersistedUser.setAddress(user.getAddress());
				et.commit();
			}
		} finally {
			em.close();
		}
	}

	/**
	 * Returns a list of users from the database.
	 */
	public List<User> listUsers() {
		TypedQuery<User> query = getEntityManager().createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

}
