package com.fdmgroup.jpauser.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@Table(name="ADDRESS")
@NamedQueries({
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a"),
@NamedQuery(name="Address.findById", query="SELECT a FROM Address a WHERE a.address_id = :addressid")
})
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private long addressId;

	@Column(name="ADDRESS_NUMBER")
	private String addressNumber;

	private String street;
	
	private String city;

	private String state;

	private String zip;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="address")
	private List<User> users;

	public Address() {
	}

	public long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddressNumber() {
		return this.addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

//	public User addUser(User user) {
//		getUsers().add(user);
//		user.setAddress(this);
//
//		return user;
//	}
//
//	public User removeUser(User user) {
//		getUsers().remove(user);
//		user.setAddress(null);
//
//		return user;
//	}

}