package christmas_exercises;

public class Exercise01 {
	public static void main(String[] args) {

		/*
		 * Program receives 24 numbers Outputs their sum the smallest and the largest
		 * number
		 */

		final int NUMBER_OF_NUMBERS = 24;
		java.util.Random rng = new java.util.Random();

		int[] numbers = new int[NUMBER_OF_NUMBERS];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rng.nextInt(Math.abs(Integer.MAX_VALUE / 256));
		}

		int sum = 0, smallest = Integer.MAX_VALUE, largest = 0;

		for (int number : numbers) {
			sum += number;
			if (number > largest)
				largest = number;
			if (smallest > number)
				smallest = number;
		}
		System.out.printf("Sum of numbers is: %d\nLargest number is %d\nSmallest number is %d.", sum, largest, smallest);
	}
	
}
