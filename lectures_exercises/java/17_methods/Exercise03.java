/*
 * write a method named loadNumber() : int
 * which accepts an infinite number of inputs
 * until the user does not enter a number greater than 0
 * When that happens, method returns that number
 */

/**
 * 
 * @author tnebes
 *
 */
public class Exercise03 {

	
	public static void main(String[] args) {
		
		System.out.printf("%d\n", loadNumber());
		
	}
	
	/**
	 * Prompts the user for a number. Returns the number if the number > 0
	 * @return int
	 */
	static int loadNumber() {
		java.util.Scanner input = new java.util.Scanner(System.in);
		int number = 0;
		while (number <= 0) {
			System.out.print("Enter a number: ");
			number = input.nextInt();
		}
		return number;
	} 
	
}
