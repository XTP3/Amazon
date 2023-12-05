package me.Michael.Actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;

import me.Michael.Amazon.InputLoop;
import me.Michael.Amazon.Menu;
import me.Michael.Amazon.Queries;
import me.Michael.Amazon.User;
import me.Michael.Utils.QueryDisplayer;
import me.Michael.Utils.Utils;

public class CustomerActions {

	public static void getAllProducts() {
		new QueryDisplayer(Queries.getAllProducts());
	}
	
	private static void addProductToCart(User user, String productID) {
		ResultSet cart = Queries.getCart(user);
		String cartID;
		try {
			if(cart.next()) {
				cartID = cart.getString("cartID");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addProductToCart(Scanner scanner, User user) {
		Predicate<String> productIDCondition = input -> Utils.isAllDigits(input);
		boolean productFound = false;
		String productID;
		Menu.horizontalLine();
		System.out.println("Add Product to Cart");
		while(!productFound) {
			productID = InputLoop.stringInputLoop(scanner, productIDCondition, "Enter the product's ID: ", "Invalid product ID!");
			if(Queries.productExists(productID)) {
				productFound = true;
			}else {
				System.out.println("Product not found!");
			}
		}
		if(Queries.userCartExists(user)) {
			// Add to cart inventory
			
			
			
		}else {
			// Create cart and add to inventory
		}
	}
	
	public static void viewPersonalWishlist() {
		
	}
	
	public static void clearPersonalWishlist() {
		
	}
	
	public static void viewCart() {
		
	}
	
	public static void clearCart() {
		
	}
	
	public static void viewOrders() {
		
	}
	
}
