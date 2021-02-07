package IO;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;

import consoleApp.DataClasses.Address;
import consoleApp.DataClasses.Article;
import consoleApp.DataClasses.Customer;
import consoleApp.DataClasses.Invoice;
import dataHandler.Controller;

/**
 * 
 * @author tnebes 7 February 2021
 */
public class DataIO {

	private static final boolean DEBUG = true;

	private static String dataDirStringPath = "./data/";
	private static String dataInvoiceFileStringPath = "invoices.json";
	private static String dataCustomerFileStringPath = "customers.json";
	private static String dataAddressesFileStringPath = "addresses.json";
	private static String dataArticlesFileStringPath = "articles.json";
	private static String dataCountersStringPath = "counters.txt";

	private static Path dataDirPath = Paths.get(dataDirStringPath);
	private static Path dataInvoicesFilePath = Paths.get(dataDirStringPath, dataInvoiceFileStringPath);
	private static Path dataCustomersFilePath = Paths.get(dataDirStringPath, dataCustomerFileStringPath);
	private static Path dataAddressesFilePath = Paths.get(dataDirStringPath, dataAddressesFileStringPath);
	private static Path dataArticlesFilePath = Paths.get(dataDirStringPath, dataArticlesFileStringPath);
	private static Path dataCountersFilePath = Paths.get(dataDirStringPath, dataCountersStringPath);

	private static ArrayList<Path> pathList = new ArrayList<>();

	/**
	 * Creates the data folder. If successful, true. If fail, false.
	 * 
	 * @return true if successful. False if not.
	 * @throws IOException
	 */
	public static boolean createDataFolder() throws IOException {
		try {
			Files.createDirectory(dataDirPath);
			return true;
		} catch (FileAlreadyExistsException e) {
			if (DEBUG) {
				System.out.printf("Data folder present at %s\n", dataDirPath.toAbsolutePath().toString());
			}
			return false;
		} catch (IOException e) {
			System.out.print("IO error.\n");
			System.out.print(e);
			System.exit(1);
		}
		return false;
	}

	/**
	 * Creates the data files
	 * 
	 * @throws IOException
	 */
	public static void createNewDataFiles() throws IOException {
		for (Path path : pathList) {
			try {
				Files.createFile(path);
			} catch (FileAlreadyExistsException e) {
				if (DEBUG) {
					System.out.printf("%s present at %s\n", path.getFileName().toString(), path.toAbsolutePath().toString());
				}
			} catch (IOException e) {
				System.out.print(e);
				System.exit(1);
			}
		}
	}

	/**
	 * Initialisation method.
	 * 
	 * @throws IOException
	 */
	public static void initialise() throws IOException {
		System.out.print("Initialising...\n");
		pathList.add(dataInvoicesFilePath);
		pathList.add(dataCustomersFilePath);
		pathList.add(dataAddressesFilePath);
		pathList.add(dataAddressesFilePath);
		pathList.add(dataArticlesFilePath);
		pathList.add(dataCountersFilePath);

		// if folder created, files needed.
		if (createDataFolder()) {
			createNewDataFiles();
			return;
		}
		// if folder there, check files and create if neccessary
		createNewDataFiles();
		IDCounter.initialiseCounters();
		Controller.initialiseData();
		
		System.out.print("\n");
	}

	public static ArrayList<Invoice> getDataInvoicesFileData() throws FileNotFoundException {
		Scanner reader = new Scanner(dataInvoicesFilePath.toFile());
		ArrayList<Invoice> returnList = new ArrayList<>();
		while (reader.hasNextLine()) {
			returnList.add(new Gson().fromJson(reader.nextLine(), Invoice.class));
		}
		reader.close();
		return returnList;
	}
	
	public static ArrayList<Customer> getDataCustomersFileData() throws FileNotFoundException  {
		Scanner reader = new Scanner(dataCustomersFilePath.toFile());
		ArrayList<Customer> returnList = new ArrayList<>();
		while (reader.hasNextLine()) {
			returnList.add(new Gson().fromJson(reader.nextLine(), Customer.class));
		}
		reader.close();
		return returnList;
	}

	public static ArrayList<Address> getDataAddressesFileData() throws FileNotFoundException  {
		Scanner reader = new Scanner(dataAddressesFilePath.toFile());
		ArrayList<Address> returnList = new ArrayList<>();
		while (reader.hasNextLine()) {
			returnList.add(new Gson().fromJson(reader.nextLine(), Address.class));
		}
		reader.close();
		return returnList;
	}

	public static ArrayList<Article> getDataArticlesFileData() throws FileNotFoundException  {
		Scanner reader = new Scanner(dataArticlesFilePath.toFile());
		ArrayList<Article> returnList = new ArrayList<>();
		while (reader.hasNextLine()) {
			returnList.add(new Gson().fromJson(reader.nextLine(), Article.class));
		}
		reader.close();
		return returnList;
	}
	
	public static String getDataCountersFileData() throws FileNotFoundException  {
		Scanner reader = new Scanner(dataCountersFilePath.toFile());
		String returnValue = reader.nextLine();
		reader.close();
		return returnValue;
	}
	
	public static void writeDataInvoicesFile(ArrayList<Invoice> invoices) throws IOException {
		FileWriter fw = new FileWriter(dataInvoicesFilePath.toFile());
		for (Invoice invoice : invoices) {
			fw.write(new Gson().toJson(invoice));
			fw.write("\n");
		}
		fw.close();
	}
	
	public static void writeDataCustomersFile(ArrayList<Customer> customers) throws IOException {
		FileWriter fw = new FileWriter(dataCustomersFilePath.toFile());
		for (Customer customer : customers) {
			fw.write(new Gson().toJson(customer));
			fw.write("\n");
		}
		fw.close();
	}
	
	public static void writeDataAddressesFile(ArrayList<Address> addresses) throws IOException {
		FileWriter fw = new FileWriter(dataAddressesFilePath.toFile());
		for (Address address : addresses) {
			fw.write(new Gson().toJson(address));
			fw.write("\n");
		}
		fw.close();
	}
	
	public static void writeDataArticlesFile(ArrayList<Article> articles) throws IOException {
		FileWriter fw = new FileWriter(dataArticlesFilePath.toFile());
		for (Article article : articles) {
			fw.write(new Gson().toJson(article));
			fw.write("\n");
		}
		fw.close();
	}
	
	public static void writeDataCountersFile(String data) throws IOException {
		FileWriter fw = new FileWriter(dataCountersFilePath.toFile());
		fw.write(data);
		fw.close();
	}
	
}
