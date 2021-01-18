
public class Exercise02 {

	public static void main(String[] args) {
		
		/*
		 * program receives 2 numbers from user
		 * program writes the difference as a result
		 * of a method call that accepts two float parameters
		 */
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		float minuend, subtrahend;
		
		System.out.print("Enter two floats: ");
		minuend = input.nextFloat();
		subtrahend = input.nextFloat();
		System.out.printf("%f\n", reduce(minuend, subtrahend));
	
		
	}
	
	static float reduce(float x, float y) {
		return x - y;
	}
	
}
