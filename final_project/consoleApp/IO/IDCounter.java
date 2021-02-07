package IO;

public class IDCounter {

	public static long invoiceCounter;
	public static long customerCounter;
	public static long addressCounter;
	public static long articleCounter;
	

	
	public static void initialiseCounters() {
		invoiceCounter = 0;
		customerCounter = 0;
		addressCounter = 0;
		articleCounter = 0;
	}



	public static long getInvoiceCounter() {
		return invoiceCounter++;
	}



	public static long getCustomerCounter() {
		return customerCounter++;
	}



	public static long getAddressCounter() {
		return addressCounter++;
	}



	public static long getArticleCounter() {
		return articleCounter++;
	}
	
	
	
	
	
}
