package project_euler_exercises;

public class Problem005 {

	/*
	 * The following problem is taken from Project Euler.
	 * https://projecteuler.net/problem=5
	 * 
	 * Solution: 232792560
	 */

	public static void main(String[] args) {
		// What is the smallest positive number that is evenly divisible by all of the
		// numbers from 1 to 20?
		

		final int STARTING_NUMBER = 1;
		final int END_NUMBER = 20;
		long smallestNumber = smallestDivisibleNumber(STARTING_NUMBER, END_NUMBER);
		System.out.printf("Smallest positive number divisible by all the numbers from %d to %d is %d\n", STARTING_NUMBER, END_NUMBER,
				smallestNumber);

	}

	public static long smallestDivisibleNumber(int startingNumber, int endNumber) {
		int[] range = new int[(endNumber - startingNumber) + 1];
		for (int i = 0; i < range.length; i++) {
			range[i] = startingNumber++;
		}
		
		return lowestCommonMultiple(range);
	}
	
	public static long lowestCommonMultiple(int[] range) {
		long result = range[0];
		for (int i = 1; i < range.length; i++) {
			result = lowestCommonMultiple(result, range[i]);
		}
		return result;
	}
	 
	public static long lowestCommonMultiple(long firstNumber, long secondNumber) {
		return firstNumber * (secondNumber / greatestCommonDivisor(firstNumber, secondNumber));
	}
	
	public static long greatestCommonDivisor(long firstNumber, long secondNumber) {
		while (secondNumber > 0) {
			long temp = secondNumber;
			secondNumber = firstNumber % secondNumber;
			firstNumber = temp;
		}
		return firstNumber;
	}
	
	/**
	 * Slow method of finding the number. I don't even know if it works.
	 * 
	 * @param largestNumber
	 * @return
	 */
	/*
	 * public static long smallestNumberDivisible(int largestNumber) {
	 * 	boolean smallestFound = false;
	 * 	for (int i = 1; i < Integer.MAX_VALUE; i++) {
	 * 		System.out.printf("%d\n", i);
	 * 		long smallestNumber = largestNumber * i;
	 * 		for (int j = 2; j < 20; j++) {
	 * 			if (smallestNumber % j != 0)
	 * 				break;
	 * 		}
	 * 		if (smallestFound)
	 * 			return smallestNumber; 
	 * 		}
	 * 		return -1;
	 * }
	 */

}
