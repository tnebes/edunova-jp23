package edunova;

public class Exercise01 {

	public static void main(String[] args) {

		/*
		 * Program enters numbers until -1 is reached Program prints the sum of all
		 * entered numbers
		 */
		
		java.util.Random rng = new java.util.Random();
		long sum = 0;
		final int MAX_INT = Integer.MAX_VALUE / 256;
		int temp;
		
		do {
			temp = rng.nextInt(MAX_INT) - 1;
			sum += temp;
		} while (temp != -1);
		
		System.out.print(sum);
	}

}
