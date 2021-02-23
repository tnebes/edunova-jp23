package invoiceGenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * 
 * @author tnebes
 * @date 6 February 2021
 */

@Entity(name = "invoice")
public class Invoice extends Identity {

	@Column(name = "date_of_creation", nullable = false)
	private Instant				dateOfCreation; // not null

	@ManyToOne(targetEntity = Customer.class)
	private Customer			customer;

	@ManyToOne
	private TransactionType 	transactionType; // not null

	@ManyToOne
	private Status				status; // not null

	@Column(name = "invoice_discount_percent")
	private Byte 				invoiceDiscountPercent;

	private BigDecimal			subtotal;

	@Column(name = "amount_due")
	private BigDecimal			amountDue;

	@Column(name = "amount_paid")
	private BigDecimal			amountPaid; // not null

	@ManyToOne
	private Address				shippingAddress;

	@Column(name = "article_invoice")
	@OneToMany(mappedBy = "invoice")
	List<ArticleInvoice> articleInvoice;

	public Invoice() {

	}

	public Invoice(Instant dateOfCreation, Customer customer, TransactionType transactionType,
				   Status status, Byte invoiceDiscountPercent, BigDecimal subtotal,
				   BigDecimal amountDue, BigDecimal amountPaid, Address shippingAddress) {
		this.dateOfCreation = dateOfCreation;
//		this.customer = customer;
		this.transactionType = transactionType;
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
//	public Customer getCustomer() {
//		return customer;
//	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	public TransactionType getTransactionTypeId() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
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
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public BigDecimal getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}
	public BigDecimal getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(BigDecimal amountPaid) {
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
