package dataHandler;

import java.time.Instant;
import java.util.ArrayList;

import IO.IDCounter;
import IO.UserInputHandler;
import dataClasses.Customer;
import dataClasses.Invoice;
import dataClasses.Status;
import dataClasses.TransactionType;

public class InvoiceHandler {

	public static void addInvoice() {
		Controller.addMessage();
		Invoice newInvoice = new Invoice();
		assignIDInvoice(newInvoice);
		newInvoice.setDateOfCreation(Instant.now());
		addTransactionTypeToInvoice(newInvoice);
		addStatusToInvoice(newInvoice);
		addDiscountToInvoice(newInvoice);

		// do we need a customer?
		Customer tempCustomer = addInvoiceAddCustomer();
		if (tempCustomer == null) {
			newInvoice.setCustomer(null);
		} else {
			newInvoice.setCustomer(tempCustomer);
			tempCustomer.getInvoicesIDs().add(newInvoice.getId());
		}

		if (UserInputHandler.yesNoDialogue("Has shipping address? y/n ")) {
			AddressHandler.addAddress();
			newInvoice.setShippingAddress(Controller.getAddresses().get(Controller.getAddresses().size() - 1));
		} else {
			// if there is no shipping address, the billing address becomes shipping address.
			// only if the customer exists
			if (newInvoice.getCustomer() != null) {
				newInvoice.setShippingAddress(newInvoice.getCustomer().getBillingAddress());
			}
		}
		Controller.getInvoices().add(newInvoice);
		System.out.print("Successfully added invoice ");
		showInvoice(getLastInvoice());
		IO.DataIO.writeDataToFiles();
	}

	private static void addDiscountToInvoice(Invoice newInvoice) {
		// FIXME temporary
		newInvoice.setInvoiceDiscountPercent((byte) 0);
	}

	private static void addStatusToInvoice(Invoice newInvoice) {
		ArrayList<Status> statuses = Controller.getStatuses();
		if (!(statuses.size() > 1)) {
			newInvoice.setStatus(statuses.get(0));
			return;
		}
		StatusHandler.showStatuses();
		while (true) {
			System.out.print("* Select status: ");
			byte userInput = (byte) IO.UserInputHandler.getIntegerInput(true);
			Status selectedStatus = StatusHandler.getStatusByID(userInput);
			if (selectedStatus == null) {
				continue;
			}
			newInvoice.setStatus(selectedStatus);
			return;
		}
	}

	private static void addTransactionTypeToInvoice(Invoice newInvoice) {
		ArrayList<TransactionType> transactionTypes = Controller.getTransactionTypes();
		if (!(transactionTypes.size() > 1)) {
			newInvoice.setTransacationType(transactionTypes.get(0));
			return;
		}
		TransactionTypeHandler.showTransactionTypes();
		while (true) {
			System.out.print("* Select transaction type: ");
			byte userInput = (byte) IO.UserInputHandler.getIntegerInput(true);
			TransactionType selectedTransactionType = TransactionTypeHandler.getTransactionTypeByID(userInput);
			if (selectedTransactionType == null) {
				continue;
			}
			newInvoice.setTransacationType(selectedTransactionType);
			return;
		}
	}

	/**
	 * This is incredibly bad
	 * 
	 * @return badness
	 */
	// FIXME this entire this is bad. rewrite.
	// TODO add each invoice to the customers invoice list.
	public static Customer addInvoiceAddCustomer() {
		if (UserInputHandler.yesNoDialogue("Customer required? y/n ")) {
			while (true) {
				if (UserInputHandler.oneOrTwoDialogue("1 - existing customer\n2 - new customer ")) {
					// existing customer
					if (Controller.getCustomers().size() == 0) {
						System.out.print("No customers in database\n");
					} else {
						while (true) {
							System.out.print("Enter ID or name. Empty to cancel: ");
							String searchToken = UserInputHandler.getStringInput(true);
							// check if cancelled
							if (searchToken.isBlank()) {
								break;
							}
							// if it is an id
							if (UserInputHandler.isLongInput(searchToken)) {
								Customer invoiceCustomer = CustomerHandler.getCustomer(Long.parseLong(searchToken.trim()));
								if (invoiceCustomer != null) {
									// customer found
									return invoiceCustomer;
								} else {
									// no hit
									System.out.print("No such customer.\n");
									CustomerHandler.showCustomers();
								}
							} else {
								// if it a string
								// search all names and report them
								ArrayList<Customer> suspectCustomers = CustomerHandler.getCustomer(searchToken);
								// if none
								// restart search
								if (suspectCustomers.size() == 0) {
									System.out.print("No such customer found\n");
								}
								// if there is only one
								// get his id
								else if (suspectCustomers.size() == 1) {
									return suspectCustomers.get(0);
								}
								// if more than one
								else {
									Customer suspectCustomer = selectCustomerFromCustomers(suspectCustomers);
									if (suspectCustomer == null) {
									}
									else {
										return suspectCustomer;
									}
								}
							}
						}
						// if something went wrong
					}
					continue;
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

	private static Customer selectCustomerFromCustomers(ArrayList<Customer> suspectCustomers) {
		while (true) {
			for (Customer customer : suspectCustomers) {
				CustomerHandler.showCustomer(customer);
				System.out.print("\n");
			}
			System.out.print("Enter one of the IDs above. Leave blank to retry: ");
			String idChoice = UserInputHandler.getStringInput(false);
			if (idChoice.isEmpty()) {
			} else {
				while (true) {
					for (Customer customer : suspectCustomers) {
						if (customer.getId() == Long.parseLong(idChoice)) {
							return customer;
						}
					}
					// you are not blessed with perception
					System.out.print("Enter the ID above: ");
				}
			}
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
		invoice.setId(IDCounter.incrementInvoiceCounter());
	}

	public static Invoice getLastInvoice() {
		return Controller.getInvoices().get(Controller.getInvoices().size() - 1);
	}

	static Invoice getInvoice(long id) {
		for (Invoice invoice : Controller.getInvoices()) {
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
		if (invoice.getCustomer() != null) {
			CustomerHandler.showCustomer(invoice.getCustomer());
			sb.append(" ");
		}
		sb.append(invoice.getDateOfCreation().toString());
		System.out.print(sb.toString());
	}

	public static void showInvoices() {
		if (Controller.getInvoices().size() == 0) {
			System.out.print("No invoices in the database.\n");
			return;
		}
		for (Invoice invoice : Controller.getInvoices()) {
			showInvoice(invoice);
			System.out.print("\n");
		}
	}

	public static void changeInvoice() {
		showInvoices();
		while (true) {
			System.out.print("Enter invoice ID to change it. Leave blank to cancel: ");
			long userInput = UserInputHandler.getIntegerInput(false);
			if (userInput == 0) {
				return;
			}
			if (getInvoice(userInput) == null) {
				System.out.print("No such invoice.\n");
			} else {
				changeInvoiceAttributes(getInvoice(userInput));
				IO.DataIO.writeDataToFiles();
			}
		}
	}

	private static void changeInvoiceAttributes(Invoice newInvoice) {
		changeInvoiceCustomer(newInvoice);
		// TODO add transaction and status id.
		// and other data fields as they appear.
		changeInvoiceAddress(newInvoice);
		IO.DataIO.writeDataToFiles();
	}
	
	public static void changeInvoiceCustomer(Invoice invoice) {
		long userInput;
		while (true) {
			System.out.printf("Customer is %s. Enter new id. Leave blank to skip: ",
					CustomerHandler.getCustomer(invoice.getId()).toString());
			userInput = UserInputHandler.getIntegerInput(false);
			if (userInput != 0) {
				if (Controller.getCustomers().get((int) userInput) != null) {
					invoice.setCustomer(CustomerHandler.getCustomer(userInput));
					return;
				} else {
					System.out.printf("Customer with id %d does not exist.\n", userInput);
				}
			}
		}
	}
	
	private static void changeInvoiceAddress(Invoice newInvoice) {
		long userInput;
		while (true) {
			if (newInvoice.getShippingAddress() == null) {
				System.out.print("No shipping address. Enter new shipping address. Leave blank to skip: ");
				userInput = UserInputHandler.getIntegerInput(false);
				if (userInput != 0) {
					dataClasses.Address suspectAddress = Controller.getAddresses().get((int) userInput); 
					if (suspectAddress != null) {
						newInvoice.setShippingAddress(suspectAddress);
						return;
					} else {
						System.out.printf("Address with id %d does not exist.\n", userInput);
						continue;
					}
				}
			} else {
				System.out.printf("Shipping address is %s. Enter new id. Leave blank to skip: ",
						newInvoice.getShippingAddress().toString());
			}
			userInput = UserInputHandler.getIntegerInput(false);
			if (userInput != 0) {
				newInvoice.setShippingAddress(AddressHandler.getAddress(userInput));
				return;
			}
		}
	}

	public static void deleteInvoice() {
		if (Controller.getInvoices().size() == 0) {
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
				Invoice invoiceToBeDeleted = getInvoice(userInput);
				Controller.getInvoices().remove(invoiceToBeDeleted);
				System.out.printf("Successfully removed invoice %d\n", userInput);

				IO.DataIO.writeDataToFiles();
				return;
			} else {
				System.out.print("No such invoice.\n");
			}
		}
	}

	@Deprecated
	static boolean invoiceIdIsUnique(long id) {
		for (Invoice invoice : Controller.getInvoices()) {
			if (invoice.getId() == id) {
				return false;
			}
		}
		return true;
	}

}
