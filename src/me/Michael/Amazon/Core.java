package me.Michael.Amazon;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

import me.Michael.ActionMenus.ActionMenuRoleSwitch;
import me.Michael.Amazon.Database;
import me.Michael.Amazon.Menu;
import me.Michael.Menus.Login;
import me.Michael.Menus.MenuRoleSwitch;
import me.Michael.Menus.Signup;
import me.Michael.Utils.Utils;

public class Core {
	public static void main(String[] args) {
		Database.connect("jdbc:mariadb://localhost:33806/amazon", "root", "root");
		Scanner scanner = new Scanner(System.in);
		HashMap<String, String> loginSignup = Utils.createPairs("1", "Login", "2", "Signup");
		Menu.prompt("Main Menu", loginSignup);
		Predicate<String> condition = input -> loginSignup.containsKey(input) || input.toLowerCase().equals("exit");
		String input = InputLoop.stringInputLoop(scanner, condition, "\nChoice: ", "Invalid choice!");
		if(input.equals("1")) {
			Login login = new Login(scanner);
			System.out.println(login.getUser().getUserID() + " " + login.getUser().getUsername() + " " + login.getUser().getPassword() + " " + login.getUser().getRole());
			new ActionMenuRoleSwitch(scanner, login.getUser());
			
		}else if(input.equals("2")) {
			Signup signup = new Signup(scanner);
			RegistrationResult customerRegistration = new MenuRoleSwitch(scanner, signup.getUser()).getRegistrationResult();
			if(customerRegistration.successful()) {
				new ActionMenuRoleSwitch(scanner, signup.getUser());
			}else {
				System.out.println("Customer registration failed!");
			}
			
		}else if(input.toLowerCase().equals("exit")) {
			System.out.println("Goodbye!");
		}
		scanner.close();
		Database.disconnect();
	}
}