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
		if(loggedIn) {
			if(user.getRole().equals("CUSTOMER")) {
				ResultSet customerQuery = Queries.getCustomer(this.user.getUserID());
				try  {
					if(customerQuery.next()) {
						String firstName = customerQuery.getString("firstName");
						String lastName = customerQuery.getString("lastName");
						String state = customerQuery.getString("state");
						String city = customerQuery.getString("city");
						String zipCode = customerQuery.getString("zipCode");
						String streetAddress = customerQuery.getString("streetAddress");
						String billingType = customerQuery.getString("billingType");
						long cardNumber = customerQuery.getLong("cardNumber");
						boolean primeStatus = customerQuery.getBoolean("primeStatus");
						long phoneNumber = customerQuery.getLong("phoneNumber");
						String email = customerQuery.getString("email");
						this.user.setCustomer(new me.Michael.Amazon.Customer(firstName, lastName, state, city, zipCode, streetAddress, billingType, cardNumber, primeStatus, phoneNumber, email));
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}else if(user.getRole().equals("VENDOR")) {
				ResultSet vendorQuery = Queries.getVendor(user.getUserID());
				try {
					if(vendorQuery.next()) {
						String vendorName = vendorQuery.getString("vendorName");
						long phoneNumber = vendorQuery.getLong("phoneNumber");
						String email = vendorQuery.getString("email");
						long routingNumber = vendorQuery.getLong("routingNumber");
						long accountNumber = vendorQuery.getLong("accountNumber");
						this.user.setVendor(new me.Michael.Amazon.Vendor(user.getUserID(), vendorName, phoneNumber, email, routingNumber, accountNumber));
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public User getUser() {
		return this.user;
	}
}
