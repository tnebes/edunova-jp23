package dataClasses;

import IO.IDCounter;

import java.util.ArrayList;
public class Status {
	
	private byte 			id;
	private String 			name;
	private String 			description;
	private String 			descriptionLong;
	private ArrayList<Long> invoicesID;

	public Status() {
		this(IDCounter.incrementStatusCounter(), "default", "default", "default");
	}

	public Status(byte id, String name, String description, String descriptionLong) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.descriptionLong = descriptionLong;
		initialise();
	}

	private void initialise() {
		this.invoicesID = new ArrayList<>();
	}

	public byte getId() {
		return id;
	}
	public void setId(byte id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescriptionLong() {
		return descriptionLong;
	}
	public void setDescriptionLong(String descriptionLong) {
		this.descriptionLong = descriptionLong;
	}
	public ArrayList<Long> getInvoicesID() {
		return invoicesID;
	}
	public void setInvoicesID(ArrayList<Long> invoicesID) {
		this.invoicesID = invoicesID;
	}

	@Override
	public String toString() {
		return "Status{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", descriptionLong='" + descriptionLong + '\'' +
				'}';
	}
}
