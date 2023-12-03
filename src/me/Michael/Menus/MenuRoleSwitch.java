package me.Michael.Menus;

import java.util.Scanner;

import me.Michael.Menus.Customer;
import me.Michael.Menus.Vendor;
import me.Michael.Amazon.User;

public class MenuRoleSwitch {

	public MenuRoleSwitch(Scanner scanner, User user) {
		switch(user.getRole()) {
			case "CUSTOMER":
				new Customer(scanner, user);
				break;
				
			case "VENDOR":
				new Vendor(scanner, user);
				break;
				
			default: 
				new Customer(scanner, user);
				break;
		}
	}

}
