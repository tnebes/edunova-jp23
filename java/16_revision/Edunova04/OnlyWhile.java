public class OnlyWhile {

	public static void main(String[] args) {
		final int MAX = 5;
		int counter0 = 0, counter1 = 1;
		while (counter0 < MAX) {
			counter0++;
			counter1 = 1;
			while (counter1 <= MAX) {
				System.out.printf("%4d", counter0 * counter1++);
			}
			System.out.print("\n");

		}

	}

}
