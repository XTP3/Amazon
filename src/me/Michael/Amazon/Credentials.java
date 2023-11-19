package me.Michael.Amazon;

import java.util.HashMap;
import java.util.Scanner;

public class Credentials {
	public static HashMap<String, String> login(Scanner scanner) {
		String username, password;
		HashMap<String, String> credentials = new HashMap<>();
		System.out.println(Menu.horizontalLine);
		System.out.println("Login\n");
		System.out.print("Username: ");
		username = scanner.nextLine();
		System.out.print("Password: ");
		password = scanner.nextLine();
		System.out.println(Menu.horizontalLine);
		credentials.put("username", username);
		credentials.put("password", password);
		return credentials;
	}
	
	public static String[] signup(Scanner scanner) {
		String firstName, lastName, username, password;
		System.out.println(Menu.horizontalLine);
		System.out.println("Signup\n");
		System.out.print("First name: ");
		firstName = scanner.nextLine();
		System.out.print("Last name: ");
		lastName = scanner.nextLine();
		System.out.print("Username: ");
		username = scanner.nextLine();
		System.out.print("Password (8-20 characters, upper & lowercase character): ");
		password = scanner.nextLine();
		System.out.println(Menu.horizontalLine);
		return new String[] {firstName, lastName, username, password};
	}
}
