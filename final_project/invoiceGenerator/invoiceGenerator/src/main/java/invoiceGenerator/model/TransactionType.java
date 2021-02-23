package invoiceGenerator.model;

import java.util.ArrayList;

public class TransactionType extends Identity {

	private String 				name;
	private String 				description;
	private ArrayList<Invoice> 	invoices;

	public TransactionType() {
		// this(IDCounter.incrementTransactionTypeCounter(), "default", "default");
	}

	public TransactionType(String name, String description) {
		this.name = name;
		this.description = description;
		initialise();
	}

	private void initialise() {
		this.invoices = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(ArrayList<Invoice> invoices) {
		this.invoices = invoices;
	}

	@Override
	public String toString() {
		return "TransactionType{" +
				"id=" + super.getId() +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
