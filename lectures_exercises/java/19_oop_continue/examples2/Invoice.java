package examples2;

import java.util.Date;

public class Invoice extends Document {

	private Date datum;

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public void setId(Long id) {
		super.setId(id);
		
	}
	
	
	
}
