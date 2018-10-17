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
 * Servlet for Editting Profile
 * @author Michael Le
 *
 */
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditProfile() {
		super();
	}

	/**
	 * Expects a POST method for parameters of user information to be pass through
	 * Checks if the password is the same as the one in the database
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		UserDAO userDAO = (UserDAO) getServletContext().getAttribute("listenerDAO");
		HttpSession userSesh = request.getSession();
		User user = (User) userSesh.getAttribute("user");
		boolean validPw = false;
		boolean userPw = false;
		
		if (request.getParameter("currentpassword").equals(user.getPassword())){
			userPw = true;
		}
		if (request.getParameter("confirmpassword").equals(password) && !password.trim().equals("")) {
			validPw = true;
		}
		
		if (userPw) {
			user.setFirstName(firstName);
			user.setLastName(lastName);
			if (validPw) {
			user.setPassword(password);
			}
			user.setEmail(email);
			userDAO.updateUser(user);
		}
		userSesh.setAttribute("userPw", userPw);
		userSesh.setAttribute("validPw", validPw);
		userSesh.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/editprofile");
		rd.forward(request, response);

	}

}
