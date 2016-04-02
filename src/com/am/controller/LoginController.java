package com.am.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.am.constants.UserConstants;
import com.am.model.UserProfile;
import com.am.services.UserServices;

@Controller
public class LoginController {

	private UserServices userServices;
	static Logger LOGGER = Logger.getLogger(LoginController.class.getClass());

	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}

	@RequestMapping("/index")
	public String getIndexPage(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();
		String login = null;
		if (session.getAttribute("login") != null) {
			login = (String) session.getAttribute("login");
			if ("success".equals(login) && session.getAttribute(UserConstants.USER_NAME) != null) {
				return "redirect:/home"; // This URL is for welcome page of USER
			}
			/*
			 * Invalidate the session otherwise attribute "login" will continue
			 * to persist.
			 */
			session.invalidate();
		}

		// Not logged in then continue...
		return "access/index";
	}
	
	@RequestMapping("/signup")
	public String getSignupPage(@ModelAttribute("Accountmate") UserProfile user, HttpServletRequest request,
			ModelMap model) {
		model.addAttribute("user", user);
		return "access/signup";
	}
	
	@RequestMapping(value = "/checkEmailAvailibility", method = RequestMethod.GET)
	public @ResponseBody String checkEmailAvailibility(@RequestParam("email") String email) {
		if (userServices.checkEmailAvailabity(email)) {
			return "{\"valid\":true}";
		}
		return "{\"valid\":false}";
	}
	
	@RequestMapping(value = "/login")
	public String login(@ModelAttribute("Accountmate") UserProfile user, HttpServletRequest request, ModelMap model) {
		/*
		 * Failure redirect to login error page ;Success add variables to session &
		 * redirect to user home page If already log in , redirect to user home
		 * page
		 */
		HttpSession session = request.getSession();
		String login = null;
		/* Already log in */
		if (session.getAttribute("login") != null) {
			login = (String) session.getAttribute("login");
			if ("success".equals(login) && session.getAttribute(UserConstants.USER_NAME) != null) {
				return "redirect:/home"; // This URL is for welcome page of USER
			}

			/*
			 * Invalidate the session otherwise attribute "login" will continue
			 * to persist.
			 */
			session.invalidate();
		}

		if (userServices.validateUser(user)) {
			session.setAttribute("login", "success");
	    	session.setAttribute(UserConstants.USER_NAME, user.getUserID());
			/*
			 * Set other attribute here e.g User Settings, email and company info
			 */
			return "redirect:/home";
		}

		session.setAttribute("login", "failure");
		session.setAttribute("message", UserConstants.INVALID_USERNAME_PASSWORD);
		return "redirect:/loginError";
	}
	
	@RequestMapping(value = "/loginError")
	public String getLoginErrorPage(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();
		String login = null;

		/* Already log in */
		if (session.getAttribute("login") != null) {
			login = (String) session.getAttribute("login");
			if ("success".equals(login) && session.getAttribute(UserConstants.USER_NAME) != null) {
				return "redirect:/home"; // This URL is for welcome page of USER
			}
			
			model.addAttribute("success", "false");
			model.addAttribute("message", session.getAttribute("message"));
			/*
			 * Invalidate the session otherwise attribute "login" will continue
			 * to persist.
			 */
			session.invalidate();
		}

		return "access/login";
	}
	
	@RequestMapping("/logout")
	public String logout(ModelMap model,HttpServletRequest request){
		HttpSession session = request.getSession(false);
		LOGGER.info("User - "+session.getAttribute(UserConstants.USER_NAME)+" has logged out.");
        if(session != null){
            session.invalidate();
        }
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("Accountmate") UserProfile user, HttpServletRequest request,
			ModelMap model) {
		/*
		 * Put the logic for registration
		 */
		/*
		 * Remember to encrypt password and store both encrypted password and its salt in DB.
		 */
		/*
		 * Success - redirect to home
		 * Failure - redirect to index (handle msg display on index page)
		 */
		userServices.addUser(user);
		return "redirect:/index";
	}
	
	@RequestMapping("contact")
	public String getContactDetails(ModelMap model,HttpServletRequest request){
		
		return "access/contact";
	}
	
	@RequestMapping("aboutUs")
	public String getAboutUsPage(ModelMap model,HttpServletRequest request){
		return "access/about"; 
	}
	
	@RequestMapping("/home")
	public String getUserHomePage(HttpServletRequest request, ModelMap model) {
		return "access/home";
	}

}
