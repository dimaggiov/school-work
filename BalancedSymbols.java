/*
 * Author: Vinny DiMaggio
 * Date: 6/20/2020
 * File: BallancedSymbols.java
 * Description: This program reads from a java or other text file as passed by 
 * the command line and checks the file for valid matching pairs of () [] and {}
 * if there is an error the line number the error is found on is reported.
 */

package blanacedsymbols;


import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class BalancedSymbols {

	public static void main(String[] args) {
		
		try {
			//open an input file stream from the first argument
			Scanner inputFile = new Scanner(new File(args[0]));
			
			//create a stack to hold the symbols
			Stack<Character> symbols = new Stack<Character>();
			
			//flag to stop looping when an error is found
			boolean errorFound = false;
			
			//current line being parsed
			int currentLineNumber = 0;
			
			//line the error occurs on
			int errorLineNumber = -1;
			
			
			//iterate through file while there are still lines to look at
			//and no error has been found
			while(inputFile.hasNext() && !errorFound){
				
				//increment line number
				currentLineNumber++;	
				
				// read the next a line in the file
				String nextLine = inputFile.nextLine();
				
				//iterate through the string and find the symbols while there are
				//still characters and no error has been found
				for(int i = 0; i < nextLine.length() &&!errorFound; i++) {
					switch (nextLine.charAt(i)) {
					//if it is an opening symbol push it on the stack
					case '(':
					case '{':
					case '[':
						symbols.push(nextLine.charAt(i));
						break;
						
					//if it is a closing symbol and it matches the previous opening symbol pop it,
					//otherwise record the line the error happens on and set the error flag to true
					case ')':
						if(symbols.isEmpty() || symbols.peek() != '(')
						{
							errorLineNumber = currentLineNumber;
							errorFound = true;
						}
						else
							symbols.pop();
						break;
						
					case '}':
						if(symbols.isEmpty() || symbols.peek() != '{')
						{
							errorLineNumber = currentLineNumber;
							errorFound = true;
						}
						else
							symbols.pop();
						break;
						
					case ']':
						if(symbols.isEmpty() || symbols.peek() != '[')
						{
							errorLineNumber = currentLineNumber;
							errorFound = true;
						}
						else
							symbols.pop();
						break;
					}
					
					
				}
			}
			
			//an error was found in the middle of the program
			if(errorFound) {
				System.out.println("There was no matching symbol on line: " + errorLineNumber);
			}
			
			//if the there is still a symbol left there was an error at the end of the program
			else if(!symbols.isEmpty()) 
				System.out.println("There was no matching symbol on line: " + currentLineNumber);
			
			//there were no errors
			else 
				System.out.println("Every symbol had a match in this file.");
		
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("There was an error opening or reading from the file");
			e.printStackTrace();
		}
			
		
	}

}
