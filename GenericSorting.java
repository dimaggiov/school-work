/*
 * Author: Vinny DiMaggio
 * File: GenericSorting.java
 * Date: 6/30/2020
 * Description: This program creates 2 random arrays of dates and integers
 * the program then sorts them in two different ways displaying the array
 * before and after each sort. 
 * 
 * This program also creates 2 Comparator classes for one of the sorting methods,
 * this comparator classes sort the data in descending order rather than ascending.
 */

package genericsorting;

import java.util.Comparator;
import java.util.Date;

public class GenericSorting {

	public static void main(String[] args) {
		
		//create 2 comparators for the comparator version
		Comparator<Date> dateComparator = new DateComparator();
		Comparator<Integer> integerComparator = new IntegerComparator();
		
		//create 2 copies of the same array of dates to sort
		Date[] dates = new Date[5];
		Date[] datesCopy;
		
		//generate 5 random dates
		for(int i = 0; i < 5; i++) {
			//generate a random number between 0 and the current time and assign it to its Date value
			//resulting in a random date between Jan 1 1970 00:00 and the current time
			Date temp = new Date((long) (Math.random() * System.currentTimeMillis()));
			dates[i] = temp;
		}
		datesCopy = dates.clone();
		
		//print dates before sorting
		System.out.println("Dates before sorting: ");
		for(Date e : dates)
			System.out.println(e.toString() + " ");
		System.out.println();
		
		//sort using comparable
		bubbleSort(dates);
		
		//print dates after comparable sort
		System.out.println("Dates after comparable sort: ");
		for(Date e : dates)
			System.out.println(e.toString() + " ");
		System.out.println();
		
		//sort using comparator
		bubbleSort(datesCopy, dateComparator);
		
		//print dates after comparator sort
		System.out.println("Dates after comparator sort: ");
		for(Date e : datesCopy)
			System.out.println(e.toString() + " ");
		System.out.println();
			
			
		//create 2 copies of the same array of integers to sort
		Integer[] numbers = new Integer[5];
		Integer[] numbersCopy;
		
		//generate 5 random integers 0-100
		for(int i = 0; i < 5; i++) 
			numbers[i] = new Integer((int)(Math.random() * 100));
		numbersCopy = numbers.clone();
			
		//print numbers before sorting
		System.out.println("Integers before sorting: ");
		for(Integer e : numbers)
			System.out.print(e.toString() + " ");
		System.out.println();
				
		//sort using comparable
		bubbleSort(numbers);
				
		//print numbers afte comparable sort
		System.out.println("Integers after comparable sort: ");
		for(Integer e : numbers)
			System.out.print(e.toString() + " ");
		System.out.println();
		
		//sort using comparator
		bubbleSort(numbersCopy, integerComparator);
				
		//print numbers after comparator sort
		System.out.println("Integers after comparator sort: ");
		for(Integer e : numbersCopy)
			System.out.print(e.toString() + " ");
		System.out.println();
		
	}
	
	
	//Sort using the comparable interface
	public static <E extends Comparable<E>> void bubbleSort(E[] list) {
		
        for (int i = 0; i < list.length -1; i++) 
            for (int j = 0; j < list.length-i-1; j++) 
            	//if the second item is more than the first item
                if (list[j].compareTo(list[j+1]) > 0) 
                { 
                	//swap the object at j with the object at j+1
                	E temp = list[j]; 
                    list[j] = list[j+1]; 
                    list[j+1] = temp; 
                } 
	}
	
	
	//Sort using a comparator
	public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
		
		for (int i = 0; i < list.length -1; i++) 
            for (int j = 0; j < list.length-i-1; j++) 
            	//if the second item is more than the first item
                if (comparator.compare(list[j], list[j+1]) > 0) 
                { 
                    //swap the object at j with the object at j+1
                	E temp = list[j]; 
                    list[j] = list[j+1]; 
                    list[j+1] = temp; 
                } 
		
	}

	
	//create a comparator class for the Date class
	static class DateComparator implements Comparator<Date>{
		
		//sort the dates in descending order
		@Override
		public int compare(Date o1, Date o2) {

			if(o1.getTime() - o2.getTime() > 0)
				return -1;
			
			if(o1.getTime() - o2.getTime() < 0)
				return 1;
			
			return 0;
		}	
	}
	
	
	//create a comparator class for the Integer class
	static class IntegerComparator implements Comparator<Integer>{

		//sort the integers in descending order
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
		
	}
	
	
}
