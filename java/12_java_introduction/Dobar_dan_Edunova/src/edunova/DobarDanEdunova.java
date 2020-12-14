package edunova;

public class DobarDanEdunova {
	public static void main(String[] args) {
		int counter = 0;
		while(true) {
			System.out.print("Hello, Edunova!\t");
			counter++;
			if (counter > 10) {
				System.out.print("\n");
				counter = 0;
			}
		}
	}
}
