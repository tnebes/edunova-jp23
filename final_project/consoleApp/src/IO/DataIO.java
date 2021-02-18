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

import dataClasses.*;
import dataHandler.Controller;

/**
 * 
 * @author tnebes 7 February 2021
 */
public class DataIO {

	private static final boolean DEBUG = true;

	private static final String DATA_DIR_STRING_PATH = "./data/";
	private static final String DATA_INVOICE_FILE_STRING_PATH = "invoices.json";
	private static final String DATA_CUSTOMER_FILE_STRING_PATH = "customers.json";
	private static final String DATA_ADDRESSES_FILE_STRING_PATH = "addresses.json";
	private static final String DATA_ARTICLES_FILE_STRING_PATH = "articles.json";
	private static final String DATA_STATUSES_FILE_STRING_PATH = "statuses.json";
	private static final String DATA_TRANSACTION_TYPES_FILE_STRING_PATH = "transaction_types.json";
	private static final String DATA_COUNTERS_STRING_PATH = "counters.txt";
	private static final String SQL_CONNECTION_STRING_PATH = "MYSQL.txt";
	private static final String SQL_DATABASE_SCRIPT = "./sql/store_database.sql";

	private static final Path DATA_DIR_PATH = Paths.get(DATA_DIR_STRING_PATH);
	private static final Path DATA_INVOICES_FILE_PATH = Paths.get(DATA_DIR_STRING_PATH, DATA_INVOICE_FILE_STRING_PATH);
	private static final Path DATA_CUSTOMERS_FILE_PATH = Paths.get(DATA_DIR_STRING_PATH, DATA_CUSTOMER_FILE_STRING_PATH);
	private static final Path DATA_ADDRESSES_FILE_PATH = Paths.get(DATA_DIR_STRING_PATH, DATA_ADDRESSES_FILE_STRING_PATH);
	private static final Path DATA_ARTICLES_FILE_PATH = Paths.get(DATA_DIR_STRING_PATH, DATA_ARTICLES_FILE_STRING_PATH);
	private static final Path DATA_COUNTERS_FILE_PATH = Paths.get(DATA_DIR_STRING_PATH, DATA_COUNTERS_STRING_PATH);
	private static final Path DATA_STATUSES_FILE_PATH = Paths.get(DATA_DIR_STRING_PATH, DATA_STATUSES_FILE_STRING_PATH);
	private static final Path DATA_TRANSACTION_TYPES_FILE_PATH = Paths.get(DATA_DIR_STRING_PATH, DATA_TRANSACTION_TYPES_FILE_STRING_PATH);
	private static final Path SQL_CONNECTION_STRING_FILE_PATH = Paths.get(DATA_DIR_STRING_PATH, SQL_CONNECTION_STRING_PATH);
	private static final Path SQL_DATABASE_SCRIPT_FILE_PATH = Paths.get(SQL_DATABASE_SCRIPT);

	private static ArrayList<Path> pathList = new ArrayList<>();
	
	private static Gson gson;

	/**
	 * Creates the data folder. If successful, true. If fail, false.
	 * 
	 * @return true if successful. False if not.
	 * @throws IOException
	 */
	public static boolean createDataFolder() throws IOException {
		try {
			Files.createDirectory(DATA_DIR_PATH);
			return true;
		} catch (FileAlreadyExistsException e) {
			if (DEBUG) {
				System.out.printf("Data folder present at %s\n", DATA_DIR_PATH.toAbsolutePath().toString());
			}
			return false;
		} catch (IOException e) {
			System.out.print("IO error.\n");
			e.printStackTrace();
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
				e.printStackTrace();
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
		gson = new Gson();
		pathList.add(DATA_INVOICES_FILE_PATH);
		pathList.add(DATA_CUSTOMERS_FILE_PATH);
		pathList.add(DATA_ADDRESSES_FILE_PATH);
		pathList.add(DATA_ARTICLES_FILE_PATH);
		pathList.add(DATA_COUNTERS_FILE_PATH);
		pathList.add(DATA_STATUSES_FILE_PATH);
		pathList.add(DATA_TRANSACTION_TYPES_FILE_PATH);
		pathList.add(SQL_CONNECTION_STRING_FILE_PATH);

		// if folder created, files needed.
		if (createDataFolder()) {
			createNewDataFiles();
			return;
		}
		// if folder there, check files and create if necessary
		createStatusTransactionFiles();
		createNewDataFiles();
		IDCounter.initialiseCounters();
		Controller.initialiseData();
		System.out.print("\n");
	}

	public static ArrayList<Invoice> getDataInvoicesFileData() throws FileNotFoundException {
		Scanner reader = new Scanner(DATA_INVOICES_FILE_PATH.toFile());
		ArrayList<Invoice> returnList = new ArrayList<>();
		while (reader.hasNextLine()) {
			returnList.add(gson.fromJson(reader.nextLine(), Invoice.class));
		}
		reader.close();
		return returnList;
	}
	
	public static ArrayList<Customer> getDataCustomersFileData() throws FileNotFoundException  {
		Scanner reader = new Scanner(DATA_CUSTOMERS_FILE_PATH.toFile());
		ArrayList<Customer> returnList = new ArrayList<>();
		while (reader.hasNextLine()) {
			returnList.add(gson.fromJson(reader.nextLine(), Customer.class));
		}
		reader.close();
		return returnList;
	}

	public static ArrayList<Address> getDataAddressesFileData() throws FileNotFoundException  {
		Scanner reader = new Scanner(DATA_ADDRESSES_FILE_PATH.toFile());
		ArrayList<Address> returnList = new ArrayList<>();
		while (reader.hasNextLine()) {
			returnList.add(gson.fromJson(reader.nextLine(), Address.class));
		}
		reader.close();
		return returnList;
	}

	public static ArrayList<Article> getDataArticlesFileData() throws FileNotFoundException  {
		Scanner reader = new Scanner(DATA_ARTICLES_FILE_PATH.toFile());
		ArrayList<Article> returnList = new ArrayList<>();
		while (reader.hasNextLine()) {
			returnList.add(gson.fromJson(reader.nextLine(), Article.class));
		}
		reader.close();
		return returnList;
	}

	public static ArrayList<Status> getDataStatusesFileData() throws FileNotFoundException {
		Scanner reader = new Scanner(DATA_STATUSES_FILE_PATH.toFile());
		ArrayList<Status> returnList = new ArrayList<>();
		while (reader.hasNextLine()) {
			returnList.add(gson.fromJson(reader.nextLine(), Status.class));
		}
		reader.close();
		return returnList;
	}

	public static ArrayList<TransactionType> getTransactionTypesFileData() throws FileNotFoundException {
		Scanner reader = new Scanner(DATA_TRANSACTION_TYPES_FILE_PATH.toFile());
		ArrayList<TransactionType> returnList = new ArrayList<>();
		while (reader.hasNextLine()) {
			returnList.add(gson.fromJson(reader.nextLine(), TransactionType.class));
		}
		reader.close();
		return returnList;
	}
	
	public static String getDataCountersFileData() throws FileNotFoundException  {
		Scanner reader = new Scanner(DATA_COUNTERS_FILE_PATH.toFile());
		String returnValue = reader.nextLine();
		reader.close();
		return returnValue;
	}

	public static String getSQLConnectionData() throws FileNotFoundException {
		Scanner reader = new Scanner(SQL_CONNECTION_STRING_FILE_PATH.toFile());
		StringBuilder sb = new StringBuilder();
		while (reader.hasNext()) {
			sb.append(reader.next()).append(" ");
		}
		return sb.toString();
	}

	/**
	 * Writes the dataclasses to json files. Does not write the counters.
	 */
	public static void writeDataToFiles() {
		writeDataInvoicesFile(Controller.getInvoices());
		writeDataAddressesFile(Controller.getAddresses());
		writeDataArticlesFile(Controller.getArticles());
		writeDataCustomersFile(Controller.getCustomers());
		writeDataStatusesFile(Controller.getStatuses());
		writeTransactionTypesFile(Controller.getTransactionTypes());
	}

	private static void writeDataInvoicesFile(ArrayList<Invoice> invoices) {
		try {
			FileWriter fw = new FileWriter(DATA_INVOICES_FILE_PATH.toFile());
			for (Invoice invoice : invoices) {
				fw.write(gson.toJson(invoice));
				fw.write("\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("Unable to write invoices to file.\n");
			System.exit(1);
		}

	}
	
	private static void writeDataCustomersFile(ArrayList<Customer> customers) {
		try {
			FileWriter fw = new FileWriter(DATA_CUSTOMERS_FILE_PATH.toFile());
			for (Customer customer : customers) {
				fw.write(gson.toJson(customer));
				fw.write("\n");
			}
			fw.close();			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("Unable to write customers to file.\n");
			System.exit(1);
		}
	}
	
	private static void writeDataAddressesFile(ArrayList<Address> addresses) {
		try {
			FileWriter fw = new FileWriter(DATA_ADDRESSES_FILE_PATH.toFile());
			for (Address address : addresses) {
				fw.write(gson.toJson(address));
				fw.write("\n");
			}
			fw.close();			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("Unable to write addresses to file.\n");
			System.exit(1);
		}

	}
	
	private static void writeDataArticlesFile(ArrayList<Article> articles) {
		try {
			FileWriter fw = new FileWriter(DATA_ARTICLES_FILE_PATH.toFile());
			for (Article article : articles) {
				fw.write(gson.toJson(article));
				fw.write("\n");
			}
			fw.close();			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("Unable to write articles to file.\n");
			System.exit(1);
		}
	}

	private static void writeDataStatusesFile(ArrayList<Status> statuses) {
		try {
			FileWriter fw = new FileWriter(DATA_STATUSES_FILE_PATH.toFile());
			for (Status status : statuses) {
				fw.write(gson.toJson(status));
				fw.write("\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("Unable to write statuses to file.\n");
			System.exit(1);
		}
	}

	private static void writeTransactionTypesFile(ArrayList<TransactionType> transactionTypes) {
		try {
			FileWriter fw = new FileWriter(DATA_TRANSACTION_TYPES_FILE_PATH.toFile());
			for (TransactionType transactionType : transactionTypes) {
				fw.write(gson.toJson(transactionType));
				fw.write("\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("Unable to write transaction types to file.\n");
			System.exit(1);
		}
	}

	public static void writeDataCountersFile(String data) {
		try {
			FileWriter fw = new FileWriter(DATA_COUNTERS_FILE_PATH.toFile());
			fw.write(data);
			fw.close();			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("Unable to write counters to file.\n");
			System.exit(1);
		}
	}

	private static void createStatusTransactionFiles() {
		Status tempStatus = new Status();
		Controller.getStatuses().add(tempStatus);
		try {
			FileWriter fw = new FileWriter(DATA_STATUSES_FILE_PATH.toFile());
			fw.write(gson.toJson(tempStatus));
			fw.write("\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		TransactionType tempTransactionType = new TransactionType();
		Controller.getTransactionTypes().add(tempTransactionType);
		try {
			FileWriter fw = new FileWriter(DATA_TRANSACTION_TYPES_FILE_PATH.toFile());
			fw.write(gson.toJson(tempTransactionType));
			fw.write("\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static Path getSqlDatabaseScriptFilePath() {
		return SQL_DATABASE_SCRIPT_FILE_PATH;
	}

	public static void purgeJSON() {
		FileWriter fw;
		for (Path path : pathList) {
			if (path.toString().contains(".json")) {
				try {
					fw = new FileWriter(path.toFile());
					fw.write("");
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		}
		IDCounter.writeZeroCounters();
	}



}
