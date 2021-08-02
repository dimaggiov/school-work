/*
 * Author: Vinny DiMaggio
 * Date: 7/19/2020
 * File: SynchronizeThreads.java
 * Description: This program creates 1000 threads to add 1 to the Integer sum
 * to demonstrate multithreading and synchronization. It does this 20 times, 10 times without synchronization
 * and 10 time with synchronization
 */
package syncronizethreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizeThreads {
	
	//Integer to hold sum value
	private static Integer sum = 0;
	
	public static void main(String[] args) {
		
		//run synchronized and nonsynchronized version 10 times
		for(int i = 0; i < 20; i++) {
		//executor to manage threads
		ExecutorService executor = Executors.newCachedThreadPool();
			
			//run nonsynchronized 10 times
			if(i < 10) {
				for(int j = 0; j < 1000; j++) {
					executor.execute(new NonSynchronizedAdder());
				}
			}
			//run synchronized 10 times
			else {
				for(int j = 0; j < 1000; j++) {
					executor.execute(new SynchronizedAdder());
				}
			}
			
			executor.shutdown();
		
			//wait until all threads are done
			while(!executor.isTerminated()) {
			}
		
			//report results
			if(i < 10) {
				System.out.println("Not Synchronized " + (i + 1) + ": Sum = " + sum);
			}
			else {
				System.out.println("Synchronized " + (i + 1) + ": Sum = " + sum);
			}
			
			//reset sum for next run
			sum = 0;
		}
		
		System.out.println();
		
			
		
		
	}

	
	static class NonSynchronizedAdder implements Runnable{

		@Override
		public void run() {
			sum++;
		}
		
	}

	static class SynchronizedAdder implements Runnable{

		@Override
		public void run() {
			synchronized (sum) {
				sum++;
			}
		}
		
	}
}


	
