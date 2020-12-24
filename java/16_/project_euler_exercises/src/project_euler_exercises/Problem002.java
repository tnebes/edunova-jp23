package project_euler_exercises;

/*
 * The following problem is taken from Project Euler.
 * https://projecteuler.net/problem=2
 */

public class Problem002 {
	
	public static void main(String[] args) {
		
		/*
		 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
		 * find the sum of the even-valued terms.
		 */
		int[] fibonacciSequence = {1, 2};
		
		int sum = 2, currentNumber = 0;
		
		while (currentNumber < 4000000) {
			currentNumber = fibonacciSequence[0] + fibonacciSequence[1];
			if (currentNumber % 2 == 0) {
				sum += currentNumber;
			}
			fibonacciSequence[0] = fibonacciSequence[1];
			fibonacciSequence[1] = currentNumber;

		}
		System.out.printf("Sum of all even-valued Fibonacci sequences is %d", sum);
	}

}
