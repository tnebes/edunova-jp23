/*
 * Create method sum(int[]) : int
 */

public class Exercise04 {

	public static void main(String[] args) {

		java.util.Random rng = new java.util.Random();
		int[] myArray = new int[4];
		do {
			for (int i = 0; i < myArray.length; i++) {
				myArray[i] = rng.nextInt(10);
			}
		} while (sum(myArray) != 14);
		for (int i = 0; i < myArray.length; i++) {
			System.out.printf("%d ", myArray[i]);
		}
		System.out.print("Found!\n");

	}

	static int sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

}
