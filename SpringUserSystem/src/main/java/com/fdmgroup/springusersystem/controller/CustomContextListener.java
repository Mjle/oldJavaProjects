package com.fdmgroup.springusersystem.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

import com.fdmgroup.springusersystem.model.impl.UserDAO;

/**
 * Listens for context initialized and destroy.
 * @author Krampus
 *
 */
public class CustomContextListener extends ContextLoaderListener {

	private ApplicationContext ctx;
	
    public CustomContextListener() {
    }

	/**
	 * Destroys the factory and closes the application context
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce)  { 
    	UserDAO.getFactory().close();
    	((ConfigurableApplicationContext)ctx).close();
    }

	/**
	 * Creates the application context
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce)  { 
    	ctx = new ClassPathXmlApplicationContext("beans.xml");
    	sce.getServletContext().setAttribute("ctx", ctx);
    }
}
