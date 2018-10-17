package com.fdmgroup.servletproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.servletproject.model.User;
import com.fdmgroup.servletproject.model.impl.UserDAO;

/**
 * Servlet implementation class ListUsers
 */
public class ListUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListUsers() {
        super();
    }

	/**
	 * Handles GET method request.
	 * Forwards a list of users to the listuserspage.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = (UserDAO) getServletContext().getAttribute("listenerDAO");
		List<User> users = userDAO.listUsers();
		request.setAttribute("users", users);
		RequestDispatcher rd = request
				.getRequestDispatcher("/listuserspage");
		rd.forward(request, response);
	}


}
