package project_euler_exercises;

/*
 * The following problem is taken from Project Euler.
 * https://projecteuler.net/problem=1
 */

public class Problem001 {

	public static void main(String[] args) {

		/*
		 * Find the sum of all the multiples of 3 or 5 below 1000.
		 * solution: 233168
		 */
		
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		System.out.printf("The sum of all multiples of 3 or 5 is: %d", sum);
		
	}

}
