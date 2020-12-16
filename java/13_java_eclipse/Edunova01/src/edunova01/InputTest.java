package edunova01;
import javax.swing.JOptionPane;

public class InputTest {
	public static void main(String[] args) {

		/*
		 * User enters two ints
		 * The program prints two numbers next to each other
		 */
		
		int firstInt, secondInt;
		
		firstInt = Integer.parseInt(JOptionPane.showInputDialog("Enter first int"));
		secondInt = Integer.parseInt(JOptionPane.showInputDialog("Enter second int"));
		
		System.out.printf("%d, %d\n", firstInt, secondInt);
	}
	
}
