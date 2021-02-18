package dataClasses;

import IO.IDCounter;

import java.util.ArrayList;

public class TransactionType {

	private byte 				id;
	private String 				name;
	private String 				description;
	private ArrayList<Invoice> 	invoices;

	public TransactionType() {
		this(IDCounter.incrementTransactionTypeCounter(), "default", "default");
	}

	public TransactionType(byte id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
		initialise();
	}

	private void initialise() {
		this.invoices = new ArrayList<>();
	}

	public byte getId() {
		return id;
	}
	public void setId(byte id) {
		this.id = id;
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
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
