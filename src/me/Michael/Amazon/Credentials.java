package me.Michael.Amazon;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

import me.Michael.Utils.Utils;

public class Credentials {
	public static HashMap<String, String> get(Scanner scanner, String title, boolean passwordKey) {
		String username, password, pwdKey = "";
		if(passwordKey) pwdKey = " (8-20 characters, upper & lowercase character, at least one digit)";
		HashMap<String, String> credentials = new HashMap<>();
		System.out.println(Menu.horizontalLine);
		System.out.println(title + "\n");
		Predicate<String> usernameCondition = input -> input.length() > 0 && input.length() <= 50;
		Predicate<String> passwordCondition = input -> Utils.validPassword(input);
		username = InputLoop.stringInputLoop(scanner, usernameCondition, "Username: ", "Invalid username!");
		password = InputLoop.stringInputLoop(scanner, passwordCondition, "Password: ", "Invalid password! Must be between 8-20 characters long, contain an uppercase and lowercase character, and at least one digit.");
		System.out.println(Menu.horizontalLine);
		credentials.put("username", username);
		credentials.put("password", password);
		return credentials;
	}
	
	public static String[] signup(Scanner scanner) {
		String username, password;
		System.out.println(Menu.horizontalLine);
		System.out.println("Signup\n");
		System.out.print("Username: ");
		username = scanner.nextLine();
		System.out.print("Password: ");
		password = scanner.nextLine();
		System.out.println(Menu.horizontalLine);
		return new String[] {username, password};
	}
}
