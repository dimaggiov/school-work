/*
 * Author: Vinny DiMaggio
 * Date: 6/30/2020
 * File: GenericQueue.java
 * Description: This class creates a GenericQueue by extending
 * the linked list class and adding methods that are needed for a queue.
 */
package genericqueue;

import java.util.LinkedList;

public class GenericQueue<E> extends LinkedList<E> {

	//enqueue adds the item to the end of the list
	public void enqueue(E e) {
		super.addLast(e);
	}
	
	//dequeue removes the first item, the oldest in the queue
	public E dequeue() {
		return super.removeFirst();
	}
	
	//returns the number of elements in the queue
	public int getSize() {
		return super.size();
	}

}
