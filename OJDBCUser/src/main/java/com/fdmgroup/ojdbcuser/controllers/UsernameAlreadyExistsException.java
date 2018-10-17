package com.fdmgroup.ojdbcuser.controllers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class UsernameAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	static Logger myLogger = Logger.getLogger("myLogger");

	public UsernameAlreadyExistsException(String username) {
		
		PropertyConfigurator.configure("mylog4j.properties");
		String message = "Username: " + username + " already exists!";
		myLogger.error(message);
	}
}
