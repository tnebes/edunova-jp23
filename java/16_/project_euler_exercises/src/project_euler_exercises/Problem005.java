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
		final int LARGEST_NUMBER = 20;
		long smallestNumber = leastCommonMultiple(STARTING_NUMBER, LARGEST_NUMBER);
		System.out.printf("Smallest positive number divisible by all the numbers from 1 to %d is %d\n", LARGEST_NUMBER,
				smallestNumber);

	}

	private static long greatestCommonDivisor(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}

	private static long greatestCommonDivisor(long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = greatestCommonDivisor(result, input[i]);
	    return result;
	}
	
	private static long leastCommonMultiple(long a, long b)
	{
	    return a * (b / greatestCommonDivisor(a, b));
	}

	private static long leastCommonMultiple(long[] input)
	{
	    long result = input[0];
	    for(int i = 1; i < input.length; i++) result = leastCommonMultiple(result, input[i]);
	    return result;
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
