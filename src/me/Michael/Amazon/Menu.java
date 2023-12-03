package me.Michael.Amazon;

import java.util.Map;

public class Menu {
	public static String horizontalLine = "---------------------------------------------------";
	
	public static void prompt(String title, Map<String, String> options) {
		System.out.println(Menu.horizontalLine);
		if(title.length() > 0) System.out.println(title + "\n");
		for(Map.Entry<String,String> option : options.entrySet()) {
			System.out.println(option.getKey() + ") " + option.getValue());
		}
		//System.out.print("\nChoice: ");
	}
	
	public static void close() {
		System.out.println(Menu.horizontalLine);
	}
}
