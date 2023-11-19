package me.Michael.Amazon;

import java.util.HashMap;

public class Utils {

	public static boolean validPassword(String password) {
		return password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,20}$"); //Upper & lower case letter, 8-20 characters long, >= 1 digit
	}
	
	public static void loading() {
		System.out.println("Loading...");
	}
	
	public static HashMap<String, String> createPairs(String... strings) {
        if(strings.length % 2 != 0) { // Provided is even
            throw new IllegalArgumentException("Odd number of strings provided. Pairs are expected.");
        }
        HashMap<String, String> pairsMap = new HashMap<>();
        for (int i = 0; i < strings.length; i += 2) {
            String key = strings[i];
            String value = strings[i + 1];
            pairsMap.put(key, value);
        }
        return pairsMap;
    }
}
