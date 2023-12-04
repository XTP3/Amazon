package me.Michael.ActionMenus;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.function.Predicate;

import me.Michael.Actions.ManagementActions;
import me.Michael.Amazon.User;
import me.Michael.Utils.Utils;

public class Management {

	public Management(Scanner scanner, User user) {
		LinkedHashMap<String, String> customerActions = Utils.createPairs(
				"1", "View All Products", 
				"2", "View All Customers", 
				"3", "View All Vendors", 
				"4", "View All Orders", 
				"5", "View All Sales", 
				"6", "View All Carts", 
				"7", "View All Wishlists",
				"8", "View All Music",
				"9", "View All Videos",
				"L", "Logout"
		);
		Predicate<String> customerActionCondition = input -> customerActions.containsKey(input);
		boolean prompt = true;
		while(prompt) {
			Actions actions = new Actions(scanner, customerActions, customerActionCondition, "Management", "\nAction: ", "Invalid action!");
			switch(actions.getInput()) {
				case "1":
					ManagementActions.getAllProducts();
					break;
					
				case "2":
					ManagementActions.getAllCustomers();
					break;
					
				case "3":
					ManagementActions.getAllVendors();
					break;
					
				case "4":
					ManagementActions.getAllOrders();
					break;
					
				case "5":
					ManagementActions.getAllSales();
					break;
					
				case "6":
					ManagementActions.getAllCarts();
					break;
					
				case "7":
					ManagementActions.getAllWishlists();
					break;
					
				case "8":
					ManagementActions.getAllMusic();
					break;
					
				case "9":
					ManagementActions.getAllVideos();
					break;
					
				case "L":
					System.out.println("Goodbye!");
					prompt = false;
					break;
			}
		}
	}
}
