package edunova01;
import javax.swing.*;


public class DecimalOnly {
	
	public static void main(String[] args) {
		/*
		 * User gets only the decimals of the number
		 */
		String theNumber = JOptionPane.showInputDialog("Enter decimal number");
		System.out.printf("%s",
			theNumber.substring(theNumber.indexOf('.') + 1));
	}
}
