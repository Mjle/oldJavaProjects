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
public class RegisterFilter implements Filter {

	private UserDAO dao;
	private static final String validUsernameRegex = "[A-Za-z0-9_]+";

	public RegisterFilter() {}
	public void destroy() {}

	/**
	 * RegisterFilter ensures correct username parameters, username doesn't already exist, and password matches
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String password = request.getParameter("password");
		boolean usernameFailed = false;
		boolean passwordFailed = false;
		String username = request.getParameter("username").toLowerCase();
		
		if (!username.matches(validUsernameRegex)) {
			usernameFailed = true;
		}
		
		if (dao.getUser(username) != null){
			usernameFailed = true;
		}
		
		if (!password.equals(request.getParameter("confirmpassword")) || password.trim().equals("")) {
			passwordFailed = true;
		}
		
		if (usernameFailed || passwordFailed) {
			request.setAttribute("usernameFailed", usernameFailed);
			request.setAttribute("passwordFailed", passwordFailed);
			RequestDispatcher rd = request
					.getRequestDispatcher("/registerpage");
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
