package edunova03;

public class Exercise02 {

	// program gives 2 ints
	// program writes OK if the sum of all the odd ints between the two ints are
	// greater than 1000

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);

		System.out.print("Enter number 1: ");
		int integer1 = input.nextInt();
		System.out.print("Enter number 2: ");
		int integer2 = input.nextInt();
		
		int sum = 0;
		for (int i = integer1; i < integer2; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
			
		System.out.printf("%s. Sum is %d.\n", sum > 100 ? "OK" : "Not OK", sum);
		
		input.close();
	}

}
