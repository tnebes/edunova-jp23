package christmas_exercises;

public class Exercise01Alt {
	public static void main(String[] args) {

		/*
		 * Program receives 24 numbers Outputs their sum the smallest and the largest
		 * number
		 * 
		 * removed all for loops and uses while
		 * 
		 */

		final int NUMBER_OF_NUMBERS = 24;
		java.util.Random rng = new java.util.Random();

		int[] numbers = new int[NUMBER_OF_NUMBERS];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rng.nextInt(Math.abs(Integer.MAX_VALUE / 256));
		}

		int sum = 0, smallest = numbers[0], largest = 0;

		int i = 0;
		while (i < numbers.length) {
			sum += numbers[i];
			if (numbers[i] > largest)
				largest = numbers[i];
			if (smallest > numbers[i])
				smallest = numbers[i];
			i++;
		}
		
		System.out.printf("Sum of numbers is: %d\nLargest number is %d\nSmallest number is %d.", sum, largest, smallest);
	}
	
}
