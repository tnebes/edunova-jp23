package project_euler_exercises;

public class Problem004 {

	/*
	 * The following problem is taken from Project Euler.
	 * https://projecteuler.net/problem=4
	 * 
	 * Solution: 906609
	 */

	public static void main(String[] args) {

		/*
		 * Find the largest palindrome made from the product of two 3-digit numbers.
		 */

		final int NUMBER_OF_DIGITS = 3;

		int palindrome = getPalindrome(NUMBER_OF_DIGITS);
		System.out.printf("Largest palindrome produced by multiplying %d digit numbers is %d", NUMBER_OF_DIGITS,
				palindrome);
	}

	/**
	 * Method that returns the largest palindromic number produced by multiplying
	 * numbers in range 1 - (largest number derived from given number of digits).
	 * 
	 * @param digits
	 * @return (int) largest palindrome
	 */
	public static int getPalindrome(int digits) {
		int range = (int) (Math.pow(10, digits));
		int largestPalindrome = 0;
		int suspectPalindrome;

		for (int i = range - 1; i > 0; i--) {
			for (int j = range - 1; j > 0; j--) {
				suspectPalindrome = i * j;
				if (suspectPalindrome > largestPalindrome && checkPalindrome(suspectPalindrome, digits))
					largestPalindrome = suspectPalindrome;
			}
		}
		return largestPalindrome;
	}

	/**
	 * Checks whether the given number is a palindrome.
	 * 
	 * @param suspectPalindrome
	 * @param numberOfDigits
	 * @return boolean
	 */
	public static boolean checkPalindrome(int suspectPalindrome, int numberOfDigits) {

		int[] digits = new int[numberOfDigits * 2]; // very bad approximation.

		// in case the the number is smaller than 10
		if (suspectPalindrome < 10)
			return true;

		// initialising the array
		int index = 0;
		while (suspectPalindrome != 0) {
			digits[index++] = suspectPalindrome % 10;
			suspectPalindrome /= 10;
		}

		// if the array is completely filled
		// go back so that the next loop
		// does not fail
		if (index == digits.length)
			index--;
		for (int i = 0; i <= index; i++) {
			if (digits[i] != digits[index--])
				return false;
		}
		return true;
	}

}
