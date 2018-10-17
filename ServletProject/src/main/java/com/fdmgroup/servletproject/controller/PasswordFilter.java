package com.fdmgroup.servletproject.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.fdmgroup.servletproject.model.impl.UserDAO;

/**
 * Servlet Filter implementation class PasswordFilter
 */
public class PasswordFilter implements Filter {
	
	private UserDAO dao;
	
    public PasswordFilter() {}
    
	public void destroy() {}

	/**
	 * Filters for valid login password.
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		boolean passwordFailed = false;
		
		if (!request.getParameter("password").equals(dao.getUser(request.getParameter("username")).getPassword())) {
			passwordFailed = true;
		}
		
		if (passwordFailed) {
			request.setAttribute("passwordFailed", passwordFailed);
			RequestDispatcher rd = request
					.getRequestDispatcher("/login");
			rd.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * Retrieves the UserDAO from the listener
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		dao = (UserDAO) fConfig.getServletContext().getAttribute("listenerDAO");
	}

}
