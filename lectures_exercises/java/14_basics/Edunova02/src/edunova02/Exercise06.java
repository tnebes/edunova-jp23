package edunova02;
import javax.swing.*;

public class Exercise06 {

	public static void main(String[] args) {
		
		// user enters two numbers
		// if the product of the two numbers is even
		// write the difference of the two numbers
		// else write the the whole part of quotient of the first and second number
		
		int number1 = Integer.parseInt(JOptionPane.showInputDialog("Enter first number"));
		int number2 = Integer.parseInt(JOptionPane.showInputDialog("Enter second number"));
		
		System.out.printf("%d\n",
				(number1 * number2) % 2 == 0 ? number1 - number2 : number1 / number2);
		
		
	}
	
}
