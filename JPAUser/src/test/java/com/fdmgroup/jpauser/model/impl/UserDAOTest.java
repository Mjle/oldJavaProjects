package com.fdmgroup.jpauser.model.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.jpauser.exceptions.InvalidUsernameException;
import com.fdmgroup.jpauser.exceptions.NullUserException;
import com.fdmgroup.jpauser.exceptions.UsernameAlreadyExistsException;
import com.fdmgroup.jpauser.model.User;
import com.fdmgroup.jpauser.model.impl.UsersDAO;

public class UserDAOTest {

	private UsersDAO classUnderTest;
	private User testUser;
	private String username;
	private String password;
	private String role;
	private String firstName;
	private String lastName;
	private String address;
	private String modifiedPass;
	private String modifiedRole;
	private String modifiedFirstName;
	private String modifiedLastName;
	private String modifiedAddr;
	String invalidUsername;
	private User nullUser;

	@Before
	public void setUp() throws Exception {
		classUnderTest = new UsersDAO();
		nullUser = null;
		username = "bob2";
		password = "pass";
		role = "admin";
		firstName = "bob";
		lastName = "lastlol";
		address = "loladdr";
		modifiedPass = "changed";
		modifiedRole = "boss";
		modifiedFirstName = "Bobby";
		modifiedLastName = "TheReal";
		modifiedAddr = "14 Wall St.";
		invalidUsername = "#43dwe2!sd";
		testUser = new User(username, password, role, firstName, lastName, address);
		classUnderTest.removeUser(testUser.getUsername());
	}

	@Test(expected = NullUserException.class)
	public void testAddingNullUser()
			throws UsernameAlreadyExistsException, InvalidUsernameException, NullUserException {
		classUnderTest.addUser(nullUser);
	}

	@Test(expected = UsernameAlreadyExistsException.class)
	public void testAddUsersTwice_ExpectUsernameAlreadyExistsException()
			throws UsernameAlreadyExistsException, InvalidUsernameException, NullUserException {
		classUnderTest.addUser(testUser);
		classUnderTest.addUser(testUser);
	}

	@Test(expected = InvalidUsernameException.class)
	public void testInvalidUsernameExceptionAddUser() throws InvalidUsernameException, UsernameAlreadyExistsException, NullUserException {
		User invalidUser = new User();
		invalidUser.setUsername(invalidUsername);
		classUnderTest.addUser(invalidUser);
	}
	
	@Test
	public void testRemoveUser() throws InvalidUsernameException, UsernameAlreadyExistsException, NullUserException {
		classUnderTest.addUser(testUser);
		User returnedUser = classUnderTest.getUser(testUser.getUsername());
		assertNotNull(returnedUser);
		classUnderTest.removeUser(testUser.getUsername());
		User afterRemoveUser = classUnderTest.getUser(testUser.getUsername());
		assertNull(afterRemoveUser);
	}
	
	@Test(expected = InvalidUsernameException.class)
	public void testInvalidUsernameExceptionGetUser() throws InvalidUsernameException {
		classUnderTest.getUser(invalidUsername);
	}
	
	@Test(expected = InvalidUsernameException.class)
	public void testInvalidUsernameExceptionRemoveUser() throws InvalidUsernameException {
		classUnderTest.removeUser(invalidUsername);
	}
	
	@Test
	public void testListUsers_ReturnsNotNullListObject() {
		List<User> users = classUnderTest.listUsers();
		assertNotNull(users);
	}

	@Test
	public void testListUsers_ReturnsListWithUserNotNull()
			throws UsernameAlreadyExistsException, InvalidUsernameException, NullUserException {
		classUnderTest.addUser(testUser);
		List<User> users = classUnderTest.listUsers();
		User returnedUser = users.get(0);
		assertNotNull(returnedUser);
	}

	@Test
	public void testAddUser_NullUserBeforeAdding_FullUserAfterAddingValidUser()
			throws UsernameAlreadyExistsException, InvalidUsernameException, NullUserException {
		User expectedReturnedNullUser = classUnderTest.getUser(username);
		classUnderTest.addUser(testUser);
		User afterAddUser = classUnderTest.getUser(username);
		assertNull(expectedReturnedNullUser);
		assertNotNull(afterAddUser);
	}

	@Test
	public void testGetUser_AddAValidUser_ReturnsAValidUser()
			throws UsernameAlreadyExistsException, InvalidUsernameException, NullUserException {
		classUnderTest.addUser(testUser);
		User returnedUser = classUnderTest.getUser(username);
		String returnedUserUsername = returnedUser.getUsername();
		assertEquals(username, returnedUserUsername);
	}

	@Test
	public void testUpdateUser_ChangeFieldsInUser_ReturnNewFields_DifferentThenOriginalTestUser()
			throws UsernameAlreadyExistsException, InvalidUsernameException, NullUserException {
		User modifiedTestUser = new User(testUser.getUsername(), modifiedPass, modifiedRole, modifiedFirstName,
				modifiedLastName, modifiedAddr);
		classUnderTest.addUser(testUser);
		classUnderTest.updateUser(modifiedTestUser);

		User returnedUser = classUnderTest.getUser(testUser.getUsername());

		assertEquals(testUser.getUsername(), returnedUser.getUsername());
		assertEquals(modifiedPass, returnedUser.getPassword());
		assertEquals(modifiedRole, returnedUser.getRole());
		assertEquals(modifiedFirstName, returnedUser.getFirstName());
		assertEquals(modifiedLastName, returnedUser.getLastName());
		assertEquals(modifiedAddr, returnedUser.getAddress());
	}
}
