package me.Michael.ActionMenus;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.function.Predicate;

import me.Michael.Actions.CustomerActions;
import me.Michael.Amazon.User;
import me.Michael.Utils.Utils;

public class Customer {

	public Customer(Scanner scanner, User user) {
		LinkedHashMap<String, String> customerActions = Utils.createPairs(
				"1", "View All Products",
				"2", "Purchase Product",
				"3", "View Personal Wishlist", 
				"4", "Clear Personal Wishlist", 
				"5", "View Cart", 
				"6", "Clear Cart", 
				"7", "View Orders", 
				"8", "View Order History", 
				"9", "View Personal Info", 
				"L", "Logout"
		);
		Predicate<String> customerActionCondition = input -> customerActions.containsKey(input);
		boolean prompt = true;
		while(prompt) {
			Actions actions = new Actions(scanner, customerActions, customerActionCondition, "Customer", "\nAction: ", "Invalid action!");
			switch(actions.getInput()) {
				case "1":
					CustomerActions.getAllProducts();
					break;
					
				case "L":
					System.out.println("Goodbye!");
					prompt = false;
					break;
			}
		}
	}
}
