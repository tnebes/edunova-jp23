package dataHandler;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import IO.DataIO;
import IO.IDCounter;
import IO.UserInputHandler;
import consoleApp.DataClasses.Address;
import consoleApp.DataClasses.Article;
import consoleApp.DataClasses.Customer;
import consoleApp.DataClasses.Invoice;

/**
 * 
 * @author tnebes
 * @date 6 February 2021
 */

public class Controller {

	static private double DOUBLE_EPSILON = 10e-14;
	static private float FLOAT_EPSILON = 10e-7f;

	static ArrayList<Invoice> invoices = new ArrayList<>();
	static ArrayList<Customer> customers = new ArrayList<>();
	static ArrayList<Address> addresses = new ArrayList<>();
	static ArrayList<Article> articles = new ArrayList<>();

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
		Controller.invoices = invoices;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		Controller.customers = customers;
	}

	public ArrayList<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(ArrayList<Address> addresses) {
		Controller.addresses = addresses;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
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
		switch (type) {
		case 0:
			return InvoiceHandler.invoiceIdIsUnique(id);
		case 1:
			return CustomerHandler.customerIdIsUnique(id);
		case 2:
			return AddressHandler.addressIdIsUnique(id);
		case 3:
			return ArticleHandler.articleIdIsUnique(id);
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

}
