package edunova.example;

import java.math.BigDecimal;

public class Start {

	public Start() {
		Document[] documents = new Document[2];
		Invoice invoice = new Invoice();
		invoice.setInvoicePart1(BigDecimal.valueOf(123.123));
		invoice.setInvoicePart2(BigDecimal.valueOf(12.23));
		
		documents[0] = invoice;
		
		Despatch despatch = new Despatch();
		despatch.setBuyer("E");
		despatch.setSub(BigDecimal.valueOf(100));
		
		documents[1] = despatch;
		
		System.out.println(documents[0].getIznos() + " - " + documents[0].getIznosPDV());
		System.out.println(documents[1].getIznos() + " - " + documents[1].getIznosPDV());
		
	}
	
	public static void main(String[] args) {
		new Start();
	}
	
}
