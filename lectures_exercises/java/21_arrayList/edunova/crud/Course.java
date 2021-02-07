package edunova.crud;

public class Course {
	
	private String name;

	public Course() {
		
	}
	
	public Course(String name) {
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
		sb.append("\tname: ");
		sb.append(name);
		return sb.toString();
	}

}
