package com.fdmgroup.ojdbcuser;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.ojdbcuser.controllers.UsernameAlreadyExistsException;
import com.fdmgroup.ojdbcuser.model.User;
import com.fdmgroup.ojdbcuser.model.impl.UsersDAO;

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
		testUser = new User(username, password, role, firstName, lastName, address);
		classUnderTest.removeUser(testUser.getUsername());
	}
	
	@Test
	public void testAddingNullUser() throws UsernameAlreadyExistsException {
		classUnderTest.addUser(nullUser);
	}
	
	@Test
	public void testListUsers_ReturnsNotNullListObject() {
		List<User> users = classUnderTest.listUsers();
		assertNotNull(users);
	}
	
	@Test
	public void testListUsers_ReturnsListWithUserNotNull() throws UsernameAlreadyExistsException{
		classUnderTest.addUser(testUser);
		List<User> users = classUnderTest.listUsers();
		User returnedUser = users.get(0);
		assertNotNull(returnedUser);	
	}
	
	@Test
	public void testAddUser_NullUserBeforeAdding_FullUserAfterAddingValidUser() throws UsernameAlreadyExistsException{
		User expectedReturnedNullUser = classUnderTest.getUser(username);
		classUnderTest.addUser(testUser);
		User afterAddUser = classUnderTest.getUser(username);
		assertNull(expectedReturnedNullUser);
		assertNotNull(afterAddUser);
	}
	
	@Test
	public void testGetUser_AddAValidUser_ReturnsAValidUser() throws UsernameAlreadyExistsException{
		classUnderTest.addUser(testUser);
		User user = classUnderTest.getUser(username);
		String returnedUserUsername = user.getUsername();
		assertEquals(username, returnedUserUsername);
	}
	
	@Test(expected=UsernameAlreadyExistsException.class)
	public void testAddUsersTwice_ExpectUsernameAlreadyExistsException() throws UsernameAlreadyExistsException {
		classUnderTest.removeUser(testUser.getUsername());
		classUnderTest.addUser(testUser);
		System.out.println("second user");
		classUnderTest.addUser(testUser);
	}
	
	@Test
	public void testUpdateUser_ChangeFieldsInUser_ReturnNewFields_DifferentThenOriginalTestUser()throws UsernameAlreadyExistsException{
		User modifiedTestUser = new User(testUser.getUsername(), modifiedPass, modifiedRole, modifiedFirstName, modifiedLastName, modifiedAddr);
		classUnderTest.addUser(testUser);
		classUnderTest.updateUser(modifiedTestUser);
		
		User returnedUser = classUnderTest.getUser(testUser.getUsername());
		
		assertEquals(modifiedPass,returnedUser.getPassword());
		assertEquals(modifiedRole,returnedUser.getRole());
		assertEquals(modifiedFirstName, returnedUser.getFirstName());
		assertEquals(modifiedLastName, returnedUser.getLastName());
		assertEquals(modifiedAddr, returnedUser.getAddress());
	}
}













