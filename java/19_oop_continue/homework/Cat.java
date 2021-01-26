package homework;

public class Cat extends Animal {

	public Cat(int numberOfLegs, boolean makesSounds, String sound) {
		super(numberOfLegs, makesSounds, sound);
		
	}
	
	public Cat() {
		
	}

	public void makeSound() {
		System.out.printf("%s\n", super.getSound());
		
	}
	
	
	
}
