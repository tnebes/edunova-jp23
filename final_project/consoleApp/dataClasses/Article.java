package dataClasses;

public class Article {

	static public final byte STANDARD_TAX_RATE = 25;
	
	private long 		id; // not null
	private String		warehouseLocation; // not null
	private long 		warehouseQuantity; // not null
	private float 		wholesalePrice; // not null
	private float 		retailPrice;
	private byte 		taxRate;
	private String 	shortName; // not null
	private String 	longName;
	private String 	shortDescription;
	private String 	longDescription;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getWarehouseLocation() {
		return warehouseLocation;
	}
	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}
	public long getWarehouseQuantity() {
		return warehouseQuantity;
	}
	public void setWarehouseQuantity(long warehouseQuantity) {
		this.warehouseQuantity = warehouseQuantity;
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
