package edunova02;

import javax.swing.*;

public class Exercise05 {

	public static void main(String[] args) {
		// user enters number
		// if even write Osijek
		// if odd write Zagreb

		int number = Integer.parseInt(JOptionPane.showInputDialog("Please enter whole number"));
		System.out.printf("%s\n", number % 2 == 0 ? "Osijek" : "Zagreb");

	}

}
