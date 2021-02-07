package edunova09;
import java.util.ArrayList;

public class Start {

	public Start() {
//		String[] names = new String[2];
//		names[0] = "Anna";
//		names[1] = "Mario";
		
		ArrayList<Person> myList = new ArrayList<>();
		myList.add(new Person("Anna"));
		myList.add(new Person("Mario"));
		myList.add(new Person("Peter"));
		for (Person person : myList) {
			System.out.printf("%s\n", person);
		}
		
	}
	
//	public class Person {
//		private String name;
//		
//		public Person(String name) {
//			this.name = name;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//		
//		@Override
//		public String toString() {
//			return super.toString().concat(String.format("\n%s", this.getName()));
//		}
//	}
	
	public static void main(String[] args) {
		new Start();
	}
	
}
