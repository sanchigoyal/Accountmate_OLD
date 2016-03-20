package com.am.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.am.constants.UserConstants;
import com.am.model.UserProfile;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	   public String getLoginPage(HttpServletRequest request,ModelMap model) {
			HttpSession session = request.getSession();
			String login = null;
			if(session.getAttribute("login") !=null){
				login=(String)session.getAttribute("login");
				if("success".equals(login) && session.getAttribute(UserConstants.USER_NAME)!= null){
					return "redirect:/home"; 
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
			
	      return "access/login";
	   }
	
	@RequestMapping("/signup")
	   public String getSignupPage(@ModelAttribute("Accountmate")UserProfile user,HttpServletRequest request,ModelMap model) {
		  System.out.println("Email -------"+user.getEmail());
		  System.out.println("Password --------"+user.getPassword());
		  model.addAttribute("user",user);
		  return "access/signup";
	   }
	
	@RequestMapping(value = "/checkEmailAvailibility", method = RequestMethod.GET)
	public @ResponseBody String checkEmailAvailibility(@RequestParam("email") String email) {
//		if(userDAO.checkEmailAvailibility(email)){
//			return  "{\"valid\":true}";
//		}
		return "{\"valid\":true}";
	}
}
