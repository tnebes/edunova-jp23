package edunova;

public class Exercise02 {

	public static void main(String[] args) {
		/*
		 * USE A WHILE LOOP
		 * write all even numbers from 10 to 50
		 */
		
		final int MIN = 10;
		final int MAX = 50;
		int myInt = MIN;
		while (myInt <= MAX) {
			if (myInt %2 != 0) {
				myInt++;
				continue;
			}
			else
				System.out.printf("%d ", myInt++);
		}
		

	}

}
