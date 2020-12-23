package edunova03;


public class Exercise01 {
	public static void main(String[] args) {
		// program writes all numbers between 20 and 200
		
		for (int i = 20; i <= 200; i++) {
			System.out.printf("%d ", i);
		}
		System.out.print("\n");
		
		// program writes all even numbers between 1 and 57
		for (int i = 2; i <= 57; i += 2) {
			System.out.printf("%d ", i);
		}
		System.out.print("\n");
		
		// program writes all numbers from 100 to 1
		for (int i = 100; i >= 1; i--) {
			System.out.printf("%d ", i);
		}
		System.out.print("\n");
		
		//program writes all odd numbers from 100 to 21
		for (int i = 99; i >= 21; i -= 2) {
			System.out.printf("%d ", i);
		}
		System.out.print("\n");
		
		// the sum of the first 100 numbers
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);
		
	}
}
