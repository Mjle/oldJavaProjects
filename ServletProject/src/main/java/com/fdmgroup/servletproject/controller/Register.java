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
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
    }

	/**
	 * Handles POST method request from filters. 
	 * Sets user attributes for session scope.
	 * Can force a runtime exception(NullPointerException); see below.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String username = request.getParameter("username").toLowerCase();
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		UserDAO userDAO = (UserDAO) getServletContext().getAttribute("listenerDAO");
		
		//Comment out line below for runtime exception error
		User user = new User(firstName, lastName, username, password, email);
		
		//Uncomment line below, register with valid user credentials to see runtime exception error page
		//User user = null;
		
		boolean added = userDAO.addUser(user);
		HttpSession session=request.getSession();  
		session.setAttribute("user", user);
		session.setAttribute("added", added);
		session.setAttribute("loggedIn", true);
		RequestDispatcher rd = request
				.getRequestDispatcher("/success");
		rd.forward(request, response);
	}

}
