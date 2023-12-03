package me.Michael.Amazon;

import java.util.HashMap;
import java.util.Scanner;

import me.Michael.Amazon.Menu;
import me.Michael.Amazon.Queries;
import me.Michael.Amazon.User;
import me.Michael.Utils.Utils;

public class Menus {
	
	public static boolean customer(Scanner scanner, User user) {
		String choice = "";
		do {
			HashMap<String, String> choices = Utils.createPairs("1", "View Products", "2", "View Personal Wishlist", "3", "View Cart", "4", "View Orders", "5", "View Order History", "6", "View Personal Info");
			HashMap<String, String> varName = Utils.createPairs("1", "Retrieving products...");
			HashMap<String, String> primeChoices = Utils.createPairs("7", "View Music", "8", "View Videos", "9", "View Saved Music", "10", "View Saved Videos");
			Menu.prompt("Customer", choices);
			choice = scanner.nextLine();
			Menu.close();
			if(choices.containsKey(choice)) {
				switch(choice) {
					case "1":
						Menu.close();
						System.out.println("Retrieving products...");
						break;
					
					case "exit":
						return true;
					default:
						
				}
			}
		}while (!choice.equals("exit"));

		return false;
	}
	
	public static void vendor() {
		
	}
	
	public static void management() {
		
	}
	
	public static void admin() {
		
	}
}
