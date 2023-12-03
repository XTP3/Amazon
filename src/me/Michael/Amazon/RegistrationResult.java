package me.Michael.Amazon;

public class RegistrationResult {
	 private final boolean success;
	 private final String userID;
	 
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
}
