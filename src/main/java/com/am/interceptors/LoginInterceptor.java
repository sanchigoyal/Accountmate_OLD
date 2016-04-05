package com.am.interceptors;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.am.constants.UserConstants;



public class LoginInterceptor implements HandlerInterceptor {
	
	private static final String BASE_URI = "/Accountmate";
	private static final String INDEX_URL = BASE_URI+"/index";
	/*
	 * These are those URIs which do not require users to login
	 */
	private static final String[] NON_SECURE_URI = {INDEX_URL,
													BASE_URI+"/checkEmailAvailibility",
													BASE_URI+"/signup",
													BASE_URI+"/register",
													BASE_URI+"/login",
													BASE_URI+"/loginError",
													BASE_URI+"/contact",
													BASE_URI+"/aboutUs"};
	
	private static final String[] AJAX_SECURE_URI = {BASE_URI+"/getEditItemPage"};
	public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {	
		HttpSession session = request.getSession(); 
		//Authentication logic here
		
         if(!Arrays.asList(NON_SECURE_URI).contains(request.getRequestURI()) && !request.getRequestURI().startsWith(BASE_URI+"/resources/")){
        	String login = null;
 			if(session.getAttribute("login") !=null){
 				login=(String)session.getAttribute("login");
 				if(!"success".equals(login) || session.getAttribute(UserConstants.USER_NAME)== null){
 					if(Arrays.asList(AJAX_SECURE_URI).contains(request.getRequestURI())){
 						response.sendRedirect(BASE_URI+"/handleAjaxSessionTimeout");
 					}else{
 						response.sendRedirect(INDEX_URL);
 					}
 					return false;
 				}	
 			}
 			else{
 				
 				if(Arrays.asList(AJAX_SECURE_URI).contains(request.getRequestURI())){
						response.sendRedirect(BASE_URI+"/handleAjaxSessionTimeout");
					}else{
						response.sendRedirect(INDEX_URL);
				}
	     		return false;
 			}
         }
        return true;
    }
    //override postHandle() and afterCompletion() 

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
	}

}
