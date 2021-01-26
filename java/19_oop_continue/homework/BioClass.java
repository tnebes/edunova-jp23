package homework;

public class BioClass extends Kingdom {

	private String className;
	private int maxNumOfPodes;
	private Kingdom kingdom;
	
	public BioClass() {
		
	}
	
	public BioClass(Kingdom kingdom) {
		this.kingdom = kingdom;
	}
	
	public Kingdom getKingdom() {
		return kingdom;
	}
	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getMaxNumOfPodes() {
		return maxNumOfPodes;
	}
	public void setMaxNumOfPodes(int max_num_of_podes) {
		this.maxNumOfPodes = max_num_of_podes;
	}

	

	
}
