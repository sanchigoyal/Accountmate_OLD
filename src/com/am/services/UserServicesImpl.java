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
		return false;
	}

	@Override
	public boolean validateUser(UserProfile user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
