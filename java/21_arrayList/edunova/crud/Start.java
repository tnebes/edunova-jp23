/*
 * Aplikacija koja traži izbor i da se dobije broj
 * enter na broj
 * podizbornik
 * izlistati smjerove, dodati smjerove, promijeniti smjerove, obrisati smjer
 * vrati se 
 */

package edunova.crud;

import java.util.ArrayList;
import java.util.Scanner;

public class Start {
	String[] mainMenuChoices = {"Courses", "Groups", "Students", "Lecturers", "Exit"};
	String[] subMenuChoices = {"Show all", "Add", "Change", "Delete", "Return"};
	ArrayList<Courses> courses = new ArrayList<>();
	ArrayList<Groups> groups = new ArrayList<>();
	ArrayList<Students> students = new ArrayList<>();
	ArrayList<Lecturers> lecturers = new ArrayList<>();
	Scanner input = new Scanner(System.in);
	
	public Start() {
		mainMenu();
		System.out.print("\n\n");
		int userInput;
		do {
			userInput = input.nextInt();
			switch(userInput) {
			case 1 : 	showSubMenuGeneric(userInput - 1);
							break;
			case 2 :		showSubMenuGeneric(userInput - 1);
							break;
			case 3 :		showSubMenuGeneric(userInput - 1);
							break;
			case 4 :		showSubMenuGeneric(userInput - 1);
							break;
			default :	showErrorMessage(mainMenuChoices.length);
							break;			
			}
		} while (userInput != mainMenuChoices.length - 1);
	}

	private void showErrorMessage(int length) {
		System.out.printf("Error! Please select from 1 to %d\n", length);
		
	}

	private void showSubMenuGeneric(int choice) {
		System.out.print("\n\n");
		for (int i = 0; i < subMenuChoices.length; i++) {
			System.out.printf("%d - %s %s\n", i + 1, subMenuChoices[i], mainMenuChoices[choice]);
		}
		int userInput;
		do {
			userInput = input.nextInt();
			switch(userInput) {
			case 1 : 	genericShow(userInput - 1);
							break;
			case 2 :		genericAdd(userInput - 1);
							break;
			case 3 :		genericChange(userInput - 1);
							break;
			case 4 :		genericDelete(userInput - 1);
							break;
			default :	showErrorMessage(subMenuChoices.length);
							break;			
			}
		} while (userInput != subMenuChoices.length - 1);
				
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
		// TODO Auto-generated method stub
		
	}

	private void printGroups() {
		// TODO Auto-generated method stub
		
	}

	private void printStudents() {
		// TODO Auto-generated method stub
		
	}

	private void printLecturers() {
		// TODO Auto-generated method stub
		
	}

	private void genericAdd(int choice) {
		// TODO Auto-generated method stub
		
	}

	private void genericChange(int choice) {
		// TODO Auto-generated method stub
		
	}

	private void genericDelete(int choice) {
		// TODO Auto-generated method stub
		
	}
	
	public void mainMenu() {
		System.out.print("===== Edunova CRUD ======\n");
		for(int i = 0; i < mainMenuChoices.length; i++) {
			System.out.printf("%d - %s\n", i + 1, mainMenuChoices[i]);
		}
	}

	public static void main(String[] args) {
		new Start();
	}
	
}
