package homework;

public class Order extends BioClass {

	private String orderName;
	boolean hasFeathers;
	private BioClass bioClass;
	
	public Order() {
		
	}
	
	public Order(BioClass bioClass) {
		this.bioClass = bioClass;
	}
	
	public BioClass getBioClass() {
		return bioClass;
	}
	public void setBioClass(BioClass bioClass) {
		this.bioClass = bioClass;
	}
	
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public boolean isHasFeathers() {
		return hasFeathers;
	}
	public void setHasFeathers(boolean hasFeathers) {
		this.hasFeathers = hasFeathers;
	}
	
	
	
}
