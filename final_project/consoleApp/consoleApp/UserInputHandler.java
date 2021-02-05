package consoleApp;

import java.util.Scanner;

public class UserInputHandler {
	
	static Scanner input = new Scanner(System.in);
	
	/**
	 * Returns a string. Depending on isRequired, will demand that a not-empty string is returned.
	 * @param isRequired
	 * @return String
	 */
	static public String getStringInput(boolean isRequired) {
		while (true) {
			if (!isRequired) {
				return input.nextLine().trim();
			} else {
				String userInput;
				do {
					userInput = input.nextLine().trim();
					if (userInput.isEmpty()) {
						System.out.print("Some data is required.\n");
					}
				} while (userInput.isEmpty());
				return userInput;
			}
		}
	}
	
	/**
	 * Returns a long. Depending on isRequired, will demand that any number is returned. Returns null 
	 * @param isRequired
	 * @return long
	 */
	static public long getIntegerInput(boolean isRequired) {
		String userInput;
		Long returnValue;
		while (true) {
			userInput = input.nextLine();
			if (!isRequired && userInput.isEmpty()) {
				return 0;
			}
			try {
				returnValue = Long.valueOf(userInput.trim());
				break;
			} catch (NumberFormatException e) {
				System.out.print("A number must be entered.\n");
				continue;
			}
		}
		return returnValue;
	}

	/**
	 * Methods returns true for 1 and false for 2
	 * @param message
	 * @return boolean
	 */
	public static boolean oneOrTwoDialogue(String message) {
		System.out.print(message);
		return Integer.valueOf(input.nextLine()) == 1 ? true : false;
	}

	public static boolean yesNoDialogue(String message) {
		System.out.print(message);
		return input.nextLine().toLowerCase().equals("y");
	}
	
	/**
	 * Returns true if the input can be parsed as a long.
	 * @param input
	 * @return
	 */
	public static boolean isLongInput(String input) {
		try {
			Long.valueOf(input.trim());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
