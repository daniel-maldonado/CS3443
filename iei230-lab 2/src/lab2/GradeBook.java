/**
 * @author Daniel G Maldonado
 */

package lab2;

import java.util.ArrayList;
/**
 * GradeBook is a singleton. This means the GradeBook object that is only instantiated once.
 */
public class GradeBook {
	private static final GradeBook instance;
	private static ArrayList<Student> gradeBook;
	
	static {
		try {
			instance = new GradeBook();
		} catch (Exception e) {
			throw new RuntimeException("Problem creating GradeBook Singleton,", e);
		}
	}
	
	/**
	 * @return This method returns the instance of the GradeBook.
	 */
	public static GradeBook getGradeBook() {
		return instance;
	}
	
	/**
	 * A private constructor to make sure that only one instance is created.
	 */
	private GradeBook() {
		gradeBook = new ArrayList<Student>();
	}
	
	/**
	 * addStudent will add a non-null Student object to the GradeBook.
	 * 
	 * @param newStudent This method takes a parameter of type Student (non-null).
	 */
	public static void addStudent(Student newStudent) {
		if (newStudent != null) {
			gradeBook.add(newStudent);
		}
	}
	
	/**
	 * printGradeBook takes no parameters and prints the non-empty GradeBook in the desired format.
	 */
	public static void printGradeBook() {
		if (gradeBook.isEmpty()) {
			System.out.println("The grade book is currently empty.");
		} 
		for (Student currentStudent: gradeBook) {
			System.out.print(currentStudent.getName() + " ");
			System.out.println(currentStudent.getGrades());
			
			System.out.println("\tName:\t " + currentStudent.getName());
			System.out.println("\tLength:  " + currentStudent.getNumberOfGrades());
			System.out.format("\tAverage: " + "%.2f%n",currentStudent.getAverage());
			System.out.println("\tMedian:  " + currentStudent.getMedian());
			System.out.println("\tMaximum: " + currentStudent.getMaximum());
			System.out.println("\tMinimum: " + currentStudent.getMinimum());
			
		}
	}
}
