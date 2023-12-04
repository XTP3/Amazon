package me.Michael.ActionMenus;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.function.Predicate;

import me.Michael.Amazon.InputLoop;
import me.Michael.Amazon.Menu;

public class Actions {
	private String input;
	
	public Actions(Scanner scanner, LinkedHashMap<String, String> actions, Predicate<String> inputCondition, String menuPrompt, String inputLoopPromptText, String inputLoopConditionNotMetMessage) {
		Menu.prompt(menuPrompt, actions);
		this.input = InputLoop.stringInputLoop(scanner, inputCondition, inputLoopPromptText, inputLoopConditionNotMetMessage);
	}
	
	public String getInput() {
		return this.input;
	}
}
