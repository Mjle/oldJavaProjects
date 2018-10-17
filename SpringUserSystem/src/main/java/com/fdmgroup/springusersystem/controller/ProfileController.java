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

@Controller
public class ProfileController {

	private ApplicationContext ctx;
	private UserDAO userDAO;
	
	/**
	 * Goes to profile page
	 * 
	 * @return - returns the profile page
	 */
	@RequestMapping(value = "/profile")
	public String goToProfile() {
		return "profile";
	}

    /**
     * Passes a model for data handling
     * @return - goes to edit profile page
     */
	@RequestMapping(value = "/editprofile")
	public String goToEditProfile(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		model.addAttribute("editUser", user);
		return "editprofile";
	}

	/**
	 * Handles the editprofile procedure. 
	 * 
	 * @return - returns to the edit profile page if current password failed.
	 */
	@RequestMapping(value = "/editprofileproc", method = RequestMethod.POST)
	public String editProfileProc(Model model, @ModelAttribute("editUser") User editUser,
			@RequestParam("desiredPassword") String desiredPassword,
			@RequestParam("confirmPassword") String confirmPassword, 
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		ctx = (ApplicationContext) session.getServletContext().getAttribute("ctx");
		userDAO = (UserDAO) ctx.getBean("UserDAO");
		User seshUser = (User) session.getAttribute("user");
		
		if(!editUser.getPassword().equals(seshUser.getPassword())) {
			model.addAttribute("passwordCurrentFail", true);
			return "editprofile";
		} 
		
		if (!desiredPassword.equals("") && desiredPassword.equals(confirmPassword)) {
			seshUser.setPassword(desiredPassword);
		} else if(!desiredPassword.equals("") && !desiredPassword.equals(confirmPassword)) {
			model.addAttribute("passwordFailed", true);
		}
		
		if (!seshUser.getFirstName().equals(editUser.getFirstName())) {
			seshUser.setFirstName(editUser.getFirstName());
		}
		if (!seshUser.getLastName().equals(editUser.getLastName())) {
			seshUser.setLastName(editUser.getLastName());
		}
		if (!seshUser.getEmail().equals(editUser.getEmail())) {
			seshUser.setEmail(editUser.getEmail());
		}
		
		userDAO.updateUser(seshUser);
		model.addAttribute("userPw", true);
		model.addAttribute("editUser", seshUser);
		return "editprofile";
	}

    /**
     * Deletes a user from database if logged in
     */
	@RequestMapping(value = "/removeproc")
	public String removeProc(HttpServletRequest req) {
		HttpSession userSesh = req.getSession();
		ctx = (ApplicationContext) userSesh.getServletContext().getAttribute("ctx");
		userDAO = (UserDAO) ctx.getBean("UserDAO");
		User removeUser = (User) userSesh.getAttribute("user");
		if (removeUser != null) {
			userDAO.removeUser(removeUser.getUsername());
			userSesh.removeAttribute("user");
			userSesh.invalidate();
		}
		return "index";
	}

}
