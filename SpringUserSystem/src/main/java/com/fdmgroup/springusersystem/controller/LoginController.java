package com.fdmgroup.springusersystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.springusersystem.model.impl.User;
import com.fdmgroup.springusersystem.model.impl.UserDAO;

/**
 * Controls the login page functionality.
 * @author Krampus
 *
 */
@Controller
public class LoginController {

	private ApplicationContext ctx;
	private UserDAO userDAO;
	private static final String validUsernameRegex = "[A-Za-z0-9_]+";

	/**
	 * Goes to login page
	 * @return - returns the login page
	 */
	@RequestMapping(value = "/login")
	public String goToLogin() {
		return "login";
	}

	/**
	 * Handles the login procedure. Takes in the username and password to handle
	 * @return - returns to the login page if credentials failed.
	 */
	@RequestMapping(value = "/loginproc", method = RequestMethod.POST)
	public String login(Model model, @RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, HttpServletRequest req) {
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		userDAO = (UserDAO) ctx.getBean("UserDAO");
		username = username.toLowerCase();
		boolean usernameValid = checkValidUsername(username);
		boolean passwordValid = checkValidPassword(username, password);

		if (!usernameValid) {
			model.addAttribute("usernameFailed", true);
		}

		if (!passwordValid) {
			model.addAttribute("passwordFailed", true);
		}

		if (usernameValid && passwordValid) {
			User loggedInUser = userDAO.getUser(username);
			session.setAttribute("user", loggedInUser);
			return "success";
		} else {
			return "login";
		}

	}

	/**
	 * Handle the username credential. 
	 * Check if it is of valid type and that it is in the database.
	 * @param username - username to check
	 * @return true or false if the username is valid.
	 */
	private boolean checkValidUsername(String username) {
		User returnedUser = null;
		returnedUser = userDAO.getUser(username);
		if (username.matches(validUsernameRegex) && returnedUser != null) {
			return true;
		}
		return false;
	}

	/**
	 * Handles the password credential
	 * @param username goes to the database and sees if it exist
	 * @param password check if the password given and is the same as database
	 * @return true or false if password matched
	 */
	private boolean checkValidPassword(String username, String password) {
		User returnedUser = null;
		returnedUser = userDAO.getUser(username);
		if (returnedUser == null) {
			return false;
		} else {
			String expectedPassword = returnedUser.getPassword();
			if (password.equals(expectedPassword)) {
				return true;
			}
		}
		return false;
	}

	/** 
	 * Log the user out and invalidates the session
	 * @param request takes in the request to handle
	 * @return the home page 
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession userSesh = request.getSession();
		userSesh.removeAttribute("user");
		userSesh.invalidate();
		return "index";
	}

}
