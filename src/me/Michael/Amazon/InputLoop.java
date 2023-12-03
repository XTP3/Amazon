package me.Michael.Amazon;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class InputLoop {
    public static String stringInputLoop(Scanner scanner, Predicate<String> condition, String promptText, String conditionNotMetMessage) {
        String userInput;

        // Continue looping until the condition is met
        while (true) {
            System.out.print(promptText);
            userInput = scanner.nextLine();

            if(condition.test(userInput)) {
                break; // Exit the loop when the condition is met
            }

            if(conditionNotMetMessage.length() > 0) System.out.println(conditionNotMetMessage);
        }
        return userInput;
    }
    
    public static int intInputLoop(Scanner scanner, IntPredicate condition) {
        int userInput;

        // Continue looping until the condition is met
        while (true) {
            System.out.print("Enter a value: ");
            userInput = scanner.nextInt();

            if(condition.test(userInput)) {
                break; // Exit the loop when the condition is met
            }

            System.out.println("Condition not met. Try again.");
        }

        scanner.close();
        return userInput;
    }
}