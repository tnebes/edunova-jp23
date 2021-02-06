package consoleApp;

import IO.DataHandler;
import IO.UserInputHandler;

/**
 * 
 * @author tnebes
 * @date 6 February 2021
 */

public class UI {

	// Menu strings.
	static private String[] mainMenuChoices = { "Invoices", "Customers", "Addresses", "Articles", "Options", "Exit" };
	static private String[] genericManipulation = { "Show", "Add", "Change", "Delete", "Exit" };
	static private String notification = "=== Drau ElektroSoftware GmbH ===";

	// value of ints is not index but what user sees. e.g. invoices is 1 and not 0.
	static final int OPTIONS = 5;
	static final int EXIT = 6;

	public static void mainMenu() {
		System.out.printf("%s\n\n", notification);
		int userChoice;
		do {
			System.out.print("\n");
			for (int i = 0; i < mainMenuChoices.length; i++) {
				// i + 1 for proper user choice
				System.out.printf("%d - %s\n", i + 1, mainMenuChoices[i]);
			}
			System.out.print("\nChoice: ");
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
		if (previousMenu == OPTIONS) {
			// TODO temporary
			System.exit(1);
		}
		do {
			System.out.print("\n");
			for (int i = 0; i < genericManipulation.length; i++) {
				// i - 1 required for proper rendering of options.
				System.out.printf("%d - %s %s\n", i + 1, genericManipulation[i], mainMenuChoices[previousMenu - 1]);
			}
			userInput = (int) UserInputHandler.getIntegerInput(true);
			if (userInput <= 0 || userInput > genericManipulation.length) {
				System.out.printf("Input must be from 1 to %d\n", genericManipulation.length);
				continue;
			}
			// submenu choices
			switch (userInput) {
			// show
			case 1:
				// if invoices
				if (previousMenu == 1) {
					DataHandler.showInvoices();
				}
				// if customers
				else if (previousMenu == 2) {
					DataHandler.showCustomers();
				}
				// if addresses
				else if (previousMenu == 3) {
					DataHandler.showAddresses();
				}
				// if articles
				else if (previousMenu == 4) {
					DataHandler.showArticles();
				}
				break;
			// add
			case 2:
				// if invoices
				if (previousMenu == 1) {
					DataHandler.addInvoice();
				}
				// if customers
				else if (previousMenu == 2) {
					DataHandler.addCustomer();
				}
				// if addresses
				else if (previousMenu == 3) {
					DataHandler.addAddress();
				}
				// if articles
				else if (previousMenu == 4) {
					DataHandler.addArticle();
				}
				break;
			// change
			case 3:
				// if invoices
				if (previousMenu == 1) {
					DataHandler.changeInvoice();
				}
				// if customers
				else if (previousMenu == 2) {
					DataHandler.changeCustomer();
				}
				// if addresses
				else if (previousMenu == 3) {
					DataHandler.changeAddress();
				}
				// if articles
				else if (previousMenu == 4) {
					DataHandler.changeArticle();
				}
				break;
			// delete
			case 4:
				// if invoices
				if (previousMenu == 1) {
					DataHandler.deleteInvoice();
				}
				// if customers
				else if (previousMenu == 2) {
					DataHandler.deleteCustomer();
				}
				// if addresses
				else if (previousMenu == 3) {
					DataHandler.deleteAddress();
				}
				// if articles
				else if (previousMenu == 4) {
					DataHandler.deleteArticle();
				}
				break;
			case 5:
				System.out.print("\n");
				return;
			}
		} while (true);
		// options menu
	}
}
