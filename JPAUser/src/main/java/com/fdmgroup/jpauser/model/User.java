package com.fdmgroup.jpauser.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fdmgroup.jpauser.exceptions.InvalidUsernameException;

/**
 * Persistent Entity User Class for Users database table
 * @author LeHuynhAnh
 */

@Entity
@Table(name = "USERS")

@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u from User u"),
@NamedQuery(name = "User.findByName", 
query = "SELECT u FROM User u WHERE u.username = :username") })

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="User_ID_seq", sequenceName="USER_ID_SEQ")
	@GeneratedValue(generator="User_ID_seq")
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ROLE")
	private String role;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "ADDRESS")
	private String address;

	/**
	 * Creates a User object with no fields.
	 */
	public User() {
	}

	/**
	 * Creates a User object with specified fields.
	 * @param username should be desired username, and not in database.
	 * @param password should be desired password.
	 * @param role should be the user's role.
	 * @param firstName should be the user's first name.
	 * @param lastName should be the user's last name.
	 * @param address should be the address of the user.
	 * @throws InvalidUsernameException if the username is in the database.
	 * 
	 */
	public User(String username, String password, String role, String firstName, String lastName, String address) throws InvalidUsernameException {
		this.setUsername(username);
		this.setPassword(password);
		this.setRole(role);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddress(address);
	}

	/**
	 * @return - returns the username of User
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username sets User's username to passed in username.
	 * @throws InvalidUsernameException if username is invalid (only A-Za-z0-9_).
	 */
	public void setUsername(String username) throws InvalidUsernameException {
		if (username.matches("[A-Za-z0-9_]+")) {
			this.username = username;
		} else {
			throw new InvalidUsernameException(username);
		}
		
	}

	/**
	 * @return - return a user object's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password sets User's password to passed in password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return - return User's role.
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role - set User's role to role.
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return first name of a user's object
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName is used to set the user's firstName 
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return last name of a user's object
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName is used to set the user's lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return a String that is the user object's address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address is used to set the user object's address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return will return the user's userID
	 */
	public int getUserId() {
		return userId;
	}

}
