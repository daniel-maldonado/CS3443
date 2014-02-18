/**
 * @author Daniel G Maldonado
 */
package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab2 {
	private static final GradeBook gradeBook = GradeBook.getGradeBook();

	public static void main(String[] args) {
		File myFile = getFile();
		Scanner myScanner = getScanner(myFile);
		
		processFile(myScanner);
		gradeBook.printGradeBook();
		
		myScanner.close();
	}

	/**
	 * processFile uses the Scanner object that was passed as a parameter and proceeds to process
	 * the text file and add the students and their respective grades to the GradeBook.
	 * 
	 * @param myScanner a Scanner object that is not null.
	 */
	public static void processFile(Scanner myScanner) {
		ArrayList<Integer> grades = new ArrayList<Integer>();
		String newName = "";
		String previousName = "";
		
		if (myScanner == null) {
			System.err.println("Scanner object cannot be null.");
			System.exit(1);
		}
		
		while (myScanner.hasNext()) {
			String currentToken = myScanner.next();
			
			if (!isNumeric(currentToken)) {
				previousName = newName;
				newName = currentToken;
				if (!grades.isEmpty()){
					Student newStudent = new Student.StudentBuilder(previousName, grades).buildStudent();
					gradeBook.addStudent(newStudent);
					
					grades = new ArrayList<Integer>();
				}
			} else {
				grades.add(Integer.parseInt(currentToken));
			}
		}
		
		if (!grades.isEmpty()) {
			Student newStudent = new Student.StudentBuilder(newName, grades).buildStudent();
			gradeBook.addStudent(newStudent);
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
		return new File("data.txt");	
	}
	
}
