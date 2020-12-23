package edunova03;
import javax.swing.*;

public class Exercise00 {
	public static void main(String[] args) {
		// program requires 3 chars
		// program checks whether it is a palindrome
		
		String input = "anavolimilovana";
		char[] palindrome = new char[input.length()];
		for (int i = 0; i < palindrome.length; i++) {
			palindrome[i] = input.charAt(i);
		}
		System.out.printf("%b", isPalindrome(palindrome));	
	}
	
	public static boolean isPalindrome(char[] palindrome) {
		for (int i = 0; i < (palindrome.length / 2) - 1; i++) {
			if (palindrome[i] != palindrome[palindrome.length - i - 1]) {
				return false;
			}
		}
		return true;
	}
}

