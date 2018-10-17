package com.fdmgroup.jpauser.exceptions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class InvalidUsernameException extends Exception {

	private static final long serialVersionUID = 1L;
	static Logger myLogger = Logger.getLogger("myLogger");
	
	public InvalidUsernameException(String username) {
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		String message = "Username: " + username + " is invalid.";
		myLogger.error(message);
	}
}
