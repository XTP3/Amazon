package me.Michael.ActionMenus;

import java.util.Scanner;

import me.Michael.Amazon.User;

public class ActionMenuRoleSwitch {

	public ActionMenuRoleSwitch(Scanner scanner, User user) {
		switch(user.getRole()) {
			case "CUSTOMER":
				new Customer(scanner, user);
				break;
				
			case "VENDOR":
				new Vendor(scanner, user);
				break;
				
			case "MANAGEMENT":
				new Management(scanner, user);
				break;
				
			case "ADMIN":
				new Admin(scanner, user);
				break;
				
			default: 
				new Customer(scanner, user);
				break;
		}
	}
}
