package project_euler_exercises;

public class Problem001 {

	public static void main(String[] args) {

		/*
		 *If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
		 *
		 *Find the sum of all the multiples of 3 or 5 below 1000.
		 */
		
		for (int i = 1; i < 1000 / 5; i++) {
			System.out.printf("%d %d\n", i * 3, i * 5);
		}		
	}

}
