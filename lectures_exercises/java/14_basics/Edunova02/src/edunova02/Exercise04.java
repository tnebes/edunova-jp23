package edunova02;

import javax.swing.*;

public class Exercise04 {

	public static void main(String[] args) {

		// user enters 3 whole numbers
		// program returns biggest

		int number1, number2, number3;

		number1 = Integer.parseInt(JOptionPane.showInputDialog("Please enter first whole number"));
		number2 = Integer.parseInt(JOptionPane.showInputDialog("Please enter second whole number"));
		number3 = Integer.parseInt(JOptionPane.showInputDialog("Please enter third whole number"));

		if (number1 >= number2) {
			System.out.println(number1);
		} else if (number2 >= number3) {
			System.out.println(number2);
		} else {
			System.out.println(number3);
		}

		boolean showoff = true;

		if (showoff) {
			int[] numbers = new int[3];
			numbers[0] = number1;
			numbers[1] = number2;
			numbers[2] = number3;

			int temp = 0;
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] > temp) {
					temp = numbers[i];
				}
			}
			System.out.println(temp);
		}

	}

}
