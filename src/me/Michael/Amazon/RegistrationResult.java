package me.Michael.Amazon;

public class RegistrationResult {
	 private boolean success;
	 private String userID;
	 private User user;
	 
	 public RegistrationResult(boolean success, String userID) {
		 this.success = success;
		 this.userID = userID;
	 }
	 
	 public boolean successful() {
		 return this.success;
	 }
	 
	 public String getUserID() {
		 return this.userID;
	 }
	 
	 public void setUser(User user) {
		 this.user = user;
	 }
	 
	 public User getUser() {
		 return this.user;
	 }
}
