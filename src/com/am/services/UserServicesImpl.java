package com.am.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.am.dao.UserDAO;
import com.am.model.UserProfile;

public class UserServicesImpl implements UserServices{
	
	private UserDAO userDAO;
	static Logger LOGGER = Logger.getLogger(UserServicesImpl.class.getClass());
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void addUser(UserProfile user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserProfile user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserProfile> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProfile getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(int userID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkEmailAvailabity(String email) {
		// TODO Auto-generated method stub
		return true;//Hard coded value - Replace with actual logic
	}

	@Override
	public boolean validateUser(UserProfile user) {
		// TODO Auto-generated method stub
		/*
		 * Step 1 - Get encrypted password and salt from DB
		 * Step 2 - Encrypt user provided password with the salt obtained from DB
		 * Step 3 - Compare both encrypted password
		 */
		return true;
	}

	@Override
	public boolean validateEmail(String email) {
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	    Boolean b = false;
	    b = email.matches(EMAIL_REGEX);
	    return b;
	}

}
