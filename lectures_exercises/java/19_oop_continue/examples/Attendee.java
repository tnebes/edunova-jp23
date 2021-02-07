package examples;

public class Attendee extends Person {
	private int status;

	private String contractNumber;
	
	public Attendee() {
		
	}
	
	public Attendee(String name, String lastName, String contractNumber) {
		super(name, lastName);
		this.contractNumber = contractNumber;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		super.status = 1; // visible because it's protected
		this.status = 2; // visible because it's in the same class
		this.contractNumber = contractNumber;
	}
	
	
}
