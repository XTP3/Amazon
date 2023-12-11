package me.Michael.Actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;

import me.Michael.Amazon.CartCreationResult;
import me.Michael.Amazon.InputLoop;
import me.Michael.Amazon.Menu;
import me.Michael.Amazon.Queries;
import me.Michael.Amazon.User;
import me.Michael.Utils.QueryDisplayer;
import me.Michael.Utils.UserDataFormatter;
import me.Michael.Utils.Utils;

public class CustomerActions {

	public static void getAllProducts() {
		new QueryDisplayer(Queries.getAllProducts());
	}
	
	/*private static void addProductToCart(User user, String productID) {
		ResultSet cart = Queries.getCart(user);
		String cartID;
		try {
			if(cart.next()) {
				cartID = cart.getString("cartID");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	public static void addProductToCart(Scanner scanner, User user) {
		Predicate<String> productIDCondition = input -> Utils.isAllDigits(input);
		boolean productFound = false;
		String productID = "";
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
			ResultSet usersCart = Queries.getCart(user);
			String cartID = "";
			try {
				while(usersCart.next()) {
					cartID = usersCart.getString("cartID");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			boolean insertSuccessful = Queries.insertIntoCartInventory(cartID, productID);
			if(insertSuccessful) {
				System.out.println("Item added to cart!");
			}else {
				System.out.println("Couldn't add item to cart!");
			}
			
		}else {
			// Create cart and add to inventory
			CartCreationResult cart = Queries.createCart(user);
			if(cart.successful()) {
				boolean insertSuccessful = Queries.insertIntoCartInventory(cart.getCartID(), productID);
				if(insertSuccessful) {
					System.out.println("Item added to cart!");
				}else {
					System.out.println("Couldn't add item to cart!");
				}
			}
		}
	}
	
	public static void viewPersonalWishlist() {
		
	}
	
	public static void clearPersonalWishlist() {
		
	}
	
	public static void viewCart(User user) {
		new QueryDisplayer(Queries.getCartInventory(user));
	}
	
	public static void clearCart(User user) {
		boolean cartCleared = Queries.clearCartInventory(user);
		if(cartCleared) {
			System.out.println("Cart cleared!");
		}else {
			System.out.println("Couldn't clear cart!");
		}
	}
	
	public static void viewOrders() {
		
	}
	
	public static void getPersonalInfo(User user) {
		Menu.horizontalLine();
		System.out.println(UserDataFormatter.displayUserData(user));
		Menu.horizontalLine();
	}	
}
