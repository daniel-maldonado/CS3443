package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lab3 {

	public static void main(String[] args) {
		File myFile = getFile();
		Scanner myScanner = getScanner(myFile);
		
		processFile(myScanner);
		
		myScanner.close();
	}
	
	/**
	 * processFile uses the Scanner object that was passed as a parameter and proceeds to process
	 * the text file and add the students and their respective grades to the GradeBook.
	 * 
	 * @param myScanner a Scanner object that is not null.
	 */
	public static void processFile(Scanner myScanner) {
		Date date1 = null;
		Date date2 = null;
		StringTokenizer dateToken;
		String currentLine;
		String month = "";
		String day = "";
		String year = "";
		
		if (myScanner == null) {
			System.err.println("Scanner object cannot be null.");
			System.exit(1);
		}
		
		while (myScanner.hasNextLine()) {
			currentLine = myScanner.nextLine();
			
			dateToken = new StringTokenizer(currentLine);
			
			month = dateToken.nextToken();
			month = month.replaceAll("([A-Za-z]+).*","$1");
			
			day = dateToken.nextToken();
			day = day.replaceAll("([0-9]+),","$1");
			
			year = dateToken.nextToken();
			
			if (date1 == null) {
				date1 = new Date(month, day, year);
			} else if (date2 == null && date1 != null) {
				date2 = new Date(month, day, year);
			}
			
			if (date1 != null && date2 != null) {
				if (date1.isValid()) {
					System.out.println(date1);
				} else {
					System.out.println("Invalid Date");
				}
				
				if (date2.isValid()) {
					System.out.println(date2);
				} else {
					System.out.println("Invalid Date");
				}
				
				if (date1.isValid() && date2.isValid()) {
					System.out.println("Date Range: TODO");
				}
				
				date1 = date2 = null;
			}
		}
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
		return new File("dates.txt");	
	}

}
