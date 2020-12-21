package edunova02;

public class Exercise07 {

	public static void main(String[] args) {
		
		// program enters char
		// if char is 'a' writes first place
		// if 'b' writes third place
		// if 'e' writes fifth place
		
		char letter = 'a';
		String myString;
		
		switch (letter) {
		case 'a':	myString = "First place";
						break;
		case 'b':	myString = "Second place";
						break;
		case 'c':	myString = "Third place";
						break;
		case 'd':	myString = "Fourth place";
						break;
		case 'e':	myString = "Fifth place";
						break;
		default:		myString = "oops";
						break;
		}
		System.out.println(myString);

	}
}
