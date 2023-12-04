package me.Michael.Utils;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.regex.Pattern;

public class Utils {

	public static boolean validPassword(String password) {
		return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,20}$"); //Upper & lower case letter, 8-20 characters long, >= 1 digit
	}
	
	public static void loading() {
		System.out.println("Loading...");
	}
	
	public static LinkedHashMap<String, String> createPairs(String... strings) {
        if(strings.length % 2 != 0) { // Provided is even
            throw new IllegalArgumentException("Odd number of strings provided. Pairs are expected.");
        }
        LinkedHashMap<String, String> pairsMap = new LinkedHashMap<>();
        for (int i = 0; i < strings.length; i += 2) {
            String key = strings[i];
            String value = strings[i + 1];
            pairsMap.put(key, value);
        }
        return pairsMap;
    }
	
	public static String generateUniqueID(int size) {
		return NanoID.randomNanoId(new Random(), NanoID.DEFAULT_ALPHABET, size);
	}
	
	public static boolean validLength(String str, int x, int y) {
		return str.length() > x && str.length() <= y;
	}
	
	public static boolean isInt(String input) {
        // Regular expression to match an integer
        String integerPattern = "^-?\\d+$"; // Matches positive and negative integers

        return Pattern.matches(integerPattern, input);
    }
	
	public static boolean isAllDigits(String input) {
        return input.matches("\\d+");
    }
}