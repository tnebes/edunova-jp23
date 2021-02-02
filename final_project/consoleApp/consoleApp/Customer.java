package consoleApp;

import java.util.Date;

public class Customer {

	static private final boolean NATURAL_PERSON = true;
	static private final boolean LEGAL_PERSON = false;
	private long id;
	private boolean type;
	private Date dateOfCreation;
	private String VATID;
	private String nationalIdNumber;
	private String name;
	private String firstName;
	private String middleName;
	private String lastName;
	private long billingAddressId;
	private long shippingAddressId;
	
	
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
	public long getBillingAddressId() {
		return billingAddressId;
	}
	public void setBillingAddressId(long billingAddressId) {
		this.billingAddressId = billingAddressId;
	}
	public long getShippingAddressId() {
		return shippingAddressId;
	}
	public void setShippingAddressId(long shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}
	
	
	
	
}
