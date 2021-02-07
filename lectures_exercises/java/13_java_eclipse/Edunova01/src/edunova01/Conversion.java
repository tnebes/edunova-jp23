package edunova01;
import javax.swing.JOptionPane;

public class Conversion {
	/*
	 * Enters double
	 * gets int
	 */
	
	public static void main(String[] args) {
		System.out.printf("%d", (int) Double.parseDouble(JOptionPane.showInputDialog("Enter decimal number:")));
	}
}
