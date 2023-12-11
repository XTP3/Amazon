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
				"2", "Add Product to Cart",
				"3", "View Cart", 
				"4", "Clear Cart", 
				"5", "Checkout",
				"6", "View Wishlist", 
				"7", "Clear Wishlist", 
				"8", "View Orders",  
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
					
				case "2":
					CustomerActions.addProductToCart(scanner, user);
					break;
					
				case "9":
					CustomerActions.getPersonalInfo(user);
					break;
					
				case "L":
					System.out.println("Goodbye!");
					prompt = false;
					break;
			}
		}
	}
}
