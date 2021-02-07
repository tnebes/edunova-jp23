import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Start {

	public static void main(String[] args) throws IOException {
		String test = "test";
		
		// writing to a file
		
		File myFile = new File("test_file.txt");
		myFile.createNewFile();
		FileWriter myFileWriter = new FileWriter(myFile);
		myFileWriter.write("abc");
		myFileWriter.append(String.valueOf(5000));
		myFileWriter.close();
		
		// reading from a file
		
		java.util.Scanner reader = new java.util.Scanner(myFile);
		System.out.print(reader.nextLine());
		
	}
	
}
