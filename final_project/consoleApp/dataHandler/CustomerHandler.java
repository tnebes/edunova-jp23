package dataHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import IO.IDCounter;
import IO.UserInputHandler;
import consoleApp.DataClasses.Customer;

public class CustomerHandler {

	public static void addCustomer() {
		Controller.addMessage();
		Customer newCustomer = new Customer();
		assignIDCustomer(newCustomer);
		newCustomer.setDateOfCreation(new Date());
		newCustomer.setType(UserInputHandler.oneOrTwoDialogue("1 - natural person\n2 - legal person: "));
		if (newCustomer.isType() == Customer.NATURAL_PERSON) {
			addCustomerNaturalPerson(newCustomer);
		} else {
			addCustomerLegalPerson(newCustomer);
		}
		customerSetAddress(newCustomer);
		Controller.customers.add(newCustomer);
		System.out.print("Successfully added customer ");
		showCustomer(getLastCustomer());
		try {
			IO.DataIO.writeDataCustomersFile(Controller.customers);
		} catch (IOException e) {
			System.out.print("Unable to write customers to file.\n");
			e.printStackTrace();
			System.exit(1);
		}
	}

	static void addCustomerNaturalPerson(Customer naturalPersonCustomer) {
		System.out.print("* First name: ");
		naturalPersonCustomer.setFirstName(UserInputHandler.getStringInput(true));
		System.out.print("Middle name: ");
		naturalPersonCustomer.setMiddleName(UserInputHandler.getStringInput(false));
		System.out.print("* Last name: ");
		naturalPersonCustomer.setLastName(UserInputHandler.getStringInput(true));
		System.out.print("National ID number: ");
		naturalPersonCustomer.setNationalIdNumber(UserInputHandler.getStringInput(false));
	}

	static void addCustomerLegalPerson(Customer legalPersonCustomer) {
		System.out.print("* Name: ");
		legalPersonCustomer.setName(UserInputHandler.getStringInput(true));
		System.out.print("* VATID");
		legalPersonCustomer.setVATID(UserInputHandler.getStringInput(true));
	}

	static void assignIDCustomer(Customer customer) {
		// System.out.print("Enter unique ID for customer. Leave blank for automatic
		// generation: ");
		// long userInput = UserInputHandler.getIntegerInput(false);
		// if (userInput == 0) {
		// customer.setId(IDCounter.getCustomerCounter());
		// } else {
		// userInput = enterId((byte) 1, userInput);
		// customer.setId(userInput);
		// }
		customer.setId(IDCounter.getCustomerCounter());
	}

	static void customerSetAddress(Customer customer) {
		AddressHandler.addBillingAddress();
		customer.setBillingAddressId(AddressHandler.getLastAddress().getId());
		if (UserInputHandler.yesNoDialogue("Customer requires separate shipping address? y/n")) {
			AddressHandler.addShippingAddress();
			customer.setShippingAddressId(AddressHandler.getLastAddress().getId());
		}
	}

	static boolean customerIdIsUnique(long id) {
		for (Customer customer : Controller.customers) {
			if (customer.getId() == id) {
				return false;
			}
		}
		return true;
	}

	static Customer getCustomer(long id) {
		for (Customer customer : Controller.customers) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		System.out.printf("Customer with id %d not found!\n", id);
		return null;
	}

	static ArrayList<Customer> getCustomer(String token) {
		ArrayList<Customer> suspectCustomers = new ArrayList<>();
		for (Customer customer : Controller.customers) {
			if (customer.getFirstName().toLowerCase().contains(token.toLowerCase())) {
				suspectCustomers.add(customer);
				continue;
			} else if (customer.getMiddleName().toLowerCase().contains(token.toLowerCase())) {
				suspectCustomers.add(customer);
				continue;
			} else if (customer.getLastName().toLowerCase().contains(token.toLowerCase())) {
				suspectCustomers.add(customer);
				continue;
			}
		}
		return suspectCustomers;
	}

	static void showCustomer(Customer customer) {
		StringBuilder sb = new StringBuilder();
		if (customer.isType() == Customer.NATURAL_PERSON) {
			sb.append(customer.getId()).append(" ");
			sb.append(customer.getNationalIdNumber()).append(" ");
			sb.append(customer.getFirstName()).append(" ");
			if (!customer.getMiddleName().isBlank()) {
				sb.append(customer.getMiddleName()).append(" ");
			}
			sb.append(customer.getLastName()).append(" ");
			System.out.print(sb.toString());
		} else {
			sb.append(customer.getId()).append(" ");
			sb.append(customer.getName()).append(" ");
			sb.append(customer.getVATID());
			System.out.print(sb.toString());
		}
	}

	public static void showCustomers() {
		if (Controller.customers.size() == 0) {
			System.out.print("No customers in the database.\n");
			return;
		}
		for (Customer customer : Controller.customers) {
			showCustomer(customer);
			System.out.print("\n");
		}
	}

	public static Customer getLastCustomer() {
		return Controller.customers.get(Controller.customers.size() - 1);
	}

	public static void changeCustomer() {
		// TODO Auto-generated method stub

	}

	public static void deleteCustomer() {
		// TODO add a check for whether the customer is associated with invoices.
		// If invoices are linked with the customer, ask the user if he wishes to delete
		// all the invoices associated
		// with the customer
		if (Controller.customers.size() == 0) {
			System.out.print("No customers in database.\n");
			return;
		}
		while (true) {
			showCustomers();
			System.out.print("Enter ID to delete an customer. Leave blank to exit: ");
			long userInput = UserInputHandler.getIntegerInput(false);
			// badness due to not-so-good implementation of getIntegerInput
			if (userInput == 0) {
				return;
			}
			if (getCustomer(userInput) != null) {
				Controller.customers.remove(getCustomer(userInput));
				System.out.printf("Successfully removed customer %d\n", userInput);
				return;
			} else {
				System.out.print("No such customer.\n");
				continue;
			}
		}
	}

}
