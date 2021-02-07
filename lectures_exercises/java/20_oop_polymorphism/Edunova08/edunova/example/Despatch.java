package edunova.example;

import java.math.BigDecimal;

public class Despatch extends Document{

	private String buyer;
	private BigDecimal sub;
	
	@Override
	public BigDecimal getIznos() {
		// TODO Auto-generated method stub
		return sub;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public BigDecimal getSub() {
		return sub;
	}

	public void setSub(BigDecimal sub) {
		this.sub = sub;
	}

	
	
	
}
