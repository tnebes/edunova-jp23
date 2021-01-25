
abstract public class Animal {

	private int numberOfLegs;
	private boolean makesSounds;
	private String sound;
	
	public Animal(int numberOfLegs, boolean makesSounds, String sound) {
		super();
		this.numberOfLegs = numberOfLegs;
		this.makesSounds = makesSounds;
		this.sound = sound;
	}
	
	public int getNumberOfLegs() {
		return numberOfLegs;
	}
	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}
	public boolean isMakesSounds() {
		return makesSounds;
	}
	public void setMakesSounds(boolean makesSounds) {
		this.makesSounds = makesSounds;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	
	
	
}
