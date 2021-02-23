package invoiceGenerator.model;

import java.time.Instant;

public class ArticleInvoice extends Identity {

	private Instant dateOfCreation;
	private Long 	articleId;
	private Long 	invoiceId;
	private Byte 	discount;
	private Long 	quantity;
	private Float 	wholesalePrice;
	private Float 	retailPrice;
	private Byte 	taxRate;
	private String 	note;
	
	public Instant getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Instant dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}
	public Long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Byte getDiscount() {
		return discount;
	}
	public void setDiscount(Byte discount) {
		this.discount = discount;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public Float getWholesalePrice() {
		return wholesalePrice;
	}
	public void setWholesalePrice(Float wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}
	public Float getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(Float retailPrice) {
		this.retailPrice = retailPrice;
	}
	public Byte getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(Byte taxRate) {
		this.taxRate = taxRate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
