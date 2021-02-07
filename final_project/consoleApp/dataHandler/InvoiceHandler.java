package dataHandler;

import java.util.ArrayList;
import java.util.Date;

import org.w3c.dom.UserDataHandler;

import IO.IDCounter;
import IO.UserInputHandler;
import dataClasses.Customer;
import dataClasses.Invoice;

public class InvoiceHandler {

	public static void addInvoice() {
		Controller.addMessage();
		Invoice newInvoice = new Invoice();
		assignIDInvoice(newInvoice);
		newInvoice.setDateOfCreation(new Date());
		// TODO
		newInvoice.setStatusId((byte) -1);
		// TODO
		newInvoice.setTranscationTypeId((byte) -1);

		// do we need a customer?
		Customer tempCustomer = addInvoiceAddCustomer();
		if (tempCustomer == null) {
			newInvoice.setCustomerId(-1);
		} else {
			newInvoice.setCustomerId(tempCustomer.getId());
			tempCustomer = null;
		}

		if (!(UserInputHandler.yesNoDialogue("Has shipping address? y/n"))) {
			newInvoice.setShippingAddressId(0);
		} else {
			// addAddress();
			// newInvoice.setShippingAddressId(addresses.get(addresses.size() - 1).getId());
		}
		Controller.invoices.add(newInvoice);
		System.out.printf("Successfully added invoice ");
		showInvoice(getLastInvoice());
		IO.DataIO.writeDataInvoicesFile(Controller.invoices);
	}

	/**
	 * This is incredibly bad
	 * 
	 * @return badness
	 */
	public static Customer addInvoiceAddCustomer() {
		if (UserInputHandler.yesNoDialogue("Customer required? y/n ")) {
			while (true) {
				if (UserInputHandler.oneOrTwoDialogue("1 - existing customer\n2 - new customer ")) {
					// existing customer
					if (Controller.customers.size() == 0) {
						System.out.print("No customers in database\n");
						continue;
					} else {
						while (true) {
							System.out.print("Enter ID or name. Empty to cancel: ");
							String searchToken = UserInputHandler.getStringInput(true);
							// check if cancelled
							if (searchToken.isEmpty()) {
								break;
							}
							// if it is an id
							if (UserInputHandler.isLongInput(searchToken)) {
								Customer invoiceCustomer = CustomerHandler.getCustomer(Long.parseLong(searchToken.trim()));
								if (invoiceCustomer != null && invoiceCustomer.getId() != -1) {
									// customer found
									return invoiceCustomer;
								} else {
									// no hit
									System.out.print("No such customer.\n");
									CustomerHandler.showCustomers();
									continue;
								}
							} else {
								// if it a string
								// search all names and report them
								ArrayList<Customer> suspectCustomers = CustomerHandler.getCustomer(searchToken);
								// if none
								// restart search
								if (suspectCustomers.size() == 0) {
									System.out.print("No such customer found\n");
									continue;
								}
								// if there is only one
								// get his id
								else if (suspectCustomers.size() == 1) {
									return suspectCustomers.get(0);
								}
								// if more than one
								else {
									for (Customer customer : suspectCustomers) {
										CustomerHandler.showCustomer(customer);
										System.out.print("\n");
									}
									System.out.print("Enter one of the IDs above. Leave blank to retry: ");
									String idChoice = UserInputHandler.getStringInput(false);
									if (idChoice.isEmpty()) {
										continue;
									} else {
										while (true) {
											for (Customer customer : suspectCustomers) {
												if (customer.getId() == Long.parseLong(idChoice)) {
													return customer;
												}
											}
											// you are not blessed with perception
											System.out.print("Enter the ID above: ");
											continue;
										}
									}
								}
							}
						}
						// if something went wrong
						continue;
					}
				}
				// adding a new customer
				else {
					CustomerHandler.addCustomer();
					return CustomerHandler.getLastCustomer();
				}
			}
		} else {
			// customer not required
			return null;
		}
	}

	private static void assignIDInvoice(Invoice invoice) {
		// System.out.print("Please enter unique invoice ID. Leave blank for automatic
		// generation: ");
		// long userInput = UserInputHandler.getIntegerInput(false);
		// if (userInput == 0) {
		// invoice.setId(IDCounter.getInvoiceCounter());
		// } else {
		// invoice.setId(enterId((byte) 0, userInput));
		// }
		invoice.setId(IDCounter.getInvoiceCounter());
	}

	public static Invoice getLastInvoice() {
		return Controller.invoices.get(Controller.invoices.size() - 1);
	}

	private static Invoice getInvoice(long id) {
		for (Invoice invoice : Controller.invoices) {
			if (invoice.getId() == id) {
				return invoice;
			}
		}
		System.out.print("No such invoice.\n");
		return null;
	}

	public static void showInvoice(Invoice invoice) {
		StringBuilder sb = new StringBuilder();
		sb.append(invoice.getId()).append(" ");
		System.out.print(sb.toString());
		sb.delete(0, sb.length());
		if (invoice.getCustomerId() != -1) {
			CustomerHandler.showCustomer(CustomerHandler.getCustomer(invoice.getCustomerId()));
			sb.append(" ");
		}
		sb.append(invoice.getDateOfCreation().toString());
		System.out.print(sb.toString());
	}

	public static void showInvoices() {
		if (Controller.invoices.size() == 0) {
			System.out.print("No invoices in the database.\n");
			return;
		}
		for (Invoice invoice : Controller.invoices) {
			showInvoice(invoice);
			System.out.print("\n");
		}
	}

	public static void changeInvoice() {
		Invoice newInvoice;
		showInvoices();
		while (true) {
			System.out.print("Enter invoice ID to change it. Leave blank to cancel: ");
			long userInput = UserInputHandler.getIntegerInput(false);
			if (userInput == 0) {
				return;
			}
			if (getInvoice(userInput) == null) {
				System.out.print("No such invoice.\n");
				continue;
			} else {
				changeInvoiceAttributes(getInvoice(userInput));
			}
		}

	}

	private static void changeInvoiceAttributes(Invoice newInvoice) {
		long userInput;
		System.out.printf("Customer is %s. Enter new id. Leave blank to skip: ",
				CustomerHandler.getCustomer(newInvoice.getId()).toString());
		userInput = UserInputHandler.getIntegerInput(false);
		if (userInput != 0) {
			// TODO add check whether customer exists
			newInvoice.setCustomerId(userInput);
		}
		// TODO add transaction and status id.
		// and other data fields as they appear.
		if (newInvoice.getShippingAddressId() == 0) {
			System.out.print("No shipping address. Enter new shipping address. Leave blank to skip: ");
			userInput = UserInputHandler.getIntegerInput(false);
			if (userInput != 0) {
				// TODO check if shipping address exists
				newInvoice.setShippingAddressId(userInput);
			}
		}
		// TODO add a check here
		if (newInvoice.getShippingAddressId() == -1) {
			System.out.print("Invoice has no shipping address. Enter new shipping ID or leave blank to skip: ");
		} else {
			System.out.printf("Shipping address is %s. Enter new id. Leave blank to skip: ",
					AddressHandler.getAddress(newInvoice.getShippingAddressId()).toString());
		}
		userInput = UserInputHandler.getIntegerInput(false);
		if (userInput != 0) {
			newInvoice.setShippingAddressId(userInput);
		}
	}

	public static void deleteInvoice() {
		if (Controller.invoices.size() == 0) {
			System.out.print("No invoices in database.\n");
			return;
		}
		while (true) {
			showInvoices();
			System.out.print("Enter ID to delete an invoice. Leave blank to exit: ");
			long userInput = UserInputHandler.getIntegerInput(false);
			if (userInput == 0) {
				return;
			}
			if (getInvoice(userInput) != null) {
				Controller.invoices.remove(getInvoice(userInput));
				System.out.printf("Successfully removed invoice %d\n", userInput);
				IO.DataIO.writeDataInvoicesFile(Controller.invoices);
				return;
			} else {
				System.out.print("No such invoice.\n");
				continue;
			}
		}
	}

	static boolean invoiceIdIsUnique(long id) {
		for (Invoice invoice : Controller.invoices) {
			if (invoice.getId() == id) {
				return false;
			}
		}
		return true;
	}

}
