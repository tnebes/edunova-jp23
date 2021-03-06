import java.util.Scanner;

public class Zadatak05 {
//
	public static void main(String[] args) {
		// ciklicka matrica

		Scanner ulaz = new Scanner(System.in);

		int redak = -1, stupac = -1;

		do {
			System.out.println("Unesi broj redaka: ");

			redak = ulaz.nextInt();
		} while (redak <= 0);

		do {
			System.out.println("Unesi broj stupaca: ");

			stupac = ulaz.nextInt();
		} while (stupac <= 0);
		
		ulaz.close();

		int pocRedak = 0, pocStupac = 0, zadRedak = redak - 1, zadStupac = stupac - 1, broj = 1;

		int[][] matrica = new int[redak][stupac];

		// unos vrijednosti u matricu (iznimka rješena pomoću if-a - linija 61)
		while (broj <= redak * stupac) {

			// (redak) desno -> lijevo
			for (int i = zadStupac; i >= pocStupac; i--) {
				matrica[zadRedak][i] = broj++;
			}
			
			zadRedak--;
			
			//ako je svaki element matrice popunjen 
			//(ako je zadnji element koji je upisan >= redak*stupac) program staje
			if(provjera(matrica,broj)) {
				break;
			}

			// (stupac) dolje -> gore
			for (int i = zadRedak; i >= pocRedak; i--) {
				matrica[i][pocStupac] = broj++;
			}
			
			pocStupac++;
			
			if(provjera(matrica,broj)) {
				break;
			}

			// (redak) lijevo -> desno
			for (int i = pocStupac; i <= zadStupac; i++) {
				matrica[pocRedak][i] = broj++;
			}
			
			pocRedak++;
			
			if(provjera(matrica,broj)) {
				break;
			}

			// (stupac) gore -> dolje
			for (int i = pocRedak; i <= zadRedak; i++) {
				matrica[i][zadStupac] = broj++;
			}
			
			zadStupac--;
			
			if(provjera(matrica,broj)) {
				break;
			}
		}

		/*
		// u slučaju kvadratne matrice neparnog reda da ispuni "zadnje" polje
		if (redak == stupac && redak % 2 != 0) {
			matrica[redak / 2][stupac / 2] = redak * stupac;
		}
		*/

		// ispis matrice
		System.out.println("Matrica je dana s: ");
		for (int i = 0; i < redak; i++) { 
			for (int j = 0; j < stupac; j++) {
				System.out.print(matrica[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	static boolean provjera(int[][] niz2d, int br) {
		return br >= niz2d.length * niz2d[0].length;
	}
}
