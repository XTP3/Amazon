package me.Michael.Menus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import me.Michael.Amazon.InputLoop;
import me.Michael.Amazon.Menu;
import me.Michael.Amazon.Queries;
import me.Michael.Amazon.User;

public class Customer {
	private User user;
	
	private boolean validLength(String str, int x, int y) {
		return str.length() > x && str.length() <= y;
	}
	
	private boolean isInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	private boolean getPrimeStatusAsBoolean(String primeStatus) {
		if(primeStatus.toLowerCase().equals("y")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String formatBillingType(String input) {
        String[] exceptions = {"AMERICAN EXPRESS"};
        
        // Check if the input matches any exception
        for(String exception : exceptions) {
            if (input.equalsIgnoreCase(exception)) {
                return exception.substring(0, 1) + exception.substring(1).toLowerCase();
            }
        }
        
        // Split the input into words
        String[] words = input.toLowerCase().split(" ");
        StringBuilder capitalized = new StringBuilder();
        
        for(String word : words) {
            if(word.length() > 1) {
                capitalized.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }else {
                capitalized.append(Character.toUpperCase(word.charAt(0))).append(" ");
            }
        }
        
        return capitalized.toString().trim();
    }
	
	public Customer(Scanner scanner, User user) {
		this.user = user;
		List<String> billingTypes = new ArrayList<>(Arrays.asList("DISCOVER", "MASTERCARD", "VISA", "AMERICAN EXPRESS"));
		Predicate<String> nameCondition = input -> validLength(input, 0, 25);
		Predicate<String> stateCondition = input -> input.length() == 2;
		Predicate<String> cityCondition = input -> validLength(input, 0, 25);
		Predicate<String> zipCodeCondition = input -> validLength(input, 3, 6);
		Predicate<String> streetAddressCondition = input -> validLength(input, 0, 50);
		Predicate<String> billingTypeCondition = input -> billingTypes.contains(input.toUpperCase());
		Predicate<String> cardNumberCondition = input -> isInt(input) && input.length() == 16;
		Predicate<String> primeStatusCondition = input -> input.toLowerCase().equals("y") || input.toLowerCase().equals("n");
		Predicate<String> phoneNumberCondition = input -> isInt(input) && input.length() == 10;
		Predicate<String> emailCondition = input -> validLength(input, 0, 30);
		Menu.close();
		System.out.println("Customer Details\n");
		String firstName = InputLoop.stringInputLoop(scanner, nameCondition, "First Name: ", "Invalid first name! Must be between 1-25 characters long.");
		String lastName = InputLoop.stringInputLoop(scanner, nameCondition, "Last Name: ", "Invalid last name! Must be between 1-25 characters long.");
		String state = InputLoop.stringInputLoop(scanner, stateCondition, "State (initials): ", "Invalid state! Must be the states initials (2 characters).");
		String city = InputLoop.stringInputLoop(scanner, cityCondition, "City: ", "Invalid city! Must be between 1-25 characters long.");
		String zipCode = InputLoop.stringInputLoop(scanner, zipCodeCondition, "Zip Code: ", "Invalid zip code! Must be between ");
		String streetAddress = InputLoop.stringInputLoop(scanner, streetAddressCondition, "Address: ", "Invalid address! Must be between 1-50 characters.");
		String billingType = InputLoop.stringInputLoop(scanner, billingTypeCondition, "Billing Type: ", "Invalid billing type! Must be Discover, MasterCard, Visa, or American Express.");
		String cardNumber = InputLoop.stringInputLoop(scanner, cardNumberCondition, "Card Number: ", "Invalid card number! Must be 16 digits long.");
		String primeStatus = InputLoop.stringInputLoop(scanner, primeStatusCondition, "Sign up for Prime? (y/n): ", "Invalid input! Must be 'Y' or 'N'.");
		String phoneNumber = InputLoop.stringInputLoop(scanner, phoneNumberCondition, "Phone Number: ", "Invalid phone number! Must be 10 digits long.");
		String email = InputLoop.stringInputLoop(scanner, emailCondition, "Email: ", "Invalid email! Must be between 1-30 characters long.");
		this.user.setCustomerDetails(firstName, lastName, state, city, zipCode, streetAddress, formatBillingType(billingType), Integer.parseInt(cardNumber), getPrimeStatusAsBoolean(primeStatus), Integer.parseInt(phoneNumber), email);
		Queries.registerNewCustomer(this.user);
	}
	
	public User getUser() {
		return this.user;
	}
}
