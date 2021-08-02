/*
 * Author: Vinny DiMaggio
 * File: DataAnalysis.java
 * Date: 9/6/2020
 * Description: This program reads integer numbers from a text file called hw3_datafile.
 * The program then stores all values in an ArrayList and calculates the min, max, sum, and average
 * of the numbers read.
 * 
 * After computing all values the the program sorts the ArrayList and writes the min, max, sum, average,
 * the number of values, and the values themselves in ascending order to the a text file called dataAnalysis.
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class DataAnalysis {
	
	public static void main(String[] args) {
		
		//Create Scanner to read from file
		Scanner inputFile = null; 
		try {
			
			inputFile = new Scanner(new File("hw3_datafile.txt"));
		
		}catch(Exception e) {
			System.out.println("Error opening input file");
			System.exit(0);
		}
		
		//Create ArrayList to hold all values read from file
		ArrayList<Integer> valuesFromFile = new ArrayList<Integer>()
				;		
		//Variables to hold min, max, sum, and the average 
		int min;
		int max;
		int sum = 0; 
		double average = 0; 
		
		
		//give min and max the value of the first item in file for future comparisons
		valuesFromFile.add(inputFile.nextInt());
		min = valuesFromFile.get(0);
		max = valuesFromFile.get(0);
	
		
		//read through file
		while(inputFile.hasNextInt()) {
			
			//add new value to values
			int nextValue = inputFile.nextInt();
			valuesFromFile.add(nextValue);
			
			//determine if new number is the new min or new max
			if(nextValue < min)
				min = nextValue;
			else if(nextValue > max)
				max = nextValue;
			
			//add value to the sum
			sum += nextValue;
			
		}
		
		//calculate the average value to 2 decimals
		average = ((int)(sum / (double)valuesFromFile.size()) * 100) /100.0 ;
		
		//sort list of values using Arraylist's sort
		valuesFromFile.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		//create Print writer to write to the output file
		PrintWriter output = null; 
		try {
			output = new PrintWriter(new File("dataAnalysis.txt"));
		
		} catch(Exception e) {
			System.out.println("Error opening output file");
			System.exit(0);
		}
		
		//Print min, max, average, sum, and number of values read to the output file
		output.println("There were " + valuesFromFile.size() + " values read from the input file");
		output.println("The largest value in the data set was: " + max);
		output.println("The smallest value in the data set was: " + min);
		output.println("The sum of the values in the data set was: " + sum);
		output.println("The average of the data set was: " + average);
		output.println("List of values read in ascending order: ");
		
		//print all values read to file in ascending order
		//10 values per line
		for(int i = 1; i < valuesFromFile.size() + 1; i++) {
			output.print(valuesFromFile.get(i - 1) + " ");
			if(i % 10 == 0)
				output.println();
		}
		output.close();
		
		
		
	}

}
