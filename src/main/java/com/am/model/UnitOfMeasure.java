package com.am.model;

import java.util.List;

public class UnitOfMeasure {
	private int uomID;
	private String uomName;
	private String symbol;
	private int userID;
	private List<Item> items;
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getUomID() {
		return uomID;
	}
	public void setUomID(int uomID) {
		this.uomID = uomID;
	}
	public String getUomName() {
		return uomName;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
}
