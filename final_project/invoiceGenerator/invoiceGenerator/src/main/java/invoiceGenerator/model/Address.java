package invoiceGenerator.model;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;

public class Address extends Identity {

	static public final boolean SHIPPING_ADDRESS = false;
	static public final boolean BILLING_ADDRESS = true;

	private Boolean					type;
	@Column(columnDefinition = "char(50)")
	private String 					city;
	@Column(columnDefinition = "char(50)")
	private String					ZIPCode;
	@Column(columnDefinition = "char(50)")
	private String					street;
	@Column(columnDefinition = "char(10)")
	private String					streetNumber;
	@Column(columnDefinition = "char(10)")
	private String					streetLetter;
	@Column(columnDefinition = "char(50)")
	private String					country;

	@OneToMany(mappedBy = "customer")
	private ArrayList<Customer>		customers;
	@OneToMany(mappedBy = "invoice")
	private ArrayList<Invoice> 		invoices;

	public Address(Boolean type, String city, String ZIPCode, String street, String streetNumber, String streetLetter, String country) {
		this.type = type;
		this.city = city;
		this.ZIPCode = ZIPCode;
		this.street = street;
		this.streetNumber = streetNumber;
		this.streetLetter = streetLetter;
		this.country = country;
	}

	public Address() {

	}

	public Boolean isType() {
		return type;
	}
	public void setType(Boolean type) {
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
	public void setInvoices(ArrayList<Invoice> invoiceIDs) {
		this.invoices = invoices;
	}
	
	
	
}
