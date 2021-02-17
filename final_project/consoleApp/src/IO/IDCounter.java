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
			// e.printStackTrace();
			System.out.print("\nID counters reset to 0 due to error.\n");
			writeZeroCounters();
		}
	}

	public static void writeZeroCounters() {
		invoiceCounter = 0;
		customerCounter = 0;
		addressCounter = 0;
		articleCounter = 0;
		sendCountersToWrite();
	}

	public static void sendCountersToWrite() {
		String sb = invoiceCounter + " " +
				customerCounter + " " +
				addressCounter + " " +
				addressCounter + " ";
		DataIO.writeDataCountersFile(sb);

	}

	public static long incrementInvoiceCounter() {
		invoiceCounter++;
		sendCountersToWrite();
		return invoiceCounter;
	}

	public static long incrementCustomerCounter() {
		customerCounter++;
		sendCountersToWrite();
		return customerCounter;
	}

	public static long incrementAddressCounter() {
		addressCounter++;
		sendCountersToWrite();
		return addressCounter;
	}

	public static long incrementArticleCounter() {
		articleCounter++;
		sendCountersToWrite();
		return articleCounter;
	}

	public static long getInvoiceCounter() {
		return invoiceCounter;
	}

	public static long getCustomerCounter() {
		return customerCounter;
	}

	public static long getAddressCounter() {
		return addressCounter;
	}

	public static long getArticleCounter() {
		return articleCounter;
	}

	public static void setInvoiceCounter(long invoiceCounter) {
		IDCounter.invoiceCounter = invoiceCounter;
		sendCountersToWrite();
	}

	public static void setCustomerCounter(long customerCounter) {
		IDCounter.customerCounter = customerCounter;
		sendCountersToWrite();
	}

	public static void setAddressCounter(long addressCounter) {
		IDCounter.addressCounter = addressCounter;
		sendCountersToWrite();
	}

	public static void setArticleCounter(long articleCounter) {
		IDCounter.articleCounter = articleCounter;
		sendCountersToWrite();
	}

}
