
public class DataObject {

	private String myString;
	private int myInt;
	
	
	public DataObject(String myString, int myInt) {
		super();
		this.myString = myString;
		this.myInt = myInt;
	}


	public String getMyString() {
		return myString;
	}


	public void setMyString(String myString) {
		this.myString = myString;
	}


	public int getMyInt() {
		return myInt;
	}


	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getMyString()).append(" ");
		sb.append(getMyInt()).append(" ");
		return sb.toString();
	}
	
	
	
}
