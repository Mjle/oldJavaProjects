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
 * Servlet implementation class LoginServlet
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * Handles POST method request from filters.
	 * Enable user information to accessed in the session scope.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username").toLowerCase();
		String password = request.getParameter("password");

		UserDAO userDAO = (UserDAO) getServletContext().getAttribute("listenerDAO");
		User returnedUser = userDAO.getUser(username);
		boolean loggedIn = false;
		HttpSession session = request.getSession();

		if (returnedUser != null) {
			if (returnedUser.getPassword().equals(password)) {
				loggedIn = true;
				session.setAttribute("user", returnedUser);
			}
		}
		
		session.setAttribute("loggedIn", loggedIn);

		RequestDispatcher rd = request.getRequestDispatcher("/success");
		rd.forward(request, response);

	}

}
