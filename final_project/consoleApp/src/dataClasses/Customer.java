package dataClasses;

import java.util.ArrayList;
import java.util.Date;

public class Customer {

	static public final boolean NATURAL_PERSON = true;
	static public final boolean LEGAL_PERSON = false;
	private long 				id;
	private boolean 			type;
	private Date 				dateOfCreation;
	private String 				VATID;
	private String 				nationalIdNumber;
	private String 				name;
	private String 				firstName;
	private String 				middleName;
	private String 				lastName;
	private Address				billingAddress;
	private Address 			shippingAddress;
	private ArrayList<Long> 	invoicesIDs;

	private void initialise() {
		this.invoicesIDs = new ArrayList<>();
	}

	public Customer() {
		initialise();
	}

	public Customer(long id, boolean type, Date dateOfCreation, String VATID, String nationalIdNumber, String name, String firstName, String middleName, String lastName, Address billingAddress, Address shippingAddress) {
		this.id = id;
		this.type = type;
		this.dateOfCreation = dateOfCreation;
		this.VATID = VATID;
		this.nationalIdNumber = nationalIdNumber;
		this.name = name;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
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
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public String getVATID() {
		return VATID;
	}
	public void setVATID(String VATID) {
		this.VATID = VATID;
	}
	public String getNationalIdNumber() {
		return nationalIdNumber;
	}
	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public ArrayList<Long> getInvoicesIDs() {
		return invoicesIDs;
	}

	public void setInvoicesIDs(ArrayList<Long> invoicesIDs) {
		this.invoicesIDs = invoicesIDs;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id).append(" ");
		if (type == NATURAL_PERSON) {
			sb.append(firstName).append(" ").append(lastName).append(" ");
		} else {
			sb.append(name).append(" ");
		}
		return sb.toString();
	}
	
	
}
