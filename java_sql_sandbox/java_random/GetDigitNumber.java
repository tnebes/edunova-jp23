/**
 * Input is an integer and the position of the desired digit. Program returns
 * the digit as position defined by user.
 * 
 * @author tnebes
 *
 */

public class GetDigitNumber {

	static java.util.Scanner input = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		int number = getNumber();
		int numberOfDigits = getDigits(number);
		int desiredDigit;
		do {
			desiredDigit = getUserDigit();
		} while (!userInputValid(numberOfDigits, desiredDigit));
		input.close(); // input can finally be closed.
		int theDigit = getDesiredDigit(number, numberOfDigits, desiredDigit);
		System.out.printf("The digit at position %d is: %d\n", desiredDigit, theDigit);
	}

	/**
	 * Method sanitises output. Returns the number.
	 * 
	 * @return int
	 */
	public static int getNumber() {
		System.out.print("Please enter a number: ");
		int number;
		try {
			number = Integer.parseInt(input.nextLine());
		} catch (Exception InputMismatchException) {
			System.out.print("Error. Please enter an integer.\n");
			number = getNumber();
		}
		return Math.abs(number);
	}

	/**
	 * Method returns the number of digits in an int.
	 * 
	 * @param number
	 * @return int
	 */
	public static int getDigits(int number) {
		int numberOfDigits = 0;
		while (number != 0) {
			number /= 10;
			numberOfDigits++;
		}
		return numberOfDigits;
	}

	/**
	 * Method returns the sanitised version of the desired user input.
	 * 
	 * @return int
	 */
	public static int getUserDigit() {
		System.out.print("Print digit at position: ");
		int digit;
		try {
			digit = Integer.parseInt(input.nextLine());
		} catch (Exception InputMismatchException) {
			System.out.print("Error. Please enter an integer.\n");
			digit = getUserDigit();
		}
		return digit;
	}

	/**
	 * Method checks whether the user has entered an acceptable digit position
	 * 
	 * @param numberOfDigits
	 * @param desiredDigit
	 * @return boolean
	 */
	public static boolean userInputValid(int numberOfDigits, int desiredDigit) {
		if (desiredDigit == 0) {
			System.out.print("Digit must start from 1 or -1\n");
			return false;
		} else if (Math.abs(desiredDigit) > numberOfDigits) {
			System.out.print("Desired digit must exist.\n");
			return false;
		}
		return true;
	}

	/**
	 * Method returns the digit as the position specified by the user.
	 * 
	 * @param number
	 * @param numberOfDigits
	 * @param desiredDigit
	 * @return int
	 */
	public static int getDesiredDigit(int number, int numberOfDigits, int desiredDigit) {
		int numberOfDivisions = 0;
		int userDigit = 0;
		if (desiredDigit < 0) {
			numberOfDivisions = Math.abs(desiredDigit) - 1;
		} else {
			numberOfDivisions = numberOfDigits - desiredDigit;
		}
		if (numberOfDivisions == 0) {
			userDigit = number % 10;
		} else {
			while (numberOfDivisions > 0) {
				number /= 10;
				userDigit = number % 10;
				numberOfDivisions--;
			}
		}

		return userDigit;
	}

}
