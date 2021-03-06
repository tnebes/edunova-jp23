package project_euler_exercises;

/*
 * The following problem is taken from Project Euler.
 * https://projecteuler.net/problem=3
 */

public class Problem003 {

	public static void main(String[] args) {
		/*
		 * What is the largest prime factor of the number 600851475143 ? Solution: 6857
		 */

		final long NUMBER = 600851475143L;
		System.out.printf("The largest prime factor of %d is %d\n", NUMBER, largestPrimeFactor(NUMBER));
	}

	/**
	 * Returns the largest prime factor of a given number
	 * 
	 * @param number
	 * @return
	 */
	public static long largestPrimeFactor(long number) {
		long largest_prime_factor = -1L;

		// a prime number > 2 cannot be even
		while (number % 2 == 0) {
			// divide it by 2 in that case until we reach an odd number
			largest_prime_factor = 2;
			number >>= 1;
		}

		//
		for (int i = 3; i <= Math.sqrt(number); i += 2) {
			while (number % i == 0) {
				largest_prime_factor = i;
				number /= i;
			}
		}

		if (number > 2)
			largest_prime_factor = number;

		return largest_prime_factor;
	}

}
