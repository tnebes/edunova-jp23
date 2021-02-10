package dataClasses;

import java.util.ArrayList;

public class Address {

	static public final boolean SHIPPING_ADDRESS = true;
	static public final boolean BILLING_ADDRESS = false;
	
	private long 						id;
	private boolean					type;
	private String 					city;
	private String						ZIPCode;
	private String						street;
	private String						streetNumber;
	private String						streetLetter;
	private String						country;
	private ArrayList<Customer>	customers;
	private ArrayList<Invoice>		invoices;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZIPCode() {
		return ZIPCode;
	}
	public void setZIPCode(String ZIPCode) {
		this.ZIPCode = ZIPCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetLetter() {
		return streetLetter;
	}
	public void setStreetLetter(String streetLetter) {
		this.streetLetter = streetLetter;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(ArrayList<Invoice> invoices) {
		this.invoices = invoices;
	}
	
	
	
}
