package consoleApp;

public class UI {
	
	// Menu strings.
	static private String[] mainMenuChoices = {"Invoices", "Customers", "Addresses", "Articles", "Options", "Exit"};
	static private String[] genericManipulation = {"Add", "Change", "Delete", "Exit"};
	static private String notification = "=== Drau ElektroSoftware GmbH ===";
	
	// value of ints is not index but what user sees. e.g. invoices is 1 and not 0.
	static final int OPTIONS = 5;
	static final int EXIT = 6;
	
	public static void mainMenu() {
		System.out.printf("%s\n\n", notification);
		for (int i = 0; i < mainMenuChoices.length; i++) {
			// i + 1 for proper user choice
			System.out.printf("%d - %s\n", i + 1, mainMenuChoices[i]);
		}
		System.out.print("\nChoice: ");
		int userChoice;
		do {
			userChoice = (int) UserInputHandler.getIntegerInput(true);
			// should the user enter rubbish
			if (userChoice <= 0 || userChoice > mainMenuChoices.length) {
				System.out.printf("Input must be from 1 to %d\n", mainMenuChoices.length);
				continue;
			}
			// proceed
			if (userChoice != mainMenuChoices.length) {
				subMenu(userChoice);
			}
			// exit
			else {
				System.out.printf("\n\n%s\n", notification);
				System.exit(0);
			}
		} while (true);

	}

	private static void subMenu(int previousMenu) {
		int userInput;
		// options will have a different menu
		if (previousMenu != OPTIONS) {
			for (int i = 0; i < genericManipulation.length; i++) {
				//i - 1 required for proper rendering of options.
				System.out.printf("%d - %s %s\n", i + 1, genericManipulation[i], mainMenuChoices[previousMenu - 1]);
			}
			do {
				userInput = (int) UserInputHandler.getIntegerInput(true);
				if (userInput <= 0 || userInput > genericManipulation.length) {
					System.out.printf("Input must be from 1 to %d\n", genericManipulation.length);
					continue;
				}
				switch(userInput) {
					// TODO
				}
			} while (true);
			
			
		}
		// options menu
		else {
			
		}
		
	}
	
}
