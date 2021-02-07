public class Hello {
	public static void main(String[] args) {
		String name = "Tomislav";
		System.out.printf("Hello %s!\n", name);

		String[] polaznici = {"Tomislav",
			"David", "Filip", "Filip", "Gabriela", "Iva",
			"Ivan", "Ivana", "Marko", "Marko", "Matija",
			"Natalija", "Srdjan", "Velimir"};

		for (int i = 0; i < polaznici.length; i++) {
			System.out.printf("Hello, %s!\n", polaznici[i]);
		}
	}
}

