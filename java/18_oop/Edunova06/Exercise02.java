/*
 * Load 5 city names as Strings
 * Print all names backwards
 */

package Edunova06;

public class Exercise02 {

	public static void main(String[] args) {
		
		String[] cities = {"Osijek", "Zagreb", "Rijeka", "Zadar", "Babin zub"};
		
		for (int i = 0; i < cities.length; i++) {
			for (int j = cities[i].length() - 1; j >= 0; j--) {
				System.out.printf("%c", cities[i].charAt(j));
			}
			System.out.print("\n");
		}
		
	}
	
}
