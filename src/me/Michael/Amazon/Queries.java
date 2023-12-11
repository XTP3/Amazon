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
	
	public static boolean tupleExists(ResultSet rs) {
		try {
			return rs.next();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean usernameTaken(String username) {
		return Queries.tupleExists(Database.retrieve("SELECT username FROM user WHERE username='" + username + "'"));
	}
	
	public static boolean vendorNameTaken(String vendorName) {
		return Queries.tupleExists(Database.retrieve("SELECT vendorName FROM vendor WHERE vendorName='" + vendorName + "'"));
	}
	
	public static boolean userCartExists(User user) {
		return Queries.tupleExists(Database.retrieve("SELECT customerID FROM cart WHERE customerID='" + user.getUserID() + "'"));
	}
	
	public static boolean productExists(String productID) {
		return Queries.tupleExists(Database.retrieve("SELECT productName FROM product WHERE productID=" + Integer.parseInt(productID)));
	}
	
	public static ResultSet getUser(String username, String password) {
		return Database.retrieve("SELECT * FROM user WHERE username='" + username + "' AND password='" + password + "'");
	}
	
	public static ResultSet getCustomer(String customerID) {
		return Database.retrieve("SELECT * FROM customer WHERE customerID='" + customerID + "'");
	}
	
	public static ResultSet getAllCustomers() {
		return Database.retrieve("SELECT * FROM customer");
	}
	
	public static ResultSet getVendor(String vendorID) {
		return Database.retrieve("SELECT * FROM vendor WHERE vendorID='" + vendorID + "'");
	}
	
	public static ResultSet getProducts() {
		return Database.retrieve("SELECT * FROM products");
	}
	
	public static ResultSet getAllProducts() {
		return Database.retrieve("SELECT * FROM product");
	}
	
	public static ResultSet getAllVendors() {
		return Database.retrieve("SELECT * FROM vendor");
	}
	
	public static ResultSet getAllOrders() {
		return Database.retrieve("SELECT * FROM orders");
	}
	
	public static ResultSet getAllSales() {
		return Database.retrieve("SELECT * FROM sales");
	}
	
	public static ResultSet getAllCarts() {
		return Database.retrieve("SELECT * FROM cart");
	}
	
	public static ResultSet getAllWishlists() {
		return Database.retrieve("SELECT * FROM wishlist");
	}
	
	public static ResultSet getAllMusic() {
		return Database.retrieve("SELECT * FROM music");
	}
	
	public static ResultSet getAllVideos() {
		return Database.retrieve("SELECT * FROM video");
	}
	
	public static ResultSet getCart(User user) {
		return Database.retrieve("SELECT cartID FROM cart WHERE customerID='" + user.getUserID() + "'");
	}
	
	public static CartCreationResult createCart(User user) {
		String query = "INSERT INTO cart (cartID, customerID) VALUES (?, ?)";
		try(PreparedStatement preparedStatement = Database.connection.prepareStatement(query)) {
			String cartID = Utils.generateUniqueID(20);
	    	preparedStatement.setString(1, cartID);
	        preparedStatement.setString(2, user.getUserID());
	        return new CartCreationResult(preparedStatement.executeUpdate() > 0, cartID);
	        
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
		return new CartCreationResult(false, "");
	}
	
	public static boolean insertIntoCartInventory(String cartID, String productID) {
		String query = "INSERT INTO cartInventory (cartID, productID) VALUES (?, ?)";
		
	    try(PreparedStatement preparedStatement = Database.connection.prepareStatement(query)) {
	    	preparedStatement.setString(1, cartID);
	        preparedStatement.setInt(2, Integer.parseInt(productID));
	        return preparedStatement.executeUpdate() > 0;
	        
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}
}
