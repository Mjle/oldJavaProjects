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
 * Servlet Filter implementation class LoginFilter
 */
public class UsernameFilter implements Filter {
	private static final String validUsernameRegex = "[A-Za-z0-9_]+";
	private UserDAO dao;

	public UsernameFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * Filters username for proper input, then passes it to password filter.
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean usernameFailed = false;
		String username = request.getParameter("username").toLowerCase();
		if (!username.matches(validUsernameRegex) || dao.getUser(username) == null) {
			usernameFailed = true;
		}

		if (usernameFailed) {
			request.setAttribute("usernameFailed", usernameFailed);
			RequestDispatcher rd = request.getRequestDispatcher("/login");
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
