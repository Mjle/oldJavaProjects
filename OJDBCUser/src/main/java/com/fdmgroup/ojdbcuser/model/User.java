package com.fdmgroup.ojdbcuser.model;

/**
 * User is a layout/ requirement for 
 * what a user should encompass.
 * @author michael.le
 *
 */
public class User {
	
	private int id;
	private String username;
	private String password;
	private String role;
	private String firstName;
	private String lastName;
	private String address;
	
	public User() {}
	public User(String username, String password, String role, String firstName, String lastName, String address) {
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
	 * @param username - sets User's username to passed in username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return - return a user object's password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password - sets User's password to passed in password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return - return User's role
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * @param role - set User's role to role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

