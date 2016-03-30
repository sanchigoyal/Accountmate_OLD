package com.am.services;

import java.util.List;

import com.am.model.UserProfile;

public interface UserServices {
	/**
	 * Method to add user 
	 * @param user
	 */
	public void addUser(UserProfile user);
	
	/**
	 * Method to update user
	 * @param user
	 */
	public void updateUser(UserProfile user);
	
	/**
	 * Method to list all users - for Admin purpose
	 * @return
	 */
	public List<UserProfile> listUsers();
	
	/**
	 * Method to get User by Email ID - UserName
	 * @param email
	 * @return
	 */
	public UserProfile getUserByEmail(String email);
	
	/**
	 * Method to close the user account
	 * This does not delete the user
	 * @param userID
	 */
	public void removeUser(int userID);
	
	/**
	 * Method to check if email is available 
	 * @param email
	 * @return
	 */
	public boolean checkEmailAvailabity(String email);
	
	/**
	 * Method to validate user login credentials
	 * @param user
	 * @return
	 */
	public boolean validateUser(UserProfile user);
}
