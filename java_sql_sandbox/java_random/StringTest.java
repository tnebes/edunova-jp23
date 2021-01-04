import java.math.BigInteger;

public class StringTest {
	public static void main(String[] args) {
		// 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
		// What is the sum of the digits of the number 2^1000?

		BigInteger baza = new BigInteger("2");
		int eksponent = 1000;
		BigInteger potencija = baza.pow(eksponent);

		//System.out.println(potencija);
		
		String znamenke=potencija.toString();
		
		//System.out.println(znamenke);
		
		int suma = 0;

		for(int i = 0; i < znamenke.length(); i++) {
		    int znamenka = Character.getNumericValue(znamenke.charAt(i));
		    suma += znamenka;
		}

		System.out.println(suma);		
		

	}

}
