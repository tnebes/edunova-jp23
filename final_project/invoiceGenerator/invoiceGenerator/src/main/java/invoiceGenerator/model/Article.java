package invoiceGenerator.model;

public class Article extends Identity {

	static public final byte STANDARD_TAX_RATE = 25;

	private String		warehouseLocation; // not null
	private Long 		warehouseQuantity; // not null
	private Float 		wholesalePrice; // not null
	private Float 		retailPrice;
	private Byte 		taxRate;
	private String 		shortName; // not null
	private String 		longName;
	private String 		shortDescription;
	private String 		longDescription;

	public Article() {

	}

	public Article(String warehouseLocation, Long warehouseQuantity, Float wholesalePrice, Float retailPrice, Byte taxRate, String shortName, String longName, String shortDescription, String longDescription) {
		this.warehouseLocation = warehouseLocation;
		this.warehouseQuantity = warehouseQuantity;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.taxRate = taxRate;
		this.shortName = shortName;
		this.longName = longName;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public String getWarehouseLocation() {
		return warehouseLocation;
	}
	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}
	public Long getWarehouseQuantity() {
		return warehouseQuantity;
	}
	public void setWarehouseQuantity(Long warehouseQuantity) {
		this.warehouseQuantity = warehouseQuantity;
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
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

}
