package dataHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import IO.IDCounter;
import IO.UserInputHandler;
import dataClasses.Customer;
import dataClasses.Invoice;

public class CustomerHandler {

	public static void addCustomer() {
		Controller.addMessage();
		Customer newCustomer = new Customer();
		assignIDCustomer(newCustomer);
		newCustomer.setDateOfCreation(Instant.now());
		newCustomer.setType(UserInputHandler.oneOrTwoDialogue("1 - legal person\n2 - natural person: "));
		if (newCustomer.isType() == Customer.NATURAL_PERSON) {
			addCustomerNaturalPerson(newCustomer);
		} else {
			addCustomerLegalPerson(newCustomer);
		}
		customerSetAddress(newCustomer);
		Controller.getCustomers().add(newCustomer);
		System.out.print("Successfully added customer ");
		showCustomer(getLastCustomer());
		IO.DataIO.writeDataToFiles();
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
		System.out.print("* VATID: ");
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
		customer.setId(IDCounter.incrementCustomerCounter());
	}

	static void customerSetAddress(Customer customer) {
		AddressHandler.addBillingAddress();
		customer.setBillingAddress(AddressHandler.getLastAddress());
		if (UserInputHandler.yesNoDialogue("Customer requires separate shipping address? y/n ")) {
			AddressHandler.addShippingAddress();
			customer.setShippingAddress(AddressHandler.getLastAddress());
		}
	}

	@Deprecated
	static boolean customerIdIsUnique(long id) {
		for (Customer customer : Controller.getCustomers()) {
			if (customer.getId() == id) {
				return false;
			}
		}
		return true;
	}

	static Customer getCustomer(Customer customer) {
		for (Customer suspectCustomer : Controller.getCustomers()) {
			if (suspectCustomer == customer) {
				return suspectCustomer;
			}
		}
		System.out.printf("Customer with id %d not found!\n", customer.getId());
		return null;
	}
	
	public static Customer getCustomer(long id) {
		for (Customer suspectCustomer : Controller.getCustomers()) {
			if (suspectCustomer.getId() == id) {
				return suspectCustomer;
			}
		}
		System.out.printf("Customer with id %d not found!\n", id);
		return null;
	}

	static ArrayList<Customer> getCustomer(String token) {
		ArrayList<Customer> suspectCustomers = new ArrayList<>();
		for (Customer customer : Controller.getCustomers()) {
			if (customer.getFirstName().toLowerCase().contains(token.toLowerCase())) {
				suspectCustomers.add(customer);
			} else if (customer.getMiddleName().toLowerCase().contains(token.toLowerCase())) {
				suspectCustomers.add(customer);
			} else if (customer.getLastName().toLowerCase().contains(token.toLowerCase())) {
				suspectCustomers.add(customer);
			}
		}
		return suspectCustomers;
	}

	static void showCustomer(Customer customer) {
		if (customer == null) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		if (customer.isType() == Customer.NATURAL_PERSON) {
			sb.append(customer.getId()).append(" ");
			sb.append(customer.getNationalIdNumber()).append(" ");
			sb.append(customer.getFirstName()).append(" ");
			if (!customer.getMiddleName().isEmpty()) {
				sb.append(customer.getMiddleName()).append(" ");
			}
			sb.append(customer.getLastName()).append(" ");
		} else {
			sb.append(customer.getId()).append(" ");
			sb.append(customer.getName()).append(" ");
			sb.append(customer.getVATID());
		}
		System.out.print(sb.toString());
	}

	public static void showCustomers() {
		if (Controller.getCustomers().size() == 0) {
			System.out.print("No customers in the database.\n");
			return;
		}
		for (Customer customer : Controller.getCustomers()) {
			showCustomer(customer);
			System.out.print("\n");
		}
	}

	public static Customer getLastCustomer() {
		return Controller.getCustomers().get(Controller.getCustomers().size() - 1);
	}

	public static ArrayList<Invoice> customerAssociatedWithInvoices(Customer customer) {
		// checking if the customer is associated with any invoice.
		ArrayList<Invoice> associatedInvoices = new ArrayList<>();
		for (dataClasses.Invoice invoice : Controller.getInvoices()) {
			if (invoice.getCustomer() == customer) {
				associatedInvoices.add(invoice);
			}
		}
		return associatedInvoices;
	}

	/**
	 * Method checks whether the customer is found in any invoices. If it is, returns false. Else returns true.
	 * @param customer
	 * @return true if can be deleted.
	 */
	public static boolean customerCanBeDeleted(Customer customer) {
		ArrayList<Invoice> invoices = customerAssociatedWithInvoices(customer);
		if (invoices.size() != 0) {
			System.out.printf("Cannot change customer with id %d because he is associated with invoices ",
					customer.getId());
			for (dataClasses.Invoice invoice : invoices) {
				System.out.printf("%d ", invoice.getId());
			}
			System.out.print("\n");
			return true;
		}
		return false;
	}

	public static void changeCustomer() {
		showCustomers();
		long userInput;
		while (true) {
			System.out.print("Enter customer ID to change it. Leave blank to cancel: ");
			userInput = UserInputHandler.getIntegerInput(false);
			if (userInput == 0) {
				return;
			} else {
				if (Controller.getCustomers().get((int) userInput) != null) {
					changeCustomerAttributes(Controller.getCustomers().get((int) userInput));

					IO.DataIO.writeDataToFiles();
				} else {
					System.out.print("Customer does not exist.\n");
				}
			}
		}
	}

	private static void changeCustomerAttributes(Customer customer) {
		System.out.printf("Customer type is %s. Change to %s? y/n ",
				customer.isType() == Customer.NATURAL_PERSON ? "natural person" : "legal person",
				!(customer.isType() == Customer.NATURAL_PERSON) ? "natural person" : "legal person");
		if (UserInputHandler.yesNoDialogue("")) {
			customer.setType(!customer.isType());
		}
		if (customer.isType() == Customer.NATURAL_PERSON) {
			changeNaturalPersonCustomerAttributes(customer);
		} else {
			changeLegalPersonCustomerAttributes(customer);
		}
		long userInput;
		while (true) {
			System.out.printf("* Customer billing address is %s. Enter new ID or leave blank to skip: ",
					AddressHandler.getAddress(customer.getBillingAddress().getId()).toString());
			userInput = UserInputHandler.getIntegerInput(false);
			if (userInput != 0) {
				dataClasses.Address returnAddress = AddressHandler.getAddress((int) userInput);
				if (returnAddress != null) {
					customer.setBillingAddress(AddressHandler.getAddress((int) userInput));
					break;
				}
			}
		}
		if (customer.getShippingAddress() == null) {
			System.out.print("Customer has no shipping address. Enter new ID or leave blank to skip: ");
		} else {
			System.out.printf("Customer shipping address is %s. Enter new ID or leave blank to skip: ",
					AddressHandler.getAddress(customer.getShippingAddress().getId()));
		}
		customer.setShippingAddress(AddressHandler.getAddress(UserInputHandler.getIntegerInput(false)));
	}

	private static void changeNaturalPersonCustomerAttributes(Customer customer) {
		String userInput;
		if (customer.getFirstName() != null) {
			System.out.printf("* First name is %s. Enter new name or leave blank to skip: ", customer.getFirstName());
			userInput = UserInputHandler.getStringInput(false);
			customer.setFirstName(userInput);
		} else {
			System.out.print("* No first name. Enter a new name:");
			customer.setFirstName(UserInputHandler.getStringInput(true));
		}
		if (customer.getMiddleName() != null) {
			System.out.printf("Middle name is %s. Enter new name or leave blank to skip: ", customer.getMiddleName());
			userInput = UserInputHandler.getStringInput(false);
			customer.setMiddleName(userInput);
		} else {
			System.out.print("No middle name. Enter a new middle name or leave blank to skip: ");
			customer.setMiddleName(UserInputHandler.getStringInput(false));
		}
		if (customer.getLastName() != null) {
			System.out.printf("* Last name is %s. Enter new name or leave blank to skip: ", customer.getLastName());
			userInput = UserInputHandler.getStringInput(false);
			customer.setLastName(userInput);
		} else {
			System.out.print("* No Last name. Enter a new last name:");
			customer.setLastName(UserInputHandler.getStringInput(true));
		}
		if (customer.getNationalIdNumber() != null) {
			System.out.printf("National ID number is %s. Enter new ID number or leave blank to skip: ",
					customer.getNationalIdNumber());
		} else {
			System.out.print("No national ID number. Enter new ID number or leave blank to skip: ");
		}
		customer.setNationalIdNumber(UserInputHandler.getStringInput(false));
	}

	private static void changeLegalPersonCustomerAttributes(Customer customer) {
		String userInput;
		if (customer.getName() != null) {
			System.out.printf("* Name is %s. Enter new name or leave blank to skip: ", customer.getName());
			userInput = UserInputHandler.getStringInput(false);
			if (!userInput.isEmpty()) {
				customer.setName(userInput);
			}
		} else {
			System.out.print("* Enter name: ");
			customer.setName(UserInputHandler.getStringInput(true));
		}
		userInput = UserInputHandler.getStringInput(false);
		System.out.print("* VATID is %s. Enter new VATID or leave blank to skip: ");
		if (!userInput.isEmpty()) {
			customer.setVATID(userInput);
		}
	}

	public static void deleteCustomer() {
		if (Controller.getCustomers().size() == 0) {
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
			Customer toBeDeletedCustomer = getCustomer(userInput);
			if (toBeDeletedCustomer != null) {
				if (customerCanBeDeleted(toBeDeletedCustomer)) {
					System.out.print("Cannot delete customer. Delete or change invoices first.\n");
					return;
				}
				Customer deletedCustomer = getCustomer(userInput);
				Controller.getCustomers().remove(deletedCustomer);
				System.out.printf("Successfully removed customer %d\n", userInput);
				AddressHandler.purgeFromAddressesCustomer(deletedCustomer);
				IO.DataIO.writeDataToFiles();
				return;
			} else {
				System.out.print("No such customer.\n");
			}
		}
	}

}
