package edunova.polymorphism.stage;

public class Attendee extends Person {

	private String contractNumber;
	
	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "Ja sam " + getName() + ", moj broj ugovora je " + getContractNumber();
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	
	
}
