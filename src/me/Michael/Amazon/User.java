package me.Michael.Amazon;

public class User {
	private String userID, username, password, role;
	private Customer customer;
	private Vendor vendor;
	
	public User(String userID, String username, String password, String role) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	public Vendor getVendor() {
		return this.vendor;
	}
	
	public String getUserID() {
		return this.userID;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public String getFormattedRole() {
		return this.role.substring(0, 1).toUpperCase() + this.role.substring(1).toLowerCase();
	}
}