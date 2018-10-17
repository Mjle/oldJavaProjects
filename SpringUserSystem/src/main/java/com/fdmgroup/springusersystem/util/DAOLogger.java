package com.fdmgroup.springusersystem.util;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.fdmgroup.springusersystem.model.impl.User;

/**
 * Creates a logger for the UserDAO
 * @author michael.le
 *
 */
@Aspect
public class DAOLogger {

	static Logger myLogger = Logger.getLogger("myLogger");

	static {
		PropertyConfigurator.configure("log4j.properties");
	}

	/**
	 * Logs if any user method is used
	 * @param jp
	 */
	@Before("execution(* com.fdmgroup.springusersystem.model.impl.UserDAO.*User(..))")
	public void logMethodUser(JoinPoint jp) {
		String anyUserMsg = jp.getSignature() + "\nUserDAO: Any user method..";
		myLogger.info(anyUserMsg);
	}

	/**
	 * Logs if any user method is exitted
	 * @param jp
	 */
	@After("execution(* com.fdmgroup.springusersystem.model.impl.UserDAO.*(..))")
	public void logExitDAOMethod(JoinPoint jp) {
		String exitDAOMsg = jp.getSignature() + "\nUserDAO: exiting method..";
		myLogger.info(exitDAOMsg);
	}

	/**
	 * Logs when user object is returned from UserDAO
	 * @param jp
	 */
	@AfterReturning(pointcut = "execution(com.fdmgroup.springusersystem.model.impl.User com.fdmgroup.springusersystem.model.impl.UserDAO.*(..))", returning = "user")
	public void logReturnUser(User user) {
		if (user != null) {
			String returnUserMsg = "UserDAO: Getting user... " + user.getUsername();
			myLogger.info(returnUserMsg);
		} else {
			String returnUserMsg = "UserDAO: no user found... ";
			myLogger.info(returnUserMsg);
		}
	}

	/**
	 * Logs an exception if no user is found with getUser
	 * @param jp
	 */
	@AfterThrowing(pointcut = "execution(* com.fdmgroup.springusersystem.model.impl.UserDAO.getUser(..))", throwing = "e")
	public void logNoResultException(JoinPoint jp, Exception e) {
		String excLogMsg = "An Exception was thrown: " + e.getClass().getSimpleName() + jp.getSignature();
		myLogger.info(excLogMsg);
	}

}
