package com.fdmgroup.ojdbcuser.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.fdmgroup.ojdbcuser.controllers.UsernameAlreadyExistsException;
import com.fdmgroup.ojdbcuser.model.User;
import com.fdmgroup.ojdbcuser.model.Users;
import com.fdmgroup.ojdbcuser.utils.PropertyUtils;

import java.sql.*;

/**
 * UsersDAO is an object that provides interface to
 * the 'USERS' database.
 * @author michael.le
 *
 */
public class UsersDAO implements Users {
	
	static Properties properties;
	static String url, username, password;
	
	/**
	 * Initializes Database Driver and Database properties configuration
	 */
	static {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		properties = PropertyUtils.loadProperties("db.properties");
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");
	}
	
	/**
	 * AddUser allows the interface to addUser based on a user object.
	 * The user object must not have a username that already exist in the database. 
	 */
	public void addUser(User user) throws UsernameAlreadyExistsException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (user == null) {
			return;
		}
		try {
			conn = DriverManager.getConnection(UsersDAO.url, UsersDAO.username, UsersDAO.password);
			if (conn == null) {
				return;
			}
			String query = "SELECT * FROM USERS WHERE USERNAME=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			rs = ps.executeQuery();
			if (rs.next()) {
				throw new UsernameAlreadyExistsException(user.getUsername());
			}
			CallableStatement stmt = conn.prepareCall("{call ADD_USERS(?,?,?,?,?,?)}");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getRole());
			stmt.setString(4, user.getFirstName());
			stmt.setString(5, user.getLastName());
			stmt.setString(6, user.getAddress());
			stmt.execute(); 
		} catch(UsernameAlreadyExistsException e){
			throw e;
		} catch(Exception e){
			System.out.println(e);
		} finally {
			try {
				if(conn!=null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Returns a user based on the passed in String parameter.
	 * Returns a null User if none is found.
	 */
	public User getUser(String username) {
		Connection conn = null;
		User user = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(UsersDAO.url, UsersDAO.username, UsersDAO.password);
			if (conn == null) {
				return user;
			}
			String query = "SELECT * FROM USERS WHERE USERNAME=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2)); 
				user.setPassword(rs.getString(3)); 
				user.setRole(rs.getString(4)); 
				user.setFirstName(rs.getString(5)); 
				user.setLastName(rs.getString(6)); 
				user.setAddress(rs.getString(7));
			}
		} catch(Exception e){
			System.out.println(e);
		} finally {
			try {
				rs.close();
				ps.close();
				if(conn!=null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	/**
	 * RemoveUser deletes a user row in the database based on passed in username. 
	 */
	public void removeUser(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection(UsersDAO.url, UsersDAO.username, UsersDAO.password);
			if (conn == null) {
				return;
			}			String query = "DELETE FROM USERS WHERE USERNAME=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.executeQuery();
		} catch(Exception e){
			System.out.println(e);
		} finally {
			try {
				ps.close();
				if(conn!=null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}

	public void updateUser(User user) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(UsersDAO.url, UsersDAO.username, UsersDAO.password);
			if (conn == null) {
				return;
			}
			CallableStatement stmt = conn.prepareCall("{call UPDATE_USERS(?,?,?,?,?,?)}");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getRole());
			stmt.setString(4, user.getFirstName());
			stmt.setString(5, user.getLastName());
			stmt.setString(6, user.getAddress());
			stmt.execute(); 
		} catch(Exception e){
			System.out.println(e);
		} finally {
			try {
				if(conn!=null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<User> listUsers() {
		List<User> listOfUsers = new ArrayList<User>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(UsersDAO.url, UsersDAO.username, UsersDAO.password);
			if (conn == null) {
				return listOfUsers;
			}
			Statement stmt = conn.createStatement();
			String query = "select * from users";
			ResultSet rs=stmt.executeQuery(query);  
			while(rs.next())  {
//			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+
//			rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)); 
			User rsCurrentUser = new User();
			rsCurrentUser.setId(rs.getInt(1));
			rsCurrentUser.setUsername(rs.getString(2));
			rsCurrentUser.setPassword(rs.getString(3));
			rsCurrentUser.setRole(rs.getString(4));
			rsCurrentUser.setFirstName(rs.getString(5));
			rsCurrentUser.setLastName(rs.getString(6));
			rsCurrentUser.setAddress(rs.getString(7));
			listOfUsers.add(rsCurrentUser);
			}
		} catch(Exception e){
			System.out.println(e);
		} finally {
			try {
				if(conn!=null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfUsers; 
	}

}
