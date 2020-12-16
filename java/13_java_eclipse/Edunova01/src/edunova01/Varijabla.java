package edunova01;

public class Varijabla {
	// varijabla klase
	static int k;
	
	public static void main(String[] args /*, int j varijabla kao parametar metode*/) {
	
	//deklaracija varijable
	// - varijabla metode
	int i;
	k = 12;
	
	//dodjeljivanje vrijednosti
	i = 1;
	//-2^31 and a maximum value of 2^31-1
	k = Integer.MAX_VALUE;
	
	//korištenje vrijednosti pohranjene u varijabli
	System.out.println(i);
	System.out.println(k);
	System.out.println(k+1);
	}
}
