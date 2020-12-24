package christmas_exercises;

public class Exercise02 {
	
	public static void main(String[] args) {

		/*
		 * Program writes a multiplication table for the first 15 numbers.
		 */

		final int TABLE_SIZE = 15;

		for (int i = 1; i <= TABLE_SIZE; i++) {
			for (int j = 1; j <= TABLE_SIZE; j++) {
				System.out.printf("%5d", i * j);
				if (j == 1) {
					System.out.print("|");
				}
			}
			if (i == 1) {
				System.out.print("\n");
				for (int k = 0; k < TABLE_SIZE * 5; k++) {
					System.out.print("-");
				}
			}
			System.out.print("\n");
		}
	}
	
}
