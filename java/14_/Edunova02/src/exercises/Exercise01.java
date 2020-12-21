package exercises;
import javax.swing.*;

public class Exercise01 {
	
	public static void main(String[] args) {
		//user enters whole number
		//program writes 1 for odd, 0 for even
		
		System.out.printf("%d\n",
				Integer.parseInt(JOptionPane.showInputDialog("Please enter whole number")) % 2);
	}
}
