package com.fdmgroup.servletproject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.servletproject.model.User;
import com.fdmgroup.servletproject.model.impl.UserDAO;

/**
 * RemoveUser allows you to delete your self if logged in.
 * @author michael.le
 *
 */
public class RemoveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RemoveUser() {
        super();
    }

	/**
	 * Handles GET method request.
	 * @return user object depending on username parameter passed in the request.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession userSesh = request.getSession();
		UserDAO userDAO = (UserDAO) getServletContext().getAttribute("listenerDAO");
		User removeUser = (User) userSesh.getAttribute("user");
		if (removeUser != null) {
			userDAO.removeUser(removeUser.getUsername());
			userSesh.removeAttribute("user");
			userSesh.invalidate();
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("./");
		rd.forward(request, response);
	}


}
