package me.Michael.Amazon;

public class User {
	private int userID;
	private String firstName, lastName, username, password, role;
	
	public User(int userID, String firstName, String lastName, String username, String password, String role) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public int getUserID() {
		return this.userID;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
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
