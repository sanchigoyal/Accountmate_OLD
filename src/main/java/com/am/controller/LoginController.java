package com.am.controller;

import java.security.NoSuchAlgorithmException;

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
import com.am.util.Crypt;

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
		if (session.getAttribute(UserConstants.ATTR_LOGIN) != null) {
			login = (String) session.getAttribute(UserConstants.ATTR_LOGIN);
			if (UserConstants.REQUEST_SUCCESS.equals(login) && session.getAttribute(UserConstants.USER_NAME) != null) {
				return "redirect:/home"; // This URL is for welcome page of USER
			}
			
			model.addAttribute("success","false");
			model.addAttribute("message",session.getAttribute("message"));
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
		if (session.getAttribute(UserConstants.ATTR_LOGIN) != null) {
			login = (String) session.getAttribute(UserConstants.ATTR_LOGIN);
			if (UserConstants.REQUEST_SUCCESS.equals(login) && session.getAttribute(UserConstants.USER_NAME) != null) {
				return "redirect:/home"; // This URL is for welcome page of USER
			}

			/*
			 * Invalidate the session otherwise attribute "login" will continue
			 * to persist.
			 */
			session.invalidate();
		}

		if (userServices.validateUser(user)) {
			session.setAttribute(UserConstants.ATTR_LOGIN, UserConstants.REQUEST_SUCCESS);
	    	session.setAttribute(UserConstants.USER_NAME, user.getUserID());
			/*
			 * Set other attribute here e.g User Settings, email and company info
			 */
			return "redirect:/home";
		}

		session.setAttribute(UserConstants.ATTR_LOGIN, UserConstants.REQUEST_FAILURE);
		session.setAttribute("message", UserConstants.INVALID_USERNAME_PASSWORD);
		return "redirect:/loginError";
	}
	
	@RequestMapping(value = "/loginError")
	public String getLoginErrorPage(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession();
		String login = null;

		/* Already log in */
		if (session.getAttribute(UserConstants.ATTR_LOGIN) != null) {
			login = (String) session.getAttribute(UserConstants.ATTR_LOGIN);
			if (UserConstants.REQUEST_SUCCESS.equals(login) && session.getAttribute(UserConstants.USER_NAME) != null) {
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
		String message = null;
		String salt = null;
		String securePassword = null;
		HttpSession session = request.getSession();
		
		try{
			/*
			 * Encrypt password and store both encrypted password and its salt in DB.
			 */
			salt = Crypt.getSalt();
			securePassword = Crypt.get_SHA_1_SecurePassword(user.getPassword(), salt); 
			
			user.setPassword(securePassword);
			user.setSalt(salt);
			
			/*
			 * Success - redirect to home
			 * Failure - redirect to index (handle msg display on index page)
			 */
			if(userServices.addUser(user)){
				/*
				 * Set all session variables here
				 */
				session.setAttribute(UserConstants.ATTR_LOGIN, UserConstants.REQUEST_SUCCESS);
		    	session.setAttribute(UserConstants.USER_NAME, user.getUserID());
		    	
				return "redirect:/home";
			}
			
			message = UserConstants.REQUEST_PROCESSING_FAILED;
			
		}catch(NoSuchAlgorithmException nsae){
			message = UserConstants.REQUEST_PROCESSING_FAILED;
		}
		catch(Exception e){
			LOGGER.error(e.getMessage(), e);;
			message = UserConstants.REQUEST_PROCESSING_FAILED;
		}
		
		session.setAttribute(UserConstants.ATTR_LOGIN, UserConstants.REQUEST_FAILURE);
		session.setAttribute("message", message);
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
