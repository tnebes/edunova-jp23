package edunova.crud;

public class Lecturer {
	
	private String firstName;
	private String lastName;
	private String IBAN;
	
	public Lecturer() {
		
	}
	
	public Lecturer(String firstName, String lastName, String iBAN) {
		this.firstName = firstName;
		this.lastName = lastName;
		IBAN = iBAN;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("first name: ");
		sb.append(firstName);
		sb.append(" last name: ");
		sb.append(lastName);
		sb.append(" IBAN: ");
		sb.append(IBAN);
		return sb.toString();
	}


}
