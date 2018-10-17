package com.fdmgroup.springusersystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.springusersystem.model.impl.User;
import com.fdmgroup.springusersystem.model.impl.UserDAO;

/**
 * Home controller
 * @author Krampus
 *
 */
@Controller
public class NavController {
	
	private ApplicationContext ctx;
	private UserDAO userDAO;

	/**
	 * Goes to the home page
	 * @return the index jsp page
	 */
	@RequestMapping(value="/")
	public String goHome(){
		return "index";
	}
	
	/**
	 * Returns a list of user in list users page
	 * @param model gives a users attribute for info display
	 * @param req allows us to access the application context
	 * @return a user info page
	 */
	@RequestMapping(value="/listusers")
	public String listUsers(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		userDAO = (UserDAO) ctx.getBean("UserDAO");
		List<User> users = userDAO.listUsers();
		model.addAttribute("users", users);
		return "listusers";
	}
	
	/**
	 * Finds a user when searched using navigation search bar
	 * @param username is the user they want to search
	 * @param model gives a user attribute for info display
	 * @param req allows us to access the application context
	 * @return a user info page
	 */
	@RequestMapping(value="/finduser")
	public String findUser(@RequestParam String username, Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		userDAO = (UserDAO) ctx.getBean("UserDAO");
		User user = userDAO.getUser(username.trim().toLowerCase());
		model.addAttribute("user", user);
		return "userinfo";
	}
	
}
