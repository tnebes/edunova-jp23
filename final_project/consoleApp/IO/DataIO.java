package IO;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;

/**
 * 
 * @author tnebes 7 February 2021
 */
public class DataIO {

	private static final boolean DEBUG = true;

	private static String dataDir = "./data/";
	private static String dataInvoiceFile = "invoices.json";
	private static String dataCustomerFile = "customers.json";
	private static String dataAddressesFile = "addresses.json";
	private static String dataArticlesFile = "articles.json";

	private static Path dataDirPath = Paths.get(dataDir);
	private static Path dataInvoicesFilePath = Paths.get(dataDir, dataInvoiceFile);
	private static Path dataCustomersFilePath = Paths.get(dataDir, dataCustomerFile);
	private static Path dataAddressesFilePath = Paths.get(dataDir, dataAddressesFile);
	private static Path dataArticlesFilePath = Paths.get(dataDir, dataArticlesFile);

	private static ArrayList<Path> pathList = new ArrayList<>();
	
	private static Files invoicesFile;
	private static Files customersFile;
	private static Files addressesFile;
	private static Files articlesFile;
	
	private static ArrayList<Files> filesList = new ArrayList<>();

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
					System.out.printf("%s present at %s\n", path.toString(), path.toAbsolutePath().toString());
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

		// if folder created, files needed.
		if (createDataFolder()) {
			createNewDataFiles();
			return;
		}
		// if folder there, check files and create if neccessary
		createNewDataFiles();

		System.out.print("\n");
	}

}
