package edunova.example;

import java.math.BigDecimal;

public abstract class Document {
	
	public abstract BigDecimal getIznos();
	
	public BigDecimal getIznosPDV() {
		return getIznos().multiply(BigDecimal.valueOf(0.25));
	}
	
}