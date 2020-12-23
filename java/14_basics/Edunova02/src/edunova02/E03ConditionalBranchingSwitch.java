package edunova02;

public class E03ConditionalBranchingSwitch {

	public static void main(String[] args) {

		int number = 5;
		String myString;

		switch (number) {
		case 1:
			myString = "Woo!";
			break;
		case 2:
			myString = "Wee!";
			break;
		case 3:
			myString = "Waa!!";
			break;
		case 4:
			myString = "Wii!!!!";
			break;
		default:
			myString = "foobar";
			break;
		}
		System.out.println(myString);

	}

}
