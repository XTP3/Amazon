package me.Michael.Amazon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.Michael.Amazon.Database;

public class Queries {

	public static boolean validateCredentials(String username, String password) {
		return false;
	}
	
	public static boolean registerNewUser(String[] credentials, String role) {
		String firstName = credentials[0], lastName = credentials[1], username = credentials[2], password = credentials[3];
		String query = "INSERT INTO users (firstName, lastName, username, password, role) VALUES (?, ?, ?, ?, ?)";
	    
	    // Using try-with-resources to ensure the PreparedStatement and its resources are closed
	    try (PreparedStatement preparedStatement = Database.connection.prepareStatement(query)) {
	        preparedStatement.setString(1, firstName);
	        preparedStatement.setString(2, lastName);
	        preparedStatement.setString(3, username);
	        preparedStatement.setString(4, password);
	        preparedStatement.setString(5, role.toUpperCase());

	        return preparedStatement.executeUpdate() > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}
	
	public static boolean usernameTaken(String username) {
		boolean taken = false;
		ResultSet user = Database.retrieve("SELECT username FROM users WHERE username='" + username + "'");
		try {
			while(user.next()) {
				taken = true;
			}
			user.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return taken;
	}
}
