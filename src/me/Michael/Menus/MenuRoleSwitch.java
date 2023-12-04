package me.Michael.Menus;

import java.util.Scanner;

import me.Michael.Amazon.RegistrationResult;
import me.Michael.Amazon.User;

public class MenuRoleSwitch {
	private RegistrationResult registrationResult;
	
	public MenuRoleSwitch(Scanner scanner, User user) {
		switch(user.getRole()) {
			case "CUSTOMER":
				this.registrationResult = new Customer(scanner, user).getRegistrationResult();
				break;
				
			case "VENDOR":
				this.registrationResult = new Vendor(scanner, user).getRegistrationResult();
				break;
				
			default:
				System.out.println("DEFAULT MENU ROLE SWITCH");
				this.registrationResult = new RegistrationResult(true, user.getUserID());
				break;
		}
	}

	public RegistrationResult getRegistrationResult() {
		return this.registrationResult;
	}
	
}
