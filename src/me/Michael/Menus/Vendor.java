package me.Michael.Menus;

import java.util.Scanner;
import java.util.function.Predicate;

import me.Michael.Amazon.InputLoop;
import me.Michael.Amazon.Menu;
import me.Michael.Amazon.Queries;
import me.Michael.Amazon.RegistrationResult;
import me.Michael.Amazon.User;
import me.Michael.Utils.Utils;

public class Vendor {
	private User user;
	private RegistrationResult registration;
	
	public Vendor(Scanner scanner, User user) {
		this.user = user;
		Predicate<String> vendorNameCondition = input -> Utils.validLength(input, 0, 25);
		Predicate<String> phoneNumberCondition = input -> Utils.isAllDigits(input) && input.length() == 10;
		Predicate<String> emailCondition = input -> Utils.validLength(input, 0, 255);
		Predicate<String> routingNumberCondition = input -> Utils.isAllDigits(input) && Utils.validLength(input, 0, 50);
		Predicate<String> accountNumberCondition = input -> Utils.isAllDigits(input) && Utils.validLength(input, 0, 50);
		Menu.horizontalLine();
		System.out.println("Customer Details\n");
		String vendorName = InputLoop.stringInputLoop(scanner, vendorNameCondition, "Vendor Name: ", "Invalid vendor name! Must be between 1-25 characters long.");
		String phoneNumber = InputLoop.stringInputLoop(scanner, phoneNumberCondition, "Phone Number: ", "Invalid phone number! Must be 10 digits long.");
		String email = InputLoop.stringInputLoop(scanner, emailCondition, "Email: ", "Invalid email! Must be between 1-255 characters long.");
		String routingNumber = InputLoop.stringInputLoop(scanner, routingNumberCondition, "Routing Number: ", "Invalid routing number! Must be between 1-50 digits.");
		String accountNumber = InputLoop.stringInputLoop(scanner, accountNumberCondition, "Account Number: ", "Invalid account number! Must be between 1-50 digits.");
		this.user.setVendor(new me.Michael.Amazon.Vendor(user.getUserID(), vendorName, Long.parseLong(phoneNumber), email, Long.parseLong(routingNumber), Long.parseLong(accountNumber)));
		this.registration = Queries.registerNewVendor(user);
	}
	
	public User getUser() {
		return this.user;
	}
	
	public RegistrationResult getRegistrationResult() {
		return this.registration;
	}
}
