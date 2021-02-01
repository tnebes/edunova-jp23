/*
 * Application has a main menu and accepts user input
 * User navigates using numbers
 * Application has courses, groups, students, lecturers, and exit
 * Each of the above groups has:
 * 	show
 * 	add
 * 	change
 * 	delete
 */

package edunova.crud;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {
	String[] mainMenuChoices = {"Courses", "Groups", "Students", "Lecturers", "Exit"};
	String[] subMenuChoices = {"Show all", "Add", "Change", "Delete", "Return from"};
	ArrayList<Course> courses = new ArrayList<>();
	ArrayList<Group> groups = new ArrayList<>();
	ArrayList<Student> students = new ArrayList<>();
	ArrayList<Lecturer> lecturers = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	
	public Start() {
		int userInput;
		do {
			mainMenu();
			System.out.print("\n\n");
			userInput = input.nextInt();
			switch(userInput) {
			case 1 : 	showSubMenuGeneric(userInput);
							break;
			case 2 :		showSubMenuGeneric(userInput);
							break;
			case 3 :		showSubMenuGeneric(userInput);
							break;
			case 4 :		showSubMenuGeneric(userInput);
							break;
			case 5 : 	break;
			default :	showErrorMessage(mainMenuChoices.length);
							break;			
			}
		} while (userInput != mainMenuChoices.length);
	}

	private void showSubMenuGeneric(int choice) {
		System.out.print("\n\n");
		int userInput;
		do {
			for (int i = 0; i < subMenuChoices.length; i++) {
				System.out.printf("%d - %s %s\n", i + 1, subMenuChoices[i], mainMenuChoices[choice - 1]);
			}
			userInput = input.nextInt();
			switch(userInput) {
			case 1 : 	genericShow(choice);
							break;
			case 2 :		genericAdd(choice);
							break;
			case 3 :		genericChange(choice);
							break;
			case 4 :		genericDelete(choice);
							break;
			case 5 : 	break;
			default :	showErrorMessage(subMenuChoices.length);
							break;			
			}
		} while (userInput != subMenuChoices.length);
				
	}
	
	private void showErrorMessage(int length) {
		System.out.printf("Error! Please select from 1 to %d\n", length);
		
	}
	
	private void genericShow(int choice) {
		switch (choice) {
		case 1 : 	printCourses();
						break;
		case 2 : 	printGroups();
						break;
		case 3 : 	printStudents();
						break;
		case 4 : 	printLecturers();
						break;
		default :	showErrorMessage(4);
						break;	
		}
	}

	private void printCourses() {
		for (int i = 0; i < courses.size(); i++) {
			System.out.printf("%4d - %s\n", i, courses.get(i).toString());
		}
	}

	private void printGroups() {
		for (int i = 0; i < groups.size(); i++) {
			System.out.printf("%4d - %s\n", i, groups.get(i).toString());
		}
	}

	private void printStudents() {
		for (int i = 0; i < students.size(); i++) {
			System.out.printf("%4d - %s\n", i, students.get(i).toString());
		}
	}

	private void printLecturers() {
		for (int i = 0; i < lecturers.size(); i++) {
			System.out.printf("%4d - %s\n", i, lecturers.get(i).toString());
		}
	}

	private void genericAdd(int choice) {
		System.out.printf("When entering multiple pieces of information, make sure you press enter after each information! ");
		switch (choice) {
		case 1 : 	addCourses();
						break;
		case 2 : 	addGroups();
						break;
		case 3 : 	addStudents();
						break;
		case 4 : 	addLecturers();
						break;
		case 5 : 	break;
		default :	showErrorMessage(4);
						break;	
		}

		
	}

	private void addCourses() {
		input.nextLine(); // eats the extra \n
		System.out.print("Enter the following information for the course: Name: ");
		courses.add(new Course(input.nextLine()));
	}

	private void addGroups() {
		input.nextLine(); // eats the extra \n
		System.out.print("Enter the following information for the group: Name: ");
		groups.add(new Group(input.nextLine()));
	}

	private void addStudents() {
		input.nextLine(); // eats the extra \n
		System.out.print("Enter the following information for the student: First name, last name: ");
		students.add(new Student(input.nextLine(), input.nextLine()));		
	}

	private void addLecturers() {
		input.nextLine(); // eats the extra \n
		System.out.print("Enter the following information for the lecturer: First name, last name, IBAN: ");
		lecturers.add(new Lecturer(input.nextLine(), input.nextLine(), input.nextLine()));		
	}

	private void genericChange(int choice) {
		switch (choice) {
		case 0 : 	changeCourses();
						break;
		case 1 : 	changeGroups();
						break;
		case 2 : 	changeStudents();
						break;
		case 3 : 	changeLecturers();
						break;
		default :	showErrorMessage(4);
						break;	
		}

		
	}

	private void changeCourses() {
		// TODO Auto-generated method stub
		
	}

	private void changeGroups() {
		// TODO Auto-generated method stub
		
	}

	private void changeStudents() {
		// TODO Auto-generated method stub
		
	}

	private void changeLecturers() {
		// TODO Auto-generated method stub
		
	}

	private void genericDelete(int choice) {
		switch (choice) {
		case 1 : 	deleteCourses();
						break;
		case 2 : 	deleteGroups();
						break;
		case 3 : 	deleteStudents();
						break;
		case 4 : 	deleteLecturers();
						break;
		default :	showErrorMessage(4);
						break;	
		}

		
	}
	
	private void deleteCourses() {
		printCourses();
		System.out.print("Enter number to delete a course: ");
		int userInput = input.nextInt();
		if (checkDeleteInputValid(userInput, courses.size())) {
			courses.remove(userInput);
		}
		
	}

	private void deleteGroups() {
		printGroups();
		System.out.print("Enter number to delete a group: ");
		int userInput = input.nextInt();
		if (checkDeleteInputValid(userInput, groups.size())) {
			groups.remove(userInput);
		}
		
	}

	private void deleteStudents() {
		printStudents();
		System.out.print("Enter number to delete a student: ");
		int userInput = input.nextInt();
		if (checkDeleteInputValid(userInput, students.size())) {
			students.remove(userInput);
		}
		
	}

	private void deleteLecturers() {
		printLecturers();
		System.out.print("Enter number to delete a lecturer: ");
		int userInput = input.nextInt();
		if (checkDeleteInputValid(userInput, lecturers.size())) {
			lecturers.remove(userInput);
		}
	}
	
	private boolean checkDeleteInputValid(int userInput, int size) {
		return userInput < size;
	}

	public void mainMenu() {
		System.out.print("===== Edunova CRUD =====\n");
		for(int i = 0; i < mainMenuChoices.length; i++) {
			System.out.printf("%d - %s\n", i + 1, mainMenuChoices[i]);
		}
	}

	public static void main(String[] args) {
		new Start();
	}
	
}
