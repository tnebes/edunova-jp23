package IO;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

import consoleApp.DataClasses.Address;
import consoleApp.DataClasses.Article;
import consoleApp.DataClasses.Customer;
import consoleApp.DataClasses.Invoice;

/**
 * 
 * @author tnebes
 * @date 6 February 2021
 */

public class DataHandler {

	static private double DOUBLE_EPSILON = 10e-14;
	static private float FLOAT_EPSILON = 10e-7f;

	static private ArrayList<Invoice> invoices = new ArrayList<>();
	static private ArrayList<Customer> customers = new ArrayList<>();
	static private ArrayList<Address> addresses = new ArrayList<>();
	static private ArrayList<Article> articles = new ArrayList<>();

	public static void initialiseData() throws FileNotFoundException {
		invoices = DataIO.getDataInvoicesFileData();
		customers = DataIO.getDataCustomersFileData();
		addresses = DataIO.getDataAddressesFileData();
		articles = DataIO.getDataArticlesFileData();		
	}

	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(ArrayList<Invoice> invoices) {
		DataHandler.invoices = invoices;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		DataHandler.customers = customers;
	}

	public ArrayList<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(ArrayList<Address> addresses) {
		DataHandler.addresses = addresses;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		DataHandler.articles = articles;
	}

	public static void addMessage() {
		System.out.print("Entering data. Fields marked * are mandatory.\n");
	}

	public static void showInvoice(Invoice invoice) {
		StringBuilder sb = new StringBuilder();
		sb.append(invoice.getId()).append(" ");
		System.out.print(sb.toString());
		sb.delete(0, sb.length());
		if (invoice.getCustomerId() != -1) {
			showCustomer(getCustomer(invoice.getCustomerId()));
			sb.append(" ");
		}
		sb.append(invoice.getDateOfCreation().toString());
		System.out.print(sb.toString());
	}

	private static void showCustomer(Customer customer) {
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

	private static void showAddress(Address address) {
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

	private static void showArticle(Article article) {
		StringBuilder sb = new StringBuilder();
		sb.append(article.getId()).append(" ");
		if (!article.getLongName().isBlank()) {
			sb.append(article.getLongName()).append(" ");			
		}
		sb.append(article.getShortName()).append(" ");
		sb.append(article.getWarehouseLocation()).append(" ");
		sb.append(article.getWarehouseQuantity()).append(" ");
		sb.append(article.getRetailPrice());
		System.out.print(sb.toString());
	}

	private static Customer getCustomer(long id) {
		for (Customer customer : customers) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		System.out.printf("Customer with id %d not found!\n", id);
		return null;
	}
	
	private static ArrayList<Customer> getCustomer(String token) {
		ArrayList<Customer> suspectCustomers = new ArrayList<>();
		for (Customer customer : customers) {
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
	
	private static Invoice getInvoice(long id) {
		for (Invoice invoice : invoices) {
			if (invoice.getId() == id) {
				return invoice;
			}
		}
		System.out.print("No such invoice.\n");
		return null;
	}

	public static void showInvoices() {
		if (invoices.size() == 0) {
			System.out.print("No invoices in the database.\n");
			return;
		}
		for (Invoice invoice : invoices) {
			showInvoice(invoice);
			System.out.print("\n");
		}
	}

	public static void showCustomers() {
		if (customers.size() == 0) {
			System.out.print("No customers in the database.\n");
			return;
		}
		for (Customer customer : customers) {
			showCustomer(customer);
			System.out.print("\n");
		}
	}

	public static void showAddresses() {
		if (addresses.size() == 0) {
			System.out.print("No addresses in the database.\n");
			return;
		}
		for (Address address : addresses) {
			showAddress(address);
			System.out.print("\n");
		}
	}

	public static void showArticles() {
		if (articles.size() == 0) {
			System.out.print("No articles in the database.\n");
			return;
		}
		for (Article article : articles) {
			showArticle(article);
			System.out.print("\n");
		}
	}

	private static boolean invoiceIdIsUnique(long id) {
		for (Invoice invoice : invoices) {
			if (invoice.getId() == id) {
				return false;
			}
		}
		return true;
	}

	private static boolean customerIdIsUnique(long id) {
		for (Customer customer : customers) {
			if (customer.getId() == id) {
				return false;
			}
		}
		return true;
	}

	private static boolean addressIdIsUnique(long id) {
		for (Address address : addresses) {
			if (address.getId() == id) {
				return false;
			}
		}
		return true;
	}

	private static boolean articleIdIsUnique(long id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return false;
			}
		}
		return true;
	}

	private static boolean idIsUnique(long id, byte type) {
		// INVOICES 0
		// CUSTOMERS 1
		// ADDRESSES 2
		// ARTICLES 3
		switch (type) {
		case 0:
			return invoiceIdIsUnique(id);
		case 1:
			return customerIdIsUnique(id);
		case 2:
			return addressIdIsUnique(id);
		case 3:
			return articleIdIsUnique(id);
		}
		return false;
	}

	public static long enterId(byte type, long id) {
		while (true) {
			if (idIsUnique(id, type)) {
				return id;
			} else {
				System.out.print("ID not unique. Enter new id or leave blank for automatic generation: ");
				id = UserInputHandler.getIntegerInput(false);
				if (id != 0) {
					continue;
				} else {
					switch (type) {
					case 0:
						return IDCounter.getInvoiceCounter();
					case 1:
						return IDCounter.getCustomerCounter();
					case 2:
						return IDCounter.getAddressCounter();
					case 3:
						return IDCounter.getInvoiceCounter();
					default:
						System.out.print("Something went wrong.");
						System.exit(1);
					}
				}
			}
		}
	}

	public static void addInvoice() {
		addMessage();
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
			newInvoice.setShippingAddressId(-1);
		} else {
//			addAddress();
//			newInvoice.setShippingAddressId(addresses.get(addresses.size() - 1).getId());
		}
		invoices.add(newInvoice);
		System.out.printf("Successfully added invoice %d\n", newInvoice.getId());
		showInvoice(newInvoice);
	}

	private static void assignIDInvoice(Invoice invoice) {
//		System.out.print("Please enter unique invoice ID. Leave blank for automatic generation: ");
//		long userInput = UserInputHandler.getIntegerInput(false);
//		if (userInput == 0) {
//			invoice.setId(IDCounter.getInvoiceCounter());
//		} else {
//			invoice.setId(enterId((byte) 0, userInput));
//		}
		invoice.setId(IDCounter.getInvoiceCounter());
	}

	/**
	 * This is incredibly bad
	 * 
	 * @return badness
	 */
	public static Customer addInvoiceAddCustomer() {
		if (UserInputHandler.yesNoDialogue("Customer required? y/n")) {
			while (true) {
				if (UserInputHandler.oneOrTwoDialogue("1 - existing customer\n2 - new customer ")) {
					// existing customer
					if (customers.size() == 0) {
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
								Customer invoiceCustomer = getCustomer(Long.parseLong(searchToken.trim()));
								if (invoiceCustomer != null && invoiceCustomer.getId() != -1) {
									// customer found
									return invoiceCustomer;
								} else {
									// no hit
									System.out.print("No such customer.\n");
									showCustomers();
									continue;
								}
							} else {
								// if it a string
								// search all names and report them
								ArrayList<Customer> suspectCustomers = getCustomer(searchToken);
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
										showCustomer(customer);
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
					addCustomer();
					return getLastCustomer();
				}
			}
		} else {
			// customer not required
			return null;
		}
	}

	public static Customer getLastCustomer() {
		return customers.get(customers.size() - 1);
	}

	public static void addCustomer() {
		addMessage();
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
		customers.add(newCustomer);
	}

	private static void assignIDCustomer(Customer customer) {
//		System.out.print("Enter unique ID for customer. Leave blank for automatic generation: ");
//		long userInput = UserInputHandler.getIntegerInput(false);
//		if (userInput == 0) {
//			customer.setId(IDCounter.getCustomerCounter());
//		} else {
//			userInput = enterId((byte) 1, userInput);
//			customer.setId(userInput);
//		}
		customer.setId(IDCounter.getCustomerCounter());
	}

	private static void addCustomerNaturalPerson(Customer naturalPersonCustomer) {
		System.out.print("* First name: ");
		naturalPersonCustomer.setFirstName(UserInputHandler.getStringInput(true));
		System.out.print("Middle name: ");
		naturalPersonCustomer.setMiddleName(UserInputHandler.getStringInput(false));
		System.out.print("* Last name: ");
		naturalPersonCustomer.setLastName(UserInputHandler.getStringInput(true));
		System.out.print("National ID number: ");
		naturalPersonCustomer.setNationalIdNumber(UserInputHandler.getStringInput(false));
	}

	private static void addCustomerLegalPerson(Customer legalPersonCustomer) {
		System.out.print("* Name: ");
		legalPersonCustomer.setName(UserInputHandler.getStringInput(true));
		System.out.print("* VATID");
		legalPersonCustomer.setVATID(UserInputHandler.getStringInput(true));
	}

	private static void customerSetAddress(Customer customer) {
		addBillingAddress();
		customer.setBillingAddressId(getLastAddress().getId());
		if (UserInputHandler.yesNoDialogue("Customer requires separate shipping address? y/n")) {
			addShippingAddress();
			customer.setShippingAddressId(getLastAddress().getId());
		}
	}

	public static Address getLastAddress() {
		return addresses.get(addresses.size() - 1);
	}

	public static void addAddress() {
		addMessage();
		if (UserInputHandler.oneOrTwoDialogue("1 - shipping address\n2 - billing address: ")) {
			addBillingAddress();
		} else {
			addShippingAddress();
		}
	}

	private static void addShippingAddress() {
		addAddressType(Address.SHIPPING_ADDRESS);
	}

	private static void addBillingAddress() {
		addAddressType(Address.BILLING_ADDRESS);
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
		addresses.add(newAddress);
	}

	private static void setAddressId(Address address) {
//		System.out.print("Enter unique ID for address. Leave blank for automatic generation: ");
//		long userInput = UserInputHandler.getIntegerInput(false);
//		if (userInput == 0) {
//			address.setId(IDCounter.getAddressCounter());
//		} else {
//			address.setId(enterId((byte) 2, userInput));
//		}
		address.setId(IDCounter.getAddressCounter());		
	}

	public static void addArticle() {
		addMessage();
		Article newArticle = new Article();
		assignArticleID(newArticle);
		assignArticleNames(newArticle);
		assignArticleWarehouseLocation(newArticle);
		assignArticlePrices(newArticle);
		articles.add(newArticle);
		System.out.print("Successfully added article ");
		showArticle(getLastArticle());
	}

	private static void assignArticleNames(Article article) {
		assignArticleShortName(article);
		assignArticleLongName(article);
		assignArticleShortDescription(article);
		assignArticleLongDescription(article);
		assignArticleQuantity(article);
	}

	private static void assignArticleQuantity(Article article) {
		System.out.print("Enter the amount of articles in the warehouse. Leave blank for 0: ");
		article.setWarehouseQuantity(UserInputHandler.getIntegerInput(false));
	}

	private static void assignArticleShortName(Article article) {
		System.out.print("* Article short name: ");
		article.setShortName(UserInputHandler.getStringInput(true));
	}

	private static void assignArticleLongName(Article article) {
		System.out.print("Article long name: ");
		article.setShortName(UserInputHandler.getStringInput(false));
	}

	private static void assignArticleShortDescription(Article article) {
		System.out.print("Article short description: ");
		article.setShortName(UserInputHandler.getStringInput(false));
	}

	private static void assignArticleLongDescription(Article article) {
		System.out.print("Article long description: ");
		article.setShortName(UserInputHandler.getStringInput(false));
	}

	private static void assignArticlePrices(Article article) {
		System.out.printf(
				"Enter tax rate without %% for article. Leave blank for automatic application of %d%% tax rate: ",
				Article.STANDARD_TAX_RATE);
		byte userIntInput = (byte) UserInputHandler.getIntegerInput(false);
		if (userIntInput == 0) {
			article.setTaxRate(Article.STANDARD_TAX_RATE);
		} else {
			article.setTaxRate(userIntInput);
		}
		boolean userInput = UserInputHandler.oneOrTwoDialogue("1 - enter retail price\n2 - enter wholesale price: ");
		if (userInput) {
			enterArticleRetailPrice(article);
			calculateWholesalePrice(article);
		} else {
			enterArticleWholesalePrice(article);
			calculateArticleRetailPrice(article);
		}
	}

	private static void calculateArticleRetailPrice(Article article) {
		article.setRetailPrice((float) (article.getWholesalePrice() * (article.getTaxRate() / 100.0 + 1)));
	}

	private static void calculateWholesalePrice(Article article) {
		article.setWholesalePrice((float) (article.getRetailPrice() / (article.getTaxRate() / 100.0 + 1)));
	}

	private static void enterArticleWholesalePrice(Article article) {
		System.out.print("* Enter wholesale price: ");
		article.setWholesalePrice((float) UserInputHandler.getDoubleInput(true));
	}

	private static void enterArticleRetailPrice(Article article) {
		System.out.print("* Enter retail price: ");
		article.setRetailPrice((float) UserInputHandler.getDoubleInput(true));
	}

	private static void assignArticleWarehouseLocation(Article article) {
		System.out.print("* Article warehouse location: ");
		article.setWarehouseLocation(UserInputHandler.getStringInput(true));
	}

	private static void assignArticleID(Article article) {
//		System.out.print("Enter article ID. Leave blank for automatic generation: ");
//		long userInput = UserInputHandler.getIntegerInput(false);
//		if (userInput == 0) {
//			article.setId(IDCounter.getArticleCounter());
//		} else {
//			article.setId(enterId((byte) 3, userInput));
//		}
		article.setId(IDCounter.getArticleCounter());
	}
	
	public static Article getLastArticle() {
		return articles.get(articles.size() - 1);
	}

	public static void changeInvoice() {
		// TODO Auto-generated method stub

	}

	public static void changeCustomer() {
		// TODO Auto-generated method stub

	}

	public static void changeAddress() {
		// TODO Auto-generated method stub

	}

	public static void changeArticle() {
		// TODO Auto-generated method stub

	}

	public static void deleteInvoice() {
		if (invoices.size() == 0) {
			System.out.print("No invoices in database.\n");
			return;
		}
		while (true) {
			showInvoices();
			System.out.print("Enter ID to delete an invoice. Leave blank to exit: ");
			long userInput = UserInputHandler.getIntegerInput(false);
			if (userInput == 0) {
				// badness due to not-so-good implementation of getIntegerInput
				if (getInvoice(0) != null) {
					if (UserInputHandler.yesNoDialogue("Delete invoice 0? y/n ")) {
						invoices.remove(getInvoice(0));
						System.out.print("Successfully removed invoice 0\n");
						return;
					} else {
						return;
					}
				}
			} else {
				if (getInvoice(userInput) != null) {
					invoices.remove(getInvoice(userInput));
					System.out.printf("Successfully removed invoice %d\n", userInput);
					return;
				} else {
					System.out.print("No such invoice.\n");
					continue;
				}
			}
		}
	}

	public static void deleteCustomer() {
		// TODO add a check for whether the customer is associated with invoices.
		// If invoices are linked with the customer, ask the user if he wishes to delete all the invoices associated
		// with the customer
		if (customers.size() == 0) {
			System.out.print("No customers in database.\n");
			return;
		}
		while (true) {
			showCustomers();
			System.out.print("Enter ID to delete an customer. Leave blank to exit: ");
			long userInput = UserInputHandler.getIntegerInput(false);
			// badness due to not-so-good implementation of getIntegerInput
			if (getCustomer(0) != null) {
				if (UserInputHandler.yesNoDialogue("Delete customer 0? y/n ")) {
					customers.remove(getCustomer(0));
					System.out.print("Successfully removed invoice 0\n");
					return;
				} else {
					return;
				}
			}
			if (getCustomer(userInput) != null) {
				customers.remove(getCustomer(userInput));
				System.out.printf("Successfully removed customer %d\n", userInput);
				return;
			} else {
				System.out.print("No such customer.\n");
				continue;
			}
		}
	}

	public static void deleteAddress() {
		// TODO add a check if the address is associated with customer or invoice. If it is
		// let the user decide whether he wants to purge the customers and invoices
		// associated with the address

		if (addresses.size() == 0) {
			System.out.print("No addresses in database.\n");
			return;
		}
		while (true) {
			showAddresses();
			System.out.print("Enter ID to delete an address. Leave blank to exit: ");
			long userInput = UserInputHandler.getIntegerInput(false);
			// badness due to not-so-good implementation of getIntegerInput
			if (getCustomer(0) != null) {
				if (UserInputHandler.yesNoDialogue("Delete customer 0? y/n ")) {
					customers.remove(getCustomer(0));
					System.out.print("Successfully removed invoice 0\n");
					return;
				} else {
					return;
				}
			}
			if (getCustomer(userInput) != null) {
				customers.remove(getCustomer(userInput));
				System.out.printf("Successfully removed customer %d\n", userInput);
				return;
			} else {
				System.out.print("No such customer.\n");
				continue;
			}
		}


	}

	public static void deleteArticle() {
		// TODO Auto-generated method stub

	}



}
