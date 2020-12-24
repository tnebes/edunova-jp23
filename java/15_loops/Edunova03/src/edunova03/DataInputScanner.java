package edunova03;

public class DataInputScanner {

	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("Enter a number: ");
		int i = input.nextInt();
		
		System.out.print("The number is " + i);
	}
}
