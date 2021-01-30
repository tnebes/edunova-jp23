package edunova.polymorphism.stage;

public abstract class Person {
	
	private String name;
	public abstract String getGreeting();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
