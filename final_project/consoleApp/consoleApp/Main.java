package consoleApp;

import java.io.IOException;

/**
 * 
 * @author tnebes
 * @date 6 February 2021
 */

public class Main {

	public Main() throws IOException {
		IO.DataIO.initialise();
		while(true) {
			UI.mainMenu();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Main();
	}
	
}
