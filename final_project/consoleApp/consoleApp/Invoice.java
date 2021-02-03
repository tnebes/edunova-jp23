package consoleApp;

import java.util.Date;

public class Invoice {
	
	private long 	id;
	private Date 	dateOfCreation;
	private long 	customerId;
	private byte 	transcationTypeId;
	private byte 	statusId;
	private byte 	invoiceDiscountPercent;
	private float 	subtotal;
	private float 	amountDue;
	private float	amountPaid;
	private long 	shippingAddressId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public byte getTranscationTypeId() {
		return transcationTypeId;
	}
	public void setTranscationTypeId(byte transcationTypeId) {
		this.transcationTypeId = transcationTypeId;
	}
	public byte getStatusId() {
		return statusId;
	}
	public void setStatusId(byte statusId) {
		this.statusId = statusId;
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
	public long getShippingAddressId() {
		return shippingAddressId;
	}
	public void setShippingAddressId(long shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}
	
	

}
