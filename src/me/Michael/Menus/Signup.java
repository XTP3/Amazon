package me.Michael.Menus;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

import me.Michael.Amazon.Credentials;
import me.Michael.Amazon.InputLoop;
import me.Michael.Amazon.Menu;
import me.Michael.Amazon.Queries;
import me.Michael.Amazon.RegistrationResult;
import me.Michael.Amazon.User;
import me.Michael.Utils.Utils;

public class Signup {
	private User user;
	
	public Signup(Scanner scanner) {
		boolean usernameTaken = false;
		do {
			HashMap<String, String> signup = Credentials.get(scanner, "Signup",  true);
			if(!Queries.usernameTaken(signup.get("username"))) {
				String roleChoice;
				HashMap<String, String> roles = Utils.createPairs("1", "Customer", "2", "Vendor", "3", "Management", "4", "Admin");
				Predicate<String> roleCondition = input -> roles.containsKey(input);
				Menu.prompt("Role Selection", roles);
				roleChoice = InputLoop.stringInputLoop(scanner, roleCondition, "\nRole: ", "Invalid role!");
				Menu.close();
				RegistrationResult registration = Queries.registerNewUser(signup, roles.get(roleChoice).toUpperCase());
				if(registration.successful()) {
					System.out.println("New user " + signup.get("username") + " successfully created!");
					this.user = new User(registration.getUserID(), signup.get("username"), signup.get("password"), roles.get(roleChoice).toUpperCase());
					usernameTaken = true;
				}else {
					System.out.println("New user creation failed!");
				}
			}else {
				System.out.println("Username already taken!");
			}
		}while (!usernameTaken);
	}
	
	public User getUser() {
		return this.user;
	}
}
