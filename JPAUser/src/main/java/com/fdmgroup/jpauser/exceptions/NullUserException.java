package com.fdmgroup.jpauser.exceptions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class NullUserException extends Exception {

	private static final long serialVersionUID = 1L;
	static Logger myLogger = Logger.getLogger("myLogger");
	
	public NullUserException() {
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		String message = "User is null. Please instantiate the object";
		myLogger.error(message);
	}
}
