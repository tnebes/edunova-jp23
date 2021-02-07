import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AdvancedStart {

	public static void main(String[] args) throws IOException {
		
		File myFile = new File("super_test.txt");
		writeToFile(myFile);
		printFile(myFile);
		alternativeReader(myFile);
	}
	
	public static void writeToFile(File file) throws IOException {
		FileWriter myFileWriter = new FileWriter(file);
		for (int i = 0; i <= 100; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(i).append("\n");
			myFileWriter.write(sb.toString());
			//String.valueOf();
		}
		myFileWriter.close();
	}
	
	public static void printFile(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		while (input.hasNextLine())	{
			String line = input.nextLine();	
			if (Integer.valueOf(line) % 2 == 0) {
				System.out.println(line);
			}
		}
		
	}
	
	public static void alternativeReader(File file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		System.out.println(file.length());
		System.out.println(Character.SIZE);
		System.out.print("\n");
		for (int i = 0; i < file.length(); i++) {
			System.out.print(i + " ");
			System.out.println((char) br.read());
		}
	}
	
	
}
