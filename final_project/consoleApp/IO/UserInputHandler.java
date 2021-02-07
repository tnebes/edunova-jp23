package IO;

import java.util.Scanner;

/**
 * 
 * @author tnebes
 * @date 6 February 2021
 */

public class UserInputHandler {
	
	static Scanner input = new Scanner(System.in);
	
	/**
	 * Returns a string. Depending on isRequired, will demand that a not-empty string is returned. Returns String
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
					if (userInput.isBlank()) {
						System.out.print("Some data is required.\n");
					}
				} while (userInput.isBlank());
				return userInput;
			}
		}
	}
	
	/**
	 * Returns a long. Depending on isRequired, will demand that any number is returned. Returns long. 
	 * @param isRequired
	 * @return long
	 */
	static public long getIntegerInput(boolean isRequired) {
		String userInput;
		Long returnValue;
		while (true) {
			userInput = input.nextLine();
			if (!isRequired && userInput.isBlank()) {
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
	 * Returns a double. Depending on isRequired, will demand that any number is returned. Returns double.
	 * @param isRequired
	 * @return
	 */
	static public double getDoubleInput(boolean isRequired) {
		String userInput;
		Double returnValue;
		while (true) {
			userInput = input.nextLine();
			if (!isRequired && userInput.isBlank()) {
				return 0.0;
			}
			try {
				returnValue = Double.valueOf(userInput.trim());
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
		while (true) {
			try {
				return Integer.valueOf(input.nextLine()) == 1 ? true : false;
			} catch (NumberFormatException e) {
				System.out.print("Please enter 1 or 2: ");
			}
		}

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
