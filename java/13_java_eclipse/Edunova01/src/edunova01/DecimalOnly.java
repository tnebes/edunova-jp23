package edunova01;
import javax.swing.*;


public class DecimalOnly {
	
	public static void main(String[] args) {

		/*
		 * user enters decimal number, receives int from input
		 * user receives the numbers after the dot
		 * \\. is used because in regex . means any char.
		 */

		String[] userInput;
		do {
			userInput = JOptionPane.showInputDialog(
					"Enter number with decimals: ").split("\\.");
		} while(userInput.length == 1);
				
		System.out.printf("Whole number: %d\nNumbers after decimal point: %d",
			Integer.parseInt(userInput[0]), Integer.parseInt(userInput[1]));		
	}
}
