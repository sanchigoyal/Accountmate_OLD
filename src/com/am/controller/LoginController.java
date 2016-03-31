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
	
	public void setUserServices(UserServices userServices){
		this.userServices = userServices;
	}
	
	@RequestMapping("/index")
	   public String getIndexPage(HttpServletRequest request,ModelMap model) {
			HttpSession session = request.getSession();
			String login = null;
			if(session.getAttribute("login") !=null){
				login=(String)session.getAttribute("login");
				if("success".equals(login) && session.getAttribute(UserConstants.USER_NAME)!= null){
					return "redirect:/home"; // This URL is for welcome page of USER
				}
				model.addAttribute("success","false");
				model.addAttribute("message",UserConstants.INVALID_USERNAME_PASSWORD);
				/*
				 * Invalidate the session otherwise attribute "login" will continue to persist.
				 * This will result into error message "invalid email or password on the GUI."
				 */
				session.invalidate();
			}
			
			if(session.getAttribute("success")!=null){
				model.addAttribute("success",(String)session.getAttribute("success"));
				model.addAttribute("message",(String)session.getAttribute("message"));
				session.removeAttribute("message");
				session.removeAttribute("success");
			}
			
	      return "access/index";
	   }
	
	@RequestMapping("/signup")
	   public String getSignupPage(@ModelAttribute("Accountmate")UserProfile user,HttpServletRequest request,ModelMap model) {
		  model.addAttribute("user",user);
		  return "access/signup";
	   }
	
	@RequestMapping(value = "/checkEmailAvailibility", method = RequestMethod.GET)
	public @ResponseBody String checkEmailAvailibility(@RequestParam("email") String email) {
		if(userServices.checkEmailAvailabity(email)){
			return  "{\"valid\":true}";
		}
		return "{\"valid\":true}";
	}
	
	@RequestMapping(value = "/login")
	public String login(@ModelAttribute("Accountmate")UserProfile user, HttpServletRequest request,ModelMap model){
		/*
		 * I/P incorrect redirect to new login page with error message
		 * Failure redirect to new login page
		 * Success add variables to session & redirect to user home page
		 * If already log in , redirect to user home page
		 */
		HttpSession session = request.getSession();
		String login = null;
		String message = null;
		
		/*Already log in */
		if(session.getAttribute("login") !=null){
			login=(String)session.getAttribute("login");
			if("success".equals(login) && session.getAttribute(UserConstants.USER_NAME)!= null){
				return "redirect:/home"; // This URL is for welcome page of USER
			}
			
			/*
			 * If login variable not available but session exists - invalidate the session
			 */
			session.invalidate();
		}	
		
		if(!userServices.validateEmail(user.getEmail())){
			message = "Email is in invalid format !!";
			session.setAttribute("message", message);
			session.setAttribute("login", "failure");
			return "redirect:/loginError";
		}
		
		if(userServices.validateUser(user)){
			session.setAttribute("login","success");
			/*
			 * Set other attribute here
			 */
			return "redirect:/home";
		}
		
		session.setAttribute("login", "failure");
		return "redirect:/loginError";
	}
	
	@RequestMapping(value="/loginError")
	public String getLoginErrorPage(HttpServletRequest request, ModelMap model){
		HttpSession session = request.getSession();
		String login = null;
		//	String message = null;
		
		/*Already log in */
		if(session.getAttribute("login") !=null){
			login=(String)session.getAttribute("login");
			if("success".equals(login) && session.getAttribute(UserConstants.USER_NAME)!= null){
				return "redirect:/home"; // This URL is for welcome page of USER
			}
			
			model.addAttribute("message",session.getAttribute("message"));
			/*
			 * If login variable not available but session exists - invalidate the session
			 */
			session.invalidate();
		}	
		
		return "access/login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("Accountmate")UserProfile user,HttpServletRequest request,ModelMap model){
		/*
		 * Put the logic for registration
		 */
		userServices.addUser(user);
		return "redirect:/index";
	}
}
