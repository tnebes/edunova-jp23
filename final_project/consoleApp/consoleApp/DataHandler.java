package consoleApp;
import java.util.ArrayList;
import java.util.Date;

public class DataHandler {
	
	static private ArrayList<Invoice> invoices = new ArrayList<>();
	static private ArrayList<Customer> customers = new ArrayList<>();
	static private ArrayList<Address> addresses = new ArrayList<>();
	static private ArrayList<Article> articles = new ArrayList<>();	
	
	/* TODO
	 * load file
	 * if file loads
	 * populate arraylist
	 * print it out
	 */
	
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
	
	public static void showInvoice(Invoice invoice) {
		StringBuilder sb = new StringBuilder();
		sb.append(invoice.getId()).append(" ");
		showCustomer(findCustomer(invoice.getCustomerId()));
		sb.append(" ").append(invoice.getDateOfCreation().toString());
		System.out.print(sb.toString());
	}
	
	private static void showCustomer(Customer customer) {
		StringBuilder sb = new StringBuilder();
		if (customer.isType() == Customer.NATURAL_PERSON) {
			sb.append(customer.getId()).append(" ");
			sb.append(customer.getNationalIdNumber()).append(" ");
			sb.append(customer.getFirstName()).append(" ");
			sb.append(customer.getMiddleName()).append(" ");
			sb.append(customer.getLastName()).append(" ");
			System.out.print(sb.toString());
		} else {
			sb.append(customer.getId()).append(" ");
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
		sb.append(article.getLongName()).append(" ");
		sb.append(article.getShortName()).append(" ");
		sb.append(article.getWarehouseLocation()).append(" ");
		sb.append(article.getWarehouseQuantity()).append(" ");
		sb.append(article.getRetailPrice());
		System.out.print(sb.toString());
		
	}
	
	private static Customer findCustomer(long id) {
		for (Customer customer : customers) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		System.out.printf("Customer with id %d not found!\n", id);
		return null;
	}

	public static void showInvoices() {
		for (Invoice invoice : invoices) {
			showInvoice(invoice);
			System.out.print("\n");
		}
	}

	public static void showCustomers() {
		for (Customer customer : customers) {
			showCustomer(customer);
			System.out.print("\n");
		}
	}
	
	public static void showAddresses() {
		for (Address address : addresses) {
			showAddress(address);
			System.out.print("\n");
		}		
	}

	public static void showArticles() {
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
		// TODO
		newInvoice.setStatusId((byte) -1);
		// TODO
		newInvoice.setTranscationTypeId((byte) -1);
		// TODO customer id by searching through names or providing id
		newInvoice.setCustomerId(-1);
		if (!(UI.yesNoDialogue("Has shipping address? "))) {
			newInvoice.setShippingAddressId(-1);
		} else {
//			addAddress();
//			newInvoice.setShippingAddressId(addresses.get(addresses.size() - 1).getId());
		}
		invoices.add(newInvoice);
		System.out.printf("Successfully added invoice ", newInvoice.getId());
		showInvoice(newInvoice);
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
