package dataClasses;

import java.util.ArrayList;

public class Address {

	static public final boolean SHIPPING_ADDRESS = false;
	static public final boolean BILLING_ADDRESS = true;
	
	private long 					id;
	private boolean					type;
	private String 					city;
	private String					ZIPCode;
	private String					street;
	private String					streetNumber;
	private String					streetLetter;
	private String					country;

	private ArrayList<Long> 		customerIDs;
	private ArrayList<Long> 		invoiceIDs;

	public Address(long id, boolean type, String city, String ZIPCode, String street, String streetNumber, String streetLetter, String country) {
		this.id = id;
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
	public ArrayList<Long> getCustomerIDs() {
		return customerIDs;
	}
	public void setCustomerIDs(ArrayList<Long> customerIDs) {
		this.customerIDs = customerIDs;
	}
	public ArrayList<Long> getInvoiceIDs() {
		return invoiceIDs;
	}
	public void setInvoiceIDs(ArrayList<Long> invoiceIDs) {
		this.invoiceIDs = invoiceIDs;
	}
	
	
	
}
