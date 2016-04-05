package com.am.model;

public class UserSettings {
	private boolean itemWiseDiscount;
	private boolean itemWiseVat;
	
	public UserSettings(){
		itemWiseDiscount = false;
		itemWiseVat = false;
	}
	
	public boolean isItemWiseDiscount() {
		return itemWiseDiscount;
	}
	public void setItemWiseDiscount(boolean itemWiseDiscount) {
		this.itemWiseDiscount = itemWiseDiscount;
	}
	public boolean isItemWiseVat() {
		return itemWiseVat;
	}
	public void setItemWiseVat(boolean itemWiseVat) {
		this.itemWiseVat = itemWiseVat;
	}
	
	
}
