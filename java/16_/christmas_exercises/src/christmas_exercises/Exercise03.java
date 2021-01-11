package christmas_exercises;

public class Exercise03 {

	public static void main(String[] args) {

		/*
		 * Program writes all the prime numbers between two input integers.
		 */

		// input
		java.util.Scanner input = new java.util.Scanner(System.in);
		int firstInteger, secondInteger;
		System.out.print("Please enter first integer: ");
		firstInteger = input.nextInt();
		System.out.print("Please enter second integer: ");
		secondInteger = input.nextInt();
		input.close();

		// validating input
		if (firstInteger > secondInteger) {
			int temp = firstInteger;
			firstInteger = secondInteger;
			secondInteger = temp;
		}

		// collecting primes
		int[] primes = new int[Math.abs(secondInteger - firstInteger) + 1];
		int primeIndex = 0, startInteger;
		if (firstInteger < 0)
			startInteger = 1;
		else
			startInteger = firstInteger;
		boolean isPrime;
		for (int i = startInteger + 1; i < secondInteger; i++) {
			isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			// 1 is not a prime number
			if (isPrime && i != 1)
				primes[primeIndex++] = i;
		}

		// printing primes
		System.out.printf("%d prime numbers between %d and %d are:\n", primeIndex, firstInteger, secondInteger);
		for (int prime : primes) {
			if (prime == 0)
				break;
			System.out.printf("%d ", prime);
		}
	}
	
}
