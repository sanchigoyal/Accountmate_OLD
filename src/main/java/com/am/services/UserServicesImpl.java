package com.am.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.am.dao.UserDAO;
import com.am.model.UserProfile;
import com.am.util.Crypt;

public class UserServicesImpl implements UserServices{
	
	private UserDAO userDAO;
	static Logger LOGGER = Logger.getLogger(UserServicesImpl.class.getClass());
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean addUser(UserProfile user) {
		// TODO Auto-generated method stub
		return userDAO.addUser(user);
	}

	public void updateUser(UserProfile user) {
		// TODO Auto-generated method stub
		
	}

	public List<UserProfile> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserProfile getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeUser(int userID) {
		// TODO Auto-generated method stub
		
	}

	public boolean checkEmailAvailabity(String email) {
		UserProfile user = userDAO.getUserByEmail(email);
		return (user != null)? false:true;
	}

	public boolean validateUser(UserProfile user) {
		/*
		 * Step 1 - Get encrypted password and salt from DB
		 * Step 2 - Encrypt user provided password with the salt obtained from DB
		 * Step 3 - Compare both encrypted password
		 */
		UserProfile availableProfile = userDAO.getUserByEmail(user.getEmail());
		if(availableProfile == null){
			return false;
		}
		
		String encryptPassword = Crypt.get_SHA_1_SecurePassword(user.getPassword(), availableProfile.getSalt()); 
		return (availableProfile.getPassword().equals(encryptPassword))?true:false;
		
	}

	public boolean validateEmail(String email) {
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	    Boolean b = false;
	    b = email.matches(EMAIL_REGEX);
	    return b;
	}

}
