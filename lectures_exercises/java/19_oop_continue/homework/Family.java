package homework;

public class Family extends Order {
	
	private String FamilyName;
	private boolean bearsNuts;
	private Order order;
	
	public Family() {
		
	}
	
	public Family(Order order) {
		this.order = order;
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getFamilyName() {
		return FamilyName;
	}
	public void setFamilyName(String familyName) {
		FamilyName = familyName;
	}
	public boolean isBearsNuts() {
		return bearsNuts;
	}
	public void setBearsNuts(boolean bearsNuts) {
		this.bearsNuts = bearsNuts;
	}
	
	

}
