package edunova.crud;

public class Group {

	private String name;

	public Group() {
		
	}
	
	public Group(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name: ");
		sb.append(name);
		return sb.toString();
	}

	
}
