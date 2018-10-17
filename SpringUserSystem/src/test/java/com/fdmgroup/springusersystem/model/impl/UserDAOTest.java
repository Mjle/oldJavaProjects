package com.fdmgroup.springusersystem.model.impl;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UserDAOTest {

	private UserDAO classUnderTest;
	private User testUser;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private User modifiedTestUser;
	private String modifiedPass;
	private String modifiedEmail;
	private String modifiedFirstName;
	private String modifiedLastName;

	@Before
	public void setUp() throws Exception {
		classUnderTest = new UserDAO();
		firstName = "bob";
		lastName = "jr";
		username = "bobuser";
		password = "bobpass";
		email = "bob@bob";
		modifiedFirstName = "mike";
		modifiedLastName = "real";
		modifiedPass = "modpass";
		modifiedEmail = "email@updated";
		
		testUser = new User(firstName, lastName, username, password, email);
		modifiedTestUser = new User(modifiedFirstName, modifiedLastName, username, modifiedPass, modifiedEmail);
		
		classUnderTest.removeUser(testUser.getUsername());
	}
	
	@Test
	public void testListUsers_ReturnsListGreaterThanZero(){
		classUnderTest.addUser(testUser);
		List<User> users = classUnderTest.listUsers();
		int listSize = users.size();
		assertTrue(listSize > 0);
	}

	@Test
	public void testAddUser_NullUserBeforeAdding_FullUserAfterAddingValidUser()
			{
		User expectedReturnedNullUser = classUnderTest.getUser(username);
		classUnderTest.addUser(testUser);
		User afterAddUser = classUnderTest.getUser(username);
		assertNull(expectedReturnedNullUser);
		assertNotNull(afterAddUser);
	}
	
	@Test
	public void testAddUserTwice_ExpectSecondAddToReturnsFalse() {
		boolean firstAdd = classUnderTest.addUser(testUser);
		boolean secondAdd = classUnderTest.addUser(testUser);
		assertTrue(firstAdd);
		assertFalse(secondAdd);
	}

	@Test
	public void testGetUser_AddAValidUser_ReturnsAValidUserSameUsername()
			{
		classUnderTest.addUser(testUser);
		User returnedUser = classUnderTest.getUser(username);
		String returnedUserUsername = returnedUser.getUsername();
		assertEquals(username, returnedUserUsername);
	}

	@Test
	public void testRemoveUser_AddValidUser_RemoveUser_NullUser() {
		classUnderTest.addUser(testUser);
		classUnderTest.removeUser(testUser.getUsername());
		assertNull(classUnderTest.getUser(testUser.getUsername()));
	}
	
	@Test
	public void testUpdateUser_ChangeFieldsInUser_ReturnNewFields_DifferentThenOriginalTestUser()
			{

		classUnderTest.addUser(testUser);
		classUnderTest.updateUser(modifiedTestUser);

		User returnedUser = classUnderTest.getUser(testUser.getUsername());

		assertEquals(testUser.getUsername(), returnedUser.getUsername());
		assertEquals(modifiedPass, returnedUser.getPassword());
		assertEquals(modifiedFirstName, returnedUser.getFirstName());
		assertEquals(modifiedLastName, returnedUser.getLastName());
		assertEquals(modifiedEmail, returnedUser.getEmail());
	}
}
