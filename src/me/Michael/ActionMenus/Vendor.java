package me.Michael.ActionMenus;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.function.Predicate;

import me.Michael.Amazon.User;
import me.Michael.Utils.Utils;

public class Vendor {

	public Vendor(Scanner scanner, User user) {
		LinkedHashMap<String, String> vendorActions = Utils.createPairs(
				"1", "Create new Product",
				"2", "View Customers", 
				"3", "View Products",
				"4", "View Sale History", 
				"5", "View Orders", 
				"6", "View Personal Info", 
				"L", "Logout"
		);
		Predicate<String> customerActionCondition = input -> vendorActions.containsKey(input);
		Actions actions = new Actions(scanner, vendorActions, customerActionCondition, "Vendor", "\nAction: ", "Invalid action!");
		switch(actions.getInput()) {
			case "1":
				System.out.println("Retrieving customers...");
		}
	}
}
