/*
 * Author: Vinny DiMaggio
 * Date: 6/30/2020
 * File: GenericQueueTester.java
 * Description: This program tests the GenericQueue class by adding names to a queue using
 * the enqueue method and dequeueing names using the dequeue method.
 */

package genericqueue;

public class GenericQueueTester {

	public static void main(String[] args) {
		
		//queue to hold the patients names
		GenericQueue<String> patients = new GenericQueue<String>();
		
		//add patients to queue
		patients.enqueue("Tom");
		patients.enqueue("George");
		patients.enqueue("Peter");
		patients.enqueue("Jean");
		patients.enqueue("Jane");
		patients.enqueue("Michael");
		patients.enqueue("Michelle");
		patients.enqueue("Daniel");
		
		
		//dequeue patients and print message.
		int size = patients.getSize();
		for(int i = 0; i < size; i++)
			System.out.println(patients.dequeue() + " the doctor will see you now.");
		
	}

}
