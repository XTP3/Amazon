package me.Michael.Amazon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import me.Michael.Amazon.Database;
import me.Michael.Amazon.RegistrationResult;
import me.Michael.Utils.Utils;

public class Queries {
	public static boolean validateCredentials(String username, String password) {
		return false;
	}
	
	public static RegistrationResult registerNewUser(HashMap<String, String> credentials, String role) {
		String username = credentials.get("username"), password = credentials.get("password"), userID = Utils.generateUniqueID(20);
		String query = "INSERT INTO user (userID, username, password, role) VALUES (?, ?, ?, ?)";
	    
	    // Using try-with-resources to ensure the PreparedStatement and its resources are closed
	    try (PreparedStatement preparedStatement = Database.connection.prepareStatement(query)) {
	    	preparedStatement.setString(1, userID);
	        preparedStatement.setString(2, username);
	        preparedStatement.setString(3, password);
	        preparedStatement.setString(4, role.toUpperCase());

	        return new RegistrationResult(preparedStatement.executeUpdate() > 0, userID);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return new RegistrationResult(false, "");
	}
	
	public static RegistrationResult registerNewCustomer(User user) {
		String query = "INSERT INTO customer (customerID, firstName, lastName, state, city, zipCode, streetAddress, billingType, cardNumber, primeStatus, phoneNumber, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Customer customer = user.getCustomer();
		
	    try (PreparedStatement preparedStatement = Database.connection.prepareStatement(query)) {
	    	preparedStatement.setString(1, user.getUserID());
	        preparedStatement.setString(2, customer.getFirstName());
	        preparedStatement.setString(3, customer.getLastName());
	        preparedStatement.setString(4, customer.getState());
	        preparedStatement.setString(5, customer.getCity());
	        preparedStatement.setString(6, customer.getZipCode());
	        preparedStatement.setString(7, customer.getStreetAddress());
	        preparedStatement.setString(8, customer.getBillingType());
	        preparedStatement.setLong(9, customer.getCardNumber());
	        preparedStatement.setBoolean(10, customer.getPrimeStatus());
	        preparedStatement.setLong(11, customer.getPhoneNumber());
	        preparedStatement.setString(12, customer.getEmail());
	        
	        RegistrationResult result = new RegistrationResult(preparedStatement.executeUpdate() > 0, user.getUserID());
	        result.setUser(user);
	        
	        return result;
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
		return new RegistrationResult(false, "");
	}
	
	public static RegistrationResult registerNewVendor(User user) {
		String query = "INSERT INTO vendor (vendorID, vendorName, phoneNumber, email, routingNumber, accountNumber) VALUES (?, ?, ?, ?, ?, ?)";
		Vendor vendor = user.getVendor();
		
	    try (PreparedStatement preparedStatement = Database.connection.prepareStatement(query)) {
	    	preparedStatement.setString(1, user.getUserID());
	        preparedStatement.setString(2, vendor.getVendorName());
	        preparedStatement.setLong(3, vendor.getPhoneNumber());
	        preparedStatement.setString(4, vendor.getEmail());
	        preparedStatement.setLong(5, vendor.getRoutingNumber());
	        preparedStatement.setLong(6, vendor.getAccountNumber());
	        
	        RegistrationResult result = new RegistrationResult(preparedStatement.executeUpdate() > 0, user.getUserID());
	        result.setUser(user);
	        
	        return result;
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
		return new RegistrationResult(false, "");
	}
	
	public static boolean usernameTaken(String username) {
		boolean taken = false;
		ResultSet user = Database.retrieve("SELECT username FROM user WHERE username='" + username + "'");
		try {
			while(user.next()) {
				taken = true;
			}
			user.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return taken;
	}
	
	public static boolean venderNameTaken(String vendorName) {
		boolean taken = false;
		ResultSet vendor = Database.retrieve("SELECT vendorName FROM vendor WHERE vendorName='" + vendorName + "'");
		try {
			while(vendor.next()) {
				taken = true;
			}
			vendor.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return taken;
	}
	
	public static ResultSet getUser(String username, String password) {
		return Database.retrieve("SELECT * FROM user WHERE username='" + username + "' AND password='" + password + "'");
	}
	
	public static ResultSet getProducts() {
		return Database.retrieve("SELECT * FROM products");
	}
}
