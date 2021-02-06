import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;

public class GsonDisk {

	public static void main(String[] args) throws IOException {

		DataObject data = new DataObject("Test", 123);
		ArrayList<DataObject> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			myList.add(data);
		}

		File myFile = new File("myJson.json");
		FileWriter writer = new FileWriter(myFile);
		
		for (int i = 0; i < myList.size(); i++) {
			writer.write(new Gson().toJson(myList.get(i)));
			writer.write("\n");
		}
		
//		writer.write(new Gson().toJson(myList));
		
		writer.close();
		System.out.printf("Wrote file to %s\n", myFile.toString());

		Scanner reader = new Scanner(myFile);

		while (reader.hasNextLine()) {
			System.out.print(new Gson().fromJson(reader.nextLine(), DataObject.class));
		}
		

	}

}
