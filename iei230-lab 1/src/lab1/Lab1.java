/**
 * @author Daniel G Maldonado
 */
package lab1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab1 {
	/**
	 * The main method of this class will use the method getFile() to get the File object used by getScanner(myFile) in order create
	 * a Scanner 'myScanner' after these are created processFile() is called using myScanner as the parameter and the results are 
	 * printed to standard out. After the file is processed the scanner is closed.
	 * 
	 */
	public static void main(String[] args) {
		File myFile = getFile();
		Scanner myScanner = getScanner(myFile);
		
		processFile(myScanner);
		
		myScanner.close();
	}
	
	/**
	 * Prints to standard out, in the following format, [count of numbers] [count of non-numbers] [total of the numbers]
	 * that exist in the file myScanner is associated with.
	 * 
	 * @param myScanner a Scanner object that is not null.
	 */
	public static void processFile(Scanner myScanner) {
		int numbers = 0; 
		int nonNumbers = 0;
		double numberTotal = 0.0;
		
		if (myScanner == null) {
			System.err.println("Scanner object cannot be null.");
			System.exit(1);
		}
		
		while (myScanner.hasNext()) {
			String currentToken = myScanner.next();
			
			if (isNumeric(currentToken)) {
				numbers++;
				numberTotal += Double.parseDouble(currentToken);
			} else {
				nonNumbers++;
			}
		}
		
		System.out.format(numbers + " " + nonNumbers + " " + "%.2f%n\n", numberTotal);
	}
	
	/**
	 * Compares string to a pattern to determine if the string is a number and returns a boolean value of true or false based on the comparison.
	 * 
	 * @param string a non-null String object.
	 * @return Returns a boolean, true if the string given is representative of a number and false if it does not.
	 */
	public static boolean isNumeric(String string) {
	  return string.matches("-?\\d+(\\.\\d+)?");
	}
	
	/**
	 * Uses the file given in the parameter 'myFile' and returns an appropriate Scanner object associated with said file. 
	 * 
	 * @param myFile is a non null File object
	 * @return Returns a Scanner object unless the file is not found.
	 */
	public static Scanner getScanner(File myFile) {
		try {
			return new Scanner(myFile);
		} catch (FileNotFoundException e) {
			System.err.println("Failed to open file: " + myFile.toString());
			System.exit(1);
		}
		return null;
	}
	/**
	 * Uses "data.txt" to create a File object and returns said object.
	 * 
	 * @return Returns a File object that is associated with "data.txt"
	 */
	public static File getFile() {
		return new File("data.txt");	
	}
	
}
