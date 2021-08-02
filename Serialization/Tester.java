/*
 * Author: Vinny DiMaggio
 * Date: 11/10/2020
 * File: Tester.java
 * Description: This menu based program creates and serializes Person objects and
 * deserializes and displays the people objects when the corresponding menu option 
 * is selected. 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Tester {

	public static void main(String[] args) {
		
		//Scanner for user input
		Scanner input = new Scanner(System.in);
		int selection = 0;

		while(selection != 3) {

			//display menu
			System.out.println("-----Menu-----");
			System.out.println("1: Add information");
			System.out.println("2: Display information");
			System.out.println("3: Exit");
			selection = input.nextInt();

			switch (selection) {

			//add a new person
			case 1:
				System.out.print("Enter full name: ");
				input.nextLine();
				String name = input.nextLine();

				System.out.print("Enter phone number: ");
				String phoneNumber = input.nextLine();

				System.out.print("Enter date of birth: ");
				String dateOfBirth = input.nextLine();

				System.out.print("Enter email address: ");
				String email = input.nextLine();
				
				
				try {
					ArrayList<Person> peopleList;
					
					//try to read the old peopleList from the serialized file
					try {
					ObjectInputStream OIStream = new ObjectInputStream(new FileInputStream("People.bin"));
					peopleList = (ArrayList<Person>)OIStream.readObject();
					
					} catch(Exception e) {
						System.out.println("No File found, Starting with a blank file");
						peopleList = new ArrayList<>();
					}
					
					//Add new person to arraylist and write object to file.
					peopleList.add(new Person(name, phoneNumber, dateOfBirth, email));
					
					ObjectOutputStream OOStream = new ObjectOutputStream(new FileOutputStream("People.bin"));
					OOStream.writeObject(peopleList);
					
					System.out.println("Person sucessfully added");
					
					
				} catch (Exception e) {
					System.out.println("Error adding person to file");
				}
				
				break;

			//retrieve information and display
			case 2:
				//read the arraylist and print the people objects
				try {
					
				ObjectInputStream OIStream = new ObjectInputStream(new FileInputStream("People.bin"));
				ArrayList<Person> peopleList = (ArrayList<Person>)OIStream.readObject();
				
				for (Person person : peopleList) {
					System.out.println(person);
				}
				
				}catch (Exception e) {
					System.out.println("Could not open file");
				}
				
				
				break;

			case 3:
				//do nothing for exit condition
				break;
			default:
				System.out.println("Invalid selection");
				break;
			}

		}		

	}

}
