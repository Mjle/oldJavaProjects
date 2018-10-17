package com.fdmgroup.servletproject.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fdmgroup.servletproject.model.impl.UserDAO;

/**
 * Listener for entire web application
 * @author michael.le
 *
 */
public class ServerListener implements ServletContextListener {

    public ServerListener() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     * close Entity Manager Factory if web app decides to shutdown
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	UserDAO.getFactory().close();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     * Creates an application scope UserDAO for servlets to use
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         UserDAO listenerDAO = new UserDAO();
         sce.getServletContext().setAttribute("listenerDAO", listenerDAO);
    }
	
}
