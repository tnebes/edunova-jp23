package consoleApp;
import java.util.ArrayList;
import java.util.Date;

public class DataHandler {
	
	static private ArrayList<Invoice> invoices = new ArrayList<>();
	static private ArrayList<Customer> customers = new ArrayList<>();
	static private ArrayList<Address> addresses = new ArrayList<>();
	static private ArrayList<Article> articles = new ArrayList<>();	
	

	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(ArrayList<Invoice> invoices) {
		this.invoices = invoices;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(ArrayList<Address> addresses) {
		this.addresses = addresses;
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
		this.articles = articles;
	}

	public static void addMessage() {
		System.out.print("Entering data. Fields marked * are mandatory.\n");
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
	

	public static long getId(byte type) {
		long id;
		while (true) {
			id = UserInputHandler.getIntegerInput(true);
			if (idIsUnique(id, type)) {
				return id;
			} else {
				System.out.print("ID not unique. Enter new id: ");
				continue;
			}
		}
	}
	
	public static void addInvoice() {
		Invoice newInvoice = new Invoice();
		System.out.print("* Please enter unique invoice ID: ");
		newInvoice.setId(getId((byte) 0));
		newInvoice.setDateOfCreation(new Date(System.currentTimeMillis()));
		System.out.print("Please enter customer ID or name: ");
		
		newInvoice.setCustomerId(customerId);
		
	}

	public static void addCustomer() {
		// TODO Auto-generated method stub
		
	}

	public static void addAddress() {
		// TODO Auto-generated method stub
		
	}

	public static void addArticle() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	public static void deleteCustomer() {
		// TODO Auto-generated method stub
		
	}

	public static void deleteAddress() {
		// TODO Auto-generated method stub
		
	}

	public static void deleteArticle() {
		// TODO Auto-generated method stub
		
	}

	
	
}
