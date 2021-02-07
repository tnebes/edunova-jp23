package edunova.polymorphism.realisation;

import edunova.polymorphism.stage.Attendee;
import edunova.polymorphism.stage.Lecturer;
import edunova.polymorphism.stage.Person;

public class Start {

	public Start() {
		Person[] persons = new Person[2];
		
		Attendee attendee = new Attendee();
		attendee.setName("Mario");
		attendee.setContractNumber("2021/55");
		persons[0] = attendee;
		
		Lecturer lecturer = new Lecturer();
		lecturer.setName("Bob");
		lecturer.setIBAN("HR01234567891011");
		persons[1] = lecturer;
		
		myPrint(persons);
		
	}
	
	private void myPrint(Person[] persons) {
		for (Person person : persons) {
			System.out.println(person.getGreeting());
		}
	}
	
	public static void main(String[] args) {
		new Start();
	}
	
}
