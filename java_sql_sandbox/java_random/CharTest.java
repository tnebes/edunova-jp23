
public class CharTest {

	public static void main(String[] args) {
		int c1 = '0';
		int c2 = '1';
		int c3 = Integer.parseInt("10");
		int c0 = Integer.parseInt("0");
		int c4 = 'a';
		int c5 = 'b';
				
		System.out.printf("%c\n", c0); //  nothing
		System.out.printf("%c\n", c1); // 0
		System.out.printf("%c\n", c2); // 1
		System.out.printf("%c\n", c3 - c0); // 
		System.out.printf("%c\n", c4); // a
		System.out.printf("%c\n", c5); // b
		System.out.printf("%c\n", c5 + c4); // Ã
		System.out.printf("%c\n", c4 - 50); // /
		
		System.out.print("\n");
		for (int i = '0'; i < 100; i++) {
			System.out.printf("%c ", (char)i);
		}

	}

}
