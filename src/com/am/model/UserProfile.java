package com.am.model;

import java.util.Set;

public class UserProfile {
	private int userID;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String salt; //This is used in user validation 
	private Set<Company> companies;
	private UserSettings setting;
	
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public UserSettings getSetting() {
		return setting;
	}
	public void setSetting(UserSettings setting) {
		this.setting = setting;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}
	
	
}
