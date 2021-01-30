package edunova.example;

import java.math.BigDecimal;

public class Invoice extends Document {

	private BigDecimal invoicePart1;
	private BigDecimal invoicePart2;
	
	@Override
	public BigDecimal getIznos() {
		// TODO Auto-generated method stub
		return invoicePart1.multiply(invoicePart2).divide(BigDecimal.valueOf(2));
	}

	public BigDecimal getInvoicePart1() {
		return invoicePart1;
	}

	public void setInvoicePart1(BigDecimal invoicePart1) {
		this.invoicePart1 = invoicePart1;
	}

	public BigDecimal getInvoicePart2() {
		return invoicePart2;
	}

	public void setInvoicePart2(BigDecimal invoicePart2) {
		this.invoicePart2 = invoicePart2;
	}

	
	
}
