package dataHandler;

import IO.DataIO;
import IO.IDCounter;
import IO.UserInputHandler;
import dataClasses.Address;
import dataClasses.Customer;

import javax.naming.ldap.Control;
import java.util.ArrayList;

public class AddressHandler {

	public static void addAddress() {
		Controller.addMessage();
		if (UserInputHandler.oneOrTwoDialogue("1 - shipping address\n2 - billing address: ")) {
			addBillingAddress();
		} else {
			addShippingAddress();
		}
	}

	private static void addAddressType(boolean type) {
		Address newAddress = new Address();
		setAddressId(newAddress);
		newAddress.setType(type);
		System.out.print("* Enter street name: ");
		newAddress.setStreet(UserInputHandler.getStringInput(true));
		System.out.print("Enter street number: ");
		newAddress.setStreetNumber(UserInputHandler.getStringInput(false));
		System.out.print("Enter street letter: ");
		newAddress.setStreetLetter(UserInputHandler.getStringInput(false));
		System.out.print("* Enter ZIP code: ");
		newAddress.setZIPCode(UserInputHandler.getStringInput(true));
		System.out.print("* Enter city name: ");
		newAddress.setCity(UserInputHandler.getStringInput(true));
		System.out.print("* Enter country name: ");
		newAddress.setCountry(UserInputHandler.getStringInput(true));
		Controller.getAddresses().add(newAddress);
		System.out.print("Successfully added address ");
		showAddress(getLastAddress());
		System.out.print("\n");
		IO.DataIO.writeDataToFiles();
	}

	static void addShippingAddress() {
		addAddressType(Address.SHIPPING_ADDRESS);
	}

	static void addBillingAddress() {
		addAddressType(Address.BILLING_ADDRESS);
	}

	static void setAddressId(Address address) {
		// System.out.print("Enter unique ID for address. Leave blank for automatic
		// generation: ");
		// long userInput = UserInputHandler.getIntegerInput(false);
		// if (userInput == 0) {
		// address.setId(IDCounter.getAddressCounter());
		// } else {
		// address.setId(enterId((byte) 2, userInput));
		// }
		address.setId(IDCounter.incrementAddressCounter());
	}

	@Deprecated
	static boolean addressIdIsUnique(long id) {
		for (Address address : Controller.getAddresses()) {
			if (address.getId() == id) {
				return false;
			}
		}
		return true;
	}

	static void showAddress(Address address) {
		String sb = address.getId() + " " +
				(address.isType() == Address.BILLING_ADDRESS ? "billing address" : "shipping address") + " " +
				address.getStreet() + " " +
				address.getStreetNumber() + " " +
				address.getStreetLetter() + " " +
				address.getCity() + " " +
				address.getZIPCode() + " " +
				address.getCountry();
		System.out.print(sb);
	}
	
	public static Address getAddress(long addressID) {
		ArrayList<Address> tempAddresses = Controller.getAddresses();
		for (Address address : tempAddresses) {
			if (address.getId() == addressID) {
				return address;
			}
		}
		return null;
	}

	public static Address getLastAddress() {
		return Controller.getAddresses().get(Controller.getAddresses().size() - 1);
	}

	public static void showAddresses() {
		if (Controller.getAddresses().size() == 0) {
			System.out.print("No addresses in the database.\n");
			return;
		}
		for (Address address : Controller.getAddresses()) {
			showAddress(address);
			System.out.print("\n");
		}
	}

	public static void changeAddress() {
		// TODO Auto-generated method stub

	}

	public static void deleteAddress() {
		if (Controller.getAddresses().size() == 0) {
			System.out.print("No addresses in database.\n");
			return;
		}
		while (true) {
			showAddresses();
			System.out.print("Enter ID to delete an address. Leave blank to exit: ");
			long userInput = UserInputHandler.getIntegerInput(false);
			// badness due to not-so-good implementation of getIntegerInput
			if (userInput == 0) {
				return;
			}
			if (AddressHandler.getAddress(userInput) != null) {
				Controller.getAddresses().remove(AddressHandler.getAddress(userInput));
				System.out.printf("Successfully removed address %d\n", userInput);
				DataIO.writeDataToFiles();
				return;
			} else {
				System.out.print("No such address.\n");
				continue;
			}
		}
	}

	public static void purgeFromAddressesCustomer(Customer deletedCustomer) {
		ArrayList<Address> addresses = Controller.getAddresses();
		for (Address address : Controller.getAddresses()) {
			for (long customerID : address.getCustomerIDs()) {
				if (customerID == deletedCustomer.getId()) {
					address.getCustomerIDs().remove(deletedCustomer.getId());
					System.out.printf("Purged %s from address %d\n", deletedCustomer.toString(), address.getId());
				}
			}
		}
		IO.DataIO.writeDataToFiles();
	}
}
