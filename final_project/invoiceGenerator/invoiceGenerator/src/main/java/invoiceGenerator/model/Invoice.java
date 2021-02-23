package invoiceGenerator.model;

import java.time.Instant;

/**
 * 
 * @author tnebes
 * @date 6 February 2021
 */

public class Invoice extends Identity {
	
	private Instant				dateOfCreation; // not null
	private Customer			customer;
	private TransactionType 	transacationType; // not null
	private Status				status; // not null
	private Byte 				invoiceDiscountPercent;
	private Float 				subtotal;
	private Float 				amountDue;
	private Float				amountPaid; // not null
	private Address				shippingAddress;

	public Invoice() {

	}

	public Invoice(Instant dateOfCreation, Customer customer, TransactionType transcationType, Status status, Byte invoiceDiscountPercent, Float subtotal, Float amountDue, Float amountPaid, Address shippingAddress) {
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
	public Byte getInvoiceDiscountPercent() {
		return invoiceDiscountPercent;
	}
	public void setInvoiceDiscountPercent(Byte invoiceDiscountPercent) {
		this.invoiceDiscountPercent = invoiceDiscountPercent;
	}
	public Float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}
	public Float getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(Float amountDue) {
		this.amountDue = amountDue;
	}
	public Float getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Float amountPaid) {
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
		String sb = super.getId() + " " +
				dateOfCreation.toString() + " ";
		return sb;
	}
	
	

}
