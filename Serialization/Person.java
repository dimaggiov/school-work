/*
 * Author: Vinny DiMaggio
 * Date: 11/10/2020
 * File: Person.java
 * Description: This class creates a very basic Person object used to 
 * demonstrate the Serializable interface.
 */
import java.io.Serializable;

public class Person implements Serializable {
	String name;
	String phoneNumber;
	String dateOfBirth;
	String email;
	

	public Person(String name, String phoneNumber, String dateOfBirth, String email ) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth + ", email="
				+ email + "]";
	}
	
	

}
