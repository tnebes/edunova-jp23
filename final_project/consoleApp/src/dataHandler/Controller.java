package dataHandler;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import IO.DataIO;
import IO.IDCounter;
import IO.UserInputHandler;
import dataClasses.*;

/**
 * 
 * @author tnebes
 * @date 6 February 2021
 */

public class Controller {

//	static private final double DOUBLE_EPSILON = 10e-14;
//	static private final float FLOAT_EPSILON = 10e-7f;

	static private ArrayList<Invoice> invoices = new ArrayList<>();
	static private ArrayList<Customer> customers = new ArrayList<>();
	static private ArrayList<Address> addresses = new ArrayList<>();
	static private ArrayList<Article> articles = new ArrayList<>();
	static private ArrayList<Status> statuses = new ArrayList<>();
	static private ArrayList<TransactionType> transactionTypes = new ArrayList<>();

	public static void initialiseData() throws FileNotFoundException {
		invoices = DataIO.getDataInvoicesFileData();
		customers = DataIO.getDataCustomersFileData();
		addresses = DataIO.getDataAddressesFileData();
		articles = DataIO.getDataArticlesFileData();
		statuses = DataIO.getDataStatusesFileData();
		transactionTypes = DataIO.getTransactionTypesFileData();
	}

	public static ArrayList<Invoice> getInvoices() {
		return invoices;
	}

	public static void setInvoices(ArrayList<Invoice> invoices) {
		Controller.invoices = invoices;
	}

	public static ArrayList<Customer> getCustomers() {
		return customers;
	}

	public static void setCustomers(ArrayList<Customer> customers) {
		Controller.customers = customers;
	}

	public static ArrayList<Address> getAddresses() {
		return addresses;
	}

	public static void setAddresses(ArrayList<Address> addresses) {
		Controller.addresses = addresses;
	}

	public static ArrayList<Article> getArticles() {
		return articles;
	}

	public static ArrayList<Status> getStatuses() {
		return statuses;
	}

	public static void setStatuses(ArrayList<Status> statuses) {
		Controller.statuses = statuses;
	}

	public static ArrayList<TransactionType> getTransactionTypes() {
		return transactionTypes;
	}

	public static void setTransactionTypes(ArrayList<TransactionType> transactionTypes) {
		Controller.transactionTypes = transactionTypes;
	}

	public static void setArticles(ArrayList<Article> articles) {
		Controller.articles = articles;
	}

	public static void addMessage() {
		System.out.print("Entering data. Fields marked * are mandatory.\n");
	}

	private static boolean idIsUnique(long id, byte type) {
		// INVOICES 0
		// CUSTOMERS 1
		// ADDRESSES 2
		// ARTICLES 3
		return switch (type) {
			case 0 -> InvoiceHandler.invoiceIdIsUnique(id);
			case 1 -> CustomerHandler.customerIdIsUnique(id);
			case 2 -> AddressHandler.addressIdIsUnique(id);
			case 3 -> ArticleHandler.articleIdIsUnique(id);
			default -> false;
		};
	}

	// FIXME update this method to be in line with the rest of the methods that use auto-generation
	// of IDs.
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
						return IDCounter.incrementInvoiceCounter();
					case 1:
						return IDCounter.incrementCustomerCounter();
					case 2:
						return IDCounter.incrementAddressCounter();
					case 3:
						return IDCounter.incrementArticleCounter();
					default:
						System.out.print("Something went wrong.");
						System.exit(1);
					}
				}
			}
		}
	}

}
