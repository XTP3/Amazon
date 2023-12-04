package me.Michael.ActionMenus;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.function.Predicate;

import me.Michael.Amazon.User;
import me.Michael.Utils.Utils;

public class Customer {

	public Customer(Scanner scanner, User user) {
		LinkedHashMap<String, String> customerActions = Utils.createPairs(
				"1", "View Products", 
				"2", "View Personal Wishlist", 
				"3", "Clear Personal Wishlist", 
				"5", "View Cart", 
				"6", "Clear Cart", 
				"7", "View Orders", 
				"8", "View Order History", 
				"9", "View Personal Info", 
				"L", "Logout"
		);
		Predicate<String> customerActionCondition = input -> customerActions.containsKey(input);
		Actions actions = new Actions(scanner, customerActions, customerActionCondition, "Customer", "\nAction: ", "Invalid action!");
		switch(actions.getInput()) {
			case "1":
				System.out.println("Retrieving products...");
		}
	}
}
