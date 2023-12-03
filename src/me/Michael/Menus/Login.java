package me.Michael.Menus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import me.Michael.Amazon.Credentials;
import me.Michael.Amazon.Queries;
import me.Michael.Amazon.User;

public class Login {
	private User user;
	
	public Login(Scanner scanner) {
		boolean loggedIn = false;
		do {
			HashMap<String, String> login = Credentials.get(scanner, "Login", false);
			ResultSet userQuery = Queries.getUser(login.get("username"), login.get("password"));
			try {
				if(userQuery.next()) {
					String userID = userQuery.getString("userID");
					String username = userQuery.getString("username");
					String password = userQuery.getString("password");
					String role = userQuery.getString("role");
					userQuery.close();
					this.user = new User(userID, username, password, role);
					loggedIn = true;
				}else {
					System.out.println("Invalid login!");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}while (!loggedIn);
	}
	
	public User getUser() {
		return this.user;
	}
}
