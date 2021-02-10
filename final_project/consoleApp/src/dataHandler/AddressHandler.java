package dataHandler;

import IO.IDCounter;
import IO.UserInputHandler;
import dataClasses.Address;

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
		address.setId(IDCounter.getAddressCounter());
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
		StringBuilder sb = new StringBuilder();
		sb.append(address.getId()).append(" ");
		sb.append(address.isType() == Address.BILLING_ADDRESS ? "billing address" : "shipping address").append(" ");
		sb.append(address.getStreet()).append(" ");
		sb.append(address.getStreetNumber()).append(" ");
		sb.append(address.getStreetLetter()).append(" ");
		sb.append(address.getCity()).append(" ");
		sb.append(address.getZIPCode()).append(" ");
		sb.append(address.getCountry());
		System.out.print(sb.toString());
	}
	
	public static Address getAddress(long addressID) {
		if (Controller.getAddresses().get((int) addressID) != null) {
			return Controller.getAddresses().get((int) addressID);
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
				return;
			} else {
				System.out.print("No such address.\n");
				continue;
			}
		}
	}
	
}
