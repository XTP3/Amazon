package me.Michael.Utils;

import me.Michael.Amazon.Customer;
import me.Michael.Amazon.User;

public class UserDataFormatter {

	public static String displayUserData(User user) {
        StringBuilder userData = new StringBuilder();
        
        userData.append("User Information:\n");
        userData.append("User ID: ").append(user.getUserID()).append("\n");
        userData.append("Username: ").append(user.getUsername()).append("\n");
        userData.append("Role: ").append(user.getFormattedRole()).append("\n");

        if(user.getRole().equalsIgnoreCase("customer")) {
            Customer customer = user.getCustomer();
            if(customer != null) {
                userData.append("\nCustomer Information:\n");
                userData.append("First Name: ").append(customer.getFirstName()).append("\n");
                userData.append("Last Name: ").append(customer.getLastName()).append("\n");
                userData.append("State: ").append(customer.getState()).append("\n");
                userData.append("City: ").append(customer.getCity()).append("\n");
                userData.append("Zip Code: ").append(customer.getZipCode()).append("\n");
                userData.append("Street Address: ").append(customer.getStreetAddress()).append("\n");
                userData.append("Billing Type: ").append(customer.getBillingType()).append("\n");
                userData.append("Card Number: ").append(customer.getCardNumber()).append("\n");
                userData.append("Phone Number: ").append(customer.getPhoneNumber()).append("\n");
                userData.append("Email: ").append(customer.getEmail()).append("\n");
                userData.append("Prime Status: ").append(customer.getPrimeStatus());
            }
        }
        return userData.toString();
    }
}