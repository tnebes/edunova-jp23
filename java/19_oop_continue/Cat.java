
public class Cat extends Animal {

	public Cat(int numberOfLegs, boolean makesSounds, String sound) {
		super(numberOfLegs, makesSounds, sound);
		
	}

	public void makeSound() {
		System.out.printf("%s\n", super.getSound());
		
	}
	
	
	
}
