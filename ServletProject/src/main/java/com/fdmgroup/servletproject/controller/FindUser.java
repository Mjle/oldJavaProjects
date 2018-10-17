package com.fdmgroup.servletproject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.servletproject.model.User;
import com.fdmgroup.servletproject.model.impl.UserDAO;

/**
 * FindUser servlet allows you to search for a specified user.
 * @author michael.le
 *
 */
public class FindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String validUsernameRegex = "[A-Za-z0-9_]+";
	
    public FindUser() {
        super();
    }

	/**
	 * Handles GET method request.
	 * @return user object depending on username parameter passed in the request.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user").toLowerCase();
		UserDAO userDAO = (UserDAO) getServletContext().getAttribute("listenerDAO");
		boolean found = false;
		User returnedUser = null;
		
		if (username.trim().matches(validUsernameRegex)){
			returnedUser = userDAO.getUser(username);
		}
		
		if (returnedUser != null) {
			found = true;
		}
		
		request.setAttribute("user", returnedUser);
		request.setAttribute("found", found);
		RequestDispatcher rd = request
				.getRequestDispatcher("/userinfo");
		rd.forward(request, response);
	}


}
