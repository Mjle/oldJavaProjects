package com.fdmgroup.servletproject.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Persistent Entity User Class for Users database table
 */
@Entity
@Table(name = "USERS")
@NamedQueries({ 
@NamedQuery(name = "User.findAll", query = "SELECT u from User u"),
@NamedQuery(name = "User.findByName", 
query = "SELECT u FROM User u WHERE u.username = :username") })

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String username;
	private String password;
	private String email;
	
	public User(){}
	public User(String firstName, String lastName, String username, String password, String email) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUsername(username.toLowerCase());
		this.setPassword(password);
		this.setEmail(email);
	}
	
	public int getId() {
		return this.id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}