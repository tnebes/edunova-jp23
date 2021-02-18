package dataClasses;

import java.time.Instant;

/**
 * 
 * @author tnebes
 * @date 6 February 2021
 */

public class Invoice {
	
	private long 				id; // not null
	private Instant				dateOfCreation; // not null
	private Customer			customer;
	private TransactionType 	transacationType; // not null
	private Status				status; // not null
	private byte 				invoiceDiscountPercent;
	private float 				subtotal;
	private float 				amountDue;
	private float				amountPaid; // not null
	private Address				shippingAddress;

	public Invoice() {

	}

	public Invoice(long id, Instant dateOfCreation, Customer customer, TransactionType transcationType, Status status, byte invoiceDiscountPercent, float subtotal, float amountDue, float amountPaid, Address shippingAddress) {
		this.id = id;
		this.dateOfCreation = dateOfCreation;
		this.customer = customer;
		this.transacationType = transcationType;
		this.status = status;
		this.invoiceDiscountPercent = invoiceDiscountPercent;
		this.subtotal = subtotal;
		this.amountDue = amountDue;
		this.amountPaid = amountPaid;
		this.shippingAddress = shippingAddress;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Instant getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Instant dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public TransactionType getTranscationTypeId() {
		return transacationType;
	}
	public void setTransacationType(TransactionType transacationType) {
		this.transacationType = transacationType;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public byte getInvoiceDiscountPercent() {
		return invoiceDiscountPercent;
	}
	public void setInvoiceDiscountPercent(byte invoiceDiscountPercent) {
		this.invoiceDiscountPercent = invoiceDiscountPercent;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public float getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(float amountDue) {
		this.amountDue = amountDue;
	}
	public float getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	@Override
	public String toString() {
		String sb = id + " " +
				dateOfCreation.toString() + " ";
		return sb;
	}
	
	

}
