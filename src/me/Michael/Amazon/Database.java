package me.Michael.Amazon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	public static Connection connection = null;
	
	public static void connect(String url, String username, String password) {
		try {
			Database.connection = DriverManager.getConnection(url, username, password);
            //System.out.println("Connected to database!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void disconnect() {
		try {
			Database.connection.close();
			//System.out.println("Disconnected from database!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet retrieve(String query) {
		try {
			PreparedStatement preparedStatement = Database.connection.prepareStatement(query);
			return preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int executeUpdate(String query) {
        try {
            PreparedStatement preparedStatement = Database.connection.prepareStatement(query);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Error occurred
    }
}
