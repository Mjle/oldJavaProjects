package com.fdmgroup.springusersystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.springusersystem.model.impl.User;
import com.fdmgroup.springusersystem.model.impl.UserDAO;

/**
 * Handles the registration page and functionalities
 * @author Krampus
 *
 */
@Controller
public class RegisterController {

	private ApplicationContext ctx;
	private UserDAO userDAO;
	private static final String validUsernameRegex = "[A-Za-z0-9_]+";

	/**
	 * Goes to register page
	 * @param model - passes a User model in to be manipulated
	 * @param req - obtains the application context to get beans
	 * @return - returns the register page
	 */
	@RequestMapping(value = "/register")
	public String goToRegisterPage(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		User user = (User) ctx.getBean("newUser");
		model.addAttribute("user", user);
		return "register";
	}
	
	/**
	 * Handles the register procedure
	 * @param model takes in the user model to further processing
	 * @param user is the user object we can store in the database using
	 * @param req allows us to obtain the application context and get the beans
	 * @param confirmPassword will allow us to get the password to match
	 * @return the register or success page depending if the register was successful
	 */
	@RequestMapping(value = "/registerproc", method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute("user") User user, HttpServletRequest req,
			@RequestParam(value = "confirmPassword") String confirmPassword) {
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		userDAO = (UserDAO) ctx.getBean("UserDAO");
		boolean usernameValid = checkValidUsername(user.getUsername());
		boolean passwordValid = checkValidPassword(user.getPassword(), confirmPassword);

		if (!usernameValid) {
			model.addAttribute("usernameFailed", true);
		}

		if (!passwordValid) {
			model.addAttribute("passwordFailed", true);
		}

		if (usernameValid && passwordValid) {
			userDAO.addUser(user);
			session.setAttribute("user", user);
			session.setAttribute("registered", true);
		} else {
			return "register";
		}
		return "success";
	}

	/**
	 * Handle the username credential. 
	 * Check if it is of valid type and that it is in the database.
	 * @param username - username to check
	 * @return true or false if the username is valid.
	 */
	private boolean checkValidUsername(String username) {
		User user = null;
		user = userDAO.getUser(username);
		if (username.matches(validUsernameRegex) && user == null) {
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
	private boolean checkValidPassword(String password, String confirmPassword) {
		if (password.equals(confirmPassword)) {
			return true;
		}
		return false;
	}
}
