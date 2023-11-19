package me.Michael.Amazon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import me.Michael.Amazon.Database;
import me.Michael.Amazon.Menu;
import me.Michael.Amazon.Credentials;
import me.Michael.Amazon.Utils;
import me.Michael.Amazon.Queries;
import me.Michael.Amazon.User;

public class Core {

	public static void main(String[] args) {
		Database.connect("jdbc:mariadb://localhost:33806/amazon", "root", "root");
		Scanner scanner = new Scanner(System.in);
		String input = "";
		HashMap<String, String> loginSignup = Utils.createPairs("1", "Login", "2", "Signup");
		do {
			Menu.prompt("Main Menu", loginSignup);
			input = scanner.nextLine();
			Menu.close();
			if(loginSignup.containsKey(input)) {
				if(input.equals("1")) {
					boolean usernameValid = false, passwordValid = false;
					do {
						HashMap<String, String> login = Credentials.login(scanner);
						if(Utils.validPassword(login.get("password"))) {
							User user = new User(1, "", "", "", "", "ROLE");
							System.out.println(user.getFormattedRole());
							passwordValid = true;
						}else {
							System.out.println("Invalid password!");
						}
					}while (!passwordValid);
					
				}else if(input.equals("2")) {
					boolean usernameValid = false, passwordValid = false;
					do {
						String[] signup = Credentials.signup(scanner);
						if(!Queries.usernameTaken(signup[2])) {
							if(Utils.validPassword(signup[3])) {
								String roleChoice;
								HashMap<String, String> roles = Utils.createPairs("1", "Customer", "2", "Vendor", "3", "Management", "4", "Admin");
								do {
									Menu.prompt("Role Selection", roles);
									roleChoice = scanner.nextLine();
									Menu.close();
								}while (!roles.containsKey(roleChoice));
								
								if(roles.containsKey(roleChoice)) {
									Utils.loading();
									boolean registrationSuccessful = Queries.registerNewUser(signup, roles.get(roleChoice).toUpperCase());
									if(registrationSuccessful) {
										System.out.println("New user " + signup[0] + " successfully created!");
									}else {
										System.out.println("New user creation failed!");
									}
									passwordValid = true;
								}
							}else {
								System.out.println("Invalid password! Must be between 8-20 characters long, contain an uppercase and lowercase character, and at least one digit.");
							}	
						}else {
							System.out.println("Username already taken!");
						}
					}while (!passwordValid);
				}
			}else {
				System.out.println("Invalid choice!");
			}
		}while (!input.equals("exit"));
		/*ResultSet query0 = database.retrieve("SELECT * FROM person");
		try {
			while(query0.next()) {
				String firstName = query0.getString("firstName");
				System.out.println("First name: " + firstName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		scanner.close();
		Database.disconnect();
	}
}
