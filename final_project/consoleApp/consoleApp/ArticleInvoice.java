package consoleApp;

import java.util.Date;

public class ArticleInvoice {

	private long id;
	private Date dateOfCreation;
	private long articleId;
	private long invoiceId;
	private byte discount;
	private long quantity;
	private float wholesalePrice;
	private float retailPrice;
	private byte taxRate;
	private String note;
	
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
	public long getArticleId() {
		return articleId;
	}
	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}
	public long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}
	public byte getDiscount() {
		return discount;
	}
	public void setDiscount(byte discount) {
		this.discount = discount;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public float getWholesalePrice() {
		return wholesalePrice;
	}
	public void setWholesalePrice(float wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}
	public float getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(float retailPrice) {
		this.retailPrice = retailPrice;
	}
	public byte getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(byte taxRate) {
		this.taxRate = taxRate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
