package com.am.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.am.model.UserProfile;

public class UserDAOImpl implements UserDAO{

	static Logger LOGGER = Logger.getLogger(UserDAOImpl.class.getClass());
	
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

}
