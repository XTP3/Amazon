package me.Michael.Amazon;

import java.util.HashMap;
import java.util.Scanner;

import me.Michael.Amazon.Menu;

public class Menus {
	public static HashMap<String, String> getCredentials(String title) {
		String username, password;
		HashMap<String, String> credentials = new HashMap<>();
		Menu menu = new Menu();
		Scanner scanner = new Scanner(System.in);
		System.out.println(menu.horizontalLine);
		System.out.println(title + "\n");
		System.out.print("Username: ");
		username = scanner.nextLine();
		System.out.print("Password: ");
		password = scanner.nextLine();
		System.out.println(menu.horizontalLine);
		credentials.put("username", username);
		credentials.put("password", password);
		return credentials;
	}
}
