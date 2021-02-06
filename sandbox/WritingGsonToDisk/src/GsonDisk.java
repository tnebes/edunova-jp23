import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class GsonDisk {

	public static void main(String[] args) throws IOException {
	
		DataObject data = new DataObject("Test", 123);
		
		File myFile = new File("myJson.exe");
		FileWriter writer = new FileWriter(myFile);
		writer.write(new Gson().toJson(data));
		writer.close();		
	}
	
	
	
	
	
}
