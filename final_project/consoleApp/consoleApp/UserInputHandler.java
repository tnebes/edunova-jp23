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
	 * Returns a long. Depending on isRequired, will demand that any number is returned.
	 * @param isRequired
	 * @return long
	 */
	static public long getIntegerInput(boolean isRequired) {
		while (true) {
			String userInput = input.nextLine();
			if (!isRequired) {
				if (userInput.isEmpty()) {
					return 0;
				} else {
					try {
						return Long.valueOf(userInput);
					} catch (NumberFormatException e) {
						System.out.print("A number must be entered.\n");
					}
				}

			}
		}
	}

}
