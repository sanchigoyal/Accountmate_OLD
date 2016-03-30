package com.am.interceptors;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class LoginInterceptor implements HandlerInterceptor {
	
	/*
	 * These are those URIs which do not require users to login
	 */
	private static final String[] NON_SECURE_URI = {"/Accountmate/login",
													"/Accountmate/checkEmailAvailibility",
													"/Accountmate/signup"};
	private static final String[] AJAX_SECURE_URI = {"/Accountmate/getEditItemPage"};
	@Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {	
		HttpSession session = request.getSession(); 
		//Authentication logic here
		
         if(!Arrays.asList(NON_SECURE_URI).contains(request.getRequestURI()) && !request.getRequestURI().startsWith("/Accountmate/resources/")){
        	String login = null;
 			if(session.getAttribute("login") !=null){
 				login=(String)session.getAttribute("login");
 				if(!"success".equals(login) || session.getAttribute("userid")== null){
 					if(Arrays.asList(AJAX_SECURE_URI).contains(request.getRequestURI())){
 						response.sendRedirect("/Accountmate/handleAjaxSessionTimeout");
 					}else{
 						response.sendRedirect("/Accountmate/login");
 					}
 					return false;
 				}	
 			}
 			else{
 				
 				if(Arrays.asList(AJAX_SECURE_URI).contains(request.getRequestURI())){
						response.sendRedirect("/Accountmate/handleAjaxSessionTimeout");
					}else{
						response.sendRedirect("/Accountmate/login");
				}
	     		return false;
 			}
         }
        return true;
    }
    //override postHandle() and afterCompletion() 

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
	}

}
