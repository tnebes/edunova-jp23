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

		final int LARGEST_NUMBER = 20;
		long smallestNumber = smallestNumberDivisible(20);
		System.out.printf("Smallest positive number divisible by all the numbers from 1 to %d is %d", LARGEST_NUMBER,
				smallestNumber);

	}

	
	public static long smallestNumberDivisible(int largest_number) {
		
		/*
		 * Finding the lowest common multiple of n numbers can be solved by using
		 * the greatest common divisor.
		 */	
		
		return 0;
	}
	
	/**
	 * Slow method of finding the number.
	 * @param largestNumber
	 * @return
	 */
	/*
	public static long smallestNumberDivisible(int largestNumber) {
		boolean smallestFound = false;
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			System.out.printf("%d\n", i);
			long smallestNumber = largestNumber * i;
			for (int j = 2; j < 20; j++) {
				if (smallestNumber % j != 0)
					break;
			}
			if (smallestFound)
				return smallestNumber;
		}
		return -1;
	}
	*/

}
