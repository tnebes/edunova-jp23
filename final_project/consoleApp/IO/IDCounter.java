package IO;

import java.util.Scanner;

public class IDCounter {

	public static long invoiceCounter;
	public static long customerCounter;
	public static long addressCounter;
	public static long articleCounter;

	public static void initialiseCounters() {
		try {
			String counters = DataIO.getDataCountersFileData();
			Scanner stringReader = new Scanner(counters);
			invoiceCounter = stringReader.nextLong();
			customerCounter = stringReader.nextLong();
			addressCounter = stringReader.nextLong();
			articleCounter = stringReader.nextLong();
			stringReader.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("\nID counters reset to 0 due to error.\n");
			invoiceCounter = 0;
			customerCounter = 0;
			addressCounter = 0;
			articleCounter = 0;
			sendCountersToWrite();
		}

	}

	public static void sendCountersToWrite() {
		StringBuilder sb = new StringBuilder();
		sb.append(invoiceCounter).append(" ");
		sb.append(customerCounter).append(" ");
		sb.append(addressCounter).append(" ");
		sb.append(addressCounter).append(" ");
		DataIO.writeDataCountersFile(sb.toString());

	}

	public static long getInvoiceCounter() {
		invoiceCounter++;
		sendCountersToWrite();
		return invoiceCounter;
	}

	public static long getCustomerCounter() {
		customerCounter++;
		sendCountersToWrite();
		return customerCounter;
	}

	public static long getAddressCounter() {
		addressCounter++;
		sendCountersToWrite();
		return addressCounter;
	}

	public static long getArticleCounter() {
		articleCounter++;
		sendCountersToWrite();
		return articleCounter;
	}

}
