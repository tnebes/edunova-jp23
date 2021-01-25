package examples;

public class Lecturer extends Person {

	public Lecturer(String name, String lastName, String iBAN) {
		super(name, lastName);
		IBAN = iBAN;
	}

	private String IBAN;

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String IBAN) {
		this.IBAN = IBAN;
	}
	
	
	
}
